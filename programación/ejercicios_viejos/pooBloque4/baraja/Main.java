    package pooBloque4.baraja;

    import java.util.List;
    import java.util.Scanner;

    public class Main {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            Baraja<?> baraja = null;

            System.out.println("BIENVENIDO AL JUEGO DE CARTAS");
            System.out.println("Elige tipo de baraja:");
            System.out.println("1. Baraja Española");
            System.out.println("2. Baraja Francesa");

            int opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.println("¿Deseas incluir las cartas 8 y 9?");
                    System.out.println("1. Sí");
                    System.out.println("2. No");
                    int inc = sc.nextInt();
                    boolean incluir8y9 = inc == 1;
                    baraja = new BarajaEspaniola(incluir8y9);
                }
                case 2 -> baraja = new BarajaFrancesa();
                default -> {
                    System.out.println("Opción no válida.");
                    System.exit(0);
                }
            }

            int accion;
            do {
                System.out.println("\nMENÚ");
                System.out.println("1. Sacar una carta");
                System.out.println("2. Ver cartas disponibles");
                System.out.println("3. Dar varias cartas");
                System.out.println("4. Ver cartas del montón");
                System.out.println("5. Mostrar baraja restante");
                System.out.println("6. Barajar");
                System.out.println("0. Salir");

                accion = sc.nextInt();

                switch (accion) {
                    case 1 -> {
                        Carta<?> c = baraja.siguienteCarta();
                        if (c != null) {
                            System.out.println("Has sacado: " + c);

                            if (baraja instanceof BarajaFrancesa bf) {
                                System.out.println(
                                        bf.cartaRoja((Carta<PalosBarFrancesa>) c)
                                                ? "Es una carta roja"
                                                : "Es una carta negra"
                                );
                            }
                        }
                    }
                    case 2 -> System.out.println(
                            "Cartas disponibles: " + baraja.cartasDisponibles()
                    );
                    case 3 -> {
                        System.out.print("¿Cuántas cartas quieres?: ");
                        int num = sc.nextInt();
                        List<? extends Carta<?>> cartas = baraja.darCartas(num);
                        cartas.forEach(System.out::println);
                    }
                    case 4 -> baraja.cartasMonton();
                    case 5 -> baraja.mostrarBaraja();
                    case 6 -> {
                        baraja.barajar();
                        System.out.println("La baraja ha sido barajada.");
                    }
                    case 0 -> System.out.println("¡Gracias por jugar!");
                    default -> System.out.println("Opción no válida.");
                }

            } while (accion != 0);

            sc.close();
        }
    }