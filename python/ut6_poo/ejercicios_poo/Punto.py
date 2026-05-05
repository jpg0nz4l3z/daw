import math


class Punto:
    _total_puntos = 0

    def __init__(self, x, y):
        self._x = x
        self._y = y
        Punto._total_puntos += 1

    # Getters y Setters
    @property
    def x(self):
        return self._x

    @x.setter
    def x(self, x):
        self._x = x

    @property
    def y(self):
        return self._y

    @y.setter
    def y(self, y):
        self._y = y

    # Metodo de clase
    @classmethod
    def desde_tupla(cls, tupla):
        """Crea un Punto a partir de una tupla (x, y)."""
        return cls(tupla[0], tupla[1])

    @classmethod
    def get_total_puntos(cls):
        """Devuelve el total de puntos creados."""
        return cls._total_puntos

    # Metodo estatico
    @staticmethod
    def es_origen(x, y):
        """Comprueba si las coordenadas corresponden al origen (0, 0)."""
        return x == 0 and y == 0

    # Metodos del enunciado
    def imprime(self):
        print(f"({self._x}, {self._y})")

    def set_xy(self, x, y):
        self._x = x
        self._y = y

    def desplaza(self, dx, dy):
        self._x += dx
        self._y += dy

    def distancia(self, punto):
        return math.sqrt((punto._x - self._x) ** 2 + (punto._y - self._y) ** 2)


# Clase principal con el metodo main
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

        print("\n\nPrueba de metodos añadidos")
        punto1.imprime()
        punto1.set_xy(6, -1)
        punto1.imprime()
        punto1.desplaza(1, 2)
        punto1.imprime()
        print(punto1.distancia(Punto(3, 4)))

        # Prueba classmethod
        print("\nPrueba classmethod:")
        punto4 = Punto.desde_tupla((8, 3))
        punto4.imprime()
        print(f"Total de puntos creados: {Punto.get_total_puntos()}")

        # Prueba staticmethod
        print("\nPrueba staticmethod:")
        print(f"(0, 0) es origen: {Punto.es_origen(0, 0)}")
        print(f"(3, 4) es origen: {Punto.es_origen(3, 4)}")


Principal.main()
