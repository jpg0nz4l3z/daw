# 🎓 EJERCICIOS TRAMPA — Como si fuera el profesor
### "Si entiendes estos, el examen te va a parecer fácil"

---

> 💡 **Cómo está organizado esto:**
> Cada ejercicio tiene:
> - 🎭 **El enunciado trampa** (como lo pondría el profe)
> - 💀 **La trampa oculta** (lo que intenta que falles)
> - ✅ **La solución comentada paso a paso**

---

# BLOQUE 1: TRAMPAS CON LAMBDAS Y CLASES ANÓNIMAS

---

## 🔥 TRAMPA 1 — "La lambda que devuelve una lambda"
### Enunciado:
*"Crea una interfaz funcional `Multiplicador` con un método `multiplicar(int factor)` que devuelva otra interfaz funcional `Operacion` con un método `aplicar(int numero)`. Úsala para crear un multiplicador por 3 y aplícalo a los números del 1 al 5."*

### 💀 La trampa:
Una interfaz que **devuelve otra interfaz**. El profe quiere ver si sabes que una lambda puede devolver otra lambda.

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaQueDevuelveLambda {

    // Interfaz 1: la "operación" que se aplica a un número
    interface Operacion {
        int aplicar(int numero);
    }

    // Interfaz 2: el "multiplicador" que DEVUELVE una Operacion
    // Fíjate: el tipo de retorno ES otra interfaz funcional
    interface Multiplicador {
        Operacion multiplicar(int factor);
    }

    public static void main(String[] args) {

        // La lambda del Multiplicador devuelve otra lambda (Operacion)
        // Multiplicador recibe un factor y devuelve una Operacion
        // La Operacion recibe un número y lo multiplica por ese factor
        Multiplicador mult = factor -> numero -> numero * factor;
        //                   ↑ param de Multiplicador   ↑ param de Operacion

        // Creamos un "multiplicador por 3"
        Operacion porTres = mult.multiplicar(3);
        // Creamos un "multiplicador por 7"
        Operacion porSiete = mult.multiplicar(7);

        // Aplicamos a los números del 1 al 5
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println("=== Multiplicar por 3 ===");
        numeros.stream()
               .map(n -> porTres.aplicar(n))
               .forEach(System.out::println); // 3, 6, 9, 12, 15

        System.out.println("=== Multiplicar por 7 ===");
        numeros.stream()
               .map(n -> porSiete.aplicar(n))
               .forEach(System.out::println); // 7, 14, 21, 28, 35
    }
}
```

---

## 🔥 TRAMPA 2 — "El filtro encadenado con transformación"
### Enunciado:
*"Dada una lista de palabras, obtén las palabras que tienen más de 4 letras, conviértelas a mayúsculas, ordénalas por longitud de MAYOR a MENOR, y si tienen la misma longitud ordénalas alfabéticamente. Muestra también cuántas hay."*

### 💀 La trampa:
Encadenar VARIOS pasos en el stream con un orden muy específico. Si cambias el orden de `.sorted()` rompes todo.

```java
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FiltroEncadenado {
    public static void main(String[] args) {

        List<String> palabras = Arrays.asList(
            "sol", "programacion", "java", "estrella", "mar",
            "colecciones", "rio", "lambda", "interfaz", "pi"
        );

        // PASO 1: filter → solo las de más de 4 letras
        // PASO 2: map    → convertir a mayúsculas
        // PASO 3: sorted → por longitud DESCENDENTE, y si empatan A-Z
        // PASO 4: collect → recoger en lista
        List<String> resultado = palabras.stream()
            .filter(p -> p.length() > 4)               // más de 4 letras
            .map(String::toUpperCase)                   // a mayúsculas
            .sorted(
                Comparator.comparingInt(String::length) // por longitud...
                          .reversed()                   // ...de mayor a menor
                          .thenComparing(Comparator.naturalOrder()) // si empatan, A-Z
            )
            .collect(Collectors.toList());

        System.out.println("Resultado: " + resultado);
        System.out.println("Cantidad: " + resultado.size());

        // OJO: el .reversed() afecta solo a comparingInt, no al thenComparing
        // Por eso el thenComparing usa naturalOrder() y no reversed()
    }
}
```

---

## 🔥 TRAMPA 3 — "La clase anónima dentro de un método que recibe parámetros"
### Enunciado:
*"Crea un método estático `crearSaludo(String idioma)` que devuelva una instancia de la interfaz `Saludo` (con método `saludar(String nombre)`). Según el idioma recibido ('ES', 'EN', 'FR'), la clase anónima saludará en ese idioma. Si el idioma no existe, lanza una excepción."*

### 💀 La trampa:
Una clase anónima dentro de un método, que además usa el **parámetro del método** (`idioma`). El profe quiere ver si sabes que las lambdas/clases anónimas pueden "capturar" variables del contexto.

```java
public class FabricaDeSaludos {

    interface Saludo {
        String saludar(String nombre);
    }

