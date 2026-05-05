"""
SOLUCIONES - EJERCICIOS DE TRY/EXCEPT (EXCEPCIONES) EN PYTHON
------------------------------------------------------------
- Un ejercicio por función.
- Cada función muestra una técnica distinta: try/except, else, finally, raise,
  excepciones personalizadas, reintentos, manejo de archivos, etc.
"""

from __future__ import annotations

from dataclasses import dataclass


# =========================
# EXCEPCIONES PERSONALIZADAS
# =========================


class InputError(ValueError):
    """Error de validación de entrada."""


class NotFoundError(LookupError):
    """Error cuando no se encuentra un elemento."""


class BusinessRuleError(RuntimeError):
    """Error por regla de negocio."""


# =========================
# NIVEL 1 (BÁSICOS)
# =========================


def ej01_division_segura(a: float, b: float) -> float | None:
    """
    EJ01 - División segura.
    Devuelve a/b. Si b == 0, devuelve None sin lanzar excepción.
    """
    try:
        return a / b
    except ZeroDivisionError:
        return None


def ej02_parse_int(s: str) -> int | None:
    """
    EJ02 - Convertir string a int.
    Devuelve int(s). Si falla, devuelve None.
    """
    try:
        return int(s)
    except (ValueError, TypeError):
        return None


def ej03_parse_float(s: str) -> float | None:
    """
    EJ03 - Convertir string a float.
    Devuelve float(s). Si falla, devuelve None.
    """
    try:
        return float(s)
    except (ValueError, TypeError):
        return None


def ej04_acceder_indice(lista: list[int], i: int) -> int | None:
    """
    EJ04 - Acceso seguro a índice.
    Devuelve lista[i] o None si el índice no existe.
    """
    try:
        return lista[i]
    except IndexError:
        return None


def ej05_obtener_clave(d: dict[str, int], clave: str) -> int | None:
    """
    EJ05 - Obtener valor de una clave.
    Devuelve d[clave] o None si no existe.
    """
    try:
        return d[clave]
    except KeyError:
        return None


def ej06_multiplicar_por_10(x) -> int | None:
    """
    EJ06 - Multiplicar por 10.
    Si x no es numérico, devuelve None.
    """
    try:
        return x * 10
    except TypeError:
        return None


# =========================
# TRY / EXCEPT / ELSE / FINALLY
# =========================


def ej07_division_con_else_finally(a: float, b: float) -> tuple[float | None, str]:
    """
    EJ07 - Uso de else/finally.
    Devuelve (resultado_o_None, mensaje).
    - Si hay división por cero: (None, "división por cero")
    - Si todo va bien: (a/b, "ok")
    El finally siempre añade " | done" al mensaje.
    """
    msg = ""
    try:
        res = a / b
    except ZeroDivisionError:
        res = None
        msg = "división por cero"
    else:
        msg = "ok"
    finally:
        msg += " | done"
    return res, msg


def ej08_validar_edad(edad: int) -> None:
    """
    EJ08 - Validar edad.
    Si edad < 0 o edad > 130 lanza InputError.
    Si es válida, no devuelve nada.
    """
    if not isinstance(edad, int):
        raise InputError("La edad debe ser un int.")
    if edad < 0 or edad > 130:
        raise InputError("Edad fuera de rango (0..130).")


def ej09_division_obligatoria(a: float, b: float) -> float:
    """
    EJ09 - División que lanza excepción propia si b==0.
    """
    if b == 0:
        raise InputError("No se puede dividir por cero.")
    return a / b


def ej10_convertir_lista_ints(items: list[str]) -> list[int]:
    """
    EJ10 - Convertir lista de strings a ints.
    Si algún elemento no es convertible, lanza InputError indicando cuál.
    """
    out: list[int] = []
    for i, s in enumerate(items):
        try:
            out.append(int(s))
        except ValueError as e:
            raise InputError(f"Elemento inválido en posición {i}: {s!r}") from e
    return out


# =========================
# MANEJO DE ARCHIVOS
# =========================


def ej11_leer_archivo(path: str) -> str | None:
    """
    EJ11 - Leer archivo de texto.
    Devuelve el contenido completo.
    Si no existe, devuelve None.
    """
    try:
        with open(path, "r", encoding="utf-8") as f:
            return f.read()
    except FileNotFoundError:
        return None


def ej12_escribir_archivo(path: str, contenido: str) -> bool:
    """
    EJ12 - Escribir archivo.
    Devuelve True si escribe bien, False si hay error de permisos.
    """
    try:
        with open(path, "w", encoding="utf-8") as f:
            f.write(contenido)
        return True
    except PermissionError:
        return False


