"""
Crea una función “calcularMaxMin” que recibe una lista 
con valores numéricos y devuelve el valor máximo y el mínimo. 
Crea un programa que pida números por teclado y muestre 
el máximo y el mínimo, utilizando la función anterior.
"""

def calcularMaxMin(lista_numeros):
    if not lista_numeros:
        return None, None
    maximo = max(lista_numeros)
    minimo = min(lista_numeros)
    return maximo, minimo

def main():
    numeros = []
    while True:
        entrada = input("Introduce un número (o 'fin' para terminar): ")
        if entrada.lower() == 'fin':
            break
        try:
            numero = float(entrada)
            numeros.append(numero)
        except ValueError:
            print("Por favor, introduce un número válido.")

    maximo, minimo = calcularMaxMin(numeros)
    if maximo is not None and minimo is not None:
        print(f"El valor máximo es: {maximo}")
        print(f"El valor mínimo es: {minimo}")
    else:
        print("No se introdujeron números.")

if __name__ == "__main__":
    main()