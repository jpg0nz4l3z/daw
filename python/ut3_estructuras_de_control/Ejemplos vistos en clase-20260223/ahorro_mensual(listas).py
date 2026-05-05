
def main():
    ahorros = []
    for i in range(3):
        ahorros.append(0.0)
    # otra manera de inicializar
    #ahorros = [0.0, 0.0, 0.0]
        
    while True:
        mes = int(input("Dime el mes?"))
        if mes == 0:
            break
        if mes > 3:
            print("mes no válido")
        else:
            ahorro = float(input("Cuánto has depositado?"))
            if mes == 1:
                ahorros[0] += ahorro
            elif mes == 2:
                ahorros[1] += ahorro
            else:
                ahorros[2] += ahorro
    total = 0.0
    for i,ahorro_x_mes in enumerate(ahorros):
        total += ahorro_x_mes
        print(i, "--" , ahorro_x_mes)
    print(f"Totales: {ahorros[0]} {ahorros[1]} {ahorros[2]}: {total}")
    

if __name__ == "__main__":
    main()