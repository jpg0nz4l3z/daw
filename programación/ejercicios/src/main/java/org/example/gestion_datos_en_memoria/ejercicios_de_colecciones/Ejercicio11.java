package org.example.gestion_datos_en_memoria.ejercicios_de_colecciones;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ejercicio11 {

    private ArrayList<String> frutas;

    public Ejercicio11() {
        frutas = new ArrayList<>();
        frutas.add("Manzana");
        frutas.add("Pera");
        frutas.add("Plátano");
        frutas.add("Manzana");
        frutas.add("Naranja");
        frutas.add("Pera");
    }

    // Convertir lista a set (elimina duplicados)
    public Set<String> convertirListaASet(List<String> lista) {
        return new HashSet<>(lista);
    }

    // Mostrar colección
    public void mostrarColeccion(Iterable<String> coleccion) {
        for (String elemento : coleccion) {
            System.out.println(elemento);
        }
    }

    public static void main(String[] args) {
        Ejercicio11 ejercicio = new Ejercicio11();

        System.out.println("Lista original (con duplicados):");
        ejercicio.mostrarColeccion(ejercicio.frutas);

        Set<String> conjunto = ejercicio.convertirListaASet(ejercicio.frutas);

        System.out.println("\nSet resultante (sin duplicados):");
        ejercicio.mostrarColeccion(conjunto);
    }
}