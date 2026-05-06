from domain.model.pokemon import Pokemon
from data.pokemon_db_repository import PokemonDBRepository
from data.pokemon_repository import PokemonRepository


class PokemonDBManager:
    """Capa de servicio para operaciones CRUD con la base de datos MySQL de pokémons."""

    def __init__(self, db_connection):
        self._db_connection = db_connection
        self._repository = PokemonDBRepository()
        self._json_repository = PokemonRepository()

    def importar_desde_json(self) -> int:
        """Importa todos los pokémons del JSON a la BD. Retorna el número de pokémons importados."""
        pokemons_json = self._json_repository.find_all()
        contador = 0
        for pokemon in pokemons_json:
            if not self._repository.exists_by_id(self._db_connection, pokemon.id):
                self._repository.save(self._db_connection, pokemon)
                contador += 1
            else:
                # Actualizar si ya existe
                self._repository.update(self._db_connection, pokemon.id, pokemon)
                contador += 1
        return contador

    def listar_todos(self) -> list[Pokemon]:
        return self._repository.find_all(self._db_connection)

    def buscar_por_id(self, id: int) -> Pokemon | None:
        return self._repository.find_by_id(self._db_connection, id)

    def buscar_por_nombre(self, nombre: str) -> Pokemon | None:
        return self._repository.find_by_name(self._db_connection, nombre)

    def crear(self, pokemon: Pokemon) -> None:
        self._repository.save(self._db_connection, pokemon)

    def actualizar(self, id: int, pokemon: Pokemon) -> bool:
        return self._repository.update(self._db_connection, id, pokemon)

    def eliminar(self, id: int) -> bool:
        return self._repository.delete(self._db_connection, id)

    def contar(self) -> int:
        return self._repository.count(self._db_connection)
