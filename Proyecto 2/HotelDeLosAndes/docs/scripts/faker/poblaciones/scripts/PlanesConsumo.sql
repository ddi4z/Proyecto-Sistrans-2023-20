create sequence idPlanesConsumo start with 1 increment by 1;
insert into planesConsumo values (idPlanesConsumo.nextval, TO_DATE('2022-01-01','YYYY-MM-DD'), TO_DATE('2023-12-31','YYYY-MM-DD'), 'Sin plan', 0, 0, 0, 0, 'SinPlan');
insert into planesConsumo values (idPlanesConsumo.nextval, TO_DATE('2022-01-01','YYYY-MM-DD'), TO_DATE('2023-12-31','YYYY-MM-DD'), 'Larga estadia', 0.15, 0, 0, 0, 'LargaEstadia');
insert into planesConsumo values (idPlanesConsumo.nextval, TO_DATE('2022-01-01','YYYY-MM-DD'), TO_DATE('2023-12-31','YYYY-MM-DD'), 'Tiempo compartido', 0, 0.1, 0.1, 0.1, 'TiempoCompartido');
insert into planesConsumo values (idPlanesConsumo.nextval, TO_DATE('2022-01-01','YYYY-MM-DD'), TO_DATE('2023-12-31','YYYY-MM-DD'), 'Todo incluido', 0, 0, 0, 0, 'TodoIncluido');
insert into planesConsumo values (idPlanesConsumo.nextval, TO_DATE('2023-10-01','YYYY-MM-DD'), TO_DATE('2023-10-31','YYYY-MM-DD'), 'Halloween', 0.15, 0.1, 0.1, 0, 'Promocion');
insert into planesConsumo values (idPlanesConsumo.nextval, TO_DATE('2023-11-01','YYYY-MM-DD'), TO_DATE('2023-11-30','YYYY-MM-DD'), 'Escapada de Noviembre', 0.2, 0.1, 0.1, 0.1, 'Promocion');
insert into planesConsumo values (idPlanesConsumo.nextval, TO_DATE('2023-12-01','YYYY-MM-DD'), TO_DATE('2023-12-31','YYYY-MM-DD'), 'Reconecta en Diciembre', 0.15, 0.1, 0.1, 0.1, 'Promocion');
