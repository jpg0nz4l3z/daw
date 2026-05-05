from domain.model.persona import Persona;

class PersonaRepository:    
    def find_all(self, conn) -> list[Persona]:
        with conn.cursor() as cursor:
            cursor.execute("select * from personas")
            personas_en_db = cursor.fetchall()
        
        personas: list[Persona] = list()
        for persona in personas_en_db:
            persona = Persona(persona['nombre'], persona['apellido'], persona['edad'])
            personas.append(persona)
        
        return personas