--  AMBOS SERVICIOS
--DE UNA
--Solo fecha
SELECT servicios.* 
FROM servicios 
INNER JOIN consumos ON servicios.id = consumos.servicio_id
WHERE consumos.fecha BETWEEN TO_DATE('2023-01-01','YYYY-MM-DD') AND TO_DATE('2023-12-31','YYYY-MM-DD')
ORDER BY servicios.id;

--Solo empleado
SELECT servicios.* 
FROM servicios 
INNER JOIN consumos ON servicios.id = consumos.servicio_id
WHERE consumos.num_documento_empleado = '428'
ORDER BY servicios.id;

--Solo tipo
SELECT servicios.* 
FROM servicios 
INNER JOIN consumos ON servicios.id = consumos.servicio_id
WHERE servicios.tipo = 'ServicioLavanderia'
ORDER BY servicios.id;

--DE DOS
--Solo fecha y empleado
SELECT servicios.* 
FROM servicios 
INNER JOIN consumos ON servicios.id = consumos.servicio_id
WHERE consumos.fecha BETWEEN TO_DATE('2023-01-01','YYYY-MM-DD') AND TO_DATE('2023-12-31','YYYY-MM-DD') AND
consumos.num_documento_empleado = '428'
ORDER BY servicios.id;

--Solo fecha y tipo
SELECT servicios.* 
FROM servicios 
INNER JOIN consumos ON servicios.id = consumos.servicio_id
WHERE servicios.tipo = 'ServicioLavanderia' AND
consumos.fecha BETWEEN TO_DATE('2023-01-01','YYYY-MM-DD') AND TO_DATE('2023-12-31','YYYY-MM-DD')
ORDER BY servicios.id;

--Solo empleado y tipo
SELECT servicios.* 
FROM servicios 
INNER JOIN consumos ON servicios.id = consumos.servicio_id
WHERE servicios.tipo = 'ServicioLavanderia' AND
consumos.num_documento_empleado = '428'
ORDER BY servicios.id;

--DE TRES
--Solo fecha, empleado, tipo
SELECT servicios.* 
FROM servicios 
INNER JOIN consumos ON servicios.id = consumos.servicio_id
WHERE servicios.tipo = 'ServicioLavanderia' AND
consumos.fecha BETWEEN TO_DATE('2023-01-01','YYYY-MM-DD') AND TO_DATE('2023-12-31','YYYY-MM-DD') AND
consumos.num_documento_empleado = '428'
ORDER BY servicios.id;


--  SERVICIOS SIMPLES
--DE UNA
--Solo precio
SELECT servicios.* 
FROM servicios
LEFT JOIN piscinas ON servicios.id = piscinas.id
LEFT JOIN gimnasios ON servicios.id = gimnasios.id
LEFT JOIN internets ON servicios.id = internets.id
LEFT JOIN serviciosLavanderia ON servicios.id = serviciosLavanderia.id
LEFT JOIN salonesConferencia ON servicios.id = salonesConferencia.id
LEFT JOIN salonesReunion ON servicios.id = salonesReunion.id
WHERE piscinas.costo_adicional BETWEEN 0 AND 500000 OR
gimnasios.costo_adicional BETWEEN 0 AND 500000 OR
internets.costo_dia BETWEEN 0 AND 500000 OR
serviciosLavanderia.costo BETWEEN 0 AND 500000 OR
salonesConferencia.costo_hora BETWEEN 0 AND 500000 OR
salonesReunion.costo_hora BETWEEN 0 AND 500000
ORDER BY servicios.id;

--DE DOS
--Solo precio y fecha
SELECT servicios.* 
FROM servicios 
INNER JOIN consumos ON servicios.id = consumos.servicio_id
WHERE consumos.fecha BETWEEN TO_DATE('2023-01-01','YYYY-MM-DD') AND TO_DATE('2023-12-31','YYYY-MM-DD')
INTERSECT
SELECT servicios.* 
FROM servicios
LEFT JOIN piscinas ON servicios.id = piscinas.id
LEFT JOIN gimnasios ON servicios.id = gimnasios.id
LEFT JOIN internets ON servicios.id = internets.id
LEFT JOIN serviciosLavanderia ON servicios.id = serviciosLavanderia.id
LEFT JOIN salonesConferencia ON servicios.id = salonesConferencia.id
LEFT JOIN salonesReunion ON servicios.id = salonesReunion.id
WHERE piscinas.costo_adicional BETWEEN 0 AND 500000 OR
gimnasios.costo_adicional BETWEEN 0 AND 500000 OR
internets.costo_dia BETWEEN 0 AND 500000 OR
serviciosLavanderia.costo BETWEEN 0 AND 500000 OR
salonesConferencia.costo_hora BETWEEN 0 AND 500000 OR
salonesReunion.costo_hora BETWEEN 0 AND 500000;

