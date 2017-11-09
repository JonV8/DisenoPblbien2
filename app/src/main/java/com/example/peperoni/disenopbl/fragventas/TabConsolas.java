package com.example.peperoni.disenopbl.fragventas;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.peperoni.disenopbl.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TabConsolas extends Fragment {
    private String tipo_producto = "Consolas";
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private static final String TAG = "TabConsolas";
    List<Consola> items=new ArrayList<Consola>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tabconsolas_fragment,container,false);

        recycler = view.findViewById(R.id.recicladorConsolas);
        recycler.setHasFixedSize(true);

        lManager = new LinearLayoutManager(container.getContext());
        recycler.setLayoutManager(lManager);

        final String tipo_producto="Consolas";

        Map<String, String> jsonParams = new HashMap<String, String>();

        jsonParams.put("tipo_producto", tipo_producto);

        String json ="http://192.168.6.188/wsPBL/post.php";

        RequestQueue queue = Volley.newRequestQueue(getContext());

        // prepare the Request
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.POST, json, null,
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
                }){

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();

                headers.put("Content-Type", "application/json; charset=utf-8");
                headers.put("tipo_producto", tipo_producto);
                return headers;
            }
        };
        // add it to the RequestQueue
        queue.add(getRequest);



        return view;
    }

}
