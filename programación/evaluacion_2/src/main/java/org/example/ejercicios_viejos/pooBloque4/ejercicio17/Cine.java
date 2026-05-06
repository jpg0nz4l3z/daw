package org.example.ejercicios_viejos.pooBloque4.ejercicio17;

import java.util.concurrent.ThreadLocalRandom;

public class Cine {
    private Pelicula peliculaEnReproduccion;
    private double precioEntrada;
    private Espectador[][] sala = new Espectador[8][8];

    public Cine(Pelicula peliculaEnReproduccion, double precioEntrada) {
        this.peliculaEnReproduccion = peliculaEnReproduccion;
        this.precioEntrada = precioEntrada;
    }

    public void llenarSala() {
        for (int i = 0, contadorEspec = 1; i < sala.length; i++) {
            for (int j = 0; j < sala.length; j++) {
                sala[i][j] = new Espectador("Espectador "+contadorEspec,
                        ThreadLocalRandom.current().nextInt(1, 25),
                        ThreadLocalRandom.current().nextInt(100, 1000));
                        contadorEspec++;
            }
        }
    }

    //

}

class Pelicula {
    private String titulo;
    private int duracionMinutos;
    private int edadMinima;
    private String director;

    public Pelicula(String titulo, int duracionMinutos, int edadMinima, String director) {
        this.titulo = titulo;
        this.duracionMinutos = duracionMinutos;
        this.edadMinima = edadMinima;
        this.director = director;
    }
}

class Espectador {
    private String nombre;
    private int edad;
    private double cantidadDinero;

    public Espectador(String nombre, int edad, double cantidadDinero) {
        this.nombre = nombre;
        this.edad = edad;
        this.cantidadDinero = cantidadDinero;
    }
}
