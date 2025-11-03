package com.alura.starwars.aplicacion;

import com.alura.starwars.controller.Menu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("¡Bienvenido a la aplicación de Star Wars!");

        Menu menu = new Menu();
        menu.empezar();
    }
}
