package org.example.ejercicios_viejos;

import java.util.Scanner;

public class exceptioons {
    public static void main(String[] args){
        jeje();
        System.out.println("Hello world");
    }

    public static void jeje(){
        try{
            Scanner sc = new Scanner(System.in);
            Integer.parseInt(sc.nextLine());
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
