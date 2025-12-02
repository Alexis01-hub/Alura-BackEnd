package com.aluracursos.screenmatch.Principal;

import java.util.Arrays;
import java.util.List;

public class EjemploStreams {
    public void ejemplo() {
        List<String> nombres = Arrays.asList("Juan", "Maria", "Pedro", "Rodriguez");

        nombres.stream().sorted().forEach(System.out::println);
    }
}
