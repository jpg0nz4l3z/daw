package org.example.gestion_datos_en_memoria.ejercicios_de_clases_anonimas_y_lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio7 {

    public static void main(String[] args) {

        // Lista de números
        List<Integer> numeros = new ArrayList<>();
        numeros.add(4);
        numeros.add(9);
        numeros.add(16);
        numeros.add(25);
        numeros.add(36);

        // Duplicar cada número
        List<Integer> duplicados = numeros.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());

        // Obtener la raíz cuadrada de cada número
        List<Double> raices = numeros.stream()
                .map(n -> Math.sqrt(n))
                .collect(Collectors.toList());

        // Mostrar resultados
        System.out.println("Lista original: " + numeros);
        System.out.println("Números duplicados: " + duplicados);
        System.out.println("Raíces cuadradas: " + raices);
    }
}