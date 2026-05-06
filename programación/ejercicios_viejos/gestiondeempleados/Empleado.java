package gestiondeempleados;

public abstract class Empleado implements Calculable {

    protected int id;
    protected String nombre;
    protected int edad;
    protected double salario;

    public Empleado(int id, String nombre, int edad, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public abstract int getTipo(); // 1 o 2

    @Override
    public String toString() {
        return "ID=" + id +
                ", Nombre=" + nombre.trim() +
                ", Edad=" + edad +
                ", Salario=" + salario +
                ", Tipo=" + (getTipo() == 1 ? "Asalariado" : "Por Horas");
    }
}
