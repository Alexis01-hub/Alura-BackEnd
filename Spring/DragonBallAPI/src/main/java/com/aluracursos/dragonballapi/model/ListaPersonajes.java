package com.aluracursos.dragonballapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ListaPersonajes(List<DatosPersonaje> items) {

}
