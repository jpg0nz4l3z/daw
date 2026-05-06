package POO.Colecciones.SolucionesEvaluables;

//HashMap:

import java.util.HashMap;
import java.util.Map;
public class HashMapEv {

        public static void main(String[] args) {
            HashMap<String, Integer> edades = new HashMap<>();
            edades.put("Juan", 25);
            edades.put("María", 30);
            edades.put("Carlos", 20);

            // Actualizar edad
            edades.put("María", 35);

            // Imprimir claves y valores
            for (Map.Entry<String, Integer> entry : edades.entrySet()) {
                System.out.println("Nombre: " + entry.getKey() + ", Edad: " + entry.getValue());
            }

            // Claves con valores mayores que cierta edad
            int edadLimite = 25;
            for (String nombre : edades.keySet()) {
                if (edades.get(nombre) > edadLimite) {
                    System.out.println("Nombre: " + nombre);
                }
            }
        }
    }

