package EjercicioTest;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Test {

    private final List<Pregunta> preguntas = new ArrayList<>();
    private final String rutaArchivoPreguntas;

    public Test(String rutaArchivoPreguntas) {
        this.rutaArchivoPreguntas = rutaArchivoPreguntas;
    }

    public void cargarPreguntas() {
        Path ruta = Paths.get(rutaArchivoPreguntas);
        try (BufferedReader br = new BufferedReader(new FileReader(ruta.toFile()))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                if (linea.startsWith(";P;")) {
                    preguntas.add(leerPregunta(br, linea));
                }
            }

        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al cargar las preguntas: " + e.getMessage());
        }
    }

    private Pregunta leerPregunta(BufferedReader br, String primeraLinea) throws IOException {
        String enunciado = primeraLinea.substring(3);
        List<String> opciones = new ArrayList<>();

        String linea;
        while ((linea = br.readLine()) != null && !linea.startsWith(";R;")) {
            opciones.add(linea);
        }

        int opcionCorrecta = Integer.parseInt(linea.substring(3));
        double puntos = Double.parseDouble(br.readLine());

        return new Pregunta(enunciado, opciones, opcionCorrecta, puntos);
    }

    public void realizarTest() {
        try (Scanner sc = new Scanner(System.in)) {
            double puntuacionTotal = 0;

            for (Pregunta pregunta : preguntas) {
                pregunta.mostrarPregunta();
                int respuesta = leerRespuesta(sc, pregunta.getNumeroOpciones());

                if (pregunta.comprobarOpcionCorrecta(respuesta)) {
                    System.out.println("Respuesta correcta\n");
                    puntuacionTotal += pregunta.getPuntos();
                } else {
                    System.out.println("Respuesta incorrecta\n");
                }
            }

            System.out.println("Puntuación final: " + puntuacionTotal);
        }
    }

    private int leerRespuesta(Scanner sc, int maxOpciones) {
        int respuesta;
        do {
            System.out.print("Elige una opción (1-" + maxOpciones + "): ");
            while (!sc.hasNextInt()) {
                sc.next();
                System.out.print("Entrada no válida. Intenta de nuevo: ");
            }
            respuesta = sc.nextInt();
        } while (respuesta < 1 || respuesta > maxOpciones);

        return respuesta;
    }

    public static void main(String[] args) {
        Test test = new Test("C:\\Users\\acer\\IdeaProjects\\Programacion\\src\\main\\java\\EjercicioTest\\examen.txt");
        test.cargarPreguntas();
        test.realizarTest();
    }
}
