"""
Ejercicios de LISTAS y TUPLAS en Python
--------------------------------------
- Un ejercicio por función.
- Cada función tiene un docstring con el enunciado y ejemplos.
- Deja tu solución en el bloque TODO.

Sugerencia:
- Empieza por los "nivel 1", y sube.
"""

from __future__ import annotations


# =========================
# NIVEL 1 (básicos)
# =========================


def ej01_sumar_lista(nums: list[int]) -> int:
    """
    EJ01 - Sumar elementos de una lista.
    Devuelve la suma de todos los enteros en nums.

    Ejemplo:
    - [1, 2, 3] -> 6
    """
    # TODO: implementa
    raise NotImplementedError


def ej02_maximo_lista(nums: list[int]) -> int:
    """
    EJ02 - Máximo de una lista.
    Devuelve el valor máximo en nums (asume lista no vacía).

    Ejemplo:
    - [3, 1, 9, 2] -> 9
    """
    # TODO
    raise NotImplementedError


def ej03_minimo_lista(nums: list[int]) -> int:
    """
    EJ03 - Mínimo de una lista.
    Devuelve el valor mínimo en nums (asume lista no vacía).
    """
    # TODO
    raise NotImplementedError


def ej04_contar_ocurrencias(nums: list[int], x: int) -> int:
    """
    EJ04 - Contar ocurrencias.
    Devuelve cuántas veces aparece x en nums.

    Ejemplo:
    - nums=[1,2,2,2,3], x=2 -> 3
    """
    # TODO
    raise NotImplementedError


def ej05_invertir_lista(nums: list[int]) -> list[int]:
    """
    EJ05 - Invertir lista (sin usar reversed() ni [::-1]).
    Devuelve una nueva lista con los elementos en orden inverso.

    Ejemplo:
    - [1,2,3] -> [3,2,1]
    """
    # TODO
    raise NotImplementedError


def ej06_encontrar_indice(nums: list[int], x: int) -> int:
    """
    EJ06 - Encontrar índice.
    Devuelve el índice de la primera aparición de x, o -1 si no está.

    Ejemplo:
    - [10,20,30], 20 -> 1
    - [10,20,30], 99 -> -1
    """
    # TODO
    raise NotImplementedError


def ej07_filtrar_pares(nums: list[int]) -> list[int]:
    """
    EJ07 - Filtrar pares.
    Devuelve una lista con los números pares de nums, manteniendo orden.

    Ejemplo:
    - [1,2,3,4,6] -> [2,4,6]
    """
    # TODO
    raise NotImplementedError


def ej08_filtrar_mayores(nums: list[int], umbral: int) -> list[int]:
    """
    EJ08 - Filtrar mayores que un umbral.
    Devuelve los elementos estrictamente mayores que umbral.
    """
    # TODO
    raise NotImplementedError


def ej09_concatenar_listas(a: list[int], b: list[int]) -> list[int]:
    """
    EJ09 - Concatenar dos listas sin usar +.
    Devuelve nueva lista con elementos de a seguidos de b.
    """
    # TODO
    raise NotImplementedError


def ej10_insertar_en_posicion(nums: list[int], i: int, x: int) -> list[int]:
    """
    EJ10 - Insertar en posición.
    Devuelve una nueva lista igual a nums pero insertando x en índice i.
    Si i < 0, inserta al inicio. Si i > len(nums), inserta al final.

    Ejemplo:
    - nums=[1,2,3], i=1, x=99 -> [1,99,2,3]
    """
    # TODO
    raise NotImplementedError


def ej11_eliminar_primera_aparicion(nums: list[int], x: int) -> list[int]:
    """
    EJ11 - Eliminar primera aparición.
    Devuelve una nueva lista con la primera aparición de x eliminada.
    Si x no está, devuelve copia igual.

    Ejemplo:
    - [1,2,2,3], x=2 -> [1,2,3]
    """
    # TODO
    raise NotImplementedError


