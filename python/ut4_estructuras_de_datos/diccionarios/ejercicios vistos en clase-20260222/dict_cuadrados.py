
cuadrados = {}

def cuadict():
    limite = int(input("Introduzca número límite: "))
    for num in range(1, limite + 1):
        cuadrados[num] = num ** 2


def main():
    cuadict()
    print(cuadrados)
    

if __name__ == "__main__":    
    main()
