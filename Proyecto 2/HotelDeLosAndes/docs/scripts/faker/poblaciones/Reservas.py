import random
import os
import config
from datetime import datetime, timedelta
from faker import Faker
faker = Faker()


usuarios = {}
reservas = []

def generar_reservas(cantidad):
    ruta = "HotelDeLosAndes/docs/scripts/faker/poblaciones/scripts/"
    if not os.path.exists(ruta):
        os.mkdir(ruta)
    with open(os.path.join(ruta, "Reservas.sql"), "w") as archivo:

        archivo.write("create sequence idReservas start with 1 increment by 1;\n")
        
        cedulas = list(range(10000001,10090001))
        10090000
        cnt = 10000001
        for i in range(cantidad):
            max = faker.date_between(start_date='-15d', end_date='today')
            fechaInicial = faker.date_between(start_date='-365d', end_date=max)
            numNoches = random.randint(1, 15)
            fechaFinal = fechaInicial + timedelta(days=numNoches)
            numPersonas = faker.random_int(1, 10)
            checkIn = faker.random_int(0, 1)
            checkOut = faker.random_int(0, 1)
            planConsumo = faker.random_int(1, 7)
            if cnt<=10090001:
                numDocumento = cedulas.pop()
                usuarios[numDocumento] = [(fechaInicial, fechaFinal)]
            else:
                while True:
                    numDocumento = random.choice(cedulas)
                    if config.isOverlap(fechaInicial, fechaFinal, usuarios[numDocumento]):
                        continue
                    else:
                        usuarios[numDocumento].append((fechaInicial, fechaFinal))
                        break
            reservas.append((fechaInicial, fechaFinal))

            archivo.write(f"insert into reservas values (idReservas.nextval, TO_DATE('{fechaInicial.strftime('%Y-%m-%d')}','YYYY-MM-DD'), TO_DATE('{fechaFinal.strftime('%Y-%m-%d')}','YYYY-MM-DD'), {numNoches}, {numPersonas}, {checkIn}, {checkOut}, {planConsumo}, '{numDocumento}');\n")
        archivo.close()

        ruta2 = "HotelDeLosAndes/docs/scripts/faker/asociaciones/"
        with open(os.path.join(ruta2, "config.py"), "r") as archivo:
            lineas = archivo.readlines()
        archivo.close()

        lista= ["["]
        for tupla in reservas:
            lista.append(",")
            lista.append("(")
            lista.append("'"+tupla[0].strftime("%Y-%m-%d")+"'")
            lista.append(",")
            lista.append("'"+tupla[1].strftime("%Y-%m-%d")+"'")
            lista.append(")")
        lista.append("]")

        linea_string = "".join(lista).replace("[,","[")
        lineas[-1] = f"diponibilidadReservas = {linea_string}"
        with open(os.path.join(ruta2, "config.py"), "w") as archivo:
            archivo.writelines(lineas)
        archivo.close()
generar_reservas(config.RESERVAS)