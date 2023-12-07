import os
import config
from faker import Faker
faker = Faker()

# MAQUINAS GIMNASIO
def maquinasGimnasio():
    ruta = "HotelDeLosAndes/docs/scripts/faker/poblaciones/scripts/"
    if not os.path.exists(ruta):
        os.mkdir(ruta)
    with open(os.path.join(ruta, "MaquinasGimnasio.sql"), "w") as archivo:
        archivo.write("create sequence idMaquinasGimnasio start with 1 increment by 1;\n")
        MAQ = config.maquinasGimnasio
        for i in range(1,len(MAQ)+1):
            archivo.write(f"insert into maquinasGimnasio values (idMaquinasGimnasio.nextval, '{MAQ[i-1]}');\n")
        archivo.close()
maquinasGimnasio()