    // El método devuelve una interfaz funcional
    // Dependiendo del idioma, devuelve una implementación diferente
    public static Saludo crearSaludo(String idioma) {

        // switch para elegir el idioma
        switch (idioma.toUpperCase()) {
            case "ES":
                // La clase anónima "captura" el valor de idioma del entorno
                return new Saludo() {
                    @Override
                    public String saludar(String nombre) {
                        return "¡Hola, " + nombre + "! ¿Cómo estás?";
                    }
                };
            case "EN":
                return new Saludo() {
                    @Override
                    public String saludar(String nombre) {
                        return "Hello, " + nombre + "! How are you?";
                    }
                };
            case "FR":
                return new Saludo() {
                    @Override
                    public String saludar(String nombre) {
                        return "Bonjour, " + nombre + "! Comment ça va?";
                    }
                };
            default:
                // Si el idioma no existe, lanzamos una excepción
                throw new IllegalArgumentException("Idioma no soportado: " + idioma);
        }
    }

    // Con lambda es exactamente lo mismo, pero más corto:
    public static Saludo crearSaludoLambda(String idioma) {
        switch (idioma.toUpperCase()) {
            case "ES": return nombre -> "¡Hola, " + nombre + "! ¿Cómo estás?";
            case "EN": return nombre -> "Hello, " + nombre + "! How are you?";
            case "FR": return nombre -> "Bonjour, " + nombre + "! Comment ça va?";
            default:   throw new IllegalArgumentException("Idioma no soportado: " + idioma);
        }
    }

    public static void main(String[] args) {

        Saludo saludoES = crearSaludo("ES");
        Saludo saludoEN = crearSaludoLambda("EN");

        System.out.println(saludoES.saludar("María"));  // ¡Hola, María! ¿Cómo estás?
        System.out.println(saludoEN.saludar("John"));   // Hello, John! How are you?

        // Probamos el error
        try {
            Saludo saludoRaro = crearSaludo("JP");
        } catch (IllegalArgumentException e) {
            System.out.println("Error capturado: " + e.getMessage());
        }
    }
}
```

---

## 🔥 TRAMPA 4 — "Lambda con estado acumulado"
### Enunciado:
*"Dada una lista de transacciones bancarias (pueden ser positivas=ingreso o negativas=gasto), usa streams para: calcular el saldo total, encontrar el mayor ingreso, encontrar el mayor gasto, y listar solo los gastos ordenados de mayor a menor (en valor absoluto)."*

### 💀 La trampa:
Múltiples operaciones sobre el MISMO stream. Un stream solo se puede recorrer una vez. El profe espera que hagas varios streams separados o uses `summaryStatistics`.

```java
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class TransaccionesBancarias {
    public static void main(String[] args) {

        // Positivo = ingreso, Negativo = gasto
        List<Integer> transacciones = Arrays.asList(
            500, -200, 1500, -50, -800, 300, -120, 2000, -600, 100
        );

        // OJO: No puedes hacer todo con UN solo stream
        // Una vez que lo "consumes" (collect, sum, etc.) no puedes reutilizarlo
        // Hay que hacer un stream por cada operación distinta

        // 1. SALDO TOTAL: suma de todos (positivos y negativos)
        int saldoTotal = transacciones.stream()
                .reduce(0, Integer::sum);
        System.out.println("Saldo total: " + saldoTotal + "€");

        // 2. MAYOR INGRESO: el positivo más alto
        int mayorIngreso = transacciones.stream()
                .filter(t -> t > 0)                    // solo positivos
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);                             // si no hay ninguno, 0
        System.out.println("Mayor ingreso: " + mayorIngreso + "€");

        // 3. MAYOR GASTO: el negativo con más valor absoluto
        int mayorGasto = transacciones.stream()
                .filter(t -> t < 0)                    // solo negativos
                .mapToInt(Integer::intValue)
                .min()                                  // min porque son negativos (-800 < -50)
                .orElse(0);
        System.out.println("Mayor gasto: " + mayorGasto + "€");

        // 4. LISTA DE GASTOS ordenados de mayor a menor (en valor absoluto)
        List<Integer> gastos = transacciones.stream()
                .filter(t -> t < 0)                    // solo gastos
                .sorted(Comparator.comparingInt(Math::abs).reversed()) // por valor absoluto descendente
                .collect(Collectors.toList());
        System.out.println("Gastos ordenados: " + gastos); // [-800, -600, -200, -120, -50]

        // BONUS: cuánto se ha gastado en total
        int totalGastado = transacciones.stream()
                .filter(t -> t < 0)
                .reduce(0, Integer::sum);
        System.out.println("Total gastado: " + totalGastado + "€");
    }
}
```

---

## 🔥 TRAMPA 5 — "La interfaz con dos implementaciones distintas en el mismo main"
### Enunciado:
*"Crea una interfaz `Validador<T>` con el método `boolean validar(T elemento)`. Implementa dos validadores con clases anónimas: uno que valide si un String tiene más de 5 caracteres, y otro que valide si un Integer es positivo. Aplícalos a listas distintas con streams."*

### 💀 La trampa:
**Genéricos** (`<T>`) en una interfaz con clases anónimas. El profe quiere ver si sabes escribir la clase anónima especificando el tipo genérico.

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ValidadorGenerico {

    // Interfaz genérica: T puede ser cualquier tipo
    interface Validador<T> {
        boolean validar(T elemento);
    }

    public static void main(String[] args) {

        // Clase anónima para String: válido si tiene más de 5 caracteres
        // Fíjate: hay que especificar <String> al instanciar
        Validador<String> validarString = new Validador<String>() {
            @Override
            public boolean validar(String elemento) {
                return elemento.length() > 5;
            }
        };

        // Clase anónima para Integer: válido si es positivo
        Validador<Integer> validarEntero = new Validador<Integer>() {
            @Override
            public boolean validar(Integer elemento) {
                return elemento > 0;
            }
        };

        // CON LAMBDA (equivalente, mucho más corto):
        Validador<String> validarStringLambda  = s -> s.length() > 5;
        Validador<Integer> validarEnteroLambda = n -> n > 0;

        // Aplicamos a listas
        List<String> palabras = Arrays.asList("sol", "programacion", "java", "colecciones", "rio");
        List<Integer> numeros = Arrays.asList(-5, 3, -1, 7, 0, -8, 12);

        List<String> palabrasValidas = palabras.stream()
                .filter(p -> validarString.validar(p))   // o: .filter(validarString::validar)
                .collect(Collectors.toList());

        List<Integer> numerosValidos = numeros.stream()
                .filter(n -> validarEntero.validar(n))
                .collect(Collectors.toList());

        System.out.println("Palabras con más de 5 letras: " + palabrasValidas);
        System.out.println("Números positivos: " + numerosValidos);
    }
}
```

