import random
import time


COLORES = ['r', 'v', 'a']


class Serpiente:
    """Representa una serpiente compuesta por anillas de colores."""

    def __init__(self):
        self.cuerpo = [random.choice(COLORES)]
        self.edad = 0
        self.viva = True

    def __str__(self):
        return f"[Edad: {self.edad} | Cuerpo: {'-'.join(self.cuerpo)}]"

    def crecer(self):
        self.cuerpo.append(random.choice(COLORES))

    def mudar_piel(self):
        self.cuerpo = [random.choice(COLORES) for _ in self.cuerpo]

    def decrecer(self):
        if self.cuerpo:
            self.cuerpo.pop()
        if not self.cuerpo:
            self.viva = False

    def vivir_un_anio(self):
        if not self.viva:
            return
        self.edad += 1
        probabilidad = random.random()
        if self.edad < 10:
            if probabilidad < 0.8:
                self.crecer()
                print(f"  La serpiente CRECE -> {self}")
            else:
                self.mudar_piel()
                print(f"  La serpiente MUDA la piel -> {self}")
        else:
            if probabilidad < 0.9:
                self.decrecer()
                if self.viva:
                    print(f"  La serpiente DECRECE -> {self}")
                else:
                    print(f"  La serpiente se ha quedado sin cuerpo. MUERE.")
            else:
                self.mudar_piel()
                print(f"  La serpiente MUDA la piel -> {self}")

    def ataque_mangosta(self):
        if random.random() < 0.1:
            self.viva = False
            print(f"  ¡Una MANGOSTA ataca! La serpiente muere. {self}")
            return True
        return False


def simular_serpiente():
    """Simula la vida de una serpiente individual."""
    print("=" * 50)
    print("SIMULACION DE UNA SERPIENTE")
    print("=" * 50)
    serpiente = Serpiente()
    print(f"Nace una serpiente: {serpiente}")
    print()

    while serpiente.viva:
        time.sleep(1)
        print(f"--- Año {serpiente.edad + 1} ---")
        serpiente.vivir_un_anio()
        if not serpiente.viva:
            break
        if serpiente.ataque_mangosta():
            break
        print()

    print()
    print(f"La serpiente ha muerto a los {serpiente.edad} años.")
    print("=" * 50)


class Nido:
    """Representa un nido que alberga hasta 20 serpientes."""

    MAX_SERPIENTES = 20

    def __init__(self):
        self.serpientes = []
        self.segundo = 0

    def lugares_libres(self):
        return self.MAX_SERPIENTES - len(self.serpientes)

    def nacer_serpientes(self):
        libres = self.lugares_libres()
        if libres <= 0:
            return
        cantidad = random.randint(1, min(3, libres))
        for _ in range(cantidad):
            self.serpientes.append(Serpiente())
        print(f"  Nacen {cantidad} serpiente(s). Total en el nido: {len(self.serpientes)}")

    def pasar_vida(self):
        muertas = []
        for i, serpiente in enumerate(self.serpientes):
            print(f"  Serpiente {i + 1}:", end=" ")
            serpiente.vivir_un_anio()
            if not serpiente.viva:
                muertas.append(serpiente)
        for m in muertas:
            self.serpientes.remove(m)
        if muertas:
            print(f"  {len(muertas)} serpiente(s) murieron por quedarse sin cuerpo.")

    def ataque_mangosta(self):
        if random.random() < 0.2:
            cantidad = random.randint(0, min(4, len(self.serpientes)))
            if cantidad > 0:
                victimas = random.sample(self.serpientes, cantidad)
                for v in victimas:
                    self.serpientes.remove(v)
                print(f"  ¡MANGOSTA! Se come {cantidad} serpiente(s). Quedan: {len(self.serpientes)}")
            else:
                print(f"  ¡Una mangosta aparece pero no atrapa ninguna!")
        else:
            print(f"  Una mangosta ronda pero no ataca.")

    def mostrar_estado(self):
        print(f"  Estado del nido ({len(self.serpientes)}/{self.MAX_SERPIENTES}):")
        for i, s in enumerate(self.serpientes):
            print(f"    {i + 1}. {s}")

    def simular(self, duracion=300):
        """Simula la vida del nido durante 'duracion' segundos (por defecto 5 min)."""
        print("=" * 60)
        print("SIMULACION DEL NIDO DE SERPIENTES (5 minutos)")
        print("=" * 60)
        print()

        for seg in range(1, duracion + 1):
            self.segundo = seg
            print(f"{'='*40} Segundo {seg} {'='*40}")

            # Cada 5 segundos nacen serpientes
            if seg % 5 == 0:
                print("[NACIMIENTO]")
                self.nacer_serpientes()

            # Cada segundo pasa la vida de cada serpiente
            if self.serpientes:
                print("[VIDA]")
                self.pasar_vida()

            # Cada 10 segundos ataque de mangosta
            if seg % 10 == 0:
                print("[MANGOSTA]")
                self.ataque_mangosta()

            # Mostrar estado
            self.mostrar_estado()
            print()

            time.sleep(1)

        print("=" * 60)
        print(f"FIN DE LA SIMULACION. Serpientes supervivientes: {len(self.serpientes)}")
        print("=" * 60)


if __name__ == "__main__":
    print("Elige modo de simulacion:")
    print("1. Serpiente individual")
    print("2. Nido de serpientes (5 minutos)")
    opcion = input("Opcion (1/2): ").strip()

    if opcion == "1":
        simular_serpiente()
    elif opcion == "2":
        nido = Nido()
        nido.simular()
    else:
        print("Opcion no valida.")
