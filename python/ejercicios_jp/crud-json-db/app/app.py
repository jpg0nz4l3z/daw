from domain.model.persona import Persona
from domain.persona_manager import PersonaManager

def main():
    manager = PersonaManager()
    personas: list[Persona] = manager.listar_personas()
    
    for persona in personas:
        print(persona.__str__())
        
if (__name__ == "__main__"):
    main()