class Articulo:
    _total_articulos = 0

    def __init__(self, nombre, precio, stock):
        self._nombre = nombre
        self._precio = precio
        self._iva = 21
        self._stock = stock
        Articulo._total_articulos += 1

    # Getters y Setters
    @property
    def nombre(self):
        return self._nombre

    @nombre.setter
    def nombre(self, nombre):
        self._nombre = nombre

    @property
    def precio(self):
        return self._precio

    @precio.setter
    def precio(self, precio):
        self._precio = precio

    @property
    def iva(self):
        return self._iva

    @iva.setter
    def iva(self, iva):
        self._iva = iva

    @property
    def stock(self):
        return self._stock

    @stock.setter
    def stock(self, stock):
        self._stock = stock

    # Metodo de clase
    @classmethod
    def con_iva_reducido(cls, nombre, precio, stock):
        """Crea un articulo con IVA reducido del 10%."""
        articulo = cls(nombre, precio, stock)
        articulo._iva = 10
        return articulo

    @classmethod
    def get_total_articulos(cls):
        """Devuelve el total de articulos creados."""
        return cls._total_articulos

    # Metodo estatico
    @staticmethod
    def calcular_iva(precio, iva):
        """Calcula el importe del IVA para un precio y porcentaje dados."""
        return precio * (iva / 100)

    # Metodos del enunciado
    def imprimir(self):
        print(
            f"{self._nombre} - Precio: {self._precio}€ - IVA: {self._iva}% "
            f"- Stock: {self._stock} - PVP: {self.get_pvp():.2f}€"
        )

    def get_pvp(self):
        return self._precio * (1 + self._iva / 100)

    def get_pvp_descuento(self, descuento):
        pvp = self.get_pvp()
        return pvp * (1 - descuento / 100)

    def vender(self, x):
        if x <= self._stock:
            self._stock -= x
            return True
        else:
            return False

    def almacenar(self, x):
        if x > 0:
            self._stock += x
            return True
        else:
            return False


class Principal:
    @staticmethod
    def main():
        articulo = Articulo("Pijama", 10, 50)

        articulo.imprimir()

        print(f"PVP: {articulo.get_pvp()}")
        print(f"PVP con 10% descuento: {articulo.get_pvp_descuento(10)}")

        if articulo.vender(5):
            print("Venta realizada")
        else:
            print("No hay suficiente stock")

        articulo.imprimir()

        articulo.almacenar(20)
        print("Despues de almacenar:")
        articulo.imprimir()

        # Prueba getters y setters
        print(f"\nNombre con getter: {articulo.nombre}")
        articulo.precio = 15
        print(f"Precio cambiado con setter: {articulo.precio}")
        articulo.imprimir()

        # Prueba classmethod
        print("\nPrueba classmethod:")
        leche = Articulo.con_iva_reducido("Leche", 1.20, 100)
        leche.imprimir()
        print(f"Total de articulos creados: {Articulo.get_total_articulos()}")

        # Prueba staticmethod
        print("\nPrueba staticmethod:")
        print(f"IVA de 100€ al 21%: {Articulo.calcular_iva(100, 21)}€")


Principal.main()
