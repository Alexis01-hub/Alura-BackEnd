package com.alura.starwars.controller;

import com.alura.starwars.model.Pelicula;
import com.alura.starwars.model.PeliculaApi;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;


import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public void empezar() throws IOException {
        Scanner teclado = new Scanner(System.in);
        List<Pelicula> peliculas = new ArrayList<>();
        // Usamos LOWER_CASE_WITH_UNDERSCORES porque la API devuelve campos como "release_date"
        // que usan snake_case; con UPPER_CAMEL_CASE Gson no encontraba los nombres y devolvía null.
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();

        while (true) {
            System.out.println("Ingrese el numero de la pelicula de star wars que desea agregar (1-6) o 0 para salir:");
            String busqueda = teclado.nextLine().trim();
            if (busqueda.equals("0")) {
                System.out.println("Saliendo del programa...");
                break;
            }

            int id;
            try {
                id = Integer.parseInt(busqueda);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida: debes ingresar un número entero (ej. 1..6). Intenta de nuevo.");
                continue;
            }

            // Validación del rango según el enunciado (asumo episodios 1..6)
            if (id < 1 || id > 6) {
                System.out.println("Número fuera de rango: ingresa un número entre 1 y 6.");
                continue;
            }

            String direccion = "https://swapi.dev/api/films/" + id + "/";
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(direccion)).build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                int status = response.statusCode();
                if (status != 200) {
                    System.out.println("La API respondió con código " + status + ". No se pudo obtener la película.");
                    continue;
                }

                String json = response.body();

                try {
                    PeliculaApi peliculaApi = gson.fromJson(json, PeliculaApi.class);
                    if (peliculaApi == null) {
                        System.out.println("No se pudo parsear la respuesta JSON a PeliculaApi.");
                        continue;
                    }
                    Pelicula miPelicula = new Pelicula(peliculaApi);
                    peliculas.add(miPelicula);
                    System.out.println("¡Pelicula agregada correctamente!");
                } catch (JsonSyntaxException jse) {
                    System.out.println("Error al parsear JSON: " + jse.getMessage());
                    continue;
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Ocurrio un error en la URI, verifique direccion ingresada");
            } catch (IOException | InterruptedException e) {
                System.out.println("Ocurrio un error al comunicarse con la API: " + e.getMessage());
                // Restaurar el estado de interrupción si fue InterruptedException
                if (e instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
            }

            System.out.println("Peliculas agregadas hasta el momento:");
            System.out.println(peliculas);
            System.out.println("--------------------------------------------------------------");
            // Usar try-with-resources para asegurar cierre del FileWriter
            try (FileWriter escritura = new FileWriter("peliculas.json")) {
                escritura.write(gson.toJson(peliculas));
            } catch (IOException ioe) {
                System.out.println("Error al escribir el archivo peliculas.json: " + ioe.getMessage());
            }
        }
        System.out.println(peliculas); // muestra el arraylist de peliculas
        System.out.println("Finalizo la operacion del programa!");
    }
}
