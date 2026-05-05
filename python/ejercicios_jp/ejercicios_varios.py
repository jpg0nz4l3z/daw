"""
Archivo: ejercicios_python.py
Ejercicios tipo examen resueltos.
Cada ejercicio está implementado como una función independiente.
"""

# =========================
# NIVEL BÁSICO
# =========================


def sumar(a, b):
    return a + b


def es_par(n):
    return n % 2 == 0


def mayor_de_tres(a, b, c):
    return max(a, b, c)


def factorial(n):
    if n < 0:
        return None
    resultado = 1
    for i in range(1, n + 1):
        resultado *= i
    return resultado


def contar_vocales(texto):
    vocales = "aeiouAEIOU"
    return sum(1 for letra in texto if letra in vocales)


def invertir_cadena(texto):
    return texto[::-1]


def es_primo(n):
    if n <= 1:
        return False
    for i in range(2, int(n**0.5) + 1):
        if n % i == 0:
            return False
    return True


def suma_lista(lista):
    return sum(lista)


def mayor_lista(lista):
    return max(lista)


def eliminar_duplicados(lista):
    return list(set(lista))


# =========================
# NIVEL INTERMEDIO
# =========================


def frecuencia_elementos(lista):
    frecuencias = {}
    for elemento in lista:
        frecuencias[elemento] = frecuencias.get(elemento, 0) + 1
    return frecuencias


def es_palindromo(texto):
    texto = texto.lower().replace(" ", "")
    return texto == texto[::-1]


def fibonacci(n):
    secuencia = []
    a, b = 0, 1
    for _ in range(n):
        secuencia.append(a)
        a, b = b, a + b
    return secuencia


def ordenar_lista(lista):
    lista = lista.copy()
    for i in range(len(lista)):
        for j in range(i + 1, len(lista)):
            if lista[i] > lista[j]:
                lista[i], lista[j] = lista[j], lista[i]
    return lista


def buscar_elemento(lista, valor):
    for i in range(len(lista)):
        if lista[i] == valor:
            return i
    return -1


def contar_palabras(texto):
    return len(texto.split())


def interseccion(lista1, lista2):
    return list(set(lista1) & set(lista2))


def decimal_a_binario(n):
    return bin(n)[2:]


def matriz_identidad(n):
    return [[1 if i == j else 0 for j in range(n)] for i in range(n)]


def transponer_matriz(matriz):
    return [list(fila) for fila in zip(*matriz)]


# =========================
# NIVEL AVANZADO
# =========================


def son_anagramas(cadena1, cadena2):
    return sorted(cadena1.replace(" ", "").lower()) == sorted(
        cadena2.replace(" ", "").lower()
    )


def segundo_mayor(lista):
    lista_unica = list(set(lista))
    if len(lista_unica) < 2:
        return None
    lista_unica.sort()
    return lista_unica[-2]


def suma_digitos(n):
    return sum(int(d) for d in str(abs(n)))


def contar_mayores_que(lista, valor):
    return sum(1 for x in lista if x > valor)


def es_potencia_de_dos(n):
    if n <= 0:
        return False
    return (n & (n - 1)) == 0


def rotar_lista(lista, k):
    k = k % len(lista)
    return lista[-k:] + lista[:-k]


def aplanar_lista(lista):
    resultado = []
    for elemento in lista:
        if isinstance(elemento, list):
            resultado.extend(aplanar_lista(elemento))
        else:
            resultado.append(elemento)
    return resultado


def contar_letras(texto):
    resultado = {}
    for letra in texto:
        if letra.isalpha():
            letra = letra.lower()
            resultado[letra] = resultado.get(letra, 0) + 1
    return resultado


def numero_armstrong(n):
    digitos = [int(d) for d in str(n)]
    potencia = len(digitos)
    return sum(d**potencia for d in digitos) == n


def mcd(a, b):
    while b:
        a, b = b, a % b
    return a


def mcm(a, b):
    return abs(a * b) // mcd(a, b)


def generar_primos_hasta(n):
    primos = []
    for num in range(2, n + 1):
        if es_primo(num):
            primos.append(num)
    return primos


def validar_parentesis(texto):
    pila = []
    pares = {")": "(", "]": "[", "}": "{"}
    for caracter in texto:
        if caracter in "([{":
            pila.append(caracter)
        elif caracter in ")]}":
            if not pila or pila.pop() != pares[caracter]:
                return False
    return len(pila) == 0


def merge_diccionarios(d1, d2):
    resultado = d1.copy()
    for clave, valor in d2.items():
        resultado[clave] = resultado.get(clave, 0) + valor
    return resultado


def es_subconjunto(lista1, lista2):
    return set(lista1).issubset(set(lista2))


def dividir_lista_en_chunks(lista, tamaño):
    return [lista[i : i + tamaño] for i in range(0, len(lista), tamaño)]


def invertir_palabras(texto):
    return " ".join(texto.split()[::-1])


def encontrar_subcadena(texto, subcadena):
    return texto.find(subcadena)


def promedio_lista(lista):
    if not lista:
        return 0
    return sum(lista) / len(lista)


# =========================
# FIN DEL ARCHIVO
# =========================
