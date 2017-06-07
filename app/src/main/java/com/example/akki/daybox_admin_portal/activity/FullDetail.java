package com.example.akki.daybox_admin_portal.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.akki.daybox_admin_portal.adapter.CustomPurchasedItemAdapter;
import com.example.akki.daybox_admin_portal.ui.listview.NonScrollListView;
import com.example.akki.daybox_admin_portal.R;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FullDetail extends AppCompatActivity {

    @Bind(R.id.tname) TextView b;
    @Bind(R.id.suppliertextviewid)TextView s;
 //   @Bind(R.id.prioritytextview)TextView p;
    @Bind(R.id.amounttextview)TextView a;
    @Bind(R.id.orderdatetextviewid)TextView od;
    @Bind(R.id.deliverydatetextviewid)TextView dd;
    @Bind(R.id.subtotaltextviewid)TextView st;
    @Bind(R.id.taxamounttextviewid)TextView ta;
    @Bind(R.id.toolbar) Toolbar tb;

    ArrayList<String> piname=new ArrayList<String>();
    ArrayList<String> piqty=new ArrayList<String>();
    ArrayList<String> pirate=new ArrayList<String>();
    ArrayList<String> piamount=new ArrayList<String>();
    CustomPurchasedItemAdapter ca;
    String buyer,amount,supplier,odate,ddate,priority,subtotal,taxamount,bphone,sphone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_detail);
        ButterKnife.bind(this);
        NonScrollListView listView=(NonScrollListView) findViewById(R.id.listviewid);



        piname.addAll(Arrays.asList("Butter Yellow","Curd","Egg","Fresh Cream"));
        piqty.addAll(Arrays.asList("0.5 kg","5.0 kg","1.0 Tray","2.0 Pkt"));
        pirate.addAll(Arrays.asList("420.0/Kg","48.0 Kg","150.0/Tray","185.0/Pkt"));
        piamount.addAll(Arrays.asList("₹ 210.0","₹ 210.0","₹ 150.0","₹ 370.0"));


        ca=new CustomPurchasedItemAdapter(this,this,piname,piqty,pirate,piamount);


        setSupportActionBar(tb);
        getSupportActionBar().setTitle("Full description");
        tb.setTitleTextColor(0XFFFFFFFF);
        tb.setNavigationIcon(R.mipmap.icon_backbutton);
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buyer=getIntent().getStringExtra("buyer");
        supplier=getIntent().getStringExtra("Supplier");
        priority=getIntent().getStringExtra("priority");
        amount=getIntent().getStringExtra("amount");
        odate=getIntent().getStringExtra("odate");
        ddate=getIntent().getStringExtra("ddate");
        subtotal=getIntent().getStringExtra("subtotal");
        taxamount=getIntent().getStringExtra("taxamount");
        bphone=getIntent().getStringExtra("bphone");

        listView.setAdapter(ca);
        buyer="<u>"+buyer+"</u>";

        b.setText(Html.fromHtml(buyer));
        s.setText("From : "+supplier);
     //   p.setText("Priority           : " +priority);
        a.setText("₹ "+amount);
        od.setText("Ordered On : " + odate);
        dd.setText(ddate);
        st.setText("₹ "+subtotal);
        ta.setText(taxamount);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + bphone));
                    if (ActivityCompat.checkSelfPermission(FullDetail.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.

                        Toast.makeText(FullDetail.this,"permission denied , check Setting",Toast.LENGTH_LONG).show();


                    }
                else {
                        startActivity(intent);
                    }
            }
        });

        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(FullDetail.this,"I Will Call Supplier",Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar_menu_fulldes, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }
}
