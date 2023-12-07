import random
import os
import config
from faker import Faker
faker = Faker()



def ServiciosPlanes(inicio,cantidad):
    ruta = "HotelDeLosAndes/docs/scripts/faker/asociaciones/scripts/"
    if not os.path.exists(ruta):
        os.mkdir(ruta)
    with open(os.path.join(ruta, "ServiciosPlanes.sql"), "w") as archivo:
        for i in range(1,cantidad+1):
            curr = set()
            while len(curr) < random.randint(0,4):
                num = random.randint(1,7)
                if num in curr:
                    continue
                curr.add(num)
                archivo.write(f"insert into serviciosPlanes values  ({i}, {num});\n")
        archivo.close()
ServiciosPlanes(1,config.TOTAL_SERVICIOS)
