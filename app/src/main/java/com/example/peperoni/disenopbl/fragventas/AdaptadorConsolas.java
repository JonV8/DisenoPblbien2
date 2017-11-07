package com.example.peperoni.disenopbl.fragventas;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.peperoni.disenopbl.R;

import java.util.List;


public class AdaptadorConsolas extends RecyclerView.Adapter<AdaptadorConsolas.ConsolasViewHolder>{
    private TabConsolas misConsolas;
    private List<CatConsolas> items;



    public static class ConsolasViewHolder extends RecyclerView.ViewHolder{
        public ImageView imagen;
        public TextView nombre;
        public TextView precio;

        public ConsolasViewHolder(View v) {
            super(v);
            imagen = (ImageView)v.findViewById(R.id.imagen);
        }
        }
    public AdaptadorConsolas(List<CatConsolas> items) {
        this.items = items;
    }

    @Override
    public ConsolasViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(misConsolas.getContext())
                .inflate(R.layout.tabconsolas_fragment, viewGroup, false);
        return new ConsolasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ConsolasViewHolder viewHolder, int i) {
        viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.nombre.setText(items.get(i).getNombre());
        viewHolder.precio.setText("Precio: "+items.get(i).getPrecio());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }





}


