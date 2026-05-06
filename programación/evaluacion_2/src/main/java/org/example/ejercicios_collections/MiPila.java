package org.example.ejercicios_collections;

import java.util.ArrayList;

public class MiPila {

    private ArrayList<Integer> elementos;

    // Constructor
    public MiPila() {
        elementos = new ArrayList<>();
    }

    // Apilar (push)
    public void push(int valor) {
        elementos.add(valor);
    }

    // Desapilar (pop)
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("La pila está vacía");
        }
        return elementos.remove(elementos.size() - 1);
    }

    // Ver elemento superior (peek)
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("La pila está vacía");
        }
        return elementos.get(elementos.size() - 1);
    }

    // Verificar si está vacía
    public boolean isEmpty() {
        return elementos.isEmpty();
    }

    // Tamaño de la pila
    public int size() {
        return elementos.size();
    }

    // Mostrar pila
    public void mostrar() {
        System.out.println(elementos);
    }
}
