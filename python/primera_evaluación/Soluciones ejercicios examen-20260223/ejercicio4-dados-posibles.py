def main():
    print("Resultados posibles al lanzar dos dados:")
    for dado1 in range(1, 7):
        for dado2 in range(1, 7):
            print(f"Dado 1: {dado1}, Dado 2: {dado2}, Suma: {dado1 + dado2}")
            
if __name__ == "__main__":
    main()