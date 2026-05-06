package POO.EjerciciosExpresionesLambda;
//9. Manejo de Eventos de Ratón con Clases Anónimas:

interface EventoRaton {
    void clic();
    void desplazamiento();
}
public class ManejoRaton {
    public static void main(String[] args) {
        EventoRaton eventoRaton = new EventoRaton() {
            @Override
            public void clic() {
                System.out.println("Clic detectado");
            }

            @Override
            public void desplazamiento() {
                System.out.println("Desplazamiento del ratón");
            }
        };

        eventoRaton.clic();
        eventoRaton.desplazamiento();
    }
}
