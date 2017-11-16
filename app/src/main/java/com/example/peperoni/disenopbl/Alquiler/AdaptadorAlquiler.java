package com.example.peperoni.disenopbl.Alquiler;

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
import com.example.peperoni.disenopbl.fragventas.AdaptadorConsolas;
import com.example.peperoni.disenopbl.fragventas.Consola;

import java.util.List;

/**
 * Created by dam2-jon on 15/11/2017.
 */

public class AdaptadorAlquiler extends RecyclerView.Adapter<AdaptadorAlquiler.AlquilerViewHolder>{
    private Context miAlquiler;
    private static List<Alquiler> item;

    public static class AlquilerViewHolder extends RecyclerView.ViewHolder{
        public ImageView imagen;
        public TextView nombre;
        public TextView precio;
        public TextView marca;
        public Button alquilar;

        public AlquilerViewHolder(View v) {
            super(v);
            imagen =(ImageView) v.findViewById(R.id.imagen);
            nombre = (TextView) v.findViewById(R.id.modelo);
            marca = (TextView) v.findViewById(R.id.marca);
            precio = (TextView) v.findViewById(R.id.precio);
            alquilar = (Button) v.findViewById(R.id.btnAlq);

            alquilar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "Alquilado", Toast.LENGTH_SHORT).show();
                }
            });
        }
        }
    public AdaptadorAlquiler(List<Alquiler> items, Context mcontext) {
        item = items;
        miAlquiler=mcontext;
    }

    public List<Alquiler> getItems() {
        return item;
    }

    public void setItems(List<Alquiler> items) {
        this.item = items;
    }

    @Override
    public AdaptadorAlquiler.AlquilerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(miAlquiler)
                .inflate(R.layout.alquileradapter, viewGroup, false);

        return new AdaptadorAlquiler.AlquilerViewHolder(v) ;
    }

    @Override
    public void onBindViewHolder(AdaptadorAlquiler.AlquilerViewHolder viewHolder, int i) {
        Glide.with(miAlquiler)
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
