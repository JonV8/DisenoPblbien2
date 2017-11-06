package com.example.peperoni.disenopbl.fragventas;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class AdaptadorConsolas extends BaseAdapter{
    private TabConsolas misConsolas;
    private JSONArray arrayFotos;
    private RequestQueue colaPeticiones;
    private StringRequest strPeticion;
    private int actual;

    public AdaptadorConsolas(TabConsolas misConsolas) {
        this.misConsolas = misConsolas;

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View miView, ViewGroup parent) {
        obtenerMarcas();
        return null;
    }


    private void obtenerMarcas() {
        JsonArrayRequest jsonPeticion;
        String url="http://192.168.6.188/wsPBL/servicio.php";
        jsonPeticion=new JsonArrayRequest(Request.Method.POST, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        arrayFotos=response;
                        //MOSTRAR EL PRIMERO Y ACTIVAR LOS BOTONES
                        //controlar si viene vacio
                        if(arrayFotos.length()>0) {
                            actual = 0;
                            mostrarDatos();
                        }
                        else{
                            Toast.makeText(misConsolas.getContext(), "No hay datos que mostrar", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(misConsolas.getContext(), "Error de red", Toast.LENGTH_SHORT).show();
                    }
                });
        colaPeticiones.add(jsonPeticion);
    }

    private void mostrarDatos() {
        JSONObject foto;
        try {
            foto= arrayFotos.getJSONObject(actual);
            //textId.setText(foto.getString("foto"));
            //textMarca.setText(marca.getString("nombre"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}

