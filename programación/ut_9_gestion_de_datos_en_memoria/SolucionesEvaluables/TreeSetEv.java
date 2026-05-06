package POO.Colecciones.SolucionesEvaluables;

//TreeSet:

import java.util.TreeSet;

public class TreeSetEv {
    public static void main(String[] args) {
        TreeSet<String> arbol = new TreeSet<>();
        arbol.add("C");
        arbol.add("A");
        arbol.add("B");

        System.out.println("Primero: " + arbol.first());
        System.out.println("Último: " + arbol.last());
        System.out.println("Arbol: " + arbol);
    }
}


