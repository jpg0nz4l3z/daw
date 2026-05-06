package pooBloque2.ejercicio3;

public class Estudiante extends Persona {

    private int curso;

    public Estudiante(String nombre, String apellido, String dni, String estadoCivil, int curso) {
        super(nombre, apellido, dni, estadoCivil);
        this.curso = curso;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return super.toString() + ", curso=" + curso;
    }
}
