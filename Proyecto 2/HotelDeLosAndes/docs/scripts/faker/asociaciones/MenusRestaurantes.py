import os
import config
from faker import Faker
faker = Faker()

def MenusRestaurantes(inicio,cantidad):
    ruta = "HotelDeLosAndes/docs/scripts/faker/asociaciones/scripts/"
    if not os.path.exists(ruta):
        os.mkdir(ruta)
    with open(os.path.join(ruta, "MenusRestaurantes.sql"), "w") as archivo:
        for i in range(inicio,inicio+cantidad):
            idEstablecimiento = inicio + 3*(i-1)
            for idProducto in range(idEstablecimiento,idEstablecimiento+30):
                archivo.write(f"insert into menusRestaurantes  values ({i}, {idProducto});\n")
        archivo.close()
MenusRestaurantes(config.serviciosInfo["Restaurante"][0],config.serviciosInfo["Restaurante"][1])
