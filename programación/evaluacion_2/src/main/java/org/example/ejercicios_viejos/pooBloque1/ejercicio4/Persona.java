package org.example.ejercicios_viejos.pooBloque1.ejercicio4;

public class Persona {
    private String dni;
    private Cuenta[] cuentasBancarias;

    public Persona(String dni){
        this.dni = dni;
        this.cuentasBancarias = new Cuenta[3];
    }

    public void agregarCuentaBancaria(Cuenta cuenta){
        if(cuentasBancarias[2] != null){
            System.out.println("No puedes tener más de 3 cuentas");
        }else{
            for(int i = 0; i < 3; i++){
                if(cuentasBancarias[i] == null){
                    cuentasBancarias[i] = cuenta;
                    break;
                }
            }
        }
    }

    public Cuenta getCuenta(int index){
        if(index >= 0 && index < this.cuentasBancarias.length){
            return this.cuentasBancarias[index];
        }
        return null;
    }

    public boolean esMoroso(){
        for(int i = 0; i < 3; i++){
            if(cuentasBancarias[i] != null &&  cuentasBancarias[i].getSaldoDisponible() < 0){
                return true;
            }
        }
        return false;
    }

}
