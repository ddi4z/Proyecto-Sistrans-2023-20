import os

def TiposUsuarios():
    ruta = "HotelDeLosAndes/docs/scripts/faker/poblaciones/scripts/"
    if not os.path.exists(ruta):
        os.mkdir(ruta)
    with open(os.path.join(ruta, "TiposUsuarios.sql"), "w") as archivo:
        archivo.write("create sequence idTiposUsuarios start with 1 increment by 1;\n")
        archivo.write("insert into tiposUsuarios values (idTiposUsuarios.nextval, 'Cliente');\n")
        archivo.write("insert into tiposUsuarios values (idTiposUsuarios.nextval, 'Recepcionista');\n")
        archivo.write("insert into tiposUsuarios values (idTiposUsuarios.nextval, 'Empleado');\n")
        archivo.write("insert into tiposUsuarios values (idTiposUsuarios.nextval, 'Administrador');\n")
        archivo.write("insert into tiposUsuarios values (idTiposUsuarios.nextval, 'Gerente');\n")
        archivo.close()
TiposUsuarios()