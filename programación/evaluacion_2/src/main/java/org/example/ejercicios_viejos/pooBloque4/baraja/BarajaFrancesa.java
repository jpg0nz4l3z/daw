package org.example.ejercicios_viejos.pooBloque4.baraja;

import java.util.ArrayList;

public class BarajaFrancesa extends Baraja<PalosBarFrancesa> {

    public BarajaFrancesa() {
        cartas = new ArrayList<>();
        monton = new ArrayList<>();
        crearBaraja();
        barajar();
    }

    @Override
    protected void crearBaraja() {

        cartasTotales = 52;
        cartasPorPalo = 13;

        for (PalosBarFrancesa palo : PalosBarFrancesa.values()) {
            for (int i = 1; i <= 13; i++) {
                cartas.add(new Carta<>(i, palo));
            }
        }
    }

    public boolean cartaRoja(Carta<PalosBarFrancesa> c) {
        return c.getPalo() == PalosBarFrancesa.CORAZONES ||
                c.getPalo() == PalosBarFrancesa.DIAMANTES;
    }

    public boolean cartaNegra(Carta<PalosBarFrancesa> c) {
        return c.getPalo() == PalosBarFrancesa.PICAS ||
                c.getPalo() == PalosBarFrancesa.TREBOLES;
    }
}

