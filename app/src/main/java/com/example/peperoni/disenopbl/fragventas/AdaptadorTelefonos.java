package com.example.peperoni.disenopbl.fragventas;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.peperoni.disenopbl.R;

import java.util.List;

/**
 * Created by dam2-jon on 13/11/2017.
 */

public class AdaptadorTelefonos extends RecyclerView.Adapter<AdaptadorTelefonos.TelefonosViewHolder>{
    private Context misTelefonos;
    private static List<Smartphone> item;




    public static class TelefonosViewHolder extends RecyclerView.ViewHolder{
        public ImageView imagen;
        public TextView nombre;
        public TextView precio;
        public TextView marca;

        public TelefonosViewHolder(View v) {
            super(v);
            imagen =(ImageView) v.findViewById(R.id.imagen);
            nombre = (TextView) v.findViewById(R.id.modelo);
            marca = (TextView) v.findViewById(R.id.marca);
            precio = (TextView) v.findViewById(R.id.precio);

        }
    }
    public AdaptadorTelefonos(List<Smartphone> items, Context mcontext) {
        item = items;
        misTelefonos=mcontext;
    }

    public List<Smartphone> getItems() {
        return item;
    }

    public void setItems(List<Smartphone> items) {
        this.item = items;
    }

    @Override
    public TelefonosViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(misTelefonos)
                .inflate(R.layout.consolaadapter, viewGroup, false);



        return new TelefonosViewHolder(v) ;
    }

    @Override
    public void onBindViewHolder(TelefonosViewHolder viewHolder, int i) {
        Glide.with(misTelefonos)
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