--Solo precio y empleado
SELECT servicios.* 
FROM servicios 
INNER JOIN consumos ON servicios.id = consumos.servicio_id
WHERE consumos.num_documento_empleado = '428'
INTERSECT
SELECT servicios.* 
FROM servicios
LEFT JOIN piscinas ON servicios.id = piscinas.id
LEFT JOIN gimnasios ON servicios.id = gimnasios.id
LEFT JOIN internets ON servicios.id = internets.id
LEFT JOIN serviciosLavanderia ON servicios.id = serviciosLavanderia.id
LEFT JOIN salonesConferencia ON servicios.id = salonesConferencia.id
LEFT JOIN salonesReunion ON servicios.id = salonesReunion.id
WHERE piscinas.costo_adicional BETWEEN 0 AND 500000 OR
gimnasios.costo_adicional BETWEEN 0 AND 500000 OR
internets.costo_dia BETWEEN 0 AND 500000 OR
serviciosLavanderia.costo BETWEEN 0 AND 500000 OR
salonesConferencia.costo_hora BETWEEN 0 AND 500000 OR
salonesReunion.costo_hora BETWEEN 0 AND 500000;

--Solo precio y tipo
SELECT servicios.* 
FROM servicios 
INNER JOIN consumos ON servicios.id = consumos.servicio_id
WHERE servicios.tipo = 'ServicioLavanderia'
INTERSECT
SELECT servicios.* 
FROM servicios
LEFT JOIN piscinas ON servicios.id = piscinas.id
LEFT JOIN gimnasios ON servicios.id = gimnasios.id
LEFT JOIN internets ON servicios.id = internets.id
LEFT JOIN serviciosLavanderia ON servicios.id = serviciosLavanderia.id
LEFT JOIN salonesConferencia ON servicios.id = salonesConferencia.id
LEFT JOIN salonesReunion ON servicios.id = salonesReunion.id
WHERE piscinas.costo_adicional BETWEEN 0 AND 500000 OR
gimnasios.costo_adicional BETWEEN 0 AND 500000 OR
internets.costo_dia BETWEEN 0 AND 500000 OR
serviciosLavanderia.costo BETWEEN 0 AND 500000 OR
salonesConferencia.costo_hora BETWEEN 0 AND 500000 OR
salonesReunion.costo_hora BETWEEN 0 AND 500000;

--DE TRES
--Solo precio, fecha, empleado
SELECT servicios.* 
FROM servicios 
INNER JOIN consumos ON servicios.id = consumos.servicio_id
WHERE consumos.fecha BETWEEN TO_DATE('2023-01-01','YYYY-MM-DD') AND TO_DATE('2023-12-31','YYYY-MM-DD') AND
consumos.num_documento_empleado = '428'
INTERSECT
SELECT servicios.* 
FROM servicios
LEFT JOIN piscinas ON servicios.id = piscinas.id
LEFT JOIN gimnasios ON servicios.id = gimnasios.id
LEFT JOIN internets ON servicios.id = internets.id
LEFT JOIN serviciosLavanderia ON servicios.id = serviciosLavanderia.id
LEFT JOIN salonesConferencia ON servicios.id = salonesConferencia.id
LEFT JOIN salonesReunion ON servicios.id = salonesReunion.id
WHERE piscinas.costo_adicional BETWEEN 0 AND 500000 OR
gimnasios.costo_adicional BETWEEN 0 AND 500000 OR
internets.costo_dia BETWEEN 0 AND 500000 OR
serviciosLavanderia.costo BETWEEN 0 AND 500000 OR
salonesConferencia.costo_hora BETWEEN 0 AND 500000 OR
salonesReunion.costo_hora BETWEEN 0 AND 500000;

