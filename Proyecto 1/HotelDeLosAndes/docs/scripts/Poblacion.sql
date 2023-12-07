--SECUENCIAS
/* Tablas Poblacion */
create sequence idTiposUsuarios start with 1 increment by 1;
create sequence idTiposHabitacion start with 1 increment by 1;
create sequence idElementosDotacion start with 1 increment by 1;
create sequence idHabitaciones start with 1 increment by 1;
create sequence idServicios start with 1 increment by 1;
create sequence idMaquinasGimnasio start with 1 increment by 1;
create sequence idProductos start with 1 increment by 1;
create sequence idServiciosSpa start with 1 increment by 1;
create sequence idPlanesConsumo start with 1 increment by 1;

/* Tablas restantes */
create sequence idReservas start with 1 increment by 1;
create sequence idConsumos start with 1 increment by 1;
create sequence idReservasSpa start with 1 increment by 1;
create sequence idPrestamos start with 1 increment by 1;
create sequence idReservasSalonReunion start with 1 increment by 1;
create sequence idReservasSalonConferencia start with 1 increment by 1;

--TABLAS
/* Tablas Poblacion */
--tiposUsuarios
insert into tiposUsuarios values (idTiposUsuarios.nextval, 'CLIENTE');
insert into tiposUsuarios values (idTiposUsuarios.nextval, 'RECEPCIONISTA');
insert into tiposUsuarios values (idTiposUsuarios.nextval, 'EMPLEADO');
insert into tiposUsuarios values (idTiposUsuarios.nextval, 'ADMINISTRADOR');
insert into tiposUsuarios values (idTiposUsuarios.nextval, 'GERENTE');

--usuarios
insert into usuarios values ('C.C', '123', 'Santiago', 'santiago@gmail.com', 5);
insert into usuarios values ('C.C', '128', 'Wilmer', 'wilmer@gmail.com', 4);
insert into usuarios values ('C.C', '154', 'Daniel', 'daniel@gmail.com', 2);
insert into usuarios values ('C.C', '103', 'Sara', 'sara@gmail.com', 2);
insert into usuarios values ('C.C', '428', 'Sofia', 'sofia@gmail.com', 3);
insert into usuarios values ('C.C', '623', 'Carlos', 'carlos@gmail.com', 3);
insert into usuarios values ('C.C', '112', 'Catalina', 'catalina@gmail.com', 3);
insert into usuarios values ('C.C', '230', 'Mateo', 'mateo@gmail.com', 3);
insert into usuarios values ('C.C', '105', 'Alejandro', 'alejandro@gmail.com', 1);
insert into usuarios values ('C.C', '285', 'Ricardo', 'ricardo@gmail.com', 1);
insert into usuarios values ('C.C', '360', 'Mariana', 'mariana@gmail.com', 1);
insert into usuarios values ('C.C', '224', 'Johanna', 'johanna@gmail.com', 1);

--tiposHabitacion
insert into tiposHabitacion values (idTiposHabitacion.nextval, 'Suite presidencial', 8, 800000);
insert into tiposHabitacion values (idTiposHabitacion.nextval, 'Suite', 6, 600000);
insert into tiposHabitacion values (idTiposHabitacion.nextval, 'Familiar', 8, 700000);
insert into tiposHabitacion values (idTiposHabitacion.nextval, 'Doble', 2, 500000);
insert into tiposHabitacion values (idTiposHabitacion.nextval, 'Sencilla', 1, 300000);

--elementosDotacion
insert into elementosDotacion values (idElementosDotacion.nextval, 'TV');
insert into elementosDotacion values (idElementosDotacion.nextval, 'Jacuzzi');
insert into elementosDotacion values (idElementosDotacion.nextval, 'Minibar');
insert into elementosDotacion values (idElementosDotacion.nextval, 'Cafetera');
insert into elementosDotacion values (idElementosDotacion.nextval, 'Comedor');
insert into elementosDotacion values (idElementosDotacion.nextval, 'Cocina');

