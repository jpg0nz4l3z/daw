"""
EJERCICIOS DE DICCIONARIOS EN PYTHON
-----------------------------------
- Un ejercicio por función.
- Cada función tiene el enunciado en el docstring.
- Implementa tu solución donde aparece TODO.
"""

# =========================
# NIVEL 1 (BÁSICOS)
# =========================


def ej01_crear_diccionario(claves: list[str], valores: list[int]) -> dict[str, int]:
    """
    EJ01 - Crear diccionario a partir de dos listas.
    Devuelve un diccionario combinando claves y valores.
    Si las listas tienen distinta longitud, usa hasta la menor.

    Ejemplo:
    claves=["a","b","c"]
    valores=[1,2,3]
    -> {"a":1,"b":2,"c":3}
    """
    # TODO
    raise NotImplementedError


def ej02_sumar_valores(d: dict[str, int]) -> int:
    """
    EJ02 - Sumar todos los valores del diccionario.
    """
    # TODO
    raise NotImplementedError


def ej03_max_valor(d: dict[str, int]) -> str | None:
    """
    EJ03 - Devolver la clave con mayor valor.
    Si el diccionario está vacío, devuelve None.
    """
    # TODO
    raise NotImplementedError


def ej04_invertir_diccionario(d: dict[str, int]) -> dict[int, str]:
    """
    EJ04 - Invertir claves y valores.
    Asume que los valores son únicos.

    {"a":1,"b":2} -> {1:"a",2:"b"}
    """
    # TODO
    raise NotImplementedError


def ej05_contar_caracteres(texto: str) -> dict[str, int]:
    """
    EJ05 - Contar frecuencia de caracteres.
    Devuelve un diccionario con el número de veces que aparece cada carácter.

    "hola" -> {"h":1,"o":1,"l":1,"a":1}
    """
    # TODO
    raise NotImplementedError


def ej06_actualizar_valor(
    d: dict[str, int], clave: str, incremento: int
) -> dict[str, int]:
    """
    EJ06 - Incrementar valor de una clave.
    Si la clave no existe, créala con el valor incremento.
    Devuelve el diccionario actualizado.
    """
    # TODO
    raise NotImplementedError


def ej07_filtrar_por_valor(d: dict[str, int], minimo: int) -> dict[str, int]:
    """
    EJ07 - Filtrar diccionario.
    Devuelve nuevo diccionario con pares cuyo valor >= minimo.
    """
    # TODO
    raise NotImplementedError


def ej08_claves_con_valor(d: dict[str, int], valor: int) -> list[str]:
    """
    EJ08 - Devolver lista de claves que tengan cierto valor.
    """
    # TODO
    raise NotImplementedError


def ej09_eliminar_clave(d: dict[str, int], clave: str) -> dict[str, int]:
    """
    EJ09 - Eliminar una clave si existe.
    Devuelve nuevo diccionario.
    """
    # TODO
    raise NotImplementedError


def ej10_combinar_diccionarios(a: dict[str, int], b: dict[str, int]) -> dict[str, int]:
    """
    EJ10 - Combinar dos diccionarios.
    Si una clave se repite, suma los valores.

    {"a":1,"b":2} y {"b":3,"c":4}
    -> {"a":1,"b":5,"c":4}
    """
    # TODO
    raise NotImplementedError


# =========================
# NIVEL 2 (INTERMEDIO)
# =========================


def ej11_agrupar_por_paridad(nums: list[int]) -> dict[str, list[int]]:
    """
    EJ11 - Agrupar números por paridad.
    Devuelve:
    {"pares":[...], "impares":[...]}
    """
    # TODO
    raise NotImplementedError


def ej12_contar_palabras(texto: str) -> dict[str, int]:
    """
    EJ12 - Contar frecuencia de palabras.
    Ignora mayúsculas/minúsculas.
    """
    # TODO
    raise NotImplementedError


def ej13_diccionario_anidado(personas: list[tuple[str, str]]) -> dict[str, list[str]]:
    """
    EJ13 - Agrupar personas por ciudad.
    personas=[("Ana","Madrid"),("Luis","Sevilla"),("Eva","Madrid")]
    -> {"Madrid":["Ana","Eva"], "Sevilla":["Luis"]}
    """
    # TODO
    raise NotImplementedError


def ej14_ordenar_por_valor(d: dict[str, int]) -> list[tuple[str, int]]:
    """
    EJ14 - Ordenar diccionario por valor ascendente.
    Devuelve lista de tuplas (clave, valor).
    """
    # TODO
    raise NotImplementedError


def ej15_diccionario_cuadrados(n: int) -> dict[int, int]:
    """
    EJ15 - Crear diccionario de cuadrados.
    n=5 -> {1:1,2:4,3:9,4:16,5:25}
    """
    # TODO
    raise NotImplementedError


