package gestionvehiculos;

import java.io.Serializable;

public abstract class Vehiculo implements Serializable {

    protected String marca;
    protected String modelo;
    protected int anioFabricacion;

    public Vehiculo(String marca, String modelo, int anioFabricacion) {
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
    }

    public String getTipoVehiculo() {
        return this.getClass().getSimpleName();
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }
}

