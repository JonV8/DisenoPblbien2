package com.example.peperoni.disenopbl.fragventas;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by dam2-jon on 07/11/2017.
 */

public class Consola {
    private int imagen;
    private String modelo;
    private String marca;
    private int precio;


    public Consola(int imagen, String modelo, String marca, int precio) {
        this.imagen = imagen;
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
    }

    public Consola(JSONObject objetoJSON) {
        try {
            modelo = objetoJSON.getString("modelo");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            marca = objetoJSON.getString("marca");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            imagen = objetoJSON.getInt("foto");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            precio = objetoJSON.getInt("precio");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPrecio() {
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
