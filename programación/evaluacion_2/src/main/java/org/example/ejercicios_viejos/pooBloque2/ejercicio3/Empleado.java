package org.example.ejercicios_viejos.pooBloque2.ejercicio3;

public class Empleado extends Persona {

    String fechaIncorporacion;

    public Empleado(String nombre, String apellido, String dni, String estadoCivil, String fechaIncorporacion) {
        super(nombre, apellido, dni, estadoCivil);

        this.fechaIncorporacion = fechaIncorporacion;
    }

    @Override
    public String toString() {
        return super.toString() + ", fecha de incorporación=" + fechaIncorporacion;
    }
}
