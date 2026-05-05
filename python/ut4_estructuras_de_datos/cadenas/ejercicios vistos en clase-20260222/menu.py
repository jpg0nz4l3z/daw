def mostrar_menu():
    print("\n-----MENÚ CADENAS-----")
    print("1. Longitud")
    print("2. Concatenar")
    print("3. indexar[]")
    print("4. subcadena[:]")
    print("5. subcadena y paso[::]")
    print("6. lower y upper, capitalize, swapcase")
    print("7. fstring")
    print("8. count, in, isalpha")
    print("0- Salir")


def main():
    cadena = "Esto es una frase"
    print(f"Cadena inicial: {cadena}")
    while True:
        mostrar_menu()
        opcion = int(input("Introduzca opción: "))
        if opcion == 0:
            print("Hasta pronto")
            break
        elif opcion == 1:
            print(f"La longitud de la cadena es: {len(cadena)}")
        elif opcion == 2:
            cadena2 = input("Introduzca palabra: ")
            print("Concatenación de cadenas:")
            print(cadena + cadena2)
        elif opcion == 3:
            cadena2 = cadena[2]
            print("Letra en posición 2: {}".format(cadena2))
        elif opcion == 4:
            cadena2 = cadena[5:10]
            print("Subcadena del 5 al 10: {}".format(cadena2))
        elif opcion == 5:
            cadena2 = cadena[5:10:2]
            print("Subcadena del 5 al 10, de 2 en 2: {}".format(cadena2))
        elif opcion == 6:
            print(cadena.upper())
            print(cadena.lower())
            print(cadena.capitalize())
            print(cadena.swapcase())
        elif opcion == 7:
            numero_pi = 3.14
            cadena2 = f"Esta frase contiene un número pi {numero_pi}"
            print(cadena2)
        elif opcion == 8:
            print(f"cadena tiene {cadena.count('a')} caracteres 'a'")
            if "e" in cadena:
                print("cadena tiene la letra e")
            if "abcde1".isalpha():
                print("cadena abcde es alfabética")
        else:
            print("Opción no válida")


if __name__ == "__main__":
    main()
