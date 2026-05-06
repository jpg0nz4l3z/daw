package org.example.ejercicios_viejos.biblioteca;

import java.sql.SQLException;
import java.util.Scanner;

public class ProbarBiblioteca {

    public static void main(String[] args) {

        try {
            GestorBiblioteca gb = new GestorBiblioteca();
            Scanner sc = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("""
                --- MENÚ BIBLIOTECA ---
                1. Agregar libro
                2. Registrar usuario
                3. Realizar préstamo
                4. Devolver libro
                5. Mostrar préstamos activos
                6. Libros disponibles
                7. Libros por usuario
                8. Salir
                """);

                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1 -> {
                        System.out.print("Título: ");
                        String t = sc.nextLine();
                        System.out.print("Autor: ");
                        String a = sc.nextLine();
                        gb.agregarLibro(t, a);
                    }
                    case 2 -> {
                        System.out.print("Nombre: ");
                        String n = sc.nextLine();
                        System.out.print("Email: ");
                        String e = sc.nextLine();
                        gb.registrarUsuario(n, e);
                    }
                    case 3 -> {
                        System.out.print("ID Usuario: ");
                        int u = sc.nextInt();
                        System.out.print("ID Libro: ");
                        int l = sc.nextInt();
                        gb.realizarPrestamo(u, l);
                    }
                    case 4 -> {
                        System.out.print("ID Préstamo: ");
                        int p = sc.nextInt();
                        gb.devolverLibro(p);
                    }
                    case 5 -> gb.mostrarPrestamosActivos();
                    case 6 -> gb.mostrarLibrosDisponibles();
                    case 7 -> {
                        System.out.print("Email usuario: ");
                        String e = sc.nextLine();
                        gb.librosPorUsuario(e);
                    }
                    case 8 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción incorrecta");
                }

            } while (opcion != 8);

        } catch (SQLException e) {
            System.out.println("Error en la base de datos: " + e.getMessage());
        }
    }
}