--Solo precio, fecha, tipo
SELECT servicios.* 
FROM servicios 
INNER JOIN consumos ON servicios.id = consumos.servicio_id
WHERE servicios.tipo = 'ServicioLavanderia' AND
consumos.fecha BETWEEN TO_DATE('2023-01-01','YYYY-MM-DD') AND TO_DATE('2023-12-31','YYYY-MM-DD')
INTERSECT
SELECT servicios.* 
FROM servicios
LEFT JOIN piscinas ON servicios.id = piscinas.id
LEFT JOIN gimnasios ON servicios.id = gimnasios.id
LEFT JOIN internets ON servicios.id = internets.id
LEFT JOIN serviciosLavanderia ON servicios.id = serviciosLavanderia.id
LEFT JOIN salonesConferencia ON servicios.id = salonesConferencia.id
LEFT JOIN salonesReunion ON servicios.id = salonesReunion.id
WHERE piscinas.costo_adicional BETWEEN 0 AND 500000 OR
gimnasios.costo_adicional BETWEEN 0 AND 500000 OR
internets.costo_dia BETWEEN 0 AND 500000 OR
serviciosLavanderia.costo BETWEEN 0 AND 500000 OR
salonesConferencia.costo_hora BETWEEN 0 AND 500000 OR
salonesReunion.costo_hora BETWEEN 0 AND 500000;

--Solo precio, empleado, tipo
SELECT servicios.* 
FROM servicios 
INNER JOIN consumos ON servicios.id = consumos.servicio_id
WHERE servicios.tipo = 'ServicioLavanderia' AND
consumos.num_documento_empleado = '428'
INTERSECT
SELECT servicios.* 
FROM servicios
LEFT JOIN piscinas ON servicios.id = piscinas.id
LEFT JOIN gimnasios ON servicios.id = gimnasios.id
LEFT JOIN internets ON servicios.id = internets.id
LEFT JOIN serviciosLavanderia ON servicios.id = serviciosLavanderia.id
LEFT JOIN salonesConferencia ON servicios.id = salonesConferencia.id
LEFT JOIN salonesReunion ON servicios.id = salonesReunion.id
WHERE piscinas.costo_adicional BETWEEN 0 AND 500000 OR
gimnasios.costo_adicional BETWEEN 0 AND 500000 OR
internets.costo_dia BETWEEN 0 AND 500000 OR
serviciosLavanderia.costo BETWEEN 0 AND 500000 OR
salonesConferencia.costo_hora BETWEEN 0 AND 500000 OR
salonesReunion.costo_hora BETWEEN 0 AND 500000;

--COMPLETA
SELECT servicios.* 
FROM servicios 
INNER JOIN consumos ON servicios.id = consumos.servicio_id
WHERE (servicios.tipo = 'ServicioLavanderia' AND
consumos.fecha BETWEEN TO_DATE('2023-01-01','YYYY-MM-DD') AND TO_DATE('2023-12-31','YYYY-MM-DD') AND
consumos.num_documento_empleado = '428')
INTERSECT
SELECT servicios.* 
FROM servicios
LEFT JOIN piscinas ON servicios.id = piscinas.id
LEFT JOIN gimnasios ON servicios.id = gimnasios.id
LEFT JOIN internets ON servicios.id = internets.id
LEFT JOIN serviciosLavanderia ON servicios.id = serviciosLavanderia.id
LEFT JOIN salonesConferencia ON servicios.id = salonesConferencia.id
LEFT JOIN salonesReunion ON servicios.id = salonesReunion.id
WHERE piscinas.costo_adicional BETWEEN 0 AND 500000 OR
gimnasios.costo_adicional BETWEEN 0 AND 500000 OR
internets.costo_dia BETWEEN 0 AND 500000 OR
serviciosLavanderia.costo BETWEEN 0 AND 500000 OR
salonesConferencia.costo_hora BETWEEN 0 AND 500000 OR
salonesReunion.costo_hora BETWEEN 0 AND 500000;


