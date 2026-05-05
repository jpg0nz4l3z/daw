package org.example.gestion_datos_en_memoria.ejercicios_de_colecciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class NotasAlumnos{
    private HashMap<String, List<Integer>> notas;

    public NotasAlumnos() {
        notas = new HashMap<>();
    }

    // Añadir nota a un alumno
    public void agregarNota(String alumno, int nota) {
        notas.putIfAbsent(alumno, new ArrayList<>());
        notas.get(alumno).add(nota);
        System.out.println("Nota añadida a " + alumno + ": " + nota);
    }

    // Mostrar notas de un alumno
    public void mostrarNotas(String alumno) {
        if (notas.containsKey(alumno)) {
            System.out.println("Notas de " + alumno + ": " + notas.get(alumno));
        } else {
            System.out.println("El alumno no existe.");
        }
    }

    // Calcular media de un alumno
    public double mediaNotas(String alumno) {
        if (!notas.containsKey(alumno)) {
            System.out.println("El alumno no existe.");
            return 0;
        }

        List<Integer> lista = notas.get(alumno);
        int suma = 0;

        for (int nota : lista) {
            suma += nota;
        }

        return (double) suma / lista.size();
    }

    // Encontrar alumno con mejor media
    public String mejorNota() {
        String mejorAlumno = null;
        double mejorMedia = Double.MIN_VALUE;

        for (Map.Entry<String, List<Integer>> entry : notas.entrySet()) {
            List<Integer> lista = entry.getValue();

            int suma = 0;
            for (int nota : lista) {
                suma += nota;
            }

            double media = (double) suma / lista.size();

            if (media > mejorMedia) {
                mejorMedia = media;
                mejorAlumno = entry.getKey();
            }
        }

        return mejorAlumno + " con media: " + mejorMedia;
    }
}

public class Ejercicio6 {

    public static void main(String[] args) {
        NotasAlumnos sistema = new NotasAlumnos();

        sistema.agregarNota("Juan", 7);
        sistema.agregarNota("Juan", 8);
        sistema.agregarNota("María", 9);
        sistema.agregarNota("María", 10);
        sistema.agregarNota("Carlos", 6);

        sistema.mostrarNotas("Juan");
        System.out.println("Media de Juan: " + sistema.mediaNotas("Juan"));

        System.out.println("Mejor alumno: " + sistema.mejorNota());
    }
}