package org.example.gestion_datos_en_memoria.ejercicios_jp.ejercicios_map.linked_hash_map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class PruebaLinkedHashMap {
    static void main() {

        //Conjunto de pares clave valor únicas
        //Cuando usas objetos como clave es necesario implementar muy bien el equals y hashMap para evitar duplicación de claves (duplicados lógicos)
        //Usos típicos, contar apariciones
        //Internamente usa una tabla hash, mismo principio hashSet
        //A diferencia de LinkedHashMap(orden de inserción) y TreeMap(orden natural o comparator), HashMap no tiene orden
        String[] palabras =
                {"java", "map", "java", "set", "map", "java"};
        Map<String, Integer> contador = new LinkedHashMap<>();

        for (String p : palabras) {
            contador.put(p, contador.getOrDefault(p, 0) + 1);
            //getOrDefault: dame el valor asociado a p, si no existe dame 0 y sumale 1, si existe sumale 1
        }

        System.out.println(contador);

        //Iteración correcta
        for(Map.Entry<String, Integer> e: contador.entrySet()){
            //System.out.println("%s : %d".formatted(e.getKey(), e.getValue()) );
            System.out.printf("%s : %d%n", e.getKey(), e.getValue());
        }
    }
}
