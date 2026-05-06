package POO.Colecciones.SolucionesEvaluables;
//HashSet:


import java.util.HashSet;
public class HashSetEv {

        public static void main(String[] args) {
            HashSet<Integer> numeros = new HashSet<>();
            numeros.add(10);
            numeros.add(5);
            numeros.add(10); // Duplicado, no se agregará

            System.out.println(numeros);

            // Operaciones de conjuntos
            HashSet<Integer> conjunto1 = new HashSet<>();
            conjunto1.add(1);
            conjunto1.add(2);
            HashSet<Integer> conjunto2 = new HashSet<>();
            conjunto2.add(2);
            conjunto2.add(3);

            // Intersección
            conjunto1.retainAll(conjunto2);
            System.out.println("Intersección: " + conjunto1);

            // Unión
            conjunto1.addAll(conjunto2);
            System.out.println("Unión: " + conjunto1);

            // Diferencia
            conjunto1.removeAll(conjunto2);
            System.out.println("Diferencia: " + conjunto1);
        }
    }

