package com.aluracurso.desafio.modelo;

public class Audio {
    private String titulo;
    private int duracion;
    private int totalDeReproducciones;
    private int meGusta;
    private int Clasificacion;
    // Metodos -----------------------------------
    public void meGusta(){
        this.meGusta++;
    }
    public void reproducir(){
        this.totalDeReproducciones++;
    }

    public String getTitulo() {
        return titulo;
    }

    public void mostrarDatos(){
        System.out.println("Titulo: " + getTitulo());
        System.out.println("Duracion: " + getDuracion() + " Minutos");
        System.out.println("Total de reproducciones: " + getTotalDeReproducciones());
        System.out.println("Me gusta: " + getMeGusta());
        System.out.println("Clasificacion: " + getClasificacion() + " estrellas");
    }
    // Getters and Setters -----------------------------------
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getTotalDeReproducciones() {
        return totalDeReproducciones;
    }

    public void setTotalDeReproducciones(int totalDeReproducciones) {
        this.totalDeReproducciones = totalDeReproducciones;
    }

    public int getMeGusta() {
        return meGusta;
    }

    public void setMeGusta(int meGusta) {
        this.meGusta = meGusta;
    }

    public int getClasificacion() {
        return Clasificacion;
    }

    public void setClasificacion(int clasificacion) {
        Clasificacion = clasificacion;
    }
}
