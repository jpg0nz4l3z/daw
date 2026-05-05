from data.persona_repository import PersonaRepository
from data.database import connection as database
from domain.model.persona import Persona

class PersonaManager:
    
    def __init__(self):
        self._repository = PersonaRepository()

    def listar_personas(self) -> list[Persona]:
        return self._repository.find_all(database)