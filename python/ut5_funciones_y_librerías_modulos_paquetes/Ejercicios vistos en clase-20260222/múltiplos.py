"""
Crea un programa que pida dos número enteros al usuario
y diga si alguno de ellos es múltiplo del otro.
Crea una función EsMultiplo que reciba los dos números,
y devuelve si el primero es múltiplo del segundo.
"""


def EsMultiplo(num1, num2):
    if num2 == 0:
        return False
    return num1 % num2 == 0


def main():
    numero1 = int(input("Introduce el primer número entero: "))
    numero2 = int(input("Introduce el segundo número entero: "))

    cadena = "SI" if EsMultiplo(numero1, numero2) else "NO"
    respuesta = f"{numero1} {cadena} es múltiplo de {numero2}."
    print(respuesta)


if __name__ == "__main__":
    main()