def ej12_sin_duplicados_orden(nums: list[int]) -> list[int]:
    """
    EJ12 - Quitar duplicados manteniendo orden.
    Devuelve una lista con los elementos únicos, conservando la primera aparición.

    Ejemplo:
    - [1,2,1,3,2] -> [1,2,3]
    """
    # TODO
    raise NotImplementedError


# =========================
# TUPLAS (básico)
# =========================


def ej13_swap_tupla(t: tuple[int, int]) -> tuple[int, int]:
    """
    EJ13 - Intercambiar valores en tupla.
    Dada t=(a,b), devuelve (b,a).
    """
    # TODO
    raise NotImplementedError


def ej14_sumar_tupla(t: tuple[int, ...]) -> int:
    """
    EJ14 - Sumar elementos de una tupla.
    Devuelve la suma.
    """
    # TODO
    raise NotImplementedError


def ej15_desempaquetar_persona(persona: tuple[str, int, str]) -> str:
    """
    EJ15 - Desempaquetado.
    persona=(nombre, edad, ciudad) -> Devuelve un string:
    "Nombre tiene X años y vive en Ciudad".

    Ejemplo:
    - ("Ana", 20, "Madrid") -> "Ana tiene 20 años y vive en Madrid"
    """
    # TODO
    raise NotImplementedError


# =========================
# NIVEL 2 (intermedio)
# =========================


def ej16_rotar_derecha(nums: list[int], k: int) -> list[int]:
    """
    EJ16 - Rotar una lista a la derecha k posiciones.
    k puede ser mayor que len(nums).
    Devuelve una nueva lista.

    Ejemplo:
    - nums=[1,2,3,4,5], k=2 -> [4,5,1,2,3]
    """
    # TODO
    raise NotImplementedError


def ej17_intercalar(a: list[int], b: list[int]) -> list[int]:
    """
    EJ17 - Intercalar dos listas.
    Mezcla a y b alternando elementos. Si una se acaba, añade el resto.

    Ejemplo:
    - a=[1,2,3], b=[10,20] -> [1,10,2,20,3]
    """
    # TODO
    raise NotImplementedError


def ej18_segmentar_por_signo(nums: list[int]) -> tuple[list[int], list[int], list[int]]:
    """
    EJ18 - Segmentar por signo.
    Devuelve (negativos, ceros, positivos) como 3 listas.

    Ejemplo:
    - [-1,0,2,0,-3,4] -> ([-1,-3],[0,0],[2,4])
    """
    # TODO
    raise NotImplementedError


def ej19_comprobar_ordenada(nums: list[int]) -> bool:
    """
    EJ19 - Comprobar si está ordenada (no decreciente).
    Devuelve True si nums[i] <= nums[i+1] para todo i.
    """
    # TODO
    raise NotImplementedError


def ej20_segundo_mayor(nums: list[int]) -> int | None:
    """
    EJ20 - Segundo mayor distinto.
    Devuelve el segundo mayor valor DISTINTO.
    Si no existe (menos de 2 distintos), devuelve None.

    Ejemplo:
    - [5,1,5,3] -> 3
    - [2,2,2] -> None
    """
    # TODO
    raise NotImplementedError


def ej21_frecuencia(nums: list[int]) -> list[tuple[int, int]]:
    """
    EJ21 - Frecuencia como lista de tuplas.
    Devuelve una lista de tuplas (valor, conteo), en el orden de primera aparición.

    Ejemplo:
    - [2,1,2,3,1,2] -> [(2,3),(1,2),(3,1)]
    """
    # TODO
    raise NotImplementedError


def ej22_matriz_transpuesta(m: list[list[int]]) -> list[list[int]]:
    """
    EJ22 - Transponer matriz.
    m es una lista de listas (todas las filas misma longitud).
    Devuelve la transpuesta.

    Ejemplo:
    - [[1,2,3],[4,5,6]] -> [[1,4],[2,5],[3,6]]
    """
    # TODO
    raise NotImplementedError


