package org.example.gestion_datos_en_memoria.ejercicios_de_colecciones;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Ejercicio9 {

    private PriorityQueue<String> colaClientes;

    public Ejercicio9() {
        // Comparator para priorizar (por ejemplo: VIP > Normal)
        colaClientes = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String c1, String c2) {
                // Si uno es VIP y otro no, el VIP va primero
                if (c1.startsWith("VIP") && !c2.startsWith("VIP")) {
                    return -1;
                } else if (!c1.startsWith("VIP") && c2.startsWith("VIP")) {
                    return 1;
                } else {
                    // Si son del mismo tipo, orden alfabético
                    return c1.compareTo(c2);
                }
            }
        });

        // Añadir clientes
        colaClientes.add("Normal - Juan");
        colaClientes.add("VIP - María");
        colaClientes.add("Normal - Carlos");
        colaClientes.add("VIP - Ana");
        colaClientes.add("Normal - Pedro");
    }

    // Atender clientes
    public void atenderClientes() {
        System.out.println("Orden de atención:");

        while (!colaClientes.isEmpty()) {
            String cliente = colaClientes.poll(); // extrae el de mayor prioridad
            System.out.println(cliente);
        }
    }

    public static void main(String[] args) {
        Ejercicio9 banco = new Ejercicio9();
        banco.atenderClientes();
    }
}
