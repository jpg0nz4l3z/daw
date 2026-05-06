package juegodeanimales;

public class Gato extends Animal {
    private boolean bigoteLargo;

    public Gato(String nombre, int edad, boolean bigoteLargo) {
        super(nombre, edad);
        this.bigoteLargo = bigoteLargo;
    }

    @Override
    public String hablar() {
        return "MIAU";
    }

    public boolean isBigoteLargo() {
        return bigoteLargo;
    }
}

