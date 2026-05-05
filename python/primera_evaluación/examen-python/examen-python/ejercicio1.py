def main():
    numeros = input("Dame una lista de números serparados por comas (ej. 1,2,3,4,5) : ")
    
    numerosSeparados = numeros.strip().split(",")
    resultado = ""
    
    for i,numero in enumerate(numerosSeparados):
        
        if int(numero) % 2 == 0:
            numerosSeparados[i] = 0
            resultado += str(numerosSeparados[i])
        else:
            numerosSeparados[i] = 1
            resultado += str(numerosSeparados[i])

        if(i != len(numerosSeparados)-1):
            resultado += ","
    
    print("Números modificados : ", resultado)
    
if __name__ == "__main__":
    main()