def ej23_aplanar(m: list[list[int]]) -> list[int]:
    """
    EJ23 - Aplanar lista de listas.
    Devuelve una lista con todos los elementos en orden.
    """
    # TODO
    raise NotImplementedError


def ej24_particionar(nums: list[int], tam: int) -> list[list[int]]:
    """
    EJ24 - Particionar en bloques.
    Divide nums en sublistas de tamaño tam. El último bloque puede ser más pequeño.
    Asume tam > 0.

    Ejemplo:
    - [1,2,3,4,5], tam=2 -> [[1,2],[3,4],[5]]
    """
    # TODO
    raise NotImplementedError


def ej25_eliminar_en_rango(nums: list[int], a: int, b: int) -> list[int]:
    """
    EJ25 - Eliminar elementos en rango [a,b] (inclusive) por valor.
    Devuelve una nueva lista sin los elementos x donde a <= x <= b.

    Ejemplo:
    - nums=[1,3,5,7,9], a=4, b=8 -> [1,3,9]
    """
    # TODO
    raise NotImplementedError


def ej26_interseccion_unicos(a: list[int], b: list[int]) -> list[int]:
    """
    EJ26 - Intersección (únicos, orden de aparición según a).
    Devuelve elementos que estén en a y también en b, sin repetidos,
    respetando el orden en que aparecen en a.

    Ejemplo:
    - a=[1,2,2,3,4], b=[2,4,4,9] -> [2,4]
    """
    # TODO
    raise NotImplementedError


def ej27_union_unicos(a: list[int], b: list[int]) -> list[int]:
    """
    EJ27 - Unión (únicos, orden estable).
    Devuelve una lista con los elementos únicos de a y luego los de b
    que aún no hayan aparecido.

    Ejemplo:
    - a=[1,2,2], b=[2,3] -> [1,2,3]
    """
    # TODO
    raise NotImplementedError


def ej28_diferencia(a: list[int], b: list[int]) -> list[int]:
    """
    EJ28 - Diferencia (a - b).
    Devuelve elementos de a que NO estén en b, manteniendo orden.
    """
    # TODO
    raise NotImplementedError


def ej29_mover_ceros_al_final(nums: list[int]) -> list[int]:
    """
    EJ29 - Mover ceros al final (estable).
    Devuelve una nueva lista donde todos los 0 van al final,
    manteniendo el orden relativo del resto.

    Ejemplo:
    - [0,1,0,3,0,2] -> [1,3,2,0,0,0]
    """
    # TODO
    raise NotImplementedError


def ej30_comprimir_rle(nums: list[int]) -> list[tuple[int, int]]:
    """
    EJ30 - Compresión RLE (run-length encoding).
    Devuelve lista de tuplas (valor, repeticiones consecutivas).

    Ejemplo:
    - [1,1,1,2,2,5] -> [(1,3),(2,2),(5,1)]
    """
    # TODO
    raise NotImplementedError


def ej31_descomprimir_rle(rle: list[tuple[int, int]]) -> list[int]:
    """
    EJ31 - Descompresión RLE.
    Inversa de ej30: (valor, veces) -> lista expandida.

    Ejemplo:
    - [(1,3),(2,2),(5,1)] -> [1,1,1,2,2,5]
    """
    # TODO
    raise NotImplementedError


# =========================
# TUPLAS (intermedio)
# =========================


def ej32_split_en_pares(nums: list[int]) -> list[tuple[int, int]]:
    """
    EJ32 - Convertir lista en lista de tuplas por pares.
    Agrupa (nums[0],nums[1]), (nums[2],nums[3]), ...
    Si la lista tiene longitud impar, ignora el último.

    Ejemplo:
    - [1,2,3,4,5] -> [(1,2),(3,4)]
    """
    # TODO
    raise NotImplementedError


