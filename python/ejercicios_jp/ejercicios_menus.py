"""
EJERCICIOS (RESUELTOS) DE MENÚS EN CONSOLA - PYTHON
--------------------------------------------------
Objetivo: practicar menús iterativos con validación de opciones,
try/except, submenús, y bucles hasta entrada válida.

Cada ejercicio está en una función ejecutable.
"""

from __future__ import annotations

import math


# =========================
# UTILIDADES DE INPUT (REUTILIZABLES)
# =========================


def pedir_opcion_valida(prompt: str, opciones_validas: set[str]) -> str:
    """
    Pide una opción (string) hasta que el usuario introduzca una válida.
    Devuelve la opción elegida (tal cual).
    """
    while True:
        op = input(prompt).strip()
        if op in opciones_validas:
            return op
        print(f"❌ Opción inválida. Opciones válidas: {sorted(opciones_validas)}")


def pedir_int(
    prompt: str, *, minimo: int | None = None, maximo: int | None = None
) -> int:
    """
    Pide un entero con validación y reintento.
    """
    while True:
        s = input(prompt).strip()
        try:
            x = int(s)
        except ValueError:
            print("❌ Debes introducir un número entero.")
            continue

        if minimo is not None and x < minimo:
            print(f"❌ Debe ser >= {minimo}.")
            continue
        if maximo is not None and x > maximo:
            print(f"❌ Debe ser <= {maximo}.")
            continue
        return x


def pedir_float(prompt: str) -> float:
    """
    Pide un float con validación y reintento.
    """
    while True:
        s = input(prompt).strip().replace(",", ".")
        try:
            return float(s)
        except ValueError:
            print("❌ Debes introducir un número (float).")


# =========================
# EJERCICIO 1 - MENÚ BÁSICO (1..3) CON REPETICIÓN
# =========================


def ej01_menu_basico():
    """
    EJ01 - Menú básico:
    1) Saludar
    2) Mostrar el cuadrado de un número
    3) Salir

    Repite hasta que elijan 3.
    Si eligen opción inválida, vuelve a pedir.
    """
    while True:
        print("\n=== MENÚ EJ01 ===")
        print("1) Saludar")
        print("2) Cuadrado de un número")
        print("3) Salir")

        op = pedir_opcion_valida("Elige opción (1-3): ", {"1", "2", "3"})

        if op == "1":
            nombre = input("Tu nombre: ").strip()
            print(f"Hola, {nombre} 👋")
        elif op == "2":
            n = pedir_int("Número entero: ")
            print(f"{n}^2 = {n*n}")
        else:
            print("Saliendo del menú EJ01...")
            break


# =========================
# EJERCICIO 2 - MENÚ CON VALIDACIÓN NUMÉRICA (1..5)
# =========================


def ej02_menu_1_a_5():
    """
    EJ02 - Menú 1..5:
    1) Sumar dos números
    2) Restar dos números
    3) Multiplicar dos números
    4) Dividir dos números (reintenta si divisor 0)
    5) Salir
    """
    while True:
        print("\n=== MENÚ EJ02 ===")
        print("1) Sumar")
        print("2) Restar")
        print("3) Multiplicar")
        print("4) Dividir")
        print("5) Salir")

        op = pedir_int("Elige opción (1-5): ", minimo=1, maximo=5)

        if op == 5:
            print("Saliendo del menú EJ02...")
            break

        a = pedir_float("a: ")
        b = pedir_float("b: ")

        if op == 1:
            print("Resultado:", a + b)
        elif op == 2:
            print("Resultado:", a - b)
        elif op == 3:
            print("Resultado:", a * b)
        elif op == 4:
            while b == 0:
                print("❌ No se puede dividir por 0. Repite b.")
                b = pedir_float("b: ")
            print("Resultado:", a / b)


# =========================
# EJERCICIO 3 - MENÚ CON SUBMENÚ
# =========================


def ej03_menu_con_submenu():
    """
    EJ03 - Menú principal:
    1) Operaciones con lista (submenú)
    2) Operaciones con números (submenú)
    3) Salir

    Cada submenú debe repetirse hasta volver.
    """
    datos: list[int] = []

    while True:
        print("\n=== MENÚ EJ03 (PRINCIPAL) ===")
        print("1) Lista (submenú)")
        print("2) Números (submenú)")
        print("3) Salir")

        op = pedir_opcion_valida("Elige opción (1-3): ", {"1", "2", "3"})
        if op == "3":
            print("Saliendo del menú EJ03...")
            break

        if op == "1":
            # Submenú lista
            while True:
                print("\n--- SUBMENÚ LISTA ---")
                print("1) Añadir número")
                print("2) Ver lista")
                print("3) Borrar último")
                print("4) Volver")

                sop = pedir_opcion_valida("Elige (1-4): ", {"1", "2", "3", "4"})
                if sop == "4":
                    break
                if sop == "1":
                    x = pedir_int("Número a añadir: ")
                    datos.append(x)
                elif sop == "2":
                    print("Lista:", datos)
                elif sop == "3":
                    if datos:
                        print("Borrado:", datos.pop())
                    else:
                        print("❌ Lista vacía.")
        else:
            # Submenú números
            while True:
                print("\n--- SUBMENÚ NÚMEROS ---")
                print("1) Factorial (n>=0)")
                print("2) Raíz cuadrada (x>=0)")
                print("3) Volver")

                sop = pedir_opcion_valida("Elige (1-3): ", {"1", "2", "3"})
                if sop == "3":
                    break
                if sop == "1":
                    n = pedir_int("n (>=0): ", minimo=0)
                    print("factorial:", math.factorial(n))
                elif sop == "2":
                    x = pedir_float("x (>=0): ")
                    while x < 0:
                        print("❌ Debe ser >= 0.")
                        x = pedir_float("x (>=0): ")
                    print("raíz:", math.sqrt(x))


