package com.aluracursos.dragonballapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record ListaPlanetas(List<DatosPlanetas> items) {
}
