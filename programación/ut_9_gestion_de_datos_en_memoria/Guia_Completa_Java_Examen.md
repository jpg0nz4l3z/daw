# 🎓 GUÍA COMPLETA JAVA - Clases Anónimas, Lambdas y Colecciones
### Preparación para examen — Todo comentado paso a paso

---

# PARTE 1: CLASES ANÓNIMAS Y EXPRESIONES LAMBDA

## ¿Qué es una interfaz funcional?
Una **interfaz funcional** es una interfaz que solo tiene **UN método**. Es el "molde" que usan las lambdas.

```java
// Esto es una interfaz funcional (solo tiene 1 método)
interface Operacion {
    int ejecutar(int a, int b);
}
```

## ¿Qué es una clase anónima vs una lambda?
- **Clase anónima**: Es como crear una clase "sin nombre" al momento de usarla. Más verbosa.
- **Lambda**: Es un atajo moderno para hacer lo mismo con menos código. `(parametros) -> resultado`

---

## EJERCICIO 1 — Calculadora (Suma, Resta, Multiplicación, División)

### Con Clase Anónima:
```java
public class Calculadora {

    // Definimos la interfaz funcional (el "molde")
    interface Operacion {
        double calcular(double a, double b);
    }

    public static void main(String[] args) {

        // SUMA: Creamos una clase anónima que implementa Operacion
        // Es como decir "crea una clase aquí mismo que haga la suma"
        Operacion suma = new Operacion() {
            @Override
            public double calcular(double a, double b) {
                return a + b;  // La operación de sumar
            }
        };

        // RESTA
        Operacion resta = new Operacion() {
            @Override
            public double calcular(double a, double b) {
                return a - b;
            }
        };

        // MULTIPLICACIÓN
        Operacion multiplicacion = new Operacion() {
            @Override
            public double calcular(double a, double b) {
                return a * b;
            }
        };

        // DIVISIÓN (con comprobación para no dividir entre 0)
        Operacion division = new Operacion() {
            @Override
            public double calcular(double a, double b) {
                if (b == 0) {
                    System.out.println("¡Error! No se puede dividir entre 0");
                    return 0;
                }
                return a / b;
            }
        };

        // Usamos las operaciones
        double num1 = 10, num2 = 4;
        System.out.println("Suma: " + suma.calcular(num1, num2));           // 14.0
        System.out.println("Resta: " + resta.calcular(num1, num2));         // 6.0
        System.out.println("Multiplicación: " + multiplicacion.calcular(num1, num2)); // 40.0
        System.out.println("División: " + division.calcular(num1, num2));   // 2.5
    }
}
```

### Con Lambda (¡mucho más corto!):
```java
public class CalculadoraLambda {

    interface Operacion {
        double calcular(double a, double b);
    }

    public static void main(String[] args) {

        // Con lambda es como decir: "dados a y b, devuelve a+b"
        // Formato: (parametros) -> resultado
        Operacion suma           = (a, b) -> a + b;
        Operacion resta          = (a, b) -> a - b;
        Operacion multiplicacion = (a, b) -> a * b;
        Operacion division       = (a, b) -> b != 0 ? a / b : 0; // if b≠0 divide, si no 0

        double num1 = 10, num2 = 4;
        System.out.println("Suma: " + suma.calcular(num1, num2));
        System.out.println("Resta: " + resta.calcular(num1, num2));
        System.out.println("Multiplicación: " + multiplicacion.calcular(num1, num2));
        System.out.println("División: " + division.calcular(num1, num2));
    }
}
```

---

## EJERCICIO 2 — Filtrar números pares de una lista

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FiltroPares {
    public static void main(String[] args) {

        // Creamos una lista de números
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Con lambda: filtramos los pares
        // .stream()       → convierte la lista en una "cinta transportadora" de datos
        // .filter(...)    → deja pasar solo los que cumplen la condición
        // num % 2 == 0    → el resto de dividir por 2 es 0 → es par
        // .collect(...)   → recoge los resultados en una nueva lista
        List<Integer> pares = numeros.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("Lista original: " + numeros);
        System.out.println("Solo pares: " + pares); // [2, 4, 6, 8, 10]
    }
}
```

### 🔄 VARIANTE — Filtrar números impares:
```java
// Cambiar la condición: num % 2 != 0 (el resto NO es cero → es impar)
List<Integer> impares = numeros.stream()
        .filter(num -> num % 2 != 0)
        .collect(Collectors.toList());
System.out.println("Solo impares: " + impares); // [1, 3, 5, 7, 9]
```

### 🔄 VARIANTE — Filtrar números mayores que 5:
```java
List<Integer> mayoresDe5 = numeros.stream()
        .filter(num -> num > 5)
        .collect(Collectors.toList());
System.out.println("Mayores de 5: " + mayoresDe5); // [6, 7, 8, 9, 10]
```

---

## EJERCICIO 3 — Manejo de Hilos con Clase Anónima

```java
public class ManejoHilos {

    // Interfaz con el trabajo que hará el hilo
    interface Tarea {
        void ejecutar();
    }

    public static void main(String[] args) {

        // Clase anónima: definimos qué hace la tarea
        Tarea miTarea = new Tarea() {
            @Override
            public void ejecutar() {
                // Este código corre en un hilo separado (como otro "trabajador")
                System.out.println("Hilo: " + Thread.currentThread().getName() + " ejecutando la tarea");
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Paso " + i + " completado");
                }
            }
        };

        // Creamos el hilo pasando un Runnable que llama a nuestra tarea
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                miTarea.ejecutar(); // Ejecuta la tarea dentro del hilo
            }
        });

        System.out.println("Iniciando el hilo...");
        hilo.start(); // Arranca el hilo (corre en paralelo)
        System.out.println("El hilo principal sigue trabajando...");
    }
}
```

### Con Lambda (más limpio):
```java
public class ManejoHilosLambda {
    public static void main(String[] args) {

        // Con lambda, creamos el hilo directamente
        // Runnable es una interfaz funcional de Java con el método run()
        Thread hilo = new Thread(() -> {
            System.out.println("Hilo corriendo: " + Thread.currentThread().getName());
            for (int i = 1; i <= 5; i++) {
                System.out.println("Paso " + i);
            }
        });

        hilo.start(); // Arranca el hilo
    }
}
```

---

## EJERCICIO 4 — Operaciones Matemáticas con Lambda

```java
public class OperacionesMatematicas {

    // Interfaz funcional para operaciones con dos números
    interface OperacionMatematica {
        double operar(double a, double b);
    }

