/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.bloque2;

import java.util.Scanner;

/**
 *
 * @author jupgo
 */
public class Bloque2 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Bloque2 bloque2 = new Bloque2();
        
        bloque2.calculaSueldo(scanner);

    }

    /*Enunciado
        Programa que calcule el sueldo que le corresponde a un trabajador de una empresa
        que cobra 40.000 euros anuales, el programa debe realizar los cálculos en función
        de los siguientes criterios:
    
        a) Si lleva más de 10 años en la empresa se le aplica un aumento del 10%. 
        b) Si lleva menos de 10 años pero más que 5 se le aplica un aumento del 7%. 
        c) Si lleva menos de 5 años pero más que 3 se le aplica un aumento del 5%. 
        d) Si lleva menos de 3 años se le aplica un aumento del 3%.
     */
    public void calculaSueldo(Scanner scanner) {

        double salario = 40000;
        System.out.println("Por favor digite la antigúedad del empleado en años");
        int antiguedad = scanner.nextInt();
        double aumento = 0;

        if (antiguedad > 10) {
            aumento = 0.1;
        } else if (antiguedad < 10 && antiguedad > 5) {
            aumento = 0.07;
        } else if (antiguedad < 5 && antiguedad > 3) {
            aumento = 0.05;
        }else if(antiguedad < 3){
            aumento = 0.03;
        }
        
        salario = salario + (salario * aumento);
        System.out.println("El nuevo salario es: " + salario);
    }
}
