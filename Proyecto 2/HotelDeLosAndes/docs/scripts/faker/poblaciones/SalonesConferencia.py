import random
import os
import config
from faker import Faker
faker = Faker()

def SalonesConferencia(start,cantidad):
    ruta = "HotelDeLosAndes/docs/scripts/faker/poblaciones/scripts/"
    if not os.path.exists(ruta):
        os.mkdir(ruta)
    with open(os.path.join(ruta, "SalonesConferencia.sql"), "w") as archivo:
        for i in range(start,start+cantidad):
            capacidad = faker.random_int(2, 1000)
            costo_hora = random.randint(0, 999999)
            archivo.write(f"insert into salonesConferencia values ({i}, {capacidad}, {costo_hora:.2f});\n")
        archivo.close()

info = config.serviciosInfo["SalonConferencia"]
SalonesConferencia(info[0],info[1])