--habitaciones
insert into habitaciones values (idHabitaciones.nextval, 0, 1);
insert into habitaciones values (idHabitaciones.nextval, 0, 1);
insert into habitaciones values (idHabitaciones.nextval, 0, 1);
insert into habitaciones values (idHabitaciones.nextval, 0, 2);
insert into habitaciones values (idHabitaciones.nextval, 0, 2);
insert into habitaciones values (idHabitaciones.nextval, 0, 2);
insert into habitaciones values (idHabitaciones.nextval, 0, 3);
insert into habitaciones values (idHabitaciones.nextval, 0, 3);
insert into habitaciones values (idHabitaciones.nextval, 0, 3);
insert into habitaciones values (idHabitaciones.nextval, 0, 4);
insert into habitaciones values (idHabitaciones.nextval, 0, 4);
insert into habitaciones values (idHabitaciones.nextval, 0, 4);
insert into habitaciones values (idHabitaciones.nextval, 0, 5);
insert into habitaciones values (idHabitaciones.nextval, 0, 5);
insert into habitaciones values (idHabitaciones.nextval, 0, 5);

--servicios
insert into servicios values (idServicios.nextval, 'Piscina');
insert into servicios values (idServicios.nextval, 'Gimnasio');
insert into servicios values (idServicios.nextval, 'Internet');
insert into servicios values (idServicios.nextval, 'Bar Moderna');
insert into servicios values (idServicios.nextval, 'Bar Rock');
insert into servicios values (idServicios.nextval, 'Supermercado');
insert into servicios values (idServicios.nextval, 'Tienda de moda');
insert into servicios values (idServicios.nextval, 'Restaurante Nacional');
insert into servicios values (idServicios.nextval, 'Restaurante Internacional');
insert into servicios values (idServicios.nextval, 'Spa');
insert into servicios values (idServicios.nextval, 'Embolar Zapatos');
insert into servicios values (idServicios.nextval, 'Lavar Camisa');
insert into servicios values (idServicios.nextval, 'Lavar Pantalon');
insert into servicios values (idServicios.nextval, 'Planchar Camisa');
insert into servicios values (idServicios.nextval, 'Planchar Pantalon');
insert into servicios values (idServicios.nextval, 'Salon Reunion');
insert into servicios values (idServicios.nextval, 'Salon Conferencia');

--piscinas
insert into piscinas values (1, 10, 2, TO_DATE('7:00','HH24:MI'), TO_DATE('22:00','HH24:MI'), 0);

--gimnasios
insert into gimnasios values (2, 30, TO_DATE('6:00','HH24:MI'), TO_DATE('20:00','HH24:MI'), 0);

--maquinasGimnasio
insert into maquinasGimnasio values (idMaquinasGimnasio.nextval, 'Caminadora');
insert into maquinasGimnasio values (idMaquinasGimnasio.nextval, 'Bicicleta');
insert into maquinasGimnasio values (idMaquinasGimnasio.nextval, 'Barra');

--internets
insert into internets values (3, 300, 0);

--bares
insert into bares values (4, 40, 'Moderna');
insert into bares values (5, 30, 'Rock');

--establecimientosComercio
insert into establecimientosComercio values (6, 'SUPERMERCADO');
insert into establecimientosComercio values (7, 'TIENDA');

--restaurantes
insert into restaurantes values (8, 40, 'Nacional');
insert into restaurantes values (9, 30, 'Internacional');

--productos
insert into productos values (idProductos.nextval, 'Cerveza', 4000, 1);
insert into productos values (idProductos.nextval, 'Agua', 2000, 1);
insert into productos values (idProductos.nextval, 'Gaseosa', 2000, 1);
insert into productos values (idProductos.nextval, 'Aguardiente', 30000, 0);
insert into productos values (idProductos.nextval, 'Cocktail', 25000, 0);
insert into productos values (idProductos.nextval, 'Canada Dry', 4000, 1);

insert into productos values (idProductos.nextval, 'Manzana', 1000, 1);
insert into productos values (idProductos.nextval, 'Bolsa de leche', 4000, 1);
insert into productos values (idProductos.nextval, 'Pan empacado', 2000, 1);

