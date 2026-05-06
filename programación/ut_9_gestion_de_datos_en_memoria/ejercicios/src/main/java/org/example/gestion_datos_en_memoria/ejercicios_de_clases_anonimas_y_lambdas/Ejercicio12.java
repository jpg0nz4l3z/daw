package org.example.gestion_datos_en_memoria.ejercicios_de_clases_anonimas_y_lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Ejercicio12 {

    public static void main(String[] args) {

        // Lista de números
        List<Integer> numeros = new ArrayList<>();
        numeros.add(5);
        numeros.add(10);
        numeros.add(3);
        numeros.add(20);
        numeros.add(7);

        // Suma de todos los números
        int suma = numeros.stream()
                .reduce(0, (a, b) -> a + b);

        // Número más grande
        Optional<Integer> maxOpt = numeros.stream()
                .reduce((a, b) -> a > b ? a : b);

        int max = maxOpt.orElse(0);

        // Mostrar resultados
        System.out.println("Lista: " + numeros);
        System.out.println("Suma total: " + suma);
        System.out.println("Número más grande: " + max);
    }
}