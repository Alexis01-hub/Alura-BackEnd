import com.aluracurso.desafio.modelo.Canciones;
import com.aluracurso.desafio.modelo.MisFavoritos;
import com.aluracurso.desafio.modelo.Podcast;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Canciones cancion1 = new Canciones();
        cancion1.setTitulo("Song 1");
        cancion1.setArtista("Artist 1");

        Podcast podcast1 = new Podcast();
        podcast1.setTitulo("Podcast 1");
        podcast1.setCreador("Creator 1");

        for (int i = 0; i < 100; i++) {
            cancion1.meGusta();
        }

        for (int i = 0; i < 5000 ; i++) {
            cancion1.reproducir();
        }

        System.out.println(cancion1.getTotalDeReproducciones());
        System.out.println(cancion1.getMeGusta());

        MisFavoritos favoritos = new MisFavoritos();
        favoritos.adicione(cancion1);
    }
}

