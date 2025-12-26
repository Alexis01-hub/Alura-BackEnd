package com.aluracursos.desafio.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cantantes")
public class Cantante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nombre; // Nombre del cantante debe ser único y no nulo

    private String nacionalidad;

    private String generoMusical;

    @OneToMany(mappedBy = "cantante", cascade = CascadeType.ALL, fetch = FetchType.EAGER) // Relación uno a muchos con Cancion. mappedBy indica que la relación es bidireccional y la propiedad "cantante" en la clase Cancion es la dueña de la relación.
    private List<Cancion> canciones = new ArrayList<>();

    // Constructores
    public Cantante() {
    }

    public Cantante(String nombre, String nacionalidad, String generoMusical) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.generoMusical = generoMusical;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    @Override
    public String toString() {
        return "Cantante{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", generoMusical='" + generoMusical + '\'' +
                ", numCanciones=" + canciones.size() +
                '}';
    }
}