def ej13_leer_lineas(path: str) -> list[str]:
    """
    EJ13 - Leer líneas de un archivo.
    Si el archivo no existe, lanza NotFoundError.
    """
    try:
        with open(path, "r", encoding="utf-8") as f:
            return [line.rstrip("\n") for line in f]
    except FileNotFoundError as e:
        raise NotFoundError(f"No se encontró el archivo: {path}") from e


# =========================
# EAFP vs LBYL (Pythonic)
# =========================


def ej14_pop_seguro(lista: list[int]) -> int | None:
    """
    EJ14 - Pop seguro usando EAFP.
    Devuelve el último elemento y lo elimina. Si lista vacía, devuelve None.
    """
    try:
        return lista.pop()
    except IndexError:
        return None


def ej15_parse_key_int(d: dict[str, str], clave: str) -> int | None:
    """
    EJ15 - Obtener clave y convertir a int.
    Devuelve int(d[clave]). Si no existe clave o no es int, devuelve None.
    """
    try:
        return int(d[clave])
    except (KeyError, ValueError, TypeError):
        return None


# =========================
# REINTENTOS Y CONTROL DE ERRORES
# =========================


def ej16_dividir_con_reintentos(a: float, bs: list[float]) -> float:
    """
    EJ16 - Reintentar divisiones.
    Intenta dividir a por cada b en bs hasta que funcione.
    Si ninguno funciona, lanza InputError.
    """
    last_err: Exception | None = None
    for b in bs:
        try:
            return a / b
        except ZeroDivisionError as e:
            last_err = e
            continue
    raise InputError("No se pudo dividir: todos los divisores eran 0.") from last_err


def ej17_convertir_hasta_primero_valido(items: list[str]) -> int:
    """
    EJ17 - Devuelve el primer int válido en la lista.
    Si no hay ninguno, lanza InputError.
    """
    for s in items:
        try:
            return int(s)
        except ValueError:
            continue
    raise InputError("No hay ningún entero válido en la lista.")


# =========================
# VALIDACIONES Y REGLAS DE NEGOCIO
# =========================


def ej18_validar_usuario(nombre: str, password: str) -> None:
    """
    EJ18 - Validación simple de usuario.
    - nombre: al menos 3 caracteres
    - password: al menos 8, debe contener un número
    Si falla: InputError.
    """
    if not isinstance(nombre, str) or not isinstance(password, str):
        raise InputError("Nombre y password deben ser strings.")
    if len(nombre.strip()) < 3:
        raise InputError("Nombre demasiado corto.")
    if len(password) < 8:
        raise InputError("Password demasiado corta.")
    if not any(ch.isdigit() for ch in password):
        raise InputError("Password debe contener al menos un número.")


def ej19_aplicar_descuento(precio: float, descuento: float) -> float:
    """
    EJ19 - Regla de negocio:
    descuento en [0, 1].
    Si no cumple, BusinessRuleError.
    """
    if descuento < 0 or descuento > 1:
        raise BusinessRuleError("El descuento debe estar entre 0 y 1.")
    if precio < 0:
        raise BusinessRuleError("El precio no puede ser negativo.")
    return precio * (1 - descuento)


# =========================
# EXCEPCIONES EN ESTRUCTURAS DE DATOS
# =========================


def ej20_buscar_o_error(d: dict[str, int], clave: str) -> int:
    """
    EJ20 - Buscar clave o lanzar NotFoundError.
    """
    try:
        return d[clave]
    except KeyError as e:
        raise NotFoundError(f"Clave no encontrada: {clave!r}") from e


def ej21_media(lista: list[float]) -> float:
    """
    EJ21 - Media de lista.
    Si lista vacía, lanza InputError.
    """
    if not lista:
        raise InputError("No se puede calcular la media de una lista vacía.")
    return sum(lista) / len(lista)


def ej22_media_segura(lista: list[float]) -> float | None:
    """
    EJ22 - Media segura.
    Devuelve None si lista vacía en vez de lanzar error.
    """
    try:
        return ej21_media(lista)
    except InputError:
        return None


# =========================
# CONTEXTO Y "raise from"
# =========================


def ej23_parsear_entero_con_contexto(s: str) -> int:
    """
    EJ23 - Parse int con excepción enriquecida.
    Si falla, lanza InputError usando 'raise ... from e' para conservar el contexto.
    """
    try:
        return int(s)
    except ValueError as e:
        raise InputError(f"No se pudo convertir a entero: {s!r}") from e


