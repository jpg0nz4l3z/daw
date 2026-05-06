package org.example.ejercicio_crud_usuarios;

public class PruebaUsuario {
    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();

        // CREATE
        dao.insertar(new Usuario("Juan", "juan@email.com"));
        dao.insertar(new Usuario("Ana", "ana@email.com"));

        // READ
        System.out.println("== LISTA ==");
        dao.listar().forEach(System.out::println);

        // READ por id
        System.out.println("== BUSCAR ID 1 ==");
        System.out.println(dao.buscarPorId(1));

        // UPDATE
        System.out.println("== ACTUALIZAR ID 1 ==");
        dao.actualizar(new Usuario(1, "Juan Actualizado", "juan2@email.com"));

        // DELETE
        System.out.println("== ELIMINAR ID 2 ==");
        dao.eliminar(2);

        // READ final
        System.out.println("== LISTA FINAL ==");
        dao.listar().forEach(System.out::println);
    }
}
