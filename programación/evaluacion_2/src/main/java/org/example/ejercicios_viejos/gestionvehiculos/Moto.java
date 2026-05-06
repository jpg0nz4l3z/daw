package org.example.ejercicios_viejos.gestionvehiculos;

public class Moto extends Vehiculo {

    private int cilindrada;

    public Moto(String marca, String modelo, int anioFabricacion, int cilindrada) {
        super(marca, modelo, anioFabricacion);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }
}
