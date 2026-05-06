package org.example.ejercicios_viejos.pooBloque1.ejercicio1;

public class PruebaRectangulo {
    public static void main(String[] args) {
        Rectangulo rectangulo1 = new Rectangulo(5,2);

        System.out.println("Base = " + rectangulo1.getBase() + ", Altura = " + rectangulo1.getAltura());
        System.out.println("Area = " + rectangulo1.calcularArea());
        System.out.println("Perímetro = " + rectangulo1.calcularPerimetro());
    }
}
