package com.aluracurso.desafio.modelo;

public class MisFavoritos {
    public void adicione(Audio audio) {
        if (audio.getClasificacion() >= 4){
            System.out.println("es uno de los favoritos");
        }else{
            System.out.println("tambien es uno de los favoritos");
        }
    }
}
