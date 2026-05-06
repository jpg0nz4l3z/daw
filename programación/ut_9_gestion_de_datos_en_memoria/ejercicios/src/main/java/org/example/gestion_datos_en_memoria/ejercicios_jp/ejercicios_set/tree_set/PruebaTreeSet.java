package org.example.gestion_datos_en_memoria.ejercicios_jp.ejercicios_set.tree_set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class PruebaTreeSet {
    static void main() {

        //forma 1
        Comparator<Persona> porEdad1 = new Comparator<Persona>() {
            @Override
            public int compare(Persona p1, Persona p2) {
                int res = Integer.compare(p1.getEdad(), p2.getEdad());//si se quiere el orden inverso hay que cambiar el orden de los parametros p2.getEdad() antes que p1. Con comparing se puede usar simplemente .reversed()
                /*Integer.compare(25, 30)  → -1
                Integer.compare(30, 30)  →  0
                Integer.compare(35, 30)  →  1*/
                if (res == 0) {
                    return p1.getNombre().compareTo(p2.getNombre());
                }
                return res;
            }
        };

        //forma2
        Comparator<Persona> porEdad2 = (p1, p2)-> {
            int res = Integer.compare(p1.getEdad(), p2.getEdad());
            if (res == 0) {
                return p1.getNombre().compareTo(p2.getNombre());
            }
            return res;
        };

        //forma3
        Comparator<Persona> porEdad3 = Comparator
                .comparing((Persona p) -> p.getEdad()).thenComparing((Persona p) -> p.getNombre());

        //forma4 definitiva
        Comparator<Persona> porEdad4 = Comparator
                .comparing(Persona::getEdad).thenComparing(Persona::getNombre);

        //TreeSet tiene un orden naturla cuando se trata de collections de int or Strings pero a la hora de ordenar objetos hay que pasarle como parametro explicitamente un comparator que determine el orden
        Set<Persona> personas = new TreeSet<Persona>(porEdad4);

        personas.add(new Persona("Gabriela", 26));
        personas.add(new Persona("Juan", 25));
        personas.add(new Persona("Camilo", 26));

        System.out.println(personas);
    }
}
