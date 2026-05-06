package org.example.ejercicios_ficheros;

import java.io.*;
import java.util.*;

public class Ejercicio7 {
    private static final String FILE = "usuarios.dat";
    private static final int NAME_LEN = 20;                 // 20 chars
    private static final int RECORD_SIZE = 4 + (NAME_LEN * 2); // int + chars

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Crear archivo de ejemplo si no existe
        if (!new File(FILE).exists()) {
            try (RandomAccessFile raf = new RandomAccessFile(FILE, "rw")) {
                addUser(raf, 1, "Ana");
                addUser(raf, 2, "Luis");
                addUser(raf, 3, "Marta");
                System.out.println("Creado archivo de ejemplo: " + new File(FILE).getAbsolutePath());
            } catch (IOException e) {
                System.out.println("Error creando: " + e.getMessage());
                return;
            }
        }

        System.out.println("\nUsuarios actuales:");
        listarUsuarios();

        System.out.print("\nID a modificar: ");
        int id = leerInt(sc);

        System.out.print("Nuevo nombre: ");
        String nuevo = sc.nextLine();

        boolean ok = modificarNombrePorId(id, nuevo);
        System.out.println(ok ? "✅ Modificado" : "❌ ID no encontrado");

        System.out.println("\nUsuarios después:");
        listarUsuarios();
    }

    private static void addUser(RandomAccessFile raf, int id, String name) throws IOException {
        raf.seek(raf.length());
        raf.writeInt(id);
        writeFixedString(raf, name, NAME_LEN);
    }

    private static boolean modificarNombrePorId(int idBuscado, String nuevoNombre) {
        try (RandomAccessFile raf = new RandomAccessFile(FILE, "rw")) {
            long nRegs = raf.length() / RECORD_SIZE;

            for (int i = 0; i < nRegs; i++) {
                long pos = (long) i * RECORD_SIZE;
                raf.seek(pos);
                int id = raf.readInt();

                if (id == idBuscado) {
                    // estamos justo después del int -> empieza nombre
                    writeFixedString(raf, nuevoNombre, NAME_LEN);
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    private static void listarUsuarios() {
        try (RandomAccessFile raf = new RandomAccessFile(FILE, "r")) {
            long nRegs = raf.length() / RECORD_SIZE;
            for (int i = 0; i < nRegs; i++) {
                raf.seek((long) i * RECORD_SIZE);
                int id = raf.readInt();
                String nombre = readFixedString(raf, NAME_LEN);
                System.out.println("ID=" + id + " | Nombre=" + nombre);
            }
        } catch (IOException e) {
            System.out.println("Error listando: " + e.getMessage());
        }
    }

    private static void writeFixedString(RandomAccessFile raf, String s, int len) throws IOException {
        StringBuilder sb = new StringBuilder(s == null ? "" : s);
        if (sb.length() > len) sb.setLength(len);
        while (sb.length() < len) sb.append(' ');
        for (int i = 0; i < len; i++) raf.writeChar(sb.charAt(i));
    }

    private static String readFixedString(RandomAccessFile raf, int len) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) sb.append(raf.readChar());
        return sb.toString().trim();
    }

    private static int leerInt(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Número inválido. Intenta de nuevo: ");
            }
        }
    }
}
