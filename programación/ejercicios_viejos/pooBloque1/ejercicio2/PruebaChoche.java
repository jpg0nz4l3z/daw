package pooBloque1.ejercicio2;

public class PruebaChoche {
    public static void main(String[] args) {
        Coche coche1 = new Coche("Verde", "Chevrolet", "Aveo", 100, 4, "RLA921");
        coche1.setColor("Amarillo");
        coche1.setMatricula("RLA931");

        Coche coche2 = new Coche("Rojo", "Chevrolet", "Aveo", 100, 4, "RLA921");
        coche2.setColor("Azúl");
        coche2.setCaballos(50);

        System.out.println("Coche 1 \n" + coche1.toString());
        System.out.println("Coche 2 \n" + coche2.toString());
    }
}
