package org.example.ejercicios_viejos.ejercicios;

import java.util.Scanner;

public class Bloque1 {
    //1. Completa el siguiente cuadro con true, false o no evaluá.
    //   AND   First condition  |  Second condition  | Result
    //               0                    0             0
    //               0                    1             0
    //               1                    0             0
    //               1                    1             1
    //    OR
    //               0                    0             0
    //               0                    1             1
    //               1                    0             1
    //               1                    1             1
    //    XOR (OR Strict)
    //               0                    0             0
    //               0                    1             1
    //               1                    0             1
    //               1                    1             0
    //Sólo necesitaremos el AND (&&) y el OR (||) para los condicionales.

//..

    //2. En un programa eclipse crea los siguientes tipos de variables
    //   e imprimelos por pantalla.
    public void variables(){
        //Un número entero de 8 bits. desde -2^7 hasta +2^7-1. Siempre uno de los bits es para el signo.
        byte a = 111;
        System.out.println("Número entero de ocho bits: a="+a);
        //Un número entero de 16 bits. desde -2^15 hasta 2^15-1
        short b = 9999;
        System.out.println("Número entero de dieciséis bits: b="+b);
        //Un número entero de 32 bits. desde -2^31 hasta 2^31-1
        int c = 999999999;
        System.out.println("Número entero de treinta y dos bits: c="+c);
        //Un número entero de 64 bits. desde -2^63 hasta 2^63
        long d = 999999999;
        System.out.println("Número entero de sesenta y cuatro bits: d="+d);
        //Un número decimal de 32 bits.
        float e = 255.345f;
        System.out.println("Número decimal de treinta y dos bits: e="+e);
        //Un número decimal de 64 bits.
        double f = 255.3333455566;
        System.out.println("Número decimal de sesenta y cuatro bits: f="+f);
        //Un carácter.
        char g = 'a';
        System.out.println("Un carácter: "+g);
        //Una variable verdadera/false.
        boolean h=true;
        System.out.println("Un boolean: h="+h);
    }

//--

    //3. haz 3 ejemplos de casting implícito con tipos de datos primitivos distintos.
    // Datos primitivos -> aquellos que pertenecen a tipos simples como enteros, caracters, string...
    // Casting implícito -> aquella conversión de tipos que no necesita ser explicitada.
    //       -Valor pequeño en contenedor grande (conversión ancha.)
    public void convestr(){

        byte a = 1;
        int a1 = a; //un valor que pertenece a tipo byte se incluye como int.

        int b = 9999;
        long b1 = b; //un integer se introduce en un long.

        float f = 2.23f;
        double f1 = f; //un float se incluye como double.

        System.out.println("int a= "+a1+", long b= "+b1+", double f= "+f1);

    }

//--

    //4. Haz 3 ejemplos de casting explícito con tipos de datos primitivos distintos.
    //   Casting explícito -> Cuando es necesario código.
    //        -Valor grande en contenedor pequeño (conversión estrecha.)
    public void convanch(){

        long a = 222323232;
        int a1 = (int) a;

        int b = 2345;
        byte b1 = (byte) b;

        double c = 987862.999999999999999999;
        float c1 = (float) c;
        System.out.println("int a= "+a1+", byte b= "+b1+", float c= "+c1);

    }

//--

    //5. Dados los números enteros a=2, b=4, c=3 y d=0, realiza las siguientes
    //operaciones y muestra el resultado por pantalla. Si alguna da fallo crea
    //un comentario al lado que lo explique.
    public void operaciones(){
        int a=2,b=4,c=3,d=0;
        int op_a = a+b;
        int op_b = b+c;
        int op_c = c+d;
        int op_d = a-b;
        int op_e = b-c;
        int op_f = c-d;
        int op_g = a*b;
        int op_h = b*d;
        int op_i = c*a;
        int op_j = d*a;
        int op_k = a/b;
        int op_l = b/c;
        int op_m = b/a;
        int op_n = d/a;
        System.out.println(  " a + b =" + op_a + "\n b + c =" + op_b +
                "\n c + d =" + op_c + "\n a - b =" + op_d +
                "\n b - c =" + op_e + "\n c - d =" + op_f +
                "\n a x b =" + op_g + "\n b x d =" + op_h +
                "\n c x a =" + op_i + "\n d x a =" + op_j +
                "\n a : b =" + op_k + "\n b : c =" + op_l +
                "\n b : a =" + op_m + "\n d : a =" + op_n);
        try {
            int op_o = b/d;
            System.out.println("b : d =" + op_o);
        }catch(ArithmeticException ae){
            System.err.println("b:d, Error de cálculo: " + ae);
        }
    }

//--

