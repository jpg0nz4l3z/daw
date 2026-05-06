from domain.model.pokemon import Pokemon
from domain.model.evolution import Evolution


class PokemonDBRepository:
    """Repositorio para gestionar las operaciones CRUD de los pokémons en MySQL."""

    def find_all(self, conn) -> list[Pokemon]:
        with conn.cursor() as cursor:
            cursor.execute("SELECT * FROM pokemon ORDER BY id")
            pokemons_data = cursor.fetchall()

        pokemons = []
        for data in pokemons_data:
            p = self._build_pokemon_from_row(conn, data)
            pokemons.append(p)
        return pokemons

    def find_by_id(self, conn, id: int) -> Pokemon | None:
        with conn.cursor() as cursor:
            cursor.execute("SELECT * FROM pokemon WHERE id = %s", (id,))
            row = cursor.fetchone()

        if row:
            return self._build_pokemon_from_row(conn, row)
        return None

    def find_by_name(self, conn, name: str) -> Pokemon | None:
        with conn.cursor() as cursor:
            cursor.execute("SELECT * FROM pokemon WHERE name = %s", (name,))
            row = cursor.fetchone()

        if row:
            return self._build_pokemon_from_row(conn, row)
        return None

    def save(self, conn, pokemon: Pokemon) -> None:
        with conn.cursor() as cursor:
            cursor.execute(
                """INSERT INTO pokemon
                   (id, num, name, img, height, weight, candy, candy_count, egg, spawn_chance, avg_spawns, spawn_time)
                   VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)""",
                (pokemon.id, pokemon.num, pokemon.name, pokemon.img, pokemon.height, pokemon.weight,
                 pokemon.candy, pokemon.candy_count, pokemon.egg, pokemon.spawn_chance,
                 pokemon.avg_spawns, pokemon.spawn_time)
            )

            # Insertar tipos
            for type_name in pokemon.types:
                cursor.execute(
                    "INSERT INTO pokemon_type (pokemon_id, type_name) VALUES (%s, %s)",
                    (pokemon.id, type_name)
                )

            # Insertar debilidades
            for weakness in pokemon.weaknesses:
                cursor.execute(
                    "INSERT INTO pokemon_weakness (pokemon_id, weakness_name) VALUES (%s, %s)",
                    (pokemon.id, weakness)
                )

            # Insertar multiplicadores
            if pokemon.multipliers:
                for multiplier in pokemon.multipliers:
                    cursor.execute(
                        "INSERT INTO pokemon_multiplier (pokemon_id, multiplier) VALUES (%s, %s)",
                        (pokemon.id, multiplier)
                    )

            # Insertar evoluciones siguientes
            for evolution in pokemon.next_evolution:
                cursor.execute(
                    "INSERT INTO pokemon_evolution (pokemon_id, direction, evolution_num, evolution_name) VALUES (%s, %s, %s, %s)",
                    (pokemon.id, 'next', evolution.num, evolution.name)
                )

            # Insertar evoluciones previas
            for evolution in pokemon.prev_evolution:
                cursor.execute(
                    "INSERT INTO pokemon_evolution (pokemon_id, direction, evolution_num, evolution_name) VALUES (%s, %s, %s, %s)",
                    (pokemon.id, 'prev', evolution.num, evolution.name)
                )

        conn.commit()

    def update(self, conn, id: int, pokemon: Pokemon) -> bool:
        exists = self.exists_by_id(conn, id)
        if not exists:
            return False

        # Eliminar el pokemon actual (cascada eliminará tipos, debilidades, etc.)
        self.delete(conn, id)

        # Insertar el pokemon actualizado con el mismo id
        pokemon.id = id
        self.save(conn, pokemon)
        return True

    def delete(self, conn, id: int) -> bool:
        with conn.cursor() as cursor:
            cursor.execute("DELETE FROM pokemon WHERE id = %s", (id,))
        conn.commit()
        return True

    def count(self, conn) -> int:
        with conn.cursor() as cursor:
            cursor.execute("SELECT COUNT(*) as total FROM pokemon")
            result = cursor.fetchone()
        return result['total'] if result else 0

    def exists_by_id(self, conn, id: int) -> bool:
        with conn.cursor() as cursor:
            cursor.execute("SELECT 1 FROM pokemon WHERE id = %s", (id,))
            return cursor.fetchone() is not None

    def _build_pokemon_from_row(self, conn, row) -> Pokemon:
        """Construye un objeto Pokemon a partir de una fila de la BD, obteniendo tipos, debilidades, etc."""
        pokemon_id = row['id']

        # Obtener tipos
        with conn.cursor() as cursor:
            cursor.execute("SELECT type_name FROM pokemon_type WHERE pokemon_id = %s ORDER BY id", (pokemon_id,))
            types = [r['type_name'] for r in cursor.fetchall()]

        # Obtener debilidades
        with conn.cursor() as cursor:
            cursor.execute("SELECT weakness_name FROM pokemon_weakness WHERE pokemon_id = %s ORDER BY id", (pokemon_id,))
            weaknesses = [r['weakness_name'] for r in cursor.fetchall()]

        # Obtener multiplicadores
        with conn.cursor() as cursor:
            cursor.execute("SELECT multiplier FROM pokemon_multiplier WHERE pokemon_id = %s ORDER BY id", (pokemon_id,))
            multipliers = [r['multiplier'] for r in cursor.fetchall()]

        # Obtener evoluciones siguientes
        with conn.cursor() as cursor:
            cursor.execute(
                "SELECT evolution_num, evolution_name FROM pokemon_evolution WHERE pokemon_id = %s AND direction = 'next' ORDER BY id",
                (pokemon_id,)
            )
            next_evolutions = [Evolution(r['evolution_num'], r['evolution_name']) for r in cursor.fetchall()]

        # Obtener evoluciones previas
        with conn.cursor() as cursor:
            cursor.execute(
                "SELECT evolution_num, evolution_name FROM pokemon_evolution WHERE pokemon_id = %s AND direction = 'prev' ORDER BY id",
                (pokemon_id,)
            )
            prev_evolutions = [Evolution(r['evolution_num'], r['evolution_name']) for r in cursor.fetchall()]

        return Pokemon(
            id=row['id'],
            num=row['num'],
            name=row['name'],
            img=row['img'],
            types=types,
            height=row['height'],
            weight=row['weight'],
            candy=row['candy'],
            candy_count=row['candy_count'],
            egg=row['egg'],
            spawn_chance=row['spawn_chance'],
            avg_spawns=row['avg_spawns'],
            spawn_time=row['spawn_time'],
            multipliers=multipliers if multipliers else None,
            weaknesses=weaknesses,
            next_evolution=next_evolutions,
            prev_evolution=prev_evolutions
        )
