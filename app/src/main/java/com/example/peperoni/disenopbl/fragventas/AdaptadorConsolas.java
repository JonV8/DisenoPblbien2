package com.example.peperoni.disenopbl.fragventas;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.peperoni.disenopbl.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;


public class AdaptadorConsolas extends RecyclerView.Adapter<AdaptadorConsolas.ConsolasViewHolder>{
    private TabConsolas misConsolas;
    private List<Consola> items;

    public static class ConsolasViewHolder extends RecyclerView.ViewHolder{
        public ImageView imagen;
        public TextView nombre;
        public TextView precio;
        public TextView marca;

        public ConsolasViewHolder(View v) {
            super(v);
            imagen = (ImageView)v.findViewById(R.id.imagen);
            nombre = (TextView) v.findViewById(R.id.modelo);
            //marca = (TextView) v.findViewById(R.id.);
            //precio = (TextView) v.findViewById(R.id.);
        }
        }
    public AdaptadorConsolas(List<Consola> items) {
        this.items = items;
    }

    @Override
    public ConsolasViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(misConsolas.getContext())
                .inflate(R.layout.consolaadapter, viewGroup, false);
        return new ConsolasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ConsolasViewHolder viewHolder, int i) {
        viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.nombre.setText(items.get(i).getModelo());
        viewHolder.precio.setText("Precio: "+items.get(i).getPrecio());
        viewHolder.marca.setText(items.get(i).getMarca());
    }
    @Override
    public int getItemCount() {
        return items.size();
    }

    public void sacarConsolas(){
        String tipo_producto="Consolas";
        String json ="http://192.168.6.188/wsPBL/post.php";

        JSONObject object = null;
        try {
            object = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONArray json_array = object.optJSONArray("productos");
        for (int i = 0; i < json_array.length(); i++) {
            try {
                items.add(new Consola(json_array.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }



}


