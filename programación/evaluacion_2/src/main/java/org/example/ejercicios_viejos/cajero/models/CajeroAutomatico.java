package org.example.ejercicios_viejos.cajero.models;

import java.util.ArrayList;

public class CajeroAutomatico {

    private Cuenta cuenta;

    public double verBalance() {
        return cuenta.verBalance();
    }

    public void sacarDinero(double cantidad) {
        cuenta.sacarDinero(cantidad);
    }

    public boolean autenticar(String numeroCuenta, String pin, ArrayList<Cuenta> cuentas) {
        for(Cuenta cuenta : cuentas) {
            if(cuenta.getNumeroCuenta().equals(numeroCuenta) && cuenta.getPin().equals(pin)) {
                this.cuenta = cuenta;
                return true;
            }
        }
        return false;
    }

    public void depositar(double cantidad) {
        cuenta.depositar(cantidad);
    }

}
