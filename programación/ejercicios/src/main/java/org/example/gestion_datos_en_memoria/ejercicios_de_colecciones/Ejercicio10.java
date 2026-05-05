package org.example.gestion_datos_en_memoria.ejercicios_de_colecciones;

import java.util.HashSet;
import java.util.Set;

public class Ejercicio10 {

    private HashSet<String> ciudades;

    public Ejercicio10() {
        ciudades = new HashSet<>();
        ciudades.add("Madrid");
        ciudades.add("Barcelona");
        ciudades.add("Málaga");
        ciudades.add("Sevilla");
        ciudades.add("Murcia");
        ciudades.add("Valencia");
    }

    // Eliminar ciudades que empiezan con M
    public void eliminarCiudadesConM(Set<String> ciudades) {
        ciudades.removeIf(ciudad -> ciudad.startsWith("M"));
    }

    // Mostrar ciudades
    public void mostrarCiudades() {
        System.out.println("Ciudades:");
        for (String ciudad : ciudades) {
            System.out.println(ciudad);
        }
    }

    public static void main(String[] args) {
        Ejercicio10 ejercicio = new Ejercicio10();

        System.out.println("Ciudades originales:");
        ejercicio.mostrarCiudades();

        ejercicio.eliminarCiudadesConM(ejercicio.ciudades);

        System.out.println("\nCiudades después de eliminar las que empiezan con M:");
        ejercicio.mostrarCiudades();
    }
}