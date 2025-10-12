package com.aluracurso.screenmatch.calculos;

public class FiltroRecomendacion {
    public void filtrar(Clasificacion clasificacion){
        if (clasificacion.getClasificacion() >= 4){
            System.out.println("Merece la pena ver");
        } else {
            System.out.println("Mejor ver otra cosa");
        }

    }
}
