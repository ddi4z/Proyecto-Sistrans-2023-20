import random
import os
import config
from faker import Faker
faker = Faker()

def Productos(cantidad):
    ruta = "HotelDeLosAndes/docs/scripts/faker/poblaciones/scripts/"
    if not os.path.exists(ruta):
        os.mkdir(ruta)
    with open(os.path.join(ruta, "Productos.sql"), "w") as archivo:
        archivo.write("create sequence idProductos start with 1 increment by 1;\n")
        for i in range(1,cantidad+1):
            nombre = "Producto "+ str(i)
            costo = random.randint(0, 9999999)
            incluido_en_planes = faker.random_int(0, 1)
            archivo.write(f"insert into productos values (idProductos.nextval, '{nombre}', {costo:.2F}, {incluido_en_planes});\n")
        archivo.close()

Productos(config.PRODUCTOS)
