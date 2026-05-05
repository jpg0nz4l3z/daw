class Producto:
    descuento_clobal = 0.1  # Descuento global de clase
    total_productos = 0 # Contador de clase

    def __init__(self, nombre, precio):
        self.nombre = nombre
        self.precio = precio
        Producto._incrementar_contador()  # Incrementar contador al crear un producto

    @classmethod
    def _incrementar_contador(cls):
        cls.total_productos += 1
    
    @classmethod
    def cambiar_descuento(cls, nuevo_descuento):
        """Lo modifica para todas las instancias"""
        cls.descuento_clobal = nuevo_descuento

    def precio_final(self):
        return self.precio * (1 - self.descuento_clobal)    
    
# Crear productos
producto1 = Producto("Laptop", 1000)
producto2 = Producto("Smartphone", 500)
print(f"Total productos: {Producto.total_productos}")  # Total productos: 2

#Precios antes del cambio de descuento
print(f"Precio final de {producto1.nombre}: {producto1.precio_final()}")
print(f"Precio final de {producto2.nombre}: {producto2.precio_final()}")
# Cambiar descuento global
Producto.cambiar_descuento(0.2)
print(f"Precio final de {producto1.nombre}: {producto1.precio_final()}")
print(f"Precio final de {producto2.nombre}: {producto2.precio_final()}")