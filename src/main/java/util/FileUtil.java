package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    // Escribe una sola línea al archivo, añadiéndola al final del archivo existente.
    public static void escribirLinea(String rutaArchivo, String linea) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            bw.write(linea);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Lee todo el contenido de un archivo y lo devuelve como una lista de líneas.
    public static List<String> leerArchivo(String rutaArchivo) {
        List<String> lineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineas;
    }

    // Reescribe el archivo completo con las líneas proporcionadas.
    public static void reescribirArchivo(String rutaArchivo, List<String> lineas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (String linea : lineas) {
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método añadido para escribir directamente un texto completo al archivo.
    public static void writeToFile(String rutaArchivo, String contenido) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            bw.write(contenido);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Añadir contenido al final del archivo existente.
    public static void appendToFile(String rutaArchivo, String contenido) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            bw.write(contenido);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Verifica si un archivo existe; si no, lo crea.
    public static File getOrCreateFile(String rutaArchivo) {
        File file = new File(rutaArchivo);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
