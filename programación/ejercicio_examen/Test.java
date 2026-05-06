import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    private ArrayList<Pregunta> preguntas;
    private String rutaArchivoPreguntas;
    private double puntuacion;

    public Test(String rutaArchivoPreguntas) {
        this.rutaArchivoPreguntas = rutaArchivoPreguntas;
        preguntas = new ArrayList<>();
    }

    public void cargarPreguntas() {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoPreguntas))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                if (linea.startsWith(";P;")) {
                    String enunciado = linea.substring(3);
                    ArrayList<String> opciones = new ArrayList<>();
                    int respuesta = 0;
                    double puntos = 0;


                    for (int i = 0; i < 4; i++) {
                        String nextLine = br.readLine();
                        if (nextLine.startsWith(";R;")) {
                            break;
                        } else {
                            opciones.add(nextLine);
                        }
                    }

                    respuesta = Integer.parseInt(br.readLine().substring(3));
                    puntos = Integer.parseInt(br.readLine());

                    Pregunta pregunta = new Pregunta(enunciado, opciones, respuesta, puntos);
                    preguntas.add(pregunta);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void realizarTest() {
        Scanner sc = new Scanner(System.in);

        for (var pregunta : preguntas) {
            pregunta.mostrarPregunta();
            System.out.println("Escribe tu opción de respuesta");
            System.out.println();
            if (pregunta.comprobarOpcionCorrecta(sc.nextInt())) {
                System.out.println("Respuesta correcta");
                puntuacion += pregunta.getPuntos();
            } else {
                System.out.println("Respuesta incorrecta");
            }
            System.out.println();
        }
        System.out.println("La puntuacion es: " + puntuacion);
    }

}
