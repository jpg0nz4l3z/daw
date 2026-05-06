package org.example.ejercicios_viejos.pooBloque3.ejercicio4.ejercicio5;

public class test {
    static void main(String[] args) {
        CentralTelefónica centralTelefónica = new CentralTelefónica();

        centralTelefónica.agregarLlamada(new Local("23", "24",1));
        centralTelefónica.agregarLlamada(new Provincial("23", "24",2, 2));

        System.out.println("----------Centralita telefónica-----------");
        System.out.println("Cantidad de llamadas : "+ centralTelefónica.getCantidadLlamadas());
        System.out.println("Coste total : "+ centralTelefónica.getCostoTotal());
    }
}
