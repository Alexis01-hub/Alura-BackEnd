public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido al Screen Match");
        System.out.println("Pelicula: Matriz");

        int fechaDeLanzamiento = 1999;
        boolean incluidoEnElPlan = true;
        double calificacion = 8.7;

        double media = (8.7 + 9.0 + 5.0) / 3;
        System.out.println("Media: " + media);

        String sinopsis = "Una computadora hacker descubre la verdadera naturaleza de su realidad y su papel en la guerra contra sus controladores.";
        System.out.println(sinopsis);

        int calificacionEntero = (int) (media / 2);
        System.out.println("Calificacion: " + calificacionEntero);
    }
}
