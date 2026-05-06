package pooBloque4.ejercicio12;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Password {
    private int longitud;
    private String contrasenia;

    public Password() {
        longitud = 8;
        generarPassword();
    }



    public Password(int longitud) {
        this.longitud = longitud;
        generarPassword();
    }

    private void generarPassword() {
        String[] valores = {
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
                "1", "2", "3", "4", "5", "6", "7", "8", "9"
        };

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < this.longitud; i++) {

                /*int random = ThreadLocalRandom.current().nextInt(0, valores.length - 1);
                password.append(valores[random]);*/

            int random = ThreadLocalRandom.current().nextInt(1, 123);
            password.append((char) random);

        }

        this.contrasenia = password.toString();
    }

    public String getContrasenia() {
        return contrasenia;
    }

    static void main() {
        Password p = new Password(10);
        System.out.printf(p.getContrasenia());


        /*Scanner scan = new Scanner(System.in);

        System.out.println("Tres en raya");
        char[][] board = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = scan.next().charAt(0);
            }
        }

        for (int i = 0; i < 3; i++) {

            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");

            }

            System.out.print("|\n");
        }*/

    }
}
