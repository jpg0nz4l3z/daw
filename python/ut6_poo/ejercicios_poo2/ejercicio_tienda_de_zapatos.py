IVA = 1.21

class Zapatillas:
    def __init__(self, marca=None, numero=None, color="Rojo", precio=0, stock=0):
        self._marca = str(marca).upper()
        self._numero = numero
        self._color = str(color).upper()
        self._precio = precio
        self._stock = stock

    @property
    def marca(self):
        return self._marca

    @marca.setter
    def marca(self, valor):
        self._marca = str(valor).upper()

    @property
    def numero(self):
        return self._numero

    @numero.setter
    def numero(self, valor):
        self._numero = valor

    @property
    def color(self):
        return self._color

    @color.setter
    def color(self, valor):
        self._color = str(valor).upper()

    @property
    def precio(self):
        return self._precio

    @precio.setter
    def precio(self, valor):
        self._precio = valor

    @property
    def stock(self):
        return self._stock

    @stock.setter
    def stock(self, valor):
        self._stock = valor

    def __str__(self):
        return f"Zapatilla {self._marca} ({self._numero}-{self._color})"

    def modificar(self, marca=None, numero=None, color="Rojo", precio=0, stock=0):
        self._marca = marca if marca is not None else self._marca
        self._numero = numero
        self._color = color
        self._precio = precio
        self._stock = stock


class Persona:
    def __init__(self):
        self._nombre = None
        self._direccion = None

    @property
    def nombre(self):
        return self._nombre

    @nombre.setter
    def nombre(self, valor):
        self._nombre = valor

    @property
    def direccion(self):
        return self._direccion

    @direccion.setter
    def direccion(self, valor):
        self._direccion = valor

    def __str__(self):
        return f"{self._nombre} ({self._direccion})"


class Comprador(Persona):
    def __init__(self, n, d, t, em="dir@dir.com"):
        super().__init__()
        self.nombre = str(n).upper()
        self.direccion = str(d).upper()
        self._tlf = t
        self._email = str(em).upper()

    @property
    def tlf(self):
        return self._tlf

    @tlf.setter
    def tlf(self, valor):
        self._tlf = valor

    @property
    def email(self):
        return self._email

    @email.setter
    def email(self, valor):
        self._email = str(valor).upper()

    def __str__(self):
        return f"{self.nombre} ({self.direccion}) - [{self._tlf} - {self._email}]"

    def modificar(self, n, d, t, em):
        self.nombre = n if n is not None else self.nombre
        self.direccion = d if d is not None else self.direccion
        self._tlf = t if t is not None else self._tlf
        self._email = em if em is not None else self._email


class Vendedor(Persona):
    def __init__(self, n, d, dn):
        super().__init__()
        self.nombre = n
        self.direccion = d
        self._dni = dn

    @property
    def dni(self):
        return self._dni

    @dni.setter
    def dni(self, valor):
        self._dni = valor

    def __str__(self):
        return f"{self.nombre} ({self.direccion}) - [{self._dni}]"

    def modificar(self, n, d, dn):
        self.nombre = n if n is not None else self.nombre
        self.direccion = d if d is not None else self.direccion
        self._dni = dn if dn is not None else self._dni


class Compra:
    def __init__(self):
        self._comprador = None
        self._vendedor = None
        self._lineas_compra = []  # Zapatillas

    @property
    def comprador(self):
        return self._comprador

    @comprador.setter
    def comprador(self, c):
        if isinstance(c, Comprador):
            self._comprador = c

    @property
    def vendedor(self):
        return self._vendedor

    @vendedor.setter
    def vendedor(self, v):
        if isinstance(v, Vendedor):
            self._vendedor = v

    # Ejercicio 7: add_linea modificado con gestion de stock y validacion
    def add_linea(self, z, cantidad=1):
        if type(z) is Zapatillas:
            # 7.2 Validacion: no permitir si stock < cantidad solicitada
            if z.stock < cantidad:
                print(f"Error: stock insuficiente para '{z}'. "
                      f"Stock disponible: {z.stock}, solicitado: {cantidad}.")
                return
            # 7.1 Gestion de stock: reducir stock del inventario
            z.stock -= cantidad
            linea = Zapatillas(z.marca, z.numero, z.color, z.precio, cantidad)
            self._lineas_compra.append(linea)

    @property
    def num_lineas(self):
        return len(self._lineas_compra)

    @property
    def _total_a_pagar(self):
        total = 0
        for linea in self._lineas_compra:
            total += linea.precio * linea.stock
        return total

    def pagar(self):
        pagado = False
        total_a_pagar = self._total_a_pagar * IVA
        # conectarse a tpv
        # esperar respuesta tpv correcta
        # responder en funcion de respuesta tpv
        # modificar pagado en funcion de la respuesta
        return pagado, total_a_pagar

    def crear_factura(self):
        texto_factura = "FACTURA \n"
        texto_factura += " No 32479342\n"
        texto_factura += "=" * 50 + "\n"
        for linea in self._lineas_compra:
            texto_factura += str(linea) + " --> " + str(linea.precio * linea.stock) + "\n"
        texto_factura += "-" * 50 + "\n"
        texto_factura += "Total:" + str(self._total_a_pagar)
        return texto_factura



