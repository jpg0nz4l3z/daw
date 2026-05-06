package POO.EjerciciosExpresionesLambda;

import java.util.Arrays;


//        10. Operaciones con Arrays con Expresiones Lambda:

@FunctionalInterface
interface OperacionArray {
    double realizarOperacion(double[] numeros);
}

public class OperacionesArray {
    public static void main(String[] args) {
        OperacionArray sumaArray = numeros -> Arrays.stream(numeros).sum();
        OperacionArray maximoArray = numeros -> Arrays.stream(numeros).max().orElse(0);

        double[] numeros = {1, 2, 3, 4, 5};

        System.out.println("Suma de elementos: " + sumaArray.realizarOperacion(numeros));
        System.out.println("Máximo elemento: " + maximoArray.realizarOperacion(numeros));
    }
}
