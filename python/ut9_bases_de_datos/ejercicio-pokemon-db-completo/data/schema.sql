-- Crear base de datos pokemondb
DROP DATABASE IF EXISTS pokemondb;
CREATE DATABASE pokemondb;
USE pokemondb;

-- Tabla principal de pokémons
CREATE TABLE pokemon (
    id INT PRIMARY KEY,
    num VARCHAR(10) NOT NULL,
    name VARCHAR(100) NOT NULL,
    img VARCHAR(255),
    height FLOAT,
    weight FLOAT,
    candy VARCHAR(100),
    candy_count INT,
    egg VARCHAR(50),
    spawn_chance FLOAT,
    avg_spawns FLOAT,
    spawn_time VARCHAR(20)
);

-- Tabla de tipos de pokémons
CREATE TABLE pokemon_type (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pokemon_id INT NOT NULL,
    type_name VARCHAR(50) NOT NULL,
    FOREIGN KEY (pokemon_id) REFERENCES pokemon(id) ON DELETE CASCADE
);

-- Tabla de debilidades de pokémons
CREATE TABLE pokemon_weakness (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pokemon_id INT NOT NULL,
    weakness_name VARCHAR(50) NOT NULL,
    FOREIGN KEY (pokemon_id) REFERENCES pokemon(id) ON DELETE CASCADE
);

-- Tabla de multiplicadores de pokémons
CREATE TABLE pokemon_multiplier (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pokemon_id INT NOT NULL,
    multiplier FLOAT NOT NULL,
    FOREIGN KEY (pokemon_id) REFERENCES pokemon(id) ON DELETE CASCADE
);

-- Tabla de evoluciones de pokémons
CREATE TABLE pokemon_evolution (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pokemon_id INT NOT NULL,
    direction VARCHAR(10) NOT NULL,
    evolution_num VARCHAR(10) NOT NULL,
    evolution_name VARCHAR(100) NOT NULL,
    FOREIGN KEY (pokemon_id) REFERENCES pokemon(id) ON DELETE CASCADE
);

-- Índices para mejorar el rendimiento
CREATE INDEX idx_pokemon_name ON pokemon(name);
CREATE INDEX idx_pokemon_num ON pokemon(num);