--  SERVICIOS CON PROMEDIO
--DE UNA
--Solo precio
SELECT servicios.*
FROM servicios
INNER JOIN bares ON servicios.id = bares.id
INNER JOIN menusBares ON bares.id = menusBares.bar_id
INNER JOIN productos ON menusBares.producto_id = productos.id
GROUP BY servicios.id, servicios.nombre, servicios.tipo
HAVING ROUND(AVG(productos.costo), 2) BETWEEN 0 AND 500000
UNION
SELECT servicios.*
FROM servicios
INNER JOIN establecimientosComercio ON servicios.id = establecimientosComercio.id
INNER JOIN menusEstablecimientos ON establecimientosComercio.id = menusEstablecimientos.establecimientoComercio_id
INNER JOIN productos ON menusEstablecimientos.producto_id = productos.id
GROUP BY servicios.id, servicios.nombre, servicios.tipo
HAVING ROUND(AVG(productos.costo), 2) BETWEEN 0 AND 500000
UNION
SELECT servicios.*
FROM servicios
INNER JOIN restaurantes ON servicios.id = restaurantes.id
INNER JOIN menusRestaurantes ON restaurantes.id = menusRestaurantes.restaurante_id
INNER JOIN productos ON menusRestaurantes.producto_id = productos.id
GROUP BY servicios.id, servicios.nombre, servicios.tipo
HAVING ROUND(AVG(productos.costo), 2) BETWEEN 0 AND 500000
UNION
SELECT servicios.*
FROM servicios
INNER JOIN spas ON servicios.id = spas.id
INNER JOIN spasServiciosSpa ON spas.id = spasServiciosSpa.spa_id
INNER JOIN serviciosSpa ON spasServiciosSpa.servicioSpa_id = serviciosSpa.id
GROUP BY servicios.id, servicios.nombre, servicios.tipo
HAVING ROUND(AVG(serviciosSpa.costo), 2) BETWEEN 0 AND 500000;

--DE DOS
--Solo precio y fecha
SELECT servicios.* 
FROM servicios 
INNER JOIN consumos ON servicios.id = consumos.servicio_id
WHERE consumos.fecha BETWEEN TO_DATE('2023-01-01','YYYY-MM-DD') AND TO_DATE('2023-12-31','YYYY-MM-DD')
INTERSECT
(SELECT servicios.*
FROM servicios
INNER JOIN bares ON servicios.id = bares.id
INNER JOIN menusBares ON bares.id = menusBares.bar_id
INNER JOIN productos ON menusBares.producto_id = productos.id
GROUP BY servicios.id, servicios.nombre, servicios.tipo
HAVING ROUND(AVG(productos.costo), 2) BETWEEN 0 AND 500000
UNION
SELECT servicios.*
FROM servicios
INNER JOIN establecimientosComercio ON servicios.id = establecimientosComercio.id
INNER JOIN menusEstablecimientos ON establecimientosComercio.id = menusEstablecimientos.establecimientoComercio_id
INNER JOIN productos ON menusEstablecimientos.producto_id = productos.id
GROUP BY servicios.id, servicios.nombre, servicios.tipo
HAVING ROUND(AVG(productos.costo), 2) BETWEEN 0 AND 500000
UNION
SELECT servicios.*
FROM servicios
INNER JOIN restaurantes ON servicios.id = restaurantes.id
INNER JOIN menusRestaurantes ON restaurantes.id = menusRestaurantes.restaurante_id
INNER JOIN productos ON menusRestaurantes.producto_id = productos.id
GROUP BY servicios.id, servicios.nombre, servicios.tipo
HAVING ROUND(AVG(productos.costo), 2) BETWEEN 0 AND 500000
UNION
SELECT servicios.*
FROM servicios
INNER JOIN spas ON servicios.id = spas.id
INNER JOIN spasServiciosSpa ON spas.id = spasServiciosSpa.spa_id
INNER JOIN serviciosSpa ON spasServiciosSpa.servicioSpa_id = serviciosSpa.id
GROUP BY servicios.id, servicios.nombre, servicios.tipo
HAVING ROUND(AVG(serviciosSpa.costo), 2) BETWEEN 0 AND 500000);

