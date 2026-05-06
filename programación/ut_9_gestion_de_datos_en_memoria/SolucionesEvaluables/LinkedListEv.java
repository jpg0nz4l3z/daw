package POO.Colecciones.SolucionesEvaluables;
// LinkedList:


import java.util.LinkedList;
public class LinkedListEv {

        public static void main(String[] args) {
            LinkedList<String> lista = new LinkedList<>();
            lista.add("A");
            lista.add("B");
            lista.add("C");

            lista.add(1, "D");
            lista.remove("B");
            lista.set(1, "E");

            System.out.println(lista);
        }
    }

