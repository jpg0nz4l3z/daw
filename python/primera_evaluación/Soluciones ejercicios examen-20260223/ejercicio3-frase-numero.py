def main():
    frase = input("Introduce una frase: ")
    longitud = int(input("Introduce un número entero: "))
    palabras = frase.split()
    for palabra in palabras:
        if len(palabra) == longitud:
            print(palabra)

if __name__ == "__main__":
    main()