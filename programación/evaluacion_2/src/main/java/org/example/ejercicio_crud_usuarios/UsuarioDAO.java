package org.example.ejercicio_crud_usuarios;

import org.example.ConexionMySql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    // CREATE
    public boolean insertar(Usuario u) {
        String sql = "INSERT INTO usuarios (nombre, email) VALUES (?, ?)";
        try (Connection con = ConexionMySql.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, u.getNombre());
            ps.setString(2, u.getEmail());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error insertando usuario: " + e.getMessage());
            return false;
        }
    }

    // READ (listar todos)
    public List<Usuario> listar() {
        String sql = "SELECT id, nombre, email FROM usuarios";
        List<Usuario> lista = new ArrayList<>();

        try (Connection con = ConexionMySql.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Usuario u = new Usuario(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("email")
                );
                lista.add(u);
            }

        } catch (SQLException e) {
            System.err.println("Error listando usuarios: " + e.getMessage());
        }
        return lista;
    }

    // READ (por id)
    public Usuario buscarPorId(int id) {
        String sql = "SELECT id, nombre, email FROM usuarios WHERE id = ?";
        try (Connection con = ConexionMySql.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("email")
                    );
                }
            }

        } catch (SQLException e) {
            System.err.println("Error buscando usuario: " + e.getMessage());
        }
        return null;
    }

    // UPDATE
    public boolean actualizar(Usuario u) {
        String sql = "UPDATE usuarios SET nombre = ?, email = ? WHERE id = ?";
        try (Connection con = ConexionMySql.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, u.getNombre());
            ps.setString(2, u.getEmail());
            ps.setInt(3, u.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error actualizando usuario: " + e.getMessage());
            return false;
        }
    }

    // DELETE
    public boolean eliminar(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (Connection con = ConexionMySql.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error eliminando usuario: " + e.getMessage());
            return false;
        }
    }
}