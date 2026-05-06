package org.example.ejercicios_viejos.pooBloque2.ejercicio3;

public class PersonalServicio extends Empleado {

    Seccion seccion;

    public PersonalServicio(String nombre, String apellido, String dni, String estadoCivil, String fechaIncorporacion, Seccion seccion) {
        super(nombre, apellido, dni, estadoCivil, fechaIncorporacion);
        this.seccion = seccion;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    @Override
    public String toString() {
        return super.toString() + ", sección=" + seccion;
    }
}
