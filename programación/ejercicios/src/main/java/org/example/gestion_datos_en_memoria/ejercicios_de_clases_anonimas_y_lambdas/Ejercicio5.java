package org.example.gestion_datos_en_memoria.ejercicios_de_clases_anonimas_y_lambdas;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio5 {

    public static void main(String[] args) {

        // Lista de nombres
        List<String> nombres = new ArrayList<>();
        nombres.add("Juan");
        nombres.add("María");
        nombres.add("Carlos");
        nombres.add("Ana");
        nombres.add("Pedro");

        // Orden alfabético
        List<String> alfabetico = new ArrayList<>(nombres);
        alfabetico.sort((a, b) -> a.compareTo(b));

        // Orden por longitud
        List<String> porLongitud = new ArrayList<>(nombres);
        porLongitud.sort((a, b) -> Integer.compare(a.length(), b.length()));

        // Mostrar resultados
        System.out.println("Lista original: " + nombres);
        System.out.println("Orden alfabético: " + alfabetico);
        System.out.println("Orden por longitud: " + porLongitud);
    }
}
