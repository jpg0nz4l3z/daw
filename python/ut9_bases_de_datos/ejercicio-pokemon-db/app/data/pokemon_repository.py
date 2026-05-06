from domain.model.pokemon import Pokemon
from data import database


class PokemonRepository:
    """Repositorio para gestionar las operaciones CRUD de los pokemons en el JSON."""

    def find_all(self) -> list[Pokemon]:
        return [Pokemon.from_dict(d) for d in database.load()]

    def find_by_id(self, id: int) -> Pokemon | None:
        for d in database.load():
            if d["id"] == id:
                return Pokemon.from_dict(d)
        return None

    def find_by_name(self, name: str) -> Pokemon | None:
        nombre = name.lower()
        for d in database.load():
            if d["name"].lower() == nombre:
                return Pokemon.from_dict(d)
        return None

    def count(self) -> int:
        return len(database.load())

    def exists_by_id(self, id: int) -> bool:
        return any(d["id"] == id for d in database.load())

    def save(self, pokemon: Pokemon) -> None:
        data = database.load()
        data.append(pokemon.to_dict())
        database.save(data)

    def update(self, id: int, pokemon: Pokemon) -> bool:
        data = database.load()
        for i, d in enumerate(data):
            if d["id"] == id:
                nuevo = pokemon.to_dict()
                nuevo["id"] = id
                data[i] = nuevo
                database.save(data)
                return True
        return False

    def delete(self, id: int) -> bool:
        data = database.load()
        nuevos = [d for d in data if d["id"] != id]
        if len(nuevos) == len(data):
            return False
        database.save(nuevos)
        return True
