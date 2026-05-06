package org.example.ejercicios_ficheros;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre del archivo a crear (ej: prueba.txt): ");
        String nombre = sc.nextLine().trim();

        if (nombre.isEmpty()) {
            System.out.println("Nombre vacío.");
            return;
        }

        File file = new File(nombre);

        try {
            if (file.exists()) {
                System.out.println("El archivo ya existe: " + file.getAbsolutePath());
            } else {
                boolean creado = file.createNewFile();
                System.out.println(creado
                        ? "✅ Archivo creado: " + file.getAbsolutePath()
                        : "No se pudo crear el archivo.");
            }
        } catch (IOException e) {
            System.out.println("Error creando archivo: " + e.getMessage());
            return;
        }

        System.out.print("¿Deseas eliminarlo? (s/n): ");
        String resp = sc.nextLine().trim().toLowerCase();

        if (resp.equals("s") || resp.equals("si") || resp.equals("sí")) {
            boolean borrado = file.delete();
            System.out.println(borrado ? "🗑️ Archivo eliminado." : "No se pudo eliminar.");
        } else {
            System.out.println("Archivo conservado.");
        }
    }
}
