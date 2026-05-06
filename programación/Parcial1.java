import java.util.Arrays;
import java.util.Scanner;

public class Parcial1 {

    public void numOrd(Scanner sc){
        int [] numeros = new int [5];
        int mayor, menor, suma=0;
        System.out.println("Dame cinco números: ");
        for (int i =  0; i < numeros.length; i++){
            numeros[i] = sc.nextInt();
            suma += numeros[i];
        }
        System.out.println("Números originales: " +  Arrays.toString(numeros));
        //ordenar de menor a mayor:
        Arrays.sort(numeros);
        System.out.println(Arrays.toString(numeros));

        //ordenar de mayor a menor, a mitad de ejecución vamos a asignar valores cambiados a valores nuevos
        // porque hemos sobreescrito los que aún necesitamos leer.:
        int [] numerosInv =  new int [numeros.length];
        for (int i = 0; i < numeros.length; i++){
            numerosInv[i] = numeros[numeros.length-i-1];
        }
        System.out.println(Arrays.toString(numerosInv));

        menor = numeros[0];
        mayor = numeros[numeros.length-1];
        System.out.println("Mayor: " + mayor);
        System.out.println("Menor: " + menor);
        System.out.println("Media: " + (double)suma/numeros.length);
    }

    //Dice que el programa devuelve las conversiones con la unidad.
    //Por eso necesitamos incluirlas en un Array de String.
    public String [] temperatura(Scanner sc, int grados){
        int cent, far, kel;
        String [] temperaturas = new String[2];
        cent=far=kel=0;
        sc.nextLine(); //grados viene directamente de un nextInt() y no consume el salto de línea.
        System.out.println("Deme la unidad que quiere comvertir: ");
        char unidad = sc.nextLine().toUpperCase().charAt(0); //lo pasamos a mayúsculas.
        System.out.println("Grados introducidos: " +  grados + unidad);
        switch (unidad){
            case 'C': cent = grados;
                      kel = cent + 273;
                      far = (int) (1.8 * cent + 32);
                      temperaturas[0] = kel + "K";
                      temperaturas[1] = far + "F"; break;
            case 'K': kel = grados;
                      cent = kel - 273;
                      far =  (int) (1.8 * cent + 32);
                      temperaturas[0] = cent + "ºC";
                      temperaturas[1] = far + "F"; break;
            case 'F': far = grados;
                      cent = (int) ((far - 32)/1.8);
                      kel = cent + 273;
                      temperaturas[0]=cent+"ºC";
                      temperaturas[1]=kel+"K"; break;
            default: System.out.println("Esta unidad no es válida.");
        }

        return temperaturas;
    }

