import random
import os
import config
from faker import Faker
faker = Faker()


def internets(start, cantidad):
    ruta = "HotelDeLosAndes/docs/scripts/faker/poblaciones/scripts/"
    if not os.path.exists(ruta):
        os.mkdir(ruta)
    with open(os.path.join(ruta, "Internets.sql"), "w") as archivo:
        for i in range(start,start+cantidad):
            capacidad = faker.random_int(1, 9999)
            costo_dia = random.randint(0, 9999999)
            archivo.write(f"insert into internets values ({i}, {capacidad}, {costo_dia:.2f});\n")


    archivo.close()
info = config.serviciosInfo["Internet"]
internets(info[0],info[1])