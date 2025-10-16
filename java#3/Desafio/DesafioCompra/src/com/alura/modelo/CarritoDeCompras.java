package com.alura.modelo;

public class CarritoDeCompras {
    private Compra[] compras; // Array para almacenar las compras realizadas
    private int indice;  // Indice para rastrear la cantidad de compras agregadas

    public CarritoDeCompras() {
        this.compras = new Compra[10]; // Inicializa el array con una capacidad de 10 compras
        this.indice = 0; // Inicializa el indice en 0
    }

    public void agregarCompra(Compra compra) {
        if (indice < compras.length) {
            compras[indice] = compra; // Agrega la compra al array en la posición del indice
            indice++; // Incrementa el indice para la próxima compra
        } else {
            System.out.println("El carrito de compras está lleno.");
        }
    }

    public void mostrarCompras() {
        System.out.println("Compras realizadas:");
        for (int i = 0; i < indice; i++) {
            System.out.println("- " + compras[i].getNombreProducto() + ": $" + compras[i].getPrecio());
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < indice; i++) {
            total += compras[i].getPrecio(); // Suma el precio de cada compra al total
        }
        return total; // Retorna el total de las compras
    }

}
