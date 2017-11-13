package com.example.peperoni.disenopbl.fragventas;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.peperoni.disenopbl.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TabConsolas extends Fragment {
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private static final String TAG = "TabConsolas";
    List<Consola> items=new ArrayList<Consola>();
    private JSONObject jsonBody;
    private String requestBody;
    private List<String> requestQueue;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tabconsolas_fragment,container,false);

        recycler = view.findViewById(R.id.recicladorConsolas);
        recycler.setHasFixedSize(true);

        lManager = new LinearLayoutManager(container.getContext());
        recycler.setLayoutManager(lManager);

        String json ="http://192.168.6.188/wsPBL/post.php";
        RequestQueue queue = Volley.newRequestQueue(getContext());
        //enviarTipo(json);
        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("tipo_producto", "Consolas");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // prepare the Request
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.POST, json, jsonBody,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        // display response
                        JSONArray productos= null;
                        JSONArray clientes=null;

                        try {
                            productos = response.getJSONArray("productos");
                            clientes = response.getJSONArray("clientes");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        for (int i = 0; i < productos.length(); i++) {
                            try {
                                JSONObject row = productos.getJSONObject(i);
                                items.add(new Consola(row));
                                adapter = new AdaptadorConsolas(items,getContext());
                                recycler.setAdapter(adapter);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", "error");
                    }
                });
        // add it to the RequestQueue
        queue.add(getRequest);



        return view;
    }
}
