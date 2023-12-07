import os
import config
from faker import Faker
faker = Faker()

def MenusBares(inicio,cantidad):
    ruta = "HotelDeLosAndes/docs/scripts/faker/asociaciones/scripts/"
    if not os.path.exists(ruta):
        os.mkdir(ruta)
    with open(os.path.join(ruta, "MenusBares.sql"), "w") as archivo:
        for i in range(inicio+1,inicio+cantidad+1):
            idEstablecimiento = inicio + 3*(i-1)
            for idProducto in range(idEstablecimiento,idEstablecimiento+30):
                archivo.write(f"insert into menusBares  values ({i}, {idProducto});\n")
        archivo.close()
MenusBares(config.serviciosInfo["Bar"][0],config.serviciosInfo["Bar"][1])
