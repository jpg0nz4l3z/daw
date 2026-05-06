package org.example.ejercicios_viejos.pooBloque2.ejercicio1;

public class Punto {
    private double x;
    private double y;
    private int cuadrante;


    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
        calcularCuadrante();
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "] - Cuadrante " + cuadrante;
    }

    public void calcularCuadrante() {
        if(x > 0 && y > 0) {
            cuadrante = 1;
        }else if(x < 0 && y > 0) {
            cuadrante = 2;
        }else if(x < 0 && y < 0) {
            cuadrante = 3;
        }else if(x > 0 && y < 0) {
            cuadrante = 4;
        }
    }
}
