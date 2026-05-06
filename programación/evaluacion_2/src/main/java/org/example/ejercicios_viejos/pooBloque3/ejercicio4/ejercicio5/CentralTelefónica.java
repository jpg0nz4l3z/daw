package org.example.ejercicios_viejos.pooBloque3.ejercicio4.ejercicio5;

import java.util.ArrayList;

public class CentralTelefónica {
    private ArrayList<Llamada> llamadas = new ArrayList<Llamada>();

    public void agregarLlamada(Llamada llamada){
        llamadas.add(llamada);
        System.out.println(llamada.toString());
    }

    public int getCantidadLlamadas(){
        return  llamadas.size();
    }

    public double getCostoTotal(){
        double costeTotal = 0;
        for(Llamada llamada : llamadas){
            costeTotal += llamada.costo;
        }
        return  costeTotal;
    }
}
