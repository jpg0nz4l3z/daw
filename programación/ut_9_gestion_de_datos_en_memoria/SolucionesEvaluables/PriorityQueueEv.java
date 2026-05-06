package POO.Colecciones.SolucionesEvaluables;

    //PriorityQueue:

import java.util.PriorityQueue;

public class  PriorityQueueEv {
    public static void main(String[] args) {
        PriorityQueue<Integer> colaPrioridad = new PriorityQueue<>();
        colaPrioridad.add(10);
        colaPrioridad.add(5);
        colaPrioridad.add(20);

        System.out.println("Primero: " + colaPrioridad.peek());
        System.out.println("Eliminado: " + colaPrioridad.poll());
        System.out.println("Nuevo primero: " + colaPrioridad.peek());
    }
}

