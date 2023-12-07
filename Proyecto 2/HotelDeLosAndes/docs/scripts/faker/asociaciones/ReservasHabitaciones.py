import random
import os
import config
from faker import Faker
from datetime import datetime, timedelta
faker = Faker()

# TODO Verificar todos los posibles edgecases

habitaciones = {i:[] for i in range(1,config.HABITACIONES+1)}


def ReservasHabitaciones(inicio,cantidad,diponibilidadReservas):
    ruta = "HotelDeLosAndes/docs/scripts/faker/asociaciones/scripts/"
    if not os.path.exists(ruta):
        os.mkdir(ruta)
    with open(os.path.join(ruta, "ReservasHabitaciones.sql"), "w") as archivo:
        for i in range(inicio,cantidad+1):
            curr = set()
            ini =    datetime.strptime(diponibilidadReservas[i-1][0], '%Y-%m-%d')
            fin = datetime.strptime(diponibilidadReservas[i-1][1], '%Y-%m-%d')
            while len(curr) < random.randint(1,3):
                num = random.randint(1,config.HABITACIONES)
                if num in curr or config.isOverlap(ini,fin,habitaciones[num]):
                    continue
                curr.add(num)
                habitaciones[num].append((ini,fin))
                archivo.write(f"insert into reservasHabitaciones values ({i}, {num});\n")
        archivo.close()


ReservasHabitaciones(1,config.RESERVAS,config.diponibilidadReservas)




