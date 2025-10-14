package com.alura.screenmatch.principal;

import com.alura.screenmatch.modelos.Pelicula;
import com.alura.screenmatch.modelos.Serie;
import com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;

public class PrincipalConListas {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Encanto",2021);
        miPelicula.evalua(9);
        Serie lost = new Serie("Lost",2000);
        Pelicula otraPelicula = new Pelicula("Avatar",2023);
        otraPelicula.evalua(6);
        var peliculaDeBruno = new Pelicula("El viaje de Chihiro",2001); // inferencia de tipo de dato
        peliculaDeBruno.evalua(10);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(peliculaDeBruno);
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(lost);

        for(Titulo item : lista) {
            System.out.println("Nombre: " +item.getNombre());
            if (item instanceof Pelicula pelicula && pelicula.getClasificacion() > 2) {
                System.out.println("Clasificacion: " + pelicula.getClasificacion());
            }
        }

        ArrayList<String> listaArtistas = new ArrayList<>();
        listaArtistas.add("Bruno Mars");
        listaArtistas.add("Adele");
        System.out.println(listaArtistas);

        Collections.sort(listaArtistas);
        System.out.println(listaArtistas);

        Collections.sort(lista);
        System.out.println("Después de ordenar");
        System.out.println(lista);
    }
}
