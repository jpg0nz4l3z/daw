package org.example.ejercicios_viejos.ejercicios;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.DoublePredicate;
import java.util.stream.DoubleStream;

public class Bloque4 {
    static void main() {

        Scanner scanner = new Scanner(System.in);
        // ejercicio1(scanner);
        //ejercicio2(scanner);
        //ejercicio3(scanner);
        //ejercicio4(scanner);
        //ejercicio5(scanner);
        //ejercicio6(scanner);
        ejercicio10(scanner);
    }

    //1. Realizar un programa que dibuje, con un símbolo dado por teclado,
    // un rectángulo con una base y una altura dadas tambíén por teclado.
    public static void rectangulo(Scanner sc) {
        System.out.println("Introduce un tamaño de base");
        int base = sc.nextInt();
        System.out.println("Introduce un tamaño de altura");
        int altura = sc.nextInt();
        System.out.println("Introduce un símbolo");
        sc.nextLine();
        String simbolo = sc.nextLine();
      /*
      for(int i = 0;i<altura;i++){
         for(int j = 0; j<base;j++){
	         System.out.print(simbolo.charAt(0));
	     }
	     System.out.println();
      }*/
        //Con un solo for:
        for (int i = 1; i <= altura * base; i++) {
            System.out.print(simbolo.charAt(0) + " ");
            if (i % base == 0) System.out.println();
        }
    }

    //2. Programa que pida dos fechas por teclado y que nos dé la
    //diferencia en días. Formato: "dd-mm-yyyy"
    //@SuppressWarnings("empty-statement")
    public static void difFechas(Scanner sc) {
        System.out.println("Deme la primera fecha: ");
        String fecha1 = sc.nextLine();
        System.out.println("Deme la segunda fecha: ");
        String fecha2 = sc.nextLine();
        //CON DATE.
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date fechaDate1 = formatter.parse(fecha1);
            Date fechaDate2 = formatter.parse(fecha2);
            Long diferencia = fechaDate2.getTime() - fechaDate1.getTime();//lo da en milisegundos
            Long diferenciaDias = diferencia / (1000 * 60 * 60 * 24); //para pasarlo a días.
            System.out.println("La diferencia entre " + fechaDate1 + " y " + fechaDate2 + " es: " + diferenciaDias + " días.");
        } catch (Exception e) {
            System.out.println("Formato inválido");
        }


