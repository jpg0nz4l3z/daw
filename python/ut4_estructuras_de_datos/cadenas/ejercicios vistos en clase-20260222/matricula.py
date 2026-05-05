# generar matricula aleatoria con random.choices formato NNNN XXX
import random
import string


# Generar matrícula aleatoria
def generar_matricula():
    numeros = "".join(random.choices(string.digits, k=4))
    letras = "".join(random.choices(string.ascii_uppercase, k=3))
    return f"{numeros} {letras}"


# Generar matrícula secuencial usando chr desde la 0000 AAA a 9999 ZZZ
def generar_matricula_chr():
    for i in range(10000):
        numeros = f"{i:04}"  # rellenar con ceros (0) hasta cuatro dígitos
        letras = "".join(chr(65 + j) for j in range(3))
        print(f"{numeros} {letras}", end="")


def main():
    generar_matricula_chr()

    for m in range(10):
        matricula = generar_matricula()
        print(f"Matrícula generada: {matricula}")


if __name__ == "__main__":
    main()
