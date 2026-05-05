# Escribe un programa que pida números hasta que se introduzca un 0 
# y compruebe que todo son pares, en caso de ser todo pares calculará 
# la media de los mismos, si hay un número impar no lo sumará en la media, 
# y al final del programa también indicará que había algún número impar.
def main():
    suma = 0
    contador = 0
    todo_pares = True

    while True:
        numero = int(input("Introduce un número (0 para terminar): "))
        if numero == 0:
            break
        if numero % 2 != 0:
            todo_pares = False
            print(f"El número {numero} es impar y no se incluirá en la media.")
        else:
            suma += numero
            contador += 1

    if contador > 0:
        media = suma / contador
        print(f"La media de los números pares es: {media:.2f}")
    else:
        print("No se introdujeron números pares para calcular la media.")

    if not todo_pares:
        print("Había al menos un número impar en la entrada.")

if __name__ == "__main__":
    main()