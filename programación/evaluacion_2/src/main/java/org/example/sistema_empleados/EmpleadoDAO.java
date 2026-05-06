package org.example.sistema_empleados;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    // CREATE
    public void crear(Empleado e) throws SQLException {
        String sql = "INSERT INTO empleados (id, nombre, tipo, salario) VALUES (?, ?, ?, ?)";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, e.getId());
            ps.setString(2, e.getNombre());
            ps.setString(3, tipoDe(e));
            ps.setDouble(4, e.calcularSalario());

            ps.executeUpdate();
        }
    }

    // READ (uno por id)
    public Empleado leerPorId(int id) throws SQLException {
        String sql = "SELECT id, nombre, tipo, salario FROM empleados WHERE id = ?";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int empId = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String tipo = rs.getString("tipo");
                    double salario = rs.getDouble("salario");

                    // Reconstrucción simple (como en la tabla solo hay salario final)
                    // Creamos un objeto concreto por 'tipo' para mantener el polimorfismo.
                    if ("FIJO".equalsIgnoreCase(tipo)) {
                        return new EmpleadoFijo(empId, nombre, salario);
                    } else if ("HORAS".equalsIgnoreCase(tipo)) {
                        // Como no tenemos horas/precioHora, usamos una aproximación:
                        // guardamos salario como (horas * precioHora) con horas=1.
                        return new EmpleadoPorHoras(empId, nombre, 1, salario);
                    } else {
                        // fallback razonable
                        return new EmpleadoFijo(empId, nombre, salario);
                    }
                }
            }
        }
        return null;
    }

    // READ (todos)
    public List<Empleado> listar() throws SQLException {
        String sql = "SELECT id, nombre, tipo, salario FROM empleados";
        List<Empleado> lista = new ArrayList<>();

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String tipo = rs.getString("tipo");
                double salario = rs.getDouble("salario");

                if ("FIJO".equalsIgnoreCase(tipo)) {
                    lista.add(new EmpleadoFijo(id, nombre, salario));
                } else {
                    lista.add(new EmpleadoPorHoras(id, nombre, 1, salario));
                }
            }
        }

        return lista;
    }

    // UPDATE (nombre y/o tipo y recalcula salario a partir del objeto)
    public boolean actualizar(Empleado e) throws SQLException {
        String sql = "UPDATE empleados SET nombre = ?, tipo = ?, salario = ? WHERE id = ?";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, e.getNombre());
            ps.setString(2, tipoDe(e));
            ps.setDouble(3, e.calcularSalario());
            ps.setInt(4, e.getId());

            return ps.executeUpdate() > 0;
        }
    }

    // DELETE
    public boolean eliminar(int id) throws SQLException {
        String sql = "DELETE FROM empleados WHERE id = ?";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    // Utilidad: detectar tipo para la columna "tipo"
    private String tipoDe(Empleado e) {
        if (e instanceof EmpleadoFijo) return "FIJO";
        if (e instanceof EmpleadoPorHoras) return "HORAS";
        return "DESCONOCIDO";
    }
}
