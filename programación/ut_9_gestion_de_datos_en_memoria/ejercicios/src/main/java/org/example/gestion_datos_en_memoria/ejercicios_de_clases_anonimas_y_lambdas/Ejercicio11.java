package org.example.gestion_datos_en_memoria.ejercicios_de_clases_anonimas_y_lambdas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getter de edad (necesario para usar ::)
    public int getEdad() {
        return edad;
    }

    // toString para imprimir
    @Override
    public String toString() {
        return nombre + " (" + edad + " años)";
    }
}

public class Ejercicio11 {

    public static void main(String[] args) {

        List<Persona> personas = new ArrayList<>();

        // Añadir personas
        personas.add(new Persona("Juan", 25));
        personas.add(new Persona("Ana", 17));
        personas.add(new Persona("Carlos", 30));
        personas.add(new Persona("María", 15));
        personas.add(new Persona("Pedro", 20));

        // Eliminar menores de 18
        personas.removeIf(p -> p.getEdad() < 18);

        // Ordenar por edad descendente usando ::
        personas.sort(Comparator.comparing(Persona::getEdad).reversed());

        // Mostrar resultado
        System.out.println("Lista final:");
        personas.forEach(System.out::println);
    }
}