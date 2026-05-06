package org.example.ejercicios_viejos.pooBloque3.ejercicio4.ejercicio5;

public abstract class Llamada {
    private String numeroOrigen;
    private String numeroDestino;
    protected int duracion;
    protected int costo;

    public Llamada(String numeroOrigen, String numeroDestino, int duracion) {
        this.numeroOrigen = numeroOrigen;
        this.numeroDestino = numeroDestino;
        this.duracion = duracion;
        calcularCosto();
    }

    abstract void calcularCosto();

    @Override
    public String toString() {
        return "numeroOrigen='" + numeroOrigen + '\'' +
                ", numeroDestino='" + numeroDestino + '\'' +
                ", duracion=" + duracion +
                ", costo=" + costo;
    }
}

class Local extends Llamada {

    public Local(String numeroOrigen, String numeroDestino, int duracion) {
        super(numeroOrigen, numeroDestino, duracion);
    }

    @Override
    void calcularCosto() {
        costo = duracion * 5;
    }
}


class Provincial extends Llamada {
    private int franja;

    public Provincial(String numeroOrigen, String numeroDestino, int duracion, int franja) {
        this.franja = franja;
        super(numeroOrigen, numeroDestino, duracion);
    }

    @Override
    void calcularCosto() {
        switch (franja) {
            case 1:
                costo = duracion * 8;
                break;
            case 2:
                costo = duracion * 12;
                break;
            case 3:
                costo = duracion * 16;
                break;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", franja=" + franja;
    }
}