---

# BLOQUE 2: TRAMPAS CON COLECCIONES

---

## 🔥 TRAMPA 6 — "El HashMap que miente"
### Enunciado:
*"Tienes un inventario de productos (nombre → stock). El usuario quiere comprar una cantidad de un producto. Crea un método `comprar(Map<String,Integer> inventario, String producto, int cantidad)` que: descuente el stock si hay suficiente, lance una excepción si no hay stock suficiente, y elimine el producto del mapa si el stock llega a 0."*

### 💀 La trampa:
Modificar un HashMap mientras lo usas. El profe quiere ver el manejo correcto de casos límite (stock=0, producto inexistente).

```java
import java.util.HashMap;
import java.util.Map;

public class GestionInventario {

    // Excepción personalizada para stock insuficiente
    static class StockInsuficienteException extends Exception {
        public StockInsuficienteException(String mensaje) {
            super(mensaje);
        }
    }

    // Método que gestiona la compra
    public static void comprar(Map<String, Integer> inventario,
                               String producto,
                               int cantidad) throws StockInsuficienteException {

        // TRAMPA 1: ¿Existe el producto?
        if (!inventario.containsKey(producto)) {
            throw new StockInsuficienteException(
                "Producto '" + producto + "' no existe en el inventario"
            );
        }

        int stockActual = inventario.get(producto);

        // TRAMPA 2: ¿Hay suficiente stock?
        if (stockActual < cantidad) {
            throw new StockInsuficienteException(
                "Stock insuficiente para '" + producto +
                "'. Pedido: " + cantidad + ", disponible: " + stockActual
            );
        }

        int nuevoStock = stockActual - cantidad;

        // TRAMPA 3: Si el stock llega a 0, eliminar del mapa
        if (nuevoStock == 0) {
            inventario.remove(producto);      // Lo quitamos del inventario
            System.out.println("'" + producto + "' agotado. Eliminado del inventario.");
        } else {
            inventario.put(producto, nuevoStock); // Actualizamos el stock
            System.out.println("Compra realizada. Stock de '" + producto + "': " + nuevoStock);
        }
    }

    public static void main(String[] args) {

        Map<String, Integer> inventario = new HashMap<>();
        inventario.put("Manzanas", 10);
        inventario.put("Peras", 3);
        inventario.put("Plátanos", 5);

        System.out.println("Inventario inicial: " + inventario);

        try {
            comprar(inventario, "Manzanas", 4); // OK: quedan 6
            comprar(inventario, "Peras", 3);    // OK: llega a 0, se elimina
            comprar(inventario, "Peras", 1);    // ERROR: ya no existe
        } catch (StockInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            comprar(inventario, "Plátanos", 10); // ERROR: solo hay 5
        } catch (StockInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Inventario final: " + inventario);
    }
}
```

---

## 🔥 TRAMPA 7 — "El Set que no es lo que parece"
### Enunciado:
*"Tienes dos listas de alumnos aprobados de dos exámenes parciales. Necesitas saber: quién aprobó AMBOS parciales, quién aprobó SOLO el primero, quién aprobó SOLO el segundo, y quién no aprobó ninguno (dado el listado total de alumnos)."*

### 💀 La trampa:
Teoría de conjuntos con 3 sets. El profe espera que sepas que las operaciones de Set MODIFICAN el conjunto original, por eso hay que hacer COPIAS.

