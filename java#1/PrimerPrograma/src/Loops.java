import java.util.Scanner;

public class Loops {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double total = 0;
        double mediaEvaluaciones = 0;

        for (int i = 0; i < 3 ; i++) {
            System.out.println("escribe la nota de:");
            total = scanner.nextDouble();
            mediaEvaluaciones = total + mediaEvaluaciones;
        }

        System.out.println(mediaEvaluaciones / 3);
        scanner.close();
    }
}
