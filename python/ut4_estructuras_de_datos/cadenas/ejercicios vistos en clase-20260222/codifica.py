# programa que codifica una palabra siguiendo este esquema:
# - las vocales se cambian por el número de orden que ocupan en la palabra (empezando en 1)
# - las consonantes se cambian por el carácter siguiente en el alfabeto

def codifica(palabra):
    resultado = ''
    for i, letra in enumerate(palabra):
        if letra.lower() in 'aeiou':
            resultado += str(i + 1)
        else:
            resultado += chr(ord(letra) + 1)
    return resultado

       

def main():
    entrada = input("Introduzca una palabra: ")
    codificada = codifica(entrada)
    print(f"La palabra codificada es: {codificada}")
     

if __name__ == "__main__":
    main()