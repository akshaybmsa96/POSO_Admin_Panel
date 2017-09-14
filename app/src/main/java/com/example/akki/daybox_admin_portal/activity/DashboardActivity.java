package com.example.akki.daybox_admin_portal.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.example.akki.daybox_admin_portal.R;
import com.example.akki.daybox_admin_portal.adapter.CustomOrdersAdapter;
import com.example.akki.daybox_admin_portal.fragment.DashboardFragment;
import com.example.akki.daybox_admin_portal.fragment.UnitsFragment;
import com.example.akki.daybox_admin_portal.network.FetchOrders;
import com.example.akki.daybox_admin_portal.pojo.orderslist.OrdersDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DashboardActivity extends AppCompatActivity {
    @Bind(R.id.toolbar) Toolbar tb;

    CustomOrdersAdapter ca;
    ArrayList<OrdersDTO> orderslist=new ArrayList<OrdersDTO>();
    ActionBarDrawerToggle toggle;
    MenuItem prevItem;
    DrawerLayout drawer;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);

        ca=new CustomOrdersAdapter(this,this,orderslist);


        setSupportActionBar(tb);
        tb.setTitleTextColor(getResources().getColor(R.color.white));


        NavigationView navigationView = (NavigationView) findViewById(R.id.navigator);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                if (prevItem != null)
                    prevItem.setChecked(false);

                item.setCheckable(true);
                item.setChecked(true);

                prevItem = item;


                switch (item.getItemId()) {

                    case R.id.dashboard:


                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.home_layout_id, new DashboardFragment(ca,orderslist));
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Unconfirmed Orders");
                        drawer.closeDrawers();

                        break;

                    case R.id.unit:

                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.home_layout_id, new UnitsFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Units");
                        drawer.closeDrawers();



                        break;


                }
                return false;


            }

        });

        MenuItem item = navigationView.getMenu().findItem(R.id.dashboard);
        item.setCheckable(true);
        item.setChecked(true);
        prevItem=item;
        fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.home_layout_id, new DashboardFragment(ca,orderslist));
        fragmentTransaction.commit();
        toggle = new ActionBarDrawerToggle(
                this, drawer,tb,R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.setDrawerListener(toggle);
        toggle.syncState();

        drawer.closeDrawers();




        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CALL_PHONE)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user'textViewBuyer response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CALL_PHONE},
                        101);


            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar_menu_home, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id==R.id.menuSortDeliveryDate)
        {
            Collections.sort(orderslist, new Comparator<OrdersDTO>() {
                @Override
                public int compare(OrdersDTO lhs, OrdersDTO rhs) {
                    return lhs.getDelivery_date().compareTo(rhs.getDelivery_date());
                }
            });
            ca.notifyDataSetChanged();

        }

        else if(id==R.id.menuSortOrderDate)
        {
            Collections.sort(orderslist, new Comparator<OrdersDTO>() {
                @Override
                public int compare(OrdersDTO lhs, OrdersDTO rhs) {
                    return lhs.getCreated_at().compareTo(rhs.getCreated_at());
                }
            });
            ca.notifyDataSetChanged();
        }

        else if(id==R.id.menuSortAmount)
        {

            Collections.sort(orderslist, new Comparator<OrdersDTO>() {
                @Override
                public int compare(OrdersDTO lhs, OrdersDTO rhs) {
                    return lhs.getFinal_amount().compareTo(rhs.getFinal_amount());
                }
            });
            ca.notifyDataSetChanged();

        }

        else if(id==R.id.menuAllOrders)
        {
            Intent intent=new Intent(DashboardActivity.this,AllOrdersActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

}
