package org.example.ejercicios_viejos.ejercicios;
import java.util.concurrent.ThreadLocalRandom;

public class TestRandom {
    static void main() {
        int numero = ThreadLocalRandom.current().nextInt(5, 10); // el límite superior es exclusivo
        System.out.println(numero);
    }
}
