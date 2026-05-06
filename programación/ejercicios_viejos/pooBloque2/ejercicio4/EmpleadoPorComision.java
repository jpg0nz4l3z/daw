package pooBloque2.ejercicio4;

public class EmpleadoPorComision extends Empleado{

    private int numeroVentas;
    private double comisionPorVentas;

    public EmpleadoPorComision(String nombre, String apellido, String numeroSeguridadSocial, int numeroVentas, double comisionPorVentas) {
        super(nombre, apellido, numeroSeguridadSocial, 0);
        this.numeroVentas = numeroVentas;
        this.comisionPorVentas = comisionPorVentas;
        calcularSalario();
    }

    public void calcularSalario(){
        super.salario = numeroVentas*comisionPorVentas;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSalario: " + super.salario;
    }
}
