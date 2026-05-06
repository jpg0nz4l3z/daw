/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO.Colecciones.SolucionesEvaluables;

import java.util.*;
public class DiasSemana {
    public static void main(String[] args) {
//        ArrayList listDias = new ArrayList(); //creamos arraylist listDias.
        LinkedList listDias = new LinkedList(); //creamos arraylist listDias.
        listDias.add("Lunes"); //añadimos los ´dias de la semana
        listDias.add("Martes");
        listDias.add("Miercoles");
        listDias.add("Jueves");
        listDias.add("Viernes");
        listDias.add("Sabado");
        listDias.add("Domingo");
        listDias.add(4,"Juernes");//añadimos en la posición 4 a Juernes.
        System.out.println("Array original tras añadir Juernes en la posición 4: " + listDias);
        ArrayList listaDos = new ArrayList(listDias); //creamos un arraylist copia de listDias
        listDias.addAll(listaDos); //añadimos los datos de listaDos en listDias (se duplicarán)
        System.out.println("Posiciones 3 y 4: "+ listDias.get(3)+", "+listDias.get(4));//posiciones 3 y 4
        //System.out.println(listDias.get(0)+", "+listDias.get(listDias.size()-1));//posiciones primera y última
        System.out.println("Primero y último: "+listDias.getFirst()+", "+listDias.getLast());//posiciones primera y última
        System.out.println("Array original tras añadir la copia a sí misma: "+listDias); //mostramos todo el arraylist
        listDias.remove("Juernes"); //eliminamos Juernes

        if(listDias.remove("Juernes")){
            System.out.println("Borrado");
        }else{
            System.out.println("No existe");
        }

        Iterator it = listDias.iterator();
        while(it.hasNext()){ //recorremos todos los elemenos del arraylist
            System.out.println(it.next());
        }

        if (listDias.contains("Lunes")){
            System.out.println("Si existe Lunes");
        }

        Iterator it2 = listDias.iterator();
        while(it2.hasNext()){
            if(it2.next().toString().toUpperCase()=="LUNES"){
                System.out.println("Si existe");
            }
        }

        Collections.sort(listDias);//ordenamos la lista.
        System.out.println("Array ordenado: "+listDias);

        listDias.clear();//borramos la lista
        System.out.println(listDias);

    }

} 

