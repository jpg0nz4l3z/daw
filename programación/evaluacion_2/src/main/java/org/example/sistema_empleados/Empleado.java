package org.example.sistema_empleados;

public abstract class Empleado {
    protected int id;
    protected String nombre;

    public Empleado(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }

    public abstract double calcularSalario();

    @Override
    public String toString() {
        return id + "," + nombre + "," + calcularSalario();
    }
}
