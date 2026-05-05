from ui.main import Menu


def main():
    """Funcion principal de la aplicacion."""
    print("Iniciando Pokedex App...")
    print("Persistencia en data/pokemons.json con arquitectura por capas\n")
    menu = Menu()
    try:
        menu.ejecutar_menu()
    except KeyboardInterrupt:
        print("\n\nHasta luego!")
    except Exception as e:
        print(f"\nError inesperado: {e}")
        input("Pulsa Enter para salir...")


if __name__ == "__main__":
    main()
