#import pymysql
from domain.model.coche import Coche

class CocheRepository:
    """
    Repositorio para gestionar las operaciones CRUD de los coches en la base de datos.
    conn: pymysql.Connection - Conexión a la base de datos.
    """

    def find_all(self, conn) -> list[Coche]:
        with conn.cursor() as cursor:
            cursor.execute("SELECT * FROM coches")
            coches_en_db = cursor.fetchall()
            
        coches :list[Coche] = list()
        for coche in coches_en_db:
            coche = Coche(coche['matricula'], coche['marca'], coche['modelo'], coche['color'])
            coches.append(coche)
        
        return coches
    
    def find_by_id(self, conn, id: int) -> Coche | None:
        with conn.cursor() as cursor:
            cursor.execute("SELECT * FROM coches WHERE id = %s", (id,))
            coche_en_db = cursor.fetchone()
        
        if coche_en_db:
            return Coche(coche_en_db['matricula'], coche_en_db['marca'], coche_en_db['modelo'], coche_en_db['color'])
        return None
    
    def save(self, conn, coche: Coche):
        with conn.cursor() as cursor:
            cursor.execute("INSERT INTO coches (matricula, marca, modelo, color) VALUES (%s, %s, %s, %s)", 
                           (coche.matricula, coche.marca, coche.modelo, coche.color))
        conn.commit()

    def delete(self, conn, id: int):
        with conn.cursor() as cursor:
            cursor.execute("DELETE FROM coches WHERE id = %s", (id,))
        conn.commit()

    def update(self, conn, id: int, coche: Coche):
        with conn.cursor() as cursor:
            cursor.execute("UPDATE coches SET matricula = %s, marca = %s, modelo = %s, color = %s WHERE id = %s", 
                           (coche.matricula, coche.marca, coche.modelo, coche.color, id))
        conn.commit()

    def count(self, conn) -> int:
        with conn.cursor() as cursor:
            cursor.execute("SELECT COUNT(*) FROM coches")
            count = cursor.fetchone()[0]
        return count

    def exists_by_id(self, conn, id: int) -> bool:
        with conn.cursor() as cursor:
            cursor.execute("SELECT 1 FROM coches WHERE id = %s", (id,))
            return cursor.fetchone() is not None
        