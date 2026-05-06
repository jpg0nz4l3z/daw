package org.example.ejercicios_viejos.cajero.utils;

import java.util.Scanner;

public enum Mensaje {
    BIENVENIDA("Bienvenido al cajero automático de IES Quevedo"),
    INTRODUCIR_CUENTA("Por favor introduce tu número de cuenta"),
    INTRODUCIR_PIN("Por favor introduce tu PIN"),
    AUTENTICACION_FALLIDA("Número de cuenta o PIN incorrectos, intentalo de nuevo"),
    AUTENTICACION_EXITOSA("Autenticacion Exitosa"),
    LINEA_SEPARADORA("+------------------------------------------------+"),
    MENU_SALIR("¿Quieres salir?\n" +
            "* Presiona cualquier tecla para salir\n" +
            "* Presiona 2 para intentar de nuevo"),
    MENU_HEADER(Mensaje.LINEA_SEPARADORA.texto() + "\n" +
            "| " + Mensaje.BIENVENIDA.texto() + " |\n" +
            Mensaje.LINEA_SEPARADORA.texto()),
    SALIR("Salir"),
    MENU_OPCIONES(
            "| 1. Ver balance                                 |\n" +
                    "| 2. Sacar dinero                                |\n" +
                    "| 3. Depositar                                   |\n" +
                    "| 4. " + Mensaje.SALIR.texto() + "                                       |\n" +
                    Mensaje.LINEA_SEPARADORA.texto()),
    MENU(Mensaje.MENU_HEADER.texto() + "\n" + Mensaje.MENU_OPCIONES.texto()),
    MENU_OPCION_INVALIDA("Selecciona una opción válida"),
    DIGITAR_MONTO("Digite el monto ej(5,3)"),
    MONTO_INVALIDO("Digite un monto correcto ej (5,3)");

    private final String texto;

    Mensaje(String texto) {
        this.texto = texto;
    }

    public String texto() {
        return texto;
    }
}
