package com.example.peperoni.disenopbl.fragapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.peperoni.disenopbl.R;

import java.util.List;

/**
 * Created by dam2-jon on 16/11/2017.
 */

public class AdaptadorCatalogo extends RecyclerView.Adapter<AdaptadorCatalogo.CatalogoViewHolder>{
    private Context miCatalogo;
    private static List<Producto> item;

    public static class CatalogoViewHolder extends RecyclerView.ViewHolder{
        public ImageView imagen;
        public TextView nombre;
        public TextView precio;
        public TextView marca;
        public Button alquilar;

        public CatalogoViewHolder(View v) {
            super(v);
            imagen =(ImageView) v.findViewById(R.id.imagen);
            nombre = (TextView) v.findViewById(R.id.modelo);
            marca = (TextView) v.findViewById(R.id.marca);
            precio = (TextView) v.findViewById(R.id.precio);
            alquilar = (Button) v.findViewById(R.id.btnAlq);

            alquilar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "Comprado", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    public AdaptadorCatalogo(List<Producto> items, Context mcontext) {
        item = items;
        miCatalogo=mcontext;
    }

    public List<Producto> getItems() {
        return item;
    }

    public void setItems(List<Producto> items) {
        this.item = items;
    }

    @Override
    public AdaptadorCatalogo.CatalogoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(miCatalogo)
                .inflate(R.layout.catalogoadapter, viewGroup, false);

        return new AdaptadorCatalogo.CatalogoViewHolder(v) ;
    }

    @Override
    public void onBindViewHolder(CatalogoViewHolder viewHolder, int i) {
        Glide.with(miCatalogo)
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