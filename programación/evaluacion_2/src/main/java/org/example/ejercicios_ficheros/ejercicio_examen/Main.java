package org.example.ejercicios_ficheros.ejercicio_examen;

public class Main {
    public static void main(String[] args) {
        Test test = new Test("examen.txt");
        test.cargarPreguntas();
        test.realizarTest();
    }
}
