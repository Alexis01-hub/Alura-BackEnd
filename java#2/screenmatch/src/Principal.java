import com.aluracurso.screenmatch.calculos.CalculadoraTiempo;
import com.aluracurso.screenmatch.calculos.FiltroRecomendacion;
import com.aluracurso.screenmatch.modelos.Episodio;
import com.aluracurso.screenmatch.modelos.Pelicula;
import com.aluracurso.screenmatch.modelos.Serie;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula();
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese el nombre de la pelicula:");
        miPelicula.setNombre(teclado.nextLine());
        System.out.println("Ingrese el año de lanzamiento:");
        miPelicula.setFechaLanzamiento(teclado.nextInt());
        System.out.println("Ingrese la duracion en minutos:");
        miPelicula.setDuracionMinutos(teclado.nextInt());

        miPelicula.mostrarInformacion();
        miPelicula.evalua(7);
        miPelicula.evalua(8.5);
        miPelicula.evalua(10);
        System.out.println("La media de las evaluaciones es: " + miPelicula.calculoMedia());


        Serie miSerie = new Serie();
        miSerie.setNombre("The Witcher");
        miSerie.setTemporadas(3);
        miSerie.setEpisodiosPorTemporada(8);
        miSerie.setMinutosPorEpisodio(60);
        miSerie.mostrarInformacion();
        System.out.println(miSerie.getDuracionMinutos());

        CalculadoraTiempo calculadora = new CalculadoraTiempo();
        calculadora.incluye(miPelicula);
        System.out.println(calculadora.getTiempoTotal());
        calculadora.incluye(miSerie);
        System.out.println(calculadora.getTiempoTotal());

        FiltroRecomendacion filtro = new FiltroRecomendacion();
        filtro.filtrar(miPelicula);

        Episodio episodio = new Episodio();
        episodio.setNombre("The End's Beginning");
        episodio.setNumero(1);
        episodio.setSerie(miSerie);
        episodio.setTotalVisualizaciones(20);
        filtro.filtrar(episodio);
        teclado.close();
    }
}
