package pooBloque2.ejercicio3;

public class test {
    public static void main(String[] args) {
        Profesor profesor = new Profesor("Juan", "González", "Z3098723N", "casado", "12-03-2025", Departamento.ciencias);
        PersonalServicio personalServicio = new PersonalServicio("Pedro", "Hernandez", "A9828374L", "Soltero", "12-03-2025", Seccion.jardin);
        Estudiante estudiante = new Estudiante("Pedro", "Hernandez", "A9828374L", "Soltero", 2);

        Persona[] personas = {profesor, personalServicio, estudiante};

        for (Persona persona : personas) {
            System.out.println(persona.toString());
            System.out.println();
        }

    }
}
