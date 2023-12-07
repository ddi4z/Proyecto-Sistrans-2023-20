--Creacion B+
CREATE INDEX reservas_fecha_entrada ON reservas(fecha_entrada);
CREATE INDEX reservas_fecha_salida ON reservas(fecha_salida);
CREATE INDEX reservas_noches ON reservas(noches);
CREATE INDEX reservas_num_documento ON reservas(num_documento);

CREATE INDEX consumos_fecha ON consumos(fecha);
CREATE INDEX consumos_costo ON consumos(costo);
CREATE INDEX consumos_servicio_id ON consumos(servicio_id);
CREATE INDEX consumos_habitacion_id ON consumos(habitacion_id);
CREATE INDEX consumos_num_documento_cliente ON consumos(num_documento_cliente);
CREATE INDEX consumos_num_documento_empleado ON consumos(num_documento_empleado);

CREATE INDEX servicios_tipo ON servicios(tipo);

CREATE INDEX salonesReunion_costo_hora ON salonesReunion(costo_hora);
CREATE INDEX salonesConferencia_costo_hora ON salonesConferencia(costo_hora);

CREATE INDEX piscinas_costo_adicional ON piscinas(costo_adicional);
CREATE INDEX gimnasios_costo_adicional ON gimnasios(costo_adicional);

CREATE INDEX internets_costo_dia ON internets(costo_dia);

CREATE INDEX productos_costo ON productos(costo);
CREATE INDEX serviciosLavanderia_costo ON serviciosLavanderia(costo);
CREATE INDEX serviciosSpa_costo ON serviciosSpa(costo);

CREATE INDEX reservasSalonReunion_duracion ON reservasSalonReunion(duracion);
CREATE INDEX reservasSalonReunion_num_documento ON reservasSalonReunion(num_documento);

CREATE INDEX reservasSalonConferencia_duracion ON reservasSalonConferencia(duracion);
CREATE INDEX reservasSalonConferencia_num_documento ON reservasSalonConferencia(num_documento);

CREATE INDEX reservasSpa_duracion ON reservasSpa(duracion);
CREATE INDEX reservasSpa_num_documento ON reservasSpa(num_documento);

COMMIT;

--Borrado B+
DROP INDEX reservas_fecha_entrada;
DROP INDEX reservas_fecha_salida;
DROP INDEX reservas_noches;
DROP INDEX reservas_num_documento;

DROP INDEX consumos_fecha;
DROP INDEX consumos_costo;
DROP INDEX consumos_servicio_id;
DROP INDEX consumos_habitacion_id;
DROP INDEX consumos_num_documento_cliente;
DROP INDEX consumos_num_documento_empleado;

DROP INDEX servicios_tipo;

DROP INDEX salonesReunion_costo_hora;
DROP INDEX salonesConferencia_costo_hora;

DROP INDEX piscinas_costo_adicional;
DROP INDEX gimnasios_costo_adicional;

DROP INDEX internets_costo_dia;

DROP INDEX productos_costo;
DROP INDEX serviciosLavanderia_costo;
DROP INDEX serviciosSpa_costo;

DROP INDEX reservasSalonReunion_duracion;
DROP INDEX reservasSalonReunion_num_documento;

DROP INDEX reservasSalonConferencia_duracion;
DROP INDEX reservasSalonConferencia_num_documento;

DROP INDEX reservasSpa_duracion;
DROP INDEX reservasSpa_num_documento;

COMMIT;