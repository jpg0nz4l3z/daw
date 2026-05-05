class Persona:
    def __init__(self, nombre: str, apellido: str, edad: int):
        self._nombre = nombre
        self._apellido = apellido
        self._edad = edad

    @property
    def nombre(self):
        return self._nombre

    @nombre.setter
    def nombre(self, nombre: str):
        self._nombre = nombre

    @property
    def apellido(self):
        return self._apellido

    @apellido.setter
    def apellido(self, apellido: str):
        self._apellido = apellido

    @property
    def edad(self):
        return self._edad

    @edad.setter
    def edad(self, edad: int):
        self._edad = edad

    def __str__(self):
        return f"Nombre: {self.nombre}, Apellido: {self.apellido}, Edad: {self.edad}"
