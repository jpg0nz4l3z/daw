package org.example.gestion_datos_en_memoria.ejercicios_de_clases_anonimas_y_lambdas;

interface Operacion {
    double calcular(double a, double b);
}

public class Ejercicio1 {

    public static void main(String[] args) {

        // Clase anónima para potencia
        Operacion potencia = new Operacion() {
            @Override
            public double calcular(double a, double b) {
                return Math.pow(a, b);
            }
        };

        // Clase anónima para módulo
        Operacion modulo = new Operacion() {
            @Override
            public double calcular(double a, double b) {
                return a % b;
            }
        };

        // Clase anónima para máximo
        Operacion maximo = new Operacion() {
            @Override
            public double calcular(double a, double b) {
                return Math.max(a, b);
            }
        };

        // Pruebas
        System.out.println("Potencia (2^3): " + potencia.calcular(2, 3));
        System.out.println("Módulo (10 % 3): " + modulo.calcular(10, 3));
        System.out.println("Máximo (7, 9): " + maximo.calcular(7, 9));
    }
}