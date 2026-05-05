package org.example.gestion_datos_en_memoria.ejercicios_de_clases_anonimas_y_lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio2 {

    public static void main(String[] args) {

        // Lista de números
        List<Integer> numeros = new ArrayList<>();
        numeros.add(3);
        numeros.add(7);
        numeros.add(10);
        numeros.add(15);
        numeros.add(20);
        numeros.add(25);

        // Filtrar números impares
        List<Integer> impares = numeros.stream()
                .filter(n -> n % 2 != 0)
                .collect(Collectors.toList());

        // Filtrar números mayores de 10
        List<Integer> mayoresDe10 = numeros.stream()
                .filter(n -> n > 10)
                .collect(Collectors.toList());

        // Mostrar resultados
        System.out.println("Lista original: " + numeros);
        System.out.println("Números impares: " + impares);
        System.out.println("Números mayores de 10: " + mayoresDe10);
    }
}