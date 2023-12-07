import os
import config
from faker import Faker
faker = Faker()

def establecimientos(inicio, cantidad):
    ruta = "HotelDeLosAndes/docs/scripts/faker/poblaciones/scripts/"
    if not os.path.exists(ruta):
        os.mkdir(ruta)
    with open(os.path.join(ruta, "EstablecimientosComercio.sql"), "w") as archivo:
        for i in range(inicio,inicio+cantidad):
            if i % 2 == 0:
                tipo = "Supermercado"
            else:
                tipo = "Tienda"
            archivo.write(f"insert into establecimientosComercio values ({i}, '{tipo.capitalize()}');\n")
        archivo.close()

info = config.serviciosInfo["EstablecimientoComercio"]
establecimientos(info[0],info[1])