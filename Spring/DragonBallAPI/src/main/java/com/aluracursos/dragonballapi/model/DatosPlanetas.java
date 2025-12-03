package com.aluracursos.dragonballapi.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
/*
 * Record para representar los datos de un planeta de Dragon Ball.
 * Utiliza anotaciones de Jackson para mapear los nombres de las propiedades JSON a los nombres de los campos del record.
 * Cada campo del record corresponde a una propiedad del planeta.
 */
public record DatosPlanetas(
        @JsonAlias("name") String nombre,
        @JsonAlias("isDestroyed") boolean estaDestruido,
        @JsonAlias("description") String descripcion
        )
{
}
