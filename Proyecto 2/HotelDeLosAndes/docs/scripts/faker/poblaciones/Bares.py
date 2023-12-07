import random
import config
import os
from faker import Faker
faker = Faker()

def Bares(inicio, cantidad):
    ruta = "HotelDeLosAndes/docs/scripts/faker/poblaciones/scripts/"
    if not os.path.exists(ruta):
        os.mkdir(ruta)
    with open(os.path.join(ruta, "Bares.sql"), "w") as archivo:
        estilosBar = ["Moderna","Rock","Jazz""Salsa","Bachata","Caribenia","Pub","Bar cafe","Tematico","Vinoteca","Cocteleria" ,"Lounge"]
        for i in range(inicio+1,inicio+cantidad+1):
            capacidad = faker.random_int(1, 99)
            estilo = random.choice(estilosBar)
            archivo.write(f"insert into bares values ({i}, {capacidad}, '{estilo}');\n")
        archivo.close()


info = config.serviciosInfo["Bar"]
Bares(info[0],info[1])