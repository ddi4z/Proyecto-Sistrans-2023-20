import random
import os
import config
from faker import Faker
faker = Faker()



def Tienen(inicio,cantidad):
    ruta = "HotelDeLosAndes/docs/scripts/faker/asociaciones/scripts/"
    if not os.path.exists(ruta):
        os.mkdir(ruta)
    with open(os.path.join(ruta, "Tienen.sql"), "w") as archivo:
        for i in range(inicio,inicio+cantidad):
            curr = set()
            while len(curr) < 7:
                num = random.randint(1,len(config.elementosDotacion))
                if num in curr:
                    continue
                curr.add(num)
                archivo.write(f"insert into tienen values ({i}, {num});\n")
        archivo.close()

Tienen(config.serviciosInfo["Gimnasio"][0],config.serviciosInfo["Gimnasio"][1])
