package org.example.ejercicios_collections;

import java.util.*;
import java.util.stream.Collectors;

public class EjerciciosCollections {

    /* =========================================================
       ===================== ARRAYS =============================
       ========================================================= */

    // 1) Sumar un array
    public static int sumArray(int[] arr) {
        int suma = 0;
        for (int n : arr) suma += n;
        return suma;
    }

    // 2) Ordenar array
    public static void sortArray(int[] arr) {
        Arrays.sort(arr);
    }

    // 3) Buscar elemento en array
    public static boolean containsInArray(int[] arr, int value) {
        for (int n : arr)
            if (n == value) return true;
        return false;
    }

    // 4) Convertir array a List
    public static List<Integer> arrayToList(Integer[] arr) {
        return Arrays.asList(arr);
    }

    /* =========================================================
       ======================= LIST =============================
       ========================================================= */

    // 5) Crear ArrayList y añadir elementos
    public static List<String> createList() {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");
        return list;
    }

    // 6) Eliminar duplicados usando Set
    public static List<Integer> removeDuplicates(List<Integer> list) {
        return new ArrayList<>(new LinkedHashSet<>(list));
    }

    // 7) Invertir lista
    public static void reverseList(List<?> list) {
        Collections.reverse(list);
    }

    // 8) Ordenar lista
    public static void sortList(List<Integer> list) {
        Collections.sort(list);
    }

    // 9) Ordenar con Comparator
    public static void sortByLength(List<String> list) {
        list.sort(Comparator.comparing(String::length));
    }

    // 10) Obtener máximo
    public static int maxValue(List<Integer> list) {
        return Collections.max(list);
    }

    /* =========================================================
       ======================== SET =============================
       ========================================================= */

    // 11) Crear HashSet
    public static Set<String> createHashSet() {
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("A"); // duplicado
        return set;
    }

    // 12) TreeSet ordenado
    public static Set<Integer> createTreeSet() {
        Set<Integer> set = new TreeSet<>();
        set.add(5);
        set.add(1);
        set.add(3);
        return set; // ordenado automáticamente
    }

    // 13) Comprobar si dos sets son iguales
    public static boolean compareSets(Set<?> a, Set<?> b) {
        return a.equals(b);
    }

    /* =========================================================
       ========================= MAP ============================
       ========================================================= */

