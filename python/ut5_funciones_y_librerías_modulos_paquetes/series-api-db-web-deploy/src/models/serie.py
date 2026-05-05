from datetime import date
from sqlmodel import Field, SQLModel
from pydantic import BaseModel

class Serie(SQLModel, table=True):
    id: int | None = Field(default=None, primary_key=True)
    nombre: str = Field(index=True, max_length=50)
    fecha_estreno: date | None = Field(nullable=True)

# dto classes
class SerieCreate(BaseModel):
    nombre: str
    # fecha de estreno posterior a la fecha actual con Annotated
    fecha_estreno: date | None = None

class SerieUpdate(BaseModel):
    nombre: str | None = None
    fecha_estreno: date | None = None

class SerieResponse(BaseModel):
    id: int
    nombre: str
    fecha_estreno: date | None = None

# mapping functions
def map_serie_to_response(serie: Serie) -> SerieResponse:
    return SerieResponse(
        id=serie.id,
        nombre=serie.nombre,
        fecha_estreno=serie.fecha_estreno
    )

def map_create_to_serie(serie_create: SerieCreate) -> Serie:
    return Serie(
        nombre=serie_create.nombre,
        fecha_estreno=serie_create.fecha_estreno
    )

def map_update_to_serie(serie: Serie, serie_update: SerieUpdate) -> Serie:
    if serie_update.nombre is not None:
        serie.nombre = serie_update.nombre
    if serie_update.fecha_estreno is not None:
        serie.fecha_estreno = serie_update.fecha_estreno
    return serie
