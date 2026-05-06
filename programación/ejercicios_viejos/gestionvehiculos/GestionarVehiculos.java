package gestionvehiculos;

import java.io.*;
import java.util.Objects;

public class GestionarVehiculos {

    private Coche[] coches = new Coche[5];
    private Moto[] motos = new Moto[5];
    private int numCoches = 0;
    private int numMotos = 0;

    public boolean addCoche(Coche coche) {
        Objects.requireNonNull(coche, "El coche no puede ser null");
        if (numCoches >= coches.length) {
            return false;
        }
        coches[numCoches++] = coche;
        return true;
    }

    public boolean addMoto(Moto moto) {
        Objects.requireNonNull(moto, "La moto no puede ser null");
        if (numMotos >= motos.length) {
            return false;
        }
        motos[numMotos++] = moto;
        return true;
    }

    public void guardarVehiculos(String fichero) throws IOException {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(fichero))) {

            int total = numCoches + numMotos;
            oos.writeInt(total);

            for (int i = 0; i < numCoches; i++) {
                oos.writeObject(coches[i]);
            }
            for (int i = 0; i < numMotos; i++) {
                oos.writeObject(motos[i]);
            }
        }
    }

    public Vehiculo[] cargarVehiculos(String fichero)
            throws IOException, ClassNotFoundException {

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(fichero))) {

            int total = ois.readInt();
            Vehiculo[] vehiculos = new Vehiculo[total];

            numCoches = 0;
            numMotos = 0;

            for (int i = 0; i < total; i++) {
                Vehiculo v = (Vehiculo) ois.readObject();
                vehiculos[i] = v;

                if (v instanceof Coche && numCoches < coches.length) {
                    coches[numCoches++] = (Coche) v;
                } else if (v instanceof Moto && numMotos < motos.length) {
                    motos[numMotos++] = (Moto) v;
                }
            }
            return vehiculos;
        }
    }

    public void mostrarVehiculos() {
        System.out.println("COCHES:");
        for (int i = 0; i < numCoches; i++) {
            Coche c = coches[i];
            System.out.println(
                    c.getMarca() + " " +
                            c.getModelo() + " (" +
                            c.getAnioFabricacion() + ") - Eléctrico: " +
                            c.isEsElectrico()
            );
        }

        System.out.println("\nMOTOS:");
        for (int i = 0; i < numMotos; i++) {
            Moto m = motos[i];
            System.out.println(
                    m.getMarca() + " " +
                            m.getModelo() + " (" +
                            m.getAnioFabricacion() + ") - " +
                            m.getCilindrada() + "cc"
            );
        }
    }
}
