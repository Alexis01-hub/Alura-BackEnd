import javax.imageio.plugins.tiff.TIFFDirectory;

public class Decisiones {
    public static void main(String[] args ){
        int fechaDeLanzamiento = 1999;
        boolean incluidoEnElPlan = true;
        double calificacion = 8.7;
        String plan = "plus";
        if (fechaDeLanzamiento < 2000){
            System.out.println("Película clásica");
        } else {
            System.out.println("Película moderna");
        }
        if (incluidoEnElPlan && plan.equals("plus")){
            System.out.println("Puedes ver la película");
        } else {
            System.out.println("Debes mejorar tu plan para ver la película");
        }
    }
}
