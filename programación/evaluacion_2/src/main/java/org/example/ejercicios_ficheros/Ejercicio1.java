package org.example.ejercicios_ficheros;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        //JAVA IO

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

        try (FileWriter writer = new FileWriter("notas.txt")) {
            for (int i = 0; i < cantidadLineas; i++) {
                System.out.println("Escriba el contenido de la linea " + (i+1));
                writer.write(scanner.nextLine() + "\n");
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        try (FileReader reader = new FileReader("notas.txt")) {
            int c;
            System.out.println("\nContenido del archivo: \n");

            //devuelve -1 al llegar al final del archivo
            //lee y escribe por carácter
            //Guarda en bytes
            //read.read() devuelve el carácter ascii
            while ((c = reader.read()) != -1) {
                //System.out.println("lo que devuelve c = " + c);
                System.out.print((char) c);
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
