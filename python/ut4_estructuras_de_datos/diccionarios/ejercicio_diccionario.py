def main():
    persona = {"nombre": "Juan", "edad": 25, "ciudad": "Madrid"}

    print()
    print_claves_y_valores(persona)
    print()

    print("1. Retornar edad")
    print(edad(persona))
    print()

    print("Actualizando edad")
    actualizar_edad(persona, 30)
    print_claves_y_valores(persona)
    print()

    print("Eliminando clave <<ciudad>>")
    eliminar_clave(persona, "ciudad")
    print_claves_y_valores(persona)
    print()

    print("Agregando clave valor")
    agregar_clave_valor(persona, "profesión", "Ingeniero")
    print_claves_y_valores(persona)
    print()

    persona1 = {"nombre": "Juan", "edad": 25, "ciudad": "Madrid"}

    persona2 = {"nombre": "Pedro", "edad": 29, "ciudad": "Madrid"}

    persona3 = {"nombre": "Pablo", "edad": 10, "ciudad": "Madrid"}

    print("Mostrar solo mayores de edad")
    lista_de_personas = [persona1, persona2, persona3]
    mayores_de_edad(lista_de_personas)


# Acceder a un valor del diccionario
def edad(persona):
    return persona["edad"]


# Actualizar el valor de una clave
def actualizar_edad(persona, nueva_edad):
    persona["edad"] = nueva_edad


# Eliminar un elemento del diccionario
def eliminar_clave(persona, clave):
    del persona[clave]


# Recorrer un diccionario
def print_claves_y_valores(persona):
    for clave, valor in persona.items():
        print(f"{clave}: {valor}")


# Agregar una nueva clave-valor al diccionario
def agregar_clave_valor(persona, clave, valor):
    persona[clave] = valor


# combinado de listas y diccionarios
def mayores_de_edad(lista_personas):
    for persona in lista_personas:
        if persona["edad"] >= 18:
            print(persona["nombre"])


if __name__ == "__main__":
    main()
