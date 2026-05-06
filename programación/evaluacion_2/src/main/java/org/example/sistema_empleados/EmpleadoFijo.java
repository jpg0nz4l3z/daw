package org.example.sistema_empleados;

public class EmpleadoFijo extends Empleado {

    private double salarioMensual;

    public EmpleadoFijo(int id, String nombre, double salarioMensual) {
        super(id, nombre);
        this.salarioMensual = salarioMensual;
    }

    @Override
    public double calcularSalario() {
        return salarioMensual+20;
    }
}