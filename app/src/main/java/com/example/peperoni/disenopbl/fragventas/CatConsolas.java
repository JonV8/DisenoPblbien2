package com.example.peperoni.disenopbl.fragventas;

/**
 * Created by dam2-jon on 06/11/2017.
 */

public class CatConsolas {
    private int imagen;
    private String nombre;
    private int precio;

    public CatConsolas(int imagen, String nombre, int precio) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public int getImagen() {
        return imagen;
    }
}
