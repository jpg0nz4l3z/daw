package org.example.gestion_datos_en_memoria.ejercicios_jp.ejercicios_set.tree_set_implementado;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class PruebaTreeSet {
    static void main() {

        /*Se ordena autómaticamente pero solo en estructuras que usan orden
        TreeSet
        TreeMap
        Collections.sort(lista)
        lista.sort(...)*/
        Set<Persona> personas = new TreeSet<Persona>();

        personas.add(new Persona("Gabriela", 26));
        personas.add(new Persona("Juan", 25));
        personas.add(new Persona("Camilo", 26));

        System.out.println(personas);
    }
}
