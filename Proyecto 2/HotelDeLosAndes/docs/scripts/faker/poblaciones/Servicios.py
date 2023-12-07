import config
import os
from faker import Faker
faker = Faker()





def Servicios():
    ruta = "HotelDeLosAndes/docs/scripts/faker/poblaciones/scripts/"
    if not os.path.exists(ruta):
        os.mkdir(ruta)
    with open(os.path.join(ruta, "Servicios.sql"), "w") as archivo:
        archivo.write("create sequence idServicios start with 1 increment by 1;")
        for tipoServicio, cantidad in config.serviciosInfo.items():
            for i in range(cantidad[1]):
                nombre = tipoServicio+str(i+1)
                archivo.write(f"insert into servicios values (idServicios.nextval, '{nombre}', '{tipoServicio}');\n")
        archivo.close()
Servicios()


