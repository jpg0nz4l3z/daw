package POO.EjerciciosExpresionesLambda;

//6. Eventos con clases anónimas.
interface Evento {
    void manejarEvento();
}

public class ManejoEventos {
    public static void main(String[] args) {
        Evento evento = new Evento() {
            @Override
            public void manejarEvento() {
                System.out.println("Evento manejado");
            }
        };

        evento.manejarEvento();
    }
}


