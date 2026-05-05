import random

def main():
    num_aleatorio = random.randint(1,100)
    #print(num_aleatorio)
    num_intentos = 0
    while num_intentos < 10:
        intento = int(input("Introduzca un número (1-100): "))
        num_intentos = num_intentos + 1
        if intento < 1 or intento > 100:
            print("Número no válido")
        elif intento < num_aleatorio:
            print("Es menor que el número a adivinar")
        elif intento > num_aleatorio:
            print("Es mayor que el número a adivinar")
        else: 
            print("Enhorabuena! acertaste")
            print(f"Número de intentos: {num_intentos}")
            break
    print(f"Número generado: {num_aleatorio}")
    
if __name__ == "__main__":
    main()