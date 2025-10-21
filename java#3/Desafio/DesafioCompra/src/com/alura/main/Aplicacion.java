package com.alura.main;

import com.alura.modelo.CarritoDeCompras;
import com.alura.modelo.Compra;
import com.alura.modelo.Tarjeta;

import java.util.Scanner;

public class Aplicacion {
    public static void main(String[] args) {
        // Inicializa el scanner para leer entrada del usuario
        Scanner teclado = new Scanner(System.in);

        // Solicita y establece el límite inicial de la tarjeta
        System.out.println("Escriba el límite de la tarjeta:");
        double limiteInicial = Double.parseDouble(teclado.nextLine());

        // Crea instancias del carrito y la tarjeta
        CarritoDeCompras carrito = new CarritoDeCompras();
        Tarjeta tarjeta = new Tarjeta(limiteInicial, limiteInicial);

        // Variable de control para el menú (0 = continuar, 1 = salir)
        int opcion = 0;

        // Bucle principal de compras
        while (opcion != 1) {
            // Solicita la descripción del producto
            tarjeta.verificarSaldo();
            System.out.println("\nEscriba la descripción de la compra:");
            String descripcion = teclado.nextLine();

            // Solicita el valor de la compra
            System.out.println("Escriba el valor de la compra:");
            double valor = Double.parseDouble(teclado.nextLine());

            // Valida que haya saldo suficiente
            if (valor <= tarjeta.getSaldoDisponible()) {
                // Realiza la compra descontando del saldo
                tarjeta.realizarCompra(valor);
                // Agrega la compra al carrito
                carrito.agregarCompra(new Compra(valor, descripcion));
                System.out.println("Compra realizada!");

                // Muestra menú de opciones
                System.out.println("\nEscriba 0 para continuar o 1 para salir:");
                opcion = Integer.parseInt(teclado.nextLine());
            } else {
                // Si no hay saldo suficiente, termina el programa
                System.out.println("Saldo insuficiente!");
                break;
            }
        }

        // Muestra el resumen final de compras
        System.out.println("\n***********************");
        System.out.println("COMPRAS REALIZADAS:\n");
        carrito.mostrarCompras(); // Muestra las compras ordenadas por valor
        System.out.println("\nTotal gastado: $" + carrito.calcularTotal());
        System.out.println("\n***********************");
        System.out.println("Saldo de la tarjeta: " + tarjeta.getSaldoDisponible());

        // Cierra el scanner
        teclado.close();
    }
}
