--tiposUsuarios
create sequence idTiposUsuarios start with 1 increment by 1;
insert into tiposUsuarios values (idTiposUsuarios.nextval, 'Cliente');
insert into tiposUsuarios values (idTiposUsuarios.nextval, 'Recepcionista');
insert into tiposUsuarios values (idTiposUsuarios.nextval, 'Empleado');
insert into tiposUsuarios values (idTiposUsuarios.nextval, 'Administrador');
insert into tiposUsuarios values (idTiposUsuarios.nextval, 'Gerente');

--tiposHabitacion
create sequence idTiposHabitacion start with 1 increment by 1;
insert into tiposHabitacion values (idTiposHabitacion.nextval, 'Suite presidencial', 8, 1000000);
insert into tiposHabitacion values (idTiposHabitacion.nextval, 'Grand Suite', 7, 900000);
insert into tiposHabitacion values (idTiposHabitacion.nextval, 'Familiar', 6, 800000);
insert into tiposHabitacion values (idTiposHabitacion.nextval, 'Suite', 5, 700000);
insert into tiposHabitacion values (idTiposHabitacion.nextval, 'Quadruple', 4, 600000);
insert into tiposHabitacion values (idTiposHabitacion.nextval, 'Junior Suite', 3, 550000);
insert into tiposHabitacion values (idTiposHabitacion.nextval, 'Triple', 3, 500000);
insert into tiposHabitacion values (idTiposHabitacion.nextval, 'Matrimonial', 2, 450000);
insert into tiposHabitacion values (idTiposHabitacion.nextval, 'Doble', 2, 400000);
insert into tiposHabitacion values (idTiposHabitacion.nextval, 'Sencilla', 1, 300000);

--planesConsumo
create sequence idPlanesConsumo start with 1 increment by 1;
insert into planesConsumo values (idPlanesConsumo.nextval, TO_DATE('2022-01-01','YYYY-MM-DD'), TO_DATE('2023-12-31','YYYY-MM-DD'), 'Sin plan', 0, 0, 0, 0, 'SinPlan');
insert into planesConsumo values (idPlanesConsumo.nextval, TO_DATE('2022-01-01','YYYY-MM-DD'), TO_DATE('2023-12-31','YYYY-MM-DD'), 'Larga estadia', 0.15, 0, 0, 0, 'LargaEstadia');
insert into planesConsumo values (idPlanesConsumo.nextval, TO_DATE('2022-01-01','YYYY-MM-DD'), TO_DATE('2023-12-31','YYYY-MM-DD'), 'Tiempo compartido', 0, 0.1, 0.1, 0.1, 'TiempoCompartido');
insert into planesConsumo values (idPlanesConsumo.nextval, TO_DATE('2022-01-01','YYYY-MM-DD'), TO_DATE('2023-12-31','YYYY-MM-DD'), 'Todo incluido', 0, 0, 0, 0, 'TodoIncluido');
insert into planesConsumo values (idPlanesConsumo.nextval, TO_DATE('2023-10-01','YYYY-MM-DD'), TO_DATE('2023-10-31','YYYY-MM-DD'), 'Halloween', 0.15, 0.1, 0.1, 0, 'Promocion');
insert into planesConsumo values (idPlanesConsumo.nextval, TO_DATE('2023-11-01','YYYY-MM-DD'), TO_DATE('2023-11-30','YYYY-MM-DD'), 'Escapada de Noviembre', 0.2, 0.1, 0.1, 0.1, 'Promocion');
insert into planesConsumo values (idPlanesConsumo.nextval, TO_DATE('2023-12-01','YYYY-MM-DD'), TO_DATE('2023-12-31','YYYY-MM-DD'), 'Reconecta en Diciembre', 0.15, 0.1, 0.1, 0.1, 'Promocion');
