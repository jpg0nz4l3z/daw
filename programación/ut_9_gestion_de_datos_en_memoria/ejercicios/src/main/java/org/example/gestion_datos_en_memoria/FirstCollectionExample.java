package org.example.gestion_datos_en_memoria;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class FirstCollectionExample {
    static void main() {
        //Listas
        List lista1 = new ArrayList();
        lista1.add("Pedro");
        lista1.add(42);
        lista1.add(88);
        lista1.add("Juan");

        for (var element : lista1) {
            System.out.println(element);
        }

        String[] datos = {"Ana", "Pedro"};
        List<String> lista = Arrays.asList(datos);

        List test;
        Collection<String> owo = new ArrayList<String>();

        lista.set(0, "Juan");

        System.out.println("Imprimir array");
        for (var dato : datos) {
            System.out.println(dato);
        }

        System.out.println();

        System.out.println("Imprimir lista");
        for (var dato : lista) {
            System.out.println(dato);
        }

        System.out.println("-----------------------");
        lista.forEach(System.out::println);
        lista.forEach(e -> System.out.println(e + "owo"));


    }
}
