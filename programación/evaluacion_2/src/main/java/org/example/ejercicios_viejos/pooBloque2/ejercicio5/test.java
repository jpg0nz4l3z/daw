package org.example.ejercicios_viejos.pooBloque2.ejercicio5;

public class test {
    public static void main(String[] args) {
        Local local = new Local("calle ...2", 200, Condicion.deSegundaMano, 14, 2000, 5);
        Piso piso = new Piso("calle ...2", 200, Condicion.deSegundaMano, 14, 2000, 5);

        System.out.println("Local: ");
        System.out.println(local.toString());

        System.out.println("Piso: ");
        System.out.println(piso.toString());
    }
}
