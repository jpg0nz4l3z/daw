package org.example.ejercicios_viejos.cajero.views;

import cajero.controllers.Controller;
import cajero.utils.Mensaje;

import java.net.Socket;
import java.util.Scanner;

public class View {
    Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }

    public void autenticacionExitosaView() {
        System.out.println(Mensaje.AUTENTICACION_EXITOSA.texto());
    }

    public void autenticacionFallidaView() {
        System.out.println(Mensaje.AUTENTICACION_FALLIDA.texto());
    }

    public String menuView() {
        System.out.println(Mensaje.MENU.texto());
        return scanner.nextLine();
    }

    public double solicitarMontoView() {
        try {
            System.out.println(Mensaje.DIGITAR_MONTO.texto());
            double monto =scanner.nextDouble();
            scanner.nextLine();
            return monto;
        } catch (Exception e) {
            System.out.println(Mensaje.MONTO_INVALIDO.texto());
            scanner.next();
            return solicitarMontoView();
        }
    }

    public String solicitarCuenta() {
        System.out.println(Mensaje.INTRODUCIR_CUENTA.texto());
        return scanner.nextLine();
    }

    public String solicitarPin() {
        System.out.println(Mensaje.INTRODUCIR_PIN.texto());
        return scanner.nextLine();
    }

    public String salirView() {
        System.out.println(Mensaje.MENU_SALIR.texto());
        return scanner.nextLine();
    }

    public void menuHeaderView() {
        System.out.println(Mensaje.MENU_HEADER.texto());
    }

    public void opcionInvalidaView(){
        System.out.println(Mensaje.MENU_OPCION_INVALIDA.texto());
    }

    public void exceptionView(Exception e){
        System.out.println(e.getMessage());
    }

    public void returnDoubleView(double data){
        System.out.println(data);
    }

}
