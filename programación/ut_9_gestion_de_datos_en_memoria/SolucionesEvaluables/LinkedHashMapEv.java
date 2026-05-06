package POO.Colecciones.SolucionesEvaluables;

   // LinkedHashMap:

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapEv {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> poblaciones = new LinkedHashMap<>();
        poblaciones.put("Nueva York", 8000000);
        poblaciones.put("Los Angeles", 4000000);
        poblaciones.put("Chicago", 2700000);

        // Iterar en orden de inserción
        for (Map.Entry<String, Integer> entry : poblaciones.entrySet()) {
            System.out.println("Ciudad: " + entry.getKey() + ", Población: " + entry.getValue());
        }
    }
}