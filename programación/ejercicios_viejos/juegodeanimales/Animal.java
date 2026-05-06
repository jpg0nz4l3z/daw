package juegodeanimales;
import java.io.Serializable;

public abstract class Animal implements Serializable {
    protected String nombre;
    protected int edad;

    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public abstract String hablar();

    public String getClase() {
        return this.getClass().getSimpleName();
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}
