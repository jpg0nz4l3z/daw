package org.example.gestion_datos_en_memoria.ejercicios_jp.ejercicios_set.hash_set;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class PruebaHashSet {
    static void main() {

        //Se calcula el hashCode por cada elemento y se compara con equals, si existe un elemento igual no se inserta, coste medio O(1) acceso director por hash, en caso de muchas colisiones puede generar O(n), No mantiene orden, no permite duplicados, alta eficiencia en insersión y busqueda
        Set<Persona> personas = new HashSet<>();

        personas.add(new Persona("Gabriela", 26));
        personas.add(new Persona("Juan", 25));
        personas.add(new Persona("Juan", 25));
        personas.add(new Persona("Camilo", 26));

        System.out.println(personas);
    }
}
