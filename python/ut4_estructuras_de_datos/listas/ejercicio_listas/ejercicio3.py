import random
import math


def main():
    posicionLista = int(input("Dame la posición de la lista"))

    intensidadPiedra = input("Dame la intensidad de la piedra")

    lista = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

    for i, elemento in enumerate(lista):
        lista.insert(posicionLista, intensidadPiedra)
        for posicionLista in range(math.abs(posicionLista - 12)):
            print("jeje")


if __name__ == "__main__":
    main()
