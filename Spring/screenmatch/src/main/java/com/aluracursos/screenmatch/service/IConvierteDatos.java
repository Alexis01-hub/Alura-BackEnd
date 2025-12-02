package com.aluracursos.screenmatch.service;

import com.aluracursos.screenmatch.model.DatosSerie;

public interface IConvierteDatos {

    <T> T obtenerDatos(String json, Class<T> tipoClase);

}
