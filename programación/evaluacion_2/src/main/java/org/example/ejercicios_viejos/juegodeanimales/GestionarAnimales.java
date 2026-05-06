package org.example.ejercicios_viejos.juegodeanimales;

import java.io.*;
import java.util.Objects;

public class GestionarAnimales {

    private Perro[] perros = new Perro[5];
    private Gato[] gatos = new Gato[5];
    private int numPerros = 0;
    private int numGatos = 0;

    public boolean addPerro(Perro perro) {
        Objects.requireNonNull(perro, "Perro no puede ser null");
        if (numPerros >= perros.length) {
            return false;
        }
        perros[numPerros++] = perro;
        return true;
    }

    public boolean addGato(Gato gato) {
        Objects.requireNonNull(gato, "Gato no puede ser null");
        if (numGatos >= gatos.length) {
            return false;
        }
        gatos[numGatos++] = gato;
        return true;
    }

    public void WriteAnimalsDisk(String fichero) throws IOException {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(fichero))) {

            int total = numPerros + numGatos;
            oos.writeInt(total);

            for (int i = 0; i < numPerros; i++) {
                oos.writeObject(perros[i]);
            }
            for (int i = 0; i < numGatos; i++) {
                oos.writeObject(gatos[i]);
            }
        }
    }

    public Animal[] ReadAnimalsDisk(String fichero)
            throws IOException, ClassNotFoundException {

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(fichero))) {

            int total = ois.readInt();
            Animal[] animales = new Animal[total];

            numPerros = 0;
            numGatos = 0;

            for (int i = 0; i < total; i++) {
                Animal a = (Animal) ois.readObject();
                animales[i] = a;

                if (a instanceof Perro && numPerros < perros.length) {
                    perros[numPerros++] = (Perro) a;
                } else if (a instanceof Gato && numGatos < gatos.length) {
                    gatos[numGatos++] = (Gato) a;
                }
            }
            return animales;
        }
    }
}

