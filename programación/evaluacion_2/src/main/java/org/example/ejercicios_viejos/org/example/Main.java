package org.example.ejercicios_viejos.org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        estrellaDeDavid();
    }

    public static void trianguloArriba(int alturaTriangulo){

    }

    public static void tringulo(Scanner scanner) {
        int alturaTriangulo =  5;

        for (int i = 0; i <= alturaTriangulo; i++){


            for (int j = 1; j <= (alturaTriangulo-i); j++){

                System.out.print("  ");
            }


            for (int x =1; x <= 2*i+1 ; x++){
                if(x == 1 || x == 2*i+1 || i == alturaTriangulo){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();


        }
    }

    public static void estrellaDeDavid(){
        int alturaTriangulo = 6;

        for (int i = 0, l = alturaTriangulo; i <= alturaTriangulo; i++, l--){


            for (int j = 1; j <= (alturaTriangulo-i); j++){

                System.out.print("  ");
            }

            for (int x =1; x <= 2*i+1 ; x++){
                    if(x == 1 || x == 2*i+1 || i == alturaTriangulo ){
                        System.out.print("* ");
                    }else{
                        System.out.print("  ");
                    }
            }

            System.out.println();
        }

        for (int l = alturaTriangulo; l >= 0; l--){
            for (int w = 1; w <= alturaTriangulo-l; w++){
                System.out.print("  ");
            }

            for (int r =1; r <= 2*l+1 ; r++){
                if(r == 1 || r == 2*l+1 || r == alturaTriangulo ){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

    }
}
