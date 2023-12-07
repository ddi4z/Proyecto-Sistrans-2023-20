import config
import os
from datetime import datetime,timedelta

def ReservasFechas(diponibilidadReservas):
    ruta = "HotelDeLosAndes/docs/scripts/faker/asociaciones/scripts/"
    if not os.path.exists(ruta):
        os.mkdir(ruta)
    with open(os.path.join(ruta, "ReservasFechas.sql"), "w") as archivo:
        for i, reserva in enumerate(diponibilidadReservas):
            inicio = datetime.strptime(reserva[0], "%Y-%m-%d")
            fin = datetime.strptime(reserva[1], "%Y-%m-%d")
            while inicio <= fin:
                fecha = inicio.strftime("%Y-%m-%d")
                archivo.write(f"insert into reservasFechas values (TO_DATE('{fecha}','YYYY-MM-DD'), {i+1});\n")
                inicio = inicio + timedelta(days=1)
        archivo.close()



ReservasFechas(config.diponibilidadReservas)