import random

def main():
    NUM_MIN = 1
    NUM_MAX = 100
    NUM_MAX_INTENTOS = 10
    num_aleatorio = random.randint(NUM_MIN,NUM_MAX)
    #print(num_aleatorio)
    for num_intentos in range(1, NUM_MAX_INTENTOS):
        intento = int(input("Introduzca un número (1-100): "))
        if intento < NUM_MIN or intento > NUM_MAX:
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