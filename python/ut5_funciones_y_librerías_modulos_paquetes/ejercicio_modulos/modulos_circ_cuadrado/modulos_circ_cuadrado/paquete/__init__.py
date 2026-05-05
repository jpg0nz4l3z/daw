# publicamos area de circunferencia para no tener que
# calificar el módulo circunferencia
from .circunferencia import area

# publicamos cuadrado tal cual está en la jerarquía de módulos
# si no incluimos este import, lo estaríamos ocultando
from . import cuadrado
