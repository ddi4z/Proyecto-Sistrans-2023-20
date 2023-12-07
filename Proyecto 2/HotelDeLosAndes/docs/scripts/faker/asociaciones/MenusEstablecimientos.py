import os
import config
from faker import Faker
faker = Faker()

def MenusEstablecimientos(inicio,cantidad):
    ruta = "HotelDeLosAndes/docs/scripts/faker/asociaciones/scripts/"
    if not os.path.exists(ruta):
        os.mkdir(ruta)
    with open(os.path.join(ruta, "MenusEstablecimiento.sql"), "w") as archivo:
        for i in range(inicio,inicio+cantidad):
            idEstablecimiento = inicio + 3*(i-1)
            for idProducto in range(idEstablecimiento,idEstablecimiento+30):
                archivo.write(f"insert into menusEstablecimientos values ({i}, {idProducto});\n")
        archivo.close()
MenusEstablecimientos(config.serviciosInfo["EstablecimientoComercio"][0],config.serviciosInfo["EstablecimientoComercio"][1])