```java
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AlumnosExamen {
    public static void main(String[] args) {

        // Todos los alumnos del curso
        Set<String> todos = new HashSet<>(Arrays.asList(
            "Ana", "Bia", "Carlos", "David", "Elena",
            "Fran", "Gloria", "Héctor", "Irene", "Juan"
        ));

        // Aprobados en el primer parcial
        Set<String> parcial1 = new HashSet<>(Arrays.asList(
            "Ana", "Carlos", "Elena", "Fran", "Irene", "Juan"
        ));

        // Aprobados en el segundo parcial
        Set<String> parcial2 = new HashSet<>(Arrays.asList(
            "Bia", "Carlos", "David", "Elena", "Gloria", "Juan"
        ));

        // ¡¡OJO!! retainAll y removeAll MODIFICAN el set
        // Siempre hay que trabajar con COPIAS para no destruir los originales

        // 1. APROBARON AMBOS: intersección de parcial1 y parcial2
        Set<String> ambos = new HashSet<>(parcial1); // copia de parcial1
        ambos.retainAll(parcial2);                   // deja solo los que están en parcial2
        System.out.println("Aprobaron ambos parciales: " + ambos);
        // {Carlos, Elena, Juan}

        // 2. SOLO EL PRIMERO: en parcial1 pero NO en parcial2
        Set<String> soloPrimero = new HashSet<>(parcial1); // copia
        soloPrimero.removeAll(parcial2);             // quita los que están en parcial2
        System.out.println("Solo aprobaron el 1º: " + soloPrimero);
        // {Ana, Fran, Irene}

        // 3. SOLO EL SEGUNDO: en parcial2 pero NO en parcial1
        Set<String> soloSegundo = new HashSet<>(parcial2); // copia
        soloSegundo.removeAll(parcial1);
        System.out.println("Solo aprobaron el 2º: " + soloSegundo);
        // {Bia, David, Gloria}

        // 4. NO APROBARON NINGUNO: en todos pero ni en parcial1 ni en parcial2
        Set<String> union = new HashSet<>(parcial1); // copia de parcial1
        union.addAll(parcial2);                      // añadimos parcial2 → todos los que aprobaron algo
        Set<String> ningunParcial = new HashSet<>(todos); // copia de todos
        ningunParcial.removeAll(union);              // quitamos los que aprobaron algo
        System.out.println("No aprobaron ninguno: " + ningunParcial);
        // {Héctor}
    }
}
```

---

## 🔥 TRAMPA 8 — "El mapa de mapas"
### Enunciado:
*"Crea un sistema de notas donde la estructura es: asignatura → (alumno → nota). Implementa métodos para añadir notas, calcular la media de una asignatura, y encontrar el alumno con mejor nota global (media de todas sus asignaturas)."*

### 💀 La trampa:
Un `Map<String, Map<String, Double>>`. El profe quiere ver si sabes iterar sobre estructuras anidadas.

```java
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalDouble;

public class SistemaNotas {

    // El mapa principal: asignatura → (alumno → nota)
    private Map<String, Map<String, Double>> notas = new HashMap<>();

    // Añadir una nota
    public void addNota(String asignatura, String alumno, double nota) {
        // Si la asignatura no existe en el mapa, la creamos con un nuevo HashMap vacío
        // computeIfAbsent: "si no existe la clave, crea el valor con esta función"
        notas.computeIfAbsent(asignatura, k -> new HashMap<>())
             .put(alumno, nota);
    }

    // Media de una asignatura
    public double mediaAsignatura(String asignatura) {
        if (!notas.containsKey(asignatura)) return 0;

        // Obtenemos el mapa interno (alumno → nota) y calculamos la media de los valores
        return notas.get(asignatura)
                    .values()                   // todos los valores (las notas)
                    .stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(0);
    }

    // Alumno con mejor nota global (media de todas sus asignaturas)
    public String mejorAlumnoGlobal() {
        // Primero recopilamos todos los alumnos que aparecen en alguna asignatura
        Map<String, Double> sumaNotas = new HashMap<>();
        Map<String, Integer> contadorAsignaturas = new HashMap<>();

        // Recorremos el mapa de mapas
        for (Map.Entry<String, Map<String, Double>> asigEntry : notas.entrySet()) {
            for (Map.Entry<String, Double> alumnoEntry : asigEntry.getValue().entrySet()) {
                String alumno = alumnoEntry.getKey();
                double nota = alumnoEntry.getValue();

                // Acumulamos la suma de notas por alumno
                sumaNotas.put(alumno, sumaNotas.getOrDefault(alumno, 0.0) + nota);
                // Contamos en cuántas asignaturas aparece
                contadorAsignaturas.put(alumno, contadorAsignaturas.getOrDefault(alumno, 0) + 1);
            }
        }

        // Calculamos la media de cada alumno y encontramos el mejor
        String mejorAlumno = null;
        double mejorMedia = -1;

        for (String alumno : sumaNotas.keySet()) {
            double media = sumaNotas.get(alumno) / contadorAsignaturas.get(alumno);
            if (media > mejorMedia) {
                mejorMedia = media;
                mejorAlumno = alumno;
            }
        }

        return mejorAlumno + " (media global: " + String.format("%.2f", mejorMedia) + ")";
    }

    public static void main(String[] args) {

        SistemaNotas sistema = new SistemaNotas();

        // Añadimos notas
        sistema.addNota("Matemáticas", "Ana", 8.5);
        sistema.addNota("Matemáticas", "Luis", 6.0);
        sistema.addNota("Matemáticas", "Sara", 9.0);

        sistema.addNota("Programación", "Ana", 9.5);
        sistema.addNota("Programación", "Luis", 7.5);
        sistema.addNota("Programación", "Sara", 8.0);

        sistema.addNota("Inglés", "Ana", 7.0);
        sistema.addNota("Inglés", "Luis", 8.5);
        sistema.addNota("Inglés", "Sara", 6.5);

        System.out.println("Media Matemáticas: " + sistema.mediaAsignatura("Matemáticas"));
        System.out.println("Media Programación: " + sistema.mediaAsignatura("Programación"));
        System.out.println("Mejor alumno global: " + sistema.mejorAlumnoGlobal());
    }
}
```

---

