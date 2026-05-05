use personas;

create table if not exists personas(
    id int auto_increment primary key,
    nombre varchar(50),
    apellido varchar(50),
    edad int
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;