import java.util.Scanner;

public class desafio {
    public static void main(String[] args) {
        double saldo = 1000.00;
        String nombreCliente;
        String tipoCuenta;
        Boolean continuar = true;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su nombre:");
        nombreCliente = scanner.nextLine();
        System.out.println("Ingrese el tipo de cuenta (Ahorros/Corriente):");
        tipoCuenta = scanner.nextLine();

        System.out.println("************************************");
        System.out.println("Cliente: " + nombreCliente);
        System.out.println("Tipo de cuenta: " + tipoCuenta);
        System.out.println("Saldo inicial: $" + saldo);
        System.out.println("************************************");

        while (continuar){
            System.out.println("Seleccione una opción:");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Depositar dinero");
            System.out.println("4. Salir");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Su saldo actual es: $" + saldo);
                    break;
                case 2:
                    System.out.println("Ingrese la cantidad a retirar:");
                    double retiro = scanner.nextDouble();
                    if (retiro > saldo) {
                        System.out.println("Fondos insuficientes.");
                    } else {
                        saldo -= retiro;
                        System.out.println("Retiro exitoso. Nuevo saldo: $" + saldo);
                    }
                    break;
                case 3:
                    System.out.println("Ingrese la cantidad a depositar:");
                    double deposito = scanner.nextDouble();
                    saldo += deposito;
                    System.out.println("Depósito exitoso. Nuevo saldo: $" + saldo);
                    break;
                case 4:
                    continuar = false;
                    System.out.println("Gracias por usar el sistema bancario. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
            System.out.println("------------------------------------");


        }
        scanner.close();


    }
}
