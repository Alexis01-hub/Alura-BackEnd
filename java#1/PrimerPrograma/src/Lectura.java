import java.util.Scanner;

public class Lectura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la película:");
        String nombrePelicula = scanner.nextLine();
        System.out.println("Ahora escribe la fecha de lanzamiento:");
        int fechaDeLanzamiento = scanner.nextInt();
        System.out.println("ahora danos la nota de esta pelicula:");
        double calificacion = scanner.nextDouble();

        System.out.println("La película es: " + nombrePelicula);
        System.out.println("Fecha de lanzamiento: " + fechaDeLanzamiento);
        System.out.println("Calificación: " + calificacion);
        scanner.close();
    }
}
