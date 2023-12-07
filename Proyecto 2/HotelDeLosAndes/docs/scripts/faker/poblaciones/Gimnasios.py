import os
import config
import random
from faker import Faker
faker = Faker()


def gimnasios(inicio, cantidad):
    ruta = "HotelDeLosAndes/docs/scripts/faker/poblaciones/scripts/"
    if not os.path.exists(ruta):
        os.mkdir(ruta)
    with open(os.path.join(ruta, "Gimnasios.sql"), "w") as archivo:
        for i in range(inicio,inicio+cantidad):
            capacidad = faker.random_int(1, 99)
            horaInicio = f'{random.randint(5, 9):02d}:{random.choice(config.minutos):02d}'
            horaFin = f'{random.randint(6, 12):02d}:{random.choice(config.minutos):02d}'
            costoAdicional = random.randint(0, 9999999)
            archivo.write(f"insert into gimnasios values ({i}, {capacidad}, TO_DATE('{horaInicio}','HH24:MI'), TO_DATE('{horaFin}','HH24:MI'), {costoAdicional:.2f});\n")
        archivo.close()


info = config.serviciosInfo["Gimnasio"]
gimnasios(info[0],info[1])