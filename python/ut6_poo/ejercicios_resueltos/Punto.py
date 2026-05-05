import math


class Punto:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def imprime(self):
        print("(", self.x, ",", self.y, ")")

    def set_xy(self, x, y):
        self.x = x
        self.y = y

    def desplaza(self, dx, dy):
        self.x += dx
        self.y += dy

    def distancia(self, punto):
        return math.sqrt((punto.x - self.x) ** 2 + (punto.y - self.y) ** 2)


# Clase principal con el método main
class Principal:
    @staticmethod
    def main():
        punto1 = Punto(5, 0)
        punto2 = Punto(10, 10)
        punto3 = Punto(-3, 7)
        print(f"Punto 1: ({punto1.x}, {punto1.y})")
        print(f"Punto 2: ({punto2.x}, {punto2.y})")
        print(f"Punto 3: ({punto3.x}, {punto3.y})")
        punto1.x += 2
        punto1.y -= 1
        punto2.x *= 2
        punto2.y = punto2.y - 5
        punto3.x = -punto3.x
        punto3.y += 3
        print(f"Nuevo Punto 1: ({punto1.x}, {punto1.y})")
        print(f"Nuevo Punto 2: ({punto2.x}, {punto2.y})")
        print(f"Nuevo Punto 3: ({punto3.x}, {punto3.y})")

        print("\n\nPrueba de métodos añadidos")
        punto1.imprime()
        punto1.set_xy(6, -1)
        punto1.imprime()
        punto1.desplaza(1, 2)
        punto1.imprime()
        print(punto1.distancia(Punto(3, 4)))


Principal.main()
