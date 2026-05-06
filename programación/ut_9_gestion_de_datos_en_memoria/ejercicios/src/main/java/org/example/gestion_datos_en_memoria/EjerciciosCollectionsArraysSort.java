package org.example.gestion_datos_en_memoria;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Ejercicios extra del Tema 8: Arrays.sort(), Collections.sort(), Comparator,
 * Comparable, búsquedas, ordenaciones y utilidades de Collections.
 *
 * Cada ejercicio está separado en un método static para poder invocarlo desde main.
 */
public class EjerciciosCollectionsArraysSort {

    public static void main(String[] args) {
        ejercicio01ArraysSortEnteros();
        ejercicio02ArraysSortStrings();
        ejercicio03ArraysSortDescendenteConInteger();
        ejercicio04ArraysBinarySearch();
        ejercicio05CollectionsSortEnteros();
        ejercicio06CollectionsSortStringsPorLongitud();
        ejercicio07CollectionsSortDescendente();
        ejercicio08ComparablePersonaPorNombre();
        ejercicio09ComparatorPersonaPorEdad();
        ejercicio10ComparatorComparing();
        ejercicio11OrdenMultipleEdadYNombre();
        ejercicio12CollectionsMaxMin();
        ejercicio13CollectionsShuffle();
        ejercicio14CollectionsReverse();
        ejercicio15CollectionsFrequency();
        ejercicio16StreamSortedNatural();
        ejercicio17StreamSortedDescendente();
        ejercicio18StreamFiltrarYOrdenar();
        ejercicio19TreeSetEliminarDuplicadosYOrdenar();
        ejercicio20ContarPalabrasConHashMap();
        ejercicio21PipelineCompleto();
        ejercicio22ComparatorLongitudInversa();
        ejercicio23OrdenarObjetosPorMultiplesCampos();
        ejercicio24BuscarElementoMasLargoConStreams();
        ejercicio25AgruparPalabrasPorLongitud();
    }

    private static void separador(String titulo) {
        System.out.println("\n========== " + titulo + " ==========");
    }

    /**
     * Ejercicio 1: Ordenar un array primitivo de enteros con Arrays.sort().
     * Arrays.sort(int[]) modifica el array original y lo ordena de menor a mayor.
     */
    public static void ejercicio01ArraysSortEnteros() {
        separador("01 - Arrays.sort con int[]");
        int[] numeros = {5, 2, 9, 1, 4};
        Arrays.sort(numeros);
        System.out.println(Arrays.toString(numeros));
    }

    /**
     * Ejercicio 2: Ordenar un array de String alfabéticamente.
     * String ya implementa Comparable, por eso Java conoce su orden natural.
     */
    public static void ejercicio02ArraysSortStrings() {
        separador("02 - Arrays.sort con String[]");
        String[] nombres = {"Luis", "Ana", "Marta"};
        Arrays.sort(nombres);
        System.out.println(Arrays.toString(nombres));
    }

    /**
     * Ejercicio 3: Ordenar de forma descendente usando Collections.reverseOrder().
     * Importante: reverseOrder() necesita objetos, por eso usamos Integer[] y no int[].
     */
    public static void ejercicio03ArraysSortDescendenteConInteger() {
        separador("03 - Arrays.sort descendente con Integer[]");
        Integer[] numeros = {5, 2, 9, 1, 4};
        Arrays.sort(numeros, Collections.reverseOrder());
        System.out.println(Arrays.toString(numeros));
    }

    /**
     * Ejercicio 4: Buscar un elemento con Arrays.binarySearch().
     * La búsqueda binaria exige que el array esté previamente ordenado.
     */
    public static void ejercicio04ArraysBinarySearch() {
        separador("04 - Arrays.binarySearch");
        int[] numeros = {5, 2, 9, 1, 4};
        Arrays.sort(numeros);
        int posicion = Arrays.binarySearch(numeros, 4);
        System.out.println("Array ordenado: " + Arrays.toString(numeros));
        System.out.println("Posición del 4: " + posicion);
    }

