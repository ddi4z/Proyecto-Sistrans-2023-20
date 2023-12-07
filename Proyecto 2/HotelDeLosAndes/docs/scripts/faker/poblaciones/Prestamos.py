import random
import os
import config
from faker import Faker
faker = Faker()


def Prestamos(cantidad):
    ruta = "HotelDeLosAndes/docs/scripts/faker/poblaciones/scripts/"
    utensilios = ["Cama","Almohadas","Mesa de noche","Lampara de noche","Telefono","Sabanas","Perchas","Espejo","Silla","Cafetera","Hervidor de agua","Toallas","Articulos de banio","Radio reloj despertador","Cortinas"]
    habitaciones = list(range(1,70001))
    if not os.path.exists(ruta):
        os.mkdir(ruta)
    with open(os.path.join(ruta, "Prestamos.sql"), "w") as archivo:    
        archivo.write("create sequence idPrestamos start with 1 increment by 1;\n")
        for _ in range(cantidad):
            utensilio = random.choice(utensilios)
            costo_perdida = random.randint(0, 9999999)
            devuelto = faker.random_int(0, 1)
            habitaciones_id = random.choice(habitaciones)
            documento = random.randint(10000000+30001, 10000000+90000)
            archivo.write(f"insert into prestamos values (idPrestamos.nextval, '{utensilio}', {costo_perdida:.2f}, {devuelto}, {habitaciones_id}, '{documento}');\n")
        archivo.close()


Prestamos(config.PRESTAMOS)
