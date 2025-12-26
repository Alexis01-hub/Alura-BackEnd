package com.aluracursos.desafio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "canciones")
public class Cancion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    private String album;

    private Integer duracionSegundos;

    private Integer anioLanzamiento;

    @ManyToOne
    @JoinColumn(name = "cantante_id", nullable = false) // Clave foránea que referencia al cantante
    private Cantante cantante;

    // Constructores
    public Cancion() {
    }

    public Cancion(String titulo, String album, Integer duracionSegundos, Integer anioLanzamiento) {
        this.titulo = titulo;
        this.album = album;
        this.duracionSegundos = duracionSegundos;
        this.anioLanzamiento = anioLanzamiento;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Integer getDuracionSegundos() {
        return duracionSegundos;
    }

    public void setDuracionSegundos(Integer duracionSegundos) {
        this.duracionSegundos = duracionSegundos;
    }

    public Integer getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(Integer anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    public Cantante getCantante() {
        return cantante;
    }

    public void setCantante(Cantante cantante) {
        this.cantante = cantante;
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", album='" + album + '\'' +
                ", duracionSegundos=" + duracionSegundos +
                ", anioLanzamiento=" + anioLanzamiento +
                ", cantante=" + (cantante != null ? cantante.getNombre() : "N/A") +
                '}';
    }
}
