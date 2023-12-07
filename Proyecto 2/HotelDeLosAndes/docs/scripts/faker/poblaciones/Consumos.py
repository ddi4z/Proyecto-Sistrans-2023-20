import random
import config
import os
from faker import Faker
faker = Faker()

#TODO sincronizar con servicios


def consumos(listaServicios,numHabitaciones):
    servicios = []
    for servicio in listaServicios:
        num = config.serviciosInfo[servicio][1]
        for i in range(num):
            servicios.append((i+1,"Consumo" + servicio))

    habiacionesId = list(range(1,numHabitaciones+1))
    habiacionesId2 = list(range(1,numHabitaciones+1))
    ruta = "HotelDeLosAndes/docs/scripts/faker/poblaciones/scripts/"
    if not os.path.exists(ruta):
        os.mkdir(ruta)


    with open(os.path.join(ruta, "Consumos.sql"), "w") as archivo:

        archivo.write("create sequence idConsumos start with 1 increment by 1;\n")
        for i in range(numHabitaciones):
            year, month, day, hour, minute= random.randint(2022, 2023),random.randint(1, 12),random.randint(1, 28), random.randint(0, 23),random.choice(config.minutos)
            fecha = f'{year:04d}-{month:02d}-{day:02d} {hour:02d}:{minute:02d}'
            if servicios:
                servicioId, descripcion = servicios.pop()
            else:
                servicioId, descripcion = "NULL", "Consumo"
            costo = random.randint(0, 999999)
            pagado = faker.random_int(0, 1)
            if habiacionesId:
                habitacionId = habiacionesId.pop()
            else:
                habitacionId =  random.choice(habiacionesId2)
            cliente = random.randint(10000000+30001, 10000000+90000) 
            empleado = random.randint(10000000+9201, 10000000+30000)
            
            archivo.write(f"insert into consumos values (idConsumos.nextval, TO_DATE('{fecha}','YYYY-MM-DD HH24:MI'), '{descripcion}', {costo:02d}, {pagado}, {habitacionId}, {servicioId}, '{cliente}', '{empleado}');\n")
        archivo.close()
consumos(config.serviciosList,config.HABITACIONES)