# Clase App - Ejercicios a realizar
class App:
    def main(self):

        # EJERCICIO 1: Clase Zapatillas

        # 1.1 Creacion de objetos
        print("=" * 50)
        print("EJERCICIO 1: Clase Zapatillas")
        print("=" * 50)

        print("\n1.1 Creacion de 3 instancias de Zapatillas:")
        z1 = Zapatillas("adidas", 45, "Azul", 30, 5)
        z2 = Zapatillas("nike", 42, "Negro", 55.99, 10)
        z3 = Zapatillas("puma", 38, "Blanco", 40, 3)
        print(f"  z1: {z1}")
        print(f"  z2: {z2}")
        print(f"  z3: {z3}")

        # 1.2 Modificar atributos
        print("\n1.2 Modificar precio y stock de z1:")
        print(f"  Antes  -> {z1} | Precio: {z1.precio} | Stock: {z1.stock}")
        z1.modificar(precio=25, stock=8)
        print(f"  Despues -> {z1} | Precio: {z1.precio} | Stock: {z1.stock}")

        # 1.3 Validacion de logica
        print("\n1.3 Crear Zapatillas sin pasar ningun valor:")
        z_vacia = Zapatillas()
        print(f"  Resultado: {z_vacia}")
        print("  Observacion: La marca se convierte en 'NONE' (str(None).upper()),")
        print("  el numero queda como None, el color toma el valor por defecto 'ROJO',")
        print("  precio=0 y stock=0. No da error, pero los datos no son validos.")

        # EJERCICIO 2: Clase Persona, Comprador y Vendedor
        print("\n" + "=" * 50)
        print("EJERCICIO 2: Persona, Comprador y Vendedor")
        print("=" * 50)

        # 2.1 Herencia y polimorfismo
        print("\n2.1 Herencia y polimorfismo:")
        comp = Comprador("Juan Garcia", "Calle Mayor 5", "612345678", "juan@email.com")
        vend = Vendedor("Ana Lopez", "Av. Libertad 10", "12345678A")
        print(f"  Comprador: {comp}")
        print(f"  Vendedor:  {vend}")
        print("  Diferencias en __str__:")
        print("  - Persona.__str__ muestra: nombre (direccion)")
        print("  - Comprador.__str__ anade: [tlf - email]")
        print("  - Vendedor.__str__ anade: [dni]")

        # 2.2 Modificar atributos
        print("\n2.2 Modificar comprador y vendedor:")
        comp.modificar("Pedro Ruiz", "Calle Nueva 12", "699887766", "pedro@email.com")
        vend.modificar("Maria Martinez", "Av. Paz 3", "87654321B")
        print(f"  Comprador modificado: {comp}")
        print(f"  Vendedor modificado:  {vend}")

        # 2.3 Desafio: valor incorrecto
        print("\n2.3 Desafio - pasar un numero como nombre:")
        comp_raro = Comprador(12345, "Direccion", "000000000")
        print(f"  Resultado: {comp_raro}")
        print("  Observacion: str(12345).upper() devuelve '12345'. No lanza error")
        print("  porque Python convierte el numero a string, pero semanticamente")
        print("  no tiene sentido como nombre de persona.")

        # EJERCICIO 3: Clase Compra
        print("\n" + "=" * 50)
        print("EJERCICIO 3: Clase Compra")
        print("=" * 50)

        # 3.1 Comprendiendo las relaciones
        print("\n3.1 Crear compra y asignar comprador/vendedor:")
        compra = Compra()
        compra.comprador = comp
        compra.vendedor = vend
        print(f"  Comprador de la compra: {compra.comprador}")
        print(f"  Vendedor de la compra:  {compra.vendedor}")

        # 3.2 Anadir lineas de compra
        print("\n3.2 Anadir zapatillas a la compra:")
        # Recreamos zapatillas con stock fresco
        z1 = Zapatillas("adidas", 45, "Azul", 30, 5)
        z2 = Zapatillas("nike", 42, "Negro", 55.99, 10)
        z3 = Zapatillas("puma", 38, "Blanco", 40, 3)
        compra.add_linea(z1, 2)
        compra.add_linea(z2, 3)
        compra.add_linea(z3, 1)
        print(f"  Numero de lineas: {compra.num_lineas}")
        print(f"  Stock restante -> z1: {z1.stock}, z2: {z2.stock}, z3: {z3.stock}")

        # 3.3 Calcular total
        print("\n3.3 Calcular el total:")
        total_sin_iva = compra._total_a_pagar
        total_con_iva = total_sin_iva * IVA
        print(f"  Subtotal (sin IVA): {total_sin_iva:.2f}")
        print(f"  IVA (21%):          {total_con_iva - total_sin_iva:.2f}")
        print(f"  Total (con IVA):    {total_con_iva:.2f}")

        # 3.4 Crear factura
        print("\n3.4 Crear factura:")
        print(compra.crear_factura())
        print("  Mejoras posibles en el diseno de la factura:")
        print("  - Mostrar datos del comprador y vendedor en la cabecera.")
        print("  - Formatear los precios con 2 decimales y simbolo de moneda.")
        print("  - Mostrar el desglose del IVA en el total.")
        print("  - Generar un numero de factura unico en vez de uno fijo.")

        # 3.5 Simular un pago
        print("\n3.5 Simular un pago:")
        pagado, total = compra.pagar()
        print(f"  Pagado: {pagado} | Total: {total:.2f}")
        print("  Observacion: 'pagado' siempre es False porque la funcionalidad")
        print("  de TPV no esta implementada. Se necesitaria una conexion real")
        print("  a un terminal de punto de venta para procesar el pago, lo cual")
        print("  no se puede simular solo con codigo.")

        # EJERCICIO 4: Clase App
        print("\n" + "=" * 50)
        print("EJERCICIO 4: Clase App")
        print("=" * 50)

        # 4.1 Ejecutar el programa principal
        print("\n4.1 Salida del programa original:")
        z_original = Zapatillas("adidas", 45, "Azul", 30, 5)
        print(f"  {str(z_original).title()}")
        c_original = Comprador("nombre", "direccion", "3456788", "EEEE")
        print(f"  {c_original}")
        print("  Cada parte representa: creacion de zapatilla, creacion de comprador,")
        print("  y generacion de una factura con la compra.")

        # 4.2 Modificar el flujo principal (ya hecho arriba con datos personalizados)
        print("\n4.2 Flujo modificado con datos personalizados (ejercicios anteriores).")

        # 4.3 Anadir interaccion
        print("\n4.3 Anadir zapatilla interactivamente:")
        respuesta = input("  Deseas anadir una zapatilla manualmente? (s/n): ")
        if respuesta.lower() == "s":
            marca = input("  Marca: ")
            numero = int(input("  Numero: "))
            color = input("  Color: ")
            precio = float(input("  Precio: "))
            stock = int(input("  Stock: "))
            z_nueva = Zapatillas(marca, numero, color, precio, stock)
            cantidad = int(input("  Cuantas unidades quieres comprar? "))
            compra.add_linea(z_nueva, cantidad)
            print(f"  Zapatilla anadida: {z_nueva}")
            print(f"  Lineas de compra actuales: {compra.num_lineas}")
            print("\n  Factura actualizada:")
            print(compra.crear_factura())

        # EJERCICIO 5: Comprension de herencia
        print("\n" + "=" * 50)
        print("EJERCICIO 5: Comprension de herencia")
        print("=" * 50)
        print("\n  Comprador y Vendedor heredan de Persona:")
        print("  - Persona define los atributos 'nombre' y 'direccion' y el metodo __str__.")
        print("  - Comprador hereda esos atributos y anade 'tlf' y 'email'.")
        print("    Sobreescribe __str__ para mostrar tambien tlf y email.")
        print("    Anade el metodo 'modificar' con sus 4 parametros.")
        print("  - Vendedor hereda esos atributos y anade 'dni'.")
        print("    Sobreescribe __str__ para mostrar tambien dni.")
        print("    Anade el metodo 'modificar' con sus 3 parametros.")
        print("  - Ambos llaman a super().__init__() para inicializar la clase padre.")

        # EJERCICIO 6: Propiedades (@property)
        print("\n" + "=" * 50)
        print("EJERCICIO 6: Propiedades (@property)")
        print("=" * 50)
        print("\n  Ventaja de usar @property en comprador y vendedor de Compra:")
        print("  - Permite VALIDAR el tipo de dato antes de asignarlo.")
        print("  - El setter de comprador verifica isinstance(c, Comprador)")
        print("    y el de vendedor verifica isinstance(v, Vendedor).")
        print("  - Sin @property, cualquier valor se podria asignar directamente")
        print("    sin ninguna validacion, rompiendo la logica del programa.")

        print("\n  Demostracion:")
        print(f"  Comprador actual: {compra.comprador}")
        compra.comprador = "esto no es un comprador"
        print(f"  Tras asignar un string: {compra.comprador}")
        print("  -> El comprador no cambio gracias a la validacion del setter.")

        # EJERCICIO 7: Extension de funcionalidad
        print("\n" + "=" * 50)
        print("EJERCICIO 7: Extension de funcionalidad")
        print("=" * 50)
        print("\n  7.1 Gestion de stock:")
        print("  El metodo add_linea ahora reduce el stock al agregar a la compra.")
        z_test = Zapatillas("reebok", 40, "Gris", 35, 5)
        print(f"  Stock antes: {z_test.stock}")
        compra.add_linea(z_test, 3)
        print(f"  Stock despues de comprar 3: {z_test.stock}")

        print("\n  7.2 Validaciones adicionales:")
        print("  Intentar comprar mas stock del disponible:")
        compra.add_linea(z_test, 10)  # Solo quedan 2

        # EJERCICIO 8: Simulacion practica
        print("\n" + "=" * 50)
        print("EJERCICIO 8: Simulacion practica - Un dia en la tienda")
        print("=" * 50)

        # Crear al menos 3 zapatillas
        print("\n  Inventario del dia:")
        zap1 = Zapatillas("adidas", 43, "Blanco", 89.99, 15)
        zap2 = Zapatillas("nike", 41, "Negro", 120.50, 8)
        zap3 = Zapatillas("new balance", 44, "Gris", 75, 20)
        print(f"  {zap1} | Precio: {zap1.precio} | Stock: {zap1.stock}")
        print(f"  {zap2} | Precio: {zap2.precio} | Stock: {zap2.stock}")
        print(f"  {zap3} | Precio: {zap3.precio} | Stock: {zap3.stock}")

        # Crear comprador y vendedor
        print("\n  Personas:")
        comprador_sim = Comprador("Laura Gomez", "Calle Sol 15", "611223344", "laura@mail.com")
        vendedor_sim = Vendedor("Carlos Diaz", "Av. Luna 22", "55667788Z")
        print(f"  Comprador: {comprador_sim}")
        print(f"  Vendedor:  {vendedor_sim}")

        # Crear compra y anadir zapatillas
        print("\n  Realizando compra:")
        compra_sim = Compra()
        compra_sim.comprador = comprador_sim
        compra_sim.vendedor = vendedor_sim
        compra_sim.add_linea(zap1, 2)
        compra_sim.add_linea(zap2, 1)
        compra_sim.add_linea(zap3, 3)
        print(f"  Lineas de compra: {compra_sim.num_lineas}")
        print(f"  Stock restante -> zap1: {zap1.stock}, zap2: {zap2.stock}, zap3: {zap3.stock}")

        # Generar factura
        print("\n  Factura generada:")
        print(compra_sim.crear_factura())

        # Calcular total con IVA y simular pago
        total_sim = compra_sim._total_a_pagar
        total_iva_sim = total_sim * IVA
        print(f"  Subtotal: {total_sim:.2f}")
        print(f"  Total con IVA: {total_iva_sim:.2f}")
        pagado_sim, total_pago_sim = compra_sim.pagar()
        print(f"  Pago simulado -> Pagado: {pagado_sim} | Total: {total_pago_sim:.2f}")

        print("\n" + "=" * 50)
        print("FIN DE LOS EJERCICIOS")
        print("=" * 50)


if __name__ == "__main__":
    App().main()
