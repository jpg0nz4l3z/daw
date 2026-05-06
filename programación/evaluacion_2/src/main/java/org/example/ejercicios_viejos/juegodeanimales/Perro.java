package org.example.ejercicios_viejos.juegodeanimales;

public class Perro extends Animal {
    private boolean raboLargo;

    public Perro(String nombre, int edad, boolean raboLargo) {
        super(nombre, edad);
        this.raboLargo = raboLargo;
    }

    @Override
    public String hablar() {
        return "GUAU";
    }

    public boolean isRaboLargo() {
        return raboLargo;
    }
}

