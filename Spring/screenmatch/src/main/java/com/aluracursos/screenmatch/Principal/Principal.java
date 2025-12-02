package com.aluracursos.screenmatch.Principal;

import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.model.DatosTemporadas;
import com.aluracursos.screenmatch.model.Episodio;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

    public class Principal {
    private Scanner scanner = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL_BASE = "http://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=449f5547";
    private ConvierteDatos conversor = new ConvierteDatos();

    public void muestraMenu(){
        System.out.println("Porfavor escribe el nombre de la serie:");
        //busca datos generales de la serie
        var nombreSerie = scanner.nextLine();
        var json = consumoAPI.obtenerDatos(URL_BASE+nombreSerie.replace(" ","+")+API_KEY);
        var datos = conversor.obtenerDatos(json, DatosSerie.class);
        System.out.println(datos);

        //busca dostos de todas las temporadas
        List<DatosTemporadas> temporadas = new ArrayList<>();
        for (int i = 1; i <= datos.totalTemporadas() ; i++) {
            json = consumoAPI.obtenerDatos(URL_BASE+nombreSerie.replace(" ","+")+"&Season="+ i +API_KEY);
            var datosTemporadas = conversor.obtenerDatos(json, DatosTemporadas.class);
            temporadas.add(datosTemporadas);
        }
        //temporadas.forEach(System.out::println);
        //mostrar  solo el titulo de los episodios de cada temporada
       /* for (int i = 0; i < datos.totalTemporadas(); i++) {
            List<DatosEpisodio> episodiosTemporadas = temporadas.get(i).episodios(); // obtener la lista de episodios de la temporada i
            for (int j = 0; j < episodiosTemporadas.size(); j++) {
                System.out.println(episodiosTemporadas.get(j).titulo()); // mostrar el título del episodio j de la temporada i
            }
        }

        */
        temporadas.forEach(t -> t.episodios().forEach(ep -> System.out.println(ep.titulo())));

    /*
        //convertir todas las informaciones a  una lista tipo DatosEpisodio
        System.out.println("top 5 ep!!!!!!");
        List<DatosEpisodio> datosEpisodios = temporadas.stream().flatMap(t -> t.episodios().stream()).collect(Collectors.toList());
        datosEpisodios.stream()
                .filter(e -> !e.evaluacion().equalsIgnoreCase("N/A"))
                .peek(e -> System.out.println("primer filtro N/A "+ e))
                .sorted(Comparator.comparing(DatosEpisodio::evaluacion).reversed())
                .peek(e -> System.out.println("segundo filtro ordenacion (M>m) "+ e))
                .map(e -> e.titulo().toUpperCase())
                .peek(e -> System.out.println("tercer filtro mayuscula (m>M) "+ e))
                .limit(5)
                .forEach(System.out::println); // mostrar los episodios ordenados por evaluación de mayor a menor
    */



        //convirtiendo los datos a episodios
        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                    .map(d -> new Episodio(t.numero(), d)))
                .collect(Collectors.toList());
        //episodios.forEach(System.out::println);

        // busqueda de episodios a partir de x años
       // System.out.println("---- episodio por fecha de lanzamiento ----");
        // System.out.println("ingresa el año de lanzamiento a partir del cual deseas ver los episodios:");
        //var fechaInput = scanner.nextInt();
        //scanner.nextLine(); //

       // LocalDate fechaBusqueda = LocalDate.of(fechaInput, 1 , 1);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Define el formato esperado dia-mes-año
    /*
        episodios.stream()
                .filter(e -> e.getFechaDeLanzamiento() != null && e.getFechaDeLanzamiento().isAfter(fechaBusqueda))
                .forEach(e -> System.out.println(
                        "temporada "+e.getTemporada()+" Episodio "+e.getTitulo()+" Fecha de lanzamiento: "+e.getFechaDeLanzamiento().format(formatter)));
    */
        //busqueda episodios  por pedazos del titulo
        /*
        System.out.println("ingresa el titulo del episodio");
        var pedazoTitulo = scanner.nextLine();
        Optional<Episodio> episodioBuscado = episodios.stream()
                .filter(e -> e.getTitulo().toUpperCase().contains(pedazoTitulo.toUpperCase()))
                .findFirst();
        if (episodioBuscado.isPresent()) {
            System.out.println("episodio encontrado");
            System.out.println("los datos son: "+ episodioBuscado.get());
        }else {
            System.out.println("episodio no encontrado");
        }
        */

        Map<Integer, Double> evaluacionesPorTemporada = episodios.stream()
                .filter(e -> e.getEvaluacion() > 0.0) // Filtrar episodios con evaluación válida
                .collect(Collectors.groupingBy(Episodio::getTemporada, Collectors.averagingDouble(Episodio::getEvaluacion)));
        System.out.println(evaluacionesPorTemporada);

        DoubleSummaryStatistics est= episodios.stream()
                .filter(e -> e.getEvaluacion() > 0.0)
                .collect(Collectors.summarizingDouble(Episodio::getEvaluacion));
        System.out.println("Media de evaluaciones: " + est.getAverage());
        System.out.println("Maxima evaluacion: " + est.getMax());
        System.out.println("Minima evaluacion: " + est.getMin());

    }
}
