class Rectangulo:
    def __init__(self, x1, y1, x2, y2):
        if x1 < x2 and y1 < y2:
            self.x1 = x1
            self.y1 = y1
            self.x2 = x2
            self.y2 = y2
        else:
            self.x1 = x1
            self.y1 = y1
            self.x2 = x1
            self.y2 = y1

    def perimetro(self):
        return 2 * (abs(self.x2 - self.x1) + abs(self.y2 - self.y1))

    def area(self):
        return abs(self.x2 - self.x1) * abs(self.y2 - self.y1)

    def imprimir(self):
        print("x1: ", self.x1, "\ny1: ", self.y1, "\nx2: ", self.x2, "\ny2: ", self.y2)

    def set_x1y1(self, x1, y1):
        if x1 < self.x2 and y1 < self.y2:
            self.x1 = x1
            self.y1 = y1

    def set_x2y2(self, x2, y2):
        if x2 > self.x1 and y2 > self.y1:
            self.x2 = x2
            self.y2 = y2

    def set_all(self, x1, y1, x2, y2):
        if x1 < x2 and y1 < y2:
            self.x1 = x1
            self.y1 = y1
            self.x2 = x2
            self.y2 = y2
        else:
            self.x1 = x1
            self.y1 = y1
            self.x2 = x1
            self.y2 = y1


class Principal:
    @staticmethod
    def main():

        rect1 = Rectangulo(0, 0, 5, 5)
        rect2 = Rectangulo(7, 9, 2, 3)

        print(
            f"Rectángulo 1: ({rect1.x1}, {rect1.y1}), ({rect1.x2}, {rect1.y2}), Perímetro: {rect1.perimetro()}, Área: {rect1.area()}"
        )
        print(
            f"Rectángulo 2: ({rect2.x1}, {rect2.y1}), ({rect2.x2}, {rect2.y2}), Perímetro: {rect2.perimetro()}, Área: {rect2.area()}"
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
            f"Nuevo Rectángulo 1: ({rect1.x1}, {rect1.y1}), ({rect1.x2}, {rect1.y2}), Perímetro: {rect1.perimetro()}, Área: {rect1.area()}"
        )
        print(
            f"Nuevo Rectángulo 2: ({rect2.x1}, {rect2.y1}), ({rect2.x2}, {rect2.y2}), Perímetro: {rect2.perimetro()}, Área: {rect2.area()}"
        )

        print("\n\nTesteando métodos nuevos")
        rect1.imprimir()
        rect1.set_x1y1(2, 3)
        print("\n")
        rect1.imprimir()
        rect1.set_x1y1(2, 3)
        print("\n")
        rect1.imprimir()
        rect1.set_all(4, 2, 6, 2)
        print("\n")
        rect1.imprimir()
        print("\n")
        print("perímetro :", rect1.perimetro())
        print("área :", rect1.area())


Principal.main()
