from typing import Annotated
from contextlib import asynccontextmanager
from fastapi import FastAPI, Depends, HTTPException, Form
from fastapi.staticfiles import StaticFiles
from fastapi.templating import Jinja2Templates
from fastapi.requests import Request
from fastapi.responses import HTMLResponse, RedirectResponse
from sqlmodel import Session, select

from models.serie import Serie, SerieCreate, SerieResponse,  map_serie_to_response, map_create_to_serie
from data.db import init_db, get_session
from data.series_repository import SeriesRepository
from routers.api_series_router import router as api_series_router


import uvicorn


@asynccontextmanager
async def lifespan(application: FastAPI):
    init_db()
    yield


SessionDep = Annotated[Session, Depends(get_session)]

app = FastAPI(lifespan=lifespan)

app.mount("/static", StaticFiles(directory="static"), name="static")
templates = Jinja2Templates(directory="templates")

app.include_router(api_series_router)

# Ruta para la página principal
@app.get("/", response_class=HTMLResponse)
async def root(request: Request):
    return templates.TemplateResponse("index.html", {"request": request})   

@app.get("/series", response_class=HTMLResponse)
async def ver_series(request: Request, session: SessionDep):
    repo = SeriesRepository(session)
    series = repo.get_all_series()
    return templates.TemplateResponse("series/series.html", {"request": request, "series": series})

@app.get("/series/new", response_class=HTMLResponse)
async def nueva_serie_form(request: Request):

    """Formulario para añadir una serie nueva"""
    return templates.TemplateResponse("series/serie_form.html", {
        "request": request,
        "serie": Serie()
    })

@app.post("/series/new", response_class=HTMLResponse)
async def crear_serie(request: Request, session: SessionDep):
    """Crear una nueva serie desde el formulario"""
    form_data = await request.form()
    nombre = form_data.get("nombre")
    fecha_estreno = form_data.get("fecha_estreno") or None

    serie_create = SerieCreate(
        nombre=nombre,
        fecha_estreno=fecha_estreno
    )
    repo = SeriesRepository(session)
    serie = map_create_to_serie(serie_create)
    repo.create_serie(serie)

    return RedirectResponse(url="/series", status_code=303)

@app.get("/series/{serie_id}", response_class=HTMLResponse)
async def serie_por_id(serie_id: int, request: Request, session: SessionDep):
    repo = SeriesRepository(session)
    serie_encontrada = repo.get_serie(serie_id)
    if not serie_encontrada:
        raise HTTPException(status_code=404, detail="Serie no encontrada")
    serie_response = map_serie_to_response(serie_encontrada)
    return templates.TemplateResponse("series/serie_detalle.html", {"request": request, "serie": serie_response})



if __name__ == "__main__":
    uvicorn.run("main:app", host="127.0.0.1", port=3000, reload=True)