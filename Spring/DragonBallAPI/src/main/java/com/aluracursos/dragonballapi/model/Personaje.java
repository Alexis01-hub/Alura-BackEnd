package com.aluracursos.dragonballapi.model;

public class Personaje {
    private String nombre;
    private String ki;
    private String raza;
    private String genero;
    private String descripcion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getKi() {
        return ki;
    }

    public void setKi(String ki) {
        this.ki = ki;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "nombre='" + nombre +
                ", ki='" + ki +
                ", raza='" + raza +
                ", genero='" + genero +
                ", descripcion='" + descripcion;
    }
}
