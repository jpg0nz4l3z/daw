package ubicacionesInternacionales;

import java.util.ArrayList;

public class Ubicacion {
    String nombre;

    public Ubicacion(String nombre) {
        this.nombre = nombre;
    }
}

class UbicacionSimple extends Ubicacion {

    public UbicacionSimple(String nombre) {
        super(nombre);
    }

    @Override
    public String toString() {
        return nombre;
    }
}

class UbicacionCompuesta extends Ubicacion {
    ArrayList<Ubicacion> ubicaciones;

    public UbicacionCompuesta(String nombre, ArrayList<Ubicacion> ubicaciones) {
        super(nombre);
        this.ubicaciones = ubicaciones;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Ubicacion ubicacion : ubicaciones) {
            sb.append(ubicacion.toString() + " , ");
        }
        return nombre + " - " + sb.toString();
    }
}

class Agencia {
    Ubicacion ubicacion;

    public Agencia(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
}

class Test {
    static void main() {

        ArrayList<Ubicacion> municipiosHuila = new ArrayList<>(){{
            add(new UbicacionSimple("Neiva"));
            add(new UbicacionSimple("Rivera"));
        }};

        ArrayList<Ubicacion> municipiosCundinamarca = new ArrayList<>(){{
            add(new UbicacionSimple("Bogotá"));
            add(new UbicacionSimple("Madrid"));
        }};

        ArrayList<Ubicacion> departamentos = new ArrayList<Ubicacion>() {{
            add(new UbicacionCompuesta("Huila", municipiosHuila));
            add(new UbicacionCompuesta("Cundinamarca", municipiosCundinamarca));
        }};


        UbicacionCompuesta colombia = new UbicacionCompuesta("Colombia", departamentos);
        System.out.println(colombia.toString());
    }
}
