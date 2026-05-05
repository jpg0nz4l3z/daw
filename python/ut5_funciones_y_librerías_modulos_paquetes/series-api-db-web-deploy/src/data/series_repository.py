from sqlmodel import Session, select
from models.serie import Serie

class SeriesRepository:
    def __init__(self, session: Session):
        self.session = session
    
    def get_all_series(self) -> list[Serie]:
        series = self.session.exec(select(Serie)).all()
        return series   

    def get_serie(self, serie_id: int) -> Serie:
        serie = self.session.get(Serie, serie_id)
        return serie

    def create_serie(self, serie: Serie) -> Serie:
        self.session.add(serie)
        self.session.commit()
        self.session.refresh(serie)
        return serie

    def update_serie(self, serie_id: int, serie_data: dict) -> Serie:
        serie = self.get_serie(serie_id)
        for key, value in serie_data.items():
            setattr(serie, key, value)
        self.session.commit()
        self.session.refresh(serie)
        return serie

    def delete_serie(self, serie_id: int) -> None:
        serie = self.get_serie(serie_id)
        self.session.delete(serie)
        self.session.commit()