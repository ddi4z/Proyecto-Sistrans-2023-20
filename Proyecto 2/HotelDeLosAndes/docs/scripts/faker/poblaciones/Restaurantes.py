import random
import os
import config
from faker import Faker
faker = Faker()



def Restaurantes(inicio, cantidad):
    estilosRestaurante = ["Nacional","Internacional","Oriental""Mexicano","Peruano","Arabe","Japones","Coreano","Frances","Espaniol","Alemán","De la India","Mediterraneo"]
    ruta = "HotelDeLosAndes/docs/scripts/faker/poblaciones/scripts/"
    if not os.path.exists(ruta):
        os.mkdir(ruta)
    with open(os.path.join(ruta, "Restaurantes.sql"), "w") as archivo:
        for i in range(inicio,inicio+cantidad):
            capacidad = faker.random_int(1, 99)
            estilo = random.choice(estilosRestaurante)
            archivo.write(f"insert into restaurantes values ({i}, {capacidad}, '{estilo}');\n")
        archivo.close()

info = config.serviciosInfo["Restaurante"]
Restaurantes(info[0],info[1])