    public static void main(String[] args) {

        // Definimos todas las operaciones como lambdas
        OperacionMatematica suma  = (a, b) -> a + b;
        OperacionMatematica resta = (a, b) -> a - b;
        OperacionMatematica mult  = (a, b) -> a * b;
        OperacionMatematica div   = (a, b) -> b != 0 ? a / b : Double.NaN;
        OperacionMatematica potencia = (a, b) -> Math.pow(a, b); // a elevado a b

        // Probamos con diferentes números
        System.out.println("=== Con 10 y 3 ===");
        System.out.println("Suma: " + suma.operar(10, 3));       // 13.0
        System.out.println("Resta: " + resta.operar(10, 3));     // 7.0
        System.out.println("Mult: " + mult.operar(10, 3));       // 30.0
        System.out.println("Div: " + div.operar(10, 3));         // 3.333...
        System.out.println("Potencia: " + potencia.operar(10,3));// 1000.0

        System.out.println("\n=== Con 8 y 4 ===");
        System.out.println("Suma: " + suma.operar(8, 4));
        System.out.println("División: " + div.operar(8, 4));
    }
}
```

---

## EJERCICIO 5 — Manejo de Colecciones con Lambda (ordenar y filtrar Strings)

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ColeccionesStrings {
    public static void main(String[] args) {

        List<String> palabras = Arrays.asList("banana", "manzana", "pera", "melon", "mango", "mora");

        // PASO 1: Ordenar alfabéticamente
        // .sorted() ordena de A a Z por defecto
        List<String> ordenadas = palabras.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Ordenadas: " + ordenadas);

        // PASO 2: Filtrar las que empiezan con 'm'
        // .startsWith("m") → ¿empieza con m?
        List<String> conM = palabras.stream()
                .filter(p -> p.startsWith("m"))
                .collect(Collectors.toList());
        System.out.println("Empiezan con 'm': " + conM); // [melon, mango, mora]

        // PASO 3: Ordenar Y filtrar combinados
        List<String> ordenadasyConM = palabras.stream()
                .filter(p -> p.startsWith("m"))   // Primero filtramos
                .sorted()                          // Luego ordenamos
                .collect(Collectors.toList());
        System.out.println("Con 'm' y ordenadas: " + ordenadasyConM);
    }
}
```

---

## EJERCICIO 6 — Eventos con Clases Anónimas

```java
public class ManejoEventos {

    // Interfaz que representa un evento
    interface Evento {
        void manejar(String mensaje);
    }

    public static void main(String[] args) {

        // Clase anónima para el evento de "click de botón"
        Evento clickBoton = new Evento() {
            @Override
            public void manejar(String mensaje) {
                System.out.println("¡Botón clickeado! Mensaje: " + mensaje);
                System.out.println("Procesando la acción del botón...");
            }
        };

        // Clase anónima para el evento de "conexión"
        Evento conexion = new Evento() {
            @Override
            public void manejar(String mensaje) {
                System.out.println("Evento de conexión: " + mensaje);
                System.out.println("Estableciendo conexión con el servidor...");
            }
        };

        // Disparamos los eventos
        clickBoton.manejar("Guardar datos");
        System.out.println("---");
        conexion.manejar("Servidor principal");
    }
}
```

---

## EJERCICIO 7 — Operaciones con Números (cuadrado, raíz, doble)

```java
public class OperacionesNumericas {

    // Interfaz para operar con UN solo número
    interface OperacionNumerica {
        double operar(double numero);
    }

    public static void main(String[] args) {

        // Cada lambda hace una cosa con el número
        OperacionNumerica cuadrado   = n -> n * n;                // n²
        OperacionNumerica raiz       = n -> Math.sqrt(n);         // √n
        OperacionNumerica doble      = n -> n * 2;                // n×2
        OperacionNumerica triple     = n -> n * 3;
        OperacionNumerica negativo   = n -> -n;                   // cambia el signo
        OperacionNumerica absoluto   = n -> Math.abs(n);          // valor absoluto

        double numero = 9;
        System.out.println("Número original: " + numero);
        System.out.println("Cuadrado: " + cuadrado.operar(numero));   // 81.0
        System.out.println("Raíz cuadrada: " + raiz.operar(numero)); // 3.0
        System.out.println("Doble: " + doble.operar(numero));         // 18.0
        System.out.println("Triple: " + triple.operar(numero));       // 27.0

        double negNum = -5;
        System.out.println("\nNúmero: " + negNum);
        System.out.println("Negativo: " + negativo.operar(negNum));   // 5.0
        System.out.println("Absoluto: " + absoluto.operar(negNum));   // 5.0
    }
}
```

---

## EJERCICIO 8 — Manejo de Strings con Lambda (mayúsculas y filtrado)

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManejoStrings {
    public static void main(String[] args) {

        List<String> palabras = Arrays.asList("hola", "mundo", "java", "programacion", "android");

        // Convertir a MAYÚSCULAS con .map()
        // .map() transforma cada elemento en otra cosa
        // String::toUpperCase es un método que ya existe en Java para pasar a mayúsculas
        List<String> mayusculas = palabras.stream()
                .map(String::toUpperCase)       // equivale a p -> p.toUpperCase()
                .collect(Collectors.toList());
        System.out.println("Mayúsculas: " + mayusculas);

        // Filtrar strings que contienen la letra 'a'
        // .contains("a") → ¿la palabra tiene la letra 'a'?
        List<String> conLetraA = palabras.stream()
                .filter(p -> p.contains("a"))
                .collect(Collectors.toList());
        System.out.println("Contienen 'a': " + conLetraA);

        // Combinar: mayúsculas Y que contengan 'A' (ya están en mayúsculas)
        List<String> mayusculasConA = palabras.stream()
                .map(String::toUpperCase)
                .filter(p -> p.contains("A"))
                .collect(Collectors.toList());
        System.out.println("Mayúsculas con 'A': " + mayusculasConA);
    }
}
```

---

## EJERCICIO 10 — Operaciones con Arrays con Lambda

```java
import java.util.Arrays;

public class OperacionesArray {

    // Interfaz para operar sobre un array entero
    interface OperacionArray {
        int operar(int[] array);
    }

    public static void main(String[] args) {

        int[] numeros = {3, 7, 1, 9, 4, 6, 2, 8, 5};

        // Lambda para sumar todos los elementos
        // Arrays.stream(array).sum() → suma todos los números del array
        OperacionArray sumarTodo = array -> Arrays.stream(array).sum();

        // Lambda para encontrar el máximo
        OperacionArray encontrarMaximo = array -> Arrays.stream(array).max().orElse(0);

        // Lambda para encontrar el mínimo
        OperacionArray encontrarMinimo = array -> Arrays.stream(array).min().orElse(0);

        // Lambda para contar elementos
        OperacionArray contarElementos = array -> array.length;

        System.out.println("Array: " + Arrays.toString(numeros));
        System.out.println("Suma total: " + sumarTodo.operar(numeros));           // 45
        System.out.println("Máximo: " + encontrarMaximo.operar(numeros));          // 9
        System.out.println("Mínimo: " + encontrarMinimo.operar(numeros));          // 1
        System.out.println("Cantidad de elementos: " + contarElementos.operar(numeros)); // 9
    }
}
```

---

## EJERCICIO 11 — Uso de doble colon (::) para ordenar Personas

```java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Clase Persona con nombre y edad
class Persona {
    private String nombre;
    private int edad;

