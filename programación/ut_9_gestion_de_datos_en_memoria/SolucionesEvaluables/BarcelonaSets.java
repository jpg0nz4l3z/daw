/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//http://myfpschool.com/ejercicios-de-java-collections/

package POO.Colecciones.SolucionesEvaluables;
import java.util.*;

public class BarcelonaSets {
   HashSet FCBarcelona = new HashSet<>();
   public void add(){
      FCBarcelona.add("Jordi Alba");
      FCBarcelona.add("Pique");
      FCBarcelona.add("Busquets");
      FCBarcelona.add("Iniesta");
      FCBarcelona.add("Messi");
   }

   HashSet jugadores = new HashSet<>();
   public void add2(){
      jugadores.add("Pique");
      jugadores.add("Busquets");
   }

   public void ShowBarcelona(){
      int i = 0;
      Iterator it = FCBarcelona.iterator();
      while(it.hasNext()){
         System.out.print(it.next());
         if(FCBarcelona.size()-1 > i){
            System.out.print(", ");
            i++;
         }
      }
      System.out.println();
   }

   public void contains(){
      if(FCBarcelona.contains("Neymar Jr")){
         System.out.println("Neymar Si está en el conjunto");
      }else{
         System.out.println("Neymar No está en el conjunto");
      }
   }

   public void jugadoresEnBarcelona(){
      Iterator it = jugadores.iterator();
     
      while(it.hasNext()){
         if(FCBarcelona.contains(it.next())){
            System.out.println(it.next()+" está en el conjunto");
         }else{
            System.out.println(it.next()+" no está en el conjunto");
         }
      }
   }

   public void unir(){
      FCBarcelona.addAll(jugadores);
   }

   public void borrar(){
      jugadores.removeAll(jugadores);
      System.out.println("Jugadores Borrados");
   }

   public void ShowJugadores(){
      Iterator it = jugadores.iterator();
      int i=0;
      if(it.hasNext()==false){
         System.out.println("No hay jugadores");
      }else{
         while(it.hasNext()){
            System.out.print(it.next());
            if(jugadores.size()-1 > i){
               System.out.print(", ");
               i++;
            }
         }
         System.out.println();
      }
   }

   public static void main(String[] args) {
      BarcelonaSets Barcelona = new BarcelonaSets();
      Barcelona.add();
      Barcelona.contains();
      Barcelona.ShowBarcelona();
      Barcelona.add2();
      Barcelona.jugadoresEnBarcelona();
      Barcelona.ShowJugadores();
      Barcelona.unir();
      Barcelona.borrar();
      Barcelona.ShowJugadores();
      Barcelona.ShowBarcelona();
   }
} 