        //CON STRING.
        //Primero pasamos los meses y años a días para restar luego las dos fechas passada a días.
        //Tendremos que hacer cast a los string.
        int fechaDias1 = pasarDias(fecha1);
        int fechaDias2 = pasarDias(fecha2);
        System.out.println("La diferencia entre " + fecha1 + " y " + fecha2 + " es: " + (fechaDias2 - fechaDias1) + " días.");
    }

    //dd-MM-yyyy
    public static int pasarDias(String fecha) {
        int dias = Integer.parseInt(fecha.substring(0, 2));
        System.out.println(dias);
        int meses = Integer.parseInt(fecha.substring(3, 5));
        int anios = Integer.parseInt(fecha.substring(6));

        int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int diasAnios = 0;
        //si es bisiesto.
        if ((anios % 4 == 0 && anios % 100 != 0) || anios % 400 == 0) diasMes[1] = 29;

        int diasTotalMes = 0; //días del año actual hasta inicio del mes de la fecha
        for (int i = 0; i < meses; i++) diasTotalMes += diasMes[i];

        //todos los días de los años anteriores al actual desde 01-01-0000
        for (int i = 0; i < anios; i++)
            if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) diasAnios += 366;
            else diasAnios += 365;

        //suma dias del mes de fecha más días del año actual más días
        // desde 01-01-0000 hasta inicio del año actual
        return dias + diasTotalMes + diasAnios;
    }

    //3. Programa que pida un número del 0 al 99 por teclado
    //y que devuelva el número en palabras.
    //@SuppressWarnings("empty-statement")
    public static void numLetras(Scanner sc) {
        System.out.println("Introduce un número del 0 al 99: ");
        int num = sc.nextInt();
        String[] numprim = {"cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete",
                "ocho", "nueve", "diez", "once", "doce", "trece", "catorce", "quince"};
        String[] numdec = {"diez", "veinte", "treinta", "cuarenta", "cincuenta",
                "sesenta", "setenta", "ochenta", "noventa"};
        if (num <= 15) System.out.println(numprim[num]);
        else if (num % 10 == 0) System.out.println(numdec[num / 10 - 1]);
        else if (num / 10 == 1) System.out.println("dieci" + numprim[num % 10]);
        else if (num / 10 == 2) System.out.println("venti" + numprim[num % 10]);
        else System.out.println(numdec[num / 10 - 1] + " y " + numprim[num % 10]);
    }

    //4. Hacer un programa que dados diez números por teclado separados por
    // guiones, indique si están ordenados de forma creciente, decreciente o desordenados.
    //--- con Math.max(iNumero1, iNumero2));
    public static void diezNumeros(Scanner sc) {
        System.out.println("Deme una cadena de diez números separados por guiones: ");
        Integer[] valor = new Integer[10];
        Integer[] valorOrd = new Integer[10];
        sc.nextLine();
        String cadnum = sc.nextLine();
        String[] numeros = cadnum.split("-"); //guardamos los números en un array de string.
        for (int i = 0; i < numeros.length; i++) {
            valor[i] = Integer.parseInt(numeros[i]);//pasamos los string a integer.
            valorOrd[i] = Integer.parseInt(numeros[i]);
        }
        Arrays.sort(valorOrd);
        if (Arrays.equals(valor, valorOrd)) {
            System.out.println("La cadena de números está ordenada de forma ascendente");
            return;
        }

        Arrays.sort(valorOrd, Collections.reverseOrder()); //sólo con wrappers
        if (Arrays.equals(valor, valorOrd)) {
            System.out.println("La cadena de números está ordenada de forma descendente");
        }

        //De la manera tradicional:
        for (int i = 0; i < valor.length; i++)
            if (valor[i] != valorOrd[valor.length - i - 1]) break;
            else if (i == valor.length - 1) {
                System.out.println("La cadena de números está ordenada de forma descendente");
                return;
            }
        System.out.println("La cadena de números no está ordenada.");
    }

    public static void diezNumerosBool(Scanner sc) {
        System.out.println("Deme una cadena de diez números separados por guiones: ");
        boolean invers = true;
        boolean direct = true;
        //int [] valor = new int[10];
        sc.nextLine();
        String cadnum = sc.nextLine();
        String[] numeros = cadnum.split("-");
        int aux = Integer.parseInt(numeros[0]);
        for (int i = 1; i < numeros.length; i++) {
            if (Integer.parseInt(numeros[i]) >= aux)
                invers = false;//mientras que el número siga siendo mayor al anterior, direct seguirá true.
            else if (Integer.parseInt(numeros[i]) <= aux)
                direct = false; //mientras siga siendo menor, invers también seguirá siendo true.
            aux = Integer.parseInt(numeros[i]);
        }
        if (direct)
            System.out.println("La cadena de números está ordenada de forma ascendente");
        else if (invers)
            System.out.println("La cadena de números está ordenada de forma descendente");
        else
            System.out.println("La cadena de números no está ordenada.");
    }

    //5. Programa que pida 10 números por pantalla(enteros) y que muestre al usuario
    // la media de los números positivos, la media de los números negativos y
    // la cantidad de ceros introducidos.
    public static void mediayceros(Scanner sc) {
        System.out.println("Deme diez números por pantalla");
        int numeros, positivos, contpositiv, negativos, contnegat, contceros;
        positivos = contpositiv = negativos = contnegat = contceros = 0;
        for (int i = 0; i < 10; i++) {
            numeros = sc.nextInt();
            if (numeros > 0) {
                positivos += numeros;
                contpositiv++;
            } else if (numeros < 0) {
                negativos += numeros;
                contnegat++;
            } else contceros++;
        }
        System.out.println("Media de positivos= " + (double) positivos / contpositiv);
        System.out.println("Media de negativos= " + (double) negativos / contnegat);
        System.out.println("Número de ceros= " + contceros);
    }

    public enum Operacion {MEDIA, CONTEO};

    //Con metodo stream() de Colecciones, por eso hay que usar arraylist.
    public static void mediaycerosArrays(Scanner sc) {
        System.out.println("Deme diez números por pantalla");
        List<Double> numeros = new ArrayList<>();
        for (int i = 0; i < 10; i++) numeros.add(sc.nextDouble());
        calcularEst("Media de positivos: ", i -> i > 0, numeros, Operacion.MEDIA);
        calcularEst("Media de negativos: ", i -> i < 0, numeros, Operacion.MEDIA);
        calcularEst("Número de ceros: ", i -> i == 0, numeros, Operacion.CONTEO);
    }

    public static void calcularEst(String cad, DoublePredicate valor, List<Double> numeros, Operacion op) {
        DoubleStream total = numeros.stream().mapToDouble(i -> (double) i).filter(valor);
        if (op == Operacion.MEDIA)
            System.out.println(cad + total.average().orElse(0.0));
        if (op == Operacion.CONTEO)
            System.out.println(cad + total.count());
    }

    //6.crear un programa que lea 10 números por pantalla y después pida el número
    //de posiciones que queremos mover los números.
    //imprimir los números colocados con el nuevo orden.
    public static void posicion(Scanner sc) {
        int[] posiciones = new int[10];
        System.out.println("Escriba diez números por pantalla");
        for (int i = 0; i < posiciones.length; i++) posiciones[i] = sc.nextInt();

        System.out.println("Dígame las posiciones que quiere desplazar los números");
        int numero = sc.nextInt();
        numero %= posiciones.length;//para controlar que el número dado no sea mayor
        // al número de elementos del array.
        System.out.println("Indique si quiere modificar posiciones de forma ascendente --> asc " +
                "o descendente --> desc");
        String dir = sc.nextLine();
        for (int i = 0; i < posiciones.length; i++) {
            System.out.print(posiciones[i] + " --> ");
            if (dir.equals("asc"))
                System.out.println(posiciones[(i + numero) % posiciones.length]);
            else if (dir.equals("desc"))
                System.out.println(posiciones[(i - numero + posiciones.length) % posiciones.length]);
        }
    }

    //7. Crear un array bidimensional de tamañno 5x5 y rellénalo de la
    //siguiente forma: la posición T[n,m] debe contener n+m.
    //después se debe mostrar su contenido mostrándolo en forma de tabla.
    public static void array5x5() {
        int[][] numeros = new int[5][5];
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++) numeros[i][j] = i + j;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++)
                System.out.print(i + " + " + j + " = " + numeros[i][j] + "\t");
            System.out.println();
        }
    }

    //8. Dejar que el usuario incluya caracteres en un array bidimensional para que el programa
    //decida si es simétrico o no. Es decir, quedaría igual si cambiamos filas por columnas.
    //Para que una matriz sea simétrica, debe tener el mismo número de filas que de columnas.
    public static void arraysimet(Scanner sc) {
        System.out.println("Diga el número de filas o columnas del array bidimensional");
        int m = sc.nextInt();
        sc.nextLine();
        char[][] numeros = new char[m][m];
        System.out.println("Introduzca, uno a uno, los " + (m * m) + " valores del array bidimensional");
        for (int i = 0; i < m; i++)
            for (int j = 0; j < m; j++)
                numeros[i][j] = sc.nextLine().charAt(0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++)
                if (numeros[i][j] != numeros[j][i]) {
                    System.out.println("La matriz no es simétrica");
                    return;
                }
            System.out.println("");
        }
        System.out.println("La matriz es simétrica ");
    }

    //9. Programa que vaya mostrando en líneas separadas lo siguiente:
    //Z.....A
    //Y....A
    //...
    //BA
    //A
    public static void escletinv() {
        for (char b = 'Z'; b >= 'A'; b--) {
            for (char a = b; a >= 'A'; a--) System.out.print(a);
            System.out.println();
        }
    }


    public static void convertirDecimal(int decimal, int base) {
        int residuo = 0;
        StringBuilder valorConvertido = new StringBuilder();

        HashMap<Integer, Character> map = new HashMap<>();
        map.put(10, 'A');
        map.put(11, 'B');
        map.put(12, 'C');
        map.put(13, 'D');
        map.put(14, 'E');
        map.put(15, 'F');

        while (decimal >= base) {


            residuo = decimal % base;
            decimal /= base;

            if (base == 16 && residuo >= 10 && residuo <= 15) {
                valorConvertido.append(map.get(residuo));

            } else {
                valorConvertido.append(residuo);
            }
        }

        if (base == 16 && decimal >= 10 && decimal <= 15) {
            valorConvertido.append(map.get(decimal));
        } else {
            valorConvertido.append(decimal);
        }

        System.out.print("El valor resultante de la conversion es: ");
        for (int i = valorConvertido.length() - 1; i >= 0; i--) {
            System.out.print(valorConvertido.charAt(i));
        }

    }

    public static void ConvertirDesdeOtraBase(String numero, int base) {
        int sumador = 0;
        numero = numero.toUpperCase();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 10);
        map.put('B', 11);
        map.put('C', 12);
        map.put('D', 13);
        map.put('E', 14);
        map.put('F', 15);

        for (int i = 0; i <= numero.length() - 1; i++) {
            if (numero.charAt(i) >= 'A' && numero.charAt(i) <= 'F') {
                sumador += (int) (map.get(numero.charAt(i)) * Math.pow(base, (numero.length() - 1) - i));
            } else {
                sumador += (int) (Integer.parseInt(String.valueOf(numero.charAt(i))) * Math.pow(base, (numero.length() - 1) - i));
            }

        }
        System.out.print("El valor resultante de la conversion es: ");
        System.out.print(sumador);
    }

    public static void ejercicio10(Scanner scanner) {

        System.out.println("1. De decimal a otro sistema de numeración");
        System.out.println("2. Desde otro sistema de numeración a decimal");

        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("1. Binario\n2. Octal\n3. Hexadecimal");
                opcion = scanner.nextInt();
                System.out.println("Por favor introduce el valor a convertir");
                int decimal = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        convertirDecimal(decimal, 2);
                        break;
                    case 2:
                        convertirDecimal(decimal, 8);
                        break;
                    case 3:
                        convertirDecimal(decimal, 16);
                        break;
                }
                break;
            case 2:
                System.out.println("1. Binario\n2. Octal\n3. Hexadecimal");
                opcion = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Por favor introduce el valor a convertir");
                String numero = scanner.nextLine();
                switch (opcion) {
                    case 1:
                        ConvertirDesdeOtraBase(numero, 2);
                        break;
                    case 2:
                        ConvertirDesdeOtraBase(numero, 8);
                        break;
                    case 3:
                        ConvertirDesdeOtraBase(numero, 16);
                        break;
                }
                break;
        }

        System.out.println("\nGracias por usar el programa");
    }
}
