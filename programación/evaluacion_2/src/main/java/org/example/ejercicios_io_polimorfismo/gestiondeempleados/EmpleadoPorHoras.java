package org.example.ejercicios_io_polimorfismo.gestiondeempleados;

public class EmpleadoPorHoras extends Empleado {

    private int horas;
    private double tarifaHora;

    public EmpleadoPorHoras(int id, String nombre, int edad,
                            int horas, double tarifaHora) {
        super(id, nombre, edad, 0);
        this.horas = horas;
        this.tarifaHora = tarifaHora;
        this.salario = calcularSalario();
    }

    @Override
    public double calcularSalario() {
        return horas * tarifaHora;
    }

    @Override
    public int getTipo() {
        return 2;
    }
}
