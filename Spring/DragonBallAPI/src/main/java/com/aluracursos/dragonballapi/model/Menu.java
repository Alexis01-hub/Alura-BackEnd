package com.aluracursos.dragonballapi.model;

public class Menu {
    public static void mostrarMenu(){
        System.out.println("\n" + "=".repeat(50)); // Línea de separación
        System.out.println("              MENÚ PRINCIPAL");
        System.out.println("=".repeat(50));
        System.out.println("1. 📋 Listar todos los personajes");
        System.out.println("2. 🔍 Buscar personaje por nombre");
        System.out.println("3. 🌍 Listar planetas");
        System.out.println("4. 🤑 Top 5 mas fuertes");
        System.out.println("=".repeat(50));
        System.out.print("Selecciona una opción: ");
    }
}
