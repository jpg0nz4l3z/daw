/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO.Colecciones.SolucionesEvaluables;

import java.util.*;

public class HashMapColegio {
    public static HashMap<String,Integer> alumno = new HashMap<String,Integer>();
    public static void addAlumno(String nac){
        if (alumno.containsKey(nac)){
            int i = (int) alumno.get(nac);
            alumno.remove(nac);
            alumno.put(nac,i+1);
        }else{
            alumno.put(nac,1);
        }
    }
    public static void showAll(){
        for(String alum: alumno.keySet()){
           System.out.println("Numero de alumno: "+alumno.get(alum)+" Nacionalidad alumno: "+alum);
        }

        Iterator it = alumno.keySet().iterator();
        while (it.hasNext()){
            String key = (String) it.next();
            System.out.println("Numero de alumno: "+alumno.get(key)+" Nacionalidad alumno: "+key);
        }
    }
    public static void showNacionalidad(String nacion){
        if (alumno.containsKey(nacion)){
           System.out.println(nacion + "->" + alumno.get(nacion));
        }
        else{
           System.out.println("No hay alumnos con esta nacionalidad.");
        }
        for(Object k :alumno.keySet()){
           System.out.println(k+"->"+alumno.get(k));
        }
    }
    public static int[] cuantos(){
        int [] total = new int[2];
        int num = 0;
        for(int valores: alumno.values()){
           num += valores;
        }
        int tamanio = alumno.size();
        total[0] = num;
        total[1] = tamanio;
        return total;
    }
    public static void borrar(String nac){
        alumno.remove(nac);
    }
    public static void main(String [] args){
       addAlumno("Española");
       addAlumno("Británica");
       addAlumno("Alemana");
       showNacionalidad("Española");
       addAlumno("Española");
       addAlumno("Británica");  
       showNacionalidad("Francesa");
       addAlumno("Española");
       addAlumno("Británica");
       showNacionalidad("Italiana");
       showAll();
       System.out.println("Número de alumnos: "+cuantos()[0] + ", Número de nacionalidades: " + cuantos()[1]);
    }
} 

