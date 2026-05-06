package pooBloque3.ejercicio4;

public class test {
    static void main() {
        Espaniol espaniol = new Espaniol();
        Perro perro = new Perro();
        Gato gato = new Gato();

        Hablador[] habladors = {espaniol, perro, gato};

        for (Hablador hablador : habladors) {
            hablador.saludar();
            System.out.println(hablador.hashCode());
            hablador.metodoImplementado();
            Hablador.metodoImplementadoStatic();
        }
    }
}