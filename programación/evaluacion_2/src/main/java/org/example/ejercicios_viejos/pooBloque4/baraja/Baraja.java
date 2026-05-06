package org.example.ejercicios_viejos.pooBloque4.baraja;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Baraja<T> {

    protected List<Carta<T>> cartas;
    protected List<Carta<T>> monton;
    protected int cartasTotales;
    protected int cartasPorPalo;

    public Baraja() {
        cartas = new ArrayList<>();
        monton = new ArrayList<>();
        crearBaraja();
        barajar();
    }

    protected abstract void crearBaraja();

    public void barajar() {
        Collections.shuffle(cartas);
    }

    public Carta<T> siguienteCarta() {
        if (cartas.isEmpty()) {
            System.out.println("No hay más cartas en la baraja.");
            return null;
        }
        Carta<T> c = cartas.remove(0);
        monton.add(c);
        return c;
    }

    public int cartasDisponibles() {
        return cartas.size();
    }

    public List<Carta<T>> darCartas(int num) {
        if (num > cartas.size()) {
            System.out.println("No hay suficientes cartas para repartir.");
            return Collections.emptyList();
        }

        List<Carta<T>> dadas = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            dadas.add(siguienteCarta());
        }
        return dadas;
    }

    public void cartasMonton() {
        if (monton.isEmpty()) {
            System.out.println("Aún no ha salido ninguna carta.");
        } else {
            monton.forEach(System.out::println);
        }
    }

    public void mostrarBaraja() {
        if (cartas.isEmpty()) {
            System.out.println("No quedan cartas en la baraja.");
        } else {
            cartas.forEach(System.out::println);
        }
    }
}