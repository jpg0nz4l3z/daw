package pooBloque4.baraja;

import java.util.ArrayList;

public class BarajaEspaniola extends Baraja<PalosBarEspaniola> {

    private boolean incluir8y9;

    public BarajaEspaniola(boolean incluir8y9) {
        this.incluir8y9 = incluir8y9;
        cartas = new ArrayList<>();
        monton = new ArrayList<>();
        crearBaraja();
        barajar();
    }

    @Override
    protected void crearBaraja() {

        cartasTotales = incluir8y9 ? 48 : 40;
        cartasPorPalo = incluir8y9 ? 12 : 10;

        for (PalosBarEspaniola palo : PalosBarEspaniola.values()) {
            for (int i = 1; i <= 12; i++) {
                if (!incluir8y9 && (i == 8 || i == 9)) continue;
                cartas.add(new Carta<>(i, palo));
            }
        }
    }
}
