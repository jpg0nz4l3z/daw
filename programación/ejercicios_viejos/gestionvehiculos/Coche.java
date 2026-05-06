package gestionvehiculos;

public class Coche extends Vehiculo {

    private boolean esElectrico;

    public Coche(String marca, String modelo, int anioFabricacion, boolean esElectrico) {
        super(marca, modelo, anioFabricacion);
        this.esElectrico = esElectrico;
    }

    public boolean isEsElectrico() {
        return esElectrico;
    }
}
