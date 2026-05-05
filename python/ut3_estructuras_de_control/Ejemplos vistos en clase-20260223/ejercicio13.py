

def main():
    while True:
        entrada = input("Introduce un dato (escribe 'FIN' para terminar): ")
        if entrada == "FIN":
            break
        print(entrada)
        
        
def muestra_mensaje():
    print ("Hasta la vista")

if __name__ == "__main__":
    main()
    muestra_mensaje()