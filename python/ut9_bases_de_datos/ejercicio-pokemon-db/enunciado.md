### 1. Enunciado

Dado el fichero `pokemons.json` del directorio `data`, debemos procesarlo y realizar consultas como si de una base de datos se tratara.

### 2. Estructura de Datos

Un **Pokemon** tiene:
- `int id` - Identificador único
- `string num` - Número del pokemon
- `string name` - Nombre del pokemon
- `string img` - URL de la imagen
- `list (string) type` - Tipos del pokemon
- `float height` - Altura en metros
- `float weight` - Peso en kg
- `string candy` - Nombre del candy
- `int candyCount` - Cantidad de candy para evolucionar
- `int egg` - Distancia del huevo
- `float spawnChance` - Probabilidad de aparición
- `float avgSpawns` - Media de apariciones
- `string spawnTime` - Hora de aparición
- `list (float) multipliers` - Multiplicadores
- `list (string) weaknesses` - Debilidades
- `list (Evolution) nextEvolution` - Próximas evoluciones
- `list (Evolution) prevEvolution` - Evolución previa

### 3. Operaciones Requeridas

Deberás realizar las siguientes consultas:

1. Todos los pokemons
2. Pokemon con id 10
3. Número de pokemons
4. 10 primeros pokemons
5. Pokemon más pesado
6. Pokemon más ligero
7. Pokemon con más evoluciones
8. Pokemon con menos evoluciones
9. Pokemon con más debilidades
10. Pokemons eléctricos
11. Pikachu
12. Número de pokemons por tipo
13. Debilidades con número de pokemons
14. Pokemons eléctricos débiles a Ground
15. Pokemons por debilidad
16. Pokemons sin evoluciones
17. Pokemons con evolución previa
18. Pokemons por tipo secundario
19. Pokemons leyenda
20. Top 5 más pesados
21. Top 5 más altos
22. Pokemons tipo dual
23. Pokemons por tipo de huevo
24. Cadenas de evolución
25. Pokemons sin debilidades

... y las siguientes modificaciones:

26. Añade un nuevo pokemon.
27. Cambia algún dato de un pokemon existente.
28. Crea un fichero llamado `patch_pokemon.json` con datos de un pokemon generados por ti. Sustituye los datos de un pokemon existente por los que hay en ese fichero que has creado.
29. Elimina un pokemon.
30. Guarda el archivo actualizado.

### 4. Ficheros

- **Entrada:** `pokemons.json` - Datos de pokemons (151 pokemons de la primera generación)
- **Carpeta data:** Donde se encuentra el fichero JSON

### 5. Requisitos Técnicos

- Estructura limpia y separada en capas
