package com.aluracursos.dragonballapi.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // Ignorar propiedades desconocidas en el JSON
    /*
    * Record para representar los datos de un personaje de Dragon Ball.
    * Utiliza anotaciones de Jackson para mapear los nombres de las propiedades JSON a los nombres de los campos del record.
    * Cada campo del record corresponde a una propiedad del personaje.
    */
public record DatosPersonaje(
        @JsonAlias("name") String nombre,
        @JsonAlias("ki") String ki,
        @JsonAlias("race") String raza,
        @JsonAlias("gender") String genero,
        @JsonAlias("description") String descripcion){

}
