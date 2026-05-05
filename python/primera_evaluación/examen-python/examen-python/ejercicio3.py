def main():
    frase = input("Dame una frase (ej. yo soy alto): ")
    entero = input("Dame un número entero: ")
    
    palabrasFrase = frase.split(" ")
    palabrasConLongitudDelEntero = ""
    
    for i,palabra in enumerate(palabrasFrase):
        
        if(len(palabra) == int(entero) ):
            palabrasConLongitudDelEntero += palabra + ", "
    
    print("Las palabras con la longitud del entero ", entero, " son :", palabrasConLongitudDelEntero)

if __name__ == "__main__":
    main()