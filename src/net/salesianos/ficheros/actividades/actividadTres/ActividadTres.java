package net.salesianos.ficheros.actividades.actividadTres;
import java.io.*;

public class ActividadTres {

    public static void main(String[] args) {
        try (
                BufferedReader r1 = new BufferedReader(new FileReader("textoUno.txt")); BufferedReader r2 = new BufferedReader(new FileReader("fichero.txt")); BufferedWriter writer = new BufferedWriter(new FileWriter("fusion.txt"))) {
            writer.write("Contenido del textoUno");
            writer.newLine();
            String linea;
            while ((linea = r1.readLine()) != null) {
                writer.write(linea);
                writer.newLine();
            }
            writer.write("contenido del fichero");
            writer.newLine();
            while ((linea = r2.readLine()) != null) {
                writer.write(linea);
                writer.newLine();
            }
            writer.write("Realizamos la fusion del programa");
            writer.newLine();
            System.out.println("Fusion creada y llamada fusion.txt");
        } catch (IOException e) {
            System.out.println("Error al procesar los ficheros: " + e.getMessage());
        }
    }
}
