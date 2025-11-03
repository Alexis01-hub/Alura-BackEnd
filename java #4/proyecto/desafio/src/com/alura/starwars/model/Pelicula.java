package com.alura.starwars.model;

public class Pelicula {
    private String titulo;
    private String fechaLanzamiento;
    private String director;

    public Pelicula(String titulo, String fechaLanzamiento, String director) {
        this.titulo = titulo;
        this.fechaLanzamiento = fechaLanzamiento;
        this.director = director;
    }
    /*
    Constructor que convierte un objeto PeliculaApi a un objeto Pelicula
     */
    public Pelicula(PeliculaApi peliculaApi) {
        this.titulo = peliculaApi.title();
        this.fechaLanzamiento = peliculaApi.release_date();
        this.director = peliculaApi.director();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return "(" +
                "titulo= " + titulo +
                ", fechaLanzamiento= " + fechaLanzamiento  +
                ", director= " + director +
                ')';
    }
}
