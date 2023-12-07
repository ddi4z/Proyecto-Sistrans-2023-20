import random
import os
import config
from datetime import datetime, timedelta
from faker import Faker
faker = Faker()



def ElementosHabitacion(inicio,cantidad):
    ruta = "HotelDeLosAndes/docs/scripts/faker/asociaciones/scripts/"
    if not os.path.exists(ruta):
        os.mkdir(ruta)
    with open(os.path.join(ruta, "ElementosHabitacion.sql"), "w") as archivo:
        for i in range(1,cantidad+1):
            curr = set()
            while len(curr) < 5:
                num = random.randint(inicio,len(config.maquinasGimnasio))
                if num in curr:
                    continue
                curr.add(num)
                archivo.write(f"insert into elementosHabitacion values ({i}, {num});\n")
        archivo.close()
ElementosHabitacion(1,10)
