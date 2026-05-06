package org.example.ejercicios_ficheros;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio4 {
    static void main() {
        Path ruta = Paths.get("config.txt");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de lineas a escribir");
        int cantidadLineas = 0;


        do {
            try {
                cantidadLineas = scanner.nextInt();

                if (cantidadLineas <= 0) {
                    System.out.println("El número debe ser mayor que 0");
                }

            } catch (InputMismatchException e) {
                System.out.println("Introduce un valor numérico válido");
                scanner.nextLine();
            }

        } while (cantidadLineas <= 0);

        scanner.nextLine();

        try {
            Files.writeString(
                    ruta,
                    "",
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING
            );


            for (int i = 0; i < cantidadLineas; i++) {
                String texto = scanner.nextLine();
                Files.writeString(
                        ruta,
                        texto + System.lineSeparator(),
                        StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND
                );

            }

            System.out.println("\nContenido del archivo:");
            for (String l : Files.readAllLines(ruta)) {
                System.out.println(l);
            }

            System.out.println("jejejejej\n");

            System.out.println(Files.readString(ruta));

        } catch (IOException e) {
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }
}
