import os

def TiposHabitacion():
    ruta = "HotelDeLosAndes/docs/scripts/faker/poblaciones/scripts/"
    if not os.path.exists(ruta):
        os.mkdir(ruta)
    with open(os.path.join(ruta, "TiposHabitacion.sql"), "w") as archivo:
        archivo.write("create sequence idTiposHabitacion start with 1 increment by 1;\n")
        archivo.write("insert into tiposHabitacion values (idTiposHabitacion.nextval, 'Suite presidencial', 8, 1000000);\n")
        archivo.write("insert into tiposHabitacion values (idTiposHabitacion.nextval, 'Grand Suite', 7, 900000);\n")
        archivo.write("insert into tiposHabitacion values (idTiposHabitacion.nextval, 'Familiar', 6, 800000);\n")
        archivo.write("insert into tiposHabitacion values (idTiposHabitacion.nextval, 'Suite', 5, 700000);\n")
        archivo.write("insert into tiposHabitacion values (idTiposHabitacion.nextval, 'Quadruple', 4, 600000);\n")
        archivo.write("insert into tiposHabitacion values (idTiposHabitacion.nextval, 'Junior Suite', 3, 550000);\n")
        archivo.write("insert into tiposHabitacion values (idTiposHabitacion.nextval, 'Triple', 3, 500000);\n")
        archivo.write("insert into tiposHabitacion values (idTiposHabitacion.nextval, 'Matrimonial', 2, 450000);\n")
        archivo.write("insert into tiposHabitacion values (idTiposHabitacion.nextval, 'Doble', 2, 400000);\n")
        archivo.write("insert into tiposHabitacion values (idTiposHabitacion.nextval, 'Sencilla', 1, 300000);\n")
        archivo.close()
TiposHabitacion()