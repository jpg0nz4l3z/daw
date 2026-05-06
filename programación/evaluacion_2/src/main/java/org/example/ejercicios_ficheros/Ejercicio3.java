package org.example.ejercicios_ficheros;

import java.io.*;

public class Ejercicio3 {
    public static void main(String[] args) {
        int contador = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("notas.txt"))) {

            //new FileWriter("archivo.txt", true); true concatena, false sobreescribe

            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();

                if (!linea.isEmpty()) {
                    contador += linea.split("\\s+").length;
                }
            }

        } catch (IOException e) {
            System.err.println("Error de E/S: " + e.getMessage());
        }

        System.out.println("Contador: " + contador);
    }
}
