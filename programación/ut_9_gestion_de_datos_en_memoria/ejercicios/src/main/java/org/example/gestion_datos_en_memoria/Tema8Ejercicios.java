package org.example.gestion_datos_en_memoria;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * Clase de ejercicios del Tema 8: Estructuras de almacenamiento y programación funcional.
 *
 * Cada ejercicio está separado en un método static para poder invocarlo desde main.
 * El objetivo es practicar: arrays, List, Set, Map, Iterator, Comparator, lambdas,
 * referencias a método, Streams, Optional y Collectors.
 */
public class Tema8Ejercicios {

    public static void main(String[] args) {
        // Invoca aquí los ejercicios que quieras probar.
        // Puedes comentar/descomentar llamadas según lo que estés estudiando.
        ejercicio01AlmacenamientoDinamicoConArrayList();
        /*ejercicio02VariablesIndependientesVsLista();
        ejercicio03ArrayDeclaracionAccesoRecorrido();
        ejercicio04ArrayInicializacionModificacionMatriz();
        ejercicio05ComplejidadConstanteLinealLogaritmica();
        ejercicio06LimitacionesArrayRedimensionarInsertarEliminarBuscar();
        ejercicio07ColeccionInterfazVsImplementacion();
        ejercicio08GenericosYTipadoSeguro();
        ejercicio09MapNoEsCollectionYRecorridos();
        ejercicio10EleccionListSetMap();
        ejercicio11ArrayListGestionPedidos();
        ejercicio12CreacionInicializacionConversionListas();
        ejercicio13LinkedListComoColaFIFO();
        ejercicio14IteratorEliminacionSegura();
        ejercicio15HashSetUnicidadYPertenencia();
        ejercicio16OperacionesDeConjunto();
        ejercicio17LinkedHashSetOrdenInsercion();
        ejercicio18TreeSetOrdenNaturalYOperaciones();
        ejercicio19TreeSetConComparable();
        ejercicio20ComparatorConClaseAnonimaLambdaYComparing();
        ejercicio21HashSetConObjetosEqualsHashCode();
        ejercicio22HashMapAccesoPorClave();
        ejercicio23HashMapContadorFrecuencias();
        ejercicio24RecorridoCorrectoEntrySet();
        ejercicio25LinkedHashMapOrdenInsercion();
        ejercicio26TreeMapOrdenNaturalYComparator();
        ejercicio27InterfazFuncionalClaseAnonima();
        ejercicio28LambdaConInterfazPropia();
        ejercicio29LambdasApiPredicateFunctionConsumerSupplier();
        ejercicio30RunnableConLambda();
        ejercicio31ForEachYRemoveIfConLambdas();
        ejercicio32PrimerPipelineStreamFilterMapCollect();
        ejercicio33EvaluacionPerezosaStream();
        ejercicio34MapTransformacionYCambioTipo();
        ejercicio35SortedNaturalYComparator();
        ejercicio36DistinctDuplicadosLogicos();
        ejercicio37LimitShortCircuiting();
        ejercicio38ReduceYCollect();
        ejercicio39ToListVsCollectorsToList();
        ejercicio40MapToIntSumForEachReferenciaMetodo();
        ejercicio41CountContadorDeclarativo();
        ejercicio42ReferenciasAMetodo();
        ejercicio43FindFirstMaxMinOptional();
        ejercicio44CollectorsGroupingByCounting();
        ejercicio45IntegracionFinalColeccionStreamLambdaResultado();*/
    }

    // ---------------------------------------------------------------------
    // MODELOS AUXILIARES
    // ---------------------------------------------------------------------

    /** record sencillo para practicar listas, mapas y streams con objetos. */
    record Pedido(String id, String cliente, double total) {}

    /**
     * Persona implementa Comparable para que TreeSet sepa ordenar por defecto.
     * El orden natural se ha definido por nombre y, si empata, por edad.
     */
    static class PersonaComparable implements Comparable<PersonaComparable> {
        private final String nombre;
        private final int edad;

