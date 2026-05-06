package pooBloque2.ejercicio4;

public class EmpleadoBaseMasComision extends Empleado{

    public EmpleadoBaseMasComision(String nombre, String apellido, String numeroSeguridadSocial, double salarioBase, int numeroVentas, double comisionPorVentas) {
        super(nombre, apellido, numeroSeguridadSocial, salarioBase);
        this.numeroVentas = numeroVentas;


    }
}
