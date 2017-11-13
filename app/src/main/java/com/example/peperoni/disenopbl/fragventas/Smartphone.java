package com.example.peperoni.disenopbl.fragventas;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by dam2-jon on 13/11/2017.
 */

class Smartphone {
    private String imagen;
    private String modelo;
    private String marca;
    private float precio;
    public Smartphone(JSONObject objetoJSON) {
        try {
            this.modelo = objetoJSON.getString("modelo");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.marca = objetoJSON.getString("marca");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.imagen = objetoJSON.getString("foto");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.precio=objetoJSON.getInt("precio");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public String getImagen() {
        return this.imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
