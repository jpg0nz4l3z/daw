import random

def lanzar_dados():
    dado1 = random.randint(1, 6)
    dado2 = random.randint(1, 6)
    return dado1 + dado2

def main():
    print("Bienvenido al juego de Craps!")
    primera_tirada = lanzar_dados()
    print(f"Lanzaste los dados y obtuviste: {primera_tirada}")
    if primera_tirada in [7, 11]:
        print("¡Felicidades! Has ganado en la primera tirada.")
        return
    elif primera_tirada in [2, 3, 12]:
        print("Lo siento, has perdido en la primera tirada.")
        return
    else:
        punto = primera_tirada
        print(f"Tu punto es: {punto}. Ahora debes lanzar hasta obtener {punto} nuevamente o un 7 para perder.")

        while True:
            nueva_tirada = lanzar_dados()
            print(f"Lanzaste los dados y obtuviste: {nueva_tirada}")
            if nueva_tirada == punto:
                print("¡Felicidades! Has ganado al repetir tu punto.")
                break
            elif nueva_tirada == 7:
                print("Lo siento, has perdido al obtener un 7.")
                break
            
if __name__ == "__main__":
    main()