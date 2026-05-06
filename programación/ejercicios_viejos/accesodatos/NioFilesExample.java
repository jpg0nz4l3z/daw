package accesodatos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class NioFilesExample {
    public static void main(String[] args) {
        Path filePath = Paths.get("archivo.txt");

        escribirEnArchivo(filePath);
        leerDesdeArchivo(filePath);

        try (FileOutputStream fos = new FileOutputStream("datos.bin")) {
            fos.write(65);   // escribe un byte
            fos.write(66);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void escribirEnArchivo(Path filePath) {
        List<String> lineas = List.of(
                "Hola, este es un archivo creado con java.nio.file.",
                "Segunda línea del archivo.",
                "Tercera línea con más contenido."
        );

        try {
            Files.write(filePath, lineas, StandardCharsets.UTF_8);

            System.out.println("Datos escritos correctamente en el archivo.");
        } catch (
                IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static void leerDesdeArchivo(Path filePath) {
        try {
            List<String> lineas = Files.readAllLines(filePath,
                    StandardCharsets.UTF_8);
            System.out.println("\nContenido del archivo:");
            for (String linea : lineas) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: "
                    + e.getMessage());
        }
    }
}
