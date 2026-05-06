package org.example.ejercicios_viejos.gestionvehiculos;

public class ProbarVehiculos {

    public static void main(String[] args) {
        try {
            GestionarVehiculos gv = new GestionarVehiculos();

            gv.addCoche(new Coche("Tesla", "Model 3", 2022, true));
            gv.addCoche(new Coche("Toyota", "Corolla", 2018, false));

            gv.addMoto(new Moto("Yamaha", "MT-07", 2020, 689));
            gv.addMoto(new Moto("Honda", "CBR600", 2019, 600));

            gv.guardarVehiculos("vehiculos.dat");

            gv.cargarVehiculos("vehiculos.dat");

            gv.mostrarVehiculos();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

