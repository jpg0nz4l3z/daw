package org.example.biblioteca;

import java.sql.*;
import java.time.LocalDate;

public class GestorBiblioteca {

    private Connection con;
    private Statement st;

    public GestorBiblioteca() throws SQLException {
        con = ConexionBD.getConexion();
        st = con.createStatement();
    }

    // 1. Agregar libro
    public void agregarLibro(String titulo, String autor) throws SQLException {
        String sql =
                "INSERT INTO libros (titulo, autor, disponible) VALUES ('"
                        + titulo + "','" + autor + "', true)";
        st.executeUpdate(sql);
        System.out.println("Libro agregado correctamente.");
    }

    // 2. Registrar usuario
    public void registrarUsuario(String nombre, String email) throws SQLException {
        String sql =
                "INSERT INTO usuarios (nombre, email) VALUES ('"
                        + nombre + "','" + email + "')";
        st.executeUpdate(sql);
        System.out.println("Usuario registrado correctamente.");
    }

    // 3. Realizar préstamo
    public void realizarPrestamo(int idUsuario, int idLibro) throws SQLException {

        ResultSet rsLibro =
                st.executeQuery("SELECT disponible FROM libros WHERE id=" + idLibro);

        if (!rsLibro.next()) {
            System.out.println("Libro no encontrado.");
            return;
        }

        if (!rsLibro.getBoolean("disponible")) {
            System.out.println("El libro no está disponible.");
            return;
        }

        ResultSet rsUsuario =
                st.executeQuery("SELECT id FROM usuarios WHERE id=" + idUsuario);

        if (!rsUsuario.next()) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        String fecha = LocalDate.now().toString();

        st.executeUpdate(
                "INSERT INTO prestamos (id_usuario, id_libro, fecha_prestamo) VALUES ("
                        + idUsuario + "," + idLibro + ",'" + fecha + "')"
        );

        st.executeUpdate(
                "UPDATE libros SET disponible=false WHERE id=" + idLibro
        );

        System.out.println("Préstamo realizado correctamente.");
    }

    // 4. Registrar devolución
    public void devolverLibro(int idPrestamo) throws SQLException {

        ResultSet rs =
                st.executeQuery("SELECT id_libro FROM prestamos WHERE id=" + idPrestamo
                        + " AND fecha_devolucion IS NULL");

        if (!rs.next()) {
            System.out.println("Préstamo no encontrado o ya devuelto.");
            return;
        }

        int idLibro = rs.getInt("id_libro");
        String fecha = LocalDate.now().toString();

        st.executeUpdate(
                "UPDATE prestamos SET fecha_devolucion='" + fecha +
                        "' WHERE id=" + idPrestamo
        );

        st.executeUpdate(
                "UPDATE libros SET disponible=true WHERE id=" + idLibro
        );

        System.out.println("Devolución registrada correctamente.");
    }

    // 5. Préstamos activos
    public void mostrarPrestamosActivos() throws SQLException {
        ResultSet rs = st.executeQuery(
                "SELECT p.id, u.nombre, l.titulo, p.fecha_prestamo " +
                        "FROM prestamos p " +
                        "JOIN usuarios u ON p.id_usuario = u.id " +
                        "JOIN libros l ON p.id_libro = l.id " +
                        "WHERE p.fecha_devolucion IS NULL"
        );

        while (rs.next()) {
            System.out.println(
                    "Préstamo ID: " + rs.getInt("id") +
                            " | Usuario: " + rs.getString("nombre") +
                            " | Libro: " + rs.getString("titulo") +
                            " | Fecha: " + rs.getDate("fecha_prestamo")
            );
        }
    }

    // 6. Libros disponibles
    public void mostrarLibrosDisponibles() throws SQLException {
        ResultSet rs =
                st.executeQuery("SELECT * FROM libros WHERE disponible=true");

        while (rs.next()) {
            System.out.println(
                    rs.getInt("id") + " - " +
                            rs.getString("titulo") + " (" +
                            rs.getString("autor") + ")"
            );
        }
    }

    // 7. Libros prestados a un usuario por email
    public void librosPorUsuario(String email) throws SQLException {

        ResultSet rs =
                st.executeQuery(
                        "SELECT l.titulo, p.fecha_prestamo " +
                                "FROM prestamos p " +
                                "JOIN usuarios u ON p.id_usuario = u.id " +
                                "JOIN libros l ON p.id_libro = l.id " +
                                "WHERE u.email='" + email + "' " +
                                "AND p.fecha_devolucion IS NULL"
                );

        if (!rs.next()) {
            System.out.println("No hay préstamos para ese usuario.");
            return;
        }

        do {
            System.out.println(
                    "Libro: " + rs.getString("titulo") +
                            " | Fecha préstamo: " + rs.getDate("fecha_prestamo")
            );
        } while (rs.next());
    }
}
