class Persona:
    def __init__(self, dni, nombre, apellidos, edad):
        self.dni = dni
        self.nombre = nombre
        self.apellidos = apellidos
        self.edad = edad

    def imprime(self):
        print(
            "dni : ",
            self.dni,
            "\nnombre: ",
            self.nombre,
            "apellidos: ",
            self.apellidos,
            "\nedad : ",
            self.edad,
        )

    def es_mayor_edad(self):
        return self.edad >= 18

    def es_jubilado(self):
        return self.edad >= 65

    def diferencia_edad(self, persona):
        return abs(self.edad - persona.edad)


class Principal:
    @staticmethod
    def main():
        persona1 = Persona("Juan", "González", "z3241241b", 14)
        persona2 = Persona("Nicolas", "Pardo", "d9231428", 25)
        # persona2 = Persona("", "", "", 0)

        # persona1.nombre = input("Introduce el nombre de la primera persona: ")
        # persona1.apellidos = input("Introduce los apellidos de la primera persona: ")
        # persona1.dni = input("Introduce el DNI de la primera persona: ")
        # persona1.edad = int(input("Introduce la edad de la primera persona: "))

        # persona2.nombre = input("Introduce el nombre de la segunda persona: ")
        # persona2.apellidos = input("Introduce apellidos de la segunda persona: ")
        # persona2.dni = input("Introduce el DNI de la segunda persona: ")
        # persona2.edad = int(input("Introduce la edad de la segunda persona: "))

        # mensaje1 = f"{persona1.nombre} {persona1.apellidos} con DNI {persona1.dni}" + (
        #   "es mayor de edad." if persona1.edad >= 18 else "no es mayor de edad."
        # )
        # mensaje2 = f"{persona2.nombre} {persona2.apellidos} con DNI {persona2.dni}" + (
        #   "es mayor de edad." if persona2.edad >= 18 else "no es mayor de edad."
        # )
        # print(mensaje1)
        # print(mensaje2)

        print("Test de métodos nuevos")
        persona1.imprime()
        print(persona1.es_mayor_edad())
        print(persona1.diferencia_edad(persona2))


Principal.main()
