# Implementación MySQL para ejercicio-pokemon-db

Este documento explica cómo configurar y usar la integración de MySQL en el proyecto.

## Estructura de la Base de Datos

La base de datos `pokemondb` contiene 5 tablas normalizadas:

1. **pokemon** — Tabla principal con los datos escalares de cada pokémon
   - id (PK), num, name, img, height, weight, candy, candy_count, egg, spawn_chance, avg_spawns, spawn_time

2. **pokemon_type** — Tipos de cada pokémon (relación 1:N)
   - id (PK), pokemon_id (FK), type_name

3. **pokemon_weakness** — Debilidades de cada pokémon (relación 1:N)
   - id (PK), pokemon_id (FK), weakness_name

4. **pokemon_multiplier** — Multiplicadores de cada pokémon (relación 1:N)
   - id (PK), pokemon_id (FK), multiplier

5. **pokemon_evolution** — Evoluciones (anterior y siguiente) de cada pokémon (relación 1:N)
   - id (PK), pokemon_id (FK), direction ('prev' o 'next'), evolution_num, evolution_name

## Configuración Inicial

### 1. Instalar dependencias

```bash
# Crear entorno virtual (recomendado)
python -m venv .venv

# Activar entorno virtual
# Windows:
.venv\Scripts\activate
# macOS/Linux:
source .venv/bin/activate

# Instalar dependencias
pip install -r requirements.txt
```

### 2. Crear la base de datos

**Opción A: Usando el script helper de Python (recomendado)**

```bash
python setup_db.py
```

Este script creará automáticamente la BD y las tablas si todo está configurado correctamente.

**Opción B: Ejecutar manualmente en MySQL**

```bash
mysql -u quevedo -p1234 < data/init_db.sql
```

**Opción C: Importar en cliente MySQL**

```bash
mysql -h localhost -P 3319 -u quevedo -p
mysql> source data/init_db.sql;
```

### 3. Verificar la conexión

Ejecuta la aplicación y verifica que puedas:
1. Ver el menú principal sin errores
2. Usar opción 31 para importar pokémons
3. Acceder a opción 32 para el menú CRUD de BD

## Uso de la Aplicación

### Menú Principal

Nuevas opciones añadidas:

- **Opción 31**: Importar pokémons del JSON a la base de datos
  - Lee todos los pokémons del archivo `data/pokemons.json`
  - Los inserta/actualiza en la BD
  - Muestra el total importado

- **Opción 32**: Acceder al menú de base de datos (CRUD)
  - Abre un submenú con operaciones CRUD completas

### Menú Base de Datos (CRUD)

1. **Crear pokemon en BD** — Ingresa todos los datos manualmente
2. **Listar todos los pokémons** — Muestra todos los pokémons guardados en la BD
3. **Buscar pokemon por id** — Busca y muestra un pokémon por su ID
4. **Buscar pokemon por nombre** — Busca y muestra un pokémon por su nombre
5. **Modificar pokemon** — Actualiza los datos de un pokémon existente
6. **Eliminar pokemon** — Elimina un pokémon de la BD
7. **Contar pokémons en BD** — Muestra el total de pokémons en la BD
8. **Volver al menú principal** — Regresa al menú principal

## Flujo Recomendado de Uso

1. **Instalación inicial**:
   - Instalar dependencias con `pip install -r requirements.txt`
   - Ejecutar `python setup_db.py` para crear la BD

2. **Importar datos**:
   - Ejecutar la aplicación
   - Seleccionar opción 31 para importar los 151 pokémons del JSON

3. **Trabajar con la BD**:
   - Seleccionar opción 32 para abrir el menú CRUD
   - Crear, buscar, modificar o eliminar pokémons según sea necesario

## Archivos Relevantes

- `requirements.txt` — Dependencias (pymysql, cryptography)
- `data/init_db.sql` — Script DDL para crear la BD y tablas
- `setup_db.py` — Script helper para crear la BD
- `app/data/db_connection.py` — Conexión a MySQL
- `app/data/pokemon_db_repository.py` — CRUD con la BD
- `app/domain/pokemon_db_manager.py` — Lógica de negocio para la BD
- `app/ui/db_menu.py` — Interfaz de usuario para el menú CRUD
- `app/ui/main.py` — Menú principal (actualizado)

## Configuración de Conexión

Por defecto, la conexión utiliza:
- **Host**: localhost
- **Puerto**: 3319
- **Usuario**: quevedo
- **Contraseña**: 1234
- **Base de datos**: pokemondb

Si necesitas cambiar estos valores, edita el archivo `app/data/db_connection.py`.

## Notas Técnicas

- El repositorio (`pokemon_db_repository.py`) maneja automáticamente las relaciones 1:N
- Las operaciones de actualización eliminan todos los registros relacionados (cascada) y vuelven a insertarlos
- El manager (`pokemon_db_manager.py`) proporciona una interfaz unificada entre JSON y BD
- Las funcionalidades de consulta de JSON (opciones 1-25) siguen usando el archivo JSON original

## Solución de Problemas

### Error: "No module named 'pymysql'"
- Ejecuta: `pip install -r requirements.txt`

### Error: "No such file or directory: 'pokemondb'"
- La BD no ha sido creada. Ejecuta: `python setup_db.py`

### Error de conexión a MySQL
- Verifica que MySQL está corriendo en el puerto 3319
- Verifica usuario y contraseña en `app/data/db_connection.py`
- Verifica que la BD `pokemondb` existe

### Los pokémons importados no aparecen en la BD
- Usa opción 2 en el menú CRUD para listar
- Verifica que ejecutaste opción 31 para importar
