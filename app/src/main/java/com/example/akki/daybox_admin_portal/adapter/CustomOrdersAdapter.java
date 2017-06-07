package com.example.akki.daybox_admin_portal.adapter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.akki.daybox_admin_portal.R;
import com.example.akki.daybox_admin_portal.activity.FullDetail;
import com.example.akki.daybox_admin_portal.pojo.OrdersDTO;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Akki on 04-06-2017.
 */

public class CustomOrdersAdapter extends RecyclerView.Adapter<CustomOrdersAdapter.ViewHolder> {

    private Context context;

    ArrayList<OrdersDTO> orderlist = new ArrayList<OrdersDTO>();
    Activity activity;

    public CustomOrdersAdapter(Context context, Activity activity, ArrayList<OrdersDTO> orderlist) {

        this.context = context;
        this.orderlist = orderlist;
        this.activity = activity;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.listviewlayout, parent, false);
        ViewHolder holder = new ViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tn.setText(orderlist.get(position).getContract().getBuyer().getShow_name());
        holder.am.setText("Amount : ₹ " + String.valueOf(orderlist.get(position).getFinal_amount()));
        holder.dd.setText(String.valueOf(orderlist.get(position).getDelivery_date()));
        holder.sn.setText("From : " + orderlist.get(position).getContract().getSeller().getShow_name());
        //Toast.makeText(context,name.get(position),Toast.LENGTH_SHORT).show();

    }

    @Override
    public int getItemCount() {

        return orderlist.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Bind(R.id.tname)
        TextView tn;
        @Bind(R.id.amounttextview)
        TextView am;
        @Bind(R.id.deliverydate)
        TextView dd;
        @Bind(R.id.dotimgid)
        ImageView im;
        @Bind(R.id.suppliertextviewid)
        TextView sn;
        PopupMenu popupMenu;


        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);


            view.setOnClickListener(this);
            im.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    popupMenu = new PopupMenu(context, view);
                    popupMenu.inflate(R.menu.list_menu);
                    popupMenu.show();

                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {

                            int mid = item.getItemId();
                            if (mid == R.id.call) {
                                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + String.valueOf(orderlist.get(getPosition()).getContract().getBuyer().getSales_person().getMobile())));
                                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                    // TODO: Consider calling
                                    //    ActivityCompat#requestPermissions
                                    // here to request the missing permissions, and then overriding
                                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                    //                                          int[] grantResults)
                                    // to handle the case where the user grants the permission. See the documentation
                                    // for ActivityCompat#requestPermissions for more details.
                                    Toast.makeText(context,"permission denied, check Setting",Toast.LENGTH_LONG).show();

                                }
                                else {
                                    context.startActivity(intent);
                                }
                            }


                            return false;
                        }
                    });

                }
            });


        }

        @Override
        public void onClick(View view) {

            Intent i=new Intent(context, FullDetail.class);
            i.putExtra("buyer",orderlist.get(getPosition()).getContract().getBuyer().getShow_name());
          //  i.putExtra("priority",priority.get(getPosition()));
            i.putExtra("Supplier",orderlist.get(getPosition()).getContract().getSeller().getShow_name());
            i.putExtra("amount",String .valueOf(orderlist.get(getPosition()).getFinal_amount()));
            i.putExtra("odate",String.valueOf(orderlist.get(getPosition()).getCreated_at()));
            i.putExtra("ddate",String.valueOf(orderlist.get(getPosition()).getDelivery_date()));
            i.putExtra("subtotal",String.valueOf(orderlist.get(getPosition()).getSub_total()));
            i.putExtra("taxamount",String.valueOf(orderlist.get(getPosition()).getTax_amount()));
            i.putExtra("bphone",String.valueOf(orderlist.get(getPosition()).getContract().getBuyer().getSales_person().getMobile()));

            context.startActivity(i);

        }


    }
}

