CREATE DATABASE biblioteca;
USE biblioteca;

CREATE TABLE libros (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        titulo VARCHAR(100) NOT NULL,
                        autor VARCHAR(100) NOT NULL,
                        disponible BOOLEAN NOT NULL
);

CREATE TABLE usuarios (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          nombre VARCHAR(100) NOT NULL,
                          email VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE prestamos (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           id_usuario INT,
                           id_libro INT,
                           fecha_prestamo DATE,
                           fecha_devolucion DATE,
                           FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
                           FOREIGN KEY (id_libro) REFERENCES libros(id)
);
