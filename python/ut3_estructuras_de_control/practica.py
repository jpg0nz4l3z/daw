print("Programa para calcular la media de todos los pares |")
print("----------------------------------------------------")

media = 0
pares = 0
impares = 0
n = 1
contador = 1

while(n != 0):
    n = int(input("Introduce el número " + str(contador) + ": "))
    if(n != 0):
        if(n%2 == 0):
            media = media + n
            pares = pares + 1
        elif(n%2 != 0):
            impares = impares + 1
    contador = contador + 1
        

print(str(media))
print(str(pares))
print("La media es " + str(media/pares))

if(impares > 0):
    print("Habían " + str(impares) + " impares")

    
