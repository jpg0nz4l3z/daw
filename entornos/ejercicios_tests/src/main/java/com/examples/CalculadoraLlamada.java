package com.examples;

public class CalculadoraLlamada {
    public static double calcularCoste(int minutos, String tarifa, boolean horaPunta) {
        if (minutos < 0) {
            throw new IllegalArgumentException("Los minutos no pueden ser negativos");
        }
        double precioPorMinuto;
        switch (tarifa.toUpperCase()) {
            case "BASICA":
                precioPorMinuto = 0.20;
                break;
            case "PRO":
                precioPorMinuto = 0.15;
                break;
            case "EMPRESA":
                precioPorMinuto = 0.10;
                break;
            default:
                throw new IllegalArgumentException("Tarifa no válida");
        }
        if (horaPunta) {
            precioPorMinuto += 0.05;
        }
        return minutos * precioPorMinuto;
    }
}