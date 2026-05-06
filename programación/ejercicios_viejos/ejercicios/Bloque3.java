package ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Bloque3 {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //ejercicio28(scanner);
        //ejercicio29(scanner);
        //ejercicio30(scanner);
        //estrellaDeDavid(scanner);
        //estrellaDeDavidSoloBordes(scanner);
        rombos(scanner);
    }

    //1. Crear un programa que pida una palabra por pantalla y
    //le muestre al usuario una debajo de otra las letras que forman esa palabra.
    public static void palabra(Scanner sc) {
        System.out.println("Escriba una palabra: ");
        //escribimos la palabra por teclado.
        String palabra = sc.nextLine();
        //recorremos letra a letra la palabra a través de un for y un subtring
        //se podría hacer también con un charAt().
        for (int i = 0; i < palabra.length(); i++) {
            System.out.println(palabra.substring(i, i + 1));
            //System.out.println(palabra.charAt(i));
        }
    }

    //2. Crea un programa que imprima los números múltiplos de cuatro menores
    //   o iguales a 100.
    public static void multiploscuatro() {
        //recorremos todos los números desde el cero hasta el cien.
        for (int i = 4; i <= 100; i += 4) {
            //con un if escribimos aquellos cuyo módulo con 4 nos dé 0.
            System.out.println(i);
        }
    }

    //3. Crear un programa que indique si una palabra metida por teclado
    //   es un palíndromo.
    public static void palindromo(Scanner sc) {
        System.out.println("Dame una palabra por teclado: ");
        sc.nextLine();
        String a = sc.nextLine();
        //Un palíndromo es una palabra que se lee igual al derecho que al revés
        int cont = 0;
        //recorremos con un for todas las letras de la palabra
        for (int i = 0; i < a.length(); i++) {
            //comparamos cada letra empezando por el principio y por el final
            //y las coincidencias las guardamos en una variable cont.
            if (a.charAt(i) != a.charAt(a.length() - i - 1)) {
                System.out.println("No es un palíndromo");
                return;
            }
        }
        System.out.println("La palabra " + a + " es un palíndromo.");
        //si el número de coincidencias es igual a la longitud de la palabra
        //es que es un palíndromo.
        //if (cont == a.length()) System.out.println(a+" es palíndromo.");
        //else System.out.println(a+" no es palíndromo.");
    }

    //4. Crea un programa que pida una cadena de caracteres y determine el
    // número de mayúsculas y el número de minúsculas.
    public static void mayusminus(Scanner sc) {
        System.out.println("Escriba una cadena de caracteres");
        String a = sc.nextLine();
        int mayusculas = 0;
        int minusculas = 0;
        //String b = a.toUpperCase();
        //Recorremos toda la cadena de caracteres con un for.
        for (int i = 0; i < a.length(); i++) {
            //con el metodo toUpperCase() la pasamos a mayúscula y
            //comparamos con la letra correspondiente del string original.
            //las coincidencias las añadimos a una variable incremental de mayúsculas.
            if (Character.isUpperCase(a.charAt(i))) mayusculas++;
            //hacemos lo mismo pasándola a minúscula y las coincidencias las
            //guardamos en otra variable incremental de minúsculas.
            if (Character.isLowerCase(a.charAt(i))) minusculas++;
        }
        //mostramos por pantalla el número de mayúsculas y de minúsculas de la palabra.
        System.out.println("La palabra " + a + " tiene " + mayusculas + " mayúsculas"
                + " y " + minusculas + " minúsculas.");
    }

    //5. Crea un programa que reciba como datos una cadena de caracteres
    //y un carácter y que reporte el número de veces que se encuentra dicho
    //carácter en la cadena.
    public static void caracter(Scanner sc) {
        System.out.println("Dame una cadena de caracteres; ");
        sc.nextLine();
        String cadena = sc.nextLine();
        System.out.println("Dame un carácter para comparar: ");
        //charAt(0) tomará el primer carácter si se incluyen varios.
        char caract = sc.nextLine().charAt(0);
        int cont = 0;
        //recorremos la cadena de caracteres con un for.
        for (int i = 0; i < cadena.length(); i++) {
            //comparamos uno a uno cada caracter de caracteres con el caracter indicado.
            //cada coincidencia incrementa en uno el valor de una variable cont.
            if (cadena.charAt(i) == caract) cont++;
        }
        //si la variable cont es igual a cero, es que no hay coincidencias.
        //de lo contratrio, se incluye el número de coincidencias almacenado en
        //la variable cont.
        if (cont == 0) System.out.println("El carácter '" + caract +
                "' no aparece en la cadena de caracteres \"" + cadena + "\".");
        else System.out.println("El carácter '" + caract + "' aparece " + cont +
                " veces en la cadena de caracteres \"" + cadena + "\".");
    }

    //6. Crea un programa que reciba una cadena S y una letra X, y coloque
    //  en mayúsculas cada ocurrencia de X en S.
    public static void letramayusc(Scanner sc) {
        //igual que el anterior, incluimos string y caracter de comparación.
        System.out.println("Dame una cadena de caracteres: ");
        String S = sc.nextLine();
        System.out.println("Dame una letra; ");
        //pasamos la letra dada a mayúsculas
        char X = sc.nextLine().charAt(0);
        //en esta ocasión vamos a guardar la cadena de caracteres en un array palabras.
        //de longitud S.length(), la longitud de la palabra.
        //char[] palabras = new char [S.length()];
        //recorremos el string caracter a caracter.
        //Lo podemos hacer también con un string.
        String palabra = "";
        for (int i = 0; i < S.length(); i++) {
            //comparamos el caracter del string en mayúsculas con el incluido por nosotros.
            if (S.charAt(i) == X) {
                //si coinciden, escribimos el caracter del Array correspondiente en mayúsculas.
                //palabras[i]=S.toUpperCase().charAt(i);
                palabra += S.toUpperCase().charAt(i); //concatenamos carácter a carácter.
                //si no coinciden, que siga tal cual está (puede estar tanto en minúscula como en mayúscula de origen)
            } else {
                //palabras[i]=S.charAt(i);
                palabra += S.charAt(i);
            }
        }
        //sobreescribimos el string S con los valores modificados en el array palabras.
        //con el uso de String.valueOf(Array); que pasa a string un array de char().
        //S = String.valueOf(palabras);
        S = palabra;
        //mostramos el string S modificado por pantalla.
        System.out.println(S);
    }

    //7. Cree un programa que partiendo de la String
    //"Estamos en invierno, hasta marzo no termina"
    // declarada e inicializada como variable primitiva,
    // muestre lo siguiente:
    //1. Longitud de la cadena.
    //2. El carácter asociado al número 9.
    //3. La subcadena "hasta" indicándole la posición donde comienza y finaliza.
    //4. El índice que ocupa el cáracter "z".
    //5. Por último, comprobar si el primer carácter de la String es 'E'
    //   y mostrar por consola un mensaje que lo indique.
    public static void invierno() {
        String inviernos = "Estamos en invierno, hasta marzo no termina, hasta entonces nadie te estima";
        //1. mostramos la longitud del string con length()
        System.out.println("1. La longitud de la cadena es " + inviernos.length());
        //2. mostramos el caracter asociado a la posición 9.
        System.out.println("2. El carácter asociado a la posición 9 es '" + inviernos.charAt(9) + "'");

        //3. Vamos a realizar el apartado con dos métodos distintos:
        //metodo 1. A través de un for.
        //recorremos elemento a elemento el string invierno desde la posición 0
        //hasta la posición última menos la longitud de la cadena "hasta".
        for (int i = 0; i < inviernos.length() - "hasta".length(); i++) { //para no salirnos de rango
            //comparamos el substring que va desde la posición actual hasta la longitud de
            //la cadena "hasta", es decir, de cinco en cinco, con la propia cadena "hasta"
            if (inviernos.substring(i, i + "hasta".length()).equals("hasta")) {
                //los coincidencias indicamos la posición inicial y la final (inicial+long de "hasta")
                System.out.println("3. La palabra \"hasta\" se encuentra entre las posiciones " + i
                        + " y " + (i + "hasta".length()));
            }
        }
        //metodo 2. Sin necesidad de un for.
        //el metodo indexOf() indica la posición donde comienza una cadena de caracteres dentro de otra.
        //la final sería la incial más el número de caracteres de "hasta"
        int inicio = inviernos.indexOf("hasta");
        while (inicio >= 0) {
            System.out.println("3. La palabra \"hasta\" se encuentra entre las posiciones " +
                    inicio + " y " +
                    (inicio + "hasta".length()));
            inicio = inviernos.indexOf("hasta", inicio + 1);
        }
        //4. indicamos la posición que ocupa el caracter 'Z' con indexOf()
        String invierno = inviernos.toLowerCase();
        int posicion = invierno.indexOf('Z');
        StringBuilder lugares = new StringBuilder("4. las posiciones asociadas al carácter 'Z' son ");
        while (posicion >= 0) {
            lugares.append(posicion);
            posicion = invierno.indexOf('Z', posicion + 1); //si no quedan devuelve -1.
            if (posicion != -1) lugares.append(", ");
        }
        System.out.println(lugares.append("."));

        //5. comparamos si el primer carácter coincide con 'E'.
        if (invierno.charAt(0) == 'E')
            System.out.println("5. El primer carácter de la cadena es 'E'");
    }

    //8. Crea un array de 7 posiciones de números con valores pedidos por teclado,
    //  Muestra por consola el índice y el valor al que corresponde.
    //  Haz dos métodos, uno para rellenar valores y otro para mostrarlos.
    //-En la programación orientada a objetos se utilizan mucho los métodos de
    //rellenar (set()) y mostrar(get()).
    //rellenar retorna el array relleno que incluimos en mostrar
    //en las llamadas del main no es necesario inicializar un array.
    public static int[] rellenar(Scanner sc) {
        int[] posiciones = new int[7];
        System.out.println("Introduzca valores enteros: ");
        for (int i = 0; i < 7; i++) {
            posiciones[i] = sc.nextInt();
        }
        return posiciones;
    }

    public static void mostrar(int[] posiciones) {
        System.out.println("Los valores introducidos son: ");
        for (int i = 0; i < 7; i++) {
            System.out.println("índice: " + i + ", valor= " + posiciones[i]);
        }
    }

    //9. Crea un array de números donde le indicamos por teclado el tamaño
    //   del array, rellenamos el array con números aleatorios entre 0 y 9,
    //   al final muestra por pantalla el valor de cada posición y la suma de
    //   todos los valores.
    //   Haz um metodo para rellenar el array(que tenga como parámetros
    //   los números entre los que generar), para mostrar el contenido y la suma
    //   del array y un metodo privado para generar número aleatorio (lo puedes usar
    //   para otros ejercicios)
    //-creamos un metodo para generar números aleatorios entre límite inferior y superior.
    private static int aleatorios(int m, int n) {
        //usamos el metodo random() de Math.(por defecto genera un número aleatorio entre 0 y 1)
        //para hacer que lo genere entre dos límites, ambos incluidos,
        //rango = maximo - minimo + 1; con ambos incluidos.
        //si fuera de 15 a 24 el rango sería (24-15+1)=10.
        //la posición inicial nos la da la suma del valor inicial m, es decir: Math.random()*10 + 15
        //----0--------------15++++++++24--------------
        //como en nuestro ejemplo m es 0 el rango será también (9-0+1)=10,
        //y la posición inicial sería 0, es decir no tendriamos que sumar m.
        //----0++++++++9------
        int rango = n - m + 1;//rango=10. n->maximo, m->minimo, -> Math.random()*10
        return (int) (Math.random() * rango + m);
    }

    //con el metodo arrayteclado, rellenamos el array con números aleatorios
    //del rango incluido por parámetros, en el ejemplo dice de 0 a 9,
    //en el main incluiríamos el 0 y el 9 como parámetros de entrada.
    //sacaremos el array relleno como return.
    public static int[] arrayteclado(Scanner sc, int m, int n) {
        //introducimos por teclado el número de elementos del array.
        System.out.println("Dame el número de elementos del array: ");
        int[] arrayint = new int[sc.nextInt()]; //el array se crea aquí.
        //con un for recorremos todas las posiciones del array para rellenarlas
        //con números aleatorios llamando en cada posición al metodo creado anteriormente.
        for (int i = 0; i < arrayint.length; i++) {
            arrayint[i] = aleatorios(m, n);
        }
        return arrayint; //lo sacamos como resultado
    }

    //con el metodo arraymostrar mostramos el valor de cada posición y la suma de todos los valores
    //del array que hemos rellenado en el metodo anterior.
    public static void arraymostrar(int[] arrayint) { //lo entramos al siguiente metodo.
        int suma = 0;
        for (int i = 0; i < arrayint.length; i++) {
            System.out.println(arrayint[i]); //mostramos sus valores.
            suma += arrayint[i];//sumammos elemento a elemento todos los números del array.
        }
        //Otra forma sin necesidad de realizar sumas sucesivas en el for.
        //suma = Arrays.stream(arrayint).sum();
        System.out.println("La suma de todos los valores del array es: " + suma);
    }

    //10. Crea un array de números de un tamaño pasado por teclado,
    //el array contendrá números aleatorios entre los números deseados,
    //por último nos indicará cuál es el mayor de todos ellos y la media.
    //--la generación del array de números lo hacemos con el metodo arrayteclado()
    //del apartado anterior, bastería con incluirlo en el main.
    public static void arraynum(int[] arraydos) {
        int suma, mayor;
        //iniciamos la suma y el mayor como el primer valor del array.
        suma = mayor = arraydos[0];
        System.out.println(arraydos[0]);
        for (int i = 1; i < arraydos.length; i++) {
            System.out.println(arraydos[i]); //mostramos sus valores.
            //sumamos uno a uno todos los valores del array arraydos[]
            //para posteriormente hallar la media.
            suma += arraydos[i];
            //si el valor del array es mayor que la variable mayor, sustituimos el valor de mayor por el del array.
            //de esta forma vamos incluyendo el valor mayor en la variable elemento a elemento.
            if (arraydos[i] > mayor) mayor = arraydos[i];
        }

        //al salir del for, la variable mayor tendrá el mayor valor del array.
        System.out.println("El mayor de valores del array es: " + mayor +
                ", que comparamos con otra forma de hallarlo: "
                + Arrays.stream(arraydos).max().getAsInt());
        //hallamos la media dividiendo la suma de todos los valores del array
        //entre el número de elementos del mismo.
        System.out.println("La media del conjunto de valores del array es: " +
                (double) (suma / arraydos.length) +
                ", que también comparamos con otra forma de hallarlo: "
                + Arrays.stream(arraydos).average().getAsDouble());
    }

    //11. Crea un array de números de 65 posiciones que contenga
    //los números del 1 al 65. Obtén la suma de todos ellos y la media.
    //--no tiene nada nuevo, respecto al ejercicio anterior.
    public static void arraypost() {
        int[] sesentaycinco = new int[65];
        int suma = 0;
        for (int i = 0; i < 65; i++) {
            sesentaycinco[i] = i + 1;
            suma += i + 1;
        }
        float media = (float) suma / sesentaycinco.length;
        System.out.println("suma = " + suma);
        System.out.println("media = " + media + " o también "
                + Arrays.stream(sesentaycinco).average().getAsDouble());
    }

    //12. Crea un array de caracteres que contenga de la 'A' a la 'Z'
    //(solo las mayúsculas). Después, ve pidiendo posiciones del array
    //por teclado y si la posición es correcta, se añadirá a una cadena
    //que se mostrará al final, se dejará de insertar cuando se introduzca un -1.
    //----Este ejercicio se ha hecho con un arrayList para incluir el valor del índice
    //que introducimos por teclado, pero podría realizarse de forma más sencilla,
    //concatenando el nuevo valor a un string, del siguiente modo:
    //caracteres = caracteres + letras[s];
    //El uso del arrayList es símplemente para explicar su funcionamiento.
    public static void arraylista(Scanner sc) {
        char[] letras = new char[26];
        int cont = 0, posc;
        //rellenamos el array de caracteres directamente con un for de char.
        for (char x = 'A'; x <= 'Z'; x++, cont++) letras[cont] = x;
        //inicializamos una variable de enteros para incluir las posiciones
        //usamos un arrayList() que es un array dinámico, varía el número de
        //valores sin necesidad de incluir un límite.
        ArrayList<Character> caracteres = new ArrayList<>();
        //StringBuilder cadena = new StringBuilder("");
        //mientras que no escribamos -1, seguirá incluyendo elementos en el arrayList
        do {
            System.out.println("Deme la posición de la letra que quiera escribir");
            posc = sc.nextInt();
            //controlamos que la posición de letras[] esté entre 0 y 26
            //si está dentro, incluimos en la posición siguiente del arrayList
            //el valor de palabras[] correspondiente a la posición incluida por teclado.
            if (posc >= 0 && posc < letras.length) {
                caracteres.add(letras[posc]);
                //cadena.append(letras[posc]);
            } else if (posc != -1) System.out.println("Error, inserte otro número");
        } while (posc != -1);
        //recorremos el arrayList y mostramos sus valores en el orden de inclusión.
        //for(int i = 0; i < caracteres.size(); i++)
        System.out.println(caracteres);//.get(i));
    }

    //13. Pida al usuario por teclado una frase y pase sus caracteres a un array.
    //---no tiene dificultad, usamos un charAt(i) para obtener el valor del índice i.
    // Lo podemos hacer en una sola sentencia:  char [] letras = frase.toCharArray();
    public static void arrayfrase(Scanner sc) {
        System.out.println("Inserte la frase por teclado, por favor");
        sc.nextLine();
        String frase = sc.nextLine();
        //creamos un array de char de longitud igual a la de la frase incluida por teclado
        char[] letras = new char[frase.length()];
        letras = frase.toCharArray();
        //añadimos cada caracter en la posición correspondiente del array.
        for (int i = 0; i < frase.length(); i++) letras[i] = frase.charAt(i);
        /* Si lo hacemos con array de String para usar Split():
        String [] frasearray = new String [frase.length()];
        frasearray = frase.split("");
        //con split() dividimos el String en
        //un array de subString. No es lo que nos piden.
        //Esto sí es lo que nos piden:
        char [] frasechar =  frase.toCharArray();
        System.out.println(Arrays.toString(frasechar));
        */
    }

    //14. Calcula la letra del DNI, pediremos el DNI por teclado y nos devolverá
    //el DNI completo (el número introducido y la letra que hemos calculado que
    // le corresponde). Para calcular la letra, cogeremos el resto de dividir
    // nuestro DNI entre 23, el resultado debe estar entre 0 y 22.
    public static void DNI(Scanner sc) {
        System.out.println("Denos el número de su DNI sin la letra");
        int DNI = sc.nextInt();
        char[] caracteres = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N',
                'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        int resto = DNI % 23;
        char letra = caracteres[resto];
        System.out.println("El DNI completo es: " + DNI + letra);
    }