    //6. Crear métodos sin parámetros fuera del main que haga lo mismo
    // que el ejercicio 5 sin devolver nada.
    // --- Lo acabamos de hacer. Tendríamos que hacer un método para cada cálculo.
    //Hago el primero como ejemplo.
    public void sumaab(){
        int a=2, b=4;
        int c = a + b;
        System.out.println("la suma de a y b es: "+ c);
    }

//--

    //7. Crear métodos fuera del main que reciban como parámetros de entrada los
    // números y que hagan lo mismo que lo anterior sin devolver nada.
    // ---  Habría que declarar e inicializar los cuatro enteros de entrada en el main
    //           y entrarlos por parámetros así:
    //           int a = 2, b = 4;
    //           sumaab (a, b);
    //      El método se declararía del siguiente modo:
    //         public void suma_ab (int a, int b) {}
    //Hago el primero como ejemplo.
    public void sumaab(int a, int b){
        int c = a + b;
        System.out.println("la suma de a y b es: "+ c);
    }//se puede observar que hemos sobrecargado el método anterior.
    //   porque se llaman igual y el main lo distinguirá por la diferencia
    //   en la entrada de parámetros.

//--

    //8. Crear métodos fuera del main que reciban como parámetros de entrada los
    //   números y que hagan lo mismo que lo anterior y devuelvan lo necesario para
    // que sea el main el que muestre el resultado.
    //   --- En este caso debemos incluir un return en el método para que
    //        nos devuelva un resultado.
    //Hago el primero como ejemplo.
    public int sumaayb (int a, int b){
        return a + b;
    }//en este caso no nos deja sobrecargar porque tendrían los mismos parámetros.

//--

    //9. Crea una calculadora que pueda hacer las operaciones de +-/* recibiendo
    //   los parámetros del usuario.
    //   También vamos a incluir por parámetros el tipo de operación que queremos hacer.
    public void calculadora (int a, int b, String operacion) {
        int c = 0;
        float d = 0f;
        switch (operacion) {
            case "suma": c = a + b; break;
            case "resta": c = a - b; break;
            case "multiplicacion": c = a * b; break;
            case "division":
                try {
                    d = a / b;
                    System.out.println(operacion + " de " + a + " y " + b + " = " + d);
                } catch (ArithmeticException ae) {
                    System.err.println("Error: " + ae);
                }
                break;
            default: System.err.println("Esta operación no está admitida"); return;
        }
        System.out.println(operacion + " de " + a + " y " + b + " = " + c);
    }

//----

    //Para ejecutar los métodos es necesario invocarlos desde un main.
    public static void main (String [] args){
        //Creo un objeto de la clase Bloque1 y lo instancio.
        //De esta forma n
        Bloque1 b1 = new Bloque1();

        //Incluyo todos los ejercios en un switch para elegir cuál quiero ejecutar
        //Para ello doy la opción de incluir el número del ejercicio por teclado.
        //   con el método Scanner.
        System.out.println("¿Qué ejercicio quiere ejecutar?");
        Scanner sc = new Scanner(System.in);
        int valor = sc.nextInt();
        switch(valor){
            case 2: b1.variables(); break;
            case 3: b1.convestr(); break;
            case 4: b1.convanch(); break;
            case 5: b1.operaciones(); break;
            case 6: b1.sumaab(); break;
            case 7: b1.sumaab(2, 4); break;
            case 8: int c = b1.sumaayb(2, 4);
                System.out.println("la suma de a y b es: "+ c);break;
            case 9: System.out.println("Elija una de estas operaciones: suma, resta, multiplicacion, division");
                String op = sc.next();
                System.out.println("Elija el primer operando");
                int a = sc.nextInt();
                System.out.println("Elija el segundo operando");
                int b = sc.nextInt();
                b1.calculadora(a, b, op); break;
        }
    }
}