    // Constructor: inicializa la persona
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getters: métodos para obtener los valores
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }

    // toString: cómo se ve la persona al imprimirla
    @Override
    public String toString() {
        return nombre + " (" + edad + " años)";
    }
}

public class OrdenarPersonas {
    public static void main(String[] args) {

        // Creamos el ArrayList con personas
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Carlos", 30));
        personas.add(new Persona("Ana", 25));
        personas.add(new Persona("Beatriz", 30));
        personas.add(new Persona("David", 20));
        personas.add(new Persona("Elena", 25));

        // Ordenar: primero por edad DESCENDENTE, luego por nombre ALFABÉTICO
        // Comparator.comparingInt → compara por un número entero
        // .reversed()            → invierte el orden (de mayor a menor)
        // .thenComparing(...)    → si la edad es igual, compara por nombre
        personas.sort(
            Comparator.comparingInt(Persona::getEdad)  // :: = "referencia al método getEdad"
                      .reversed()                       // edad descendente (30 → 20)
                      .thenComparing(Persona::getNombre)// si empatan en edad, orden A-Z por nombre
        );

        System.out.println("=== Personas ordenadas ===");
        // forEach con :: imprime cada elemento usando System.out.println
        personas.forEach(System.out::println);

        // removeIf: elimina los que cumplen la condición
        // Aquí eliminamos los menores de 25 años
        personas.removeIf(p -> p.getEdad() < 25);
        System.out.println("\n=== Después de eliminar menores de 25 ===");
        personas.forEach(System.out::println);
    }
}
```

---

## EJERCICIO 12 — Expresiones Lambda: filtrar, map y reduce

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdasCompleto {
    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // --- PARTE 1: Filtrar pares ---
        List<Integer> pares = numeros.stream()
                .filter(n -> n % 2 == 0)    // Solo pasan los pares
                .collect(Collectors.toList());
        System.out.println("Pares: " + pares);

        // --- PARTE 2: Convertir lista de Strings a mayúsculas con map() ---
        List<String> palabras = Arrays.asList("hola", "mundo", "java");

        List<String> mayusculas = palabras.stream()
                .map(String::toUpperCase)   // Transforma cada palabra a mayúsculas
                .collect(Collectors.toList());
        System.out.println("Mayúsculas: " + mayusculas);

        // --- PARTE 3: Sumar todos los elementos con reduce() ---
        // reduce() "acumula" el resultado: empieza en 0 y va sumando
        // Integer::sum es lo mismo que (a, b) -> a + b
        int suma = numeros.stream()
                .reduce(0, Integer::sum);   // 0 es el valor inicial
        System.out.println("Suma total: " + suma); // 55
    }
}
```

---

# PARTE 2: EJERCICIOS DE COLECCIONES

## ¿Qué son las colecciones en Java?
Son como **cajas** para guardar varios objetos:
- **ArrayList**: Lista ordenada, como una fila. Permite duplicados.
- **HashSet**: Bolsa sin orden. NO permite duplicados.
- **HashMap**: Diccionario con clave→valor (ej: nombre→edad).
- **TreeSet**: Como HashSet pero ordenado automáticamente.
- **LinkedList**: Lista como cadena de eslabones. Buena para insertar/borrar.
- **Queue**: Cola (FIFO: el primero que entra es el primero que sale).
- **Stack**: Pila (LIFO: el último que entra es el primero que sale).

---

## EJERCICIO 1 — ArrayList: agregar y mostrar números

```java
import java.util.ArrayList;
import java.util.List;

public class Ejercicio1_ArrayList {
    public static void main(String[] args) {

        // Creamos un ArrayList vacío que guardará números enteros
        List<Integer> lista = new ArrayList<>();

        // Añadimos números del 1 al 5 con un bucle
        for (int i = 1; i <= 5; i++) {
            lista.add(i);  // .add() añade un elemento al final de la lista
        }

        System.out.println("Lista: " + lista); // [1, 2, 3, 4, 5]
        System.out.println("Tamaño: " + lista.size()); // 5
        System.out.println("Primer elemento: " + lista.get(0)); // 1 (índice empieza en 0)
        System.out.println("Último elemento: " + lista.get(lista.size() - 1)); // 5
    }
}
```

---

## EJERCICIO 2 — Eliminar números pares de una lista

```java
import java.util.ArrayList;
import java.util.List;

public class Ejercicio2_Eliminar {
    public static void main(String[] args) {

        List<Integer> lista = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            lista.add(i);
        }
        System.out.println("Antes: " + lista); // [1, 2, 3, ..., 10]

        // removeIf() elimina los elementos que cumplan la condición lambda
        // n % 2 == 0 → el número es par → lo eliminamos
        lista.removeIf(n -> n % 2 == 0);

        System.out.println("Después (solo impares): " + lista); // [1, 3, 5, 7, 9]
    }
}
```

---

## EJERCICIO 3 — Buscar un elemento en una lista

```java
import java.util.ArrayList;
import java.util.List;

public class Ejercicio3_Buscar {
    public static void main(String[] args) {

        List<Integer> lista = new ArrayList<>();
        for (int i = 1; i <= 10; i++) lista.add(i);

        int numeroABuscar = 7;

        // indexOf() devuelve la posición del elemento, o -1 si no existe
        int indice = lista.indexOf(numeroABuscar);

        if (indice != -1) {
            System.out.println("El número " + numeroABuscar + " está en la posición: " + indice);
        } else {
            System.out.println("El número " + numeroABuscar + " NO está en la lista");
        }

        // contains() solo dice si está o no (true/false)
        boolean existe = lista.contains(5);
        System.out.println("¿Existe el 5? " + existe); // true
    }
}
```

---

## EJERCICIO 4 — Eliminar duplicados con HashSet

```java
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ejercicio4_SinDuplicados {
    public static void main(String[] args) {

        // Lista CON duplicados
        List<Integer> lista = new ArrayList<>();
        lista.add(1); lista.add(2); lista.add(2);
        lista.add(3); lista.add(4); lista.add(4); lista.add(5);
        System.out.println("Con duplicados: " + lista);

        // HashSet: automáticamente elimina duplicados al añadir
        // Lo creamos pasándole la lista (hace la copia sin duplicados)
        Set<Integer> sinDuplicados = new HashSet<>(lista);
        System.out.println("Sin duplicados: " + sinDuplicados);

        // Si queremos devolver a una lista:
        lista.clear();          // Vaciamos la lista original
        lista.addAll(sinDuplicados); // Llenamos con los únicos
        System.out.println("Lista sin duplicados: " + lista);
    }
}
```

---

## EJERCICIO 5 — Intersección de dos conjuntos

