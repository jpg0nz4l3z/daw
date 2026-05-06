package org.example.ejercicios_ficheros;

import java.io.*;

public class Ejercicio2 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("notas.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("salida.txt", true))) {

            //new FileWriter("archivo.txt", true); true concatena, false sobreescribe

            String linea;
            while ((linea = br.readLine()) != null) {
                bw.write(linea);
                bw.newLine();
            }

        } catch (IOException e) {
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }
}
