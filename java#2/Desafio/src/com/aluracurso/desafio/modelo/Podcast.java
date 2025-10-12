package com.aluracurso.desafio.modelo;

public class Podcast extends Audio{
    private String creador;
    private String descripcion;

    @Override
    public int getClasificacion() {
        if (getTotalDeReproducciones() > 5){
            return 5;
        } else {
            return 4;
        }
    }

    // Getters and Setters -----------------------------------
    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
