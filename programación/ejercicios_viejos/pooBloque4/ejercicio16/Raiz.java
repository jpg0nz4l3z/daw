package pooBloque4.ejercicio16;

public class Raiz {
    private double a;
    private double b;
    private double c;

    public Raiz(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void obtenerRaices() {
        System.out.println();
    }

    public void obtenerRaiz() {
        System.out.println();
    }

    public double getDiscriminante() {
        return Math.pow(b, 2) - (4 * a * c);
    }

    public boolean tieneRaices() {
        return getDiscriminante() > 0;
    }

    public boolean tieneRaiz() {
        return getDiscriminante() == 0;
    }

    public void calcular() {
        double solucion1;
        double solucion2;
        if (tieneRaices()) {
            solucion1 = (-b + Math.sqrt(getDiscriminante())) / (2 * a);
            solucion2 = (-b - Math.sqrt(getDiscriminante())) / (2 * a);
            System.out.println("Solución 1 + = " + solucion1);
            System.out.println("Solución 2 - = " + solucion2);
        } else if (tieneRaiz()) {
            solucion1 = -b + Math.sqrt(getDiscriminante() / 2 * a);
            System.out.println("Solución = " + solucion1);
        } else {
            System.out.println("No existe solución");
        }
    }

    static void main() {
        Raiz raiz = new Raiz(1, -5, 6);
        System.out.println("**** Raiz ***");
        raiz.calcular();
    }
}
