package com.example.akki.daybox_admin_portal.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.akki.daybox_admin_portal.R;

import java.util.ArrayList;

/**
 * Created by Akki on 03-06-2017.
 */
public class CustomPurchasedItemAdapter extends ArrayAdapter<String> {

    Context context;
    Activity activity;
    ArrayList<String> piname;
    ArrayList<String> piqty;
    ArrayList<String> pirate;
    ArrayList<String> piamount;

    public CustomPurchasedItemAdapter(Context context, Activity activity, ArrayList<String> piname,ArrayList<String> piqty,
            ArrayList<String> pirate, ArrayList<String> piamount) {
        super(context, R.layout.orderslistviewlayout, piname);
        this.context = context;
        this.piname=piname;
        this.piqty=piqty;
        this.pirate=pirate;
        this.piamount=piamount;
        this.activity = activity;
    }



    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.purchase_list_layout, null, true);
        TextView tv=(TextView)rowView.findViewById(R.id.iname);
        TextView tv1=(TextView)rowView.findViewById(R.id.quantitytextviewid);
        TextView tv2=(TextView)rowView.findViewById(R.id.ratetextviewid);

        tv.setText(piname.get(position));
        tv1.setText(piqty.get(position));
        tv2.setText("Rate : "+pirate.get(position));

        return rowView;
    }

}