insert into productos values (idProductos.nextval, 'Aretes', 20000, 1);
insert into productos values (idProductos.nextval, 'Collar', 30000, 1);
insert into productos values (idProductos.nextval, 'Anillo', 35000, 0);

insert into productos values (idProductos.nextval, 'Bandeja paisa', 18000, 1);
insert into productos values (idProductos.nextval, 'Tamal', 12000, 1);
insert into productos values (idProductos.nextval, 'Corrientazo', 10000, 1);
insert into productos values (idProductos.nextval, 'Sushi', 30000, 0);
insert into productos values (idProductos.nextval, 'Curry', 25000, 0);
insert into productos values (idProductos.nextval, 'Paella', 20000, 1);

--spas
insert into spas values (10, 15);

--serviciosSpa
insert into serviciosSpa values (idServiciosSpa.nextval, 'Masaje relajante', 45, 30000);
insert into serviciosSpa values (idServiciosSpa.nextval, 'Turco', 60, 32000);
insert into serviciosSpa values (idServiciosSpa.nextval, 'Sauna', 60, 32000);

--serviciosLavanderia
insert into serviciosLavanderia values (11, 4000);
insert into serviciosLavanderia values (12, 5000);
insert into serviciosLavanderia values (13, 5000);
insert into serviciosLavanderia values (14, 4000);
insert into serviciosLavanderia values (15, 4000);

--salonesReunion
insert into salonesReunion values (16, 12, 25000, 5000);

--salonesConferencia
insert into salonesConferencia values (17, 50, 60000);

--planesConsumo
insert into planesConsumo values (idPlanesConsumo.nextval, TO_DATE('2023-01-01','YYYY-MM-DD'), TO_DATE('2023-12-31','YYYY-MM-DD'), 'Larga estadia', 0.15, 0, 0, 0, 'LARGA ESTADIA');
insert into planesConsumo values (idPlanesConsumo.nextval, TO_DATE('2023-01-01','YYYY-MM-DD'), TO_DATE('2023-12-31','YYYY-MM-DD'), 'Tiempo compartido', 0, 0.10, 0.10, 0.10, 'TIEMPO COMPARTIDO');
insert into planesConsumo values (idPlanesConsumo.nextval, TO_DATE('2023-01-01','YYYY-MM-DD'), TO_DATE('2023-12-31','YYYY-MM-DD'), 'Todo incluido', 0, 0, 0, 0, 'TODO INCLUIDO');
insert into planesConsumo values (idPlanesConsumo.nextval, TO_DATE('2023-10-01','YYYY-MM-DD'), TO_DATE('2023-10-31','YYYY-MM-DD'), 'Halloween', 0.15, 0.1, 0.1, 0, 'PROMOCION');

/* Tablas restantes */
--reservas
insert into reservas values (idReservas.nextval, TO_DATE('2023-10-01','YYYY-MM-DD'), TO_DATE('2023-10-08','YYYY-MM-DD'), 7, 1, 0, 0, 4, '105');

--consumos
insert into consumos values (idConsumos.nextval, TO_DATE('2023-10-01 19:30','YYYY-MM-DD HH24:MI'), 'Consumo Bar Moderna', 4000, 1, 1, 4);

--reservasSpa
insert into reservasSpa values (idReservasSpa.nextval, TO_DATE('2023-10-02 08:00','YYYY-MM-DD HH24:MI'), TO_DATE('2023-10-02 08:45','YYYY-MM-DD HH24:MI'), 30000, 10);

--prestamos
insert into prestamos values (idPrestamos.nextval, 'Toalla', 15000, 1, 1);

--reservasSalonReunion
insert into reservasSalonReunion values (idReservasSalonReunion.nextval, TO_DATE('2023-10-03 08:00','YYYY-MM-DD HH24:MI'), 60, 25000, TO_DATE('2023-10-03 10:00','YYYY-MM-DD HH24:MI'), 16);

--reservasSalonConferencia
insert into reservasSalonConferencia values (idReservasSalonConferencia.nextval, TO_DATE('2023-10-04 08:00','YYYY-MM-DD HH24:MI'), 120, 120000, TO_DATE('2023-10-04 22:00','YYYY-MM-DD HH24:MI'), 17);

commit;





