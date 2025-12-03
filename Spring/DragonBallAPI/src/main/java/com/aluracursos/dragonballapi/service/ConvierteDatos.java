package com.aluracursos.dragonballapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos implements IConvierteDatos {
    private ObjectMapper mapper = new ObjectMapper(); // Objeto de Jackson para manejar la conversión


    @Override
    public <T> T obtenerDatos(String json, Class<T> tipoClase) {
        try {
            return mapper.readValue(json, tipoClase); // Convierte el JSON en un objeto de la clase especificada
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
