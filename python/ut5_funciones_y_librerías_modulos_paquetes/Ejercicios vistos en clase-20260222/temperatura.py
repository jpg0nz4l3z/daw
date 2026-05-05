"""
Crear una función que calcule la temperatura media 
de un día a partir de la temperatura máxima y mínima. 
Crear un programa principal, que utilizando la función 
anterior, vaya pidiendo la temperatura máxima y mínima 
de cada día y vaya mostrando la media. 
El programa pedirá el número de días que se van a introducir.
"""

def temperatura_media(temp_max, temp_min):
    return (temp_max + temp_min) / 2

def main():
    num_dias = int(input("Introduce el número de días: "))
    for dia in range(1, num_dias + 1):
        temp_max = float(input(f"Introduce la temperatura máxima del día {dia}: "))
        temp_min = float(input(f"Introduce la temperatura mínima del día {dia}: "))
        media = temperatura_media(temp_max, temp_min)
        print(f"La temperatura media del día {dia} es: {media:.2f}")

if __name__ == "__main__":
    main()