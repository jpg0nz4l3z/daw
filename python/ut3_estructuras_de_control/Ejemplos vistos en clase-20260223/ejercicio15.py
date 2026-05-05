def mostrar_menu():
    print("Operaciones: 1) Suma 2) Resta 3) Multiplicación 4) División 5) Potencia")
    op = int(input("Selecciona la operación (1-5): "))
    return op

def main():

    num1 = int(input("Introduce el primer número: "))
    num2 = int(input("Introduce el segundo número: "))
    operacion = mostrar_menu()
    match operacion:
        case 1:
            print(f"Resultado: {num1 + num2}")
        case 2:
            print(f"Resultado: {num1 - num2}")
        case 3:
            print(f"Resultado: {num1 * num2}")
        case 4:
            if num2 != 0:
                print(f"Resultado: {num1 / num2}")
            else:
                print("Error: División por cero")
        case 5:
            print(f"Resultado: {num1 ** num2}")
        case _:
            print("Operación no válida")
 
if __name__ == "__main__":
    main()