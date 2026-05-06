package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySql {

    private static final String URL = "jdbc:mysql://localhost:3306/pruebas?useSSL=false&serverTimezone=UTC";

    //private static final String URL =
    //"jdbc:mysql://localhost:3306/tu_base_datos?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=UTF-8";

    private static final String USER = "root";
    private static final String PASSWORD = "TuContraseñaSegura123!";

    private static Connection conexion;

    public static Connection getConexion() {
        try {
            if (conexion == null || conexion.isClosed()) {
                conexion = DriverManager.getConnection(URL, USER, PASSWORD);
                //System.out.println("Conexión exitosa a MySQL");
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar a MySQL: " + e.getMessage());
        }
        return conexion;
    }

    public static void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }

    public static void main(){
        Connection conn = ConexionMySql.getConexion();

        if (conn != null) {
            System.out.println("Listo para trabajar con la base de datos.");
        }

        ConexionMySql.cerrarConexion();
    }
}