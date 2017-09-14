package com.example.akki.daybox_admin_portal.adapter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.akki.daybox_admin_portal.R;
import com.example.akki.daybox_admin_portal.activity.FullDetailActivity;
import com.example.akki.daybox_admin_portal.pojo.orderslist.OrdersDTO;
import com.example.akki.daybox_admin_portal.util.StringUtility;
import com.google.gson.Gson;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Akki on 04-06-2017.
 */

public class CustomOrdersAdapter extends RecyclerView.Adapter<CustomOrdersAdapter.ViewHolder> implements StickyRecyclerHeadersAdapter<RecyclerView.ViewHolder> {

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
        View view = inflater.inflate(R.layout.orderslistviewlayout, parent, false);
        ViewHolder holder = new ViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.textViewSupplier.setText(orderlist.get(position).getContract().getSeller().getShow_name());
        holder.textViewAmount.setText("Amount : ₹ " + String.valueOf(orderlist.get(position).getFinal_amount()));
        holder.textViewDDate.setText(StringUtility.getSimpleDate(orderlist.get(position).getDelivery_date()));
        holder.textViewBuyer.setText("By: " + orderlist.get(position).getContract().getBuyer().getShow_name());
        //Toast.makeText(context,name.get(position),Toast.LENGTH_SHORT).show();

    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        @Bind(R.id.textViewSupplier)
        TextView textViewSupplier;
        @Bind(R.id.textViewAmount)
        TextView textViewAmount;
        @Bind(R.id.textViewDdate)
        TextView textViewDDate;
        @Bind(R.id.imageViewCall)
        ImageView imageViewCall;
        @Bind(R.id.textViewBuyer)
        TextView textViewBuyer;


        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

            view.setOnClickListener(this);
            view.setOnLongClickListener(this);
            imageViewCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + String.valueOf(orderlist.get(getPosition()).getContract().getSeller().getSales_person().getMobile())));
                    if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        Toast.makeText(context, "permission denied, check Setting", Toast.LENGTH_LONG).show();

                    } else {
                        context.startActivity(intent);
                    }
                }
            });


        }

        @Override
        public void onClick(View view) {

            Intent i = new Intent(context, FullDetailActivity.class);
            Gson gson = new Gson();
            i.putExtra("orderDetails", gson.toJson(orderlist.get(getPosition())));
            context.startActivity(i);

        }

        @Override
        public boolean onLongClick(View view) {
       //     Toast.makeText(context, "Item will be Delete", Toast.LENGTH_SHORT).show();
            return true;
        }

    }

    @Override
    public long getHeaderId(int position) {
        return orderlist.get(position).getDelivery_date();
    }

    @Override
    public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_header, parent, false);
        return new RecyclerView.ViewHolder(view) {
        };
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int position) {
        TextView textView = (TextView) holder.itemView.findViewById(R.id.textViewHeader);
        textView.setText(StringUtility.getSimpleDate(orderlist.get(position).getDelivery_date()));

    }


    @Override
    public int getItemCount() {

        return orderlist.size();
    }


}