def ej33_zip_manual(a: list[int], b: list[int]) -> list[tuple[int, int]]:
    """
    EJ33 - Zip manual (sin usar zip()).
    Devuelve una lista de tuplas emparejando hasta el mínimo tamaño.

    Ejemplo:
    - [1,2,3] y [10,20] -> [(1,10),(2,20)]
    """
    # TODO
    raise NotImplementedError


def ej34_unzip(pares: list[tuple[int, int]]) -> tuple[list[int], list[int]]:
    """
    EJ34 - Unzip.
    Convierte lista de tuplas en dos listas: (xs, ys).

    Ejemplo:
    - [(1,10),(2,20)] -> ([1,2],[10,20])
    """
    # TODO
    raise NotImplementedError


def ej35_ordenar_por_segundo(pares: list[tuple[int, int]]) -> list[tuple[int, int]]:
    """
    EJ35 - Ordenar tuplas por el segundo elemento (ascendente).
    Devuelve nueva lista ordenada.
    """
    # TODO
    raise NotImplementedError


# =========================
# NIVEL 3 (retos)
# =========================


def ej36_sublista_mas_larga_sin_repetidos(nums: list[int]) -> tuple[int, int]:
    """
    EJ36 - Sublista más larga sin repetidos (ventana deslizante).
    Devuelve (inicio, fin) inclusive de la sublista más larga sin elementos repetidos.
    Si hay empate, devuelve la primera.

    Ejemplo:
    - [1,2,3,2,4,5] -> (2,5) porque [3,2,4,5] longitud 4
    """
    # TODO
    raise NotImplementedError


def ej37_dos_sum(nums: list[int], objetivo: int) -> tuple[int, int] | None:
    """
    EJ37 - Two Sum (índices).
    Devuelve una tupla (i,j) con i<j tal que nums[i]+nums[j]=objetivo.
    Si hay varias, devuelve la primera que encuentres de izquierda a derecha.
    Si no hay, None.

    Ejemplo:
    - nums=[2,7,11,15], objetivo=9 -> (0,1)
    """
    # TODO
    raise NotImplementedError


def ej38_productos_sin_el_propio(nums: list[int]) -> list[int]:
    """
    EJ38 - Producto de todos excepto el propio (sin división).
    Devuelve lista out donde out[i] = producto(nums[j] para j!=i).
    Maneja ceros correctamente.

    Ejemplo:
    - [1,2,3,4] -> [24,12,8,6]
    """
    # TODO
    raise NotImplementedError


def ej39_mediana(nums: list[int]) -> float:
    """
    EJ39 - Mediana.
    Devuelve la mediana como float.
    Si longitud impar: elemento central de la lista ordenada.
    Si par: promedio de los dos centrales.

    Ejemplo:
    - [3,1,2] -> 2.0
    - [1,2,3,4] -> 2.5
    """
    # TODO
    raise NotImplementedError


def ej40_k_esimo_menor(nums: list[int], k: int) -> int:
    """
    EJ40 - k-ésimo menor (1-indexado).
    Devuelve el k-ésimo menor elemento de nums (k=1 => mínimo).
    Asume 1 <= k <= len(nums).
    (Reto: intenta hacerlo sin ordenar toda la lista.)
    """
    # TODO
    raise NotImplementedError


def ej41_buscar_en_matriz(m: list[list[int]], x: int) -> tuple[int, int] | None:
    """
    EJ41 - Buscar en matriz ordenada.
    Supón que:
    - cada fila está ordenada ascendente
    - la primera de cada fila es >= la última de la fila anterior
    (equivale a lista ordenada "aplanada")
    Devuelve (fila, col) donde está x, o None.

    Ejemplo:
    - [[1,3,5],[7,9,11]], x=9 -> (1,1)
    """
    # TODO
    raise NotImplementedError


def ej42_sumas_prefijo(nums: list[int]) -> list[int]:
    """
    EJ42 - Sumas prefijo.
    Devuelve una lista p donde p[i] = suma(nums[0..i]).

    Ejemplo:
    - [1,2,3] -> [1,3,6]
    """
    # TODO
    raise NotImplementedError


