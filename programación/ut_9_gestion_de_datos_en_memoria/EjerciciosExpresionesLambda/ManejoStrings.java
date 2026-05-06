package POO.EjerciciosExpresionesLambda;


import java.util.List;
import java.util.stream.Collectors;

//8. Manejo de Strings con Expresiones Lambda:

public class ManejoStrings {
    public static void main(String[] args) {
        List<String> palabras = List.of("java", "python", "c++", "javascript");

        List<String> mayusculas = palabras.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        List<String> filtradas = palabras.stream()
                .filter(s -> s.contains("a"))
                .collect(Collectors.toList());

        System.out.println("Palabras en mayúsculas: " + mayusculas);
        System.out.println("Palabras que contienen 'a': " + filtradas);
    }
}