def ej24_validar_rango(x: int, lo: int, hi: int) -> int:
    """
    EJ24 - Validar que lo <= x <= hi.
    Si falla, lanza InputError.
    """
    if x < lo or x > hi:
        raise InputError(f"Valor {x} fuera de rango [{lo}, {hi}].")
    return x


# =========================
# DATA CLASSES + VALIDACIÓN CON EXCEPCIONES
# =========================


@dataclass(frozen=True)
class Producto:
    nombre: str
    precio: float
    stock: int


def ej25_crear_producto(nombre: str, precio: float, stock: int) -> Producto:
    """
    EJ25 - Crear Producto validando datos.
    - nombre no vacío
    - precio >= 0
    - stock >= 0
    Si falla, InputError.
    """
    if not isinstance(nombre, str) or not nombre.strip():
        raise InputError("Nombre inválido.")
    if precio < 0:
        raise InputError("Precio no puede ser negativo.")
    if stock < 0:
        raise InputError("Stock no puede ser negativo.")
    return Producto(nombre=nombre.strip(), precio=float(precio), stock=int(stock))


def ej26_vender_producto(p: Producto, cantidad: int) -> Producto:
    """
    EJ26 - Vender producto (regla de negocio).
    Si cantidad <= 0 -> InputError
    Si cantidad > stock -> BusinessRuleError
    Devuelve un NUEVO Producto con stock actualizado.
    """
    if cantidad <= 0:
        raise InputError("Cantidad debe ser > 0.")
    if cantidad > p.stock:
        raise BusinessRuleError("No hay stock suficiente.")
    return Producto(nombre=p.nombre, precio=p.precio, stock=p.stock - cantidad)


# =========================
# EXCEPCIONES EN BUCLES (continue/break)
# =========================


def ej27_sumar_convertibles(items: list[str]) -> int:
    """
    EJ27 - Sumar solo los elementos convertibles a int.
    Los no convertibles se ignoran.
    """
    total = 0
    for s in items:
        try:
            total += int(s)
        except ValueError:
            continue
    return total


def ej28_primera_division_valida(nums: list[float], divisores: list[float]) -> float:
    """
    EJ28 - Buscar la primera división válida nums[i]/divisores[i].
    Si una pareja falla por división cero o por falta de índice, sigue.
    Si ninguna válida, lanza InputError.
    """
    n = min(len(nums), len(divisores))
    for i in range(n):
        try:
            return nums[i] / divisores[i]
        except ZeroDivisionError:
            continue
    raise InputError("No se encontró ninguna división válida (divisor 0 en todas).")


# =========================
# FINALLY PARA LIMPIEZA (sin with)
# =========================


def ej29_leer_primera_linea_sin_with(path: str) -> str | None:
    """
    EJ29 - Leer primera línea sin usar with, asegurando cierre con finally.
    Devuelve None si no existe el archivo.
    """
    f = None
    try:
        f = open(path, "r", encoding="utf-8")
        return f.readline().rstrip("\n")
    except FileNotFoundError:
        return None
    finally:
        if f is not None:
            try:
                f.close()
            except Exception:
                # Si falla el close (raro), lo ignoramos
                pass


# =========================
# ASSERT vs EXCEPCIONES
# =========================


def ej30_dividir_con_assert(a: float, b: float) -> float:
    """
    EJ30 - Uso de assert (NO recomendado para validación en producción).
    Lanza AssertionError si b==0.
    """
    assert b != 0, "b no puede ser 0"
    return a / b


# =========================
# RUNNER / DEMO
# =========================


def _demo():
    print("== Demo básica ==")
    print("ej01:", ej01_division_segura(10, 2), ej01_division_segura(10, 0))
    print("ej02:", ej02_parse_int("123"), ej02_parse_int("xx"))
    print(
        "ej07:",
        ej07_division_con_else_finally(10, 2),
        ej07_division_con_else_finally(10, 0),
    )

    print("\n== Validaciones ==")
    try:
        ej08_validar_edad(200)
    except InputError as e:
        print("ej08 capturado:", e)

    print("\n== Productos ==")
    p = ej25_crear_producto("Teclado", 19.99, 5)
    print("Producto:", p)
    try:
        p2 = ej26_vender_producto(p, 10)
        print("Vendido:", p2)
    except BusinessRuleError as e:
        print("Stock insuficiente:", e)

    print("\n== Archivos (puede variar según tu entorno) ==")
    print("ej11:", ej11_leer_archivo("no_existe.txt"))

    print("\n== Sumar convertibles ==")
    print("ej27:", ej27_sumar_convertibles(["1", "2", "x", "10"]))


if __name__ == "__main__":
    _demo()
    print("\n✅ Archivo de ejercicios resueltos listo.")
