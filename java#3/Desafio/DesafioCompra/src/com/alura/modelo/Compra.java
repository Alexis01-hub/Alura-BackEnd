package com.alura.modelo;

public class Compra {
    private double precio; // Precio del producto comprado
    private String nombreProducto; // Nombre del producto comprado

    public Compra(double precio, String nombreProducto) {
        this.precio = precio;
        this.nombreProducto = nombreProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
}
