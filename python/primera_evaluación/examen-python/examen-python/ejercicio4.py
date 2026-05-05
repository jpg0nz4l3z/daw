def main():
    print("dado 1 ,  dado 2")
    print("-----------------")
    
    contador = 1
    for dado1 in range(1,7):
        for dado2 in range(dado1,7):
            print(dado1, "     ,      ", dado2, " resultado", contador)
            contador = contador+1
            
if __name__ == "__main__":
    main()