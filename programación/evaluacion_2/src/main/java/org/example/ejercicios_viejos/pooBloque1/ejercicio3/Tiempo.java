package org.example.ejercicios_viejos.pooBloque1.ejercicio3;

public class Tiempo {
    private int hora;
    private int minuto;
    private int segundo;

    public Tiempo(int hora, int minuto, int segundo) {
        assert hora >= 0 && hora <= 23: "Hora no puede ser menor a 0 ni mayor a 23";
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    public Tiempo(int hora, int minuto) {
        this.hora = hora;
        this.minuto = minuto;
    }

    public Tiempo(int hora) {
        this.hora = hora;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    @Override
    public String toString() {
        return "Tiempo{" +
                "hora=" + hora +
                ", minuto=" + minuto +
                ", segundo=" + segundo +
                '}';
    }
}
