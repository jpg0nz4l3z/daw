class Vehiculo:  # clase padre

    def __init__(self, color: str, kilometros_recorridos: float = 0):
        self._color = color
        self._kilometros_recorridos = kilometros_recorridos
        self._kilometros_totales = kilometros_recorridos

    @property
    def color(self) -> str:
        return self._color

    @color.setter
    def color(self, valor: str):
        self._color = valor

    @property
    def kilometros_recorridos(self) -> float:
        return self._kilometros_recorridos

    @property
    def kilometros_totales(self) -> float:
        return self._kilometros_totales

    def andar(self, km: float):
        if km > 0:
            self._kilometros_recorridos += km
            self._kilometros_totales += km


class Bicicleta(Vehiculo):  # clase hija de vehículo

    LIMITE_KM = 10_000

    def __init__(self, color: str, kilometros_recorridos: float = 0):
        super().__init__(color, kilometros_recorridos)

    def andar(self, km: float):
        super().andar(km)
        print(f"Has pedaleado {km} km con la bicicleta.")

    def hacer_caballito(self):
        km = 0.5
        super().andar(km)
        print(f"Has hecho el caballito con la bicicleta. (+{km} km)")

    def ver_kilometraje(self):
        print(f"\n--- Kilometraje Bicicleta ---")
        print(f"  Color: {self._color}")
        print(f"  Km recorridos: {self._kilometros_recorridos}")
        print(f"  Km totales:    {self._kilometros_totales}")
        if self._kilometros_totales > self.LIMITE_KM:
            print(
                f"  AVISO: La bicicleta supera los {self.LIMITE_KM:,} km. "
                f"Se recomienda cambiar el vehiculo."
            )

    def __str__(self):
        return (
            f"Bicicleta - Color: {self._color} | "
            f"Km recorridos: {self._kilometros_recorridos} | "
            f"Km totales: {self._kilometros_totales}"
        )


class Coche(Vehiculo):  # clase hija de vehículo

    LIMITE_KM = 100_000

    def __init__(self, color: str, kilometros_recorridos: float = 0):
        super().__init__(color, kilometros_recorridos)

    def andar(self, km: float):
        super().andar(km)
        print(f"Has conducido {km} km con el coche.")

    def quemar_rueda(self):
        km = 1.0
        super().andar(km)
        print(f"Has quemado rueda con el coche. (+{km} km)")

    def ver_kilometraje(self):
        print(f"\n--- Kilometraje Coche ---")
        print(f"  Color: {self._color}")
        print(f"  Km recorridos: {self._kilometros_recorridos}")
        print(f"  Km totales:    {self._kilometros_totales}")
        if self._kilometros_totales > self.LIMITE_KM:
            print(
                f"  AVISO: El coche supera los {self.LIMITE_KM:,} km. "
                f"Se recomienda cambiar el vehiculo."
            )

    def __str__(self):
        return (
            f"Coche - Color: {self._color} | "
            f"Km recorridos: {self._kilometros_recorridos} | "
            f"Km totales: {self._kilometros_totales}"
        )


def menu_crear_objeto(bicicleta, coche):
    # Muestra el menu crear objetos, pide datos y devuelve (bicicleta, coche).
    print("\nMenu crear objetos:")
    print("Que objeto deseas crear?:")
    print("1. Coche.")
    print("2. Bicicleta.")
    opcion = input("Elige una opcion (1-2): ")

    if opcion == "1":
        print("\n--- Datos del coche ---")
        color = input("Color: ")
        km = float(input("Kilometros recorridos iniciales: "))
        coche = Coche(color, km)
        print(f"Coche creado: {coche}")

    elif opcion == "2":
        print("\n--- Datos de la bicicleta ---")
        color = input("Color: ")
        km = float(input("Kilometros recorridos iniciales: "))
        bicicleta = Bicicleta(color, km)
        print(f"Bicicleta creada: {bicicleta}")

    else:
        print("Opcion no valida.")

    return bicicleta, coche


def main():
    bicicleta = None
    coche = None

    # Al iniciar, se muestra el menu de crear objeto
    bicicleta, coche = menu_crear_objeto(bicicleta, coche)

    # Una vez creado el objeto, aparece el menu VEHICULOS
    while True:
        print("\n========== VEHICULOS ==========")
        print("1. Anda con la bicicleta.")
        print("2. Has el caballito con la bicicleta.")
        print("3. Anda con el coche.")
        print("4. Queme rueda con el coche.")
        print("5. Ver Kilometros de la bicicleta.")
        print("6. Ver Kilometros del coche.")
        print("7. Ver kilometros totales.")
        print("8. Volver al menu de crear objeto.")
        print("9. Salir.")
        opcion = input("Elige una opcion (1-9): ")

        if opcion == "1":
            if bicicleta is None:
                print("No hay bicicleta creada. Crea una primero (opcion 8).")
                continue
            km = float(input("Cuantos km quieres recorrer? "))
            bicicleta.andar(km)

        elif opcion == "2":
            if bicicleta is None:
                print("No hay bicicleta creada. Crea una primero (opcion 8).")
                continue
            bicicleta.hacer_caballito()

        elif opcion == "3":
            if coche is None:
                print("No hay coche creado. Crea uno primero (opcion 8).")
                continue
            km = float(input("Cuantos km quieres recorrer? "))
            coche.andar(km)

        elif opcion == "4":
            if coche is None:
                print("No hay coche creado. Crea uno primero (opcion 8).")
                continue
            coche.quemar_rueda()

        elif opcion == "5":
            if bicicleta is None:
                print("No hay bicicleta creada. Crea una primero (opcion 8).")
                continue
            bicicleta.ver_kilometraje()

        elif opcion == "6":
            if coche is None:
                print("No hay coche creado. Crea uno primero (opcion 8).")
                continue
            coche.ver_kilometraje()

        elif opcion == "7":
            km_bici = bicicleta.kilometros_totales if bicicleta else 0
            km_coche = coche.kilometros_totales if coche else 0
            print(f"\n--- Kilometros totales ---")
            print(f"  Bicicleta: {km_bici} km")
            print(f"  Coche:     {km_coche} km")
            print(f"  TOTAL:     {km_bici + km_coche} km")

        elif opcion == "8":
            # Vuelve al menu crear objeto (si crea uno nuevo, sobrescribe el anterior)
            bicicleta, coche = menu_crear_objeto(bicicleta, coche)

        elif opcion == "9":
            print("Hasta luego!")
            break

        else:
            print("Opcion no valida.")


if __name__ == "__main__":
    main()
