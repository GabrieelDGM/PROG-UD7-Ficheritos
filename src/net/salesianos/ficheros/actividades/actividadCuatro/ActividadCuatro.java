package net.salesianos.ficheros.actividades.actividadCuatro;

import java.util.List;
import java.util.Scanner;

public class ActividadCuatro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("====MESAS====");
            System.out.println("1. Nueva mesa");
            System.out.println("2. Mostrar mesas");
            System.out.println("3. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Dime un color para la mesa:");
                    String color = scanner.nextLine();
                    System.out.println("Dime el número de patas de la mesa:");
                    int numeroPatas = scanner.nextInt();
                    scanner.nextLine();

                    Mesa mesa = new Mesa(color, numeroPatas);
                    MesaService.guardarMesaEnFichero(mesa);
                    System.out.println("Mesa añadida correctamente.");
                }
                case 2 -> {
                    System.out.println("Mostrando mesas guardadas:");
                    List<Mesa> mesas = MesaService.obtenerMesasDelFichero();
                    for (Mesa m : mesas) {
                        System.out.println(m);
                    }
                }
                case 3 ->
                    System.out.println("Saliendo...");
                default ->
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
    }
}
