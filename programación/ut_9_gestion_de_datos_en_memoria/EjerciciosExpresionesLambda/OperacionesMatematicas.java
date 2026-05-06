package POO.EjerciciosExpresionesLambda;
//4. Operaciones con Expresiones Lambda:

@FunctionalInterface
interface OperacionMatematica {
    double calcular(double x, double y);
}
public class OperacionesMatematicas {
    public static void main(String[] args) {
        OperacionMatematica suma = (x, y) -> x + y;
        OperacionMatematica resta = (x, y) -> x - y;
        OperacionMatematica multiplicacion = (x, y) -> x * y;
        OperacionMatematica division = (x, y) -> x / y;

        System.out.println("Suma: " + suma.calcular(5, 3));
        System.out.println("Resta: " + resta.calcular(5, 3));
        System.out.println("Multiplicación: " + multiplicacion.calcular(5, 3));
        System.out.println("División: " + division.calcular(5, 3));
    }
}
