# 11 Día Juliano
def ejercicio11():
    def LeerFecha():
        dia = int(input("Día: "))
        mes = int(input("Mes: "))
        anio = int(input("Año: "))
        return dia, mes, anio

    def EsBisiesto(anio):
        return (anio % 4 == 0 and anio % 100 != 0) or (anio % 400 == 0)

    def DiasDelMes(mes, anio):
        if mes in [1, 3, 5, 7, 8, 10, 12]:
            return 31
        elif mes in [4, 6, 9, 11]:
            return 30
        elif mes == 2:
            return 29 if EsBisiesto(anio) else 28
        else:
            return 0

    def Calcular_Dia_Juliano(dia, mes, anio):
        total = sum(DiasDelMes(m, anio) for m in range(1, mes)) + dia
        return total

    dia, mes, anio = LeerFecha()
    dia_juliano = Calcular_Dia_Juliano(dia, mes, anio)
    print(f"El día juliano de la fecha {dia}/{mes}/{anio} es {dia_juliano}.")

# 11 Validar Fecha
def ejercicio12():
    def LeerFechaValida():
        while True:
            dia = int(input("Día: "))
            mes = int(input("Mes: "))
            anio = int(input("Año: "))

            if anio <= 0:
                print("Año inválido, debe ser mayor que 0.")
                continue

            if 1 <= mes <= 12:
                if 1 <= dia <= DiasDelMes(mes, anio):
                    return dia, mes, anio

            print("Fecha inválida, intente de nuevo.")

    def EsBisiesto(anio):
        return (anio % 4 == 0 and anio % 100 != 0) or (anio % 400 == 0)

    def DiasDelMes(mes, anio):
        if mes in [1, 3, 5, 7, 8, 10, 12]:
            return 31
        elif mes in [4, 6, 9, 11]:
            return 30
        elif mes == 2:
            return 29 if EsBisiesto(anio) else 28
        else:
            return 0

    def Calcular_Dia_Juliano(dia, mes, anio):
        total = sum(DiasDelMes(m, anio) for m in range(1, mes)) + dia
        return total

    dia, mes, anio = LeerFechaValida()
    dia_juliano = Calcular_Dia_Juliano(dia, mes, anio)
    print(f"El día juliano de la fecha {dia}/{mes}/{anio} es {dia_juliano}.")

# 13 Fracciones
def ejercicio13():
    def Calcular_mcd(a, b):
        while b != 0:
            a, b = b, a % b
        return a

    def Simplificar_fraccion(numerador, denominador):
        mcd = Calcular_mcd(numerador, denominador)
        return numerador // mcd, denominador // mcd

    def Leer_fraccion():
        numerador = int(input("Numerador: "))
        denominador = int(input("Denominador: "))
        while denominador == 0:
            print("El denominador no puede ser 0.")
            denominador = int(input("Denominador: "))
        return Simplificar_fraccion(numerador, denominador)

    def Escribir_fraccion(frac):
        n, d = frac
        if d == 1:
            print(f"{n}")
        else:
            print(f"{n}/{d}")

    def Sumar_fracciones(f1, f2):
        n1, d1 = f1
        n2, d2 = f2
        return Simplificar_fraccion(n1*d2 + n2*d1, d1*d2)

    def Restar_fracciones(f1, f2):
        n1, d1 = f1
        n2, d2 = f2
        return Simplificar_fraccion(n1*d2 - n2*d1, d1*d2)

    def Multiplicar_fracciones(f1, f2):
        n1, d1 = f1
        n2, d2 = f2
        return Simplificar_fraccion(n1*n2, d1*d2)

    def Dividir_fracciones(f1, f2):
        n1, d1 = f1
        n2, d2 = f2
        if n2 == 0:
            print("Error: División por fracción con numerador 0")
            return (0,1)
        return Simplificar_fraccion(n1*d2, d1*n2)

    while True:
        print("\n--- MENÚ FRACCIONES ---")
        print("1. Sumar dos fracciones")
        print("2. Restar dos fracciones")
        print("3. Multiplicar dos fracciones")
        print("4. Dividir dos fracciones")
        print("5. Salir")
        opcion = input("Opción: ")
        if opcion == "5":
            break
        print("Fracción 1:")
        f1 = Leer_fraccion()
        print("Fracción 2:")
        f2 = Leer_fraccion()
        if opcion == "1":
            resultado = Sumar_fracciones(f1, f2)
        elif opcion == "2":
            resultado = Restar_fracciones(f1, f2)
        elif opcion == "3":
            resultado = Multiplicar_fracciones(f1, f2)
        elif opcion == "4":
            resultado = Dividir_fracciones(f1, f2)
        else:
            print("Opción inválida")
            continue
        print("Resultado:")
        Escribir_fraccion(resultado)

# 14 Pila
def ejercicio14():
    MAX_PILA = 10

    def LongitudPila(pila):
        return len(pila)

    def EstaVaciaPila(pila):
        return len(pila) == 0

    def EstaLlenaPila(pila):
        return len(pila) >= MAX_PILA

    def AddPila(elemento, pila):
        if not EstaLlenaPila(pila):
            pila.append(elemento)
        else:
            print("Error: Pila llena")

    def SacarDeLaPila(pila):
        if not EstaVaciaPila(pila):
            return pila.pop()
        else:
            print("Error: Pila vacía")
            return None

    def EscribirPila(pila):
        print("Pila:", pila)

    pila = []
    while True:
        print("\n--- MENÚ PILA ---")
        print("1. Añadir elemento")
        print("2. Sacar elemento")
        print("3. Longitud de la pila")
        print("4. Mostrar pila")
        print("5. Salir")
        opcion = input("Opción: ")
        if opcion == "5":
            break
        elif opcion == "1":
            elemento = input("Elemento a añadir: ")
            AddPila(elemento, pila)
        elif opcion == "2":
            elem = SacarDeLaPila(pila)
            if elem is not None:
                print("Elemento sacado:", elem)
        elif opcion == "3":
            print("Longitud:", LongitudPila(pila))
        elif opcion == "4":
            EscribirPila(pila)
        else:
            print("Opción inválida")

# 15 Cola
def ejercicio15():
    MAX_COLA = 10

    def LongitudCola(cola):
        return len(cola)

    def EstaVaciaCola(cola):
        return len(cola) == 0

    def EstaLlenaCola(cola):
        return len(cola) >= MAX_COLA

    def AddCola(elemento, cola):
        if not EstaLlenaCola(cola):
            cola.append(elemento)
        else:
            print("Error: Cola llena")

    def SacarDeLaCola(cola):
        if not EstaVaciaCola(cola):
            return cola.pop(0)
        else:
            print("Error: Cola vacía")
            return None

    def EscribirCola(cola):
        print("Cola:", cola)

    cola = []
    while True:
        print("\n--- MENÚ COLA ---")
        print("1. Añadir elemento")
        print("2. Sacar elemento")
        print("3. Longitud de la cola")
        print("4. Mostrar cola")
        print("5. Salir")
        opcion = input("Opción: ")
        if opcion == "5":
            break
        elif opcion == "1":
            elemento = input("Elemento a añadir: ")
            AddCola(elemento, cola)
        elif opcion == "2":
            elem = SacarDeLaCola(cola)
            if elem is not None:
                print("Elemento sacado:", elem)
        elif opcion == "3":
            print("Longitud:", LongitudCola(cola))
        elif opcion == "4":
            EscribirCola(cola)
        else:
            print("Opción inválida")

def main():
    ejercicio11()
    #ejercicio12()
    #ejercicio13()
    #ejercicio14()
    #ejercicio15()

if __name__ == "__main__":
    main()