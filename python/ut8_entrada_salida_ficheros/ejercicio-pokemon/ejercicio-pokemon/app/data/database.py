import json
import os

# Ruta absoluta al fichero JSON situado en <proyecto>/data/pokemons.json
_BASE_DIR = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
JSON_PATH = os.path.join(_BASE_DIR, "data", "pokemons.json")


def load() -> list[dict]:
    """Carga la lista de pokemons (lista de dicts) desde el fichero JSON."""
    with open(JSON_PATH, "r", encoding="utf-8") as f:
        contenido = json.load(f)
    return contenido.get("pokemon", [])


def save(pokemons: list[dict]) -> None:
    """Guarda la lista de pokemons en el fichero JSON, manteniendo el formato."""
    with open(JSON_PATH, "w", encoding="utf-8") as f:
        json.dump({"pokemon": pokemons}, f, ensure_ascii=False, indent=2)
