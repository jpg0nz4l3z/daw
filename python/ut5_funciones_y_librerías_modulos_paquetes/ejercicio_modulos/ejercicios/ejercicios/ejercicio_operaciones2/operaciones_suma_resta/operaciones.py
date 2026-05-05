def suma(a,b):
    resultado = 0
    try:
        resultado = a + b
    finally:
        print("Error de valor invalido")
    
    return resultado

def resta(a,b):
    resultado = 0
    try:
        resultado = a - b
    except TypeError:
        print("Tipo de dato invalido")
    finally:
        print("Error de valor invalido")
    
    return resultado
