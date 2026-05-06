package org.example.ejercicios_viejos.pooBloque2.ejercicio5;

import java.util.Objects;

public abstract class Inmueble {
    private String direccion;
    protected double metrosCuadrados;
    private Condicion condicion;
    private int antiguedad;
    private double precioBase;
    protected double precioReal;

    public Inmueble(String direccion, double metrosCuadrados, Condicion condicion, int antiguedad, double precioBase) {
        this.direccion = direccion;
        this.metrosCuadrados = metrosCuadrados;
        this.condicion = condicion;
        this.antiguedad = antiguedad;
        this.precioBase = precioBase;
        ajustarPrecioBase();
    }

    private void ajustarPrecioBase(){
        if(antiguedad < 15 ){
            precioReal = precioBase - (precioBase*0.01);
        }else{
            precioReal = precioBase - (precioBase*0.02);
        }
    }

    abstract protected void calcularPrecioReal();

    @Override
    public String toString() {
        return "direccion='" + direccion +
                ", metrosCuadrados=" + metrosCuadrados +
                ", condicion=" + condicion +
                ", antiguedad=" + antiguedad +
                ", precioBase=" + precioBase +
                ", precioReal=" + precioReal;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Inmueble inmueble = (Inmueble) o;
        return Double.compare(metrosCuadrados, inmueble.metrosCuadrados) == 0 && antiguedad == inmueble.antiguedad && Double.compare(precioBase, inmueble.precioBase) == 0 && Double.compare(precioReal, inmueble.precioReal) == 0 && Objects.equals(direccion, inmueble.direccion) && condicion == inmueble.condicion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(direccion, metrosCuadrados, condicion, antiguedad, precioBase, precioReal);
    }
}

class Piso extends Inmueble {
    int piso;

    public Piso(String direccion, double metrosCuadrados, Condicion condicion, int antiguedad, double precioBase, int piso) {
        super(direccion, metrosCuadrados, condicion, antiguedad, precioBase);
        this.piso = piso;
        calcularPrecioReal();
    }

    @Override
    protected void calcularPrecioReal(){
        if(piso >= 3){
            precioReal += precioReal*0.03;
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                ", piso=" + piso;
    }
}

class Local extends Inmueble {
    int ventanas;

    public Local(String direccion, double metrosCuadrados, Condicion condicion, int antiguedad, int precioBase, int ventanas) {
        super(direccion, metrosCuadrados, condicion, antiguedad, precioBase);
        this.ventanas = ventanas;
    }

    @Override
    protected void calcularPrecioReal(){
        if(super.metrosCuadrados > 50){
            precioReal += precioReal*0.01;
        }

        if(ventanas <= 1){
            precioReal -= precioReal*0.02;
        }else if(ventanas > 4){
            precioReal += precioReal*0.02;
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                ", ventanas=" + ventanas;
    }
}

enum Condicion {
    nuevo,
    deSegundaMano
}
