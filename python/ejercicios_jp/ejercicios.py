import calendar
import pandas
import random
import math

# import matplotlib

# matplotlib.use("TkAgg")

import matplotlib.pyplot as plt


def hello_world_20_times():
    for i in range(20):
        print("Hello World ", i)


def module_calendar():
    print(calendar.month(2019, 4))


def array_exercise():
    numbers = []
    numbers.append(1)
    numbers.append(2)
    numbers.append(3)

    print(numbers[0])

    for i in numbers:
        print(i)

    nombres = ["Juan", "Grabriela", "Camilo"]

    for count, nombre in enumerate(nombres):
        print(nombre, str(count + 1))

    personas = [("Juan", 25), ("Gabriela", 30), ("Camilo", 22)]

    for i, (nombre, edad) in enumerate(personas, start=1):
        print(i, nombre, edad)


def bar_diagram_matplot():
    nombres = ["María", "Mercedes", "Miriam", "Mónica"]
    calificaciones = [[2, 4.5, 9], [5, 3, 10], [7.5, 8.3, 9], [4, 6.5, 7]]
    df = pandas.DataFrame({"Nombre": nombres, "Calificaciones": calificaciones})
    medias = []
    for x in df["Calificaciones"]:
        medias.append(sum(x) / len(x))
    df["Media"] = medias
    cnt = 0
    plt.bar(df["Nombre"], df["Media"], color="darkorchid")
    plt.xlabel("Estudiantes")
    plt.ylabel("Medias")
    plt.title("Medias de calificaciones por estudiante")
    for i in df["Media"]:
        plt.text(cnt, i, f"{i:.4f}", ha="center", va="bottom")
        cnt += 1
    # plt.show()
    plt.savefig("grafica.png")


def dispersion_diagram():
    def cuadrada(num):
        return math.sqrt(num)

    numeros = []
    raices = []
    for i in range(0, 20):
        x = random.randint(0, 100)
        numeros.append(x)
        raices.append(cuadrada(x))
    plt.scatter(numeros, raices, color="red")
    plt.xlabel("Número")
    plt.ylabel("Raíz cuadrada")
    plt.title("Gráfico de dispersión de números y sus raíces")
    # plt.show()
    plt.savefig("dispersion.png")


def tuple_exercise():
    nombres = ("Juan", "Gabriela", "Camilo")

    for count, nombre in enumerate(nombres):
        print(nombre, count)


def main():
    # hello_world_20_times()
    # array_exercise()
    # tuple_exercise()
    # module_calendar()
    # bar_diagram_matplot()
    dispersion_diagram()


if __name__ == "__main__":
    main()
