class Articulo:
    def __init__(self, nombre, precio, stock):
        self.nombre = nombre
        self.precio = precio
        self.iva = 21
        self.stock = stock

    def imprimir(self):
        print(
            f"{self.nombre} - Precio: {self.precio}€ - IVA: {self.iva}% - Stock: {self.stock} - PVP: {self.get_pvp():.2f}€"
        )

    def get_pvp(self):
        return self.precio * (1 + self.iva / 100)

    def get_pvp_descuento(self, descuento):
        pvp = self.get_pvp()
        return pvp * (1 - descuento / 100)

    def vender(self, x):
        if x <= self.stock:
            self.stock -= x
            return True
        else:
            return False

    def almacenar(self, x):
        if x > 0:
            self.stock += x
            return True
        else:
            return False


class Principal:
    @staticmethod
    def main():

        articulo = Articulo("Pijama", 10, 50)

        articulo.imprimir()

        print("PVP:", articulo.get_pvp())
        print("PVP con 10% descuento:", articulo.get_pvp_descuento(10))

        if articulo.vender(5):
            print("Venta realizada")
        else:
            print("No hay suficiente stock")

        articulo.imprimir()

        articulo.almacenar(20)
        print("Después de almacenar:")
        articulo.imprimir()


Principal.main()
