"""
Crea un función “ConvertirEspaciado”, 
que reciba como parámetro un texto 
y devuelve una cadena con un espacio adicional 
tras cada letra. 
Por ejemplo, “Hola, tú” devolverá “H o l a , t ú “. 
Crea un programa principal donde se use dicha función.
"""

def ConvertirEspaciado(texto):
    resultado = ''
    for caracter in texto:
        resultado += caracter + ' '
    return resultado.strip()

def main():
    texto = input("Introduce un texto: ")
    print(ConvertirEspaciado(texto))

if __name__ == "__main__":
    main()