package EjercicioTest;

import java.util.List;

public class Pregunta {

    private final String enunciado;
    private final List<String> opciones;
    private final int opcionCorrecta;
    private final double puntos;

    public Pregunta(String enunciado, List<String> opciones, int opcionCorrecta, double puntos) {
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.opcionCorrecta = opcionCorrecta;
        this.puntos = puntos;
    }

    public void mostrarPregunta() {
        System.out.println(enunciado);
        for (int i = 0; i < opciones.size(); i++) {
            System.out.println((i + 1) + ". " + opciones.get(i));
        }
    }

    public boolean comprobarOpcionCorrecta(int opcionUsuario) {
        return opcionUsuario == opcionCorrecta;
    }

    public int getNumeroOpciones() {
        return opciones.size();
    }

    public double getPuntos() {
        return puntos;
    }
}
