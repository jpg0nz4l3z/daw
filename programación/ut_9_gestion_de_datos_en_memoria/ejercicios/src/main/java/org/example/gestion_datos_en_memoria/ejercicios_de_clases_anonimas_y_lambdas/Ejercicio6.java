package org.example.gestion_datos_en_memoria.ejercicios_de_clases_anonimas_y_lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Producto {
    String nombre;
    double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre + " - " + precio + "€";
    }
}

public class Ejercicio6 {

    public static void main(String[] args) {

        // Lista de productos
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Pan", 1.5));
        productos.add(new Producto("Queso", 25));
        productos.add(new Producto("Leche", 2));
        productos.add(new Producto("Jamón", 30));
        productos.add(new Producto("Huevos", 3));

        // Eliminar productos con precio < 20 usando clase anónima
        productos.removeIf(new Predicate<Producto>() {
            @Override
            public boolean test(Producto p) {
                return p.precio < 20;
            }
        });

        // Mostrar lista final
        System.out.println("Productos con precio >= 20€:");
        for (Producto p : productos) {
            System.out.println(p);
        }
    }
}
