#!/usr/bin/env python3
"""
Script helper para crear la base de datos pokemondb.
Ejecuta el script SQL init_db.sql

Antes de ejecutar este script:
1. Asegúrate de que MySQL está corriendo
2. Verifica que tienes acceso con el usuario 'quevedo' y contraseña '1234'
"""

import pymysql
import os

def setup_database():
    """Crea la base de datos y las tablas leyendo init_db.sql"""

    # Conexión sin especificar BD (para crear la BD)
    try:
        conn = pymysql.connect(
            host='localhost',
            port=3319,
            user='quevedo',
            password='1234'
        )
        print("✓ Conexión a MySQL exitosa")
    except Exception as e:
        print(f"✗ Error de conexión: {e}")
        return False

    # Leer el archivo SQL
    sql_file = os.path.join(os.path.dirname(__file__), 'data', 'init_db.sql')

    if not os.path.exists(sql_file):
        print(f"✗ No se encontró el archivo {sql_file}")
        return False

    try:
        with open(sql_file, 'r', encoding='utf-8') as f:
            sql_content = f.read()
        print(f"✓ Archivo SQL leído: {sql_file}")
    except Exception as e:
        print(f"✗ Error al leer el archivo SQL: {e}")
        return False

    # Ejecutar cada comando SQL
    try:
        with conn.cursor() as cursor:
            # Ejecutar cada statement
            statements = [s.strip() for s in sql_content.split(';') if s.strip()]
            for statement in statements:
                cursor.execute(statement)
            conn.commit()
        print("✓ Base de datos y tablas creadas exitosamente")
        return True
    except Exception as e:
        print(f"✗ Error al crear la base de datos: {e}")
        return False
    finally:
        conn.close()

if __name__ == '__main__':
    print("=" * 60)
    print("Creando base de datos pokemondb")
    print("=" * 60)

    if setup_database():
        print("\n✓ Setup completado correctamente")
        print("Ahora puedes ejecutar: python app/app.py")
    else:
        print("\n✗ Hubo un error durante el setup")
        print("Intenta ejecutar manualmente: mysql -u quevedo -p1234 < data/init_db.sql")
