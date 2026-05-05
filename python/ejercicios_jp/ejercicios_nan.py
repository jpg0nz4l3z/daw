"""
EJERCICIOS SOBRE NaN E isnan EN PYTHON
--------------------------------------
Usa principalmente:
- math.isnan()
- float('nan')

Recuerda:
NaN != NaN  (muy importante)
"""

import math


# =========================
# NIVEL 1 (BÁSICO)
# =========================


def ej01_es_nan(x: float) -> bool:
    """
    EJ01 - Verificar si un número es NaN.
    Devuelve True si x es NaN, False en caso contrario.
    """
    # TODO
    raise NotImplementedError


def ej02_contar_nan(lista: list[float]) -> int:
    """
    EJ02 - Contar cuántos NaN hay en una lista.

    Ejemplo:
    [1.0, nan, 2.0, nan] -> 2
    """
    # TODO
    raise NotImplementedError


def ej03_reemplazar_nan(lista: list[float], valor: float) -> list[float]:
    """
    EJ03 - Reemplazar todos los NaN por un valor dado.
    Devuelve nueva lista.
    """
    # TODO
    raise NotImplementedError


def ej04_filtrar_nan(lista: list[float]) -> list[float]:
    """
    EJ04 - Devolver lista sin NaN.
    """
    # TODO
    raise NotImplementedError


def ej05_nan_en_diccionario(d: dict[str, float]) -> list[str]:
    """
    EJ05 - Devolver lista de claves cuyo valor sea NaN.
    """
    # TODO
    raise NotImplementedError


# =========================
# NIVEL 2 (INTERMEDIO)
# =========================


def ej06_promedio_sin_nan(lista: list[float]) -> float:
    """
    EJ06 - Calcular promedio ignorando NaN.
    Si todos son NaN, devuelve 0.0
    """
    # TODO
    raise NotImplementedError


def ej07_indice_primer_nan(lista: list[float]) -> int:
    """
    EJ07 - Devolver índice del primer NaN.
    Si no hay, devuelve -1.
    """
    # TODO
    raise NotImplementedError


def ej08_matriz_contar_nan(matriz: list[list[float]]) -> int:
    """
    EJ08 - Contar NaN en una matriz (lista de listas).
    """
    # TODO
    raise NotImplementedError


def ej09_matriz_reemplazar_nan(
    matriz: list[list[float]], valor: float
) -> list[list[float]]:
    """
    EJ09 - Reemplazar NaN en matriz por valor dado.
    Devuelve nueva matriz.
    """
    # TODO
    raise NotImplementedError


def ej10_comparacion_nan(a: float, b: float) -> bool:
    """
    EJ10 - Devolver True si ambos son NaN.
    (Recuerda que NaN != NaN)
    """
    # TODO
    raise NotImplementedError


# =========================
# NIVEL 3 (RETOS)
# =========================


def ej11_normalizar_datos(lista: list[float]) -> list[float]:
    """
    EJ11 - Normalizar datos ignorando NaN.
    Fórmula: (x - min) / (max - min)
    Ignora NaN para calcular min y max.
    Los NaN deben mantenerse como NaN.
    """
    # TODO
    raise NotImplementedError


def ej12_nan_por_media(lista: list[float]) -> list[float]:
    """
    EJ12 - Reemplazar NaN por el promedio de los valores válidos.
    Si no hay valores válidos, deja los NaN.
    """
    # TODO
    raise NotImplementedError


def ej13_porcentaje_nan(lista: list[float]) -> float:
    """
    EJ13 - Calcular porcentaje de NaN en lista.
    Devuelve valor entre 0 y 100.
    """
    # TODO
    raise NotImplementedError


def ej14_tiene_nan_en_rango(lista: list[float], inicio: int, fin: int) -> bool:
    """
    EJ14 - Verificar si hay algún NaN en el rango [inicio, fin].
    """
    # TODO
    raise NotImplementedError


def ej15_columna_mas_nan(matriz: list[list[float]]) -> int:
    """
    EJ15 - Devolver índice de la columna con más NaN.
    Si empate, devuelve la primera.
    """
    # TODO
    raise NotImplementedError


def ej16_nan_a_cero_si_negativo(lista: list[float]) -> list[float]:
    """
    EJ16 - Si el valor es negativo, convertirlo en NaN.
    Si ya es NaN, dejarlo.
    """
    # TODO
    raise NotImplementedError


def ej17_comprobar_todo_nan(lista: list[float]) -> bool:
    """
    EJ17 - Devuelve True si todos los elementos son NaN.
    """
    # TODO
    raise NotImplementedError


def ej18_posiciones_nan(lista: list[float]) -> list[int]:
    """
    EJ18 - Devolver lista con índices donde hay NaN.
    """
    # TODO
    raise NotImplementedError


def ej19_nan_en_diccionario_anidado(d: dict[str, dict[str, float]]) -> int:
    """
    EJ19 - Contar NaN en diccionario anidado.
    {
      "A":{"x":1.0,"y":nan},
      "B":{"x":nan,"y":5.0}
    }
    -> 2
    """
    # TODO
    raise NotImplementedError


def ej20_rellenar_nan_vecinos(lista: list[float]) -> list[float]:
    """
    EJ20 - Reemplazar NaN por el promedio de sus vecinos inmediatos.
    Si uno de los vecinos es NaN, ignóralo.
    Si ambos vecinos son NaN o no existen, deja NaN.
    """
    # TODO
    raise NotImplementedError


# =========================
# BONUS (CONCEPTUAL)
# =========================


def ej21_nan_es_igual_a_si_mismo() -> bool:
    """
    EJ21 - ¿float('nan') == float('nan')?
    Devuelve el resultado directamente.
    """
    # TODO
    raise NotImplementedError


def ej22_detectar_nan_sin_math(x: float) -> bool:
    """
    EJ22 - Detectar NaN SIN usar math.isnan().
    (Pista: NaN es el único valor que no es igual a sí mismo)
    """
    # TODO
    raise NotImplementedError


# =========================
# RUNNER
# =========================


def _demo():
    nan = float("nan")
    print("Ejemplo rápido:")
    print("¿nan es nan?", math.isnan(nan))


if __name__ == "__main__":
    _demo()
    print("Archivo listo. Implementa los TODO.")
