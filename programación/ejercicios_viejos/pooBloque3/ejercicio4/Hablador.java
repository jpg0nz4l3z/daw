package pooBloque3.ejercicio4;

public interface Hablador {
    void saludar();

    default void metodoImplementado() {
        System.out.println("Implementado desde una interface");
    }

    static void metodoImplementadoStatic() {
        System.out.println("Implementado desde una interface");
    }
}

abstract class Animal implements Hablador {

    public void saludar() {
        System.out.println("Saludo animal");
    }
}

abstract class Persona {
    private String nombre;
    private String apellido;

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}

class Gato extends Animal {
    @Override
    public void saludar() {
        System.out.println("Miau..");
    }
}

class Perro extends Animal {
    @Override
    public void saludar() {
        System.out.println("Guau..");
    }
}

class Espaniol implements Hablador {

    public void saludar() {
        System.out.println("Saludo español");
    }
}


