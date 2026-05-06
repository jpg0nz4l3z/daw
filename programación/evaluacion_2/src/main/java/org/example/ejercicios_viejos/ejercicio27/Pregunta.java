package org.example.ejercicios_viejos.ejercicio27;

import java.util.ArrayList;
import java.util.Scanner;

public class Pregunta {
    private String enunciado;
    private ArrayList<String> opciones;
    private int opcionCorrecta;
    private double puntos;

    public Pregunta(String enunciado, ArrayList<String> opciones, int opcionCorrecta, double puntos) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.opcionCorrecta = opcionCorrecta;
        this.puntos = puntos;
    }

    public void mostrarPregunta() {
        System.out.println(enunciado + "\n");

        for (int i = 0; i < opciones.size(); i++) {
            System.out.println(i+1 + ". " + opciones.get(i));
        }
    }

    public boolean comprobarOpcionCorrecta(int opcion) {
        return opcionCorrecta == opcion;
    }

    public int getOpcionCorrecta() {
        return opcionCorrecta;
    }
}