```java
import java.util.HashSet;
import java.util.Set;

public class Ejercicio5_Interseccion {
    public static void main(String[] args) {

        // Conjunto 1: números del 1 al 5
        Set<Integer> conjunto1 = new HashSet<>();
        for (int i = 1; i <= 5; i++) conjunto1.add(i); // {1, 2, 3, 4, 5}

        // Conjunto 2: números del 3 al 7
        Set<Integer> conjunto2 = new HashSet<>();
        for (int i = 3; i <= 7; i++) conjunto2.add(i); // {3, 4, 5, 6, 7}

        System.out.println("Conjunto 1: " + conjunto1);
        System.out.println("Conjunto 2: " + conjunto2);

        // INTERSECCIÓN: elementos que están en AMBOS conjuntos
        // retainAll() deja solo los elementos que también están en conjunto2
        Set<Integer> interseccion = new HashSet<>(conjunto1); // Copiamos conjunto1
        interseccion.retainAll(conjunto2);
        System.out.println("Intersección: " + interseccion); // {3, 4, 5}

        // UNIÓN: todos los elementos de ambos (sin repetir)
        Set<Integer> union = new HashSet<>(conjunto1); // Copiamos conjunto1
        union.addAll(conjunto2); // Añadimos conjunto2 (los duplicados se ignoran)
        System.out.println("Unión: " + union); // {1, 2, 3, 4, 5, 6, 7}

        // DIFERENCIA: lo que tiene conjunto1 y NO tiene conjunto2
        Set<Integer> diferencia = new HashSet<>(conjunto1);
        diferencia.removeAll(conjunto2); // Quitamos los que están en conjunto2
        System.out.println("Diferencia (1 - 2): " + diferencia); // {1, 2}
    }
}
```

---

## EJERCICIO 6 — Contar frecuencia de caracteres (HashMap)

```java
import java.util.HashMap;
import java.util.Map;

public class Ejercicio6_FrecuenciaCaracteres {
    public static void main(String[] args) {

        String cadena = "abracadabra";

        // HashMap: guarda pares clave→valor (aquí: carácter→cuántas veces aparece)
        Map<Character, Integer> frecuencia = new HashMap<>();

        // Recorremos cada carácter de la cadena
        for (char c : cadena.toCharArray()) {
            // getOrDefault(c, 0): busca 'c' en el mapa, si no existe devuelve 0
            // Sumamos 1 a lo que ya había
            frecuencia.put(c, frecuencia.getOrDefault(c, 0) + 1);
        }

        System.out.println("Cadena: " + cadena);
        System.out.println("Frecuencias: " + frecuencia);
        // Ejemplo: {a=5, b=2, r=2, c=1, d=1}
    }
}
```

---

## EJERCICIO 7 — Ordenar un mapa por sus claves (TreeMap)

```java
import java.util.Map;
import java.util.TreeMap;

public class Ejercicio7_MapaOrdenado {
    public static void main(String[] args) {

        // TreeMap ordena automáticamente las claves de A a Z
        Map<String, Integer> mapa = new TreeMap<>();
        mapa.put("Banana", 3);
        mapa.put("Apple", 1);
        mapa.put("Orange", 2);
        mapa.put("Mango", 4);

        // Al imprimir, ya está ordenado: Apple, Banana, Mango, Orange
        System.out.println("Mapa ordenado: " + mapa);

        // Recorrer el mapa con forEach
        System.out.println("=== Detalle ===");
        mapa.forEach((fruta, cantidad) ->
            System.out.println(fruta + " → cantidad: " + cantidad)
        );
    }
}
```

---

## EJERCICIO 8 — Invertir una lista

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ejercicio8_Invertir {
    public static void main(String[] args) {

        List<Integer> lista = new ArrayList<>();
        for (int i = 1; i <= 5; i++) lista.add(i); // [1, 2, 3, 4, 5]

        System.out.println("Original: " + lista);

        // Collections.reverse() invierte el orden de la lista
        Collections.reverse(lista);

        System.out.println("Invertida: " + lista); // [5, 4, 3, 2, 1]

        // Ordenar de nuevo
        Collections.sort(lista);
        System.out.println("Ordenada: " + lista); // [1, 2, 3, 4, 5]
    }
}
```

---

## EJERCICIO 9 — Convertir mapa a lista de claves

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ejercicio9_ClavesComoLista {
    public static void main(String[] args) {

        Map<String, Integer> mapa = new HashMap<>();
        mapa.put("Uno", 1);
        mapa.put("Dos", 2);
        mapa.put("Tres", 3);
        mapa.put("Cuatro", 4);

        // keySet() devuelve todas las claves del mapa como un Set
        // Lo pasamos a ArrayList para tenerlo como lista
        List<String> claves = new ArrayList<>(mapa.keySet());
        System.out.println("Claves: " + claves);

        // values() devuelve todos los valores
        List<Integer> valores = new ArrayList<>(mapa.values());
        System.out.println("Valores: " + valores);
    }
}
```

---

## EJERCICIO 10 — Cola (Queue) para simular una fila

```java
import java.util.LinkedList;
import java.util.Queue;

public class Ejercicio10_Cola {
    public static void main(String[] args) {

        // Queue = Cola. El PRIMERO en entrar es el PRIMERO en salir (FIFO)
        // Como una cola del supermercado
        Queue<String> cola = new LinkedList<>();

        // .offer() o .add() añade al FINAL de la cola
        cola.offer("Persona 1");
        cola.offer("Persona 2");
        cola.offer("Persona 3");
        cola.offer("Persona 4");

        System.out.println("Cola: " + cola);
        System.out.println("Próximo en ser atendido: " + cola.peek()); // Ver sin quitar

        // .poll() saca el PRIMERO de la cola (lo atiende y lo elimina)
        while (!cola.isEmpty()) {
            String persona = cola.poll();
            System.out.println("Atendiendo a: " + persona);
        }

        System.out.println("Cola vacía: " + cola.isEmpty()); // true
    }
}
```

---

## EJERCICIO 11 — Eliminar elemento de un Set

```java
import java.util.HashSet;
import java.util.Set;

public class Ejercicio11_EliminarDelSet {
    public static void main(String[] args) {

        Set<Integer> conjunto = new HashSet<>();
        for (int i = 1; i <= 5; i++) conjunto.add(i);

        System.out.println("Antes: " + conjunto); // {1, 2, 3, 4, 5}

        // .remove() elimina el elemento específico
        conjunto.remove(3);

        System.out.println("Después de quitar el 3: " + conjunto); // {1, 2, 4, 5}

        // contains() comprueba si existe
        System.out.println("¿Existe el 3? " + conjunto.contains(3)); // false
        System.out.println("¿Existe el 4? " + conjunto.contains(4)); // true
    }
}
```

---

## EJERCICIO 14 — Pila (Stack) para invertir una cadena

```java
import java.util.Stack;

public class Ejercicio14_Pila {
    public static void main(String[] args) {

        String cadena = "Hola Mundo";

        // Stack = Pila. El ÚLTIMO en entrar es el PRIMERO en salir (LIFO)
        // Como una pila de platos: pones encima, coges de encima
        Stack<Character> pila = new Stack<>();

        // Metemos cada carácter en la pila
        for (char c : cadena.toCharArray()) {
            pila.push(c); // push = empujar hacia arriba
        }

        // Sacamos los caracteres (en orden inverso) y construimos el resultado
        StringBuilder resultado = new StringBuilder();
        while (!pila.isEmpty()) {
            resultado.append(pila.pop()); // pop = sacar el de arriba
        }

        System.out.println("Original: " + cadena);
        System.out.println("Invertida: " + resultado); // odnuM aloH
    }
}
```

