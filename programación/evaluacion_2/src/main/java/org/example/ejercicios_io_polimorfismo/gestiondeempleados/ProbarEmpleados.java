package org.example.ejercicios_io_polimorfismo.gestiondeempleados;

public class ProbarEmpleados {

    public static void main(String[] args) {
        try {
            GestionEmpleados ge = new GestionEmpleados("empleados.dat");

            ge.agregarEmpleado(new EmpleadoAsalariado(0, "Ana", 30, 2000));
            ge.agregarEmpleado(new EmpleadoAsalariado(1, "Luis", 40, 2500));
            ge.agregarEmpleado(new EmpleadoPorHoras(2, "Carlos", 25, 160, 10));
            ge.agregarEmpleado(new EmpleadoPorHoras(3, "Marta", 28, 120, 12));

            System.out.println("=== LISTA INICIAL ===");
            ge.listarEmpleados();

            ge.modificarSalario(1, 3000);

            System.out.println("\n=== LISTA MODIFICADA ===");
            ge.listarEmpleados();

            ge.cerrar();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

