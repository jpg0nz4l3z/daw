package org.example.ejercicios_viejos.gestiondeempleados;

public class EmpleadoAsalariado extends Empleado {

    public EmpleadoAsalariado(int id, String nombre, int edad, double salario) {
        super(id, nombre, edad, salario);
    }

    @Override
    public double calcularSalario() {
        return salario;
    }

    @Override
    public int getTipo() {
        return 1;
    }
}
