package org.example.gestion_datos_en_memoria.ejercicios_jp.ejercicios_map.tree_map;

import org.example.gestion_datos_en_memoria.ejercicios_jp.ejercicios_map.hash_map.Persona;

import java.util.*;

public class PruebaTreeMap {
    static void main() {

        //TreeMap(orden natural o comparator)
        //El TreeMap y Comparator solo afectan a las claves
        String[] palabras =
                {"java", "map", "java", "set", "map", "java"};
        Map<String, Integer> contador = new TreeMap<>();

        for (String p : palabras) {
            contador.put(p, contador.getOrDefault(p, 0) + 1);
            //getOrDefault: dame el valor asociado a p, si no existe dame 0 y sumale 1, si existe sumale 1
        }

        System.out.println(contador);

        //Iteración correcta
        for (Map.Entry<String, Integer> e : contador.entrySet()) {
            //System.out.println("%s : %d".formatted(e.getKey(), e.getValue()) );
            System.out.printf("%s : %d%n", e.getKey(), e.getValue());
        }

        //como solo puede comparar por key y no por value, si quisieramos ordenar por la cantidad de repetición habría que usar otra estructura de datos

        List<Map.Entry<String, Integer>> lista = new ArrayList<>(contador.entrySet());

        lista.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

        System.out.println(lista);


        //Otra alternativa

        Map<Integer, List<String>> invertido = new TreeMap<>(Comparator.reverseOrder());

        for (Map.Entry<String, Integer> e : contador.entrySet()) {
            invertido
                    .computeIfAbsent(e.getValue(), k -> new ArrayList<>())
                    .add(e.getKey());
            //computeIfAbset: para esta cantidad dame su lista ["...", "..."], sino existe creala y añade la palabra
        }

        System.out.println(invertido);


        //Ejemplo2 con comparator para personas

        Comparator<Persona> comparator = Comparator.comparing(Persona::getEdad).thenComparing(Persona::getNombre).reversed();
        Map<Persona, Integer> personas = new TreeMap<>(comparator);

        personas.put(new Persona("Juan", 21), 1);
        personas.put(new Persona("Camilo", 22), 2);
        personas.put(new Persona("Gabriela", 23), 3);

        System.out.println("\n\n" + personas);
    }
}
