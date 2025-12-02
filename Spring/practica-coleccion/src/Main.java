import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        /*
        List<String> empleados = new ArrayList<>();
        empleados.add("juan");
        empleados.add("lucas");
        empleados.add("pedro");
        empleados.add("antonio");
        System.out.println("Lista inicial: "+empleados);

        empleados.remove("pedro");

        System.out.println("Lista despues de eliminar a pedro: "+empleados);

        System.out.println("-----------------------");
        System.out.println("la degunda peros de la lista es: "+empleados.get(1));
        System.out.println("el tamaño de la lista es: "+empleados.size());

        System.out.println("----------------------");

        List<String> eventos = new ArrayList<>();
        eventos.add("IA Conference");

        eventos.add("AI Summit");

        eventos.add("DevFest");

        eventos.add("Cloud Expo");

        eventos.add("IA Conference");

        Set<String> eventosSet = new HashSet<>(eventos);
        System.out.println("Eventos sin duplicados: " + eventosSet);

        System.out.println("----------------------");
        Map<Integer, String> clientesMap = new HashMap<>();
        clientesMap.put(1, "Carlos");
        clientesMap.put(2, "Ana");
        clientesMap.put(3, "Luis");
        clientesMap.put(4, "Pedro");
        clientesMap.put(5, "Juan");

        int idCliente = 7;
        System.out.println("conbre del cliente con ID 2: " + clientesMap.get(2));

        if (clientesMap.containsKey(idCliente)) {
            System.out.println("El cliente con ID " + idCliente + " es: " + clientesMap.get(idCliente));
        } else {
            System.out.println("Cliente con ID " + idCliente + " no encontrado.");
        }
        */
        /*List<String> empleados = new ArrayList<>();
        empleados.add("juan");
        empleados.add("pedro");
        empleados.add("maria");
        System.out.println(empleados.get(0)); */

        /*Set<String> productos = new HashSet<String>();
        productos.add("papa");
        productos.add("agua");
        productos.add("tele");
        System.out.println(productos);
        */

        /* Map<Integer,String> empleados = new HashMap<>();
        empleados.put(1, "juan");
        empleados.put(2, "pedro");
        empleados.put(3, "maria");
        System.out.println(empleados); */

        //------------------ streams ------------------

        List<String> empleados = new ArrayList<>();
        empleados.add("ana");
        empleados.add("bruno");
        empleados.add("carlos");
        empleados.add("amanda");
        empleados.add("alice");
        empleados.add("daniel");
        //filtar nombres con 5 o menos letras
        List<String> resultado = empleados.stream()
                .filter(nombre -> nombre.length() <= 5)
                .collect(Collectors.toList());
        System.out.println("Nombres con 5 o menos letras: " + resultado);

        List<Integer> numeros = List.of(2, 3, 5, 7, 11);
        //elevar al cuadrado cada numero
        List<Integer> cuadrados = numeros.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Números al cuadrado: " + cuadrados);

        List<Double> preciosProductos = List.of(29.99, 49.50, 15.75, 99.99);

        //calcular el precio total
        double precioTotal = preciosProductos.stream()
                .reduce(0.0, Double::sum);
        double impuesto = precioTotal * 0.08;
        double totalConImpuesto = precioTotal + impuesto;
        System.out.println("Precio total con impuesto: " + totalConImpuesto);
        System.out.println("Precio total sin impuesto: " + precioTotal);

        // lista notas
        List<Double> notas = List.of(7.5, 8.0, 6.5, 9.0, 10.0);
        // Suma usando reduce()
        double suma = notas.stream()
                .reduce(0.0, Double::sum);

        // Media
        double media =  suma / notas.size();

        double maxima = notas.stream()
                .max(Double::compare).get();

        double minima = notas.stream()
                .min(Double::compare).get();

        System.out.println("Suma de notas: " + suma);
        System.out.println("Media de notas: " + media);
        System.out.println("Nota máxima: " + maxima);
        System.out.println("Nota mínima: " + minima);




    }
}
