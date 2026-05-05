package org.example.gestion_datos_en_memoria.ejercicios_de_colecciones;

import java.util.HashSet;
import java.util.Set;

public class Ejercicio4 {

    // Mostrar diferencias
    public static void diferencias(Set<String> set1, Set<String> set2) {
        Set<String> diferencia = new HashSet<>(set1); // copia de set1
        diferencia.removeAll(set2); // elimina los elementos que también están en set2

        System.out.println("Elementos en el primer conjunto pero no en el segundo:");
        for (String nombre : diferencia) {
            System.out.println(nombre);
        }
    }

    public static void main(String[] args) {
        // Crear conjuntos
        Set<String> grupo1 = new HashSet<>();
        Set<String> grupo2 = new HashSet<>();

        // Llenar grupo1
        grupo1.add("Juan");
        grupo1.add("María");
        grupo1.add("Carlos");
        grupo1.add("Ana");

        // Llenar grupo2 (con algunas diferencias)
        grupo2.add("María");
        grupo2.add("Carlos");
        grupo2.add("Pedro");
        grupo2.add("Lucía");

        // Mostrar conjuntos
        System.out.println("Grupo 1: " + grupo1);
        System.out.println("Grupo 2: " + grupo2);

        // Mostrar diferencias
        diferencias(grupo1, grupo2);

    }
}