## 🔥 TRAMPA 9 — "La cola de prioridad personalizada"
### Enunciado:
*"Crea una cola de atención médica. Los pacientes tienen nombre y nivel de urgencia (1=crítico, 2=urgente, 3=normal). La cola debe atender primero al más urgente (menor número). Si dos pacientes tienen la misma urgencia, atiende al que llegó antes."*

### 💀 La trampa:
`PriorityQueue` con un `Comparator` personalizado. El orden natural no sirve, hay que definir el criterio.

```java
import java.util.PriorityQueue;
import java.util.Comparator;

public class ColaMedica {

    // Clase que representa un paciente
    static class Paciente {
        String nombre;
        int urgencia;      // 1=crítico, 2=urgente, 3=normal
        int ordenLlegada;  // para desempatar si tienen la misma urgencia

        public Paciente(String nombre, int urgencia, int ordenLlegada) {
            this.nombre = nombre;
            this.urgencia = urgencia;
            this.ordenLlegada = ordenLlegada;
        }

        @Override
        public String toString() {
            String nivel = urgencia == 1 ? "🔴 CRÍTICO" :
                           urgencia == 2 ? "🟡 URGENTE" : "🟢 NORMAL";
            return nombre + " [" + nivel + "]";
        }
    }

    public static void main(String[] args) {

        // PriorityQueue con comparador personalizado:
        // 1. Primero por urgencia (menor número = más prioritario)
        // 2. Si empatan en urgencia, por orden de llegada (menor = llegó antes)
        PriorityQueue<Paciente> colaMedica = new PriorityQueue<>(
            Comparator.comparingInt((Paciente p) -> p.urgencia)
                      .thenComparingInt(p -> p.ordenLlegada)
        );

        // Añadimos pacientes en "orden de llegada"
        colaMedica.offer(new Paciente("Manolo",   3, 1)); // llegó 1º, normal
        colaMedica.offer(new Paciente("Carmen",   2, 2)); // llegó 2º, urgente
        colaMedica.offer(new Paciente("Roberto",  1, 3)); // llegó 3º, crítico
        colaMedica.offer(new Paciente("Lucía",    2, 4)); // llegó 4º, urgente
        colaMedica.offer(new Paciente("Andrés",   1, 5)); // llegó 5º, crítico
        colaMedica.offer(new Paciente("Patricia", 3, 6)); // llegó 6º, normal

        System.out.println("=== Orden de atención médica ===");
        int turno = 1;
        while (!colaMedica.isEmpty()) {
            Paciente siguiente = colaMedica.poll(); // saca el más prioritario
            System.out.println("Turno " + turno + ": " + siguiente);
            turno++;
        }
        // Roberto (crítico, llegó 3º)
        // Andrés (crítico, llegó 5º)
        // Carmen (urgente, llegó 2º)
        // Lucía (urgente, llegó 4º)
        // Manolo (normal, llegó 1º)
        // Patricia (normal, llegó 6º)
    }
}
```

---

## 🔥 TRAMPA 10 — "El LinkedHashMap para mantener el orden"
### Enunciado:
*"Simula un carrito de la compra. El carrito debe recordar el orden en que se añadieron los productos. Implementa: añadir producto (si ya existe, suma la cantidad), eliminar producto, calcular total, y mostrar en orden de inserción."*

### 💀 La trampa:
Usar `LinkedHashMap` en lugar de `HashMap` para que el orden de inserción se mantenga.

```java
import java.util.LinkedHashMap;
import java.util.Map;

public class CarritoCompra {

    // LinkedHashMap: como HashMap pero MANTIENE el orden de inserción
    private Map<String, Integer> carrito = new LinkedHashMap<>();

    // Mapa de precios (otro HashMap, el orden aquí no importa)
    private Map<String, Double> precios = new LinkedHashMap<>();

    public CarritoCompra() {
        // Definimos los precios disponibles
        precios.put("Manzanas", 1.50);
        precios.put("Leche",    0.90);
        precios.put("Pan",      1.20);
        precios.put("Queso",    3.50);
        precios.put("Yogur",    0.75);
    }

    // Añadir producto: si ya existe, SUMA la cantidad
    public void añadir(String producto, int cantidad) {
        if (!precios.containsKey(producto)) {
            System.out.println("Producto no disponible: " + producto);
            return;
        }
        // getOrDefault: si ya está en el carrito, suma; si no, empieza desde 0
        carrito.put(producto, carrito.getOrDefault(producto, 0) + cantidad);
        System.out.println("Añadido: " + cantidad + "x " + producto);
    }

    // Eliminar producto del carrito
    public void eliminar(String producto) {
        if (carrito.remove(producto) != null) {
            System.out.println("Eliminado: " + producto);
        } else {
            System.out.println(producto + " no estaba en el carrito");
        }
    }

    // Calcular el total
    public double calcularTotal() {
        return carrito.entrySet().stream()
                .mapToDouble(e -> precios.get(e.getKey()) * e.getValue())
                .sum();
    }

    // Mostrar el carrito (en orden de inserción, gracias a LinkedHashMap)
    public void mostrarCarrito() {
        System.out.println("╔═══════════════════════════════╗");
        System.out.println("║         CARRITO DE COMPRA     ║");
        System.out.println("╠═══════════════════════════════╣");
        carrito.forEach((producto, cantidad) -> {
            double subtotal = precios.get(producto) * cantidad;
            System.out.printf("║ %-12s %2dx  %5.2f€  ║%n",
                              producto, cantidad, subtotal);
        });
        System.out.println("╠═══════════════════════════════╣");
        System.out.printf("║ TOTAL:              %7.2f€  ║%n", calcularTotal());
        System.out.println("╚═══════════════════════════════╝");
    }

    public static void main(String[] args) {

        CarritoCompra carrito = new CarritoCompra();

        carrito.añadir("Pan", 2);
        carrito.añadir("Leche", 3);
        carrito.añadir("Queso", 1);
        carrito.añadir("Pan", 1);    // Añadimos más pan (suma: 3 total)
        carrito.añadir("Yogur", 4);
        carrito.añadir("Pepsi", 2);  // No existe, avisa
        carrito.eliminar("Leche");

        carrito.mostrarCarrito();
        // El orden en pantalla será: Pan, Queso, Yogur (el orden en que se añadieron)
        // NUNCA sería aleatorio como con HashMap
    }
}
```

