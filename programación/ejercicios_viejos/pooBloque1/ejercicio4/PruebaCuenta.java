package pooBloque1.ejercicio4;

public class PruebaCuenta {
    public static void main(String[] args) {
        Persona persona = new Persona("O391|831M");
        persona.agregarCuentaBancaria(new Cuenta("ES1111111111111111"));
        persona.agregarCuentaBancaria(new Cuenta("ES8888888888888888", 750));
        persona.agregarCuentaBancaria(new Cuenta("ES3333333333333333", 100));
        persona.agregarCuentaBancaria(new Cuenta("ES4444444444444444", 100));

       persona.getCuenta(0).recibirAbono(1100);
        persona.getCuenta(1).pagarRecibo(750);

        Cuenta.transferir(persona.getCuenta(0), persona.getCuenta(1), 1200);

        System.out.println("Es moroso? " + persona.esMoroso());
        for (int i = 0; i < 3; i++) {
            if(persona.getCuenta(i) != null){
                System.out.println(persona.getCuenta(i).toString());
            }
        }
    }
}
