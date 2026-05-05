package org.example.gestion_datos_en_memoria.ejercicios_de_colecciones;

import java.util.HashSet;
import java.util.Set;

public class Ejercicio5 {

    // Devuelve los elementos únicos (no comunes)
    public static Set<Integer> obtenerElementosUnicos(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> resultado = new HashSet<>();

        // Añadir elementos de set1 que no están en set2
        for (Integer num : set1) {
            if (!set2.contains(num)) {
                resultado.add(num);
            }
        }

        // Añadir elementos de set2 que no están en set1
        for (Integer num : set2) {
            if (!set1.contains(num)) {
                resultado.add(num);
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        Set<Integer> conjunto1 = new HashSet<>();
        Set<Integer> conjunto2 = new HashSet<>();

        // Llenar conjuntos
        conjunto1.add(1);
        conjunto1.add(2);
        conjunto1.add(3);
        conjunto1.add(4);
        conjunto1.add(5);

        conjunto2.add(4);
        conjunto2.add(5);
        conjunto2.add(6);
        conjunto2.add(7);
        conjunto2.add(8);

        // Mostrar conjuntos
        System.out.println("Conjunto 1: " + conjunto1);
        System.out.println("Conjunto 2: " + conjunto2);

        // Obtener elementos únicos
        Set<Integer> unicos = obtenerElementosUnicos(conjunto1, conjunto2);

        // Mostrar resultado
        System.out.println("Elementos únicos (sin repetidos entre conjuntos): " + unicos);
    }
}