from datetime import date

class Usuario:
    def __init__(self, nombre, edad):
        self.nombre = nombre
        self.edad = edad

    @classmethod
    def from_año_nacimiento(cls, nombre, año_nacimiento):
        edad = date.today().year - año_nacimiento
        return cls(nombre, edad)
    
# Con constructor estándar
usuario1 = Usuario("Carlos", 30)

# Con classmethod
usuario2 = Usuario.from_año_nacimiento("Ana", 1990)