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

public class AdaptadorJuegos extends RecyclerView.Adapter<AdaptadorJuegos.JuegosViewHolder>{
    private Context misJuegos;
    private static List<Juego> item;




    public static class JuegosViewHolder extends RecyclerView.ViewHolder{
        public ImageView imagen;
        public TextView nombre;
        public TextView precio;
        public TextView marca;

        public JuegosViewHolder(View v) {
            super(v);
            imagen =(ImageView) v.findViewById(R.id.imagen);
            nombre = (TextView) v.findViewById(R.id.modelo);
            marca = (TextView) v.findViewById(R.id.marca);
            precio = (TextView) v.findViewById(R.id.precio);

        }
    }
    public AdaptadorJuegos(List<Juego> items, Context mcontext) {
        item = items;
        misJuegos=mcontext;
    }

    public List<Juego> getItems() {
        return item;
    }

    public void setItems(List<Juego> items) {
        this.item = items;
    }

    @Override
    public AdaptadorJuegos.JuegosViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(misJuegos)
                .inflate(R.layout.juegosadapter, viewGroup, false);


        return new AdaptadorJuegos.JuegosViewHolder(v) ;
    }

    @Override
    public void onBindViewHolder(AdaptadorJuegos.JuegosViewHolder viewHolder, int i) {
        Glide.with(misJuegos)
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
