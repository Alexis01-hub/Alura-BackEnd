package com.aluracursos.dragonballapi.principal;

import com.aluracursos.dragonballapi.model.*;
import com.aluracursos.dragonballapi.service.ConsumoAPI;
import com.aluracursos.dragonballapi.service.ConvierteDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


/**
 * Clase que gestiona la interacción con la API de Dragon Ball.
 * Proporciona funcionalidades para listar personajes, planetas y realizar búsquedas.
 *
 * @author Alexis01-hub
 * @version 1.0
 */
public class InteraccionApi {
    private final String API_URL = "https://dragonball-api.com/api";
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    int opcion;

    public void menu() {
        System.out.println("╔═══════════════════════════════════════════╗");
        System.out.println("║   🐉 BIENVENIDO A DRAGON BALL API 🐉    ║");
        System.out.println("╚═══════════════════════════════════════════╝");
        Menu.mostrarMenu();

        try {
            opcion = Integer.parseInt(teclado.nextLine());
        } catch (Exception e) {
            System.out.println("Opción inválida. Por favor, ingrese un número.");
        }


        switch (opcion) {
            case 1:
                listarPersonajes();
                break;
            case 2:
                buscarPersonajePorNombre();
                break;
            case 3:
                listarPlanetas();
                break;
            case 4:
                masFuertes();
                break;
            default:
                System.out.println("error en la opción seleccionada");
                break;
        }
    }
    /**
     * Lista todos los personajes disponibles en la API.
     * Muestra información detallada de cada personaje incluyendo nombre, raza, género, ki y descripción.
     */
    public void listarPersonajes() {
        var json = consumoAPI.obtenerDatos(API_URL + "/characters");
        var datos = conversor.obtenerDatos(json, ListaPersonajes.class);
        for (DatosPersonaje personaje : datos.items()) {
            System.out.println("Nombre: " + personaje.nombre());
            System.out.println("Raza: " + personaje.raza());
            System.out.println("Género: " + personaje.genero());
            System.out.println("Ki: " + personaje.ki());
            System.out.println("Descripción: " + personaje.descripcion());
            System.out.println("-".repeat(40));
        }
    }
    /**
     * Busca un personaje por su nombre utilizando streams.
     * La búsqueda es insensible a mayúsculas y permite coincidencias parciales.
     * Si encuentra el personaje, muestra su información completa.
     * Si no lo encuentra, muestra un mensaje de error.
     */
    public void buscarPersonajePorNombre() {
        System.out.print("Ingrese el nombre del personaje a buscar: ");
        String nombreBuscado = teclado.nextLine().toLowerCase();

        var json = consumoAPI.obtenerDatos(API_URL + "/characters");
        var datos = conversor.obtenerDatos(json, ListaPersonajes.class);

        var personajeEncontrado = datos.items().stream()
                .filter(p -> p.nombre().toLowerCase().contains(nombreBuscado.toLowerCase()))
                .findFirst(); // Buscar el primer personaje que coincida

        if (personajeEncontrado != null) {
            DatosPersonaje personaje = personajeEncontrado.get();
            System.out.println("\n✅ PERSONAJE ENCONTRADO\n");
            System.out.println("👤 Nombre: " + personaje.nombre());
            System.out.println("🧬 Raza: " + personaje.raza());
            System.out.println("⚧ Género: " + personaje.genero());
            System.out.println("⚡ Ki: " + personaje.ki());
            System.out.println("💬 Descripción: " + personaje.descripcion());
            System.out.println("-".repeat(40));
        } else {
            System.out.println("❌ No se encontró ningún personaje con ese nombre.");
        }

    }
    /**
     * Lista todos los planetas disponibles en la API.
     * Muestra el nombre, estado de destrucción y descripción de cada planeta.
     */
    public void listarPlanetas() {
        var json = consumoAPI.obtenerDatos(API_URL + "/planets");
        var datos = conversor.obtenerDatos(json, ListaPlanetas.class);

        System.out.println("\n🌍 LISTA DE PLANETAS\n");
        for (DatosPlanetas planeta : datos.items()) {
            System.out.println("🪐 Nombre: " + planeta.nombre());
            System.out.println("💥 Destruido: " + (planeta.estaDestruido() ? "Sí" : "No"));
            System.out.println("📝 Descripción: " + planeta.descripcion());
            System.out.println("-".repeat(40));
        }
    }
    /**
     * Muestra los 5 personajes más fuertes según su nivel de Ki.
     * Utiliza streams para filtrar, ordenar y limitar los resultados.
     * El ordenamiento es descendente, mostrando primero al personaje con mayor Ki.
     */
    public void masFuertes() {
        var json = consumoAPI.obtenerDatos(API_URL + "/characters");
        var datos = conversor.obtenerDatos(json, ListaPersonajes.class);

        List<DatosPersonaje> top5MasFuertes = datos.items().stream()
                .filter(p -> p.ki() != null && !p.ki().isEmpty())
                .sorted((p1, p2) -> {
                    Long ki1 = convertirKiANumero(p1.ki());
                    Long ki2 = convertirKiANumero(p2.ki());
                    return ki2.compareTo(ki1); // Orden descendente
                })
                .limit(5)
                .collect(Collectors.toList());

        System.out.println("\n💪 TOP 5 PERSONAJES MÁS FUERTES 💪\n");
        for (DatosPersonaje personaje : top5MasFuertes) {
            System.out.println("👤 Nombre: " + personaje.nombre());
            System.out.println("⚡ Ki: " + personaje.ki());
            System.out.println("-".repeat(40));
        }
    }

    /**
     * Convierte el valor de Ki de formato String a Long.
     * Elimina los separadores de miles (puntos) antes de la conversión.
     *
     * @param ki Valor de Ki en formato String (ej: "60.000.000")
     * @return Valor numérico del Ki como Long, o 0L si la conversión falla
     */
    private Long convertirKiANumero(String ki) {
        try {
            // Eliminar puntos (separadores de miles) y convertir a número
            return Long.parseLong(ki.replace(".", ""));
        } catch (NumberFormatException e) {
            return 0L; // Si no se puede convertir, retornar 0
        }
    }
}
