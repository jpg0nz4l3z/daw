"""
Crear una subrutina llamada “Login”, 
que recibe un nombre de usuario y una contraseña 
y te devuelve Verdadero si el nombre de usuario es “usuario1”
 y la contraseña es “asdasd”. 
Además recibe el número de intentos que se ha intentado
 hacer login y si no se ha podido hacer login incremente
   este valor.
Crear un programa principal donde se pida un nombre 
de usuario y una contraseña y se intente hacer login,
 solamente tenemos tres oportunidades para intentarlo.
"""

def Login(nombre_usuario, contrasena, intentos):
    if nombre_usuario == "usuario1" and contrasena == "asdasd":
        return True
    else:
        intentos += 1
        return False, intentos
    
def main():
    intentos = 0
    max_intentos = 3

    while intentos < max_intentos:
        nombre_usuario = input("Introduce el nombre de usuario: ")
        contrasena = input("Introduce la contraseña: ")
        
        resultado = Login(nombre_usuario, contrasena, intentos)
        
        if resultado is True:
            print("Login exitoso.")
            break
        else:
            intentos = resultado[1]
            print(f"Login fallido. Intento {intentos} de {max_intentos}.")
    else:
        print("Has superado el número máximo de intentos.")

if __name__ == "__main__":
    main()