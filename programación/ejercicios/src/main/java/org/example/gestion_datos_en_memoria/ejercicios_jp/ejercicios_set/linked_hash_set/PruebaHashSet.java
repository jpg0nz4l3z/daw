package org.example.gestion_datos_en_memoria.ejercicios_jp.ejercicios_set.linked_hash_set;

import java.util.*;

public class PruebaHashSet {
    static void main() {

        //Mantiene el orden de inserción a trave de una lista enlazada interna, coste ligeramente superior a HashSet, coste medio O(1), no se ordena es decir no se puede implementar Comparable, solo mantiene el orden de inserción, en caso de quere ordenar hay que usar primero otra estrucutra ordenable como TreeSet y despues pasar a LinkedHashSet
        Set<Persona> personas = new LinkedHashSet<>();

        personas.add(new Persona("Gabriela", 26));
        personas.add(new Persona("Juan", 25));
        personas.add(new Persona("Juan", 25));
        personas.add(new Persona("Camilo", 26));

        System.out.println(personas);
    }
}
