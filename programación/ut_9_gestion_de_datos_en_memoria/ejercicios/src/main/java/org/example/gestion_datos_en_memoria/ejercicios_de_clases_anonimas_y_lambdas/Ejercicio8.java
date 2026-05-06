package org.example.gestion_datos_en_memoria.ejercicios_de_clases_anonimas_y_lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Ejercicio8 {

    public static void main(String[] args) {

        // Lista de números
        List<Integer> numeros = new ArrayList<>();
        numeros.add(5);
        numeros.add(12);
        numeros.add(7);
        numeros.add(20);
        numeros.add(3);
        numeros.add(15);

        // Número mayor
        int max = numeros.stream()
                .max((a, b) -> a.compareTo(b))
                .orElse(0);

        // Número menor
        int min = numeros.stream()
                .min((a, b) -> a.compareTo(b))
                .orElse(0);

        // Media
        OptionalDouble mediaOpt = numeros.stream()
                .mapToInt(n -> n)
                .average();

        double media = mediaOpt.orElse(0);

        // Mostrar resultados
        System.out.println("Lista: " + numeros);
        System.out.println("Mayor: " + max);
        System.out.println("Menor: " + min);
        System.out.println("Media: " + media);
    }
}