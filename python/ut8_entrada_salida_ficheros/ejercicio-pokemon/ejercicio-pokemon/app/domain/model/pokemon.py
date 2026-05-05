from domain.model.evolution import Evolution


class Pokemon:
    """Modelo de dominio de un Pokemon."""

    def __init__(self, id: int, num: str, name: str, img: str,
                 types: list, height: float, weight: float, candy: str,
                 candy_count, egg: str, spawn_chance, avg_spawns,
                 spawn_time: str, multipliers, weaknesses: list,
                 next_evolution: list = None, prev_evolution: list = None):
        self.id = id
        self.num = num
        self.name = name
        self.img = img
        self.types = types
        self.height = height
        self.weight = weight
        self.candy = candy
        self.candy_count = candy_count
        self.egg = egg
        self.spawn_chance = spawn_chance
        self.avg_spawns = avg_spawns
        self.spawn_time = spawn_time
        self.multipliers = multipliers
        self.weaknesses = weaknesses
        self.next_evolution = next_evolution if next_evolution is not None else []
        self.prev_evolution = prev_evolution if prev_evolution is not None else []

    def num_evoluciones(self) -> int:
        return len(self.next_evolution) + len(self.prev_evolution)

    def es_dual(self) -> bool:
        return len(self.types) >= 2

    def tipo_secundario(self):
        return self.types[1] if len(self.types) >= 2 else None

    def es_legendario(self) -> bool:
        return (
            self.candy == "None"
            and not self.next_evolution
            and not self.prev_evolution
            and self.spawn_chance == 0
        )

    @classmethod
    def from_dict(cls, data: dict) -> "Pokemon":
        height_raw = str(data.get("height", "0 m")).replace(" m", "").strip()
        weight_raw = str(data.get("weight", "0 kg")).replace(" kg", "").strip()
        next_ev = [Evolution(e["num"], e["name"]) for e in data.get("next_evolution", [])]
        prev_ev = [Evolution(e["num"], e["name"]) for e in data.get("prev_evolution", [])]
        return cls(
            id=data["id"],
            num=data["num"],
            name=data["name"],
            img=data.get("img", ""),
            types=data.get("type", []),
            height=float(height_raw) if height_raw else 0.0,
            weight=float(weight_raw) if weight_raw else 0.0,
            candy=data.get("candy", "None"),
            candy_count=data.get("candy_count"),
            egg=data.get("egg", "Not in Eggs"),
            spawn_chance=data.get("spawn_chance", 0),
            avg_spawns=data.get("avg_spawns", 0),
            spawn_time=data.get("spawn_time", "N/A"),
            multipliers=data.get("multipliers"),
            weaknesses=data.get("weaknesses", []),
            next_evolution=next_ev,
            prev_evolution=prev_ev,
        )

    def to_dict(self) -> dict:
        d = {
            "id": self.id,
            "num": self.num,
            "name": self.name,
            "img": self.img,
            "type": self.types,
            "height": f"{self.height} m",
            "weight": f"{self.weight} kg",
            "candy": self.candy,
        }
        if self.candy_count is not None:
            d["candy_count"] = self.candy_count
        d["egg"] = self.egg
        d["spawn_chance"] = self.spawn_chance
        d["avg_spawns"] = self.avg_spawns
        d["spawn_time"] = self.spawn_time
        d["multipliers"] = self.multipliers
        d["weaknesses"] = self.weaknesses
        if self.prev_evolution:
            d["prev_evolution"] = [e.to_dict() for e in self.prev_evolution]
        if self.next_evolution:
            d["next_evolution"] = [e.to_dict() for e in self.next_evolution]
        return d

    def __str__(self):
        tipos = ", ".join(self.types) if self.types else "-"
        return (f"#{self.num} {self.name:<12} | Tipos: {tipos:<22} | "
                f"Peso: {self.weight} kg | Altura: {self.height} m")

    def __repr__(self):
        return f"Pokemon(id={self.id}, name={self.name!r})"
