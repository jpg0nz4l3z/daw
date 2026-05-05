class Rectangulo:
    _total_rectangulos = 0

    def __init__(self, x1, y1, x2, y2):
        if x1 < x2 and y1 < y2:
            self._x1 = x1
            self._y1 = y1
            self._x2 = x2
            self._y2 = y2
        else:
            self._x1 = x1
            self._y1 = y1
            self._x2 = x1
            self._y2 = y1
        Rectangulo._total_rectangulos += 1

    # Getters y Setters
    @property
    def x1(self):
        return self._x1

    @x1.setter
    def x1(self, x1):
        self._x1 = x1

    @property
    def y1(self):
        return self._y1

    @y1.setter
    def y1(self, y1):
        self._y1 = y1

    @property
    def x2(self):
        return self._x2

    @x2.setter
    def x2(self, x2):
        self._x2 = x2

    @property
    def y2(self):
        return self._y2

    @y2.setter
    def y2(self, y2):
        self._y2 = y2

    # Metodo de clase
    @classmethod
    def desde_origen(cls, ancho, alto):
        """Crea un rectangulo desde el origen (0,0) con el ancho y alto indicados."""
        return cls(0, 0, ancho, alto)

    @classmethod
    def get_total_rectangulos(cls):
        """Devuelve el total de rectangulos creados."""
        return cls._total_rectangulos

    # Metodo estatico
    @staticmethod
    def es_cuadrado(x1, y1, x2, y2):
        """Comprueba si las coordenadas forman un cuadrado."""
        return abs(x2 - x1) == abs(y2 - y1)

    # Metodos del enunciado
    def imprimir(self):
        print(
            f"x1: {self._x1}\ny1: {self._y1}\n"
            f"x2: {self._x2}\ny2: {self._y2}"
        )

    def set_x1y1(self, x1, y1):
        if x1 < self._x2 and y1 < self._y2:
            self._x1 = x1
            self._y1 = y1

    def set_x2y2(self, x2, y2):
        if x2 > self._x1 and y2 > self._y1:
            self._x2 = x2
            self._y2 = y2

    def set_all(self, x1, y1, x2, y2):
        if x1 < x2 and y1 < y2:
            self._x1 = x1
            self._y1 = y1
            self._x2 = x2
            self._y2 = y2
        else:
            self._x1 = x1
            self._y1 = y1
            self._x2 = x1
            self._y2 = y1

    def get_perimetro(self):
        return 2 * (abs(self._x2 - self._x1) + abs(self._y2 - self._y1))

    def get_area(self):
        return abs(self._x2 - self._x1) * abs(self._y2 - self._y1)


class Principal:
    @staticmethod
    def main():
        rect1 = Rectangulo(0, 0, 5, 5)
        rect2 = Rectangulo(7, 9, 2, 3)

        print(
            f"Rectangulo 1: ({rect1.x1}, {rect1.y1}), ({rect1.x2}, {rect1.y2}), "
            f"Perimetro: {rect1.get_perimetro()}, Area: {rect1.get_area()}"
        )
        print(
            f"Rectangulo 2: ({rect2.x1}, {rect2.y1}), ({rect2.x2}, {rect2.y2}), "
            f"Perimetro: {rect2.get_perimetro()}, Area: {rect2.get_area()}"
        )

        rect1.x1 += 1
        rect1.y1 += 1
        rect1.x2 += 1
        rect1.y2 += 1

        rect2.x1 -= 1
        rect2.y1 -= 1
        rect2.x2 -= 1
        rect2.y2 -= 1

        print(
            f"Nuevo Rectangulo 1: ({rect1.x1}, {rect1.y1}), ({rect1.x2}, {rect1.y2}), "
            f"Perimetro: {rect1.get_perimetro()}, Area: {rect1.get_area()}"
        )
        print(
            f"Nuevo Rectangulo 2: ({rect2.x1}, {rect2.y1}), ({rect2.x2}, {rect2.y2}), "
            f"Perimetro: {rect2.get_perimetro()}, Area: {rect2.get_area()}"
        )

        print("\n\nTesteando metodos nuevos")
        rect1.imprimir()
        rect1.set_x1y1(2, 3)
        print()
        rect1.imprimir()
        rect1.set_all(1, 1, 6, 6)
        print()
        rect1.imprimir()
        print(f"\nPerimetro: {rect1.get_perimetro()}")
        print(f"Area: {rect1.get_area()}")

        # Prueba classmethod
        print("\nPrueba classmethod:")
        rect3 = Rectangulo.desde_origen(10, 5)
        rect3.imprimir()
        print(f"Total de rectangulos creados: {Rectangulo.get_total_rectangulos()}")

        # Prueba staticmethod
        print("\nPrueba staticmethod:")
        print(f"(0,0)-(5,5) es cuadrado: {Rectangulo.es_cuadrado(0, 0, 5, 5)}")
        print(f"(0,0)-(5,3) es cuadrado: {Rectangulo.es_cuadrado(0, 0, 5, 3)}")


Principal.main()
