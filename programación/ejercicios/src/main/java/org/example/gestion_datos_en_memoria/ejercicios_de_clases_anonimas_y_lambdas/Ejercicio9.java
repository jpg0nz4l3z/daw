package org.example.gestion_datos_en_memoria.ejercicios_de_clases_anonimas_y_lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio9 {

    public static void main(String[] args) {

        // Lista de palabras
        List<String> palabras = new ArrayList<>();
        palabras.add("Java");
        palabras.add("Lambda");
        palabras.add("Stream");
        palabras.add("API");
        palabras.add("Código");

        // Concatenar palabras separadas por coma
        String resultado = palabras.stream()
                .collect(Collectors.joining(", "));

        // Mostrar resultado
        System.out.println("Lista: " + palabras);
        System.out.println("Cadena concatenada: " + resultado);
    }
}