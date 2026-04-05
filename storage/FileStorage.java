package storage;

import java.io.*;

public class FileStorage {

    // Metodo para guardar cualquier objeto (en nuestro caso, el servicio completo)
    public static void saveData(Object data, String fileName) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(data);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    // Metodo para cargar los datos al iniciar
    public static Object loadData(String fileName) {
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Object data = in.readObject();
            in.close();
            fileIn.close();
            return data;
        } catch (IOException | ClassNotFoundException e) {
            // Si el archivo no existe, retornamos null para empezar de cero
            return null;
        }
    }
}