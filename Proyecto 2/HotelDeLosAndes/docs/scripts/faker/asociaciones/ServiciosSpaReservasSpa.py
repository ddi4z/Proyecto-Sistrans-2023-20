import random
import os
import config
from faker import Faker
faker = Faker()



def Tienen(inicio,cantidad):
    ruta = "HotelDeLosAndes/docs/scripts/faker/asociaciones/scripts/"
    if not os.path.exists(ruta):
        os.mkdir(ruta)
    with open(os.path.join(ruta, "ServiciosSpasReservasSpa.sql"), "w") as archivo:
        for i in range(1,cantidad+1):
            curr = set()
            while len(curr) < random.randint(1,3):
                num = random.randint(inicio,len(config.serviciosSpas))
                if num in curr:
                    continue
                curr.add(num)
                archivo.write(f"insert into serviciosSpaReservasSpa values ({i}, {num});\n")
        archivo.close()
Tienen(1,config.RESERVASSPA)
