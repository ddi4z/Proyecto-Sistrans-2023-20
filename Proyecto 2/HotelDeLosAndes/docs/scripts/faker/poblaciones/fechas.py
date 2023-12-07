import os
from datetime import datetime, timedelta


def Fechas():
    ruta = "HotelDeLosAndes/docs/scripts/faker/poblaciones/scripts/"
    if not os.path.exists(ruta):
        os.mkdir(ruta)
    with open(os.path.join(ruta, "fechas.sql"), "w") as archivo:
        for i in range(0,365*2):
            fecha = "2022-01-01"
            fecha_obj = datetime.strptime(fecha, "%Y-%m-%d") + timedelta(days=i)
            archivo.write(f"insert into fechas values (TO_DATE('{fecha_obj.strftime('%Y-%m-%d')}','YYYY-MM-DD'));\n")
        archivo.close()
Fechas()