        PersonaComparable(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        public String getNombre() { return nombre; }
        public int getEdad() { return edad; }

        @Override
        public int compareTo(PersonaComparable otra) {
            int porNombre = this.nombre.compareTo(otra.nombre);
            if (porNombre != 0) return porNombre;
            return Integer.compare(this.edad, otra.edad);
        }

        @Override
        public String toString() {
            return nombre + "(" + edad + ")";
        }
    }

    /**
     * Persona con equals/hashCode: necesaria para que HashSet y distinct()
     * puedan detectar duplicados lógicos correctamente.
     */
    static class PersonaHash {
        private final String nombre;
        private final int edad;

        PersonaHash(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        public String getNombre() { return nombre; }
        public int getEdad() { return edad; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PersonaHash otra)) return false;
            return edad == otra.edad && Objects.equals(nombre, otra.nombre);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nombre, edad);
        }

        @Override
        public String toString() {
            return nombre + "(" + edad + ")";
        }
    }

    @FunctionalInterface
    interface Operacion {
        int aplicar(int a, int b);
    }

    @FunctionalInterface
    interface Condicion {
        boolean evaluar(int x);
    }

    @FunctionalInterface
    interface Filtro {
        boolean aceptar(int x);
    }

    private static void separador(String titulo) {
        System.out.println("\n--- " + titulo + " ---");
    }

    // ---------------------------------------------------------------------
    // EJERCICIOS
    // ---------------------------------------------------------------------

    public static void ejercicio01AlmacenamientoDinamicoConArrayList() {
        separador("01. Almacenamiento dinamico con ArrayList");
        // ArrayList permite que el numero de elementos crezca durante la ejecucion.
        List<String> usuarios = new ArrayList<>();
        usuarios.add("Ana");
        usuarios.add("Luis");
        usuarios.add("Marta");
        System.out.println("Usuarios: " + usuarios);
    }

    public static void ejercicio02VariablesIndependientesVsLista() {
        separador("02. Variables independientes vs lista");
        // Con variables sueltas no podemos recorrer los datos de forma uniforme.
        String u1 = "Ana";
        String u2 = "Luis";
        String u3 = "Marta";
        System.out.println("Variables sueltas: " + u1 + ", " + u2 + ", " + u3);

        // Con una lista tratamos todos los datos como grupo.
        List<String> usuarios = List.of(u1, u2, u3);
        usuarios.forEach(System.out::println);
    }

    public static void ejercicio03ArrayDeclaracionAccesoRecorrido() {
        separador("03. Array: declaracion, acceso y recorrido");
        int[] numeros = new int[5];
        numeros[0] = 10;
        numeros[1] = 20;
        numeros[2] = 30;
        numeros[3] = 40;
        numeros[4] = 50;

        // Acceso directo por indice: coste O(1).
        int valor = numeros[2];
        System.out.println("Valor en posicion 2: " + valor);

        // Recorrido completo: coste O(n), porque visitamos todos los elementos.
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("numeros[" + i + "] = " + numeros[i]);
        }
    }

    public static void ejercicio04ArrayInicializacionModificacionMatriz() {
        separador("04. Inicializacion directa, modificacion y matriz");
        int[] numeros = {10, 20, 30, 40, 50};
        numeros[1] = 25; // modificar una posicion concreta
        System.out.println("Array modificado: " + Arrays.toString(numeros));

        int[][] matriz = new int[3][3];
        matriz[0][1] = 5;
        System.out.println("matriz[0][1] = " + matriz[0][1]);
    }

    public static void ejercicio05ComplejidadConstanteLinealLogaritmica() {
        separador("05. Patrones Big-O: O(1), O(n), O(log n)");
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};

        // O(1): no depende del tamano del array.
        int constante = a[2];
        System.out.println("O(1): " + constante);

        // O(n): una pasada completa.
        int suma = 0;
        for (int x : a) suma += x;
        System.out.println("O(n), suma: " + suma);

        // O(log n): reducimos el problema a la mitad en cada iteracion.
        int m = a.length;
        int pasos = 0;
        while (m > 1) {
            m = m / 2;
            pasos++;
        }
        System.out.println("O(log n), pasos dividiendo entre 2: " + pasos);
    }

    public static void ejercicio06LimitacionesArrayRedimensionarInsertarEliminarBuscar() {
        separador("06. Limitaciones de arrays");
        int[] datos = {1, 2, 3, 4, 5};

        // Redimensionar exige crear otro array y copiar: O(n).
        int[] nuevo = new int[10];
        System.arraycopy(datos, 0, nuevo, 0, datos.length);
        System.out.println("Array redimensionado: " + Arrays.toString(nuevo));

        // Insertar al principio implica desplazar elementos: O(n).
        int n = datos.length;
        int[] insertado = new int[n + 1];
        insertado[0] = 99;
        for (int i = 0; i < n; i++) insertado[i + 1] = datos[i];
        System.out.println("Insertado al principio: " + Arrays.toString(insertado));

        // Buscar sin orden ni estructura adicional implica recorrido lineal: O(n).
        int buscado = 4;
        int posicion = -1;
        for (int i = 0; i < datos.length; i++) {
            if (datos[i] == buscado) {
                posicion = i;
                break;
            }
        }
        System.out.println("Posicion de " + buscado + ": " + posicion);
    }

    public static void ejercicio07ColeccionInterfazVsImplementacion() {
        separador("07. Coleccion: interfaz vs implementacion");
        // Programamos contra la interfaz List, pero usamos ArrayList como implementacion concreta.
        List<String> nombres = new ArrayList<>();
        nombres.add("Ana");
        nombres.add("Luis");
        System.out.println(nombres);

        // Podemos cambiar la implementacion sin cambiar las operaciones principales.
        nombres = new LinkedList<>(nombres);
        nombres.add("Marta");
        System.out.println(nombres);
    }

    public static void ejercicio08GenericosYTipadoSeguro() {
        separador("08. Genericos y tipado seguro");
        List<String> lista = new ArrayList<>();
        lista.add("Ana");
        // lista.add(10); // Error de compilacion: la lista solo acepta String.
        String s = lista.get(0); // No hace falta cast.
        System.out.println(s);

        List<Integer> xs = new ArrayList<>();
        xs.add(5); // autoboxing: int -> Integer
        int a = xs.get(0); // unboxing: Integer -> int
        System.out.println(a);
    }

    public static void ejercicio09MapNoEsCollectionYRecorridos() {
        separador("09. Map no es Collection y formas de recorrerlo");
        Map<String, Integer> map = new HashMap<>();
        map.put("Ana", 25);
        map.put("Luis", 30);

        System.out.println("Claves: " + map.keySet());
        System.out.println("Valores: " + map.values());

        // Forma recomendada: entrySet da acceso a clave y valor sin busquedas extra.
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }

    public static void ejercicio10EleccionListSetMap() {
        separador("10. Elegir entre List, Set y Map");
        List<String> usuariosEnOrden = new ArrayList<>(List.of("Ana", "Luis", "Ana"));
        Set<String> dniUnicos = new HashSet<>(List.of("111A", "222B", "111A"));
        Map<String, Double> notaPorDni = new HashMap<>();
        notaPorDni.put("111A", 8.5);
        notaPorDni.put("222B", 7.0);

        System.out.println("List permite orden y duplicados: " + usuariosEnOrden);
        System.out.println("Set elimina duplicados: " + dniUnicos);
        System.out.println("Map busca por clave: " + notaPorDni.get("111A"));
    }

    public static void ejercicio11ArrayListGestionPedidos() {
        separador("11. ArrayList: gestion de pedidos");
        List<String> pedidos = new ArrayList<>();
        pedidos.add("Pedido1");
        pedidos.add("Pedido2");
        pedidos.add("Pedido3");
        for (String p : pedidos) System.out.println(p);
        pedidos.set(1, "PedidoModificado");
        pedidos.remove(0);
        System.out.println("Resultado final: " + pedidos);
    }

    public static void ejercicio12CreacionInicializacionConversionListas() {
        separador("12. Patrones de creacion de List");
        List<String> incremental = new ArrayList<>();
        incremental.add("Ana");

        List<String> inmutable = List.of("Ana", "Luis", "Marta");
        // inmutable.add("Carlos"); // UnsupportedOperationException

        String[] datos = {"Ana", "Luis", "Marta"};
        List<String> tamanoFijo = Arrays.asList(datos);
        tamanoFijo.set(0, "Carlos");
        // tamanoFijo.add("Eva"); // UnsupportedOperationException

        List<String> modificable = new ArrayList<>(Arrays.asList(datos));
        modificable.add("Eva");

        System.out.println(incremental);
        System.out.println(inmutable);
        System.out.println(tamanoFijo);
        System.out.println(modificable);
    }

    public static void ejercicio13LinkedListComoColaFIFO() {
        separador("13. LinkedList como cola FIFO");
        LinkedList<String> cola = new LinkedList<>();
        cola.addLast("Pedido1");
        cola.addLast("Pedido2");
        cola.addLast("Pedido3");

        while (!cola.isEmpty()) {
            String pedido = cola.removeFirst();
            System.out.println("Procesando: " + pedido);
        }
    }

    public static void ejercicio14IteratorEliminacionSegura() {
        separador("14. Iterator y eliminacion segura");
        List<String> lista = new ArrayList<>(List.of("Ana", "Luis", "Marta"));

        // No elimines con lista.remove(s) dentro de for-each: puede lanzar ConcurrentModificationException.
        Iterator<String> it = lista.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s.equals("Luis")) {
                it.remove(); // eliminacion segura mediante el propio iterador
            }
        }
        System.out.println(lista);
    }

    public static void ejercicio15HashSetUnicidadYPertenencia() {
        separador("15. HashSet: unicidad y pertenencia");
        Set<String> nombres = new HashSet<>();
        System.out.println(nombres.add("Ana"));
        System.out.println(nombres.add("Luis"));
        System.out.println(nombres.add("Ana")); // false: ya existia
        System.out.println("Contiene Ana? " + nombres.contains("Ana"));
        System.out.println(nombres);
    }

    public static void ejercicio16OperacionesDeConjunto() {
        separador("16. Union, interseccion y diferencia con Set");
        Set<String> a = new HashSet<>(List.of("Ana", "Luis"));
        Set<String> b = new HashSet<>(List.of("Luis", "Marta"));

        Set<String> union = new HashSet<>(a);
        union.addAll(b);

        Set<String> interseccion = new HashSet<>(a);
        interseccion.retainAll(b);

        Set<String> diferencia = new HashSet<>(a);
        diferencia.removeAll(b);

        System.out.println("Union: " + union);
        System.out.println("Interseccion: " + interseccion);
        System.out.println("Diferencia A-B: " + diferencia);
    }

    public static void ejercicio17LinkedHashSetOrdenInsercion() {
        separador("17. LinkedHashSet mantiene orden de insercion");
        Set<String> linkedSet = new LinkedHashSet<>();
        linkedSet.add("Luis");
        linkedSet.add("Ana");
        linkedSet.add("Marta");
        linkedSet.add("Ana");
        System.out.println(linkedSet);
    }

    public static void ejercicio18TreeSetOrdenNaturalYOperaciones() {
        separador("18. TreeSet: orden natural");
        TreeSet<Integer> tree = new TreeSet<>();
        tree.add(12);
        tree.add(4);
        tree.add(60);
        tree.add(4);
        System.out.println("Ordenado y sin duplicados: " + tree);
        System.out.println("Primero: " + tree.first());
        System.out.println("Ultimo: " + tree.last());
        System.out.println("Mayor o igual que 10: " + tree.ceiling(10));
    }

    public static void ejercicio19TreeSetConComparable() {
        separador("19. TreeSet con Comparable");
        Set<PersonaComparable> personas = new TreeSet<>();
        personas.add(new PersonaComparable("Zoe", 40));
        personas.add(new PersonaComparable("Ana", 25));
        personas.add(new PersonaComparable("Luis", 30));
        System.out.println(personas);
    }

    public static void ejercicio20ComparatorConClaseAnonimaLambdaYComparing() {
        separador("20. Comparator: clase anonima, lambda y comparing");
        List<PersonaComparable> personas = new ArrayList<>(List.of(
                new PersonaComparable("Ana", 25),
                new PersonaComparable("Luis", 30),
                new PersonaComparable("Marta", 20)
        ));

        Comparator<PersonaComparable> porEdadAnonimo = new Comparator<PersonaComparable>() {
            @Override
            public int compare(PersonaComparable p1, PersonaComparable p2) {
                return Integer.compare(p1.getEdad(), p2.getEdad());
            }
        };
        personas.sort(porEdadAnonimo);
        System.out.println("Clase anonima: " + personas);

        personas.sort((p1, p2) -> Integer.compare(p2.getEdad(), p1.getEdad()));
        System.out.println("Lambda edad desc: " + personas);

        personas.sort(Comparator.comparing(PersonaComparable::getNombre));
        System.out.println("Comparator.comparing nombre: " + personas);
    }

    public static void ejercicio21HashSetConObjetosEqualsHashCode() {
        separador("21. HashSet con objetos y contrato equals/hashCode");
        Set<PersonaHash> personas = new HashSet<>();
        personas.add(new PersonaHash("Ana", 25));
        personas.add(new PersonaHash("Ana", 25)); // duplicado logico: no se inserta
        personas.add(new PersonaHash("Luis", 30));
        System.out.println(personas);
    }

    public static void ejercicio22HashMapAccesoPorClave() {
        separador("22. HashMap: acceso por clave");
        Map<String, String> usuarios = new HashMap<>();
        usuarios.put("u1", "Ana");
        usuarios.put("u2", "Luis");
        usuarios.put("u3", "Marta");
        System.out.println("Usuario u2: " + usuarios.get("u2"));
    }

    public static void ejercicio23HashMapContadorFrecuencias() {
        separador("23. HashMap contador de frecuencias");
        String[] palabras = {"java", "map", "java", "set", "map", "java"};
        Map<String, Integer> contador = new HashMap<>();
        for (String p : palabras) {
            contador.put(p, contador.getOrDefault(p, 0) + 1);
        }
        System.out.println(contador);
    }

    public static void ejercicio24RecorridoCorrectoEntrySet() {
        separador("24. Recorrido correcto de Map con entrySet");
        Map<String, Integer> contador = new HashMap<>();
        contador.put("java", 3);
        contador.put("map", 2);
        contador.put("set", 1);

        for (Map.Entry<String, Integer> e : contador.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }

    public static void ejercicio25LinkedHashMapOrdenInsercion() {
        separador("25. LinkedHashMap mantiene orden de insercion");
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(100, "Ana");
        map.put(101, "Luis");
        map.put(102, "Marta");
        map.remove(101);
        System.out.println(map);
    }

    public static void ejercicio26TreeMapOrdenNaturalYComparator() {
        separador("26. TreeMap: orden natural y comparator");
        Map<String, Integer> natural = new TreeMap<>();
        natural.put("Luis", 2);
        natural.put("Ana", 1);
        natural.put("Marta", 3);
        System.out.println("Orden natural clave: " + natural);

        Map<String, Integer> inverso = new TreeMap<>(Comparator.reverseOrder());
        inverso.putAll(natural);
        System.out.println("Orden inverso clave: " + inverso);
    }

    public static void ejercicio27InterfazFuncionalClaseAnonima() {
        separador("27. Interfaz funcional con clase anonima");
        Operacion suma = new Operacion() {
            @Override
            public int aplicar(int a, int b) {
                return a + b;
            }
        };
        System.out.println("3 + 4 = " + suma.aplicar(3, 4));
    }

    public static void ejercicio28LambdaConInterfazPropia() {
        separador("28. Lambda con interfaz propia");
        Condicion esPar = x -> x % 2 == 0;
        Operacion suma = (a, b) -> a + b;
        Operacion producto = (a, b) -> a * b;

        List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> pares = new ArrayList<>();
        for (int n : numeros) {
            if (esPar.evaluar(n)) pares.add(n);
        }

        int totalSuma = 0;
        for (int n : pares) totalSuma = suma.aplicar(totalSuma, n);

        int totalProducto = 1;
        for (int n : pares) totalProducto = producto.aplicar(totalProducto, n);

        System.out.println("Pares: " + pares);
        System.out.println("Suma pares: " + totalSuma);
        System.out.println("Producto pares: " + totalProducto);
    }

    public static void ejercicio29LambdasApiPredicateFunctionConsumerSupplier() {
        separador("29. Lambdas con Predicate, Function, Consumer y Supplier");
        Predicate<Integer> esPar = x -> x % 2 == 0;
        Function<Integer, Integer> cuadrado = x -> x * x;
        Consumer<String> imprimir = s -> System.out.println("Mensaje: " + s);
        Supplier<Double> aleatorio = () -> Math.random();

        System.out.println(esPar.test(4));
        System.out.println(cuadrado.apply(5));
        imprimir.accept("Hola mundo");
        System.out.println("Aleatorio: " + aleatorio.get());
    }

    public static void ejercicio30RunnableConLambda() {
        separador("30. Runnable con lambda");
        Runnable tarea = () -> System.out.println("Ejecutando tarea en hilo");
        Thread t = new Thread(tarea);
        t.start();
        try {
            t.join(); // esperamos para que la salida aparezca antes de seguir
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void ejercicio31ForEachYRemoveIfConLambdas() {
        separador("31. forEach y removeIf con lambdas");
        List<Integer> datos = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        datos.forEach(x -> System.out.println("Dato: " + x));

        // removeIf recibe un Predicate: si devuelve true, elimina el elemento.
        datos.removeIf(x -> x % 2 == 0);
        System.out.println("Tras eliminar pares: " + datos);
    }

    public static void ejercicio32PrimerPipelineStreamFilterMapCollect() {
        separador("32. Primer pipeline Stream: filter, map, collect");
        List<Integer> datos = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> resultado = datos.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * x)
                .collect(Collectors.toList());
        System.out.println(resultado);
    }

    public static void ejercicio33EvaluacionPerezosaStream() {
        separador("33. Evaluacion perezosa de Streams");
        List<Integer> datos = List.of(1, 2, 3, 4, 5, 6);
        datos.stream()
                .filter(x -> {
                    System.out.println("filter: " + x);
                    return x % 2 == 0;
                })
                .map(x -> {
                    System.out.println("map: " + x);
                    return x * x;
                })
                .forEach(x -> System.out.println("forEach: " + x));
    }

    public static void ejercicio34MapTransformacionYCambioTipo() {
        separador("34. map(): transformacion y cambio de tipo");
        List<Integer> datos = List.of(1, 2, 3, 4);
        List<Integer> cuadrados = datos.stream().map(x -> x * x).toList();
        System.out.println(cuadrados);

        List<String> textos = List.of("Ana", "Luis");
        List<Integer> longitudes = textos.stream().map(String::length).toList();
        System.out.println(longitudes);
    }

    public static void ejercicio35SortedNaturalYComparator() {
        separador("35. sorted(): orden natural y comparator");
        List<Integer> datos = List.of(5, 2, 9, 1, 4);
        System.out.println(datos.stream().sorted().toList());

        List<String> nombres = List.of("Ana", "Luis", "Marta", "Alberto");
        List<String> porLongitud = nombres.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
        System.out.println(porLongitud);
    }

    public static void ejercicio36DistinctDuplicadosLogicos() {
        separador("36. distinct(): eliminar duplicados logicos");
        List<String> nombres = List.of("Ana", "Luis", "Ana", "Marta", "Luis");
        System.out.println(nombres.stream().distinct().toList());

        List<PersonaHash> personas = List.of(
                new PersonaHash("Ana", 25),
                new PersonaHash("Ana", 25),
                new PersonaHash("Luis", 30)
        );
        System.out.println(personas.stream().distinct().toList());
    }

    public static void ejercicio37LimitShortCircuiting() {
        separador("37. limit(): restriccion y short-circuiting");
        List<Integer> datos = List.of(5, 2, 9, 1, 4, 8);
        System.out.println("Primeros 3: " + datos.stream().limit(3).toList());
        System.out.println("Tres menores: " + datos.stream().sorted().limit(3).toList());
    }

    public static void ejercicio38ReduceYCollect() {
        separador("38. reduce y collect");
        List<Integer> datos = List.of(1, 2, 3, 4);
        int suma = datos.stream().reduce(0, (acum, x) -> acum + x);
        System.out.println("Suma con reduce: " + suma);

        List<Integer> pares = datos.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Pares con collect: " + pares);
    }

    public static void ejercicio39ToListVsCollectorsToList() {
        separador("39. toList() vs collect(Collectors.toList())");
        List<Integer> noModificable = Stream.of(1, 2, 3, 4, 5)
                .filter(n -> n % 2 == 0)
                .toList();
        System.out.println("toList: " + noModificable);
        // noModificable.add(6); // UnsupportedOperationException en Java 16+

        List<Integer> modificable = Stream.of(1, 2, 3, 4, 5)
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        modificable.add(6);
        System.out.println("Collectors.toList modificable: " + modificable);
    }

    public static void ejercicio40MapToIntSumForEachReferenciaMetodo() {
        separador("40. mapToInt, sum, forEach y referencia a metodo");
        List<Integer> datos = List.of(1, 2, 3, 4, 5, 6);
        int sumaPares = datos.stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(x -> x)
                .sum();
        System.out.println("Suma pares: " + sumaPares);

        datos.stream()
                .filter(x -> x % 2 == 0)
                .forEach(System.out::println);
    }

    public static void ejercicio41CountContadorDeclarativo() {
        separador("41. count(): contador declarativo");
        List<Integer> datos = List.of(1, 2, 3, 4, 5, 6);
        long total = datos.stream().count();
        long pares = datos.stream().filter(x -> x % 2 == 0).count();
        System.out.println("Total: " + total);
        System.out.println("Pares: " + pares);
    }

    public static void ejercicio42ReferenciasAMetodo() {
        separador("42. Referencias a metodo (::)");
        List<String> datos = List.of("10", "20", "30");

        // Clase::metodo estatico: Integer::parseInt equivale a s -> Integer.parseInt(s).
        List<Integer> numeros = datos.stream().map(Integer::parseInt).toList();
        System.out.println(numeros);

        // Clase::metodo de instancia: String::length equivale a s -> s.length().
        List<Integer> longitudes = datos.stream().map(String::length).toList();
        System.out.println(longitudes);

        // objeto::metodo: System.out::println equivale a x -> System.out.println(x).
        numeros.forEach(System.out::println);
    }

    public static void ejercicio43FindFirstMaxMinOptional() {
        separador("43. findFirst, max, min y Optional");
        List<Integer> datos = List.of(1, 3, 5, 8, 9);

        Optional<Integer> primerPar = datos.stream()
                .filter(x -> x % 2 == 0)
                .findFirst();
        System.out.println("Optional primer par: " + primerPar);
        System.out.println("Valor o -1: " + primerPar.orElse(-1));

        int maximo = datos.stream().max(Integer::compareTo).orElse(0);
        int minimo = datos.stream().min(Integer::compareTo).orElse(0);
        System.out.println("Maximo: " + maximo);
        System.out.println("Minimo: " + minimo);
    }

    public static void ejercicio44CollectorsGroupingByCounting() {
        separador("44. Collectors: groupingBy y counting");
        List<Integer> datos = List.of(1, 2, 3, 4, 5, 6);

        Map<Boolean, List<Integer>> agrupado = datos.stream()
                .collect(Collectors.groupingBy(x -> x % 2 == 0));
        System.out.println("Agrupado por paridad: " + agrupado);

        Map<Boolean, Long> conteo = datos.stream()
                .collect(Collectors.groupingBy(x -> x % 2 == 0, Collectors.counting()));
        System.out.println("Conteo por paridad: " + conteo);
    }

    public static void ejercicio45IntegracionFinalColeccionStreamLambdaResultado() {
        separador("45. Integracion final: coleccion -> stream -> operaciones -> resultado");
        List<Integer> datos = List.of(1, 2, 3, 4, 5, 6);

        int resultado = datos.stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(x -> x * x)
                .sum();

        System.out.println("Suma de cuadrados pares: " + resultado);

        // Version con objetos: pedidos de importe mayor de 100 agrupados por cliente.
        List<Pedido> pedidos = List.of(
                new Pedido("p1", "Ana", 120.0),
                new Pedido("p2", "Luis", 80.0),
                new Pedido("p3", "Ana", 200.0),
                new Pedido("p4", "Marta", 50.0)
        );

        Map<String, List<Pedido>> pedidosGrandesPorCliente = pedidos.stream()
                .filter(p -> p.total() > 100)
                .collect(Collectors.groupingBy(Pedido::cliente));

        System.out.println(pedidosGrandesPorCliente);
    }
}
