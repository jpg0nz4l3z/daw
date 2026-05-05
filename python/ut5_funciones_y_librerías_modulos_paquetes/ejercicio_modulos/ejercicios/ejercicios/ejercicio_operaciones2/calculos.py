import sys
import os

sys.path.insert(0, os.path.dirname(__file__))  # solo para python embebed

from operaciones_suma_resta import *
from operaciones_producto_division import *

a, b, c, d = (10, 5, 0, "Hola")

print("{} + {} = {}".format(a, b, suma(a, b)))
print("{} - {} = {}".format(b, d, resta(b, d)))
print("{} * {} = {}".format(b, b, producto(b, b)))
print(
    "{} / {} = {}".format(a, c, division(a, c))
)  # El modulo operaciones_producto_division oculta la función división por eso da error