    /**
     * Ejercicio 5: Ordenar una lista de enteros con Collections.sort().
     * Collections.sort() modifica la lista original.
     */
    public static void ejercicio05CollectionsSortEnteros() {
        separador("05 - Collections.sort con List<Integer>");
        List<Integer> numeros = new ArrayList<>(Arrays.asList(5, 2, 9, 1, 4));
        Collections.sort(numeros);
        System.out.println(numeros);
    }

    /**
     * Ejercicio 6: Ordenar Strings por longitud usando Comparator con lambda.
     * En vez del orden alfabético, definimos nuestro propio criterio de ordenación.
     */
    public static void ejercicio06CollectionsSortStringsPorLongitud() {
        separador("06 - Collections.sort por longitud");
        List<String> nombres = new ArrayList<>(Arrays.asList("Ana", "Alejandro", "Luis", "Marta"));
        Collections.sort(nombres, (a, b) -> Integer.compare(a.length(), b.length()));
        System.out.println(nombres);
    }

    /**
     * Ejercicio 7: Ordenar una lista de mayor a menor.
     * Collections.reverseOrder() devuelve un Comparator descendente.
     */
    public static void ejercicio07CollectionsSortDescendente() {
        separador("07 - Collections.sort descendente");
        List<Integer> numeros = new ArrayList<>(Arrays.asList(5, 2, 9, 1, 4));
        Collections.sort(numeros, Collections.reverseOrder());
        System.out.println(numeros);
    }

    /**
     * Ejercicio 8: Usar Comparable para definir el orden natural de una clase.
     * PersonaComparable se ordena por nombre porque su compareTo compara nombres.
     */
    public static void ejercicio08ComparablePersonaPorNombre() {
        separador("08 - Comparable por nombre");
        List<PersonaComparable> personas = new ArrayList<>();
        personas.add(new PersonaComparable("Luis"));
        personas.add(new PersonaComparable("Ana"));
        personas.add(new PersonaComparable("Marta"));
        Collections.sort(personas);
        System.out.println(personas);
    }

    /**
     * Ejercicio 9: Usar Comparator externo para ordenar por edad.
     * La clase Persona no necesita implementar Comparable: el criterio viene desde fuera.
     */
    public static void ejercicio09ComparatorPersonaPorEdad() {
        separador("09 - Comparator por edad");
        List<Persona> personas = crearPersonas();
        Collections.sort(personas, (p1, p2) -> Integer.compare(p1.getEdad(), p2.getEdad()));
        System.out.println(personas);
    }

    /**
     * Ejercicio 10: Ordenar usando Comparator.comparing().
     * Es una forma más moderna y legible que escribir manualmente Integer.compare().
     */
    public static void ejercicio10ComparatorComparing() {
        separador("10 - Comparator.comparing");
        List<Persona> personas = crearPersonas();
        personas.sort(Comparator.comparing(Persona::getEdad));
        System.out.println(personas);
    }

    /**
     * Ejercicio 11: Orden múltiple.
     * Primero ordenamos por edad; si dos personas tienen la misma edad, por nombre.
     */
    public static void ejercicio11OrdenMultipleEdadYNombre() {
        separador("11 - Orden múltiple: edad y nombre");
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Luis", 20));
        personas.add(new Persona("Ana", 30));
        personas.add(new Persona("Marta", 20));
        personas.add(new Persona("Carlos", 30));

        personas.sort(Comparator.comparing(Persona::getEdad).thenComparing(Persona::getNombre));
        System.out.println(personas);
    }

    /**
     * Ejercicio 12: Obtener máximo y mínimo con Collections.max() y Collections.min().
     * Sirve cuando los elementos tienen orden natural o se proporciona un Comparator.
     */
    public static void ejercicio12CollectionsMaxMin() {
        separador("12 - Collections.max y Collections.min");
        List<Integer> numeros = Arrays.asList(5, 2, 9, 1, 4);
        int max = Collections.max(numeros);
        int min = Collections.min(numeros);
        System.out.println("Máximo: " + max);
        System.out.println("Mínimo: " + min);
    }

    /**
     * Ejercicio 13: Mezclar aleatoriamente una lista con Collections.shuffle().
     * Es útil para simular barajas, sorteos o aleatorizar datos de prueba.
     */
    public static void ejercicio13CollectionsShuffle() {
        separador("13 - Collections.shuffle");
        List<Integer> numeros = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Collections.shuffle(numeros);
        System.out.println(numeros);
    }

