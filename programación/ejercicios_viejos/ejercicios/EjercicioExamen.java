package ejercicios;

import java.util.Scanner;

public class EjercicioExamen {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la altura de los elementos (>=3) : ");
        int alturaElementos = scanner.nextInt();

        System.out.println("Introduce el número de elementos: ");
        int numeroElementos = scanner.nextInt();

        System.out.println("Introduce la altura de la base: ");
        int alturaBase = scanner.nextInt();

        if (alturaElementos < 3) {
            System.out.println("La altura de cada elementos debe ser <= 3");
            return;
        }

        dibujarElementos(alturaElementos, numeroElementos);
        dibujarBase(numeroElementos * ((2 * alturaElementos) - 1), alturaBase);


    }

    private static void dibujarElementos(int altura, int numero) {
        for (int t = 0; t < numero; t++) {
            for (int j = 0; j < altura - 1; j++) {
                System.out.print(" ");
            }
            System.out.print("+");
            for (int j = 0; j < altura; j++) {
                System.out.print(" ");
            }
        }
        System.out.println();
        for (int t = 0; t < altura; t++) {
            for (int j = 0; j < numero; j++) {
                for (int l = 0; l < altura - t - 1; l++) {
                    System.out.print(" ");
                }
                for (int l = 0; l < (2 * t) + 1; l++) {
                    System.out.print("*");
                }
                for (int l = 0; l < altura - t; l++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static void dibujarBase(int alturaElementos, int numeroElementos) {
    }
}
