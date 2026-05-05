class Transporte:
    def __init__(self, marca):
        self.marca = marca
    @classmethod
    def from_config(cls, marca):
        """Factoría: crea una instancia de la clase que lo llama"""
        print(f"Creando un transporte de tipo {cls.__name__}")
        return cls(marca)


class Coche(Transporte):
    def conducir(self):
        return f"Conduciendo un coche de marca {self.marca}"

class Moto(Transporte):
    def conducir(self):
        return f"Conduciendo una moto de marca {self.marca}"

# Crear instancias usando la factoría y los datos en un diccionario
coche_config = {"marca": "Toyota"}
moto_config = {"marca": "Honda"}

coche = Coche.from_config(coche_config["marca"])
moto = Moto.from_config(moto_config["marca"])

print(coche.conducir())
print(isinstance(coche, Coche))  # True
print(isinstance(coche, Transporte))  # True