    // 14) Crear HashMap
    public static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Juan", 30);
        map.put("Ana", 25);
        return map;
    }

    // 15) Recorrer Map
    public static void printMap(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // 16) Contar frecuencia de palabras
    public static Map<String, Integer> wordFrequency(String text) {
        Map<String, Integer> map = new HashMap<>();
        String[] words = text.split("\\s+");

        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        return map;
    }

    // 17) TreeMap ordenado por clave
    public static Map<String, Integer> createTreeMap() {
        Map<String, Integer> map = new TreeMap<>();
        map.put("C", 3);
        map.put("A", 1);
        map.put("B", 2);
        return map;
    }

    /* =========================================================
       ====================== QUEUE =============================
       ========================================================= */

    // 18) Uso de Queue
    public static void queueExample() {
        Queue<String> queue = new LinkedList<>();
        queue.offer("Uno");
        queue.offer("Dos");
        queue.poll(); // elimina primero
    }

    // 19) Uso de Deque como pila
    public static void stackExample() {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.pop();
    }

    /* =========================================================
       ===================== ITERADORES =========================
       ========================================================= */

    // 20) Eliminar elementos mientras iteras
    public static void removeEven(List<Integer> list) {
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() % 2 == 0)
                it.remove();
        }
    }

    /* =========================================================
       ====================== STREAMS ===========================
       ========================================================= */

    // 21) Filtrar números pares
    public static List<Integer> filterEven(List<Integer> list) {
        return list.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }

    // 22) Transformar lista (map)
    public static List<Integer> squareNumbers(List<Integer> list) {
        return list.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
    }

    // 23) Agrupar por longitud
    public static Map<Integer, List<String>> groupByLength(List<String> list) {
        return list.stream()
                .collect(Collectors.groupingBy(String::length));
    }

    // 24) Obtener suma con reduce
    public static int sumWithStream(List<Integer> list) {
        return list.stream()
                .reduce(0, Integer::sum);
    }

    /* =========================================================
       =================== LINKEDLIST ===========================
       ========================================================= */

    // 25) Uso básico de LinkedList
    public static LinkedList<String> linkedListExample() {
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("Inicio");
        list.addLast("Final");
        return list;
    }

    /* =========================================================
       ===================== OPTIONAL ===========================
       ========================================================= */

    // 26) Buscar elemento opcional
    public static Optional<String> findElement(List<String> list, String value) {
        return list.stream()
                .filter(e -> e.equals(value))
                .findFirst();
    }

    /* =========================================================
   ==================== ARRAYLIST ONLY =====================
   ========================================================= */

    // 1) Crear ArrayList vacío
    public static ArrayList<String> createArrayList() {
        return new ArrayList<>();
    }

    // 2) Crear ArrayList con capacidad inicial
    public static ArrayList<Integer> createWithCapacity(int capacity) {
        return new ArrayList<>(capacity);
    }

    // 3) Agregar elemento
    public static void addElement(ArrayList<String> list, String value) {
        list.add(value);
    }

    // 4) Agregar elemento en posición específica
    public static void addAtPosition(ArrayList<String> list, int index, String value) {
        list.add(index, value);
    }

    // 5) Obtener elemento por índice
    public static String getElement(ArrayList<String> list, int index) {
        return list.get(index);
    }

    // 6) Modificar elemento
    public static void setElement(ArrayList<String> list, int index, String newValue) {
        list.set(index, newValue);
    }

    // 7) Eliminar por índice
    public static void removeByIndex(ArrayList<String> list, int index) {
        list.remove(index);
    }

    // 8) Eliminar por valor
    public static boolean removeByValue(ArrayList<String> list, String value) {
        return list.remove(value);
    }

    // 9) Verificar si contiene un elemento
    public static boolean containsElement(ArrayList<String> list, String value) {
        return list.contains(value);
    }

    // 10) Obtener tamaño
    public static int getSize(ArrayList<?> list) {
        return list.size();
    }

    // 11) Verificar si está vacía
    public static boolean isEmpty(ArrayList<?> list) {
        return list.isEmpty();
    }

    // 12) Limpiar lista
    public static void clearList(ArrayList<?> list) {
        list.clear();
    }

    // 13) Encontrar índice de un elemento
    public static int indexOfElement(ArrayList<String> list, String value) {
        return list.indexOf(value);
    }

    // 14) Encontrar último índice
    public static int lastIndexOfElement(ArrayList<String> list, String value) {
        return list.lastIndexOf(value);
    }

    // 15) Clonar ArrayList
    public static ArrayList<String> cloneList(ArrayList<String> list) {
        return (ArrayList<String>) list.clone();
    }

    // 16) Convertir ArrayList a Array
    public static Object[] toArray(ArrayList<?> list) {
        return list.toArray();
    }

    // 17) Convertir ArrayList a Array tipado
    public static String[] toTypedArray(ArrayList<String> list) {
        return list.toArray(new String[0]);
    }

    // 18) Recorrer con for clásico
    public static void iterateWithFor(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    // 19) Recorrer con for-each
    public static void iterateWithForEach(ArrayList<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
    }

    // 20) Recorrer con Iterator
    public static void iterateWithIterator(ArrayList<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    // 21) Ordenar ArrayList
    public static void sortList(ArrayList<Integer> list) {
        Collections.sort(list);
    }

    // 22) Ordenar en orden inverso
    public static void sortReverse(ArrayList<Integer> list) {
        list.sort(Collections.reverseOrder());
    }

    // 23) Barajar elementos
    public static void shuffleList(ArrayList<?> list) {
        Collections.shuffle(list);
    }

    // 24) Invertir lista
    public static void reverseList(ArrayList<?> list) {
        Collections.reverse(list);
    }

    // 25) Copiar una lista en otra
    public static ArrayList<String> copyList(ArrayList<String> original) {
        return new ArrayList<>(original);
    }

    // 26) Unir dos listas
    public static ArrayList<String> mergeLists(ArrayList<String> a, ArrayList<String> b) {
        ArrayList<String> result = new ArrayList<>(a);
        result.addAll(b);
        return result;
    }

    // 27) Obtener sublista
    public static List<String> getSubList(ArrayList<String> list, int from, int to) {
        return list.subList(from, to);
    }

    // 28) Retener solo elementos comunes
    public static void retainCommon(ArrayList<String> list1, ArrayList<String> list2) {
        list1.retainAll(list2);
    }

    // 29) Eliminar todos los elementos de otra lista
    public static void removeAllElements(ArrayList<String> list1, ArrayList<String> list2) {
        list1.removeAll(list2);
    }

    // 30) Reemplazar todos los elementos
    public static void replaceAllToUpper(ArrayList<String> list) {
        list.replaceAll(String::toUpperCase);
    }

    // 31) Eliminar elementos con condición
    public static void removeIfEven(ArrayList<Integer> list) {
        list.removeIf(n -> n % 2 == 0);
    }

    // 32) Buscar máximo
    public static int getMax(ArrayList<Integer> list) {
        return Collections.max(list);
    }

    // 33) Buscar mínimo
    public static int getMin(ArrayList<Integer> list) {
        return Collections.min(list);
    }

    // 34) Contar frecuencia
    public static int frequency(ArrayList<String> list, String value) {
        return Collections.frequency(list, value);
    }

    // 35) Convertir a String con join
    public static String joinList(ArrayList<String> list) {
        return String.join(", ", list);
    }

    // 36) Verificar igualdad entre listas
    public static boolean areEqual(ArrayList<?> a, ArrayList<?> b) {
        return a.equals(b);
    }

    // 37) Asegurar capacidad interna
    public static void ensureCapacity(ArrayList<?> list, int capacity) {
        list.ensureCapacity(capacity);
    }

    // 38) Reducir capacidad al tamaño actual
    public static void trimToSize(ArrayList<?> list) {
        list.trimToSize();
    }

    // 39) Insertar múltiples elementos
    public static void addMultiple(ArrayList<String> list, String... values) {
        Collections.addAll(list, values);
    }

    // 40) Filtrar usando Stream
    public static ArrayList<Integer> filterGreaterThan(ArrayList<Integer> list, int value) {
        return list.stream()
                .filter(n -> n > value)
                .collect(Collectors.toCollection(ArrayList::new));
    }


    /* =========================================================
       ===================== MAIN DEMO ==========================
       ========================================================= */

    public static void main(String[] args) {

        int[] arr = {5, 2, 9};
        sortArray(arr);
        System.out.println("Array ordenado: " + Arrays.toString(arr));

        List<String> list = createList();
        sortByLength(list);
        System.out.println("Lista ordenada por longitud: " + list);

        Set<String> set = createHashSet();
        System.out.println("HashSet: " + set);

        Map<String, Integer> map = createMap();
        printMap(map);

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Pares: " + filterEven(nums));
        System.out.println("Cuadrados: " + squareNumbers(nums));
    }
}