---

## EJERCICIO 15 — Mapear nombres a sus longitudes

```java
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ejercicio15_MapaLongitudes {
    public static void main(String[] args) {

        List<String> nombres = Arrays.asList("Juan", "Ana", "Roberto", "María", "Alejandro");

        // Creamos un mapa donde la clave es el nombre y el valor es su longitud
        Map<String, Integer> mapaLongitudes = new HashMap<>();
        for (String nombre : nombres) {
            mapaLongitudes.put(nombre, nombre.length());
            //  "Juan" → 4,  "Ana" → 3,  "Roberto" → 7, etc.
        }

        System.out.println("Nombre → Longitud:");
        mapaLongitudes.forEach((nombre, longitud) ->
            System.out.println(nombre + " → " + longitud + " letras")
        );
    }
}
```

---

## EJERCICIO A — ArrayList completo (máx, mín, suma, ordenar)

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListCompleto {
    public static void main(String[] args) {

        List<Integer> lista = new ArrayList<>();
        lista.add(15); lista.add(3); lista.add(8);
        lista.add(22); lista.add(1); lista.add(14);

        System.out.println("Lista: " + lista);

        // Máximo: Collections.max() busca el mayor
        System.out.println("Máximo: " + Collections.max(lista));  // 22

        // Mínimo: Collections.min() busca el menor
        System.out.println("Mínimo: " + Collections.min(lista));  // 1

        // Suma: con stream y reduce
        int suma = lista.stream().reduce(0, Integer::sum);
        System.out.println("Suma: " + suma);

        // Ordenar de menor a mayor
        Collections.sort(lista);
        System.out.println("Ordenada: " + lista);

        // Ordenar de mayor a menor
        lista.sort(Collections.reverseOrder());
        System.out.println("Invertida: " + lista);
    }
}
```

---

## EJERCICIO B — LinkedList: insertar, eliminar, actualizar

```java
import java.util.LinkedList;

