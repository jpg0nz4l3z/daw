import random


def lanzar_dados():
    dado1 = random.randint(1, 6)
    dado2 = random.randint(1, 6)

    return dado1 + dado2


def main():
    print("Bienvenido al juego CRAPS")

    try:
        if int(input("Escribe 1 para realizar un lanzamiento de dados: ")) == 1:
            puntuacion = lanzar_dados()
        else:
            print("Bye!!")
            return

        print("Tu puntuación fué : ", puntuacion)

        if puntuacion == 7 or puntuacion == 11:
            print("Felicidades Ganaste")
            return
        elif puntuacion == 2 or puntuacion == 3 or puntuacion == 12:
            print("Mala suerte perdiste")
        elif (
            puntuacion == 4
            or puntuacion == 5
            or puntuacion == 6
            or puntuacion == 8
            or puntuacion == 9
            or puntuacion == 10
        ):

            if int(input("Si quieres lanzar de nuevo escribe 1: ")) == 1:
                siguientePuntuacion = lanzar_dados()
            else:
                print("Bye!!")
                return

            while siguientePuntuacion != puntuacion:

                if siguientePuntuacion == 7:
                    print(
                        "Mala suerte, tu nueva puntuación fuè ",
                        siguientePuntuacion,
                        " perdiste",
                    )
                    return
                print(
                    "Tu nueva puntuación es ",
                    siguientePuntuacion,
                    ", que no es igual a la primera que fué ",
                    puntuacion,
                    " sigue intentando",
                )
                if int(input("Si quieres lanzar de nuevo escribe 1: ")) == 1:
                    siguientePuntuacion = lanzar_dados()
                else:
                    print("Bye!!")
                    return

            print("Felicidades Ganaste ")
            print(
                "Puntuación 1 : ", puntuacion, "\nPuntuaciñon 2: ", siguientePuntuacion
            )
    except:
        print("Bye!!")
        return


if __name__ == "__main__":
    main()
