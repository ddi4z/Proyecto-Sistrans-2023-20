--ASOCIACIONES
/* Tablas Poblacion */
--elementosHabitacion
insert into elementosHabitacion values (1, 1); /* Suite presidencial */
insert into elementosHabitacion values (1, 2);
insert into elementosHabitacion values (1, 3);
insert into elementosHabitacion values (1, 4);
insert into elementosHabitacion values (1, 5);
insert into elementosHabitacion values (1, 6);

insert into elementosHabitacion values (2, 1); /* Suite */
insert into elementosHabitacion values (2, 2);
insert into elementosHabitacion values (2, 3);
insert into elementosHabitacion values (2, 4);

insert into elementosHabitacion values (3, 1); /* Familiar */
insert into elementosHabitacion values (3, 5);
insert into elementosHabitacion values (3, 6);

insert into elementosHabitacion values (4, 1); /* Doble */
insert into elementosHabitacion values (4, 3);
insert into elementosHabitacion values (4, 4);
insert into elementosHabitacion values (4, 5);

insert into elementosHabitacion values (5, 1); /* Sencilla */
insert into elementosHabitacion values (5, 3);
insert into elementosHabitacion values (5, 4);

--serviciosPlanes
/* Tiempo compartido */
insert into serviciosPlanes values (4, 2); /* Bar Moderna */
insert into serviciosPlanes values (6, 2); /* Supermercado */
insert into serviciosPlanes values (8, 2); /* Restaurante Nacional */
insert into serviciosPlanes values (10, 2); /* Spa */

/* Todo incluido */
insert into serviciosPlanes values (5, 3); /* Bar Rock */
insert into serviciosPlanes values (9, 3); /* Restaurante Internacional */

/* Halloween */
insert into serviciosPlanes values (7, 4); /* Tienda de moda */
insert into serviciosPlanes values (16, 4); /* Salon Reunion */
insert into serviciosPlanes values (17, 4); /* Salon Conferencia */

--tienen
insert into tienen values (2, 1); /* Gimnasio */
insert into tienen values (2, 2);
insert into tienen values (2, 3);

--menusBares
insert into menusBares values (4, 1); /* Bar Moderna */
insert into menusBares values (4, 2);
insert into menusBares values (4, 3);

insert into menusBares values (5, 4); /* Bar Rock */
insert into menusBares values (5, 5);
insert into menusBares values (5, 6);

--menusEstablecimientos
insert into menusEstablecimientos values (6, 7); /* Supermercado */
insert into menusEstablecimientos values (6, 8);
insert into menusEstablecimientos values (6, 9);

insert into menusEstablecimientos values (7, 10); /* Tienda de moda */
insert into menusEstablecimientos values (7, 11);
insert into menusEstablecimientos values (7, 12);

--menusRestaurantes
insert into menusRestaurantes values (8, 13); /* Restaurante Nacional */
insert into menusRestaurantes values (8, 14);
insert into menusRestaurantes values (8, 15);

insert into menusRestaurantes values (9, 16); /* Restaurante Internacional */
insert into menusRestaurantes values (9, 17);
insert into menusRestaurantes values (9, 18);

--spasServiciosSpa
insert into spasServiciosSpa values (10, 1); /* Spa */
insert into spasServiciosSpa values (10, 2);
insert into spasServiciosSpa values (10, 3);

/* Tablas restantes */
--reservasHabitaciones
insert into reservasHabitaciones values (1, 1);

--serviciosSpaReservasSpa
insert into serviciosSpaReservasSpa values (1, 1);

commit;
