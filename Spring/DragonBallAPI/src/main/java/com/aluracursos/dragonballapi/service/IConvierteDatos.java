package com.aluracursos.dragonballapi.service;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> tipoClase);
}
