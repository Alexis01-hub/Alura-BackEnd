package com.aluracurso.desafio.modelo;

public class Canciones extends Audio{
    private String artista;
    private String album;

    @Override
    public int getClasificacion() {
        if (getMeGusta() > 5){
            return 5;
        } else {
            return 4;
        }
    }


    // Getters and Setters -----------------------------------
    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}
