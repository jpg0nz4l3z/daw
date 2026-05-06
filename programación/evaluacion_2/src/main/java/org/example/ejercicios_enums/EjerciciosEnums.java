package org.example.ejercicios_enums;

import java.util.*;

/* =========================================================
   =================== ARCHIVO COMPLETO =====================
   ========================================================= */

public class EjerciciosEnums {

    /* ===================== 1) ENUM BÁSICO ===================== */
    public enum Dia {
        LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO
    }

    /* ===================== 2) ENUM CON ATRIBUTOS ===================== */
    public enum NivelPrioridad {
        BAJA(1),
        MEDIA(2),
        ALTA(3);

        private int nivel;

        NivelPrioridad(int nivel) {
            this.nivel = nivel;
        }

        public int getNivel() {
            return nivel;
        }
    }

    /* ===================== 3) ENUM CON MÉTODO ===================== */
    public enum Operacion {
        SUMA,
        RESTA,
        MULTIPLICACION,
        DIVISION;

        public double aplicar(double a, double b) {
            switch (this) {
                case SUMA: return a + b;
                case RESTA: return a - b;
                case MULTIPLICACION: return a * b;
                case DIVISION: return a / b;
                default: throw new IllegalArgumentException();
            }
        }
    }

    /* ===================== 4) ENUM CON MÉTODOS ABSTRACTOS ===================== */
    public enum OperacionAvanzada {

        SUMA {
            public double aplicar(double a, double b) { return a + b; }
        },
        RESTA {
            public double aplicar(double a, double b) { return a - b; }
        },
        MULTIPLICACION {
            public double aplicar(double a, double b) { return a * b; }
        },
        DIVISION {
            public double aplicar(double a, double b) { return a / b; }
        };

        public abstract double aplicar(double a, double b);
    }

    /* ===================== 5) ENUM CON STRING Y BÚSQUEDA ===================== */
    public enum EstadoPedido {

        PENDIENTE("Pendiente"),
        ENVIADO("Enviado"),
        ENTREGADO("Entregado");

        private String descripcion;

        EstadoPedido(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public static EstadoPedido fromDescripcion(String desc) {
            for (EstadoPedido e : values()) {
                if (e.descripcion.equalsIgnoreCase(desc)) {
                    return e;
                }
            }
            return null;
        }
    }

    /* ===================== 6) ENUM IMPLEMENTANDO INTERFACE ===================== */
    public interface Describible {
        String descripcion();
    }

    public enum Color implements Describible {
        ROJO, VERDE, AZUL;

        @Override
        public String descripcion() {
            return "Color: " + this.name();
        }
    }

    /* ===================== 7) ENUM COMO MÁQUINA DE ESTADOS ===================== */
    public enum Semaforo {

        ROJO {
            public Semaforo siguiente() { return VERDE; }
        },
        VERDE {
            public Semaforo siguiente() { return AMARILLO; }
        },
        AMARILLO {
            public Semaforo siguiente() { return ROJO; }
        };

        public abstract Semaforo siguiente();
    }

    /* ===================== 8) ENUM CON MÚLTIPLES ATRIBUTOS ===================== */
    public enum Planeta {

        TIERRA(5.97E24, 6371000),
        MARTE(6.42E23, 3389500);

        private final double masa;
        private final double radio;

        Planeta(double masa, double radio) {
            this.masa = masa;
            this.radio = radio;
        }

        public double gravedad() {
            double G = 6.67430E-11;
            return G * masa / (radio * radio);
        }
    }

    /* ===================== MÉTODOS DE PRUEBA ===================== */

    public static boolean esFinDeSemana(Dia dia) {
        return dia == Dia.SABADO || dia == Dia.DOMINGO;
    }

    public static void recorrerDias() {
        for (Dia d : Dia.values()) {
            System.out.println(d);
        }
    }

    public static void ejemploEnumSet() {
        EnumSet<Dia> laborales = EnumSet.range(Dia.LUNES, Dia.VIERNES);
        System.out.println("Laborales: " + laborales);
    }

    public static void ejemploEnumMap() {
        EnumMap<Dia, String> tareas = new EnumMap<>(Dia.class);
        tareas.put(Dia.LUNES, "Gym");
        tareas.put(Dia.MARTES, "Estudiar");

        System.out.println("Tarea lunes: " + tareas.get(Dia.LUNES));
    }

    /* ===================== MAIN ===================== */

    public static void main(String[] args) {

        // ENUM BÁSICO
        System.out.println("¿Es fin de semana? " + esFinDeSemana(Dia.SABADO));

        // ENUM CON ATRIBUTOS
        System.out.println("Nivel prioridad alta: " + NivelPrioridad.ALTA.getNivel());

        // ENUM CON MÉTODO
        System.out.println("Suma: " + Operacion.SUMA.aplicar(5, 3));

        // ENUM CON MÉTODO ABSTRACTO
        System.out.println("Multiplicación: " + OperacionAvanzada.MULTIPLICACION.aplicar(4, 2));

        // ENUM CON BÚSQUEDA
        System.out.println("Estado desde texto: " + EstadoPedido.fromDescripcion("Enviado"));

        // INTERFACE
        System.out.println(Color.ROJO.descripcion());

        // MÁQUINA DE ESTADOS
        Semaforo estado = Semaforo.ROJO;
        estado = estado.siguiente();
        System.out.println("Siguiente semáforo: " + estado);

        // PLANETA
        System.out.println("Gravedad Tierra: " + Planeta.TIERRA.gravedad());

        // EnumSet
        ejemploEnumSet();
        Dia dia = Dia.values()[0];
        dia.ordinal();
        // EnumMap
        ejemploEnumMap();

        // Recorrer valores
        recorrerDias();
    }
}