    /**
     * Ejercicio 14: Invertir el orden actual de una lista.
     * reverse() no ordena; simplemente da la vuelta al orden existente.
     */
    public static void ejercicio14CollectionsReverse() {
        separador("14 - Collections.reverse");
        List<Integer> numeros = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Collections.reverse(numeros);
        System.out.println(numeros);
    }

    /**
     * Ejercicio 15: Contar cuántas veces aparece un elemento.
     * Collections.frequency() recorre la colección y compara usando equals().
     */
    public static void ejercicio15CollectionsFrequency() {
        separador("15 - Collections.frequency");
        List<String> datos = Arrays.asList("Ana", "Luis", "Ana", "Ana", "Marta");
        int veces = Collections.frequency(datos, "Ana");
        System.out.println("Ana aparece " + veces + " veces");
    }

    /**
     * Ejercicio 16: Ordenar con Stream.sorted().
     * A diferencia de sort(), no modifica la lista original: crea un resultado nuevo.
     */
    public static void ejercicio16StreamSortedNatural() {
        separador("16 - Stream.sorted natural");
        List<Integer> numeros = Arrays.asList(5, 2, 9, 1, 4);
        List<Integer> resultado = numeros.stream().sorted().collect(Collectors.toList());
        System.out.println("Original: " + numeros);
        System.out.println("Ordenada: " + resultado);
    }

    /**
     * Ejercicio 17: Ordenar descendente con Streams.
     * sorted(Comparator.reverseOrder()) aplica un criterio de mayor a menor.
     */
    public static void ejercicio17StreamSortedDescendente() {
        separador("17 - Stream.sorted descendente");
        List<Integer> numeros = Arrays.asList(5, 2, 9, 1, 4);
        List<Integer> resultado = numeros.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(resultado);
    }

    /**
     * Ejercicio 18: Filtrar y ordenar.
     * Primero dejamos pasar solo pares y después ordenamos esos resultados.
     */
    public static void ejercicio18StreamFiltrarYOrdenar() {
        separador("18 - Stream filter + sorted");
        List<Integer> numeros = Arrays.asList(5, 2, 9, 1, 4, 8, 6);
        List<Integer> resultado = numeros.stream()
                .filter(x -> x % 2 == 0)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(resultado);
    }

    /**
     * Ejercicio 19: Eliminar duplicados y ordenar automáticamente con TreeSet.
     * TreeSet combina dos ideas: no permite duplicados y mantiene orden natural.
     */
    public static void ejercicio19TreeSetEliminarDuplicadosYOrdenar() {
        separador("19 - TreeSet: únicos y ordenados");
        List<Integer> datos = Arrays.asList(5, 2, 9, 2, 1, 5, 4);
        Set<Integer> unicosOrdenados = new TreeSet<>(datos);
        System.out.println(unicosOrdenados);
    }

    /**
     * Ejercicio 20: Contar palabras con HashMap.
     * La palabra es la clave y el número de apariciones es el valor asociado.
     */
    public static void ejercicio20ContarPalabrasConHashMap() {
        separador("20 - Contador con HashMap");
        String[] palabras = {"java", "map", "java", "set", "java", "map"};
        Map<String, Integer> contador = new HashMap<>();

        for (String p : palabras) {
            contador.put(p, contador.getOrDefault(p, 0) + 1);
        }

        System.out.println(contador);
    }

    /**
     * Ejercicio 21: Pipeline completo.
     * Filtra pares, los ordena, los eleva al cuadrado y suma el resultado final.
     */
    public static void ejercicio21PipelineCompleto() {
        separador("21 - Pipeline completo");
        List<Integer> numeros = Arrays.asList(5, 2, 9, 1, 4, 8);
        int suma = numeros.stream()
                .filter(x -> x % 2 == 0)
                .sorted()
                .mapToInt(x -> x * x)
                .sum();
        System.out.println("Suma de cuadrados pares ordenados: " + suma);
    }

