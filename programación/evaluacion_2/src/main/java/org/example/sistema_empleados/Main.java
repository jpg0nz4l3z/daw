package org.example.sistema_empleados;

import java.util.*;
import java.sql.SQLException;
import java.io.IOException;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static EmpleadoDAO dao = new EmpleadoDAO();
    private static final String RUTA = "empleados.txt";

    public static void main(String[] args) {

        int opcion;

        do {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            try {
                switch (opcion) {
                    case 1 -> crearEmpleado();
                    case 2 -> listarBD();
                    case 3 -> exportarAFichero();
                    case 4 -> importarDesdeFichero();
                    case 5 -> eliminarEmpleado();
                    case 0 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción inválida");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ ---");
        System.out.println("1. Crear empleado y guardar en BD");
        System.out.println("2. Listar empleados desde BD");
        System.out.println("3. Exportar empleados BD a fichero");
        System.out.println("4. Importar empleados desde fichero a BD");
        System.out.println("5. Eliminar empleado");
        System.out.println("0. Salir");
        System.out.print("Opción: ");
    }

    private static void crearEmpleado() throws SQLException {

        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Tipo (1=Fijo, 2=Horas): ");
        int tipo = sc.nextInt();

        Empleado e;

        if (tipo == 1) {
            System.out.print("Salario mensual: ");
            double salario = sc.nextDouble();
            e = new EmpleadoFijo(id, nombre, salario);
        } else {
            System.out.print("Horas trabajadas: ");
            int horas = sc.nextInt();
            System.out.print("Precio por hora: ");
            double precio = sc.nextDouble();
            e = new EmpleadoPorHoras(id, nombre, horas, precio);
        }

        dao.crear(e);
        System.out.println("Empleado guardado en BD.");
    }

    private static void listarBD() throws SQLException {

        List<Empleado> lista = dao.listar();

        for (Empleado e : lista) {
            // 🔹 POLIMORFISMO
            System.out.println(e.getId() + " - " +
                    e.getNombre() + " - " +
                    e.calcularSalario());
        }
    }

    private static void exportarAFichero() throws SQLException, IOException {

        List<Empleado> lista = dao.listar();
        FicheroEmpleado.escribir(RUTA, lista);

        System.out.println("Datos exportados a fichero.");
    }

    private static void importarDesdeFichero() throws IOException, SQLException {

        List<Empleado> lista = FicheroEmpleado.leer(RUTA);

        for (Empleado e : lista) {
            dao.crear(e);
        }

        System.out.println("Datos importados a BD.");
    }

    private static void eliminarEmpleado() throws SQLException {

        System.out.print("ID a eliminar: ");
        int id = sc.nextInt();

        if (dao.eliminar(id)) {
            System.out.println("Empleado eliminado.");
        } else {
            System.out.println("No existe ese empleado.");
        }
    }
}



