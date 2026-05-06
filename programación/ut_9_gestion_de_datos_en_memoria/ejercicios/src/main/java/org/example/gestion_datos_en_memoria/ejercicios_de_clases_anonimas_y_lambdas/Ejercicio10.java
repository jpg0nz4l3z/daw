package org.example.gestion_datos_en_memoria.ejercicios_de_clases_anonimas_y_lambdas;

interface OperacionArray {
    int procesar(int[] array);
}

public class Ejercicio10 {

    public static void main(String[] args) {

        // Lambda para sumar todos los elementos
        OperacionArray suma = (array) -> {
            int total = 0;
            for (int num : array) {
                total += num;
            }
            return total;
        };

        // Lambda para contar números pares
        OperacionArray contarPares = (array) -> {
            int contador = 0;
            for (int num : array) {
                if (num % 2 == 0) {
                    contador++;
                }
            }
            return contador;
        };

        // Arrays de prueba
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {10, 15, 20, 25, 30};

        // Pruebas
        System.out.println("Array1 suma: " + suma.procesar(array1));
        System.out.println("Array1 pares: " + contarPares.procesar(array1));

        System.out.println("Array2 suma: " + suma.procesar(array2));
        System.out.println("Array2 pares: " + contarPares.procesar(array2));
    }
}