--Solo precio y empleado
SELECT servicios.* 
FROM servicios 
INNER JOIN consumos ON servicios.id = consumos.servicio_id
WHERE consumos.num_documento_empleado = '428'
INTERSECT
(SELECT servicios.*
FROM servicios
INNER JOIN bares ON servicios.id = bares.id
INNER JOIN menusBares ON bares.id = menusBares.bar_id
INNER JOIN productos ON menusBares.producto_id = productos.id
GROUP BY servicios.id, servicios.nombre, servicios.tipo
HAVING ROUND(AVG(productos.costo), 2) BETWEEN 0 AND 500000
UNION
SELECT servicios.*
FROM servicios
INNER JOIN establecimientosComercio ON servicios.id = establecimientosComercio.id
INNER JOIN menusEstablecimientos ON establecimientosComercio.id = menusEstablecimientos.establecimientoComercio_id
INNER JOIN productos ON menusEstablecimientos.producto_id = productos.id
GROUP BY servicios.id, servicios.nombre, servicios.tipo
HAVING ROUND(AVG(productos.costo), 2) BETWEEN 0 AND 500000
UNION
SELECT servicios.*
FROM servicios
INNER JOIN restaurantes ON servicios.id = restaurantes.id
INNER JOIN menusRestaurantes ON restaurantes.id = menusRestaurantes.restaurante_id
INNER JOIN productos ON menusRestaurantes.producto_id = productos.id
GROUP BY servicios.id, servicios.nombre, servicios.tipo
HAVING ROUND(AVG(productos.costo), 2) BETWEEN 0 AND 500000
UNION
SELECT servicios.*
FROM servicios
INNER JOIN spas ON servicios.id = spas.id
INNER JOIN spasServiciosSpa ON spas.id = spasServiciosSpa.spa_id
INNER JOIN serviciosSpa ON spasServiciosSpa.servicioSpa_id = serviciosSpa.id
GROUP BY servicios.id, servicios.nombre, servicios.tipo
HAVING ROUND(AVG(serviciosSpa.costo), 2) BETWEEN 0 AND 500000);

--Solo precio y tipo
SELECT servicios.* 
FROM servicios 
INNER JOIN consumos ON servicios.id = consumos.servicio_id
WHERE servicios.tipo = 'Bar'
INTERSECT
(SELECT servicios.*
FROM servicios
INNER JOIN bares ON servicios.id = bares.id
INNER JOIN menusBares ON bares.id = menusBares.bar_id
INNER JOIN productos ON menusBares.producto_id = productos.id
GROUP BY servicios.id, servicios.nombre, servicios.tipo
HAVING ROUND(AVG(productos.costo), 2) BETWEEN 0 AND 500000
UNION
SELECT servicios.*
FROM servicios
INNER JOIN establecimientosComercio ON servicios.id = establecimientosComercio.id
INNER JOIN menusEstablecimientos ON establecimientosComercio.id = menusEstablecimientos.establecimientoComercio_id
INNER JOIN productos ON menusEstablecimientos.producto_id = productos.id
GROUP BY servicios.id, servicios.nombre, servicios.tipo
HAVING ROUND(AVG(productos.costo), 2) BETWEEN 0 AND 500000
UNION
SELECT servicios.*
FROM servicios
INNER JOIN restaurantes ON servicios.id = restaurantes.id
INNER JOIN menusRestaurantes ON restaurantes.id = menusRestaurantes.restaurante_id
INNER JOIN productos ON menusRestaurantes.producto_id = productos.id
GROUP BY servicios.id, servicios.nombre, servicios.tipo
HAVING ROUND(AVG(productos.costo), 2) BETWEEN 0 AND 500000
UNION
SELECT servicios.*
FROM servicios
INNER JOIN spas ON servicios.id = spas.id
INNER JOIN spasServiciosSpa ON spas.id = spasServiciosSpa.spa_id
INNER JOIN serviciosSpa ON spasServiciosSpa.servicioSpa_id = serviciosSpa.id
GROUP BY servicios.id, servicios.nombre, servicios.tipo
HAVING ROUND(AVG(serviciosSpa.costo), 2) BETWEEN 0 AND 500000);

