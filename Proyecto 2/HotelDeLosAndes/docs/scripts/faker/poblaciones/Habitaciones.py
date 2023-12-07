import os
from faker import Faker
import config
faker = Faker()

def Habitaciones(cantidad):
    ruta = "HotelDeLosAndes/docs/scripts/faker/poblaciones/scripts/"
    if not os.path.exists(ruta):
        os.mkdir(ruta)
    with open(os.path.join(ruta, "Habitaciones.sql"), "w") as archivo:
        archivo.write("create sequence idHabitaciones start with 1 increment by 1;\n")
        for i in range(cantidad):
            ocupada = faker.random_int(0, 1)
            tipoHabitacion = faker.random_int(1, 10)
            archivo.write(f"insert into habitaciones values (idHabitaciones.nextval, {ocupada}, {tipoHabitacion});\n")
        archivo.close()




Habitaciones(config.HABITACIONES)

