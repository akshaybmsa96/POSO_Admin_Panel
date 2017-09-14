package com.example.akki.daybox_admin_portal.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.akki.daybox_admin_portal.R;
import com.example.akki.daybox_admin_portal.pojo.orderdetail.ItemsDTO;

import java.util.ArrayList;

/**
 * Created by Akki on 03-06-2017.
 */
public class CustomPurchasedItemAdapter extends ArrayAdapter<ItemsDTO> {

    Context context;
    Activity activity;
    ArrayList<ItemsDTO> items;

    public CustomPurchasedItemAdapter(Context context,Activity activity,ArrayList<ItemsDTO> items) {
        super(context, R.layout.orderslistviewlayout, items);
        this.context = context;
        this.items=items;
        this.activity=activity;
    }


    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.purchase_list_layout, null, true);
        TextView textViewItemName=(TextView)rowView.findViewById(R.id.textViewItemName);
        TextView textViewQuantity=(TextView)rowView.findViewById(R.id.textViewQuantity);
        TextView textViewRate=(TextView)rowView.findViewById(R.id.textViewRate);

        textViewItemName.setText(items.get(position).getItem().getName());
        textViewQuantity.setText(""+items.get(position).getFinal_quantity()+ " " +items.get(position).getItem().getUom());
        textViewRate.setText("Rate : "+items.get(position).getFinal_rate()+ "/" +items.get(position).getItem().getUom());

        return rowView;
    }

}