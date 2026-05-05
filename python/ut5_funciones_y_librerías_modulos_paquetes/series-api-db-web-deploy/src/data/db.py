from dotenv import load_dotenv
import os
from sqlmodel import create_engine, SQLModel, Session
from models.serie import Serie

load_dotenv()

db_user: str = os.getenv("DB_USER", "quevedo")
db_password: str = os.getenv("DB_PASSWORD", "1234")
db_server: str = os.getenv("DB_SERVER", "fastapi-db")
db_port: int = os.getenv("DB_PORT", 3306)  
db_name: str = os.getenv("DB_NAME", "seriesdb")  

DATABASE_URL = f"mysql+pymysql://{db_user}:{db_password}@{db_server}:{db_port}/{db_name}"
engine = create_engine(os.getenv("DB_URL", DATABASE_URL), echo=True)

def get_session():
    with Session(engine) as session:
        yield session

def init_db():
    SQLModel.metadata.drop_all(engine)
    SQLModel.metadata.create_all(engine)
    with Session(engine) as session:
        session.add(Serie(id=1, nombre="The Mandalorian", fecha_estreno="2023-09-10"))
        session.add(Serie(id=2, nombre="The Simpsons", fecha_estreno="2024-03-20"))
        session.add(Serie(id=3, nombre="Friends", fecha_estreno="2019-02-22"))
        session.add(Serie(id=4, nombre="House of dragon", fecha_estreno="2021-10-01"))
        session.add(Serie(id=5, nombre="Lord of the rings", fecha_estreno="2023-09-10"))
        session.commit()
        #session.refresh_all()