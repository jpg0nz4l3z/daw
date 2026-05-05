def numero_con_ceros(numero):
    numeroCeros = f"{numero:04}"
    return numeroCeros


def main():
    for n in range(1, 20):
        print(f"Número con ceros: {numero_con_ceros(n)}")


if __name__ == "__main__":
    main()
