package pooBloque1.ejercicio5;

public class ConjuntoLibros {
    private Libro[] libros;

    public ConjuntoLibros(int cantidadLibros) {
        this.libros = new Libro[cantidadLibros];
    }

    public void AgregarLibro(Libro libro) {
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] == null) {
                libros[i] = libro;
                break;
            }
        }
    }


}
