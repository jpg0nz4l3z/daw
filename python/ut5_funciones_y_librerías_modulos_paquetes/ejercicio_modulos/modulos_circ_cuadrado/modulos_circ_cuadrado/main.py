import sys
import os

sys.path.insert(0, os.path.dirname(__file__))

from paquete import area, cuadrado


def main():
    lado_cuadrado = 3.0
    radio = 5.0

    print(f"El área del cuadrado es: {cuadrado.area(lado_cuadrado)}")
    print(f"El área de la circ. es: {area(radio)}")


if __name__ == "__main__":
    main()
