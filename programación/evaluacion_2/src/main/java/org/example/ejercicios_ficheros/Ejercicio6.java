package org.example.ejercicios_ficheros;

import java.io.*;
import java.util.*;

public class Ejercicio6 {
    private static final String FILE = "datos.dat";

    private static final long POS_INT = 0;           // 4 bytes
    private static final long POS_DOUBLE = 4;        // 8 bytes -> hasta 12
    private static final long POS_STRING = 12;       // string fija
    private static final int STR_LEN = 30;           // 30 chars * 2 bytes = 60 bytes

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1) Crear/llenar archivo
        try (RandomAccessFile raf = new RandomAccessFile(FILE, "rw")) {
            raf.setLength(0); // limpiar

            raf.seek(POS_INT);
            raf.writeInt(12345);

            raf.seek(POS_DOUBLE);
            raf.writeDouble(99.75);

            raf.seek(POS_STRING);
            writeFixedString(raf, "Hola RandomAccessFile", STR_LEN);

            System.out.println("Archivo creado: " + new File(FILE).getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error creando archivo: " + e.getMessage());
            return;
        }

        // 2) Menú lectura
        while (true) {
            System.out.println("\n¿Qué dato quieres leer?");
            System.out.println("1) Entero");
            System.out.println("2) Decimal (double)");
            System.out.println("3) Cadena");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            String op = sc.nextLine().trim();

            try (RandomAccessFile raf = new RandomAccessFile(FILE, "r")) {
                switch (op) {
                    case "1" -> {
                        raf.seek(POS_INT);
                        System.out.println("Entero = " + raf.readInt());
                    }
                    case "2" -> {
                        raf.seek(POS_DOUBLE);
                        System.out.println("Double = " + raf.readDouble());
                    }
                    case "3" -> {
                        raf.seek(POS_STRING);
                        System.out.println("Cadena = " + readFixedString(raf, STR_LEN));
                    }
                    case "0" -> { return; }
                    default -> System.out.println("Opción inválida");
                }
            } catch (IOException e) {
                System.out.println("Error leyendo: " + e.getMessage());
            }
        }
    }

    private static void writeFixedString(RandomAccessFile raf, String s, int len) throws IOException {
        StringBuilder sb = new StringBuilder(s);
        if (sb.length() > len) sb.setLength(len);
        while (sb.length() < len) sb.append(' ');

        for (int i = 0; i < len; i++) raf.writeChar(sb.charAt(i));
    }

    private static String readFixedString(RandomAccessFile raf, int len) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) sb.append(raf.readChar());
        return sb.toString().trim();
    }
}
