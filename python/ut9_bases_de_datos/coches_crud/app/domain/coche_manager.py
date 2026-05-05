from domain.model.coche import Coche
from data.database import connection as database    
from data.coche_repository import CocheRepository


class CocheManager:
    """Clase que maneja las operaciones CRUD de los coches (Capa de Servicio)"""
    
    def __init__(self):
        self._repository = CocheRepository()

    def listar_coches(self) -> list[Coche]:
        return self._repository.find_all(database)

    def crear_coche(self, coche: Coche):
        self._repository.save(database, coche)

    def borrar_coche(self, id: int):
        self._repository.delete(database, id)

    def actualizar_coche(self, id: int, coche: Coche):
        self._repository.update(database, id, coche)

    def buscar_coche(self, id: int):
        return self._repository.find_by_id(database, id)
