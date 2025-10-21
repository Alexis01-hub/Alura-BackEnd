package com.alura.modelo;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Clase que representa un carrito de compras que almacena múltiples compras.
 * Permite agregar compras, mostrarlas ordenadas por precio y calcular el total.
 * Tiene una capacidad máxima de 5 compras.
 *
 */
public class CarritoDeCompras {
    private Compra[] compras; // Array para almacenar las compras realizadas
    private int indice;  // Índice para rastrear la cantidad de compras agregadas

    /**
     * Constructor que inicializa el carrito con capacidad para 5 compras.
     */
    public CarritoDeCompras() {
        this.compras = new Compra[5]; // Inicializa el array con una capacidad de 5 compras
        this.indice = 0; // Inicializa el índice en 0
    }

    /**
     * Agrega una compra al carrito si hay espacio disponible.
     * Si el carrito está lleno, muestra un mensaje de advertencia.
     *
     * @param compra El objeto Compra a agregar al carrito
     */
    public void agregarCompra(Compra compra) {
        if (indice < compras.length) {
            compras[indice] = compra; // Agrega la compra al array en la posición del índice
            indice++; // Incrementa el índice para la próxima compra
        } else {
            System.out.println("El carrito de compras está lleno.");
        }
    }

    /**
     * Muestra todas las compras realizadas ordenadas por precio de menor a mayor.
     * Utiliza Arrays.sort con un Comparator para ordenar solo la porción ocupada del array.
     */
    public void mostrarCompras() {
        // Ordena solo la porción ocupada [0, indice) por precio ascendente
        Arrays.sort(compras, 0, indice, Comparator.comparingDouble(Compra::getPrecio));

        System.out.println("Compras realizadas:");
        for (int i = 0; i < indice; i++) {
            System.out.println("- " + compras[i].getNombreProducto() + ": $" + compras[i].getPrecio());
        }
    }

    /**
     * Calcula el monto total de todas las compras en el carrito.
     *
     * @return El total de la suma de precios de todas las compras
     */
    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < indice; i++) {
            total += compras[i].getPrecio(); // Suma el precio de cada compra al total
        }
        return total; // Retorna el total de las compras
    }

}
