def main():
    frase = input("Indica una frase (ej. hoy es martes): ")
    #AlxlA
    fraseFormateada = frase.lower().replace(" ", "")
    palindromo = True
    
    for i in range(0, (len(frase)//2)):
        if(fraseFormateada[i] != fraseFormateada[len(fraseFormateada)-1 - i]):
            palindromo = False
            break
    
    if(palindromo):
        print("Es palìndromo")
    else:
        print("No es palìndromo")

if __name__ == "__main__":
    main()