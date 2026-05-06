package org.example.gestion_datos_en_memoria;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Conversiones {
    static void main() {

        //Arrays
        int[] datos = {1,2,3,4,5};
        int[] nuevo = new int[10];
        System.arraycopy(datos, 0, nuevo, 0, datos.length);

        for(int a : nuevo){
            System.out.println(a);
        }

        //listas, crea una lista inmutable con el list of, no permite add ni remove
        List<String> nombres = List.of("Ana","Luis","Marta");

        //Tamaño fijo, no se puede añadir ni eliminar, pero si modificar
        String[] datos2 = {"Ana", "Luis", "Marta"};
        List<String> lista = Arrays.asList(datos2);
        //lista.add("jeje");
        lista.set(0, "modificado");
        lista.forEach(System.out::println);

        //operaciones en conjunto set
        //unión
        Set<String> a = new HashSet<>(List.of("Ana", "Luis"));
        Set<String> b = new HashSet<>(List.of("Luis", "Marta"));
        a.addAll(b);
        System.out.println(a);

        //intersección
        Set<String> a2 = new HashSet<>(List.of("Ana", "Luis"));
        Set<String> b2 = new HashSet<>(List.of("Luis", "Marta"));
        a2.retainAll(b2);
        System.out.println(a);

        //diferencia
        Set<String> a3 = new HashSet<>(List.of("Ana", "Luis"));
        Set<String> b3 = new HashSet<>(List.of("Luis"));

        //remueve a los que estén en a y en b
        a3.removeAll(b3);
        System.out.println(a);
    }
}
