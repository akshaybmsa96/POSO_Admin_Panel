package com.example.akki.daybox_admin_portal.network;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.akki.daybox_admin_portal.adapter.CustomOrdersAdapter;
import com.example.akki.daybox_admin_portal.global.NetworkConstants;
import com.example.akki.daybox_admin_portal.pojo.orderslist.OrdersDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Akki on 07-06-2017.
 */

public class FetchOrders implements NetworkConstants {

    Context context;
    ArrayList<OrdersDTO> orderlist;
    CustomOrdersAdapter ca;
    RecyclerView recyclerView;

    public FetchOrders(Context context, ArrayList<OrdersDTO> orderlist, CustomOrdersAdapter ca, RecyclerView recyclerView) {

        this.context=context;
        this.orderlist=orderlist;
        this.ca=ca;
        this.recyclerView =recyclerView;
    }

    public void fetch()
    {
        final ProgressDialog pDialog = new ProgressDialog(context);
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();

        String url=GeneralUrl+FetchOrdersUrl;

        final RequestQueue mRequestQueue= Volley.newRequestQueue(context);

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                       //     Log.d(TAG, response.toString());
                        mRequestQueue.stop();
                        JsonElement jelement= new JsonParser().parse(response.toString());
                        JsonObject j=jelement.getAsJsonObject();
                        JsonArray j1=j.getAsJsonArray("orders");

                        GsonBuilder gsonBuilder=new GsonBuilder();
                        Gson gson=gsonBuilder.create();
                        orderlist.addAll(Arrays.asList(gson.fromJson(j1,OrdersDTO[].class)));
                        pDialog.hide();
                        recyclerView.setAdapter(ca);
                        final StickyRecyclerHeadersDecoration headersDecor = new StickyRecyclerHeadersDecoration(ca);
                        recyclerView.addItemDecoration(headersDecor);
                     //   Toast.makeText(context,"" +a.get(4).getSales_status_name() + "",Toast.LENGTH_SHORT).show();

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // VolleyLog.d(TAG, "Error: " + error.getMessage());
                // hide the progress dialog
                pDialog.hide();
                mRequestQueue.stop();
                Toast.makeText(context,error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        mRequestQueue.add(jsonObjReq);
    }
    }
