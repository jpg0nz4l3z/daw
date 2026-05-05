"""
Crea un función EscribirCentrado, que reciba como parámetro
un texto y lo escriba centrado en pantalla
(suponiendo una anchura de 80 columnas;
pista: deberás escribir 40 - longitud/2
espacios antes del texto).
Además subraya el mensaje utilizando el carácter =
"""


def EscribirCentrado(texto):
    longitud = len(texto)
    espacios = (80 - longitud) // 2  # división entera
    print(" " * espacios + texto)
    print(" " * espacios + "=" * longitud)


def main():
    mensaje = input("Introduce un mensaje: ")
    EscribirCentrado(mensaje)


if __name__ == "__main__":
    main()
