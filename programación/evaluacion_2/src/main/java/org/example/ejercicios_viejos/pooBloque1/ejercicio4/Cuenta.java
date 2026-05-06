package org.example.ejercicios_viejos.pooBloque1.ejercicio4;

public class Cuenta {
    private String numeroCuenta;
    private double saldoDisponible;

    public Cuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Cuenta(String numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldoDisponible = saldoInicial;
    }

    public void recibirAbono(double abono) {
        saldoDisponible += abono;
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    public void pagarRecibo(double valorRecibo) {
        saldoDisponible -= valorRecibo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setSaldoDisponible(double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public static void transferir(Cuenta c1, Cuenta c2, double cantidad) {
        c1.pagarRecibo(cantidad);
        c2.recibirAbono(cantidad);
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "numeroCuenta='" + numeroCuenta + '\'' +
                ", saldoDisponible=" + saldoDisponible +
                '}';
    }
}
