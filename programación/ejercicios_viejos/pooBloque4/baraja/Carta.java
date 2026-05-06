package pooBloque4.baraja;

public class Carta<T> {

    private int numero;
    private T palo;

    public Carta(int numero, T palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public int getNumero() {
        return numero;
    }

    public T getPalo() {
        return palo;
    }

    @Override
    public String toString() {

        String nombreCarta = "";
        if (palo instanceof PalosBarFrancesa) {
            switch (numero) {
                case 1 -> nombreCarta = "As";
                case 11 -> nombreCarta = "Jota";
                case 12 -> nombreCarta = "Reina";
                case 13 -> nombreCarta = "Rey";
                default -> nombreCarta = String.valueOf(numero);
            }
        }

        if (palo instanceof PalosBarEspaniola) {
            switch (numero) {
                case 1 -> nombreCarta = "As";
                case 10 -> nombreCarta = "Sota";
                case 11 -> nombreCarta = "Caballo";
                case 12 -> nombreCarta = "Rey";
                default -> nombreCarta = String.valueOf(numero);
            }
        }
        return nombreCarta + " de " + palo;
    }
}


