package net.salesianos.ficheros.actividades.actividadCuatro;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MesaService {

    private static final String NOMBRE_FICHERO = "mesas.dat";

    public static void guardarMesaEnFichero(Mesa mesa) {
        boolean ficheroExiste = new File(NOMBRE_FICHERO).exists();

        try (ObjectOutputStream oos = ficheroExiste
                ? new AppendableObjectOutputStream(new FileOutputStream(NOMBRE_FICHERO, true))
                : new ObjectOutputStream(new FileOutputStream(NOMBRE_FICHERO))) {
            oos.writeObject(mesa);
        } catch (IOException e) {
            System.err.println("Error al guardar la mesa: " + e.getMessage());
        }
    }

    public static List<Mesa> obtenerMesasDelFichero() {
        List<Mesa> mesas = new ArrayList<>();
        File fichero = new File(NOMBRE_FICHERO);

        if (!fichero.exists()) {
            return mesas;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
            while (true) {
                Mesa mesa = (Mesa) ois.readObject();
                mesas.add(mesa);
            }
        } catch (EOFException e) {
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer mesas: " + e.getMessage());
        }

        return mesas;
    }

    private static class AppendableObjectOutputStream extends ObjectOutputStream {

        public AppendableObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException {
            reset();
        }
    }
}
