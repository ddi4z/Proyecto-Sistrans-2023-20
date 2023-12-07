import random
import os
import config
from faker import Faker
faker = Faker()

def SpasServiciosSpas(inicio,cantidad):
    ruta = "HotelDeLosAndes/docs/scripts/faker/asociaciones/scripts/"
    if not os.path.exists(ruta):
        os.mkdir(ruta)
    with open(os.path.join(ruta, "SpasServiciosSpas.sql"), "w") as archivo:
        for i in range(inicio,inicio+cantidad):
            curr = set()
            while len(curr) < 25:
                num = random.randint(1,len(config.serviciosSpas))
                if num in curr:
                    continue
                curr.add(num)
                archivo.write(f"insert into spasServiciosSpa values ({i}, {num});\n")
        archivo.close()
SpasServiciosSpas(config.serviciosInfo["Spa"][0],config.serviciosInfo["Spa"][1])
