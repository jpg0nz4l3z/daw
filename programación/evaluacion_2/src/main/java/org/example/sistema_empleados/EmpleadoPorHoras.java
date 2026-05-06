package org.example.sistema_empleados;

public class EmpleadoPorHoras extends Empleado {

    private int horas;
    private double precioHora;

    public EmpleadoPorHoras(int id, String nombre, int horas, double precioHora) {
        super(id, nombre);
        this.horas = horas;
        this.precioHora = precioHora;
    }

    @Override
    public double calcularSalario() {
        return horas * precioHora;
    }
}