public class LinkedListEjemplo {
    public static void main(String[] args) {

        // LinkedList: lista enlazada, buena para insertar y borrar en cualquier posición
        LinkedList<String> lista = new LinkedList<>();

        // Añadir al final
        lista.add("Manzana");
        lista.add("Banana");
        lista.add("Cereza");

        // Añadir al principio
        lista.addFirst("Aguacate");

        // Añadir al final
        lista.addLast("Dátil");

        System.out.println("Lista: " + lista);
        // [Aguacate, Manzana, Banana, Cereza, Dátil]

        // Eliminar el primero
        lista.removeFirst();

        // Eliminar un elemento concreto
        lista.remove("Banana");

        System.out.println("Después de borrar: " + lista);

        // Actualizar (cambiar) un elemento en posición 1
        lista.set(1, "Blueberry"); // set(índice, nuevoValor)
        System.out.println("Tras actualizar: " + lista);

        // Convertir a array
        Object[] array = lista.toArray();
        System.out.println("Como array: " + java.util.Arrays.toString(array));
    }
}
```

---

## EJERCICIO C — HashMap completo (personas y edades)

```java
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class HashMapPersonas {
    public static void main(String[] args) {

        // HashMap: clave = nombre, valor = edad
        Map<String, Integer> personas = new HashMap<>();

        // Añadir personas
        personas.put("Juan", 25);
        personas.put("María", 30);
        personas.put("Pedro", 22);
        personas.put("Ana", 35);
        personas.put("Luis", 28);

        System.out.println("Mapa: " + personas);

        // Actualizar la edad de Juan
        personas.put("Juan", 26); // put con la misma clave → actualiza

        // Eliminar a Pedro
        personas.remove("Pedro");

        // Buscar una persona
        System.out.println("Edad de María: " + personas.get("María"));
        System.out.println("¿Existe Carlos? " + personas.containsKey("Carlos")); // false

        // Iterar: recorrer todas las entradas
        System.out.println("=== Todos ===");
        for (Map.Entry<String, Integer> entry : personas.entrySet()) {
            System.out.println(entry.getKey() + " tiene " + entry.getValue() + " años");
        }

        // Encontrar personas mayores de 27 con lambda
        System.out.println("=== Mayores de 27 ===");
        personas.entrySet().stream()
                .filter(e -> e.getValue() > 27)
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}
```

---

## EJERCICIO D — TreeSet (ordenado automático)

```java
import java.util.TreeSet;

public class TreeSetEjemplo {
    public static void main(String[] args) {

        // TreeSet: como HashSet pero ordenado automáticamente (A-Z o menor a mayor)
        TreeSet<String> frutas = new TreeSet<>();
        frutas.add("Mango");
        frutas.add("Apple");
        frutas.add("Banana");
        frutas.add("Cereza");
        frutas.add("Apple"); // Los duplicados se ignoran

        System.out.println("Frutas (ordenadas): " + frutas);
        // [Apple, Banana, Cereza, Mango]

        // Primera y última
        System.out.println("Primera: " + frutas.first()); // Apple
        System.out.println("Última: " + frutas.last());   // Mango

        // Eliminar
        frutas.remove("Banana");
        System.out.println("Tras borrar Banana: " + frutas);

        // Verificar existencia
        System.out.println("¿Existe Mango? " + frutas.contains("Mango")); // true
    }
}
```

---

## EJERCICIO E — PriorityQueue (cola con prioridad)

```java
import java.util.PriorityQueue;

public class PriorityQueueEjemplo {
    public static void main(String[] args) {

        // PriorityQueue: cola donde el MENOR número tiene más prioridad
        PriorityQueue<Integer> cola = new PriorityQueue<>();

        // Añadimos números en cualquier orden
        cola.offer(30);
        cola.offer(10);
        cola.offer(20);
        cola.offer(5);
        cola.offer(15);

        System.out.println("Cola (no ordenada visualmente): " + cola);

        // Al sacar con poll(), siempre saca el MENOR primero
        System.out.println("=== Sacando en orden de prioridad ===");
        while (!cola.isEmpty()) {
            System.out.println("Sale: " + cola.poll());
        }
        // Sale: 5, 10, 15, 20, 30 (de menor a mayor)
    }
}
```

---

## EJERCICIO F — Collections (ordenar, mezclar, buscar)

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsEjemplo {
    public static void main(String[] args) {

        List<Integer> lista = new ArrayList<>();
        for (int i = 1; i <= 8; i++) lista.add(i);

        System.out.println("Original: " + lista);

        // sort(): ordena de menor a mayor
        Collections.sort(lista);
        System.out.println("Ordenada: " + lista);

        // shuffle(): mezcla aleatoriamente
        Collections.shuffle(lista);
        System.out.println("Mezclada: " + lista);

        // reverse(): invierte el orden actual
        Collections.sort(lista); // primero ordenamos
        Collections.reverse(lista);
        System.out.println("Invertida: " + lista); // de mayor a menor

        // binarySearch(): busca un elemento (la lista debe estar ordenada)
        Collections.sort(lista); // ordenamos antes de buscar
        int pos = Collections.binarySearch(lista, 5);
        System.out.println("Posición del 5: " + pos);

        // frequency(): cuenta cuántas veces aparece un elemento
        lista.add(3); // añadimos un 3 extra
        System.out.println("Veces que aparece el 3: " + Collections.frequency(lista, 3));
    }
}
```

---

## EJERCICIO G — Clase Colegio con HashMap (ejercicio del PDF)

```java
import java.util.HashMap;
import java.util.Map;

// Excepción personalizada para cuando la nacionalidad está vacía
class ExceptionVacio extends Exception {
    public ExceptionVacio(String mensaje) {
        super(mensaje); // Llama al constructor de Exception con el mensaje
    }
}

// Clase principal que gestiona nacionalidades de alumnos
class Colegio {
    // El mapa guarda: nacionalidad → número de alumnos con esa nacionalidad
    private Map<String, Integer> nacionalidades = new HashMap<>();

    // Añade la nacionalidad de un nuevo alumno
    public void addAlumno(String nacionalidad) throws ExceptionVacio {
        // Validación: si la nacionalidad está vacía, lanzamos la excepción
        if (nacionalidad == null || nacionalidad.trim().isEmpty()) {
            throw new ExceptionVacio("¡La nacionalidad no puede estar vacía!");
        }

        // Guardamos en MAYÚSCULAS siempre
        String nac = nacionalidad.toUpperCase();

        // Si ya existe, sumamos 1; si no existe, empezamos en 1
        nacionalidades.put(nac, nacionalidades.getOrDefault(nac, 0) + 1);
    }

    // Muestra todas las nacionalidades y cuántos alumnos hay de cada una
    public void showAll() {
        System.out.println("=== Todas las nacionalidades ===");
        for (String key : nacionalidades.keySet()) {
            System.out.println(key + " → " + nacionalidades.get(key) + " alumnos");
        }
    }

    // Muestra solo una nacionalidad específica
    public void showNacionalidad(String nacionalidad) {
        String nac = nacionalidad.toUpperCase();
        if (nacionalidades.containsKey(nac)) {
            System.out.println(nac + " → " + nacionalidades.get(nac) + " alumnos");
        } else {
            System.out.println("No hay alumnos de nacionalidad: " + nac);
        }
    }

    // Devuelve cuántas nacionalidades diferentes hay
    public void cuantos() {
        System.out.println("Nacionalidades diferentes: " + nacionalidades.size());
    }

    // Elimina todos los datos
    public void borra() {
        nacionalidades.clear();
        System.out.println("Datos borrados.");
    }
}

// Clase para probar el Colegio
public class TestColegio {
    public static void main(String[] args) {
        Colegio colegio = new Colegio();

        try {
            colegio.addAlumno("española");
            colegio.addAlumno("Española");
            colegio.addAlumno("francesa");
            colegio.addAlumno("ITALIANA");
            colegio.addAlumno("francesa");
            colegio.addAlumno(""); // Esto lanzará la excepción
        } catch (ExceptionVacio e) {
            System.out.println("Error capturado: " + e.getMessage());
        }

        colegio.showAll();
        colegio.showNacionalidad("francesa");
        colegio.cuantos();
        colegio.borra();
        colegio.showAll();
    }
}
```

---

## EJERCICIO H — ArrayList días de la semana (ejercicio del PDF)

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DiasSemanaPDF {
    public static void main(String[] args) {

        // Creamos la lista con los días
        List<String> listaDias = new ArrayList<>();
        listaDias.add("Lunes");
        listaDias.add("Martes");
        listaDias.add("Miércoles");
        listaDias.add("Jueves");
        listaDias.add("Viernes");
        listaDias.add("Sábado");
        listaDias.add("Domingo");

        System.out.println("Días: " + listaDias);

        // Insertar en posición 4 (índice 3) el "Juernes"
        listaDias.add(3, "Juernes"); // add(índice, elemento)
        System.out.println("Con Juernes: " + listaDias);

        // Copiar la lista
        List<String> listaDos = new ArrayList<>(listaDias);

        // Añadir listaDos a listaDias
        listaDias.addAll(listaDos);
        System.out.println("Tamaño tras añadir copia: " + listaDias.size());

        // Mostrar posiciones 3 y 4
        System.out.println("Posición 3: " + listaDias.get(3));
        System.out.println("Posición 4: " + listaDias.get(4));

        // Primero y último (usando índices)
        System.out.println("Primero: " + listaDias.get(0));
        System.out.println("Último: " + listaDias.get(listaDias.size() - 1));

        // Eliminar "Juernes"
        if (listaDias.remove("Juernes")) {
            System.out.println("Juernes borrado");
        } else {
            System.out.println("No existe");
        }

        // Recorrer con iterador
        System.out.println("=== Con iterador ===");
        Iterator<String> it = listaDias.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // ¿Existe Lunes? (sensible a mayúsculas)
        System.out.println("¿Existe Lunes? " + listaDias.contains("Lunes"));

        // ¿Existe lunes? (ignorando mayúsculas)
        String buscar = "lunes";
        boolean existe = listaDias.stream()
                .anyMatch(d -> d.equalsIgnoreCase(buscar));
        System.out.println("¿Existe 'lunes' (sin importar mayúsculas)? " + existe);

        // Ordenar y mostrar
        Collections.sort(listaDias);
        System.out.println("Ordenada: " + listaDias);

        // Borrar todo
        listaDias.clear();
        System.out.println("Lista vacía: " + listaDias.isEmpty()); // true
    }
}
```

---

## EJERCICIO I — Set de Jugadores (ejercicio del PDF)

```java
import java.util.HashSet;
import java.util.Set;

public class JugadoresFCB {
    public static void main(String[] args) {

        // Set de jugadores del Barça
        Set<String> jugadores = new HashSet<>();
        jugadores.add("Ter Stegen");
        jugadores.add("Piqué");
        jugadores.add("Busquets");
        jugadores.add("Pedri");
        jugadores.add("Lewandowski");
        jugadores.add("Gavi");

        // Mostrar todos
        System.out.println("=== Jugadores del FC Barcelona ===");
        for (String nombre : jugadores) {
            System.out.println(nombre);
        }

        // Consultar si existe un jugador
        String buscado = "Neymar JR";
        if (jugadores.contains(buscado)) {
            System.out.println(buscado + " SÍ está en el equipo");
        } else {
            System.out.println(buscado + " NO está en el equipo");
        }

        // Segundo conjunto
        Set<String> jugadores2 = new HashSet<>();
        jugadores2.add("Piqué");
        jugadores2.add("Busquets");

        // ¿Están todos los de jugadores2 en jugadores?
        boolean todosContenidos = jugadores.containsAll(jugadores2);
        System.out.println("¿jugadores2 ⊆ jugadores? " + todosContenidos);

        // Unión de ambos conjuntos
        jugadores.addAll(jugadores2);
        System.out.println("Tras la unión, jugadores tiene: " + jugadores.size());

        // Eliminar todos los de jugadores2 de jugadores2 y contar
        jugadores2.removeAll(jugadores2);
        System.out.println("jugadores2 tras borrar todo: " + jugadores2.size()); // 0
    }
}
```

---

# PARTE 3: LAMBDAS CON STREAMS (los más importantes del examen)

## RESUMEN RÁPIDO de métodos de Stream:
| Método | ¿Para qué sirve? | Ejemplo |
|--------|-------------------|---------|
| `.filter(condición)` | Deja pasar solo los que cumplen la condición | `.filter(n -> n > 5)` |
| `.map(transformación)` | Transforma cada elemento en otra cosa | `.map(String::toUpperCase)` |
| `.sorted()` | Ordena de menor a mayor / A a Z | `.sorted()` |
| `.sorted(Comparator)` | Ordena con criterio personalizado | `.sorted(Comparator.reversed())` |
| `.reduce(inicio, función)` | Acumula todos en un solo valor | `.reduce(0, Integer::sum)` |
| `.collect(Collectors.toList())` | Guarda el resultado en una lista | `.collect(Collectors.toList())` |
| `.count()` | Cuenta cuántos elementos hay | `.count()` |
| `.forEach(acción)` | Hace algo con cada elemento | `.forEach(System.out::println)` |
| `.max(comparador)` | Encuentra el máximo | `.max(Comparator.naturalOrder())` |
| `.min(comparador)` | Encuentra el mínimo | `.min(Comparator.naturalOrder())` |

---

## EJERCICIO STREAM 1 — Filtrar, transformar y contar

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamEjemplo1 {
    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // 1. Filtrar pares
        List<Integer> pares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Pares: " + pares);

        // 2. Suma de pares
        int sumaPares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
        System.out.println("Suma de pares: " + sumaPares); // 30

        // 3. Cuántos números son mayores de 5
        long cantidad = numeros.stream()
                .filter(n -> n > 5)
                .count();
        System.out.println("Mayores de 5: " + cantidad); // 5

        // 4. Suma de todos
        int total = numeros.stream().reduce(0, Integer::sum);
        System.out.println("Suma total: " + total); // 55

        // 5. Estadísticas completas de los pares
        numeros.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .summaryStatistics();
    }
}
```

---

## EJERCICIO STREAM 2 — Operaciones con objetos Persona

```java
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Persona {
    String nombre;
    int edad;
    String ciudad;

    Persona(String nombre, int edad, String ciudad) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getCiudad() { return ciudad; }

    @Override
    public String toString() {
        return nombre + " (" + edad + ") - " + ciudad;
    }
}

public class StreamPersonas {
    public static void main(String[] args) {

        List<Persona> personas = Arrays.asList(
            new Persona("Juan", 20, "Madrid"),
            new Persona("María", 25, "Barcelona"),
            new Persona("Pedro", 18, "Madrid"),
            new Persona("Ana", 30, "Barcelona"),
            new Persona("Luis", 22, "Sevilla")
        );

        // 1. Filtrar mayores de 20 y obtener sus nombres
        List<String> nombresMayores = personas.stream()
                .filter(p -> p.getEdad() > 20)
                .map(Persona::getNombre)    // Persona::getNombre = p -> p.getNombre()
                .collect(Collectors.toList());
        System.out.println("Mayores de 20: " + nombresMayores);

        // 2. Ordenar por edad (de menor a mayor)
        personas.stream()
                .sorted(Comparator.comparingInt(Persona::getEdad))
                .forEach(System.out::println);

        // 3. Ordenar por ciudad y luego por edad
        System.out.println("=== Por ciudad y edad ===");
        personas.stream()
                .sorted(Comparator.comparing(Persona::getCiudad)
                        .thenComparingInt(Persona::getEdad))
                .forEach(System.out::println);

        // 4. Agrupar por ciudad
        Map<String, List<Persona>> porCiudad = personas.stream()
                .collect(Collectors.groupingBy(Persona::getCiudad));
        porCiudad.forEach((ciudad, lista) -> {
            System.out.println("Ciudad: " + ciudad + " → " + lista.size() + " personas");
        });

        // 5. Promedio de edades
        double promedio = personas.stream()
                .mapToInt(Persona::getEdad)
                .average()
                .orElse(0);
        System.out.println("Edad media: " + promedio);
    }
}
```

---

## EJERCICIO STREAM 3 — Palabras que empiezan con vocal

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamVocales {
    public static void main(String[] args) {

        List<String> palabras = Arrays.asList("java", "hola", "eclipse", "android",
                                              "idea", "mundo", "ubuntu", "ocean");

        // Filtrar las que empiezan con vocal
        // charAt(0) → primer carácter
        // "aeiou".contains(...) → comprueba si es vocal
        List<String> conVocal = palabras.stream()
                .filter(p -> "aeiouAEIOU".contains(String.valueOf(p.charAt(0))))
                .collect(Collectors.toList());
        System.out.println("Empiezan con vocal: " + conVocal);

        // Contar cuántas son
        long cantidad = palabras.stream()
                .filter(p -> "aeiouAEIOU".contains(String.valueOf(p.charAt(0))))
                .count();
        System.out.println("Cantidad: " + cantidad);
    }
}
```

---

## EJERCICIO STREAM 4 — Combinación y exclusión de listas

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCombinar {
    public static void main(String[] args) {

        List<String> lista1 = Arrays.asList("a", "b", "c", "d", "e");
        List<String> lista2 = Arrays.asList("c", "d", "e", "f", "g");

        // UNIR las dos listas en una
        List<String> combinada = Stream.concat(lista1.stream(), lista2.stream())
                .collect(Collectors.toList());
        System.out.println("Combinada: " + combinada);

        // ELEMENTOS EXCLUSIVOS de lista1 (que NO están en lista2)
        List<String> exclusivos = lista1.stream()
                .filter(e -> !lista2.contains(e)) // solo si NO está en lista2
                .collect(Collectors.toList());
        System.out.println("Solo en lista1: " + exclusivos); // [a, b]

        // INTERSECCIÓN (los que están en AMBAS)
        List<String> comunes = lista1.stream()
                .filter(lista2::contains) // lista2::contains = e -> lista2.contains(e)
                .collect(Collectors.toList());
        System.out.println("En ambas: " + comunes); // [c, d, e]
    }
}
```

---

# 🚀 VARIANTES EXTRA PARA PRACTICAR

## VARIANTE 1 — Calcular promedio (anónima + lambda)

```java
import java.util.Arrays;

public class VariantePromedio {

    interface CalculadoraPromedio {
        double calcular(int[] array);
    }

    public static void main(String[] args) {

        int[] numeros = {10, 20, 30, 40, 50};

        // Con clase anónima
        CalculadoraPromedio anonima = new CalculadoraPromedio() {
            @Override
            public double calcular(int[] array) {
                return Arrays.stream(array).average().orElse(0);
            }
        };

        // Con lambda (una línea)
        CalculadoraPromedio lambda = array -> Arrays.stream(array).average().orElse(0);

        System.out.println("Promedio (anónima): " + anonima.calcular(numeros));  // 30.0
        System.out.println("Promedio (lambda): " + lambda.calcular(numeros));    // 30.0
    }
}
```

---

## VARIANTE 2 — Número que más se repite (anónima + lambda)

```java
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class VarianteRepetido {
    public static void main(String[] args) {

        int[] numeros = {1, 2, 3, 2, 3, 3, 4, 1, 2, 3};

        // Con lambda y streams
        Map<Integer, Long> conteo = new HashMap<>();
        Arrays.stream(numeros).forEach(n ->
            conteo.put(n, conteo.getOrDefault(n, 0L) + 1)
        );

        // Encontrar el que más se repite
        int masRepetido = conteo.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(-1);

        System.out.println("Número más repetido: " + masRepetido); // 3
        System.out.println("Frecuencias: " + conteo);
    }
}
```

---

## VARIANTE 3 — Mayor de tres números (anónima + lambda)

```java
public class VarianteMayor3 {

    interface TresNumeros {
        int mayor(int a, int b, int c);
    }

    public static void main(String[] args) {

        // Con clase anónima
        TresNumeros anonima = new TresNumeros() {
            @Override
            public int mayor(int a, int b, int c) {
                return Math.max(Math.max(a, b), c);
            }
        };

        // Con lambda
        TresNumeros lambda = (a, b, c) -> Math.max(Math.max(a, b), c);

        System.out.println("Mayor (anónima): " + anonima.mayor(10, 25, 15)); // 25
        System.out.println("Mayor (lambda): " + lambda.mayor(100, 50, 75));  // 100
    }
}
```

---

## VARIANTE 4 — Multiplicar String por número

```java
public class VarianteMultiplicarString {

    interface MultiplicarString {
        String multiplicar(String texto, int veces);
    }

    public static void main(String[] args) {

        // Con clase anónima
        MultiplicarString anonima = new MultiplicarString() {
            @Override
            public String multiplicar(String texto, int veces) {
                StringBuilder resultado = new StringBuilder();
                for (int i = 0; i < veces; i++) {
                    resultado.append(texto);
                }
                return resultado.toString();
            }
        };

        // Con lambda (usando repeat() de Java 11+)
        MultiplicarString lambda = (texto, veces) -> texto.repeat(veces);

        System.out.println(anonima.multiplicar("Hola ", 3)); // Hola Hola Hola
        System.out.println(lambda.multiplicar("Java! ", 4)); // Java! Java! Java! Java!
    }
}
```

---

## VARIANTE 5 — Factorial (anónima + lambda)

```java
import java.util.stream.LongStream;

public class VarianteFactorial {

    interface Factorial {
        long calcular(int n);
    }

    public static void main(String[] args) {

        // Con clase anónima
        Factorial anonima = new Factorial() {
            @Override
            public long calcular(int n) {
                if (n == 0) return 1;
                // LongStream.rangeClosed(1, n) genera los números del 1 al n
                // reduce(1, (x,y) -> x*y) los va multiplicando todos
                return LongStream.rangeClosed(1, n).reduce(1, (x, y) -> x * y);
            }
        };

        // Con lambda
        Factorial lambda = n -> n == 0 ? 1 : LongStream.rangeClosed(1, n).reduce(1, (x,y) -> x*y);

        System.out.println("5! = " + anonima.calcular(5));  // 120
        System.out.println("7! = " + lambda.calcular(7));   // 5040
        System.out.println("0! = " + lambda.calcular(0));   // 1
    }
}
```

---

## VARIANTE 6 — Verificar si es número primo con lambda

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VariantePrimo {

    interface VerificadorPrimo {
        boolean esPrimo(int n);
    }

    public static void main(String[] args) {

        // Lambda para verificar si un número es primo
        // Un número es primo si solo es divisible por 1 y por él mismo
        VerificadorPrimo esPrimo = n -> {
            if (n < 2) return false;  // 0 y 1 no son primos
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false; // Si tiene divisor, no es primo
            }
            return true;
        };

        // Probamos algunos números
        System.out.println("¿7 es primo? " + esPrimo.esPrimo(7));   // true
        System.out.println("¿9 es primo? " + esPrimo.esPrimo(9));   // false
        System.out.println("¿11 es primo? " + esPrimo.esPrimo(11)); // true

        // Filtrar primos de una lista con stream
        List<Integer> numeros = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13);
        List<Integer> primos = numeros.stream()
                .filter(n -> esPrimo.esPrimo(n))
                .collect(Collectors.toList());
        System.out.println("Primos: " + primos); // [2, 3, 5, 7, 11, 13]
    }
}
```

---

# 📝 RESUMEN ULTRA-RÁPIDO PARA EL EXAMEN

## Sintaxis Lambda:
```
// Sin parámetros:
() -> System.out.println("Hola")

