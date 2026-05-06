package POO.Colecciones.SolucionesEvaluables;
//ArrayList:


import java.util.ArrayList;
import java.util.Collections;

public class ArrayListEv {
         public static void main(String[] args) {
            ArrayList<Integer> numeros = new ArrayList<>();
            numeros.add(10);
            numeros.add(5);
            numeros.add(20);

            int maximo = Collections.max(numeros);
            int minimo = Collections.min(numeros);
            int suma = 0;
            for (int num : numeros) {
                suma += num;
            }

            System.out.println("Máximo: " + maximo);
            System.out.println("Mínimo: " + minimo);
            System.out.println("Suma: " + suma);
        }
    }
