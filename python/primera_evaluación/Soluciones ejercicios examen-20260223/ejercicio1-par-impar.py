def main():
    entrada = input("Introduce una lista de números separados por comas: ")
    numeros = entrada.split(",")
    for num in numeros:
        num = num.strip() # Eliminar espacios en blanco
        if num.isdigit(): # Verificar que es un número válido
            if int(num) % 2 == 0:
                print ("0")
            else:
                print("1")
        else:
            print("no es un número válido")
                
if __name__ == "__main__":
    main()