// Un parámetro (sin paréntesis):
n -> n * 2

// Varios parámetros:
(a, b) -> a + b

// Cuerpo con varias líneas (necesita llaves y return):
(a, b) -> {
    int resultado = a + b;
    return resultado;
}
```

## Clase Anónima:
```java
NombreInterfaz variable = new NombreInterfaz() {
    @Override
    public TipoRetorno metodo(params) {
        // implementación
        return valor;
    }
};
```

## Streams paso a paso:
```java
lista.stream()          // 1. Convertir a stream
     .filter(condición) // 2. Filtrar (opcional)
     .map(función)      // 3. Transformar (opcional)
     .sorted()          // 4. Ordenar (opcional)
     .collect(Collectors.toList())  // 5. Recoger resultado
```

## Colecciones — cuándo usar cada una:
- **ArrayList** → Lista normal, acceso por índice, permite duplicados
- **LinkedList** → Muchas inserciones/borrados en el medio
- **HashSet** → No quiero duplicados, no me importa el orden
- **TreeSet** → No quiero duplicados Y quiero orden automático
- **HashMap** → Pares clave-valor, búsqueda rápida
- **TreeMap** → Como HashMap pero con claves ordenadas
- **LinkedHashMap** → Como HashMap pero mantiene el orden de inserción
- **Queue/LinkedList** → Cola FIFO (primero en entrar, primero en salir)
- **Stack** → Pila LIFO (último en entrar, primero en salir)
- **PriorityQueue** → Cola donde el menor tiene prioridad

---

*¡Mucho ánimo en el examen! 💪 Si te sabes bien los streams y la diferencia entre clase anónima y lambda, tienes la mitad ganada.*
