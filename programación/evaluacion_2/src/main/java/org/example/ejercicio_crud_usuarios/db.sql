CREATE
DATABASE IF NOT EXISTS pruebas;
USE
pruebas;

CREATE TABLE IF NOT EXISTS usuarios
(
    id
    INT
    AUTO_INCREMENT
    PRIMARY
    KEY,
    nombre
    VARCHAR
(
    100
) NOT NULL,
    email VARCHAR
(
    150
) NOT NULL UNIQUE
    );
