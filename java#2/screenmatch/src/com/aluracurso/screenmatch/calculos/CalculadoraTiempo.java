package com.aluracurso.screenmatch.calculos;

import com.aluracurso.screenmatch.modelos.Pelicula;
import com.aluracurso.screenmatch.modelos.Serie;
import com.aluracurso.screenmatch.modelos.Titulo;

public class CalculadoraTiempo {
    private int tiempoTotal;

    public int getTiempoTotal() {
        return tiempoTotal;
    }

    public void incluye(Titulo titulo){
        tiempoTotal += titulo.getDuracionMinutos();
    }
}