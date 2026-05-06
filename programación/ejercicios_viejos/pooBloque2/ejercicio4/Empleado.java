package pooBloque2.ejercicio4;

public abstract class Empleado {
    private String nombre;
    private String apellido;
    private String numeroSeguridadSocial;
    private double salarioBase;
    protected double salario;
    protected int numeroVentas;
    protected double comisionPorVentas;

    public Empleado(String nombre, String apellido, String numeroSeguridadSocial, double salarioBase) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroSeguridadSocial = numeroSeguridadSocial;
        this.salarioBase = salarioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNumeroSeguridadSocial() {
        return numeroSeguridadSocial;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNumeroSeguridadSocial(String numeroSeguridadSocial) {
        this.numeroSeguridadSocial = numeroSeguridadSocial;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", numeroSeguridadSocial='" + numeroSeguridadSocial + '\'' +
                ", salarioBase=" + salarioBase +
                ", salario=" + salario +
                '}';
    }

    public void calcularSalario(){
        this.salario = numeroVentas*comisionPorVentas;
    }
}
