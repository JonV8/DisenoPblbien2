package com.example.peperoni.disenopbl.fragventas;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.peperoni.disenopbl.R;

import java.util.ArrayList;
import java.util.List;

public class TabConsolas extends Fragment {
    private String tipo_producto = "Consolas";
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private static final String TAG = "TabConsolas";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tabconsolas_fragment,container,false);
        List items = new ArrayList();

        recycler = view.findViewById(R.id.recicladorConsolas);
        recycler.setHasFixedSize(true);

        lManager = new LinearLayoutManager(view.getContext());
        recycler.setLayoutManager(lManager);

        adapter = new AdaptadorConsolas(items);
        recycler.setAdapter(adapter);

        return view;
    }

}
