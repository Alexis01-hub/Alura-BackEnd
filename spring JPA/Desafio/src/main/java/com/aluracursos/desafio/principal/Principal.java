package com.aluracursos.desafio.principal;

import com.aluracursos.desafio.model.Cancion;
import com.aluracursos.desafio.model.Cantante;
import com.aluracursos.desafio.repository.CancionRepository;
import com.aluracursos.desafio.repository.CantanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class Principal {

    @Autowired
    private CantanteRepository cantanteRepository;

    @Autowired
    private CancionRepository cancionRepository;

    private Scanner teclado = new Scanner(System.in);

    public void muestraMenu() {
        var opcion = 0;
        while (opcion != 9) {
            var menu = """
                    
                    ===== GESTIÓN MUSICAL =====
                    1. Agregar cantante
                    2. Agregar canción
                    3. Listar cantantes
                    4. Listar canciones
                    5. Eliminar cantante
                    6. Eliminar canción
                    7. Top 5 cantantes con más canciones
                    8. Buscar canciones por cantante
                    9. Salir
                    ===========================
                    """;
            System.out.println(menu);
            System.out.print("Seleccione una opción: ");
            try {
                opcion = teclado.nextInt();
                teclado.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        agregarCantante();
                        break;
                    case 2:
                        agregarCancion();
                        break;
                    case 3:
                        listarCantantes();
                        break;
                    case 4:
                        listarCanciones();
                        break;
                    case 5:
                        eliminarCantante();
                        break;
                    case 6:
                        eliminarCancion();
                        break;
                    case 7:
                        topCantantesConMasCanciones();
                        break;
                    case 8:
                        buscarCancionesPorCantante();
                        break;
                    case 9:
                        System.out.println("¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                teclado.nextLine(); // Limpiar el buffer en caso de error
            }
        }
    }

    @Transactional
    private void agregarCantante() {
        System.out.println("\n--- AGREGAR CANTANTE ---");
        System.out.print("Nombre del cantante: ");
        String nombre = teclado.nextLine();

        // Verificar si ya existe
        Optional<Cantante> existente = cantanteRepository.findByNombre(nombre);
        if (existente.isPresent()) {
            System.out.println("¡El cantante ya existe en la base de datos!");
            return;
        }

        System.out.print("Nacionalidad: ");
        String nacionalidad = teclado.nextLine();

        System.out.print("Género musical: ");
        String generoMusical = teclado.nextLine();

        Cantante cantante = new Cantante(nombre, nacionalidad, generoMusical);
        cantanteRepository.save(cantante);
        System.out.println("✓ Cantante agregado exitosamente!");
    }

    @Transactional
    private void agregarCancion() {
        System.out.println("\n--- AGREGAR CANCIÓN ---");

        // Primero mostrar los cantantes disponibles
        List<Cantante> cantantes = cantanteRepository.findAll();
        if (cantantes.isEmpty()) {
            System.out.println("¡No hay cantantes registrados! Primero agregue un cantante.");
            return;
        }

        System.out.println("Cantantes disponibles:");
        for (int i = 0; i < cantantes.size(); i++) {
            System.out.println((i + 1) + ". " + cantantes.get(i).getNombre());
        }

        System.out.print("Seleccione el número del cantante: ");
        int seleccion = teclado.nextInt();
        teclado.nextLine(); // Limpiar buffer

        if (seleccion < 1 || seleccion > cantantes.size()) {
            System.out.println("Selección inválida.");
            return;
        }

        Cantante cantante = cantantes.get(seleccion - 1);

        System.out.print("Título de la canción: ");
        String titulo = teclado.nextLine();

        System.out.print("Álbum: ");
        String album = teclado.nextLine();

        System.out.print("Duración en segundos: ");
        Integer duracion = teclado.nextInt();

        System.out.print("Año de lanzamiento: ");
        Integer anio = teclado.nextInt();
        teclado.nextLine(); // Limpiar buffer

        Cancion cancion = new Cancion(titulo, album, duracion, anio);
        cancion.setCantante(cantante);
        cancionRepository.save(cancion);
        System.out.println("✓ Canción agregada exitosamente!");
    }

    private void listarCantantes() {
        System.out.println("\n--- LISTA DE CANTANTES ---");
        List<Cantante> cantantes = cantanteRepository.findAll();

        if (cantantes.isEmpty()) {
            System.out.println("No hay cantantes registrados.");
            return;
        }

        cantantes.forEach(c -> {
            System.out.println("\nID: " + c.getId());
            System.out.println("Nombre: " + c.getNombre());
            System.out.println("Nacionalidad: " + c.getNacionalidad());
            System.out.println("Género: " + c.getGeneroMusical());
            System.out.println("Canciones registradas: " + c.getCanciones().size());
            System.out.println("-------------------------");
        });
    }

    private void listarCanciones() {
        System.out.println("\n--- LISTA DE CANCIONES ---");
        List<Cancion> canciones = cancionRepository.findAll();

        if (canciones.isEmpty()) {
            System.out.println("No hay canciones registradas.");
            return;
        }

        canciones.forEach(c -> {
            System.out.println("\nID: " + c.getId());
            System.out.println("Título: " + c.getTitulo());
            System.out.println("Álbum: " + c.getAlbum());
            System.out.println("Duración: " + c.getDuracionSegundos() + " segundos");
            System.out.println("Año: " + c.getAnioLanzamiento());
            System.out.println("Cantante: " + c.getCantante().getNombre());
            System.out.println("-------------------------");
        });
    }

    @Transactional
    private void eliminarCantante() {
        System.out.println("\n--- ELIMINAR CANTANTE ---");
        listarCantantes();

        System.out.print("\nIngrese el ID del cantante a eliminar: ");
        Long id = teclado.nextLong();
        teclado.nextLine(); // Limpiar buffer

        Optional<Cantante> cantante = cantanteRepository.findById(id);
        if (cantante.isPresent()) {
            cantanteRepository.deleteById(id);
            System.out.println("✓ Cantante eliminado exitosamente (incluyendo sus canciones)!");
        } else {
            System.out.println("No se encontró el cantante con ID: " + id);
        }
    }

    @Transactional
    private void eliminarCancion() {
        System.out.println("\n--- ELIMINAR CANCIÓN ---");
        listarCanciones();

        System.out.print("\nIngrese el ID de la canción a eliminar: ");
        Long id = teclado.nextLong();
        teclado.nextLine(); // Limpiar buffer

        Optional<Cancion> cancion = cancionRepository.findById(id);
        if (cancion.isPresent()) {
            cancionRepository.deleteById(id);
            System.out.println("✓ Canción eliminada exitosamente!");
        } else {
            System.out.println("No se encontró la canción con ID: " + id);
        }
    }

    private void topCantantesConMasCanciones() {
        System.out.println("\n--- TOP 5 CANTANTES CON MÁS CANCIONES ---");
        List<Cantante> top5 = cantanteRepository.findTop5CantantesConMasCanciones();

        if (top5.isEmpty()) {
            System.out.println("No hay cantantes registrados.");
            return;
        }

        for (int i = 0; i < top5.size(); i++) {
            Cantante c = top5.get(i);
            System.out.println((i + 1) + ". " + c.getNombre() +
                             " - " + c.getCanciones().size() + " canciones");
        }
    }

    private void buscarCancionesPorCantante() {
        System.out.println("\n--- BUSCAR CANCIONES POR CANTANTE ---");
        System.out.print("Ingrese el nombre del cantante: ");
        String nombre = teclado.nextLine();

        // Usando Derived Query
        List<Cancion> canciones = cancionRepository.findByCantanteNombre(nombre);

        if (canciones.isEmpty()) {
            System.out.println("No se encontraron canciones para el cantante: " + nombre);
            return;
        }

        System.out.println("\nCanciones de " + nombre + ":");
        canciones.forEach(c -> {
            System.out.println("- " + c.getTitulo() +
                             " (" + c.getAlbum() + ", " + c.getAnioLanzamiento() + ")");
        });
    }
}