---

# BLOQUE 3: TRAMPAS COMBINADAS (Lambda + Colecciones)

---

## 🔥 TRAMPA 11 — "El stream que agrupa y luego filtra el grupo"
### Enunciado:
*"Dada una lista de empleados con nombre, departamento y salario: agrupa por departamento, calcula la media salarial de cada departamento, y muestra solo los departamentos donde la media supera los 2000€. Ordena el resultado por media salarial descendente."*

### 💀 La trampa:
`groupingBy` + `averagingDouble` + filtrar y ordenar el mapa resultante. El profe espera streams anidados.

```java
import java.util.*;
import java.util.stream.Collectors;

public class AnálisisSalarial {

    static class Empleado {
        String nombre;
        String departamento;
        double salario;

        Empleado(String nombre, String departamento, double salario) {
            this.nombre = nombre;
            this.departamento = departamento;
            this.salario = salario;
        }
    }

    public static void main(String[] args) {

        List<Empleado> empleados = Arrays.asList(
            new Empleado("Ana",     "IT",        3000),
            new Empleado("Luis",    "IT",        2500),
            new Empleado("Sara",    "IT",        1800),
            new Empleado("Marta",   "RRHH",      1500),
            new Empleado("Carlos",  "RRHH",      1700),
            new Empleado("Pedro",   "Ventas",    2200),
            new Empleado("Elena",   "Ventas",    2800),
            new Empleado("David",   "Ventas",    1900),
            new Empleado("Gloria",  "Dirección", 5000),
            new Empleado("Roberto", "Dirección", 4500)
        );

        // PASO 1: Agrupar por departamento y calcular media salarial
        // Collectors.groupingBy + Collectors.averagingDouble
        Map<String, Double> mediaPorDepto = empleados.stream()
            .collect(Collectors.groupingBy(
                e -> e.departamento,                          // clave: departamento
                Collectors.averagingDouble(e -> e.salario)   // valor: media de salarios
            ));

        // PASO 2: Filtrar departamentos con media > 2000 y ordenar descendente
        // Ahora hacemos un stream SOBRE EL MAPA (entrySet)
        mediaPorDepto.entrySet().stream()
            .filter(entry -> entry.getValue() > 2000)        // solo medias > 2000
            .sorted(Map.Entry.<String, Double>comparingByValue().reversed()) // ordenar desc
            .forEach(entry ->
                System.out.printf("%-12s → media: %.2f€%n",
                                  entry.getKey(), entry.getValue())
            );

        // Salida esperada (ordenada de mayor a menor media):
        // Dirección    → media: 4750,00€
        // IT           → media: 2433,33€
        // Ventas       → media: 2300,00€
    }
}
```

---

## 🔥 TRAMPA 12 — "El mapa de frecuencias con streams"
### Enunciado:
*"Dada una frase, cuenta cuántas veces aparece cada palabra (ignorando mayúsculas/minúsculas y signos de puntuación). Muestra las 3 palabras más frecuentes."*

### 💀 La trampa:
Hay que limpiar la cadena (quitar puntuación), dividirla, agrupar y ordenar. Muchos pasos encadenados.

```java
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FrecuenciaPalabras {
    public static void main(String[] args) {

        String frase = "El sol brilla, el mar canta, el sol es hermoso. " +
                       "El mar es azul y el sol calienta el mar.";

        // PASO 1: Limpiar la frase
        // .toLowerCase()         → todo a minúsculas
        // .replaceAll("[^a-záéíóúüñ ]", "") → eliminar todo lo que NO sea letra o espacio
        //   [^...] = "todo lo que NO sea esto"
        String fraseLimpia = frase.toLowerCase()
                                  .replaceAll("[^a-záéíóúüñ ]", "");

        // PASO 2: Dividir en palabras y contar frecuencias
        // .split("\\s+") → divide por uno o más espacios en blanco
        Map<String, Long> frecuencias = Arrays.stream(fraseLimpia.split("\\s+"))
            .collect(Collectors.groupingBy(
                palabra -> palabra,          // clave: la palabra
                Collectors.counting()        // valor: cuántas veces aparece
            ));

        System.out.println("Todas las frecuencias: " + frecuencias);

        // PASO 3: Ordenar por frecuencia descendente y coger las TOP 3
        System.out.println("\n=== TOP 3 palabras más frecuentes ===");
        frecuencias.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .limit(3)               // solo las 3 primeras
            .forEach(e ->
                System.out.println("'" + e.getKey() + "' → " + e.getValue() + " veces")
            );
        // el → 5 veces
        // mar → 3 veces
        // sol → 3 veces
    }
}
```