//15. Crea una aplicación que pida un número por teclado y que compruebe después
    //si el número introducido es capicúa utilizando arrays.

    //Sin array bastaría con dar la vuelta al número y comparar los dos:
    //long aux=numero, resto, inverso = 0;
    //while(aux!=0){
    //   resto = aux%10;
    //   aux = aux/10;
    //   inverso = inverso*10 + resto;
    // }
    //if(numero==inverso)System.out.println("El número " + numero + " es capicúa.");

    //---para poder incluir los dígitos del número incluido a un array en posiciones sucesivas,
    //pasamos a string intermedio el número long y después incluimos los dígitos al array.
    //este último paso no sería necesario si no se nos indicara que utilicemos arrays.
    //con el string podríamos comprobar si es un palindromo de números (equivalente al capicua)
    public static void capicua(Scanner sc) {
        System.out.println("Deme un número largo por teclado");
        //introducimos un número Long por teclado
        long numero = sc.nextLong();
        /*   Si lo hacemos con array de enteros, debemos usar arraylist puesto qoe no sabemos el número de dígitos
             ArrayList<Integer> numeros = new ArrayList<>();
             while (numero != 0){
                 numeros.add((int)numero%10);
                 numero /= 10;
             }
             for (int i = 0; i < numeros.size(); i++){
                 if(numeros.get(i) != numeros.get(numeros.size()-i-1)){
                     System.out.println("El número no es capicúa");
                     return;
                 }
             }

             También podemos averiguar el número de dígitos del long de la siguiente manera:
                int digitos = (numero == 0) ? 1 : (int)Math.log10(Math.abs(numero)) + 1;
             En este caso no necesitamos un arraylist
                int [] numeros = new int[digitos];
        */
        String numStr = Long.toString(numero);
        //creamos el array de enteros con la longitud del string.
        char[] numcapi = numStr.toCharArray();
        //rellenamos el array con los números del string pasados a int.
        for (int i = 0; i < numcapi.length; i++)
            numcapi[i] = numStr.charAt(i); //casting implícito.
        int cont = 0;
        //recorremos el array y comparamos empezando por el principio y por el final,
        //posición a posición.
        //cada coincidencia hace incrementar en 1 el valor de la variable cont.
        for (int i = 0; i < numcapi.length; i++)
            if (numcapi[i] == numcapi[numcapi.length - i - 1]) cont++;
        //si al final del recorrido, el número de elementos del array es igual al valor
        //de la variable, es que han coincidido todas la posiciones y, por tanto,
        //el número es capicua.
        if (cont == numcapi.length) System.out.println("El número " +
                numero + " es capicúa.");
    }

    //Otra forma de realizar el ejercicio 15.
    public static void capicua2(Scanner sc) {
        System.out.println("Deme un número largo por teclado");
        //introducimos un número Long por teclado
        long numero = sc.nextLong();
        //int cont = 0;
        //Si lo hacemos con array, lo mejor es convertir el número a String y tratarlo como un palíndromo.
        //lo pasamos a string, hacemos un cast a string con Long.toString(numero)
        String numStr = Long.toString(numero);
        //convertimos el string a un array de caracteres (char[])
        char[] valores = numStr.toCharArray();
        System.out.println(Arrays.toString(valores));

        for (int i = 0; i < valores.length; i++)
            //Si coinciden las posiciones contrapuestas
            if (valores[i] != valores[valores.length - i - 1]) {
                System.out.println("El número no es capicúa.");
                return;
            }
        System.out.println("El número " + numero + " es capicúa");
    }

    //16. Dado un array de números de 6 posiciones con los siguientes valores
    //  {1,2,3,4,5,6}, guardar los valores de este array en otro array distinto
    // pero con los valores invertidos. Es decir, que el segundo array deberá tener
    // los valores {6,5,4,3,2,1}
    public static void arrayinvertido() {
        Integer[] arrayderch = {1, 2, 3, 4, 5, 6};
        Integer[] arrayinvert = new Integer[arrayderch.length];
        //Integer [] arrayinvertInt = new Integer[arrayderch.length];
        System.out.println("El array invertido tiene estos valores: ");
        //es el mismo sistema que el ejercicio anterior.
        for (int i = 0; i < arrayderch.length; i++)
            arrayinvert[i] = arrayderch[arrayderch.length - i - 1];
        System.out.println(Arrays.toString(arrayinvert));
        //arrayinvert = Arrays.copyOf(arrayderch, 6);
        //Arrays.sort(arrayinvert, Collections.reverseOrder());
    }

