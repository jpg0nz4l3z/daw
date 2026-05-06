package org.example.ejercicios_io_polimorfismo.juegodeanimales;

public class ProbarAnimales {

    public static void main(String[] args) {
        try {
            GestionarAnimales ga = new GestionarAnimales();

            ga.addPerro(new Perro("Rex", 5, true));
            ga.addPerro(new Perro("Toby", 3, false));

            ga.addGato(new Gato("Misu", 4, true));
            ga.addGato(new Gato("Luna", 2, false));

            ga.WriteAnimalsDisk("animales.dat");

            Animal[] animales = ga.ReadAnimalsDisk("animales.dat");

            for (Animal a : animales) {
                System.out.println(
                        a.getClase() + " " +
                                a.getNombre() + " " +
                                a.getEdad() + " dice " +
                                a.hablar()
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
