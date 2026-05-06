package cajero.models;

public class Cuenta {

    private String numeroCuenta;
    private String pin;
    private double saldo;
    private double saldoInicial;
    private double balance;

    public Cuenta(String numeroCuenta, String pin, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.pin = pin;
        this.saldo = saldo;
        this.balance = 0;
        this.saldoInicial = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getPin() {
        return pin;
    }

    public void sacarDinero(double cantidad){
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }

        if (cantidad > saldo) {
            throw new IllegalStateException("Saldo insuficiente");
        }
        saldo -= cantidad;
        balance -= cantidad;
    }

    public void depositar(double cantidad){
        saldo += cantidad;
        balance += cantidad;
    }

    public double verBalance() {
        return saldoInicial + balance;
    }
}
