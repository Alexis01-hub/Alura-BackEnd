package com.aluracursos.desafio.repository;

import com.aluracursos.desafio.model.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CancionRepository extends JpaRepository<Cancion, Long> {
    // Derived Query - Buscar canciones por el nombre del cantante
    List<Cancion> findByCantanteNombre(String nombreCantante);

    // JPQL - Buscar canciones por cantante
    @Query("SELECT c FROM Cancion c WHERE c.cantante.nombre LIKE %:nombre%")
    List<Cancion> buscarCancionesPorCantante(String nombre);
}
