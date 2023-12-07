SELECT *
FROM USUARIOS US
INNER JOIN CONSUMOS C ON US.NUM_DOCUMENTO = C.NUM_DOCUMENTO_CLIENTE
INNER JOIN SERVICIOS S ON S.ID = C.SERVICIO_ID
WHERE S.TIPO = :servicio
AND C.FECHA BETWEEN TO_DATE(:fechaInicial, 'YYYY-MM-DD') AND TO_DATE(:fechaFinal, 'YYYY-MM-DD')
ORDER BY :ordenamiento

SELECT *
FROM USUARIOS US
LEFT JOIN CONSUMOS C ON US.NUM_DOCUMENTO = C.NUM_DOCUMENTO_CLIENTE
LEFT JOIN SERVICIOS S ON S.ID = C.SERVICIO_ID AND S.TIPO = :servicio
WHERE S.ID IS NULL
AND (C.FECHA IS NULL
OR C.FECHA BETWEEN TO_DATE(:fechaInicial, 'YYYY-MM-DD') AND TO_DATE(:fechaFinal, 'YYYY-MM-DD'))
ORDER BY :ordenamiento

SELECT tabla.tipo_documento, tabla.num_documento, tabla.nombre, tabla.correo, COUNT(tabla.num_documento) AS semestres_estadia
FROM (SELECT usuarios.tipo_documento, usuarios.num_documento, usuarios.nombre, usuarios.correo, TO_CHAR(reservas.fecha_salida, 'Q') AS semestre, COUNT(reservas.id) AS conteo
    FROM usuarios
    INNER JOIN reservas ON usuarios.num_documento = reservas.num_documento
    WHERE EXTRACT(YEAR FROM reservas.fecha_salida) = 2023
    GROUP BY usuarios.tipo_documento, usuarios.num_documento, usuarios.nombre, usuarios.correo, TO_CHAR(reservas.fecha_salida, 'Q')
) tabla
GROUP BY tabla.tipo_documento, tabla.num_documento, tabla.nombre, tabla.correo
HAVING COUNT(tabla.num_documento) = 4
--1
SELECT habitaciones.id, habitaciones.tipo, habitaciones.ocupada, sum(costo) FROM habitaciones LEFT JOIN consumos ON consumos.habitacion_id = habitaciones.id WHERE EXTRACT(YEAR FROM fecha) = 2023 OR fecha IS NULL GROUP BY habitaciones.id, habitaciones.tipo, habitaciones.ocupada ORDER BY habitaciones.id;

--2
SELECT servicios.id, servicios.nombre, count(servicios.id) as cantidad FROM CONSUMOS RIGHT JOIN servicios ON consumos.SERVICIO_ID = servicios.ID WHERE consumos.fecha BETWEEN TO_DATE('2023-01-01 00:00','YYYY-MM-DD HH24:MI') AND TO_DATE('2023-12-31 23:59','YYYY-MM-DD HH24:MI') GROUP BY servicios.id, servicios.nombre ORDER BY cantidad DESC FETCH FIRST 20 ROWS ONLY;

--3
SELECT habitaciones.id, habitaciones.tipo, SUM(reservas.noches) AS dias_ocupacion, ROUND((SUM(reservas.noches)*100)/365, 2) AS porcentaje_ocupacion FROM habitaciones LEFT JOIN reservasHabitaciones ON habitaciones.id = reservashabitaciones.habitacion_id LEFT JOIN reservas ON reservashabitaciones.reserva_id = reservas.id WHERE reservashabitaciones.habitacion_id IS NULL OR reservas.fecha_salida < (SELECT TO_DATE(TO_CHAR(SYSDATE, 'YYYY') || '-01-01', 'YYYY-MM-DD') + INTERVAL '1' YEAR FROM DUAL) GROUP BY habitaciones.id, habitaciones.tipo ORDER BY habitaciones.id;

--5
SELECT * FROM CONSUMOS WHERE num_documento_cliente = '105' and fecha BETWEEN TO_DATE('2023-01-01 00:00','YYYY-MM-DD HH24:MI') AND TO_DATE('2023-12-31 23:59','YYYY-MM-DD HH24:MI');

--6
SELECT fechas.fecha, COUNT(CASE WHEN reservasFechas.reserva_id IS NOT NULL THEN 1 ELSE NULL END) AS habitaciones_ocupadas FROM fechas LEFT JOIN reservasFechas ON fechas.fecha = reservasFechas.fecha LEFT JOIN reservas ON reservasFechas.reserva_id = reservas.id LEFT JOIN reservasHabitaciones ON reservas.id = reservasHabitaciones.reserva_id GROUP BY fechas.fecha ORDER BY habitaciones_ocupadas DESC, fechas.fecha FETCH FIRST 20 ROWS ONLY;
SELECT fechas.fecha, COUNT(CASE WHEN reservasFechas.reserva_id IS NOT NULL THEN 1 ELSE NULL END) AS habitaciones_ocupadas FROM fechas LEFT JOIN reservasFechas ON fechas.fecha = reservasFechas.fecha LEFT JOIN reservas ON reservasFechas.reserva_id = reservas.id  LEFT JOIN reservasHabitaciones ON reservas.id = reservasHabitaciones.reserva_id GROUP BY fechas.fecha ORDER BY habitaciones_ocupadas, fechas.fecha FETCH FIRST 20 ROWS ONLY;
SELECT TRUNC(fecha), count(*) FROM CONSUMOS group by TRUNC(fecha) order by count(*) DESC FETCH FIRST 20 ROWS ONLY;

--7
SELECT usuarios.num_documento, SUM(consumos.costo) AS total_gastos, SUM(reservas.noches) AS total_noches FROM usuarios LEFT JOIN consumos ON usuarios.num_documento = consumos.num_documento_cliente LEFT JOIN reservas ON usuarios.num_documento = reservas.num_documento GROUP BY usuarios.num_documento HAVING SUM(consumos.costo) > 15000000 OR SUM(reservas.noches) >= 14 ORDER BY usuarios.num_documento;

--8
SELECT servicios.id, servicios.nombre, servicios.tipo, ROUND(COUNT(consumos.servicio_id)/TO_CHAR(SYSDATE, 'WW'), 2) FROM consumos RIGHT JOIN servicios ON consumos.servicio_id = servicios.id  GROUP BY servicios.id, servicios.nombre, servicios.tipo  HAVING ROUND(COUNT(consumos.servicio_id)/TO_CHAR(SYSDATE, 'WW'), 2) < 3  ORDER BY ROUND(COUNT(consumos.servicio_id)/TO_CHAR(SYSDATE, 'WW'), 2), servicios.id;