--DE TRES
--Solo precio, fecha, empleado
SELECT servicios.* 
FROM servicios 
INNER JOIN consumos ON servicios.id = consumos.servicio_id
WHERE consumos.fecha BETWEEN TO_DATE('2023-01-01','YYYY-MM-DD') AND TO_DATE('2023-12-31','YYYY-MM-DD') AND
consumos.num_documento_empleado = '428'
INTERSECT
(SELECT servicios.*
FROM servicios
INNER JOIN bares ON servicios.id = bares.id
INNER JOIN menusBares ON bares.id = menusBares.bar_id
INNER JOIN productos ON menusBares.producto_id = productos.id
GROUP BY servicios.id, servicios.nombre, servicios.tipo
HAVING ROUND(AVG(productos.costo), 2) BETWEEN 0 AND 500000
UNION
SELECT servicios.*
FROM servicios
INNER JOIN establecimientosComercio ON servicios.id = establecimientosComercio.id
INNER JOIN menusEstablecimientos ON establecimientosComercio.id = menusEstablecimientos.establecimientoComercio_id
INNER JOIN productos ON menusEstablecimientos.producto_id = productos.id
GROUP BY servicios.id, servicios.nombre, servicios.tipo
HAVING ROUND(AVG(productos.costo), 2) BETWEEN 0 AND 500000
UNION
SELECT servicios.*
FROM servicios
INNER JOIN restaurantes ON servicios.id = restaurantes.id
INNER JOIN menusRestaurantes ON restaurantes.id = menusRestaurantes.restaurante_id
INNER JOIN productos ON menusRestaurantes.producto_id = productos.id
GROUP BY servicios.id, servicios.nombre, servicios.tipo
HAVING ROUND(AVG(productos.costo), 2) BETWEEN 0 AND 500000
UNION
SELECT servicios.*
FROM servicios
INNER JOIN spas ON servicios.id = spas.id
INNER JOIN spasServiciosSpa ON spas.id = spasServiciosSpa.spa_id
INNER JOIN serviciosSpa ON spasServiciosSpa.servicioSpa_id = serviciosSpa.id
GROUP BY servicios.id, servicios.nombre, servicios.tipo
HAVING ROUND(AVG(serviciosSpa.costo), 2) BETWEEN 0 AND 500000);

--Solo precio, fecha, tipo
SELECT servicios.* 
FROM servicios 
INNER JOIN consumos ON servicios.id = consumos.servicio_id
WHERE servicios.tipo = 'Bar' AND
consumos.fecha BETWEEN TO_DATE('2023-01-01','YYYY-MM-DD') AND TO_DATE('2023-12-31','YYYY-MM-DD')
INTERSECT
(SELECT servicios.*
FROM servicios
INNER JOIN bares ON servicios.id = bares.id
INNER JOIN menusBares ON bares.id = menusBares.bar_id
INNER JOIN productos ON menusBares.producto_id = productos.id
GROUP BY servicios.id, servicios.nombre, servicios.tipo
HAVING ROUND(AVG(productos.costo), 2) BETWEEN 0 AND 500000
UNION
SELECT servicios.*
FROM servicios
INNER JOIN establecimientosComercio ON servicios.id = establecimientosComercio.id
INNER JOIN menusEstablecimientos ON establecimientosComercio.id = menusEstablecimientos.establecimientoComercio_id
INNER JOIN productos ON menusEstablecimientos.producto_id = productos.id
GROUP BY servicios.id, servicios.nombre, servicios.tipo
HAVING ROUND(AVG(productos.costo), 2) BETWEEN 0 AND 500000
UNION
SELECT servicios.*
FROM servicios
INNER JOIN restaurantes ON servicios.id = restaurantes.id
INNER JOIN menusRestaurantes ON restaurantes.id = menusRestaurantes.restaurante_id
INNER JOIN productos ON menusRestaurantes.producto_id = productos.id
GROUP BY servicios.id, servicios.nombre, servicios.tipo
HAVING ROUND(AVG(productos.costo), 2) BETWEEN 0 AND 500000
UNION
SELECT servicios.*
FROM servicios
INNER JOIN spas ON servicios.id = spas.id
INNER JOIN spasServiciosSpa ON spas.id = spasServiciosSpa.spa_id
INNER JOIN serviciosSpa ON spasServiciosSpa.servicioSpa_id = serviciosSpa.id
GROUP BY servicios.id, servicios.nombre, servicios.tipo
HAVING ROUND(AVG(serviciosSpa.costo), 2) BETWEEN 0 AND 500000);

