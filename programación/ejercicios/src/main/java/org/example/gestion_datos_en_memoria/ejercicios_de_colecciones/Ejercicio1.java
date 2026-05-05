package org.example.gestion_datos_en_memoria.ejercicios_de_colecciones;

import java.util.ArrayList;

public class Ejercicio1 {

    private ArrayList<String> listaNombres;

    public Ejercicio1() {
        listaNombres = new ArrayList<>();
    }

    // Añadir un nombre
    public void agregarNombre(String nombre) {
        listaNombres.add(nombre);
        System.out.println("Nombre agregado: " + nombre);
    }

    // Modificar un nombre por índice
    public void modificarNombre(int indice, String nuevoNombre) {
        if (indice >= 0 && indice < listaNombres.size()) {
            String anterior = listaNombres.get(indice);
            listaNombres.set(indice, nuevoNombre);
            System.out.println("Nombre modificado: " + anterior + " -> " + nuevoNombre);
        } else {
            System.out.println("Índice no válido.");
        }
    }

    // Eliminar un nombre
    public void eliminarNombre(String nombre) {
        if (listaNombres.remove(nombre)) {
            System.out.println("Nombre eliminado: " + nombre);
        } else {
            System.out.println("El nombre no existe en la lista.");
        }
    }

    // Mostrar la lista completa
    public void mostrarLista() {
        System.out.println("Lista de nombres:");
        for (int i = 0; i < listaNombres.size(); i++) {
            System.out.println(i + ": " + listaNombres.get(i));
        }
    }

    public static void main(String[] args) {
        Ejercicio1 gestion = new Ejercicio1();

        gestion.agregarNombre("Juan");
        gestion.agregarNombre("María");
        gestion.agregarNombre("Carlos");

        gestion.mostrarLista();

        gestion.modificarNombre(1, "Ana");
        gestion.mostrarLista();

        gestion.eliminarNombre("Carlos");
        gestion.mostrarLista();
    }
}