
def main():
    ahorro_ene = 0
    ahorro_feb = 0
    ahorro_mar = 0
    while True:
        mes = int(input("Dime el mes?"))
        if mes == 0:
            break
        if mes > 3:
            print("mes no válido")
        else:
            ahorro = float(input("Cuánto has depositado?"))
            if mes == 1:
                ahorro_ene += ahorro
            elif mes == 2:
                ahorro_feb += ahorro
            else:
                ahorro_mar += ahorro
    total = ahorro_ene + ahorro_feb + ahorro_mar
    print(f"Totales: {ahorro_ene} {ahorro_feb} {ahorro_mar}: {total}")
    

if __name__ == "__main__":
    main()