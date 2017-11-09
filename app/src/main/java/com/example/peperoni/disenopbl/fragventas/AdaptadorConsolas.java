package com.example.peperoni.disenopbl.fragventas;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.peperoni.disenopbl.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class AdaptadorConsolas extends RecyclerView.Adapter<AdaptadorConsolas.ConsolasViewHolder>{
    private Context misConsolas;
    private static List<Consola> item;




    public static class ConsolasViewHolder extends RecyclerView.ViewHolder{
        public ImageView imagen;
        public TextView nombre;
        public TextView precio;
        public TextView marca;

        public ConsolasViewHolder(View v) {
            super(v);
            imagen =(ImageView) v.findViewById(R.id.imagen);
            nombre = (TextView) v.findViewById(R.id.modelo);
            marca = (TextView) v.findViewById(R.id.marca);
            precio = (TextView) v.findViewById(R.id.precio);

        }
        }
    public AdaptadorConsolas(List<Consola> items, Context mcontext) {
        item = items;
        misConsolas=mcontext;
    }

    public List<Consola> getItems() {
        return item;
    }

    public void setItems(List<Consola> items) {
        this.item = items;
    }

    @Override
    public ConsolasViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(misConsolas)
                .inflate(R.layout.consolaadapter, viewGroup, false);


        //ImageView imagen = (ImageView) LayoutInflater.from(viewGroup.getContext())
                //.inflate(R.layout.consolaadapter, viewGroup, false);
        return new ConsolasViewHolder(v) ;
    }

    @Override
    public void onBindViewHolder(ConsolasViewHolder viewHolder, int i) {
        Glide.with(misConsolas)
                .load(item.get(i).getImagen())
                .into(viewHolder.imagen);
        System.out.print(item.get(i).getModelo()+" ");
        viewHolder.nombre.setText(item.get(i).getModelo());
        viewHolder.precio.setText("Precio: "+item.get(i).getPrecio());
        viewHolder.marca.setText(item.get(i).getMarca());
    }
    @Override
    public int getItemCount() {
        return item.size();
    }







}


