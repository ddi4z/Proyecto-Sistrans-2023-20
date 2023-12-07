import os
import config
from faker import Faker
faker = Faker()

def elementosDotacion(inicio):
    ruta = "HotelDeLosAndes/docs/scripts/faker/poblaciones/scripts/"
    if not os.path.exists(ruta):
        os.mkdir(ruta)
    with open(os.path.join(ruta, "ElementosDotacion.sql"), "w") as archivo:
        archivo.write("create sequence idElementosDotacion start with 1 increment by 1;\n")
        ELE = config.elementosDotacion
        for i in range(inicio,inicio+len(ELE)):
            archivo.write(f"insert into elementosDotacion values (idElementosDotacion.nextval, '{ELE[i-inicio]}');\n")
        archivo.close()

elementosDotacion(1)