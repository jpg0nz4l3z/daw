package gestiondeempleados;

import java.io.IOException;
import java.io.RandomAccessFile;

public class GestionEmpleados {

    private static final int TAM_REGISTRO = 40;
    private RandomAccessFile raf;

    public GestionEmpleados(String fichero) throws IOException {
        raf = new RandomAccessFile(fichero, "rw");
    }

    public void agregarEmpleado(Empleado e) throws IOException {
        long posicion = e.getId() * TAM_REGISTRO;
        raf.seek(posicion);

        raf.writeInt(e.getId());
        escribirStringFijo(e.nombre, 12);
        raf.writeInt(e.edad);
        raf.writeDouble(e.getSalario());
    }

    public Empleado leerEmpleado(int id) throws IOException {
        long posicion = id * TAM_REGISTRO;
        if (posicion >= raf.length()) return null;

        raf.seek(posicion);

        int empId = raf.readInt();
        String nombre = leerStringFijo(12);
        int edad = raf.readInt();
        double salario = raf.readDouble();

        return new EmpleadoAsalariado(empId, nombre, edad, salario);
    }

    public void modificarSalario(int id, double nuevoSalario) throws IOException {
        long posicion = id * TAM_REGISTRO + 32;
        raf.seek(posicion);
        raf.writeDouble(nuevoSalario);
    }

    public void listarEmpleados() throws IOException {
        raf.seek(0);

        while (raf.getFilePointer() < raf.length()) {
            int id = raf.readInt();
            String nombre = leerStringFijo(12);
            int edad = raf.readInt();
            double salario = raf.readDouble();

            System.out.println(
                    "ID=" + id +
                            ", Nombre=" + nombre.trim() +
                            ", Edad=" + edad +
                            ", Salario=" + salario
            );
        }
    }

    private void escribirStringFijo(String s, int longitud) throws IOException {
        StringBuffer buffer = new StringBuffer(s);
        buffer.setLength(longitud);
        raf.writeChars(buffer.toString());
    }

    private String leerStringFijo(int longitud) throws IOException {
        char[] chars = new char[longitud];
        for (int i = 0; i < longitud; i++) {
            chars[i] = raf.readChar();
        }
        return new String(chars);
    }

    public void cerrar() throws IOException {
        raf.close();
    }
}
