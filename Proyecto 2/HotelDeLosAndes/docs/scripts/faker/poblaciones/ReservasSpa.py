import random
import os
import config
from faker import Faker
faker = Faker()


def ReservasSpas(cantidad):
    ruta = "HotelDeLosAndes/docs/scripts/faker/poblaciones/scripts/"
    if not os.path.exists(ruta):
        os.mkdir(ruta)
    with open(os.path.join(ruta, "ReservasSpa.sql"), "w") as archivo:
        archivo.write("create sequence idReservasSpa start with 1 increment by 1;")
        for i in range(cantidad):
            año,mes,dia =  random.randint(2022, 2023),random.randint(1, 12),random.randint(1, 28)
            hora, minuto = random.randint(5, 9), random.choice(config.minutos)
            hora_inicio = f"{año:04d}-{mes:02d}-{dia:02d} {hora:02d}:{minuto:02d}"
            hora_fin = f"{año:04d}-{mes:02d}-{dia:02d} {hora + random.randint(2, 6):02d}:{random.choice(config.minutos):02d}"
            costo = random.randint(0, 9999999)
            id_spa = random.randint(config.serviciosInfo["Spa"][0], config.serviciosInfo["Spa"][0] + config.serviciosInfo["Spa"][1])
            duracion = random.randint(15, 720)
            numero_documento = random.randint(1, config.configUsuarios[4][0]) + 10000000
            archivo.write(f"insert into reservasSpa values (idReservasSpa.nextval, TO_DATE('{hora_inicio}','YYYY-MM-DD HH24:MI'), TO_DATE('{hora_fin}','YYYY-MM-DD HH24:MI'), {costo}, {duracion}, {id_spa}, {numero_documento});\n")



ReservasSpas(config.RESERVASSPA)