--Solo precio, empleado, tipo
SELECT servicios.* 
FROM servicios 
INNER JOIN consumos ON servicios.id = consumos.servicio_id
WHERE servicios.tipo = 'Bar' AND
consumos.num_documento_empleado = '428'
INTERSECT
(SELECT servicios.*
FROM servicios
INNER JOIN bares ON servicios.id = bares.id
INNER JOIN menusBares ON bares.id = menusBares.bar_id
INNER JOIN productos ON menusBares.producto_id = productos.id
GROUP BY servicios.id, servicios.nombre, servicios.tipo
HAVING ROUND(AVG(productos.costo), 2) BETWEEN 0 AND 500000
UNION
SELECT servicios.*
FROM servicios
INNER JOIN establecimientosComercio ON servicios.id = establecimientosComercio.id
INNER JOIN menusEstablecimientos ON establecimientosComercio.id = menusEstablecimientos.establecimientoComercio_id
INNER JOIN productos ON menusEstablecimientos.producto_id = productos.id
GROUP BY servicios.id, servicios.nombre, servicios.tipo
HAVING ROUND(AVG(productos.costo), 2) BETWEEN 0 AND 500000
UNION
SELECT servicios.*
FROM servicios
INNER JOIN restaurantes ON servicios.id = restaurantes.id
INNER JOIN menusRestaurantes ON restaurantes.id = menusRestaurantes.restaurante_id
INNER JOIN productos ON menusRestaurantes.producto_id = productos.id
GROUP BY servicios.id, servicios.nombre, servicios.tipo
HAVING ROUND(AVG(productos.costo), 2) BETWEEN 0 AND 500000
UNION
SELECT servicios.*
FROM servicios
INNER JOIN spas ON servicios.id = spas.id
INNER JOIN spasServiciosSpa ON spas.id = spasServiciosSpa.spa_id
INNER JOIN serviciosSpa ON spasServiciosSpa.servicioSpa_id = serviciosSpa.id
GROUP BY servicios.id, servicios.nombre, servicios.tipo
HAVING ROUND(AVG(serviciosSpa.costo), 2) BETWEEN 0 AND 500000);

--COMPLETA
SELECT servicios.* 
FROM servicios 
INNER JOIN consumos ON servicios.id = consumos.servicio_id
WHERE (servicios.tipo = 'Bar' AND
consumos.fecha BETWEEN TO_DATE('2023-01-01','YYYY-MM-DD') AND TO_DATE('2023-12-31','YYYY-MM-DD') AND
consumos.num_documento_empleado = '428')
INTERSECT
(SELECT servicios.*
FROM servicios
INNER JOIN bares ON servicios.id = bares.id
INNER JOIN menusBares ON bares.id = menusBares.bar_id
INNER JOIN productos ON menusBares.producto_id = productos.id
GROUP BY servicios.id, servicios.nombre, servicios.tipo
HAVING ROUND(AVG(productos.costo), 2) BETWEEN 0 AND 500000
UNION
SELECT servicios.*
FROM servicios
INNER JOIN establecimientosComercio ON servicios.id = establecimientosComercio.id
INNER JOIN menusEstablecimientos ON establecimientosComercio.id = menusEstablecimientos.establecimientoComercio_id
INNER JOIN productos ON menusEstablecimientos.producto_id = productos.id
GROUP BY servicios.id, servicios.nombre, servicios.tipo
HAVING ROUND(AVG(productos.costo), 2) BETWEEN 0 AND 500000
UNION
SELECT servicios.*
FROM servicios
INNER JOIN restaurantes ON servicios.id = restaurantes.id
INNER JOIN menusRestaurantes ON restaurantes.id = menusRestaurantes.restaurante_id
INNER JOIN productos ON menusRestaurantes.producto_id = productos.id
GROUP BY servicios.id, servicios.nombre, servicios.tipo
HAVING ROUND(AVG(productos.costo), 2) BETWEEN 0 AND 500000
UNION
SELECT servicios.*
FROM servicios
INNER JOIN spas ON servicios.id = spas.id
INNER JOIN spasServiciosSpa ON spas.id = spasServiciosSpa.spa_id
INNER JOIN serviciosSpa ON spasServiciosSpa.servicioSpa_id = serviciosSpa.id
GROUP BY servicios.id, servicios.nombre, servicios.tipo
HAVING ROUND(AVG(serviciosSpa.costo), 2) BETWEEN 0 AND 500000);