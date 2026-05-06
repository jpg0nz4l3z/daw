class Evolution:
    """Representa una evolucion (anterior o siguiente) de un pokemon."""

    def __init__(self, num: str, name: str):
        self.num = num
        self.name = name

    def to_dict(self) -> dict:
        return {"num": self.num, "name": self.name}

    def __str__(self):
        return f"#{self.num} {self.name}"
