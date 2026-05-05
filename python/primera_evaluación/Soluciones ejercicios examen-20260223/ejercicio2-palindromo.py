def es_palindromo(texto):
    texto_normalizado = texto.replace(" ", "").lower()
    return texto_normalizado == texto_normalizado[::-1]

def main():
    palabra_o_frase = input("Introduce una palabra o frase: ")
    if es_palindromo(palabra_o_frase):
        print("Es un palíndromo")
    else:
        print("No es un palíndromo")
        
if __name__ == "__main__":
    main()