    /**
     * Ejercicio 22: Comparator por longitud inversa.
     * Ordena textos desde el más largo hasta el más corto.
     */
    public static void ejercicio22ComparatorLongitudInversa() {
        separador("22 - Comparator longitud inversa");
        List<String> palabras = new ArrayList<>(Arrays.asList("sol", "programacion", "java", "colecciones"));
        palabras.sort((a, b) -> Integer.compare(b.length(), a.length()));
        System.out.println(palabras);
    }

    /**
     * Ejercicio 23: Ordenar objetos por múltiples campos.
     * Primero por nota descendente y, si empatan, por nombre ascendente.
     */
    public static void ejercicio23OrdenarObjetosPorMultiplesCampos() {
        separador("23 - Objetos: nota descendente y nombre");
        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno("Luis", 8.5));
        alumnos.add(new Alumno("Ana", 9.0));
        alumnos.add(new Alumno("Marta", 8.5));
        alumnos.add(new Alumno("Carlos", 9.0));

        alumnos.sort(
                Comparator.comparing(Alumno::getNota).reversed()
                        .thenComparing(Alumno::getNombre)
        );
        System.out.println(alumnos);
    }

    /**
     * Ejercicio 24: Buscar el texto más largo con Streams.
     * max() devuelve Optional porque podría no existir resultado si la lista está vacía.
     */
    public static void ejercicio24BuscarElementoMasLargoConStreams() {
        separador("24 - Stream max con Optional");
        List<String> nombres = Arrays.asList("Ana", "Alejandro", "Luis", "Marta");
        Optional<String> mayor = nombres.stream()
                .max(Comparator.comparing(String::length));
        System.out.println("Más largo: " + mayor.orElse("No hay datos"));
    }

    /**
     * Ejercicio 25: Agrupar palabras por longitud.
     * groupingBy() crea un Map donde la clave es la longitud y el valor es la lista de palabras.
     */
    public static void ejercicio25AgruparPalabrasPorLongitud() {
        separador("25 - Collectors.groupingBy por longitud");
        List<String> nombres = Arrays.asList("Ana", "Luis", "Juan", "Marta", "Alejandro");
        Map<Integer, List<String>> agrupadas = nombres.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(agrupadas);
    }

    private static List<Persona> crearPersonas() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Ana", 30));
        personas.add(new Persona("Luis", 20));
        personas.add(new Persona("Marta", 25));
        return personas;
    }

    static class PersonaComparable implements Comparable<PersonaComparable> {
        private final String nombre;

        PersonaComparable(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public int compareTo(PersonaComparable otra) {
            return this.nombre.compareTo(otra.nombre);
        }

        @Override
        public String toString() {
            return nombre;
        }
    }

    static class Persona {
        private final String nombre;
        private final int edad;

        Persona(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        public String getNombre() {
            return nombre;
        }

        public int getEdad() {
            return edad;
        }

        @Override
        public String toString() {
            return nombre + "(" + edad + ")";
        }
    }

    static class Alumno {
        private final String nombre;
        private final double nota;

        Alumno(String nombre, double nota) {
            this.nombre = nombre;
            this.nota = nota;
        }

        public String getNombre() {
            return nombre;
        }

        public double getNota() {
            return nota;
        }

        @Override
        public String toString() {
            return nombre + "(" + nota + ")";
        }
    }
}


//Para imprimir arrays facilmente arrays.toString(nombreArray) Arrays.deepToString() para multitimensionales
/*

Random random = new Random();

int numero = random.nextInt(10); del 0 al 9
int numero = random.nextInt(10) + 1; del 1 al 10
random.nextInt(max - min + 1) + min      -> fórmula típica para random por rango
int numero = random.nextInt(100 - 50 + 1) + 50;        del 50 al 100


Otra forma
import java.util.concurrent.ThreadLocalRandom;

int numero =
        ThreadLocalRandom.current().nextInt(1, 11); del 1 al 10

Otra
int n = (int)(Math.random() * 10);

public static boolean esPalindromo(String palabra) {

    palabra = palabra.toLowerCase();

    for (int i = 0; i < palabra.length() / 2; i++) {

        // Comparar inicio con final
        if (palabra.charAt(i) !=
            palabra.charAt(palabra.length() - 1 - i)) {

            return false;
        }
    }

    return true;
}
*/