//17. Rellena un array bidimensional de 10x10 con los números del 1 al 100
    //en orden invertido y recorre la matriz mostrando los valores con su posición.
    /*  (i,j)
        0,0  0,1  0,2  ...  0,7  0,8  0,9
        1,0  1,1  1,2  ...  1,7  1,8  1,9
        .                               .
        .                               .
        .                               .
        9,0 ...                   ... 9,9
    */
    //usamos dos for encadenamos, el primero para las filas, el segundo para las columnas.
    //usamos una variable contador decreciente, para incluir los valores a las posiciones.

    //con un contador descendente
    public static void arraybidm() {
        int[][] matriz = new int[10][10];
        int fil = matriz.length; //así calculamos el número de filas.
        int col = matriz[0].length; //así calculamos el número de columnas.
        int cont = 100;
        //Rellenamos el array con números del 100 al 1.
        for (int i = 0; i < fil; i++) //las filas
            for (int j = 0; j < col; j++, cont--) //las columnas.
                matriz[i][j] = cont;
        //Recorremos la matriz
        for (int i = 0; i < fil; i++) {
            for (int j = 0; j < col; j++)
                if (matriz[i][j] >= 10) System.out.print(matriz[i][j] + " ");
                else System.out.print(matriz[i][j] + "  ");
            System.out.println();
        }
    }

    //con las posiciones invertidas de filas (decenas) y columnas (unidades).
    public static void arraybidm1() {
        int[][] matriz = new int[10][10];
        int fil = matriz.length; //así calculamos el número de filas.
        int col = matriz[0].length; //así calculamos el número de columnas.
        //Rellenamos el array con números del 100 al 1.
        for (int i = 0; i < fil; i++) //las filas
            for (int j = 0; j < col; j++) //las columnas.
                //E incluimos los valores al derecho.
                matriz[i][j] = (fil - i - 1) * 10 + (col - j - 1) + 1;
        //(9-i)*10 + 10-j -> 100 - (10*i + j)
        //Recorremos la matriz
        for (int i = 0; i < fil; i++) {
            for (int j = 0; j < col; j++)
                if (i != fil - 1) System.out.print(matriz[i][j] + " ");
                else System.out.print(matriz[i][j] + "  ");
            System.out.println();
        }
    }

    //18. Crea un programa que imprima la tabla de multiplicar de un número
    //introducido por pantalla.
    public static void tablamult(Scanner sc) {
        System.out.println("Introduzca el número de la tabla a rellenar: ");
        int num = sc.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + "x" + i + " = " + (num * i));
        }
    }

    //19. Crea un programa que calcule el cubo de un número introducido por pantalla.
    //---usamos Math.pow(número,potencia);
    public static void cubo(Scanner sc) {
        System.out.println("Introduzca un número por pantalla: ");
        int num = sc.nextInt();
        System.out.println("El cubo de " + num + " es " + (int) Math.pow(num, 3));
    }

    //20. Crea un programa que lea por teclado una palabra y la imprima
    //a la inversa hasta que el usuario introduzca la palabra "fin".
    public static void palabrareves(Scanner sc) {
        System.out.println("Introduzca una palabra por teclado");
        String palabra = "";
        //mientras la palabra introducida no sea "fin", que siga haciendo el bucle while()
        do {
            palabra = sc.nextLine();
            //en esta ocasión usamos un for descendente. primera posición -> límite superior,
            //última posición -> límite inferior, i-- -> hace que itere de forma descendente uno a uno.
            for (int i = palabra.length() - 1; i >= 0; i--)
                System.out.print(palabra.charAt(i));
            System.out.println("Introduzca otra palabra: ");
        } while (!palabra.equals("fin"));
    }

    //21. Crea un programa que dibuje una escalera de asteriscos.
    //Nosotros le pasamos la altura de la escalera por teclado.
    //---usaremos dos for encadenados, el exterior para las filas, el interior para las columnas.
    public static void escalera(Scanner sc) {
        System.out.println("Indique el número de peldaños de la escalera: ");
        int peldaños = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < peldaños; i++) {
            //para dibujar los asteriscos de forma creciente, incrementamos el límite superior de
            //asteriscos a incluir por fila hasta el número de la fila en cuestión (i)
            for (int j = 0; j <= i; j++)
                System.out.print("*"); // en misma línea
            System.out.println("");//salto de línea
        }
    }

    //22. Crea un programa que dibuje una escalera descendente de números.
    // Nosotros le pasamos la altura de la escalera por teclado.
    //--igual que con los asteriscos, pero incluyendo el número de la fila en su posición.
    public static void escaleraNum(Scanner sc) {
        System.out.println("Deme el número de pisos de la escalera: ");
        int pisos = sc.nextInt();
        sc.nextLine();
        //usamos un for descendente para empezar a escribir el número de fila mayor y
        //terminar por el menor (exclusivamente por esa razón)
        for (int i = pisos; i > 0; i--) { //filas -> peldaños.
            for (int j = 0; j < i; j++) { //columnas
                System.out.print(i + " ");
                //para que guarde la forma le añadimos otro espacio
                if (i < 10) System.out.print(" ");
            }
            System.out.println("");
        }
    }

    //23. Crea un programa que dibuje una escalera de números, siendo cada
    //línea números empezando en uno y acabando en el número de la línea.
    //--en este caso escribimos la posición que ocupa la columna(j) dentro de la fila
    public static void escaleraNum2(Scanner sc) {
        System.out.println("Deme el número de pisos de la escalera: ");
        int pisos = sc.nextInt();
        for (int i = 1; i <= pisos; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print(j + " ");
            System.out.println("");
        }
    }

    //24. Crea un programa que dibuje una pirámide de asteriscos. Nosotros
    //le pasamos la altura de la pirámide por teclado.
    //---como ahora nos piden una pirámide, no una escalera, tenemos que añadir
    //en cada fila un número de espacios en blanco para dibujar la forma correcta.
    public static void piramideAst(Scanner sc) {
        System.out.println("Deme el número de pisos de la pirámide: ");
        int pisos = sc.nextInt();
        for (int i = 1; i <= pisos; i++) {
            for (int j = 1; j <= pisos - i; j++) System.out.print(" "); //Uno menos al piso en que se encuentre.
            for (int k = 1; k < i * 2; k++) System.out.print("*");//El doble menos uno a la iteración.
            System.out.println(" ");
        }
    }

    //25. Crea un programa que dibuje una pirámide invertida de asteriscos.
    //Nosotros le pasamos la altura de la pirámide por teclado.
    //---igual que el anterior pero la pirámide se dibuja invertida
    //comenzamos con el valor máximo del piso y terminamos con el mínimo.
    public static void piramideAstInv(Scanner sc) {
        System.out.println("Deme el número de pisos de la pirámide: ");
        int pisos = sc.nextInt();
        for (int i = pisos; i >= 1; i--) { //invirtiendo el for de filas. La fila equivale al piso.
            for (int j = 1; j <= pisos - i; j++)
                System.out.print(" ");
            for (int k = 1; k < i * 2; k++)
                System.out.print("*");
            System.out.println("");
        }

        for (int i = 0; i < pisos; i++) { //con un for ascendente -> la fila es la inversa al piso.
            for (int j = 0; j < i; j++)
                System.out.print(" "); //Uno menos a la fila actual empezando por arriba
            for (int k = 0; k < 2 * (pisos - i) - 1; k++)
                System.out.print("*"); //el doble menos uno del piso en que se encuentre.
            System.out.println("");
        }
    }

    //26. Crea un programa que dibuje una pirámide invertida de números donde
    //el número de cada fila suponga multiplicar la fila por la columna.
    //---el número de posiciones dentro de cada fila, corresponde con
    //el número de la fila en cuestión. Luego no hay que hacer el doble de nada.
    public static void piramideNumInv(Scanner sc) {
        System.out.println("Deme el número de pisos de la pirámide: ");
        int pisos = sc.nextInt();
        for (int i = pisos; i > 0; i--) {
            for (int m = 1; m <= pisos - i; m++) System.out.print("  ");
            for (int j = 1; j <= i; j++) System.out.print(i * j + "  ");
            System.out.println("");
        }
        for (int i = 0; i < pisos; i++) { //con un for ascendente -> la fila es la inversa al piso.
            for (int j = 0; j < i; j++)
                System.out.print("  "); //Uno menos a la fila actual empezando por arriba
            for (int k = 0; k < pisos - i; k++)
                System.out.print((pisos - i) * (k + 1) + "  "); //el doble del piso en que se encuentre.
            System.out.println("");
        }
    }

    //27. Crea un programa que dibuje una pirámide de números de la siguiente manera.
    public static void piramideCeryUn(Scanner sc) {
        System.out.println("Deme el número de pisos de la pirámide: ");
        int pisos = sc.nextInt();
        for (int i = 1; i <= pisos; i++) {
            //for (int m = 1; m <= pisos-i; m++) System.out.print(" ");
            for (int j = 1; j <= i; j++) {
                if (j % 2 == 0) System.out.print("0 ");//en posic pares -> 1
                else System.out.print("1 ");//en impares -> 0
            }
            System.out.println("");
        }
    }

    public static void ejercicio28(Scanner scanner) {
        System.out.println("Por favor escribe la altura del rombo ej. 13");
        int alturaRombo = scanner.nextInt();
        int alturaTriangulo = alturaRombo - 7;

        for (int i = 0; i <= alturaTriangulo; i++) {
            for (int j = 1; j <= (alturaTriangulo - i); j++) {
                System.out.print("  ");
            }

            for (int x = 1; x <= 2 * i + 1; x++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        for (int i = alturaTriangulo - 1; i >= 0; i--) {
            for (int j = 1; j <= alturaTriangulo - i; j++) {
                System.out.print("  ");
            }
            for (int x = 1; x <= 2 * i + 1; x++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    public static void ejercicio29(Scanner scanner) {
        System.out.println("Por favor escribe el tamaño de la diagonal ej. 5");
        int tamanioDiagonal = scanner.nextInt();
        int alturaTriangulo = tamanioDiagonal - 1;

        for (int i = 0; i <= alturaTriangulo; i++) {
            if (i <= 2) {
                System.out.print("  ");
            } else if (i == 3) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (alturaTriangulo - i); j++) {

                System.out.print(" ");
            }

            for (int x = 1; x <= i + 1; x++) {

                System.out.print((i + 1) * x + " ");

            }
            System.out.println();
        }


        for (int i = alturaTriangulo - 1; i >= 0; i--) {

            if (i <= 2) {
                System.out.print("  ");
            } else if (i == 3) {
                System.out.print(" ");
            }
            for (int j = 1; j <= alturaTriangulo - i; j++) {
                System.out.print(" ");
            }

            for (int x = 1; x <= i + 1; x++) {
                System.out.print((i + 1) * x + " ");
            }
            System.out.println();
        }


    }

    public static void ejercicio30(Scanner scanner) {

        /*
        1 = 1*1
        2 = 2*1
        3 = 3*2*1
        4 = 4*3*2*1
        5 = 5*4*3*2*1
        */

        for (int i = 1; i <= 7; i++) {
            int producto = 1;
            for (int y = i; y >= 1; y--) {
                producto *= y;
            }
            System.out.println(producto);
        }
    }

    public static void estrellaDeDavid(Scanner scanner) {
        System.out.println("Por favor escribe la altura del triángulo. ej 8");
        int alturaTriangulo = scanner.nextInt() - 1;

        //1 parte
        for (int i = 0; i <= alturaTriangulo; i++) {
            for (int j = 1; j <= (alturaTriangulo - i); j++) {
                System.out.print("  ");
            }

            for (int x = 1; x <= 2 * i + 1; x++) {

                if (i == alturaTriangulo) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }

                //segundo triangulo
                if (x == 2 * i + 1) {
                    for (int j = 2; j <= (alturaTriangulo - i) * 2; j++) {
                        System.out.print("  ");
                    }

                    for (int y = 1; y <= 2 * i + 1; y++) {
                        if (y == 1 || y == 2 * i + 1 || i == alturaTriangulo) {
                            if (!(y == 2 * i + 1 & i == alturaTriangulo)) {
                                System.out.print("* ");
                            }

                        } else {
                            System.out.print("  ");
                        }

                        //tercer triangulo

                        if (y == 2 * i + 1) {

                            for (int j = 2; j <= (alturaTriangulo - i) * 2; j++) {
                                System.out.print("  ");
                            }
                            for (int l = 1; l <= 2 * i + 1; l++) {
                                if (i == alturaTriangulo) {
                                    if (!(l == 2 * i + 1 & i == alturaTriangulo)) {
                                        System.out.print("* ");
                                    }
                                } else {
                                    System.out.print("  ");
                                }
                            }
                        }
                        //fin tercer triangulo
                    }
                }
                //final segundo tringulo
            }

            System.out.println();
        }

        //2 parte
        for (int i = alturaTriangulo - 1; i >= 0; i--) {

            for (int j = 1; j <= (alturaTriangulo - i); j++) {
                System.out.print("  ");
            }

            for (int x = 1; x <= 2 * i + 1; x++) {
                if (x == 1 || x == 2 * i + 1) {
                    System.out.print("* ");

                } else {
                    System.out.print("  ");

                }

                //segundo triangulo
                if (x == 2 * i + 1) {
                    for (int j = 2; j <= (alturaTriangulo - i) * 2; j++) {
                        System.out.print("  ");
                    }

                    for (int y = 1; y <= 2 * i + 1; y++) {
                        System.out.print("  ");

                        //tercer triangulo

                        if (y == 2 * i + 1) {

                            for (int j = 2; j <= (alturaTriangulo - i) * 2; j++) {
                                System.out.print("  ");
                            }
                            for (int l = 1; l <= 2 * i + 1; l++) {
                                if (l == 1 || l == 2 * i + 1) {
                                    if (!(l == 2 * i + 1 & i == alturaTriangulo)) {
                                        System.out.print("* ");
                                    }
                                } else {
                                    System.out.print("  ");
                                }
                            }
                        }
                        //fin tercer triangulo
                    }
                }
                //final segundo tringulo

            }
            System.out.println();

        }

        //parte 3
        for (int i = 1; i <= alturaTriangulo; i++) {

            for (int j = 1; j <= (alturaTriangulo - i); j++) {
                System.out.print("  ");
            }

            for (int x = 1; x <= 2 * i + 1; x++) {
                if (x == 1 || x == 2 * i + 1 || i == alturaTriangulo) {
                    System.out.print("* ");

                } else {
                    System.out.print("  ");

                }

                //segundo triangulo
                if (x == 2 * i + 1) {
                    for (int j = 2; j <= (alturaTriangulo - i) * 2; j++) {
                        System.out.print("  ");
                    }

                    for (int y = 1; y <= 2 * i + 1; y++) {
                        if (i == alturaTriangulo) {
                            if (!(y == 2 * i + 1 & i == alturaTriangulo)) {
                                System.out.print("* ");
                            }

                        } else {
                            System.out.print("  ");
                        }

                        //tercer triangulo

                        if (y == 2 * i + 1) {

                            for (int j = 2; j <= (alturaTriangulo - i) * 2; j++) {
                                System.out.print("  ");
                            }
                            for (int l = 1; l <= 2 * i + 1; l++) {
                                if (l == 1 || l == 2 * i + 1 || i == alturaTriangulo) {
                                    if (!(l == 2 * i + 1 & i == alturaTriangulo)) {
                                        System.out.print("* ");
                                    }
                                } else {
                                    System.out.print("  ");
                                }
                            }
                        }
                        //fin tercer triangulo
                    }
                }
                //final segundo tringulo
            }

            System.out.println();

        }

        //parte 4
        for (int i = alturaTriangulo - 1; i >= 0; i--) {

            for (int j = 1; j <= (alturaTriangulo - i); j++) {
                System.out.print("  ");
            }

            for (int x = 1; x <= 2 * i + 1; x++) {

                System.out.print("  ");

                //segundo triangulo
                if (x == 2 * i + 1) {
                    for (int j = 2; j <= (alturaTriangulo - i) * 2; j++) {
                        System.out.print("  ");
                    }

                    for (int y = 1; y <= 2 * i + 1; y++) {
                        if (y == 1 || y == 2 * i + 1) {
                            if (!(y == 2 * i + 1 & i == alturaTriangulo)) {
                                System.out.print("* ");
                            }

                        } else {
                            System.out.print("  ");
                        }

                        //tercer triangulo

                        if (y == 2 * i + 1) {

                            for (int j = 2; j <= (alturaTriangulo - i) * 2; j++) {
                                System.out.print("  ");
                            }
                            for (int l = 1; l <= 2 * i + 1; l++) {

                                System.out.print("  ");

                            }
                        }
                        //fin tercer triangulo
                    }
                }
                //final segundo tringulo
            }

            System.out.println();
        }
    }

    public static void estrellaDeDavidSoloBordes(Scanner scanner) {
        System.out.println("Por favor escribe la altura del triángulo. ej 8");
        int alturaTriangulo = scanner.nextInt() - 1;

        //1 parte
        for (int i = 0; i <= alturaTriangulo; i++) {
            for (int j = 1; j <= (alturaTriangulo - i); j++) {
                System.out.print("  ");
            }

            for (int x = 1; x <= 2 * i + 1; x++) {

                if (i == alturaTriangulo) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }

                //segundo triangulo
                if (x == 2 * i + 1) {
                    for (int j = 2; j <= (alturaTriangulo - i) * 2; j++) {
                        System.out.print("  ");
                    }

                    for (int y = 1; y <= 2 * i + 1; y++) {
                        if ((y == 1 && i != alturaTriangulo) || (y == 2 * i + 1 && i != alturaTriangulo) || (i == alturaTriangulo && y == 2 * i)) {
                            //if (!(y == 2 * i + 1 & i == alturaTriangulo)) {
                            System.out.print("* ");
                            //}

                            //}

                        } else {
                            if (!(i == alturaTriangulo && y == 2 * i + 1)) {
                                System.out.print("  ");
                            }

                        }

                        //tercer triangulo

                        if (y == 2 * i + 1) {

                            for (int j = 2; j <= (alturaTriangulo - i) * 2; j++) {
                                System.out.print("  ");
                            }
                            for (int l = 1; l <= 2 * i + 1; l++) {
                                if (i == alturaTriangulo) {
                                    if (!(l == 2 * i + 1 & i == alturaTriangulo)) {
                                        System.out.print("* ");
                                    }
                                } else {
                                    System.out.print("  ");
                                }
                            }
                        }
                        //fin tercer triangulo
                    }
                }
                //final segundo tringulo
            }

            System.out.println();
        }

        //2 parte
        for (int i = alturaTriangulo - 1; i >= 0; i--) {

            for (int j = 1; j <= (alturaTriangulo - i); j++) {
                System.out.print("  ");
            }

            for (int x = 1; x <= 2 * i + 1; x++) {
                if (x == 1) {
                    System.out.print("* ");

                } else {
                    System.out.print("  ");

                }

                //segundo triangulo
                if (x == 2 * i + 1) {
                    for (int j = 2; j <= (alturaTriangulo - i) * 2; j++) {
                        System.out.print("  ");
                    }

                    for (int y = 1; y <= 2 * i + 1; y++) {
                        System.out.print("  ");

                        //tercer triangulo

                        if (y == 2 * i + 1) {

                            for (int j = 2; j <= (alturaTriangulo - i) * 2; j++) {
                                System.out.print("  ");
                            }
                            for (int l = 1; l <= 2 * i + 1; l++) {
                                if (l == 2 * i + 1) {
                                    if (!(l == 2 * i + 1 & i == alturaTriangulo)) {
                                        System.out.print("* ");
                                    }
                                } else {
                                    System.out.print("  ");
                                }
                            }
                        }
                        //fin tercer triangulo
                    }
                }
                //final segundo tringulo

            }
            System.out.println();

        }

        //parte 3
        for (int i = 1; i <= alturaTriangulo; i++) {

            for (int j = 1; j <= (alturaTriangulo - i); j++) {
                System.out.print("  ");
            }

            for (int x = 1; x <= 2 * i + 1; x++) {
                if (x == 1 || i == alturaTriangulo) {
                    System.out.print("* ");

                } else {
                    System.out.print("  ");

                }

                //segundo triangulo
                if (x == 2 * i + 1) {
                    for (int j = 2; j <= (alturaTriangulo - i) * 2; j++) {
                        System.out.print("  ");
                    }

                    for (int y = 1; y <= 2 * i + 1; y++) {
                        if (i == alturaTriangulo && y == 2 * i) {

                            System.out.print("* ");

                        } else {
                            if (!(i == alturaTriangulo && y == 2 * i + 1)) {
                                System.out.print("  ");
                            }
                        }

                        //tercer triangulo

                        if (y == 2 * i + 1) {

                            for (int j = 2; j <= (alturaTriangulo - i) * 2; j++) {
                                System.out.print("  ");
                            }
                            for (int l = 1; l <= 2 * i + 1; l++) {
                                if (l == 2 * i + 1 || i == alturaTriangulo) {
                                    if (!(l == 2 * i + 1 & i == alturaTriangulo)) {
                                        System.out.print("* ");
                                    }
                                } else {
                                    System.out.print("  ");
                                }
                            }
                        }
                        //fin tercer triangulo
                    }
                }
                //final segundo tringulo
            }

            System.out.println();

        }

        //parte 4
        for (int i = alturaTriangulo - 1; i >= 0; i--) {

            for (int j = 1; j <= (alturaTriangulo - i); j++) {
                System.out.print("  ");
            }

            for (int x = 1; x <= 2 * i + 1; x++) {

                System.out.print("  ");

                //segundo triangulo
                if (x == 2 * i + 1) {
                    for (int j = 2; j <= (alturaTriangulo - i) * 2; j++) {
                        System.out.print("  ");
                    }

                    for (int y = 1; y <= 2 * i + 1; y++) {
                        if (y == 1 || y == 2 * i + 1) {
                            if (!(y == 2 * i + 1 & i == alturaTriangulo)) {
                                System.out.print("* ");
                            }

                        } else {
                            System.out.print("  ");
                        }

                        //tercer triangulo

                        if (y == 2 * i + 1) {

                            for (int j = 2; j <= (alturaTriangulo - i) * 2; j++) {
                                System.out.print("  ");
                            }
                            for (int l = 1; l <= 2 * i + 1; l++) {

                                System.out.print("  ");

                            }
                        }
                        //fin tercer triangulo
                    }
                }
                //final segundo tringulo
            }

            System.out.println();
        }
    }


    public static void rombos(Scanner scanner) {

        System.out.println("Dame la altura del triángulo");
        int alturaTriangulo = scanner.nextInt() - 1;

        for (int i = 0; i <= alturaTriangulo; i++) {
            for (int j = 1; j <= (alturaTriangulo - i); j++) {
                System.out.print("  ");
            }

            for (int x = 1; x <= 2 * i + 1; x++) {

                if (x == 1 || x == 2 * i + 1) {
                    System.out.print("* ");

                } else {
                    System.out.print("  ");
                }

                //segundo triangulo
                if (x == 2 * i + 1) {
                    for (int j = 2; j <= (alturaTriangulo - i) * 2; j++) {
                        System.out.print("  ");
                    }

                    for (int y = 1; y <= 2 * i + 1; y++) {
                        if ((y == 1 || y == 2 * i + 1) && i != alturaTriangulo) {
                            System.out.print("* ");
                        } else {
                            if (i == alturaTriangulo && y == 2 * i) {
                                System.out.print("* ");
                            } else {
                                System.out.print("  ");
                            }

                        }
                    }
                }
                //final segundo triángulo
            }
            System.out.println();
        }

        //2 parte
        for (int i = alturaTriangulo - 1; i >= 0; i--) {

            for (int j = 1; j <= (alturaTriangulo - i); j++) {
                System.out.print("  ");
            }

            for (int x = 1; x <= 2 * i + 1; x++) {
                if (x == 1 || x == 2 * i + 1 /*|| i == alturaTriangulo*/) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }

                //segundo triángulo
                if (x == 2 * i + 1) {
                    for (int j = 2; j <= (alturaTriangulo - i) * 2; j++) {
                        System.out.print("  ");
                    }

                    for (int y = 1; y <= 2 * i + 1; y++) {
                        if (y == 1 || y == 2 * i + 1) {
                            if (!(y == 2 * i + 1 & i == alturaTriangulo)) {
                                System.out.print("* ");
                            }
                        } else {
                            System.out.print("  ");
                        }
                    }
                }
                //final segundo triangulo
            }
            System.out.println();
        }
    }

}