def ej16_fusionar_lista_diccionarios(lista: list[dict[str, int]]) -> dict[str, int]:
    """
    EJ16 - Fusionar lista de diccionarios.
    Suma valores de claves repetidas.
    """
    # TODO
    raise NotImplementedError


def ej17_clave_mas_frecuente(d: dict[str, int]) -> str | None:
    """
    EJ17 - Devolver la clave con valor más frecuente.
    Si vacío, None.
    """
    # TODO
    raise NotImplementedError


def ej18_verificar_subdiccionario(a: dict, b: dict) -> bool:
    """
    EJ18 - Verificar si b es subdiccionario de a.
    Es decir, si todas las claves y valores de b están en a.
    """
    # TODO
    raise NotImplementedError


def ej19_invertir_multi(d: dict[str, int]) -> dict[int, list[str]]:
    """
    EJ19 - Invertir diccionario permitiendo valores repetidos.
    {"a":1,"b":2,"c":1} -> {1:["a","c"],2:["b"]}
    """
    # TODO
    raise NotImplementedError


def ej20_promedio_valores(d: dict[str, int]) -> float:
    """
    EJ20 - Calcular promedio de los valores.
    Si vacío, devuelve 0.0
    """
    # TODO
    raise NotImplementedError


# =========================
# NIVEL 3 (RETOS)
# =========================


def ej21_matriz_a_diccionario(m: list[list[int]]) -> dict[tuple[int, int], int]:
    """
    EJ21 - Convertir matriz en diccionario.
    Clave=(fila,col), valor=elemento.
    """
    # TODO
    raise NotImplementedError


def ej22_diccionario_a_matriz(
    d: dict[tuple[int, int], int], filas: int, cols: int
) -> list[list[int]]:
    """
    EJ22 - Convertir diccionario anterior en matriz.
    Si falta una posición, poner 0.
    """
    # TODO
    raise NotImplementedError


def ej23_cache_simple(
    operaciones: list[tuple[str, int, int]],
) -> dict[tuple[int, int], int]:
    """
    EJ23 - Simular cache de suma.
    operaciones=[("suma",a,b),...]
    Guarda resultados en un diccionario para no recalcular.
    Devuelve el diccionario cache final.
    """
    # TODO
    raise NotImplementedError


def ej24_frecuencia_lista_tuplas(datos: list[tuple[str, int]]) -> dict[str, int]:
    """
    EJ24 - Sumar valores agrupados por clave.
    [("a",2),("b",3),("a",5)] -> {"a":7,"b":3}
    """
    # TODO
    raise NotImplementedError


def ej25_detectar_duplicados(lista: list[int]) -> dict[int, int]:
    """
    EJ25 - Devolver diccionario solo con elementos repetidos.
    Clave=numero, valor=cantidad (>1)
    """
    # TODO
    raise NotImplementedError


def ej26_transformar_claves(d: dict[str, int]) -> dict[str, int]:
    """
    EJ26 - Transformar claves a mayúsculas.
    """
    # TODO
    raise NotImplementedError


def ej27_producto_cartesiano(a: list[int], b: list[int]) -> dict[tuple[int, int], int]:
    """
    EJ27 - Crear diccionario con producto cartesiano.
    Clave=(x,y), valor=x*y
    """
    # TODO
    raise NotImplementedError


def ej28_contar_anagramas(palabras: list[str]) -> dict[str, list[str]]:
    """
    EJ28 - Agrupar palabras que son anagramas.
    ["roma","amor","perro"] -> {"amor":["roma","amor"],"eoprr":["perro"]}
    (clave = palabra ordenada alfabéticamente)
    """
    # TODO
    raise NotImplementedError


def ej29_actualizar_stock(
    stock: dict[str, int], ventas: list[tuple[str, int]]
) -> dict[str, int]:
    """
    EJ29 - Actualizar stock tras ventas.
    Resta cantidades vendidas.
    Si un producto no existe, ignóralo.
    """
    # TODO
    raise NotImplementedError


def ej30_simular_sistema_usuarios(eventos: list[tuple[str, str]]) -> dict[str, bool]:
    """
    EJ30 - Simular login/logout.
    eventos=[("login","ana"),("logout","ana"),("login","luis")]
    Devuelve diccionario con estado final:
    {"ana":False,"luis":True}
    """
    # TODO
    raise NotImplementedError


# =========================
# RUNNER OPCIONAL
# =========================


def _demo():
    """
    Puedes probar aquí tus funciones.
    """
    pass


if __name__ == "__main__":
    _demo()
    print("Archivo cargado. Implementa los TODO y prueba tus soluciones.")
