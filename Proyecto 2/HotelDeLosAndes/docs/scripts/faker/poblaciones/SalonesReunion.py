import random
import os
import config
from faker import Faker
faker = Faker()

def SalonesReunion(start,cantidad):
    ruta = "HotelDeLosAndes/docs/scripts/faker/poblaciones/scripts/"
    if not os.path.exists(ruta):
        os.mkdir(ruta)
    with open(os.path.join(ruta, "SalonesReunion.sql"), "w") as archivo:
        for i in range(start,start+cantidad):
            capacidad = faker.random_int(2, 12)
            costo_hora = random.randint(0, 999999)
            costo_equipos = random.randint(0, 200000)
            archivo.write(f"insert into salonesReunion values ({i}, {capacidad}, {costo_hora:.2f}, {costo_equipos:.2f});\n")
        archivo.close()



info = config.serviciosInfo["SalonReunion"]
SalonesReunion(info[0],info[1])