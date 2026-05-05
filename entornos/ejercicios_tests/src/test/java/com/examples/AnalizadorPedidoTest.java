package com.examples;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnalizadorPedidoTest {

    @Test
    void testCP1deberiaDevolverDatosInvalidosSiImportesEsNull() {
        String resultado = AnalizadorPedido.clasificarPedido(null, false);

        assertEquals("DATOS_INVALIDOS", resultado);
    }

    @Test
    void testCP2deberiaDevolverPedidoMuyGrandeSinDescuentoPremium() {
        double[] importes = {150, 60};

        String resultado = AnalizadorPedido.clasificarPedido(importes, false);

        assertEquals("PEDIDO_MUY_GRANDE", resultado);
    }

    @Test
    void testCP3deberiaDevolverPedidoMuyGrandeConDescuentoPremium() {
        double[] importes = {220, 10};

        String resultado = AnalizadorPedido.clasificarPedido(importes, true);

        assertEquals("PEDIDO_MUY_GRANDE", resultado);
    }

    @Test
    void testCP4deberiaDevolverErrorDatosSiExisteImporteNegativo() {
        double[] importes = {50, -10};

        String resultado = AnalizadorPedido.clasificarPedido(importes, false);

        assertEquals("ERROR_DATOS", resultado);
    }

    @Test
    void testCP5deberiaRecorrerElForYDevolverPedidoMuyGrande() {
        double[] importes = {120, 90};

        String resultado = AnalizadorPedido.clasificarPedido(importes, false);

        assertEquals("PEDIDO_MUY_GRANDE", resultado);
    }

    @Test
    void testCP6deberiaDevolverPedidoGrande() {
        double[] importes = {60, 50};

        String resultado = AnalizadorPedido.clasificarPedido(importes, false);

        assertEquals("PEDIDO_GRANDE", resultado);
    }

    @Test
    void testCP7deberiaDevolverPedidoNormal() {
        double[] importes = {40, 30};

        String resultado = AnalizadorPedido.clasificarPedido(importes, false);

        assertEquals("PEDIDO_NORMAL", resultado);
    }

    //Adicional(No básico) para curbir todas las ramas
    @Test
    void deberiaDevolverDatosInvalidosSiArrayVacio() {
        double[] importes = {};

        String resultado = AnalizadorPedido.clasificarPedido(importes, false);

        assertEquals("DATOS_INVALIDOS", resultado);
    }
}