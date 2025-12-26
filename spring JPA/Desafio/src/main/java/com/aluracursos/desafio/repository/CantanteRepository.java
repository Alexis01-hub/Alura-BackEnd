package com.aluracursos.desafio.repository;

import com.aluracursos.desafio.model.Cantante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CantanteRepository extends JpaRepository<Cantante, Long> {
    // Derived Query - Buscar cantante por nombre exacto
    Optional<Cantante> findByNombre(String nombre);

    // Derived Query - Buscar cantantes por género musical
    List<Cantante> findByGeneroMusical(String generoMusical);

    // JPQL - Top 5 cantantes con más canciones
    @Query("SELECT c FROM Cantante c ORDER BY SIZE(c.canciones) DESC LIMIT 5")
    List<Cantante> findTop5CantantesConMasCanciones();

    // Native Query - Buscar cantantes por nacionalidad
    @Query(value = "SELECT * FROM cantantes WHERE nacionalidad = :nacionalidad", nativeQuery = true)
    List<Cantante> buscarPorNacionalidad(String nacionalidad);
}

