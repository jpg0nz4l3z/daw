package org.example.gestion_datos_en_memoria;

import java.util.Iterator;
import java.util.TreeSet;

public class TestTreeSet {
    static void main() {
        /*Para ordenar elementos automáticamente por orden:
         alfabético,
         numérico,
         character(ASCII),
         Ojetos propios(El que se defina en el comparator)
         */

        TreeSet<Integer> tree = new TreeSet<>();
        tree.add(12);
        tree.add(63);
        tree.add(34);
        tree.add(45);

        System.out.println("Los datos del arbol son los siguientes");

        Iterator<Integer> iterator = tree.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        if (tree.isEmpty()) {
            System.out.println("El arbol está vacío");
        } else {
            System.out.println("El tamaño del arbol es " + tree.size());
        }

        System.out.println("Primer dato del arbol " + tree.first());
        System.out.println("Último dato del arbol " + tree.last());

        if (tree.remove(45)) {
            System.out.println("El dato 45 es eliminado del arbol");
        } else {
            System.out.println("El dato 45 no existe");
        }

        iterator = tree.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println("\nEl tamaño del arbol es " + tree.size());

        tree.clear();
        if (tree.isEmpty()) {
            System.out.println("El arbol está vacío");
        } else {
            System.out.println("El tamaño del arbol es " + tree.size());
        }
    }
}
