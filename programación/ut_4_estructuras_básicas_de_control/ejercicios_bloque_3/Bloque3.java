package ejercicios;

import java.util.Scanner;

public class Bloque3 {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //ejercicio28(scanner);
        //ejercicio29(scanner);
        //ejercicio30(scanner);
        //estrellaDeDavid(scanner);
        estrellaDeDavidSoloBordes(scanner);
        //rombos(scanner);
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
                        if ((y == 1 && i != alturaTriangulo) ||( y == 2 * i + 1 && i != alturaTriangulo) || (i == alturaTriangulo && y == 2 * i) ) {
                            //if (!(y == 2 * i + 1 & i == alturaTriangulo)) {
                                System.out.print("* ");
                                //}

                            //}

                        }else{
                            if(!(i == alturaTriangulo && y == 2 * i +1)){
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
                        if (i == alturaTriangulo && y == 2 * i ) {

                                System.out.print("* ");

                        } else {
                            if(!(i == alturaTriangulo && y == 2 * i +1)){
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
