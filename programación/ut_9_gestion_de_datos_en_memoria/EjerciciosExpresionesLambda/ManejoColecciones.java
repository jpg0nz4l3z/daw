package POO.EjerciciosExpresionesLambda;


    //5. Manejo de Colecciones con Expresiones Lambda:


import java.util.List;

public class ManejoColecciones {
        public static void main(String[] args) {
            List<String> palabras = List.of("Java", "Python", "C++", "JavaScript");

            palabras.sort((s1, s2) -> s1.compareToIgnoreCase(s2));

            List<String> filtradas = palabras.stream()
                    .filter(s -> s.startsWith("J"))
                    .toList();

            System.out.println("Lista ordenada: " + palabras);
            System.out.println("Palabras que comienzan con 'J': " + filtradas);
        }
    }
