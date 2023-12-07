import os

def PlanesConsumo():
    ruta = "HotelDeLosAndes/docs/scripts/faker/poblaciones/scripts/"
    if not os.path.exists(ruta):
        os.mkdir(ruta)
    with open(os.path.join(ruta, "PlanesConsumo.sql"), "w") as archivo:
        archivo.write("create sequence idPlanesConsumo start with 1 increment by 1;\n")
        archivo.write("insert into planesConsumo values (idPlanesConsumo.nextval, TO_DATE('2022-01-01','YYYY-MM-DD'), TO_DATE('2023-12-31','YYYY-MM-DD'), 'Sin plan', 0, 0, 0, 0, 'SinPlan');\n")
        archivo.write("insert into planesConsumo values (idPlanesConsumo.nextval, TO_DATE('2022-01-01','YYYY-MM-DD'), TO_DATE('2023-12-31','YYYY-MM-DD'), 'Larga estadia', 0.15, 0, 0, 0, 'LargaEstadia');\n")
        archivo.write("insert into planesConsumo values (idPlanesConsumo.nextval, TO_DATE('2022-01-01','YYYY-MM-DD'), TO_DATE('2023-12-31','YYYY-MM-DD'), 'Tiempo compartido', 0, 0.1, 0.1, 0.1, 'TiempoCompartido');\n")
        archivo.write("insert into planesConsumo values (idPlanesConsumo.nextval, TO_DATE('2022-01-01','YYYY-MM-DD'), TO_DATE('2023-12-31','YYYY-MM-DD'), 'Todo incluido', 0, 0, 0, 0, 'TodoIncluido');\n")
        archivo.write("insert into planesConsumo values (idPlanesConsumo.nextval, TO_DATE('2023-10-01','YYYY-MM-DD'), TO_DATE('2023-10-31','YYYY-MM-DD'), 'Halloween', 0.15, 0.1, 0.1, 0, 'Promocion');\n")
        archivo.write("insert into planesConsumo values (idPlanesConsumo.nextval, TO_DATE('2023-11-01','YYYY-MM-DD'), TO_DATE('2023-11-30','YYYY-MM-DD'), 'Escapada de Noviembre', 0.2, 0.1, 0.1, 0.1, 'Promocion');\n")
        archivo.write("insert into planesConsumo values (idPlanesConsumo.nextval, TO_DATE('2023-12-01','YYYY-MM-DD'), TO_DATE('2023-12-31','YYYY-MM-DD'), 'Reconecta en Diciembre', 0.15, 0.1, 0.1, 0.1, 'Promocion');\n")
        archivo.close()
PlanesConsumo()