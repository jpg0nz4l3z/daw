from fastapi import APIRouter, HTTPException, Depends
from typing import Annotated
from sqlmodel import Session
from models.serie import Serie, SerieCreate, SerieResponse, map_serie_to_response, map_create_to_serie

from data.series_repository import SeriesRepository
from data.db import init_db, get_session

router = APIRouter(prefix="/api/series", tags=["series"])

SessionDep = Annotated[Session, Depends(get_session)]

# Rutas de la API para gestionar series

@router.get("/", response_model=list[SerieResponse])
async def lista_series(session: SessionDep):
    repo = SeriesRepository(session)
    series = repo.get_all_series()
    return [map_serie_to_response(serie) for serie in series]

@router.post("/", response_model=SerieResponse)
async def nueva_serie(serie_create: SerieCreate, session: SessionDep):
    repo = SeriesRepository(session)
    serie = map_create_to_serie(serie_create)
    serie_creada = repo.create_serie(serie)
    return map_serie_to_response(serie_creada)


@router.get("/{serie_id}", response_model=SerieResponse)
async def serie_por_id(serie_id: int, session: SessionDep):
    repo = SeriesRepository(session)
    serie_encontrada = repo.get_serie(serie_id)
    if not serie_encontrada:
        raise HTTPException(status_code=404, detail="Serie no encontrada")
    return map_serie_to_response(serie_encontrada)

@router.delete("/{serie_id}", status_code=204)
async def borrar_serie(serie_id: int, session: SessionDep):
    repo = SeriesRepository(session)
    serie_encontrada = repo.get_serie(serie_id)
    if not serie_encontrada:
        raise HTTPException(status_code=404, detail="Serie no encontrada")
    repo.delete_serie(serie_id)
    return None


@router.patch("/{serie_id}", response_model=SerieResponse)
async def cambia_serie(serie_id: int, serie: Serie, session: SessionDep):
    repo = SeriesRepository(session)
    serie_encontrada = repo.get_serie(serie_id)
    if not serie_encontrada:
        raise HTTPException(status_code=404, detail="Serie no encontrada")
    serie_data = serie.model_dump(exclude_unset=True)
    serie_encontrada.sqlmodel_update(serie_data)
    repo.update_serie(serie_encontrada.id, serie_data)
    return map_serie_to_response(serie_encontrada)

@router.put("/", response_model=SerieResponse)
async def cambia_serie(serie: Serie, session: SessionDep):
    repo = SeriesRepository(session)
    serie_encontrada = repo.get_serie(serie.id)
    if not serie_encontrada:
        raise HTTPException(status_code=404, detail="Serie no encontrada")
    serie_data = serie.model_dump()
    serie_encontrada.sqlmodel_update(serie_data)
    repo.update_serie(serie_encontrada.id, serie_data)
    return map_serie_to_response(serie_encontrada)