package org.example.sistema_empleados;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FicheroEmpleado {

    public static void escribir(String ruta, List<Empleado> empleados) throws IOException {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {

            for (Empleado e : empleados) {
                String tipo = (e instanceof EmpleadoFijo) ? "FIJO" : "HORAS";

                bw.write(e.getId() + ";" +
                        e.getNombre() + ";" +
                        tipo + ";" +
                        e.calcularSalario());

                bw.newLine();
            }
        }
    }

    public static List<Empleado> leer(String ruta) throws IOException {

        List<Empleado> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(";");

                int id = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                String tipo = datos[2];
                double salario = Double.parseDouble(datos[3]);

                if (tipo.equalsIgnoreCase("FIJO")) {
                    lista.add(new EmpleadoFijo(id, nombre, salario));
                } else {
                    lista.add(new EmpleadoPorHoras(id, nombre, 1, salario));
                }
            }
        }

        return lista;
    }
}

