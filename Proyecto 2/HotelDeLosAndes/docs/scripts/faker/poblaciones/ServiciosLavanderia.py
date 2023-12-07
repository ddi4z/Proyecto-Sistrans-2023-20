import random
import os
import config
from faker import Faker
faker = Faker()


def serviciosLavanderia(inicio,cantidad):
    ruta = "HotelDeLosAndes/docs/scripts/faker/poblaciones/scripts/"
    if not os.path.exists(ruta):
        os.mkdir(ruta)
    with open(os.path.join(ruta, "ServiciosLavanderia.sql"), "w") as archivo:
        for i in range(inicio,inicio+cantidad):
            costo = random.randint(10000000, 99999999)
            archivo.write(f"insert into serviciosLavanderia values ({i}, {costo:.2f});\n")
        archivo.close()

info = config.serviciosInfo["ServicioLavanderia"]
serviciosLavanderia(info[0],info[1])