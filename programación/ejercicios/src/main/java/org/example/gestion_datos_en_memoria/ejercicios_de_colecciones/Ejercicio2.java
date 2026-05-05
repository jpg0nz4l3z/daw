package org.example.gestion_datos_en_memoria.ejercicios_de_colecciones;

import java.util.ArrayList;
import java.util.Iterator;

public class Ejercicio2 {

    private ArrayList<Integer> listaNumeros;

    public Ejercicio2() {
        listaNumeros = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            listaNumeros.add(i);
        }
    }

    // Eliminar los que NO son múltiplos de 3
    public void eliminarNoMultiplosDeTres() {
        Iterator<Integer> iterator = listaNumeros.iterator();

        while (iterator.hasNext()) {
            int numero = iterator.next();
            if (numero % 3 != 0) {
                iterator.remove();
            }
        }
    }

    // Mostrar lista
    public void mostrarLista() {
        System.out.println("Lista de números:");
        for (Integer num : listaNumeros) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Ejercicio2 ejercicio = new Ejercicio2();

        System.out.println("Lista original:");
        ejercicio.mostrarLista();

        ejercicio.eliminarNoMultiplosDeTres();

        System.out.println("Lista después de eliminar no múltiplos de 3:");
        ejercicio.mostrarLista();
    }
}
