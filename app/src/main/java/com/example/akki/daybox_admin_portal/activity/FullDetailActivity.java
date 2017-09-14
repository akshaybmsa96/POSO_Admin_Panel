package com.example.akki.daybox_admin_portal.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.akki.daybox_admin_portal.adapter.CustomPurchasedItemAdapter;
import com.example.akki.daybox_admin_portal.network.ConfirmOrder;
import com.example.akki.daybox_admin_portal.network.FetchOrderDetails;
import com.example.akki.daybox_admin_portal.network.ResendMessage;
import com.example.akki.daybox_admin_portal.pojo.orderdetail.OrderDetailDTO;
import com.example.akki.daybox_admin_portal.pojo.orderslist.OrdersDTO;
import com.example.akki.daybox_admin_portal.ui.listview.NonScrollListView;
import com.example.akki.daybox_admin_portal.R;
import com.example.akki.daybox_admin_portal.util.StringUtility;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FullDetailActivity extends AppCompatActivity {

    @Bind(R.id.textViewSupplier) TextView textViewSupplier;
    @Bind(R.id.textViewBuyer)TextView textViewBuyer;
 //   @Bind(R.id.prioritytextview)TextView p;
    @Bind(R.id.textViewAmount)TextView textViewAmount;
    @Bind(R.id.textViewODate)TextView textViewODate;
    @Bind(R.id.textViewDDate)TextView textViewDDate;
    @Bind(R.id.textViewSubAmount)TextView textViewSubAmount;
    @Bind(R.id.textViewTaxAmount)TextView textViewTaxAmount;
    @Bind(R.id.toolbar) Toolbar tb;
    @Bind(R.id.buttonCancelOrder)
    Button buttonCancelOrder;
    @Bind(R.id.buttonConfirmOrder)
    Button buttonConfirmOrder;
    @Bind(R.id.textViewDeliveryCharge)
    TextView textViewDeliveryCharge;



    OrdersDTO orderdetail;
    CustomPurchasedItemAdapter ca;
    String orderIntent,supplier;

    OrderDetailDTO orderDetails=new OrderDetailDTO();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_detail);
        ButterKnife.bind(this);
        NonScrollListView listView=(NonScrollListView) findViewById(R.id.listView);

         orderIntent =getIntent().getStringExtra("orderDetails");
         initialize();

        FetchOrderDetails fetchOrderDetails=new FetchOrderDetails(this,this,orderDetails,listView,String.valueOf(orderdetail.getId()));
        fetchOrderDetails.fetch();

        setSupportActionBar(tb);
        getSupportActionBar().setTitle("Full description");
        tb.setTitleTextColor(getResources().getColor(R.color.white));
        tb.setNavigationIcon(R.mipmap.ic_back);
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

      //  Toast.makeText(this,""+orderdetail.getContract().getBuyer().getShow_name()+"",Toast.LENGTH_LONG).show();

        supplier=orderdetail.getContract().getSeller().getShow_name();
        supplier="<u>"+supplier+"</u>";


        SpannableString content = new SpannableString("By: "+orderdetail.getContract().getBuyer().getShow_name());
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);


        textViewBuyer.setText(content);
        textViewSupplier.setText(Html.fromHtml(supplier));
     //   p.setText("Priority           : " +priority);
        textViewAmount.setText("₹ "+ orderdetail.getFinal_amount());
        textViewODate.setText("Ordered On : " + StringUtility.getSimpleDate(orderdetail.getCreated_at()));
        textViewDDate.setText(StringUtility.getSimpleDate(orderdetail.getDelivery_date()));
        textViewSubAmount.setText("₹ "+orderdetail.getSub_total());
        textViewTaxAmount.setText("₹ "+orderdetail.getTax_amount());
        textViewDeliveryCharge.setText("₹ "+orderdetail.getExtra_charge_amount());

        textViewSupplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + orderdetail.getContract().getSeller().getSales_person().getMobile()));
                if (ActivityCompat.checkSelfPermission(FullDetailActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.

                    Toast.makeText(FullDetailActivity.this,"permission denied , check Setting",Toast.LENGTH_LONG).show();


                }

                else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(FullDetailActivity.this);
                    builder.setTitle("CALL SELLER ?");
                    builder.setMessage(orderdetail.getContract().getSeller().getShow_name());
                    builder.setPositiveButton("Call", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            startActivity(intent);
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    builder.show();
                }



            }
        });

        textViewBuyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + orderdetail.getContract().getBuyer().getSales_person().getMobile()));
                        if (ActivityCompat.checkSelfPermission(FullDetailActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            // TODO: Consider calling
                            //    ActivityCompat#requestPermissions
                            // here to request the missing permissions, and then overriding
                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                            //                                          int[] grantResults)
                            // to handle the case where the user grants the permission. See the documentation
                            // for ActivityCompat#requestPermissions for more details.

                            Toast.makeText(FullDetailActivity.this,"permission denied , check Setting",Toast.LENGTH_LONG).show();


                        }

                        else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(FullDetailActivity.this);
                            builder.setTitle("CALL BUYER ?");
                            builder.setMessage(orderdetail.getContract().getBuyer().getShow_name());
                            builder.setPositiveButton("Call", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    startActivity(intent);
                                }
                            });
                            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                            builder.show();
                        }



            }
        });

        buttonCancelOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(FullDetailActivity.this);
                builder.setTitle("CANCEL ORDER");
                builder.setMessage("Are You Sure ?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();

            }
        });



        buttonConfirmOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(FullDetailActivity.this);
                builder.setTitle("CONFIRM ORDER");
                builder.setMessage("Are You Sure ?");
                builder.setPositiveButton("CONFIRM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        ConfirmOrder co=new ConfirmOrder(FullDetailActivity.this,String.valueOf(orderdetail.getId()));
                        co.confirm();

                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();

            }
        });

    }

    private void initialize() {

        JsonElement jsonElement=new JsonParser().parse(orderIntent);
        GsonBuilder gsonBuilder=new GsonBuilder();
        Gson gson=gsonBuilder.create();
        orderdetail=(gson.fromJson(jsonElement,OrdersDTO.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar_menu_fulldes, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id==R.id.callblock)
        {

        }

        else if(id==R.id.resend)
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(FullDetailActivity.this);
            builder.setTitle("RESEND MESSAGE TO SELLER ?");
            builder.setMessage(orderdetail.getContract().getSeller().getShow_name());
            builder.setPositiveButton("SEND", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    ResendMessage rm=new ResendMessage(FullDetailActivity.this,String.valueOf(orderdetail.getId()),FullDetailActivity.this);
                    rm.send();

                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.show();




        }


        return super.onOptionsItemSelected(item);
    }
}