---

## 🔥 TRAMPA 13 — "La lista que se convierte en árbol genealógico"
### Enunciado:
*"Tienes una lista de personas con nombre y nombre del padre. Construye un mapa donde cada persona mapee a la lista de sus hijos. Luego encuentra quién tiene más hijos."*

### 💀 La trampa:
Invertir la relación padre-hijo. Los datos vienen como `hijo→padre` pero hay que construir `padre→[hijos]`.

```java
import java.util.*;
import java.util.stream.Collectors;

public class ArbolGenealogico {

    static class Persona {
        String nombre;
        String nombrePadre; // null si es raíz (no tiene padre conocido)

        Persona(String nombre, String nombrePadre) {
            this.nombre = nombre;
            this.nombrePadre = nombrePadre;
        }
    }

    public static void main(String[] args) {

        // Los datos vienen como: nombre → padre
        List<Persona> personas = Arrays.asList(
            new Persona("Carlos",  null),       // raíz (sin padre)
            new Persona("Marta",   null),        // raíz
            new Persona("Ana",     "Carlos"),
            new Persona("Luis",    "Carlos"),
            new Persona("Elena",   "Carlos"),
            new Persona("Pedro",   "Marta"),
            new Persona("Sofía",   "Ana"),
            new Persona("Tomás",   "Ana")
        );

        // CONSTRUIR el mapa padre → [lista de hijos]
        // Filtramos los que tienen padre (nombrePadre != null)
        // Agrupamos por el nombre del padre, y el valor es la lista de nombres de hijos
        Map<String, List<String>> hijos = personas.stream()
            .filter(p -> p.nombrePadre != null)         // solo los que tienen padre
            .collect(Collectors.groupingBy(
                p -> p.nombrePadre,                     // agrupar por nombre del padre
                Collectors.mapping(p -> p.nombre, Collectors.toList()) // recoger nombres de hijos
            ));

        System.out.println("Árbol:");
        hijos.forEach((padre, listaHijos) ->
            System.out.println(padre + " → hijos: " + listaHijos)
        );

        // ENCONTRAR quién tiene más hijos
        String padreConMasHijos = hijos.entrySet().stream()
            .max(Comparator.comparingInt(e -> e.getValue().size()))
            .map(Map.Entry::getKey)
            .orElse("Nadie");

        int maxHijos = hijos.get(padreConMasHijos).size();
        System.out.println("\nEl que más hijos tiene: " + padreConMasHijos +
                           " con " + maxHijos + " hijos");
    }
}
```

---

## 🔥 TRAMPA 14 — "La pila como validador de paréntesis"
### Enunciado:
*"Implementa un método que valide si una expresión matemática tiene los paréntesis bien balanceados. Por ejemplo: '((a+b)*c)' es válido, pero '((a+b)' o ')a+b(' no lo son."*

### 💀 La trampa:
Uso clásico de `Stack` para algo que no es "invertir". El profe quiere ver si sabes aplicar la pila a un problema real.

```java
import java.util.Stack;

public class ValidadorParentesis {

    interface Validador {
        boolean validar(String expresion);
    }

    public static void main(String[] args) {

        // Lambda que valida los paréntesis usando una pila
        Validador validarParentesis = expresion -> {

            Stack<Character> pila = new Stack<>();

            for (char c : expresion.toCharArray()) {

                if (c == '(') {
                    // Abre paréntesis: lo metemos en la pila
                    pila.push(c);

                } else if (c == ')') {
                    // Cierra paréntesis: tiene que haber uno abierto esperando
                    if (pila.isEmpty()) {
                        return false; // Cierra sin haber abierto → inválido
                    }
                    pila.pop(); // Emparejamos el cierre con el último apertura
                }
                // Los demás caracteres los ignoramos
            }

            // Al final, la pila debe estar vacía (todos los '(' fueron cerrados)
            return pila.isEmpty();
        };

        // Probamos diferentes expresiones
        String[] expresiones = {
            "((a+b)*c)",     // válido
            "((a+b)",        // inválido: falta cerrar un (
            "a+b)*c",        // inválido: cierra antes de abrir
            "(a*(b+c))",     // válido
            ")((",           // inválido
            "a+b+c"          // válido (sin paréntesis)
        };

        for (String expr : expresiones) {
            System.out.println("'" + expr + "' → " +
                (validarParentesis.validar(expr) ? "✅ VÁLIDO" : "❌ INVÁLIDO"));
        }
    }
}
```

---

## 🔥 TRAMPA 15 — "El super-combo final" *(el más difícil)*
### Enunciado:
*"Dada una lista de pedidos de una tienda online (cada pedido tiene: id, cliente, lista de productos y cantidad de cada uno, y estado: 'PENDIENTE'/'ENVIADO'/'ENTREGADO'). Implementa con streams: el total facturado por cliente, los pedidos pendientes ordenados por número de productos, y el producto más vendido en total."*

### 💀 La trampa:
Streams con objetos que contienen colecciones dentro. Hay que "aplanar" con `flatMap`.

