package net.salesianos.ficheros.actividades.actividadDos;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ActividadDos {

    public static void main(String[] args) {
        String fichero = "fichero.txt";

        try (FileWriter writer = new FileWriter(fichero)) {
            writer.write("Hola aqui estoy realizando la actividad de fichero para mi profesor Adrian SIIIIU");
        } catch (IOException e) {
            System.out.println("Error al escribir el fichero: " + e.getMessage());
            return;
        }

        try (FileReader reader = new FileReader(fichero)) {
            int caracter;
            while ((caracter = reader.read()) != -1) {
                System.out.print((char) caracter);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
    }
}
