package POO.EjerciciosExpresionesLambda;
//1. Calculadora con Clase Anónima:
interface Operacion {
    double calcular(double x, double y);
}
public class Calculadora {
    public static void main(String[] args) {
        Operacion suma = new Operacion() {
            @Override
            public double calcular(double x, double y) {
                return x + y;
            }
        };

        Operacion resta = (x, y) -> x - y;
        Operacion multiplicacion = (x, y) -> x * y;
        Operacion division = (x, y) -> x / y;

        System.out.println("Suma: " + suma.calcular(5, 3));
        System.out.println("Resta: " + resta.calcular(5, 3));
        System.out.println("Multiplicación: " + multiplicacion.calcular(5, 3));
        System.out.println("División: " + division.calcular(5, 3));
    }
}
