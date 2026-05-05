class Calculadora:
    def __init__(self, valor):
        self.valor = valor
    
    @staticmethod
    def is_valid_porcentaje(num):
        """Valida que el número sea un entero o flotante"""
        return 0 <= num <= 100 and isinstance(num, (int, float))
    
    @staticmethod
    def to_decimal(porcentaje):
        """Convierte un porcentaje a decimal"""
        if Calculadora.is_valid_porcentaje(porcentaje):
            return porcentaje / 100
        raise ValueError("El porcentaje debe ser un número")
    
    def aplicar_descuento(self, porcentaje):
        if self.is_valid_porcentaje(porcentaje):
            return self.valor * (1 - self.to_decimal(porcentaje))
        raise ValueError("El porcentaje no es válido")
    
# Podemos usar la clase sin instanciarla
if Calculadora.is_valid_porcentaje(21):
    print("El porcentaje es válido")

# O usarlos desde una instancia
calc = Calculadora(1000)
print(calc.aplicar_descuento(21))  