def ej43_rango_suma(p: list[int], i: int, j: int) -> int:
    """
    EJ43 - Suma en rango usando prefijos.
    Dada lista p de sumas prefijo (como en ej42),
    devuelve suma original de nums[i..j] inclusive.

    Ejemplo:
    - nums=[1,2,3,4], p=[1,3,6,10], i=1, j=3 -> 9 (2+3+4)
    """
    # TODO
    raise NotImplementedError


def ej44_reordenar_por_paridad(nums: list[int]) -> list[int]:
    """
    EJ44 - Reordenar por paridad (estable).
    Devuelve primero impares y luego pares (o al revés, tú decides),
    pero debe ser estable y lo indicas en tu solución.

    Ejemplo (si impares primero):
    - [3,2,1,4] -> [3,1,2,4]
    """
    # TODO
    raise NotImplementedError


def ej45_tuplas_a_diccionario(pares: list[tuple[str, int]]) -> dict[str, int]:
    """
    EJ45 - Convertir lista de tuplas a diccionario.
    Si una clave se repite, quédate con el último valor.

    Ejemplo:
    - [("a",1),("b",2),("a",9)] -> {"a":9,"b":2}
    """
    # TODO
    raise NotImplementedError


def ej46_agrupar_por_longitud(palabras: list[str]) -> list[tuple[int, list[str]]]:
    """
    EJ46 - Agrupar por longitud.
    Devuelve lista de tuplas (longitud, [palabras]) ordenada por longitud ascendente.
    Mantén el orden de aparición dentro de cada grupo.

    Ejemplo:
    - ["sol","luna","mar","cielo"] -> [(3,["sol","mar"]), (4,["luna"]), (5,["cielo"])]
    """
    # TODO
    raise NotImplementedError


def ej47_validar_parentesis(s: str) -> bool:
    """
    EJ47 - Validar paréntesis usando lista como pila.
    s contiene solo '()'.
    Devuelve True si está balanceada.

    Ejemplo:
    - "(()())" -> True
    - "())(" -> False
    """
    # TODO
    raise NotImplementedError


def ej48_pila_operaciones(ops: list[tuple[str, int | None]]) -> list[int]:
    """
    EJ48 - Simular pila con operaciones.
    ops es lista de tuplas (op, valor):
    - ("push", x): apila x
    - ("pop", None): desapila (si está vacía, no hace nada)
    Devuelve el contenido final de la pila como lista (fondo->cima).

    Ejemplo:
    - [("push",1),("push",2),("pop",None),("push",3)] -> [1,3]
    """
    # TODO
    raise NotImplementedError


def ej49_colas_con_listas(eventos: list[tuple[str, str]]) -> list[str]:
    """
    EJ49 - Simular cola.
    eventos: ("enqueue", nombre) o ("dequeue", None) representado como ("dequeue","")
    (para evitar None si prefieres strings).
    Devuelve el estado final de la cola.

    Ejemplo:
    - [("enqueue","A"),("enqueue","B"),("dequeue",""),("enqueue","C")] -> ["B","C"]
    """
    # TODO
    raise NotImplementedError


def ej50_mezclar_tuplas(t1: tuple[int, ...], t2: tuple[int, ...]) -> tuple[int, ...]:
    """
    EJ50 - Mezclar dos tuplas alternando elementos.
    Devuelve una tupla con alternancia; si una se acaba, añade el resto.

    Ejemplo:
    - (1,2,3) y (10,20) -> (1,10,2,20,3)
    """
    # TODO
    raise NotImplementedError


# =========================
# Runner opcional (para ti)
# =========================


def _demo():
    """
    Puedes ir probando aquí tus funciones conforme las implementes.
    Deja los ejemplos y ve descomentando cuando completes cada ejercicio.
    """
    pass


if __name__ == "__main__":
    _demo()
    print("Archivo cargado. Implementa las funciones (TODO) y prueba en _demo().")
