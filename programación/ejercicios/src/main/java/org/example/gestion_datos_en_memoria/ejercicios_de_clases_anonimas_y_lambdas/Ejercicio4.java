package org.example.gestion_datos_en_memoria.ejercicios_de_clases_anonimas_y_lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio4 {

    public static void main(String[] args) {

        // Lista de palabras
        List<String> palabras = new ArrayList<>();
        palabras.add("hola");
        palabras.add("mundo");
        palabras.add("java");
        palabras.add("lambda");

        // Convertir a mayúsculas
        List<String> mayusculas = palabras.stream()
                .map(p -> p.toUpperCase())
                .collect(Collectors.toList());

        // Invertir cada palabra
        List<String> invertidas = palabras.stream()
                .map(p -> new StringBuilder(p).reverse().toString())
                .collect(Collectors.toList());

        // Mostrar resultados
        System.out.println("Lista original: " + palabras);
        System.out.println("En mayúsculas: " + mayusculas);
        System.out.println("Invertidas: " + invertidas);
    }
}