```java
import java.util.*;
import java.util.stream.Collectors;

public class SuperComboFinal {

    // Clase que representa una línea de pedido (producto + cantidad)
    static class LineaPedido {
        String producto;
        int cantidad;
        double precioUnitario;

        LineaPedido(String producto, int cantidad, double precio) {
            this.producto = producto;
            this.cantidad = cantidad;
            this.precioUnitario = precio;
        }
        double subtotal() { return cantidad * precioUnitario; }
    }

    // Clase que representa un pedido completo
    static class Pedido {
        int id;
        String cliente;
        List<LineaPedido> lineas;
        String estado; // PENDIENTE, ENVIADO, ENTREGADO

        Pedido(int id, String cliente, String estado, LineaPedido... lineas) {
            this.id = id;
            this.cliente = cliente;
            this.estado = estado;
            this.lineas = Arrays.asList(lineas);
        }

        double total() {
            return lineas.stream().mapToDouble(LineaPedido::subtotal).sum();
        }
    }

    public static void main(String[] args) {

        List<Pedido> pedidos = Arrays.asList(
            new Pedido(1, "Ana", "ENTREGADO",
                new LineaPedido("Camiseta", 2, 15.0),
                new LineaPedido("Pantalón", 1, 40.0)),

            new Pedido(2, "Luis", "PENDIENTE",
                new LineaPedido("Zapatillas", 1, 80.0),
                new LineaPedido("Calcetines", 3, 5.0),
                new LineaPedido("Camiseta", 1, 15.0)),

            new Pedido(3, "Ana", "ENVIADO",
                new LineaPedido("Chaqueta", 1, 90.0)),

            new Pedido(4, "Marta", "PENDIENTE",
                new LineaPedido("Pantalón", 2, 40.0),
                new LineaPedido("Camiseta", 3, 15.0)),

            new Pedido(5, "Luis", "ENTREGADO",
                new LineaPedido("Zapatillas", 2, 80.0))
        );

        // 1. TOTAL FACTURADO POR CLIENTE
        System.out.println("=== Total por cliente ===");
        pedidos.stream()
            .collect(Collectors.groupingBy(
                p -> p.cliente,
                Collectors.summingDouble(Pedido::total) // suma los totales de cada pedido
            ))
            .entrySet().stream()
            .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
            .forEach(e -> System.out.printf("%-8s → %.2f€%n", e.getKey(), e.getValue()));

        // 2. PEDIDOS PENDIENTES ordenados por número de líneas (de más a menos)
        System.out.println("\n=== Pedidos pendientes (por nº de productos) ===");
        pedidos.stream()
            .filter(p -> p.estado.equals("PENDIENTE"))
            .sorted(Comparator.comparingInt((Pedido p) -> p.lineas.size()).reversed())
            .forEach(p -> System.out.println(
                "Pedido #" + p.id + " [" + p.cliente + "] - " +
                p.lineas.size() + " productos - Total: " + p.total() + "€"
            ));

        // 3. PRODUCTO MÁS VENDIDO (en unidades totales)
        // flatMap: "aplana" la lista de listas
        // Cada pedido tiene una lista de líneas → queremos UNA sola lista con todas las líneas
        System.out.println("\n=== Producto más vendido ===");
        pedidos.stream()
            .flatMap(p -> p.lineas.stream())     // convierte List<List<Línea>> en List<Línea>
            .collect(Collectors.groupingBy(
                l -> l.producto,
                Collectors.summingInt(l -> l.cantidad) // suma las cantidades
            ))
            .entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .ifPresent(e ->
                System.out.println(e.getKey() + " con " + e.getValue() + " unidades vendidas")
            );
    }
}
```

---

# 📋 GUÍA DE TRAMPAS — Lo que el profe busca que falles

| # | La trampa | La solución |
|---|-----------|-------------|
| 1 | Lambda que devuelve lambda | `factor -> numero -> resultado` |
| 2 | Orden incorrecto de pasos en stream | Siempre: filter → map → sorted → collect |
| 3 | Variables capturadas en clase anónima | Son `effectively final` (no se modifican) |
| 4 | Reutilizar un stream | ❌ Imposible. Hay que crear uno nuevo cada vez |
| 5 | Genéricos en interfaces con clases anónimas | Especifica el tipo: `new Validador<String>()` |
| 6 | Modificar HashMap mientras iteras | Usa `remove()` directamente, nunca en un `for-each` sobre el mapa |
| 7 | `retainAll/removeAll` modifica el Set original | Siempre trabaja con **copias**: `new HashSet<>(original)` |
| 8 | Iterar mapa de mapas | `entrySet()` anidado o `computeIfAbsent()` |
| 9 | PriorityQueue sin comparador | Por defecto ordena el menor primero (para mayor, `.reversed()`) |
| 10 | HashMap no mantiene orden | Usa `LinkedHashMap` si el orden de inserción importa |
| 11 | Stream sobre un Map | Usa `.entrySet().stream()` |
| 12 | Limpiar texto antes de procesar | `.toLowerCase().replaceAll("[^a-z ]", "")` |
| 13 | flatMap | Cuando tienes listas dentro de listas → `flatMap(x -> x.stream())` |
| 14 | Stack para algo que no es invertir | La pila es perfecta para balanceo, historial, deshacer |
| 15 | `summingDouble` vs `averagingDouble` | `summingDouble` suma, `averagingDouble` promedia |

---

*🎯 Si resuelves estos 15 sin mirar las soluciones, el examen será pan comido.*