# =========================
# EJERCICIO 4 - MENÚ CON CONFIRMACIÓN (sí/no)
# =========================


def ej04_menu_confirmacion_salida():
    """
    EJ04 - Menú que al salir pide confirmación (s/n).
    Si usuario pone otra cosa, reintenta.
    """
    while True:
        print("\n=== MENÚ EJ04 ===")
        print("1) Hacer algo")
        print("2) Salir")

        op = pedir_opcion_valida("Opción (1-2): ", {"1", "2"})
        if op == "1":
            print("Hecho ✅")
        else:
            conf = pedir_opcion_valida("¿Seguro que quieres salir? (s/n): ", {"s", "n"})
            if conf == "s":
                print("Adiós 👋")
                break


# =========================
# EJERCICIO 5 - MENÚ CON COMANDOS (texto)
# =========================


def ej05_menu_comandos():
    """
    EJ05 - Menú por comandos de texto:
    Comandos válidos:
    - add (añade un número a una lista)
    - sum (suma la lista)
    - clear (vacía la lista)
    - exit (salir)

    Si comando inválido, reintenta.
    """
    datos: list[int] = []

    while True:
        print("\n=== MENÚ EJ05 (COMANDOS) ===")
        print("Comandos: add | sum | clear | exit")
        cmd = input("cmd> ").strip().lower()

        if cmd == "add":
            x = pedir_int("Número a añadir: ")
            datos.append(x)
            print("OK. Lista:", datos)
        elif cmd == "sum":
            print("Suma:", sum(datos))
        elif cmd == "clear":
            datos.clear()
            print("Lista vacía.")
        elif cmd == "exit":
            print("Saliendo...")
            break
        else:
            print("❌ Comando inválido.")


# =========================
# EJERCICIO 6 - MENÚ CON INTENTOS LIMITADOS
# =========================


def ej06_menu_intentos_limitados():
    """
    EJ06 - El usuario solo tiene 3 intentos para poner una opción válida.
    Menú:
    1) Opción A
    2) Opción B
    3) Salir
    Si se gasta intentos, el programa termina.
    """
    intentos = 3
    while True:
        print("\n=== MENÚ EJ06 ===")
        print("1) A")
        print("2) B")
        print("3) Salir")
        op = input("Opción (1-3): ").strip()

        if op not in {"1", "2", "3"}:
            intentos -= 1
            print(f"❌ Inválida. Te quedan {intentos} intento(s).")
            if intentos == 0:
                print("Sin intentos. Cerrando.")
                break
            continue

        # válida
        if op == "1":
            print("Elegiste A")
        elif op == "2":
            print("Elegiste B")
        else:
            print("Adiós.")
            break


# =========================
# EJERCICIO 7 - MENÚ CRUD SIMPLE (diccionario)
# =========================


def ej07_menu_crud_contactos():
    """
    EJ07 - CRUD de contactos (diccionario):
    1) Crear/Actualizar contacto (nombre -> teléfono)
    2) Buscar contacto
    3) Eliminar contacto
    4) Listar contactos
    5) Salir

    Repite hasta salir. Valida opción.
    """
    contactos: dict[str, str] = {}

    while True:
        print("\n=== MENÚ EJ07 (CONTACTOS) ===")
        print("1) Crear/Actualizar")
        print("2) Buscar")
        print("3) Eliminar")
        print("4) Listar")
        print("5) Salir")

        op = pedir_int("Opción (1-5): ", minimo=1, maximo=5)

        if op == 5:
            print("Saliendo de contactos...")
            break

        if op == 1:
            nombre = input("Nombre: ").strip()
            tel = input("Teléfono: ").strip()
            if not nombre:
                print("❌ Nombre vacío.")
                continue
            contactos[nombre] = tel
            print("✅ Guardado.")
        elif op == 2:
            nombre = input("Nombre a buscar: ").strip()
            if nombre in contactos:
                print(f"{nombre}: {contactos[nombre]}")
            else:
                print("❌ No encontrado.")
        elif op == 3:
            nombre = input("Nombre a eliminar: ").strip()
            if nombre in contactos:
                del contactos[nombre]
                print("✅ Eliminado.")
            else:
                print("❌ No existe.")
        elif op == 4:
            if not contactos:
                print("(vacío)")
            else:
                for nombre, tel in sorted(contactos.items()):
                    print(f"- {nombre}: {tel}")


# =========================
# MENÚ PRINCIPAL PARA EJECUTAR EJERCICIOS
# =========================


def menu_principal():
    """
    Menú principal para lanzar cada ejercicio.
    """
    ejercicios = {
        "1": ("Menú básico", ej01_menu_basico),
        "2": ("Menú 1..5 calculadora", ej02_menu_1_a_5),
        "3": ("Menú con submenú", ej03_menu_con_submenu),
        "4": ("Salida con confirmación", ej04_menu_confirmacion_salida),
        "5": ("Menú por comandos", ej05_menu_comandos),
        "6": ("Intentos limitados", ej06_menu_intentos_limitados),
        "7": ("CRUD contactos", ej07_menu_crud_contactos),
        "0": ("Salir", None),
    }

    while True:
        print("\n============================")
        print("   MENÚ PRINCIPAL (MENÚS)")
        print("============================")
        for k, (nombre, _) in ejercicios.items():
            print(f"{k}) {nombre}")

        op = pedir_opcion_valida("Elige ejercicio: ", set(ejercicios.keys()))
        if op == "0":
            print("Hasta luego 👋")
            break

        _, fn = ejercicios[op]
        assert fn is not None
        fn()


if __name__ == "__main__":
    menu_principal()
