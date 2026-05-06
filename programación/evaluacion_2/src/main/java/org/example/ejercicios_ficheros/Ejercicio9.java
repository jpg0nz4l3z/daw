package org.example.ejercicios_ficheros;

import com.google.gson.Gson;

class Alumno {
    String nombre;
    String curso;
    double calificacion;

    Alumno(String nombre, String curso, double calificacion) {
        this.nombre = nombre;
        this.curso = curso;
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Alumno{nombre='" + nombre + "', curso='" + curso + "', calificacion=" + calificacion + "}";
    }
}

public class Ejercicio9 {
    public static void main(String[] args) {
        Gson gson = new Gson();

        Alumno a1 = new Alumno("Juan", "DAM", 8.7);

        // Objeto -> JSON
        String json = gson.toJson(a1);
        System.out.println("JSON:");
        System.out.println(json);

        // JSON -> Objeto
        Alumno a2 = gson.fromJson(json, Alumno.class);
        System.out.println("\nObjeto recuperado:");
        System.out.println(a2);
    }
}
