from ui.main import Menu

def main():
    """Función principal de la aplicación"""
    print("🚗🚴 Iniciando Coches CRUD App...")
    print("📁 Usando persistencia en base de datos con arquitectura de capas\n")
    menu = Menu()
    try:
        menu.ejecutar_menu()
    except KeyboardInterrupt:
        print("\n\n👋 ¡Hasta luego!")
    except Exception as e:
        print(f"\n❌ Error inesperado: {e}")
        input("Pulsa Enter para salir...")

if ( __name__ == "__main__" ): 
    main()