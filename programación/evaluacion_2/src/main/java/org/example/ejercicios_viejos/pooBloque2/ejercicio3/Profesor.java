package org.example.ejercicios_viejos.pooBloque2.ejercicio3;

public class Profesor extends Empleado{

    Departamento departamento;

    public Profesor(String nombre, String apellido, String dni, String estadoCivil, String fechaIncorporacion, Departamento departamento) {
        super(nombre, apellido, dni, estadoCivil, fechaIncorporacion);
        this.departamento = departamento;
    }

    Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return super.toString() + ", departamento=" + departamento;
    }
}


