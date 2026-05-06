package POO.Colecciones.SolucionesEvaluables;


    //Collections:

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsEv {
    public static void main(String[] args) {
        List<String> nombres = new ArrayList<>();
        nombres.add("María");
        nombres.add("Juan");
        nombres.add("Carlos");

        // Ordenar alfabéticamente
        Collections.sort(nombres);
        System.out.println("Ordenado: " + nombres);

        // Invertir
        Collections.reverse(nombres);
        System.out.println("Invertido: " + nombres);

        // Mezclar
        Collections.shuffle(nombres);
        System.out.println("Mezclado: " + nombres);

        // Buscar
        int indice = Collections.binarySearch(nombres, "María");
        System.out.println("Índice de María: " + indice);
    }
}