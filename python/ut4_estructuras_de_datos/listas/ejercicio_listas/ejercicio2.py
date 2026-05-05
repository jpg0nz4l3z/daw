import random

def main():
    
    numeros = []
    
    for n in range(6):
        numeroRandom = random.randint(1,6)
        while numeroRandom in numeros:
            numeroRandom = random.randint(1,6)
        numeros.append(numeroRandom)
    
    print(numeros)

if __name__ == "__main__":
    main()