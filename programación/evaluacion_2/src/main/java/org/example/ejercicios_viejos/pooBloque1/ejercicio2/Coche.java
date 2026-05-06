package org.example.ejercicios_viejos.pooBloque1.ejercicio2;

import java.util.Objects;

public class Coche {
    private String color;
    private String marca;
    private String modelo;
    private double caballos;
    private int puertas;
    private String matricula;

    public Coche(String color, String marca, String modelo, double caballos, int puertas, String matricula) {
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.caballos = caballos;
        this.puertas = puertas;
        this.matricula = matricula;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Coche coche = (Coche) o;
        return Double.compare(caballos, coche.caballos) == 0 && puertas == coche.puertas && Objects.equals(color, coche.color) && Objects.equals(marca, coche.marca) && Objects.equals(modelo, coche.modelo) && Objects.equals(matricula, coche.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, marca, modelo, caballos, puertas, matricula);
    }

    @Override
    public String toString() {
        return  " color='" + color + '\'' +
                "\n marca='" + marca + '\'' +
                "\n modelo='" + modelo + '\'' +
                "\n caballos=" + caballos +
                "\n puertas=" + puertas +
                "\n matricula='" + matricula + '\'';
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getCaballos() {
        return caballos;
    }

    public void setCaballos(double caballos) {
        this.caballos = caballos;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
