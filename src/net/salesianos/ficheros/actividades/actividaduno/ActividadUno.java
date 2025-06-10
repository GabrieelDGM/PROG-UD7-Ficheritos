package net.salesianos.ficheros.actividades.actividaduno;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ActividadUno {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String texto;

        do {
            System.out.print("Introduce un texto que al menos tenga 30 caracteres: ");
            texto = scanner.nextLine();
            if (texto.length() < 30) {
                System.out.println("El texto debe tener 30 caracteres obligatorios");
            }
        } while (texto.length() < 30);

        String textoFormateado = texto.toUpperCase().replace(" ", "_");
        try (FileWriter writer = new FileWriter("textoUno.txt")) {
            writer.write(textoFormateado);
            System.out.println("Texto guardado en textoUno.txt");
        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
