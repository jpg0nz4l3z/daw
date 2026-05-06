package org.example.ejercicios_ficheros;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Path ruta = Paths.get("documento.txt");

        if (!Files.exists(ruta)) {
            System.out.println("No existe: " + ruta.toAbsolutePath());
            return;
        }

        System.out.print("Introduce la palabra a buscar: ");
        String palabra = sc.nextLine().trim();
        if (palabra.isEmpty()) {
            System.out.println("Palabra vacía. Fin.");
            return;
        }

        try {
            String texto = Files.readString(ruta);

            // \b para palabra completa; Pattern.quote para escapar caracteres raros
            Pattern p = Pattern.compile("\\b" + Pattern.quote(palabra) + "\\b", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
            Matcher m = p.matcher(texto);

            int count = 0;
            while (m.find()) count++;

            System.out.println("La palabra \"" + palabra + "\" aparece " + count + " veces.");

        } catch (IOException e) {
            System.out.println("Error I/O: " + e.getMessage());
        }
    }
}
