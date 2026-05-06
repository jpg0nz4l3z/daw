import json
from collections import Counter

from domain.model.pokemon import Pokemon
from data.pokemon_repository import PokemonRepository


class PokemonManager:
    """Capa de servicio: orquesta consultas y modificaciones sobre los pokemons."""

    def __init__(self):
        self._repository = PokemonRepository()

    # --- Consultas ---

    def listar_todos(self) -> list[Pokemon]:
        return self._repository.find_all()

    def buscar_por_id(self, id: int) -> Pokemon | None:
        return self._repository.find_by_id(id)

    def buscar_por_nombre(self, nombre: str) -> Pokemon | None:
        return self._repository.find_by_name(nombre)

    def contar(self) -> int:
        return self._repository.count()

    def primeros(self, n: int) -> list[Pokemon]:
        return self._repository.find_all()[:n]

    def mas_pesado(self) -> Pokemon:
        return max(self._repository.find_all(), key=lambda p: p.weight)

    def mas_ligero(self) -> Pokemon:
        return min(self._repository.find_all(), key=lambda p: p.weight)

    def mas_evoluciones(self) -> Pokemon:
        return max(self._repository.find_all(), key=lambda p: p.num_evoluciones())

    def menos_evoluciones(self) -> Pokemon:
        return min(self._repository.find_all(), key=lambda p: p.num_evoluciones())

    def mas_debilidades(self) -> Pokemon:
        return max(self._repository.find_all(), key=lambda p: len(p.weaknesses))

    def por_tipo(self, tipo: str) -> list[Pokemon]:
        t = tipo.lower()
        return [p for p in self._repository.find_all()
                if any(x.lower() == t for x in p.types)]

    def contar_por_tipo(self) -> dict:
        c = Counter()
        for p in self._repository.find_all():
            for t in p.types:
                c[t] += 1
        return dict(c)

    def contar_por_debilidad(self) -> dict:
        c = Counter()
        for p in self._repository.find_all():
            for w in p.weaknesses:
                c[w] += 1
        return dict(c)

    def por_tipo_y_debilidad(self, tipo: str, debilidad: str) -> list[Pokemon]:
        d = debilidad.lower()
        return [p for p in self.por_tipo(tipo)
                if any(w.lower() == d for w in p.weaknesses)]

    def por_debilidad(self, debilidad: str) -> list[Pokemon]:
        d = debilidad.lower()
        return [p for p in self._repository.find_all()
                if any(w.lower() == d for w in p.weaknesses)]

    def sin_evoluciones(self) -> list[Pokemon]:
        return [p for p in self._repository.find_all() if p.num_evoluciones() == 0]

    def con_evolucion_previa(self) -> list[Pokemon]:
        return [p for p in self._repository.find_all() if p.prev_evolution]

    def por_tipo_secundario(self, tipo: str) -> list[Pokemon]:
        t = tipo.lower()
        return [p for p in self._repository.find_all()
                if p.tipo_secundario() and p.tipo_secundario().lower() == t]

    def leyendas(self) -> list[Pokemon]:
        return [p for p in self._repository.find_all() if p.es_legendario()]

    def top_pesados(self, n: int = 5) -> list[Pokemon]:
        return sorted(self._repository.find_all(), key=lambda p: p.weight, reverse=True)[:n]

    def top_altos(self, n: int = 5) -> list[Pokemon]:
        return sorted(self._repository.find_all(), key=lambda p: p.height, reverse=True)[:n]

    def tipo_dual(self) -> list[Pokemon]:
        return [p for p in self._repository.find_all() if p.es_dual()]

    def por_tipo_huevo(self, egg: str) -> list[Pokemon]:
        return [p for p in self._repository.find_all() if p.egg == egg]

    def cadenas_evolucion(self) -> dict:
        chains: dict = {}
        for p in self._repository.find_all():
            if p.candy and p.candy != "None":
                chains.setdefault(p.candy, []).append(p)
        return {c: ordenados(ps) for c, ps in chains.items() if len(ps) > 1}

    def sin_debilidades(self) -> list[Pokemon]:
        return [p for p in self._repository.find_all() if not p.weaknesses]

    # --- Modificaciones ---

    def crear(self, pokemon: Pokemon) -> None:
        self._repository.save(pokemon)

    def actualizar_campo(self, id: int, campo: str, valor) -> bool:
        p = self._repository.find_by_id(id)
        if p is None or not hasattr(p, campo):
            return False
        setattr(p, campo, valor)
        return self._repository.update(id, p)

    def reemplazar_desde_json(self, id: int, ruta: str) -> bool:
        with open(ruta, "r", encoding="utf-8") as f:
            data = json.load(f)
        nuevo = Pokemon.from_dict(data)
        return self._repository.update(id, nuevo)

    def eliminar(self, id: int) -> bool:
        return self._repository.delete(id)


def ordenados(pokemons: list[Pokemon]) -> list[Pokemon]:
    """Ordena pokemons por id ascendente (orden natural de la cadena)."""
    return sorted(pokemons, key=lambda p: p.id)
