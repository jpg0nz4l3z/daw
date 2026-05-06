package org.example.gestion_datos_en_memoria.ejercicios_de_clases_anonimas_y_lambdas;

interface OperacionFactorial {
    long calcular(int n);
}

public class Ejercicio3 {

    public static void main(String[] args) {

        // Lambda para calcular el factorial
        OperacionFactorial factorial = (n) -> {
            long resultado = 1;
            for (int i = 1; i <= n; i++) {
                resultado *= i;
            }
            return resultado;
        };

        // Pruebas
        System.out.println("Factorial de 5: " + factorial.calcular(5));
        System.out.println("Factorial de 7: " + factorial.calcular(7));
        System.out.println("Factorial de 10: " + factorial.calcular(10));
    }
}
