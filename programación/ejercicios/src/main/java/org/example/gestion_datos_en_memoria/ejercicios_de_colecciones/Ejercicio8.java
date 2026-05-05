package org.example.gestion_datos_en_memoria.ejercicios_de_colecciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ejercicio8 {

    private HashMap<String, Integer> personas;

    public Ejercicio8() {
        personas = new HashMap<>();
        personas.put("Juan", 25);
        personas.put("María", 30);
        personas.put("Carlos", 22);
        personas.put("Ana", 28);
    }

    // Extraer edades del mapa
    public List<Integer> extraerEdades(Map<String, Integer> map) {
        return new ArrayList<>(map.values());
    }

    // Calcular promedio
    public double calcularPromedio(List<Integer> edades) {
        if (edades.isEmpty()) return 0;

        int suma = 0;
        for (int edad : edades) {
            suma += edad;
        }
        return (double) suma / edades.size();
    }

    // Encontrar mayor edad
    public int encontrarMayorEdad(List<Integer> edades) {
        if (edades.isEmpty()) return 0;

        int max = edades.get(0);
        for (int edad : edades) {
            if (edad > max) {
                max = edad;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Ejercicio8 ejercicio = new Ejercicio8();

        // Extraer edades
        List<Integer> edades = ejercicio.extraerEdades(ejercicio.personas);
        System.out.println("Edades: " + edades);

        // Promedio
        double promedio = ejercicio.calcularPromedio(edades);
        System.out.println("Promedio de edades: " + promedio);

        // Mayor edad
        int mayor = ejercicio.encontrarMayorEdad(edades);
        System.out.println("Mayor edad: " + mayor);
    }
}