package POO.EjerciciosExpresionesLambda;
//   7. Operaciones con Números con Expresiones Lambda:

@FunctionalInterface
interface OperacionNumerica {
    double realizarOperacion(double numero);
}
public class OperacionesNumericas {
    public static void main(String[] args) {
        OperacionNumerica cuadrado = x -> x * x;
        OperacionNumerica raizCuadrada = Math::sqrt;
        OperacionNumerica doble = x -> x * 2;

        System.out.println("Cuadrado de 5: " + cuadrado.realizarOperacion(5));
        System.out.println("Raíz cuadrada de 25: " + raizCuadrada.realizarOperacion(25));
        System.out.println("Doble de 7: " + doble.realizarOperacion(7));
    }
}
