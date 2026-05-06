package org.example.ejercicios_ficheros;

import java.io.File;
import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce la ruta del directorio: ");
        String ruta = sc.nextLine().trim();

        File dir = new File(ruta);

        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("❌ El directorio no existe o no es un directorio.");
            return;
        }

        File[] archivos = dir.listFiles();
        if (archivos == null || archivos.length == 0) {
            System.out.println("Directorio vacío.");
            return;
        }

        System.out.println("\nContenido de " + dir.getAbsolutePath() + ":");
        for (File f : archivos) {
            System.out.println((f.isDirectory() ? "[DIR] " : "[FILE] ") + f.getName());
        }
    }
}
