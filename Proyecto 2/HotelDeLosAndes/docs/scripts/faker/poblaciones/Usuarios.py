import random
import os
import config
from faker import Faker
faker = Faker()


def Usuarios():
    tiposDocumento = config.tiposDocumento
    configUsuarios = config.configUsuarios
    ruta = "HotelDeLosAndes/docs/scripts/faker/poblaciones/scripts/"
    if not os.path.exists(ruta):
        os.mkdir(ruta)
    with open(os.path.join(ruta, "Usuarios.sql"), "w") as archivo:
        cnt = 10000000
        for i, tipoUsuario in configUsuarios:
            for numeroDocumento in range(cnt+1,cnt+i+1):
                tipoDocumento = random.choice(tiposDocumento)
                name = faker.name()
                email = faker.email()
                archivo.write(f"insert into usuarios values ('{tipoDocumento}', '{numeroDocumento}', '{name}', '{email}', {tipoUsuario});\n")
            cnt += i
        archivo.close()
Usuarios()