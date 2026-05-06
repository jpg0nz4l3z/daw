import json
import os
import sys

from domain.model.pokemon import Pokemon
from domain.pokemon_manager import PokemonManager
from domain.pokemon_db_manager import PokemonDBManager
from data.db_connection import connection as db_connection
from ui.db_menu import DBMenu


class Menu:
    """Capa de presentacion: menu interactivo por consola."""

    def __init__(self):
        self.manager = PokemonManager()
        self.db_manager = PokemonDBManager(db_connection)
        self.db_menu = DBMenu(self.db_manager)

    def limpiar_pantalla(self):
        os.system('cls' if os.name == 'nt' else 'clear')

    def pausar(self):
        input("\nPresiona Enter para continuar...")

    def mostrar_menu(self):
        print("=" * 60)
        print("                  POKEDEX - MENU PRINCIPAL")
        print("=" * 60)
        print(" --- Consultas (JSON) ---")
        print("  1.  Listar todos los pokemons")
        print("  2.  Pokemon con id 10")
        print("  3.  Numero de pokemons")
        print("  4.  10 primeros pokemons")
        print("  5.  Pokemon mas pesado")
        print("  6.  Pokemon mas ligero")
        print("  7.  Pokemon con mas evoluciones")
        print("  8.  Pokemon con menos evoluciones")
        print("  9.  Pokemon con mas debilidades")
        print(" 10.  Pokemons electricos")
        print(" 11.  Pikachu")
        print(" 12.  Numero de pokemons por tipo")
        print(" 13.  Debilidades con numero de pokemons")
        print(" 14.  Pokemons electricos debiles a Ground")
        print(" 15.  Pokemons por debilidad (parametrico)")
        print(" 16.  Pokemons sin evoluciones")
        print(" 17.  Pokemons con evolucion previa")
        print(" 18.  Pokemons por tipo secundario (parametrico)")
        print(" 19.  Pokemons leyenda")
        print(" 20.  Top 5 mas pesados")
        print(" 21.  Top 5 mas altos")
        print(" 22.  Pokemons tipo dual")
        print(" 23.  Pokemons por tipo de huevo (parametrico)")
        print(" 24.  Cadenas de evolucion")
        print(" 25.  Pokemons sin debilidades")
        print(" --- Modificaciones en JSON (se guardan automaticamente) ---")
        print(" 26.  Anadir un nuevo pokemon")
        print(" 27.  Cambiar un dato de un pokemon")
        print(" 28.  Sustituir pokemon desde patch_pokemon.json")
        print(" 29.  Eliminar un pokemon")
        print(" --- Base de Datos MySQL ---")
        print(" 31.  Importar pokemons del JSON a la BD")
        print(" 32.  Menu base de datos (CRUD MySQL)")
        print(" 33.  Salir")
        print("=" * 60)

    def listar(self, pokemons):
        if not pokemons:
            print("(sin resultados)")
            return
        for p in pokemons:
            print(p)
        print(f"\nTotal: {len(pokemons)}")

    def ejecutar_menu(self):
        while True:
            self.limpiar_pantalla()
            self.mostrar_menu()
            opcion = input("Selecciona una opcion: ").strip()
            try:
                self.dispatch(opcion)
            except ValueError as e:
                print(f"Entrada invalida: {e}")
            except Exception as e:
                print(f"Error: {e}")
            self.pausar()

    def dispatch(self, opcion: str):
        m = self.manager

        if opcion == '1':
            self.listar(m.listar_todos())

        elif opcion == '2':
            p = m.buscar_por_id(10)
            print(p if p else "Pokemon con id 10 no encontrado")

        elif opcion == '3':
            print(f"Numero total de pokemons: {m.contar()}")

        elif opcion == '4':
            self.listar(m.primeros(10))

        elif opcion == '5':
            print(f"Mas pesado: {m.mas_pesado()}")

        elif opcion == '6':
            print(f"Mas ligero: {m.mas_ligero()}")

        elif opcion == '7':
            p = m.mas_evoluciones()
            print(f"Mas evoluciones ({p.num_evoluciones()}): {p}")

        elif opcion == '8':
            p = m.menos_evoluciones()
            print(f"Menos evoluciones ({p.num_evoluciones()}): {p}")

        elif opcion == '9':
            p = m.mas_debilidades()
            print(f"Mas debilidades ({len(p.weaknesses)}): {p}")
            print(f"Debilidades: {', '.join(p.weaknesses)}")

        elif opcion == '10':
            self.listar(m.por_tipo("Electric"))

        elif opcion == '11':
            p = m.buscar_por_nombre("Pikachu")
            print(p if p else "Pikachu no encontrado")

        elif opcion == '12':
            for k, v in sorted(m.contar_por_tipo().items()):
                print(f"  {k:<10}: {v}")

        elif opcion == '13':
            for k, v in sorted(m.contar_por_debilidad().items()):
                print(f"  {k:<10}: {v}")

        elif opcion == '14':
            self.listar(m.por_tipo_y_debilidad("Electric", "Ground"))

        elif opcion == '15':
            d = input("Debilidad (ej. Fire): ").strip()
            self.listar(m.por_debilidad(d))

        elif opcion == '16':
            self.listar(m.sin_evoluciones())

        elif opcion == '17':
            self.listar(m.con_evolucion_previa())

        elif opcion == '18':
            t = input("Tipo secundario (ej. Flying): ").strip()
            self.listar(m.por_tipo_secundario(t))

        elif opcion == '19':
            self.listar(m.leyendas())

        elif opcion == '20':
            self.listar(m.top_pesados(5))

        elif opcion == '21':
            self.listar(m.top_altos(5))

        elif opcion == '22':
            self.listar(m.tipo_dual())

        elif opcion == '23':
            e = input("Tipo de huevo (ej. '2 km', '5 km', '10 km'): ").strip()
            self.listar(m.por_tipo_huevo(e))

        elif opcion == '24':
            cadenas = m.cadenas_evolucion()
            for candy, ps in cadenas.items():
                print(f"  {candy:<22} -> {' -> '.join(p.name for p in ps)}")
            print(f"\nTotal cadenas: {len(cadenas)}")

        elif opcion == '25':
            self.listar(m.sin_debilidades())

        elif opcion == '26':
            self.crear_pokemon()

        elif opcion == '27':
            self.editar_campo()

        elif opcion == '28':
            self.sustituir_patch()

        elif opcion == '29':
            id = int(input("Id a eliminar: "))
            print("Eliminado" if m.eliminar(id) else "Pokemon no encontrado")

        elif opcion == '31':
            self.importar_a_bd()

        elif opcion == '32':
            self.db_menu.ejecutar_menu()

        elif opcion == '33':
            print("\nHasta luego!")
            sys.exit(0)

        else:
            print("Opcion no valida")

    # --- Helpers de BD ---

    def importar_a_bd(self):
        print("\nImportando pokémons del JSON a la base de datos...")
        try:
            total = self.db_manager.importar_desde_json()
            print(f"✓ Se importaron/actualizaron {total} pokémons en la BD")
        except Exception as e:
            print(f"✗ Error durante la importación: {e}")

    # --- Helpers de modificacion ---

    def crear_pokemon(self):
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
        print(f"Pokemon creado: {nuevo}")

    def editar_campo(self):
        id_ = int(input("Id del pokemon a editar: "))
        actual = self.manager.buscar_por_id(id_)
        if actual is None:
            print("Pokemon no encontrado")
            return
        print(f"Actual: {actual}")
        campo = input("Campo a cambiar (name, weight, height, candy, "
                      "candy_count, egg, spawn_time, types, weaknesses): ").strip()
        valor = input("Nuevo valor: ").strip()

        if campo in ("weight", "height", "spawn_chance", "avg_spawns"):
            valor = float(valor)
        elif campo == "candy_count":
            valor = int(valor) if valor else None
        elif campo == "id":
            valor = int(valor)
        elif campo in ("types", "weaknesses"):
            valor = [v.strip() for v in valor.split(",") if v.strip()]

        if self.manager.actualizar_campo(id_, campo, valor):
            print("Actualizado correctamente")
        else:
            print("No se pudo actualizar (campo invalido o pokemon inexistente)")

    def sustituir_patch(self):
        id_ = int(input("Id del pokemon a sustituir: "))
        ruta = self._ruta_patch()
        if not os.path.exists(ruta):
            self._crear_patch_plantilla(ruta, id_)
            print(f"He creado una plantilla en:\n  {ruta}")
            print("Editala con los datos deseados y vuelve a ejecutar la opcion 28.")
            return
        if self.manager.reemplazar_desde_json(id_, ruta):
            print(f"Pokemon con id {id_} sustituido por los datos de {ruta}")
        else:
            print("Pokemon no encontrado")

    def _ruta_patch(self) -> str:
        # <proyecto>/data/patch_pokemon.json
        base = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
        return os.path.join(base, "data", "patch_pokemon.json")

    def _crear_patch_plantilla(self, ruta: str, id_: int):
        plantilla = {
            "id": id_,
            "num": str(id_).zfill(3),
            "name": "PatchMon",
            "img": "http://example.com/patchmon.png",
            "type": ["Normal"],
            "height": "1.00 m",
            "weight": "10.0 kg",
            "candy": "None",
            "egg": "Not in Eggs",
            "spawn_chance": 0,
            "avg_spawns": 0,
            "spawn_time": "N/A",
            "multipliers": None,
            "weaknesses": ["Fighting"],
        }
        os.makedirs(os.path.dirname(ruta), exist_ok=True)
        with open(ruta, "w", encoding="utf-8") as f:
            json.dump(plantilla, f, ensure_ascii=False, indent=2)
