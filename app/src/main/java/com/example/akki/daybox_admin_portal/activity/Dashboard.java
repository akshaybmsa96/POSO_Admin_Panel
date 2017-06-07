package com.example.akki.daybox_admin_portal.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.akki.daybox_admin_portal.R;
import com.example.akki.daybox_admin_portal.adapter.CustomOrdersAdapter;
import com.example.akki.daybox_admin_portal.network.FetchAllOrders;
import com.example.akki.daybox_admin_portal.pojo.OrdersDTO;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Dashboard extends AppCompatActivity {
    @Bind(R.id.recyclerviewid) RecyclerView r;
    @Bind(R.id.toolbar) Toolbar tb;

    CustomOrdersAdapter ca;
    FetchAllOrders fetchAllOrders;
    ArrayList<OrdersDTO> orderslist=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);

        setSupportActionBar(tb);
        getSupportActionBar().setTitle("Orders");
        tb.setTitleTextColor(0XFFFFFFFF);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CALL_PHONE)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CALL_PHONE},
                        101);


            }
        }

        ca=new CustomOrdersAdapter(this,this,orderslist);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        r.setLayoutManager(layoutManager);
        r.setHasFixedSize(true);
        fetchAllOrders =new FetchAllOrders(this,orderslist,ca,r);
        fetchAllOrders.fetch();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar_menu_home, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }

}
