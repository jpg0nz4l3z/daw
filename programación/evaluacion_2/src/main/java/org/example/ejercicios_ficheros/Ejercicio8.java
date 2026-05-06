package org.example.ejercicios_ficheros;


import java.io.*;
import java.util.*;

class Persona implements Serializable {
    private static final long serialVersionUID = 1L;

    String nombre;
    int edad;
    String email;

    Persona(String nombre, int edad, String email) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persona{nombre='" + nombre + "', edad=" + edad + ", email='" + email + "'}";
    }
}

public class Ejercicio8 {
    private static final String FILE = "personas.dat";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Persona> personas = new ArrayList<>();

        System.out.print("¿Cuántas personas quieres crear? ");
        int n = leerEnteroPositivo(sc);

        for (int i = 0; i < n; i++) {
            System.out.println("\nPersona " + (i + 1));
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Edad: ");
            int edad = leerEnteroPositivo(sc);
            System.out.print("Email: ");
            String email = sc.nextLine();
            personas.add(new Persona(nombre, edad, email));
        }

        // Serializar
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE))) {
            oos.writeObject(personas);
            System.out.println("\n✅ Guardadas en " + new File(FILE).getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error guardando: " + e.getMessage());
            return;
        }

        // Deserializar
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE))) {
            @SuppressWarnings("unchecked")
            List<Persona> leidas = (List<Persona>) ois.readObject();
            System.out.println("\nContenido leído del archivo:");
            leidas.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error leyendo: " + e.getMessage());
        }
    }

    private static int leerEnteroPositivo(Scanner sc) {
        while (true) {
            try {
                int v = Integer.parseInt(sc.nextLine().trim());
                if (v <= 0) {
                    System.out.print("Debe ser > 0. Intenta otra vez: ");
                    continue;
                }
                return v;
            } catch (NumberFormatException e) {
                System.out.print("Número inválido. Intenta otra vez: ");
            }
        }
    }
}
