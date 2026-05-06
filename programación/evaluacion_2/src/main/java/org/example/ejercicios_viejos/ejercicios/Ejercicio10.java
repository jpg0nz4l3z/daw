package org.example.ejercicios_viejos.ejercicios;

import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio10 {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        ejercicio10(scanner);
    }

    public static void convertirDecimal(int decimal, int base) {
        int residuo;
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
        }else{
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
