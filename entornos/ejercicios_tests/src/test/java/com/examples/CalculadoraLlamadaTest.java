package com.examples;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraLlamadaTest {

    // CASOS VÁLIDOS
    static Stream<Arguments> casosValidos() {
        return Stream.of(
                Arguments.of("CP2 - BASICA sin hora punta",
                        10, "BASICA", false, 2.0),

                Arguments.of("CP3 - BASICA con hora punta",
                        10, "BASICA", true, 2.5),

                Arguments.of("CP4 - PRO sin hora punta",
                        10, "PRO", false, 1.5),

                Arguments.of("CP5 - EMPRESA sin hora punta",
                        10, "EMPRESA", false, 1.0)
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("casosValidos")
    void testCasosValidos(String nombreCaso,
                          int minutos,
                          String tarifa,
                          boolean horaPunta,
                          double esperado) {

        double resultado = CalculadoraLlamada.calcularCoste(minutos, tarifa, horaPunta);

        assertEquals(esperado, resultado, 0.0001);
    }

    // CASOS EXCEPCIONALES
    static Stream<Arguments> casosExcepcionales() {
        return Stream.of(
                Arguments.of("CP1 - Minutos negativos",
                        -5, "BASICA", false, "Los minutos no pueden ser negativos"),

                Arguments.of("CP6 - Tarifa inválida",
                        10, "INVALIDA", false, "Tarifa no válida")
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("casosExcepcionales")
    void testCasosExcepcionales(String nombreCaso,
                                int minutos,
                                String tarifa,
                                boolean horaPunta,
                                String mensajeEsperado) {

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> CalculadoraLlamada.calcularCoste(minutos, tarifa, horaPunta)
        );

        assertEquals(mensajeEsperado, ex.getMessage());
    }
}