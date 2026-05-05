import sys
import os

from domain.model.coche import Coche
from domain.coche_manager import CocheManager

class Menu:
    def __init__(self):
        self.manager = CocheManager()
    
    def limpiar_pantalla(self):
        """Limpia la pantalla de la consola"""
        os.system('cls' if os.name == 'nt' else 'clear')
    
    def pausar(self):
        """Pausa la ejecución hasta que el usuario presione Enter"""
        input("\nPresiona Enter para continuar...")

    def mostrar_menu(self):
        """Muestra el menú principal"""
        print("=" * 50)
        print("          MENÚ PRINCIPAL")
        print("=" * 50)
        print(" 1. Crear coche")   # C
        print(" 2. Listar coches") # R
        print(" 3. Buscar coche")  # R
        print(" 4. Cambiar coche") # U
        print(" 5. Borrar coche")  # D
        print(" 6. Salir")
        print("=" * 50)

    def ejecutar_menu(self):
        while True:
            self.limpiar_pantalla()
            self.mostrar_menu()
            
            opcion = input("Selecciona una opción: ").strip()

            if opcion == '1': # Crear coche
                matricula :str = input("dime la matricula: ").strip()
                marca :str = input("dime la marca: ").strip()
                modelo :str = input("dime el modelo: ").strip()
                color :str = input("dime el color: ").strip()
                coche_nuevo :Coche = Coche(matricula, marca, modelo, color)
                self.manager.crear_coche(coche_nuevo)
                print("Coche creado")           
            elif opcion == '2': # Listar coches
                coches :list[Coche] = self.manager.listar_coches()
                for coche in coches:
                    print(coche)
            elif opcion == '3': # Buscar coche
                id :int = int(input("dime el id: "))
                coche : Coche = self.manager.buscar_coche(id)
                if coche is None:
                    print("Coche no encontrado")
                else:
                    print(coche)
            elif opcion == '4': # Cambiar coche
                id :int = int(input("dime el id: "))
                coche : Coche = self.manager.buscar_coche(id)
                if coche is None:
                    print("Coche no encontrado")
                else:    
                    matricula :str = input("dime la matricula: ").strip()
                    marca :str = input("dime la marca: ").strip()
                    modelo :str = input("dime el modelo: ").strip()
                    color :str = input("dime el color: ").strip()
                    coche_nuevo :Coche = Coche(matricula, marca, modelo, color)
                    coche :Coche = self.manager.actualizar_coche(id, coche_nuevo)
                    print(coche)
            elif opcion == '5': # Borrar coche
                id :int = int(input("dime el id: "))
                self.manager.borrar_coche(id)
            elif opcion == '6': # Salir 
                print("\n👋 ¡Gracias por usar el programa Vehículos!")
                sys.exit(0)
            else:
                print("❌ Opción no válida. Intenta de nuevo.")
            
            self.pausar()

