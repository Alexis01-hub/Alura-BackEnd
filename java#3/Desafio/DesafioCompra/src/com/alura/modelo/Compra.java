package com.alura.modelo;

/**
 * Clase que representa una compra individual realizada con la tarjeta.
 * Almacena la información del producto comprado y su precio.
 *
 */
public class Compra {
    private double precio; // Precio del producto comprado
    private String nombreProducto; // Nombre o descripción del producto comprado

    /**
     * Constructor que inicializa una compra con precio y nombre del producto.
     *
     * @param precio El valor monetario de la compra
     * @param nombreProducto La descripción o nombre del producto
     */
    public Compra(double precio, String nombreProducto) {
        this.precio = precio;
        this.nombreProducto = nombreProducto;
    }

    /**
     * Obtiene el precio de la compra.
     *
     * @return El precio del producto
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Obtiene el nombre o descripción del producto comprado.
     *
     * @return El nombre del producto
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

}
