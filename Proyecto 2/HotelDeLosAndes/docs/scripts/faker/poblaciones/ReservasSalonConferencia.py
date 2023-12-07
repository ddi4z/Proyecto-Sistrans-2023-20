
import random
import os
from datetime import datetime, timedelta
import config
from faker import Faker
faker = Faker()

fechas = []



def ReservasSalonConferencia(cantidad):
    ruta = "HotelDeLosAndes/docs/scripts/faker/poblaciones/scripts/"
    if not os.path.exists(ruta):
        os.mkdir(ruta)
    with open(os.path.join(ruta, "ReservaSalonConferencias.sql"), "w") as archivo:
        archivo.write("create sequence idReservasSalonConferencia start with 1 increment by 1;\n")
        for i in range(1,cantidad+1):
            while True:
                duracion = random.choice(config.duraciones)
                costo  = random.randint(1000000, 9999999)
                idSalon = random.randint(config.serviciosInfo["SalonConferencia"][0], config.serviciosInfo["SalonConferencia"][0] + config.serviciosInfo["SalonConferencia"][1])
                año,mes,día,hora,minutos = random.randint(2022, 2023),random.randint(1, 12),random.randint(1, 28),random.randint(0, 23),random.choice(config.minutos)
                fecha1 = datetime(año, mes, día, hora, minutos)

                fecha2 = fecha1 + timedelta(minutes=(duracion))
                fecha2Limpieza = fecha2 + timedelta(minutes=(720))



                fecha_inicio = fecha1.strftime("%Y-%m-%d %H:%M")
                fecha_fin = fecha2Limpieza.strftime("%Y-%m-%d %H:%M")
                if fecha_inicio.split("-")[2][0:2] == fecha_fin.split("-")[2][0:2] and not config.isOverlap(fecha1,fecha2Limpieza,fechas):
                    break

            fechas.append((fecha1,fecha2Limpieza))
            numero_documento = random.randint(1, config.configUsuarios[4][0]) + 10000000
            archivo.write(f"insert into reservasSalonConferencia values (idReservasSalonConferencia.nextval, TO_DATE('{fecha_inicio}','YYYY-MM-DD HH24:MI'), {duracion}, {costo}, TO_DATE('{fecha2.strftime('%Y-%m-%d %H:%M')}','YYYY-MM-DD HH24:MI'), {idSalon},{numero_documento});\n")
        archivo.close()

ReservasSalonConferencia(config.RESERVASCONFERENCIA)