    //Debemos respetar mayúsculas y minúsculas, por eso hacemos dos abecedarios.
    public void cesar(Scanner sc){
        int posicion, posicionfinal;
        System.out.println("Deme una frase: ");
        String frase = sc.nextLine();
        System.out.println("CLAVE: ");
        int clave = sc.nextInt();
        sc.nextLine();
        char c;
        String minusculas = "abcdefghijklmnñopqrstuvwxyz";
        String mayusculas = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < frase.length(); i++){
            c = frase.charAt(i);
            if(Character.isLowerCase(c)){
                posicion = minusculas.indexOf(c);
                //sin indexOf():
                //for(int j = 0; j < minusculas.length(); j++)
                //   if (frase.charAt(i)==minusculas.charAt(j)){
                //       posicion = j;
                //       break; }
                //Si el carácter no está en el string, indexOf() devuelve -1.
                if (posicion == -1) {
                    sb.append(c);
                    continue;
                }
                //Para evitar que rebose la posicion final, hacemos el módulo.
                posicionfinal = (posicion + clave) % minusculas.length();
                sb.append(minusculas.charAt(posicionfinal));
            }
            else if(Character.isUpperCase(c)) {
                posicion = mayusculas.indexOf(c);
                if (posicion == -1) {
                    sb.append(c);
                    continue;
                }
                posicionfinal = (posicion + clave) % mayusculas.length();
                sb.append(mayusculas.charAt(posicionfinal));
            }
            else sb.append(c);

        }
        System.out.println("La frase encriptada es: " + sb.toString());
    }

    public void fuertes(Scanner sc){
        System.out.println("Dame la contraseña: ");
        String pasword = sc.nextLine().toLowerCase(); //lo pasamos todo a minúsculas para que el switch también coja las mayúsculas.
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < pasword.length(); i++){
            switch (pasword.charAt(i)){
                case 'a': sb.append(4); break;
                case 'e': sb.append(3); break;
                case 'i': sb.append(1); break;
                case 'o': sb.append(0); break;
                case 'u': sb.append(9); break;
                default: sb.append(pasword.toUpperCase().charAt(i));
            }
        }
        sb.append(pasword.length());
        System.out.println("La password es: " + sb.toString());
    }

    public void explicacion(){
        System.out.println("Resumen paso a paso:\n" +
                "\n" +
                "intentos = 3. Bucle etiquetado bucle_externo con while(true).\n" +
                "\n" +
                "Dentro, for (i = 1..3) pide entrada por Scanner.\n" +
                "\n" +
                "Si entrada.equalsIgnoreCase(\"SALIR\") → return; Sale del método de forma inmediata. No imprime “Fin”.\n" +
                "\n" +
                "Si la cadena está vacía tras trim() → imprime “Vacía” y continue; Pasa a la siguiente iteración del for. Cuenta como intento consumido porque i avanza.\n" +
                "\n" +
                "Si entrada.equals(CLAVE) con coincidencia exacta en mayúsculas/minúsculas → imprime “OK” y break bucle_externo; Rompe el while(true) completo. Continúa tras el while e imprime “Fin”.\n" +
                "\n" +
                "Si no es correcta y no es el último intento → imprime “Mal. Quedan X” donde X = intentos - i.\n" +
                "\n" +
                "Si i == intentos tras un fallo → imprime “Bloqueado” y break bucle_externo; Sale del while y luego imprime “Fin”.\n" +
                "\n" +
                "Papel de cada instrucción de control:\n" +
                "\n" +
                "continue; salta al siguiente ciclo del for actual. No vuelve a pedir en el mismo ciclo. Consume intento.\n" +
                "\n" +
                "break bucle_externo; rompe el bucle etiquetado while(true), no solo el for. Luego se ejecuta System.out.println(\"Fin\");.\n" +
                "\n" +
                "return; termina el método acceso en el acto. No imprime “Fin” ni nada más en este método.\n" +
                "\n" +
                "Qué ocurre en cada caso:\n" +
                "\n" +
                "Entrada vacía: se imprime “Vacía”, se consume ese intento, continúa pidiendo hasta agotar 3 o acertar. Al agotar con vacíos o fallos terminará con “Bloqueado” + “Fin”.\n" +
                "\n" +
                "Escribir “SALIR”: return; Sale del método. No hay “Fin”.\n" +
                "\n" +
                "Fallar tres veces seguidas: en el tercer fallo se imprime “Bloqueado”, se rompe el while etiquetado, y después se imprime “Fin”.");
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Parcial1 obj = new Parcial1();
        System.out.println("Dame el ejercicio que quieres ejecutar: ");
        int ejercicio = sc.nextInt();
        sc.nextLine();
        switch (ejercicio) {
            case 1: obj.numOrd(sc); break;
            case 2: System.out.println("Deme la temperatura que quiere convertir: ");
            String [] conv = obj.temperatura(sc, sc.nextInt());
            System.out.println("La temperatura convertida es: " + Arrays.toString(conv));break;
            case 3: obj.cesar(sc); break;
            case 4: obj.fuertes(sc); break;
            case 5: obj.explicacion();break;

        }
    }
}
