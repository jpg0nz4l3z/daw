package org.example.gestion_datos_en_memoria.ejercicios_jp.ejercicios_map.tree_map;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class TestForEach {
    static void main() {
        List<Integer> datos = List.of(1, 2, 3, 4, 5);

        //datos.forEach(x -> System.out.println(x));
        //datos.forEach(System.out::println);

        /*List<Integer> resultado = datos.stream().filter(x -> x % 2 == 0)
              .collect(Collectors.toList());

        resultado.forEach(System.out::println);*/

        datos.stream().filter(x -> x % 2 == 0)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        datos.stream().filter(x -> x % 2 == 0)
                .forEach(System.out::println);
    }
}
