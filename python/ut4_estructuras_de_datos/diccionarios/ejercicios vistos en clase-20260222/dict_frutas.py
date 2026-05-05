
frutas_precios = {"pera": 2.59, "manzana": 1.95, "plátano": 2.20 }


def main():
    while True:
        fruta = input("Introduzca nombre de fruta: ")
        cantidad = int(input("Introduzca cantidad: "))
        if fruta in frutas_precios:    
            precio_final = frutas_precios[fruta] * cantidad 
            print(f"El precio de {cantidad}Kg de {fruta}s a {frutas_precios[fruta]} es: {precio_final}")
            salir = input("¿Quiere hacer otra consulta? (S/N)")
            if salir.lower() == "S":
                break 
        else:
            print("La fruta no existe")

if __name__ == "__main__":
    main()