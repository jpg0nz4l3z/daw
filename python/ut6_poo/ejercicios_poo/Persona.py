class Persona:
    _total_personas = 0

    def __init__(self, dni, nombre, apellidos, edad):
        self._dni = dni
        self._nombre = nombre
        self._apellidos = apellidos
        self._edad = edad
        Persona._total_personas += 1

    # Getters y Setters
    @property
    def dni(self):
        return self._dni

    @dni.setter
    def dni(self, dni):
        self._dni = dni

    @property
    def nombre(self):
        return self._nombre

    @nombre.setter
    def nombre(self, nombre):
        self._nombre = nombre

    @property
    def apellidos(self):
        return self._apellidos

    @apellidos.setter
    def apellidos(self, apellidos):
        self._apellidos = apellidos

    @property
    def edad(self):
        return self._edad

    @edad.setter
    def edad(self, edad):
        self._edad = edad

    # Metodo de clase
    @classmethod
    def desde_datos_completos(cls, texto):
        """Crea una Persona a partir de un string 'dni,nombre,apellidos,edad'."""
        partes = texto.split(",")
        return cls(partes[0], partes[1], partes[2], int(partes[3]))

    @classmethod
    def get_total_personas(cls):
        """Devuelve el total de personas creadas."""
        return cls._total_personas

    # Metodo estatico
    @staticmethod
    def es_edad_valida(edad):
        """Comprueba si una edad es valida (entre 0 y 150)."""
        return 0 <= edad <= 150

    # Metodos del enunciado
    def imprime(self):
        print(
            f"DNI: {self._dni}\n"
            f"Nombre: {self._nombre}\n"
            f"Apellidos: {self._apellidos}\n"
            f"Edad: {self._edad}"
        )

    def es_mayor_edad(self):
        return self._edad >= 18

    def es_jubilado(self):
        return self._edad >= 65

    def diferencia_edad(self, persona):
        return abs(self._edad - persona._edad)


class Principal:
    @staticmethod
    def main():
        persona1 = Persona("z3241241b", "Juan", "González", 14)
        persona2 = Persona("d9231428", "Nicolas", "Pardo", 25)

        print("Test de metodos nuevos")
        persona1.imprime()
        print(f"Es mayor de edad: {persona1.es_mayor_edad()}")
        print(f"Diferencia de edad: {persona1.diferencia_edad(persona2)}")

        # Prueba getters y setters
        print(f"\nNombre con getter: {persona1.nombre}")
        persona1.nombre = "Pedro"
        print(f"Nombre cambiado con setter: {persona1.nombre}")

        # Prueba classmethod
        print("\nPrueba classmethod:")
        persona3 = Persona.desde_datos_completos("12345678A,Ana,Lopez,30")
        persona3.imprime()
        print(f"Total de personas creadas: {Persona.get_total_personas()}")

        # Prueba staticmethod
        print("\nPrueba staticmethod:")
        print(f"Edad 25 valida: {Persona.es_edad_valida(25)}")
        print(f"Edad -5 valida: {Persona.es_edad_valida(-5)}")


Principal.main()
