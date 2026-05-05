def main():
    numeros = [5,10,15,20,25] #Crea una lista de nombre numeros con los valores indicados
    pares = [] #Declara una lista vacia de nombre pares
    for n in numeros: #Itera la lista de numeros 
        if n%2 == 0: #si el modulo de dos del elemento de la lista es 0 entra en el condicional
            pares.append(n) #Agrega el elemento a la lista de pares
    resultado = [n * 3 for n in pares]# Declara una lista cuyos valores vienen dados por la multiplicaciòn * 3 de cada elemento de la lista pares
    for r in resultado: #Itera la lista resultado
        if r > 30: #Si el elemento de la lista es mayor a 30 entra en el condicional
            print(r, end=" ") #Imprime el elemento de la lista resultado, el end=" " es para que no haga salto de linea

if __name__ == "__main__":
    main()