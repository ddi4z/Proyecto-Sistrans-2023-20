import random
import os
import config
from faker import Faker
faker = Faker()

def piscinas(start,cantidad):
    ruta = "HotelDeLosAndes/docs/scripts/faker/poblaciones/scripts/"
    if not os.path.exists(ruta):
        os.mkdir(ruta)
    with open(os.path.join(ruta, "Piscinas.sql"), "w") as archivo:
        for i in range(start,start+cantidad):
            capacidad = faker.random_int(1, 99)
            profundidad = faker.random_int(1, 99)
            horaInicio = f'{random.randint(5, 9):02d}:{random.choice(config.minutos):02d}'
            horaFin = f'{random.randint(18, 23):02d}:{random.choice(config.minutos):02d}'
            costoAdicional = random.randint(0, 9999999)
            archivo.write(f"insert into piscinas values ({i}, {capacidad}, {profundidad}, TO_DATE('{horaInicio}','HH24:MI'), TO_DATE('{horaFin}','HH24:MI'), {costoAdicional:.2f});\n")
        archivo.close()

info = config.serviciosInfo["Piscina"]
piscinas(info[0],info[1])