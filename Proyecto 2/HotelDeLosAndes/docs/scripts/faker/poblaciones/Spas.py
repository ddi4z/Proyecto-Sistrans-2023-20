import os
import config
from faker import Faker
faker = Faker()

def spas(start,cantidad):
    ruta = "HotelDeLosAndes/docs/scripts/faker/poblaciones/scripts/"
    if not os.path.exists(ruta):
        os.mkdir(ruta)
    with open(os.path.join(ruta, "Spas.sql"), "w") as archivo:
        for i in range(start,start+cantidad):
            capacidad = faker.random_int(1, 99)
            archivo.write(f"insert into spas values ({i}, {capacidad});\n")
        archivo.close()


info = config.serviciosInfo["Spa"]
spas(info[0],info[1])