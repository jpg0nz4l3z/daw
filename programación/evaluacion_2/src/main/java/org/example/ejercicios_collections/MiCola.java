package org.example.ejercicios_collections;

import java.util.ArrayList;

public class MiCola {

    private ArrayList<Integer> elementos;

    // Constructor
    public MiCola() {
        elementos = new ArrayList<>();
    }

    // Encolar (enqueue)
    public void enqueue(int valor) {
        elementos.add(valor);
    }

    // Desencolar (dequeue)
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("La cola está vacía");
        }
        return elementos.remove(0);
    }

    // Ver primero (peek)
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("La cola está vacía");
        }
        return elementos.get(0);
    }

    // Verificar si está vacía
    public boolean isEmpty() {
        return elementos.isEmpty();
    }

    // Tamaño
    public int size() {
        return elementos.size();
    }

    // Mostrar cola
    public void mostrar() {
        System.out.println(elementos);
    }
}
