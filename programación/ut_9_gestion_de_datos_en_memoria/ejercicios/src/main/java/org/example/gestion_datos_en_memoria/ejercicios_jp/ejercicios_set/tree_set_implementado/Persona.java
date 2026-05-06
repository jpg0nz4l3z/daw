package org.example.gestion_datos_en_memoria.ejercicios_jp.ejercicios_set.tree_set_implementado;

import java.util.Comparator;
import java.util.Objects;

public class Persona implements Comparable<Persona> {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(nombre, persona.nombre) && Objects.equals(edad, persona.edad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }

    @Override
    public int compareTo(Persona otra) {
        int res = Integer.compare(this.edad, otra.edad);
        if (res == 0) {
            return this.nombre.compareTo(otra.nombre);
        }
        return res;
    }

}
