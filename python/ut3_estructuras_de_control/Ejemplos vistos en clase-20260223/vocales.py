vocales = ("a","e","i","o","u")

def is_vocal(caracter):
    if caracter in vocales:
        return True
    return False

def is_vocal2(caracter):
    return caracter in vocales

def is_vocal3(caracter):
    return caracter in "aeiou"

def main():
    while True:
        caracter = input("Introduce un caracter:").lower()
        if caracter.isspace():
            break
        if is_vocal3(caracter):
            print("VOCAL")
        else:
            print("NO VOCAL")
    


if __name__ == "__main__":
    main()