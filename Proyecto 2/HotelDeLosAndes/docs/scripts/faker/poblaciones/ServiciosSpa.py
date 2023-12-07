import random

import os
import config
from faker import Faker
faker = Faker()

def ServiciosSpa():
    ruta = "HotelDeLosAndes/docs/scripts/faker/poblaciones/scripts/"
    if not os.path.exists(ruta):
        os.mkdir(ruta)
    with open(os.path.join(ruta, "ServiciosSpa.sql"), "w") as archivo:
        archivo.write("create sequence idServiciosSpa start with 1 increment by 1;\n")
        nombres = config.serviciosSpas
        for i in range(1, len(nombres)+1):
            nombre = nombres[i-1]
            duracion =  faker.random_int(1, 999)
            costo = random.randint(10000000,99999999)
            archivo.write(f"insert into serviciosSpa values (idServiciosSpa.nextval, '{nombre}', {duracion}, {costo:.2f});\n")
        archivo.close()
ServiciosSpa()


