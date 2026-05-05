package com.examples;

public class AnalizadorPedido {
    public static String clasificarPedido(double[] importes, boolean clientePremium) {
        if (importes == null || importes.length == 0) {
            return "DATOS_INVALIDOS";
        }
        double total = 0;
        for (double importe : importes) {
            if (importe < 0) return "ERROR_DATOS";
            total += importe;
        }

        if (clientePremium) total -= 10;

        if (total > 200) return "PEDIDO_MUY_GRANDE";

        if (total >= 100) {
            return "PEDIDO_GRANDE";
        } else {
            return "PEDIDO_NORMAL";
        }
    }
}