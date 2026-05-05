import random


def mostrar_menu():
    print("\n" + "=" * 40)
    print("      MENÚ DE GESTIÓN DE LISTAS")
    print("=" * 40)
    print("1.  Crear lista1 (números, tamaño usuario)")
    print("2.  Crear lista2 (nombres, tamaño usuario)")
    print("3.  Crear lista3 (aleatoria)")
    print("4.  Mostrar listas")
    print("5.  Añadir elemento (a elegir lista)")
    print("6.  Añadir a lista1 con RANGO (10-100)")
    print("7.  Consultar elemento por posición (lista2)")
    print("8.  Consultar si existe elemento (lista1)")
    print("9.  Contar apariciones de un elemento")
    print("10. Consultar tamaño de una lista")
    print("11. Buscar posición de un nombre (lista2)")
    print("12. Insertar elemento en posición dada (lista2)")
    print("13. Añadir al final de lista1")
    print("14. Eliminar por nombre (lista2)")
    print("15. Eliminar por posición (lista1)")
    print("16. Vaciar lista (clear)")
    print("17. Ordenar lista (sort)")
    print("18. Dar vuelta a lista2 (reverse)")
    print("0.  Salir")
    print("=" * 40)


def main():
    lista1 = []
    lista2 = []
    lista3 = []
    while True:
        mostrar_menu()
        opcion = input("--> Elige una opción: ")

        if opcion == "1":
            lista1 = []
            try:
                n = int(input("¿Cuántos números quieres en la lista 1?: "))
                for i in range(n):
                    num = int(input(f"Introduce número {i+1}: "))
                    lista1.append(num)
                print("Lista 1 creada exitosamente.")
            except ValueError:
                print("¡Error! Debes introducir un número entero.")

        elif opcion == "2":
            lista2 = []
            try:
                n = int(input("¿Cuántos nombres quieres en la lista 2?: "))
                for i in range(n):
                    nom = input(f"Introduce nombre {i+1}: ")
                    lista2.append(nom)
                print("Lista 2 creada exitosamente.")
            except ValueError:
                print("¡Error! El tamaño debe ser un número.")

        elif opcion == "3":
            lista3 = []
            tamano = random.randint(1, 10)
            print(f"Creando lista3 con tamaño aleatorio: {tamano}")
            for _ in range(tamano):
                lista3.append(random.randint(0, 100))
            print("Lista 3 generada aleatoriamente.")

        elif opcion == "4":
            cual = input("¿Qué lista quieres ver? (1, 2, 3 o T para todas): ").upper()
            if cual == "1":
                print(f"Lista 1: {lista1}")
            elif cual == "2":
                print(f"Lista 2: {lista2}")
            elif cual == "3":
                print(f"Lista 3: {lista3}")
            elif cual == "T":
                print(f"Lista 1: {lista1}")
                print(f"Lista 2: {lista2}")
                print(f"Lista 3: {lista3}")
            else:
                print("Opción no válida.")

        elif opcion == "5":
            destino = input("¿Añadir a lista 1 o lista 2?:")
            if destino == "1":
                elem = int(input("Introduce el número a añadir: "))
                lista1.append(elem)
            elif destino == "2":
                elem = input("Introduce el nombre a añadir: ")
                lista2.append(elem)
            else:
                print("Lista incorrecta.")

        elif opcion == "6":
            print("Añadiendo a Lista 1 con control (10 - 100)...")
            while True:
                try:
                    num = int(input("Introduce un número entre 10 y 100: "))
                    if 10 <= num <= 100:
                        lista1.append(num)
                        print("Número aceptado y añadido.")
                        break
                    else:
                        print("Fuera de rango. Inténtalo de nuevo.")
                except ValueError:
                    print("Dato no válido.")

        elif opcion == "7":
            try:
                pos = int(input(f"Introduce posición (0 a {len(lista2)-1}): "))
                if 0 <= pos < len(lista2):
                    print(f"El elemento en posición {pos} es: {lista2[pos]}")
                else:
                    print("Error: Posición fuera de los límites.")
            except ValueError:
                print("La posición debe ser un número.")

        elif opcion == "8":
            buscar = int(input("¿Qué número buscas en lista 1?: "))
            if buscar in lista1:
                print(f"¡Sí! El número {buscar} ESTÁ en la lista 1.")
            else:
                print(f"El número {buscar} NO está en la lista 1.")

        elif opcion == "9":
            cual = input("¿En qué lista buscar? (1, 2 o 3): ")
            if cual == "1":
                v = int(input("Valor a contar: "))
                print(f"Aparece {lista1.count(v)} veces.")
            elif cual == "2":
                v = input("Nombre a contar: ")
                print(f"Aparece {lista2.count(v)} veces.")
            elif cual == "3":
                v = int(input("Valor a contar: "))
                print(f"Aparece {lista3.count(v)} veces.")

        elif opcion == "10":
            cual = input("¿De qué lista quieres saber el tamaño? (1 , 2 o 3): ")
            if cual == "1":
                print(f"Tamaño lista 1: {len(lista1)}")
            elif cual == "2":
                print(f"Tamaño lista 2: {len(lista2)}")
            elif cual == "3":
                print(f"Tamaño lista 3: {len(lista3)}")

        elif opcion == "11":
            buscado = input("¿Qué nombre buscas en lista 2?: ")
            if buscado in lista2:
                print(
                    f"El nombre '{buscado}' está en el índice: {lista2.index(buscado)}"
                )
            else:
                print("Ese nombre no existe en la lista.")

        elif opcion == "12":
            elem = input("Nuevo nombre a insertar: ")
            try:
                pos = int(input("¿En qué posición?: "))
                lista2.insert(pos, elem)
                print("Insertado correctamente.")
            except ValueError:
                print("Posición no válida.")

        elif opcion == "13":
            try:
                val = int(input("Valor a añadir al final de lista 1: "))
                lista1.append(val)
                print("Añadido.")
            except ValueError:
                print("Debe ser número.")

        elif opcion == "14":
            borrar = input("Nombre a eliminar de lista 2: ")
            if borrar in lista2:
                lista2.remove(borrar)
                print("Eliminado.")
            else:
                print("El elemento no estaba en la lista.")

        elif opcion == "15":
            try:
                pos = int(
                    input(f"Posición a eliminar en lista 1 (0-{len(lista1)-1}): ")
                )
                if 0 <= pos < len(lista1):
                    eliminado = lista1.pop(pos)
                    print(f"Se ha eliminado el valor: {eliminado}")
                else:
                    print("Posición inválida.")
            except ValueError:
                print("Error en el número.")

        elif opcion == "16":
            cual = input("¿Qué lista vaciar? (1, 2 o 3): ")
            if cual == "1":
                lista1.clear()
            elif cual == "2":
                lista2.clear()
            elif cual == "3":
                lista3.clear()
            print("Lista vaciada (ahora está []).")

        elif opcion == "17":
            cual = input("¿Qué lista ordenar? (1, 2 o 3): ")
            if cual == "1":
                lista1.sort()
            elif cual == "2":
                lista2.sort()
            elif cual == "3":
                lista3.sort()
            print("Lista ordenada.")

        elif opcion == "18":
            lista2.reverse()
            print("Lista 2 invertida.")

        elif opcion == "0":
            print("Saliendo del programa...")
            break

        else:
            print("Opción no reconocida, intenta de nuevo.")


if __name__ == "__main__":
    main()
