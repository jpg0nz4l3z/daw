import os
import sys

from domain.model.pokemon import Pokemon
from domain.pokemon_db_manager import PokemonDBManager


class DBMenu:
    """Menú CRUD para operaciones con la base de datos MySQL de pokémons."""

    def __init__(self, db_manager: PokemonDBManager):
        self.manager = db_manager

    def limpiar_pantalla(self):
        os.system('cls' if os.name == 'nt' else 'clear')

    def pausar(self):
        input("\nPresiona Enter para continuar...")

    def mostrar_menu(self):
        print("=" * 60)
        print("             MENÚ BASE DE DATOS - CRUD POKÉMONS")
        print("=" * 60)
        print(" 1. Crear pokemon en BD")
        print(" 2. Listar todos los pokémons de la BD")
        print(" 3. Buscar pokemon por id")
        print(" 4. Buscar pokemon por nombre")
        print(" 5. Modificar pokemon")
        print(" 6. Eliminar pokemon")
        print(" 7. Contar pokémons en BD")
        print(" 8. Volver al menú principal")
        print("=" * 60)

    def ejecutar_menu(self):
        while True:
            self.limpiar_pantalla()
            self.mostrar_menu()
            opcion = input("Selecciona una opción: ").strip()

            try:
                self.dispatch(opcion)
            except ValueError as e:
                print(f"Entrada inválida: {e}")
            except Exception as e:
                print(f"Error: {e}")

            if opcion == '8':
                break

            self.pausar()

    def dispatch(self, opcion: str):
        if opcion == '1':
            self.crear_pokemon()
        elif opcion == '2':
            self.listar_pokémons()
        elif opcion == '3':
            self.buscar_por_id()
        elif opcion == '4':
            self.buscar_por_nombre()
        elif opcion == '5':
            self.modificar_pokemon()
        elif opcion == '6':
            self.eliminar_pokemon()
        elif opcion == '7':
            total = self.manager.contar()
            print(f"\nTotal de pokémons en la BD: {total}")
        elif opcion == '8':
            print("\nVolviendo al menú principal...")
        else:
            print("Opción no válida")

    def crear_pokemon(self):
        print("\n--- Crear pokemon en BD ---")
        id_ = int(input("Id: "))
        if self.manager.buscar_por_id(id_):
            print("Ya existe un pokemon con ese id")
            return
        num = input("Num (ej. '152'): ").strip()
        name = input("Nombre: ").strip()
        img = input("Img URL: ").strip()
        types = [t.strip() for t in input("Tipos (separados por coma): ").split(",") if t.strip()]
        height = float(input("Altura en metros (ej. 1.20): "))
        weight = float(input("Peso en kg (ej. 10.5): "))
        candy = input("Candy (vacio = None): ").strip() or "None"
        cc_raw = input("Candy count (vacio si no aplica): ").strip()
        candy_count = int(cc_raw) if cc_raw else None
        egg = input("Egg (ej. '2 km' o 'Not in Eggs'): ").strip() or "Not in Eggs"
        spawn_chance = float(input("Spawn chance (0-1, vacio=0): ") or 0)
        avg_spawns = float(input("Avg spawns (vacio=0): ") or 0)
        spawn_time = input("Spawn time (ej. '12:00'): ").strip() or "N/A"
        weaknesses = [w.strip() for w in input("Debilidades (separadas por coma): ").split(",") if w.strip()]

        nuevo = Pokemon(
            id=id_, num=num, name=name, img=img, types=types,
            height=height, weight=weight, candy=candy, candy_count=candy_count,
            egg=egg, spawn_chance=spawn_chance, avg_spawns=avg_spawns,
            spawn_time=spawn_time, multipliers=None, weaknesses=weaknesses,
        )
        self.manager.crear(nuevo)
        print(f"✓ Pokemon creado en la BD: {nuevo}")

    def listar_pokémons(self):
        print("\n--- Pokémons en la BD ---")
        pokemons = self.manager.listar_todos()
        if not pokemons:
            print("(sin pokémons en la BD)")
            return
        for p in pokemons:
            print(p)
        print(f"\nTotal: {len(pokemons)}")

    def buscar_por_id(self):
        print("\n--- Buscar pokemon por id ---")
        id_ = int(input("Id a buscar: "))
        p = self.manager.buscar_por_id(id_)
        if p:
            print(f"Encontrado:\n{p}")
        else:
            print("Pokemon no encontrado")

    def buscar_por_nombre(self):
        print("\n--- Buscar pokemon por nombre ---")
        nombre = input("Nombre a buscar: ").strip()
        p = self.manager.buscar_por_nombre(nombre)
        if p:
            print(f"Encontrado:\n{p}")
        else:
            print("Pokemon no encontrado")

    def modificar_pokemon(self):
        print("\n--- Modificar pokemon ---")
        id_ = int(input("Id del pokemon a modificar: "))
        actual = self.manager.buscar_por_id(id_)
        if actual is None:
            print("Pokemon no encontrado")
            return

        print(f"Pokemon actual: {actual}")
        print("\nIngresa los nuevos datos (deja en blanco para mantener el valor actual):")

        num = input(f"Num [{actual.num}]: ").strip() or actual.num
        name = input(f"Nombre [{actual.name}]: ").strip() or actual.name
        img = input(f"Img [{actual.img}]: ").strip() or actual.img
        types_input = input(f"Tipos (separados por coma) [{', '.join(actual.types)}]: ").strip()
        types = [t.strip() for t in types_input.split(",") if t.strip()] if types_input else actual.types
        height = float(input(f"Altura [{actual.height}]: ") or actual.height)
        weight = float(input(f"Peso [{actual.weight}]: ") or actual.weight)
        candy = input(f"Candy [{actual.candy}]: ").strip() or actual.candy
        candy_count_input = input(f"Candy count [{actual.candy_count}]: ").strip()
        candy_count = int(candy_count_input) if candy_count_input else actual.candy_count
        egg = input(f"Egg [{actual.egg}]: ").strip() or actual.egg
        spawn_chance = float(input(f"Spawn chance [{actual.spawn_chance}]: ") or actual.spawn_chance)
        avg_spawns = float(input(f"Avg spawns [{actual.avg_spawns}]: ") or actual.avg_spawns)
        spawn_time = input(f"Spawn time [{actual.spawn_time}]: ").strip() or actual.spawn_time
        weaknesses_input = input(f"Debilidades (separadas por coma) [{', '.join(actual.weaknesses)}]: ").strip()
        weaknesses = [w.strip() for w in weaknesses_input.split(",") if w.strip()] if weaknesses_input else actual.weaknesses

        pokemon_actualizado = Pokemon(
            id=id_, num=num, name=name, img=img, types=types,
            height=height, weight=weight, candy=candy, candy_count=candy_count,
            egg=egg, spawn_chance=spawn_chance, avg_spawns=avg_spawns,
            spawn_time=spawn_time, multipliers=actual.multipliers, weaknesses=weaknesses,
            next_evolution=actual.next_evolution, prev_evolution=actual.prev_evolution
        )

        if self.manager.actualizar(id_, pokemon_actualizado):
            print(f"✓ Pokemon actualizado: {pokemon_actualizado}")
        else:
            print("Error al actualizar el pokemon")

    def eliminar_pokemon(self):
        print("\n--- Eliminar pokemon ---")
        id_ = int(input("Id del pokemon a eliminar: "))
        p = self.manager.buscar_por_id(id_)
        if p is None:
            print("Pokemon no encontrado")
            return

        print(f"Confirmación: ¿Deseas eliminar a {p.name}? (s/n): ", end="")
        if input().strip().lower() == 's':
            if self.manager.eliminar(id_):
                print(f"✓ Pokemon {p.name} eliminado")
            else:
                print("Error al eliminar el pokemon")
        else:
            print("Operación cancelada")
