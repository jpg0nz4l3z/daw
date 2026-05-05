package org.example.gestion_datos_en_memoria.ejercicios_de_colecciones;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Ejercicio7 {

    private LinkedHashMap<String, Double> productos;

    public Ejercicio7() {
        productos = new LinkedHashMap<>();
        productos.put("Pan", 1.2);
        productos.put("Leche", 0.9);
        productos.put("Queso", 2.5);
        productos.put("Huevos", 1.8);
        productos.put("Arroz", 1.1);
    }

    // Ordenar por precio ascendente
    public LinkedHashMap<String, Double> ordenarPorPrecioAscendente() {
        return productos.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    // Mostrar mapa
    public void mostrarMapa(Map<String, Double> mapa) {
        for (Map.Entry<String, Double> entry : mapa.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + "€");
        }
    }

    public static void main(String[] args) {
        Ejercicio7 ejercicio = new Ejercicio7();

        System.out.println("Mapa original:");
        ejercicio.mostrarMapa(ejercicio.productos);

        System.out.println("\nMapa ordenado por precio ascendente:");
        LinkedHashMap<String, Double> ordenado = ejercicio.ordenarPorPrecioAscendente();
        ejercicio.mostrarMapa(ordenado);
    }
}