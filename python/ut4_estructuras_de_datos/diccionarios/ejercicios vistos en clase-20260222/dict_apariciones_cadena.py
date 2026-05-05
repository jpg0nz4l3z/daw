
frase = "Estamos en clase de Python"
diccionario = dict()

def apariciones():   
    cadena = "".join(frase.split())
    for letra in cadena.lower():
        if letra not in diccionario:
            diccionario[letra] = 0
        diccionario[letra] += 1
         
def main():
    apariciones()
    print(diccionario)
    diccionario_ordenado = dict(sorted(diccionario.items()))
    print(diccionario_ordenado)

if __name__ == "__main__":
    main()