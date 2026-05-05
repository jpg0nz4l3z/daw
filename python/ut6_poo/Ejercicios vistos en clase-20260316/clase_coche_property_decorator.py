"""
Realiza una clase Coche con atributos que reflejen
su marca, modelo, color y matrícula.
También debe almacenar información acerca de sus características
de movimiento: motor encendido o apagado, marchaActual,
velocidadActual, subirMarcha, bajarMarcha
y aquellos que creas conveniente para manipular
su información dinámica.

Crea los métodos necesarios que permitan simular lo siguiente:
a) El coche parte de una situación de reposo.
b) Arranca.
c) Acelera e irá subiendo marchas hasta llegar a una velocidad que se ha pedido por teclado al usuario.
d) Se mantiene esa velocidad un tiempo que se ha pedido al usuario por teclado.
e) Se va desacelerando y bajando marchas hasta que el coche se pare.
f) Punto muerto y paramos el motor.

Consideraciones para la simulación:

Rangos de marcha: 1ª 0 – 30; 2ª 30 – 50; 3ª 50 – 70; 4ª 70 – 100; 5ª 100 →.
El 10% de las veces se nos cruza un gato. Para evitar pillarlo se debe simular un frenazo que pare el coche y cale el motor.
"""

import time
import random


class Coche:
    def __init__(self, marca, modelo, color, matricula):
        self.marca = marca
        self.modelo = modelo
        self.color = color
        self.matricula = matricula
        self.motor_encendido = False
        self._marcha_actual = 0
        self.velocidad_actual = 0

    @property
    def marcha_actual(self):
        return self._marcha_actual

    @marcha_actual.setter
    def marcha_actual(self, value):
        self._marcha_actual = value
        print(f"Marcha actual actualizada a: {self._marcha_actual}")

    def arrancar(self):
        if not self.motor_encendido:
            self.motor_encendido = True
            print("El coche ha arrancado.")
        else:
            print("El coche ya está encendido.")

    def acelerar(self, velocidad_objetivo):
        if not self.motor_encendido:
            print("El coche no puede acelerar porque el motor está apagado.")
            return

        while self.velocidad_actual < velocidad_objetivo:
            if random.random() < 0.1:  # 10% de probabilidad de cruzarse un gato
                print("¡Cuidado! Se ha cruzado un gato. Frenazo y calado del motor.")
                self.frenar()
                return

            self.velocidad_actual += 5  # Aumenta la velocidad en incrementos de 5 km/h
            self.actualizar_marcha()
            print(
                f"Acelerando... Velocidad actual: {self.velocidad_actual} km/h, Marcha actual: {self.marcha_actual}"
            )
            time.sleep(1)  # Simula el tiempo que tarda en acelerar

    def actualizar_marcha(self):
        match self.velocidad_actual:
            case v if v <= 30:
                if self.marcha_actual != 1:
                    self.marcha_actual = 1
            case v if v <= 50:
                if self.marcha_actual != 2:
                    self.marcha_actual = 2
            case v if v <= 70:
                if self.marcha_actual != 3:
                    self.marcha_actual = 3
            case v if v <= 100:
                if self.marcha_actual != 4:
                    self.marcha_actual = 4
            case _:
                if self.marcha_actual != 5:
                    self.marcha_actual = 5

    def mantener_velocidad(self, tiempo):
        if not self.motor_encendido:
            print("El coche no puede mantener velocidad porque el motor está apagado.")
            return

        print(
            f"Manteniendo velocidad de {self.velocidad_actual} km/h durante {tiempo} segundos."
        )
        time.sleep(tiempo)

    def desacelerar(self):
        if not self.motor_encendido:
            print("El coche no puede desacelerar porque el motor está apagado.")
            return

        while self.velocidad_actual > 0:
            self.velocidad_actual -= (
                5  # Disminuye la velocidad en incrementos de 5 km/h
            )
            self.actualizar_marcha()
            print(
                f"Desacelerando... Velocidad actual: {self.velocidad_actual} km/h, Marcha actual: {self.marcha_actual}"
            )
            time.sleep(1)  # Simula el tiempo que tarda en desacelerar
        print("El coche se ha detenido.")

    def frenar(self):
        self.velocidad_actual = 0
        self.marcha_actual = 0
        self.motor_encendido = False
        print("El coche ha frenado y el motor se ha calado.")


# Simulación del coche
if __name__ == "__main__":
    coche = Coche("Toyota", "Corolla", "Rojo", "1234 ABC")
    coche.arrancar()
    velocidad_objetivo = int(input("Introduce la velocidad objetivo (km/h): "))
    coche.acelerar(velocidad_objetivo)
    tiempo_mantener = int(
        input("Introduce el tiempo para mantener la velocidad (segundos): ")
    )
    coche.mantener_velocidad(tiempo_mantener)
    coche.desacelerar()
