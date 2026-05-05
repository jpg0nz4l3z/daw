package org.example.gestion_datos_en_memoria.ejercicios_de_colecciones;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Ejercicio3 {

    private ArrayList<String> listaPalabras;

    public Ejercicio3() {
        listaPalabras = new ArrayList<>();
        listaPalabras.add("Casa");
        listaPalabras.add("Perro");
        listaPalabras.add("Coche");
        listaPalabras.add("Gato");
        listaPalabras.add("Camión");
    }

    // Buscar la primera palabra que empiece por una letra
    public String buscarPrimeraPalabraConLetra(String letra) {
        Optional<String> resultado = listaPalabras.stream()
                .filter(p -> p.toLowerCase().startsWith(letra.toLowerCase()))
                .findFirst();

        return resultado.orElse("No hay palabras que comiencen con la letra: " + letra);
    }

    // Mostrar lista
    public void mostrarLista() {
        System.out.println("Lista de palabras:");
        for (String palabra : listaPalabras) {
            System.out.println(palabra);
        }
    }

    public static void main(String[] args) {
        Ejercicio3 ejercicio = new Ejercicio3();

        ejercicio.mostrarLista();

        String resultado = ejercicio.buscarPrimeraPalabraConLetra("C");
        System.out.println("Resultado búsqueda: " + resultado);

        String resultado2 = ejercicio.buscarPrimeraPalabraConLetra("Z");
        System.out.println("Resultado búsqueda: " + resultado2);
    }
}
