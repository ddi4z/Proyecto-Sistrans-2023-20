package uniandes.edu.co.proyecto.repositorios;

import java.math.BigInteger;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Integer>{
    @Query(value = "SELECT * FROM servicios", nativeQuery = true)
    Collection<Servicio> darServicios();

    @Query(value = "SELECT * FROM servicios WHERE id = :id", nativeQuery = true)
    Servicio darServicio(@Param("id") Integer id);

    @Query(value = "SELECT DISTINCT TIPO FROM servicios", nativeQuery = true)
    Collection<String> darTiposServicio();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO servicios VALUES (idServicios.nextval, :nombre, :tipo)", nativeQuery = true)
    void insertarServicio(@Param("nombre") String nombre, @Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE servicios SET nombre = :nombre, tipo = :tipo WHERE id = :id", nativeQuery = true)
    void actualizarServicio(@Param("id") Integer id, @Param("nombre") String nombre, @Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM servicios WHERE id = :id", nativeQuery = true)
    void eliminarServicio(@Param("id") Integer id);

    @Query(value = "SELECT idServicios.CURRVAL FROM DUAL", nativeQuery = true)
    BigInteger darIdServicios();








//AMBOS SERVICIOS
//DE UNA
//Solo fecha
    @Query(value = "SELECT servicios.* \r\n" + //
            "FROM servicios \r\n" + //
            "INNER JOIN consumos ON servicios.id = consumos.servicio_id\r\n" + //
            "WHERE consumos.fecha BETWEEN TO_DATE(:fecha1,'YYYY-MM-DD') AND TO_DATE(:fecha2,'YYYY-MM-DD')\r\n" + //
            "ORDER BY servicios.id", nativeQuery = true)
    Collection<Servicio> darServiciosEntreFechas(@Param("fecha1") String fecha1, @Param("fecha2") String fecha2);



//Solo empleado
    @Query(value = "SELECT servicios.* \r\n" + //
            "FROM servicios \r\n" + //
            "INNER JOIN consumos ON servicios.id = consumos.servicio_id\r\n" + //
            "WHERE consumos.num_documento_empleado = :empleado\r\n" + //
            "ORDER BY servicios.id", nativeQuery = true)
    Collection<Servicio> darServiciosPorEmpleadoId(@Param("empleado") String empleado);


//Solo tipo
    @Query(value = "SELECT servicios.* \r\n" + //
            "FROM servicios \r\n" + //
            "INNER JOIN consumos ON servicios.id = consumos.servicio_id\r\n" + //
            "WHERE servicios.tipo = :tipo\r\n" + //
            "ORDER BY servicios.id", nativeQuery = true)
    Collection<Servicio> darServiciosPorTipo(@Param("tipo") String tipo);



//DE DOS
//Solo fecha y empleado
    @Query(value = "SELECT servicios.* \r\n" + //
            "FROM servicios \r\n" + //
            "INNER JOIN consumos ON servicios.id = consumos.servicio_id\r\n" + //
            "WHERE consumos.fecha BETWEEN TO_DATE(:fecha1,'YYYY-MM-DD') AND TO_DATE(:fecha2,'YYYY-MM-DD') AND\r\n" + //
            "consumos.num_documento_empleado = :empleado\r\n" + //
            "ORDER BY servicios.id", nativeQuery = true)
    Collection<Servicio> darServiciosPorFechaYEmpleado(@Param("fecha1") String fecha1, @Param("fecha2") String fecha2,@Param("empleado") String empleado);
    


//Solo fecha y tipo
    @Query(value = "SELECT servicios.* \r\n" + //
            "FROM servicios \r\n" + //
            "INNER JOIN consumos ON servicios.id = consumos.servicio_id\r\n" + //
            "WHERE servicios.tipo = :tipo AND\r\n" + //
            "consumos.fecha BETWEEN TO_DATE(:fecha1,'YYYY-MM-DD') AND TO_DATE(:fecha2,'YYYY-MM-DD')\r\n" + //
            "ORDER BY servicios.id", nativeQuery = true)
    Collection<Servicio> darServiciosPorFechaYTipo(@Param("fecha1") String fecha1, @Param("fecha2") String fecha2,@Param("tipo") String tipo);



//Solo empleado y tipo

    @Query(value = "SELECT servicios.* \r\n" + //
            "FROM servicios \r\n" + //
            "INNER JOIN consumos ON servicios.id = consumos.servicio_id\r\n" + //
            "WHERE servicios.tipo = :tipo AND\r\n" + //
            "consumos.num_documento_empleado = :empleado\r\n" + //
            "ORDER BY servicios.id", nativeQuery = true)
    Collection<Servicio> darServiciosPorEmpleadoYTipo(@Param("empleado") String empleado,@Param("tipo") String tipo);


//DE TRES
//Solo fecha, empleado, tipo

    @Query(value = "SELECT servicios.* \r\n" + //
            "FROM servicios \r\n" + //
            "INNER JOIN consumos ON servicios.id = consumos.servicio_id\r\n" + //
            "WHERE servicios.tipo = :tipo AND\r\n" + //
            "consumos.fecha BETWEEN TO_DATE(:fecha1,'YYYY-MM-DD') AND TO_DATE(:fecha2,'YYYY-MM-DD') AND\r\n" + //
            "consumos.num_documento_empleado = :empleado\r\n" + //
            "ORDER BY servicios.id", nativeQuery = true)
    Collection<Servicio> darServiciosPorFechaEmpleadoYTipo(@Param("fecha1") String fecha1, @Param("fecha2") String fecha2,@Param("empleado") String empleado,@Param("tipo") String tipo);



//  SERVICIOS SIMPLES
//DE UNA
//Solo precio

    @Query(value = "SELECT servicios.* \r\n" + //
            "FROM servicios\r\n" + //
            "LEFT JOIN piscinas ON servicios.id = piscinas.id\r\n" + //
            "LEFT JOIN gimnasios ON servicios.id = gimnasios.id\r\n" + //
            "LEFT JOIN internets ON servicios.id = internets.id\r\n" + //
            "LEFT JOIN serviciosLavanderia ON servicios.id = serviciosLavanderia.id\r\n" + //
            "LEFT JOIN salonesConferencia ON servicios.id = salonesConferencia.id\r\n" + //
            "LEFT JOIN salonesReunion ON servicios.id = salonesReunion.id\r\n" + //
            "WHERE piscinas.costo_adicional BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "gimnasios.costo_adicional BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "internets.costo_dia BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "serviciosLavanderia.costo BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "salonesConferencia.costo_hora BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "salonesReunion.costo_hora BETWEEN :precio1 AND :precio2\r\n" + //
            "ORDER BY servicios.id", nativeQuery = true)
    Collection<Servicio> darServiciosPorPrecio(@Param("precio1") Integer precio1, @Param("precio2") Integer precio2);


//DE DOS
//Solo precio y fecha

    @Query(value = "SELECT servicios.* \r\n" + //
            "FROM servicios \r\n" + //
            "INNER JOIN consumos ON servicios.id = consumos.servicio_id\r\n" + //
            "WHERE consumos.fecha BETWEEN TO_DATE(:fecha1,'YYYY-MM-DD') AND TO_DATE(:fecha2,'YYYY-MM-DD')\r\n" + //
            "INTERSECT\r\n" + //
            "SELECT servicios.* \r\n" + //
            "FROM servicios\r\n" + //
            "LEFT JOIN piscinas ON servicios.id = piscinas.id\r\n" + //
            "LEFT JOIN gimnasios ON servicios.id = gimnasios.id\r\n" + //
            "LEFT JOIN internets ON servicios.id = internets.id\r\n" + //
            "LEFT JOIN serviciosLavanderia ON servicios.id = serviciosLavanderia.id\r\n" + //
            "LEFT JOIN salonesConferencia ON servicios.id = salonesConferencia.id\r\n" + //
            "LEFT JOIN salonesReunion ON servicios.id = salonesReunion.id\r\n" + //
            "WHERE piscinas.costo_adicional BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "gimnasios.costo_adicional BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "internets.costo_dia BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "serviciosLavanderia.costo BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "salonesConferencia.costo_hora BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "salonesReunion.costo_hora BETWEEN :precio1 AND :precio2", nativeQuery = true)
    Collection<Servicio> darServiciosPorPrecioYFecha(@Param("precio1") Integer precio1, @Param("precio2") Integer precio2,@Param("fecha1") String fecha1, @Param("fecha2") String fecha2);


//Solo precio y empleado

    @Query(value = "SELECT servicios.* \r\n" + //
            "FROM servicios \r\n" + //
            "INNER JOIN consumos ON servicios.id = consumos.servicio_id\r\n" + //
            "WHERE consumos.num_documento_empleado = :empleado\r\n" + //
            "INTERSECT\r\n" + //
            "SELECT servicios.* \r\n" + //
            "FROM servicios\r\n" + //
            "LEFT JOIN piscinas ON servicios.id = piscinas.id\r\n" + //
            "LEFT JOIN gimnasios ON servicios.id = gimnasios.id\r\n" + //
            "LEFT JOIN internets ON servicios.id = internets.id\r\n" + //
            "LEFT JOIN serviciosLavanderia ON servicios.id = serviciosLavanderia.id\r\n" + //
            "LEFT JOIN salonesConferencia ON servicios.id = salonesConferencia.id\r\n" + //
            "LEFT JOIN salonesReunion ON servicios.id = salonesReunion.id\r\n" + //
            "WHERE piscinas.costo_adicional BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "gimnasios.costo_adicional BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "internets.costo_dia BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "serviciosLavanderia.costo BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "salonesConferencia.costo_hora BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "salonesReunion.costo_hora BETWEEN :precio1 AND :precio2\r\n" + //
            "", nativeQuery = true)
    Collection<Servicio> darServiciosPorPrecioYEmpleado(@Param("precio1") Integer precio1, @Param("precio2") Integer precio2,@Param("empleado") String empleado);

//Solo precio y tipo

    @Query(value = "SELECT servicios.* \r\n" + //
            "FROM servicios \r\n" + //
            "INNER JOIN consumos ON servicios.id = consumos.servicio_id\r\n" + //
            "WHERE servicios.tipo = :tipo\r\n" + //
            "INTERSECT\r\n" + //
            "SELECT servicios.* \r\n" + //
            "FROM servicios\r\n" + //
            "LEFT JOIN piscinas ON servicios.id = piscinas.id\r\n" + //
            "LEFT JOIN gimnasios ON servicios.id = gimnasios.id\r\n" + //
            "LEFT JOIN internets ON servicios.id = internets.id\r\n" + //
            "LEFT JOIN serviciosLavanderia ON servicios.id = serviciosLavanderia.id\r\n" + //
            "LEFT JOIN salonesConferencia ON servicios.id = salonesConferencia.id\r\n" + //
            "LEFT JOIN salonesReunion ON servicios.id = salonesReunion.id\r\n" + //
            "WHERE piscinas.costo_adicional BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "gimnasios.costo_adicional BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "internets.costo_dia BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "serviciosLavanderia.costo BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "salonesConferencia.costo_hora BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "salonesReunion.costo_hora BETWEEN :precio1 AND :precio2", nativeQuery = true)
    Collection<Servicio> darServiciosPorPrecioYTipo(@Param("precio1") Integer precio1, @Param("precio2") Integer precio2,@Param("tipo") String tipo);


//DE TRES
//Solo precio, fecha, empleado

    @Query(value = "SELECT servicios.* \r\n" + //
            "FROM servicios \r\n" + //
            "INNER JOIN consumos ON servicios.id = consumos.servicio_id\r\n" + //
            "WHERE consumos.fecha BETWEEN TO_DATE(:fecha1,'YYYY-MM-DD') AND TO_DATE(:fecha2,'YYYY-MM-DD') AND\r\n" + //
            "consumos.num_documento_empleado = :empleado\r\n" + //
            "INTERSECT\r\n" + //
            "SELECT servicios.* \r\n" + //
            "FROM servicios\r\n" + //
            "LEFT JOIN piscinas ON servicios.id = piscinas.id\r\n" + //
            "LEFT JOIN gimnasios ON servicios.id = gimnasios.id\r\n" + //
            "LEFT JOIN internets ON servicios.id = internets.id\r\n" + //
            "LEFT JOIN serviciosLavanderia ON servicios.id = serviciosLavanderia.id\r\n" + //
            "LEFT JOIN salonesConferencia ON servicios.id = salonesConferencia.id\r\n" + //
            "LEFT JOIN salonesReunion ON servicios.id = salonesReunion.id\r\n" + //
            "WHERE piscinas.costo_adicional BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "gimnasios.costo_adicional BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "internets.costo_dia BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "serviciosLavanderia.costo BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "salonesConferencia.costo_hora BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "salonesReunion.costo_hora BETWEEN :precio1 AND :precio2", nativeQuery = true)
    Collection<Servicio> darServiciosPorPrecioFechaYEmpleado(@Param("precio1") Integer precio1, @Param("precio2") Integer precio2,@Param("fecha1") String fecha1, @Param("fecha2") String fecha2, @Param("empleado") String empleado);


//Solo precio, fecha, tipo

    @Query(value = "SELECT servicios.* \r\n" + //
            "FROM servicios \r\n" + //
            "INNER JOIN consumos ON servicios.id = consumos.servicio_id\r\n" + //
            "WHERE servicios.tipo = :tipo AND\r\n" + //
            "consumos.fecha BETWEEN TO_DATE(:fecha1,'YYYY-MM-DD') AND TO_DATE(:fecha2,'YYYY-MM-DD')\r\n" + //
            "INTERSECT\r\n" + //
            "SELECT servicios.* \r\n" + //
            "FROM servicios\r\n" + //
            "LEFT JOIN piscinas ON servicios.id = piscinas.id\r\n" + //
            "LEFT JOIN gimnasios ON servicios.id = gimnasios.id\r\n" + //
            "LEFT JOIN internets ON servicios.id = internets.id\r\n" + //
            "LEFT JOIN serviciosLavanderia ON servicios.id = serviciosLavanderia.id\r\n" + //
            "LEFT JOIN salonesConferencia ON servicios.id = salonesConferencia.id\r\n" + //
            "LEFT JOIN salonesReunion ON servicios.id = salonesReunion.id\r\n" + //
            "WHERE piscinas.costo_adicional BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "gimnasios.costo_adicional BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "internets.costo_dia BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "serviciosLavanderia.costo BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "salonesConferencia.costo_hora BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "salonesReunion.costo_hora BETWEEN :precio1 AND :precio2", nativeQuery = true)
    Collection<Servicio> darServiciosPorPrecioFechaYTipo(@Param("precio1") Integer precio1, @Param("precio2") Integer precio2,@Param("fecha1") String fecha1, @Param("fecha2") String fecha2,@Param("tipo") String tipo);


//Solo precio, empleado, tipo

    @Query(value = "SELECT servicios.* \r\n" + //
            "FROM servicios \r\n" + //
            "INNER JOIN consumos ON servicios.id = consumos.servicio_id\r\n" + //
            "WHERE servicios.tipo = :tipo AND\r\n" + //
            "consumos.num_documento_empleado = :empleado\r\n" + //
            "INTERSECT\r\n" + //
            "SELECT servicios.* \r\n" + //
            "FROM servicios\r\n" + //
            "LEFT JOIN piscinas ON servicios.id = piscinas.id\r\n" + //
            "LEFT JOIN gimnasios ON servicios.id = gimnasios.id\r\n" + //
            "LEFT JOIN internets ON servicios.id = internets.id\r\n" + //
            "LEFT JOIN serviciosLavanderia ON servicios.id = serviciosLavanderia.id\r\n" + //
            "LEFT JOIN salonesConferencia ON servicios.id = salonesConferencia.id\r\n" + //
            "LEFT JOIN salonesReunion ON servicios.id = salonesReunion.id\r\n" + //
            "WHERE piscinas.costo_adicional BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "gimnasios.costo_adicional BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "internets.costo_dia BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "serviciosLavanderia.costo BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "salonesConferencia.costo_hora BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "salonesReunion.costo_hora BETWEEN :precio1 AND :precio2", nativeQuery = true)
    Collection<Servicio> darServiciosPorPrecioEmpleadoYTipo(@Param("precio1") Integer precio1, @Param("precio2") Integer precio2,@Param("empleado") String empleado,@Param("tipo") String tipo);


//COMPLETA

    @Query(value = "SELECT servicios.* \r\n" + //
            "FROM servicios \r\n" + //
            "INNER JOIN consumos ON servicios.id = consumos.servicio_id\r\n" + //
            "WHERE (servicios.tipo = :tipo AND\r\n" + //
            "consumos.fecha BETWEEN TO_DATE(:fecha1,'YYYY-MM-DD') AND TO_DATE(:fecha2,'YYYY-MM-DD') AND\r\n" + //
            "consumos.num_documento_empleado = :empleado)\r\n" + //
            "INTERSECT\r\n" + //
            "SELECT servicios.* \r\n" + //
            "FROM servicios\r\n" + //
            "LEFT JOIN piscinas ON servicios.id = piscinas.id\r\n" + //
            "LEFT JOIN gimnasios ON servicios.id = gimnasios.id\r\n" + //
            "LEFT JOIN internets ON servicios.id = internets.id\r\n" + //
            "LEFT JOIN serviciosLavanderia ON servicios.id = serviciosLavanderia.id\r\n" + //
            "LEFT JOIN salonesConferencia ON servicios.id = salonesConferencia.id\r\n" + //
            "LEFT JOIN salonesReunion ON servicios.id = salonesReunion.id\r\n" + //
            "WHERE piscinas.costo_adicional BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "gimnasios.costo_adicional BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "internets.costo_dia BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "serviciosLavanderia.costo BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "salonesConferencia.costo_hora BETWEEN :precio1 AND :precio2 OR\r\n" + //
            "salonesReunion.costo_hora BETWEEN :precio1 AND :precio2", nativeQuery = true)
    Collection<Servicio> darServiciosConTodo(@Param("fecha1") String fecha1, @Param("fecha2") String fecha2,@Param("precio1") Integer precio1, @Param("precio2") Integer precio2,@Param("empleado") String empleado,@Param("tipo") String tipo);



//  SERVICIOS CON PROMEDIO
//DE UNA
//Solo precio

    @Query(value = "SELECT servicios.*\r\n" + //
            "FROM servicios\r\n" + //
            "INNER JOIN bares ON servicios.id = bares.id\r\n" + //
            "INNER JOIN menusBares ON bares.id = menusBares.bar_id\r\n" + //
            "INNER JOIN productos ON menusBares.producto_id = productos.id\r\n" + //
            "GROUP BY servicios.id, servicios.nombre, servicios.tipo\r\n" + //
            "HAVING ROUND(AVG(productos.costo), 2) BETWEEN :precio1 AND :precio2\r\n" + //
            "UNION\r\n" + //
            "SELECT servicios.*\r\n" + //
            "FROM servicios\r\n" + //
            "INNER JOIN establecimientosComercio ON servicios.id = establecimientosComercio.id\r\n" + //
            "INNER JOIN menusEstablecimientos ON establecimientosComercio.id = menusEstablecimientos.establecimientoComercio_id\r\n" + //
            "INNER JOIN productos ON menusEstablecimientos.producto_id = productos.id\r\n" + //
            "GROUP BY servicios.id, servicios.nombre, servicios.tipo\r\n" + //
            "HAVING ROUND(AVG(productos.costo), 2) BETWEEN :precio1 AND :precio2\r\n" + //
            "UNION\r\n" + //
            "SELECT servicios.*\r\n" + //
            "FROM servicios\r\n" + //
            "INNER JOIN restaurantes ON servicios.id = restaurantes.id\r\n" + //
            "INNER JOIN menusRestaurantes ON restaurantes.id = menusRestaurantes.restaurante_id\r\n" + //
            "INNER JOIN productos ON menusRestaurantes.producto_id = productos.id\r\n" + //
            "GROUP BY servicios.id, servicios.nombre, servicios.tipo\r\n" + //
            "HAVING ROUND(AVG(productos.costo), 2) BETWEEN :precio1 AND :precio2\r\n" + //
            "UNION\r\n" + //
            "SELECT servicios.*\r\n" + //
            "FROM servicios\r\n" + //
            "INNER JOIN spas ON servicios.id = spas.id\r\n" + //
            "INNER JOIN spasServiciosSpa ON spas.id = spasServiciosSpa.spa_id\r\n" + //
            "INNER JOIN serviciosSpa ON spasServiciosSpa.servicioSpa_id = serviciosSpa.id\r\n" + //
            "GROUP BY servicios.id, servicios.nombre, servicios.tipo\r\n" + //
            "HAVING ROUND(AVG(serviciosSpa.costo), 2) BETWEEN :precio1 AND :precio2", nativeQuery = true)
    Collection<Servicio> darServiciosPromedioPorPrecio(@Param("precio1") Integer precio1, @Param("precio2") Integer precio2);


//DE DOS
//Solo precio y fecha

    @Query(value = "SELECT servicios.* \r\n" + //
            "FROM servicios \r\n" + //
            "INNER JOIN consumos ON servicios.id = consumos.servicio_id\r\n" + //
            "WHERE consumos.fecha BETWEEN TO_DATE(:fecha1,'YYYY-MM-DD') AND TO_DATE(:fecha2,'YYYY-MM-DD')\r\n" + //
            "INTERSECT\r\n" + //
            "(SELECT servicios.*\r\n" + //
            "FROM servicios\r\n" + //
            "INNER JOIN bares ON servicios.id = bares.id\r\n" + //
            "INNER JOIN menusBares ON bares.id = menusBares.bar_id\r\n" + //
            "INNER JOIN productos ON menusBares.producto_id = productos.id\r\n" + //
            "GROUP BY servicios.id, servicios.nombre, servicios.tipo\r\n" + //
            "HAVING ROUND(AVG(productos.costo), 2) BETWEEN :precio1 AND :precio2\r\n" + //
            "UNION\r\n" + //
            "SELECT servicios.*\r\n" + //
            "FROM servicios\r\n" + //
            "INNER JOIN establecimientosComercio ON servicios.id = establecimientosComercio.id\r\n" + //
            "INNER JOIN menusEstablecimientos ON establecimientosComercio.id = menusEstablecimientos.establecimientoComercio_id\r\n" + //
            "INNER JOIN productos ON menusEstablecimientos.producto_id = productos.id\r\n" + //
            "GROUP BY servicios.id, servicios.nombre, servicios.tipo\r\n" + //
            "HAVING ROUND(AVG(productos.costo), 2) BETWEEN :precio1 AND :precio2\r\n" + //
            "UNION\r\n" + //
            "SELECT servicios.*\r\n" + //
            "FROM servicios\r\n" + //
            "INNER JOIN restaurantes ON servicios.id = restaurantes.id\r\n" + //
            "INNER JOIN menusRestaurantes ON restaurantes.id = menusRestaurantes.restaurante_id\r\n" + //
            "INNER JOIN productos ON menusRestaurantes.producto_id = productos.id\r\n" + //
            "GROUP BY servicios.id, servicios.nombre, servicios.tipo\r\n" + //
            "HAVING ROUND(AVG(productos.costo), 2) BETWEEN :precio1 AND :precio2\r\n" + //
            "UNION\r\n" + //
            "SELECT servicios.*\r\n" + //
            "FROM servicios\r\n" + //
            "INNER JOIN spas ON servicios.id = spas.id\r\n" + //
            "INNER JOIN spasServiciosSpa ON spas.id = spasServiciosSpa.spa_id\r\n" + //
            "INNER JOIN serviciosSpa ON spasServiciosSpa.servicioSpa_id = serviciosSpa.id\r\n" + //
            "GROUP BY servicios.id, servicios.nombre, servicios.tipo\r\n" + //
            "HAVING ROUND(AVG(serviciosSpa.costo), 2) BETWEEN :precio1 AND :precio2)", nativeQuery = true)
    Collection<Servicio> darServiciosPromedioPorPrecioyFecha(@Param("precio1") Integer precio1, @Param("precio2") Integer precio2,@Param("fecha1") String fecha1, @Param("fecha2") String fecha2);


//Solo precio y empleado

    @Query(value = "SELECT servicios.* \r\n" + //
            "FROM servicios \r\n" + //
            "INNER JOIN consumos ON servicios.id = consumos.servicio_id\r\n" + //
            "WHERE consumos.num_documento_empleado = :empleado\r\n" + //
            "INTERSECT\r\n" + //
            "(SELECT servicios.*\r\n" + //
            "FROM servicios\r\n" + //
            "INNER JOIN bares ON servicios.id = bares.id\r\n" + //
            "INNER JOIN menusBares ON bares.id = menusBares.bar_id\r\n" + //
            "INNER JOIN productos ON menusBares.producto_id = productos.id\r\n" + //
            "GROUP BY servicios.id, servicios.nombre, servicios.tipo\r\n" + //
            "HAVING ROUND(AVG(productos.costo), 2) BETWEEN :precio1 AND :precio2\r\n" + //
            "UNION\r\n" + //
            "SELECT servicios.*\r\n" + //
            "FROM servicios\r\n" + //
            "INNER JOIN establecimientosComercio ON servicios.id = establecimientosComercio.id\r\n" + //
            "INNER JOIN menusEstablecimientos ON establecimientosComercio.id = menusEstablecimientos.establecimientoComercio_id\r\n" + //
            "INNER JOIN productos ON menusEstablecimientos.producto_id = productos.id\r\n" + //
            "GROUP BY servicios.id, servicios.nombre, servicios.tipo\r\n" + //
            "HAVING ROUND(AVG(productos.costo), 2) BETWEEN :precio1 AND :precio2\r\n" + //
            "UNION\r\n" + //
            "SELECT servicios.*\r\n" + //
            "FROM servicios\r\n" + //
            "INNER JOIN restaurantes ON servicios.id = restaurantes.id\r\n" + //
            "INNER JOIN menusRestaurantes ON restaurantes.id = menusRestaurantes.restaurante_id\r\n" + //
            "INNER JOIN productos ON menusRestaurantes.producto_id = productos.id\r\n" + //
            "GROUP BY servicios.id, servicios.nombre, servicios.tipo\r\n" + //
            "HAVING ROUND(AVG(productos.costo), 2) BETWEEN :precio1 AND :precio2\r\n" + //
            "UNION\r\n" + //
            "SELECT servicios.*\r\n" + //
            "FROM servicios\r\n" + //
            "INNER JOIN spas ON servicios.id = spas.id\r\n" + //
            "INNER JOIN spasServiciosSpa ON spas.id = spasServiciosSpa.spa_id\r\n" + //
            "INNER JOIN serviciosSpa ON spasServiciosSpa.servicioSpa_id = serviciosSpa.id\r\n" + //
            "GROUP BY servicios.id, servicios.nombre, servicios.tipo\r\n" + //
            "HAVING ROUND(AVG(serviciosSpa.costo), 2) BETWEEN :precio1 AND :precio2)", nativeQuery = true)
    Collection<Servicio> darServiciosPromedioPorPrecioYEmpleado(@Param("precio1") Integer precio1, @Param("precio2") Integer precio2,@Param("empleado") String empleado);


//Solo precio y tipo

    @Query(value = "SELECT servicios.* \r\n" + //
            "FROM servicios \r\n" + //
            "INNER JOIN consumos ON servicios.id = consumos.servicio_id\r\n" + //
            "WHERE servicios.tipo = :tipo\r\n" + //
            "INTERSECT\r\n" + //
            "(SELECT servicios.*\r\n" + //
            "FROM servicios\r\n" + //
            "INNER JOIN bares ON servicios.id = bares.id\r\n" + //
            "INNER JOIN menusBares ON bares.id = menusBares.bar_id\r\n" + //
            "INNER JOIN productos ON menusBares.producto_id = productos.id\r\n" + //
            "GROUP BY servicios.id, servicios.nombre, servicios.tipo\r\n" + //
            "HAVING ROUND(AVG(productos.costo), 2) BETWEEN :precio1 AND :precio2\r\n" + //
            "UNION\r\n" + //
            "SELECT servicios.*\r\n" + //
            "FROM servicios\r\n" + //
            "INNER JOIN establecimientosComercio ON servicios.id = establecimientosComercio.id\r\n" + //
            "INNER JOIN menusEstablecimientos ON establecimientosComercio.id = menusEstablecimientos.establecimientoComercio_id\r\n" + //
            "INNER JOIN productos ON menusEstablecimientos.producto_id = productos.id\r\n" + //
            "GROUP BY servicios.id, servicios.nombre, servicios.tipo\r\n" + //
            "HAVING ROUND(AVG(productos.costo), 2) BETWEEN :precio1 AND :precio2\r\n" + //
            "UNION\r\n" + //
            "SELECT servicios.*\r\n" + //
            "FROM servicios\r\n" + //
            "INNER JOIN restaurantes ON servicios.id = restaurantes.id\r\n" + //
            "INNER JOIN menusRestaurantes ON restaurantes.id = menusRestaurantes.restaurante_id\r\n" + //
            "INNER JOIN productos ON menusRestaurantes.producto_id = productos.id\r\n" + //
            "GROUP BY servicios.id, servicios.nombre, servicios.tipo\r\n" + //
            "HAVING ROUND(AVG(productos.costo), 2) BETWEEN :precio1 AND :precio2\r\n" + //
            "UNION\r\n" + //
            "SELECT servicios.*\r\n" + //
            "FROM servicios\r\n" + //
            "INNER JOIN spas ON servicios.id = spas.id\r\n" + //
            "INNER JOIN spasServiciosSpa ON spas.id = spasServiciosSpa.spa_id\r\n" + //
            "INNER JOIN serviciosSpa ON spasServiciosSpa.servicioSpa_id = serviciosSpa.id\r\n" + //
            "GROUP BY servicios.id, servicios.nombre, servicios.tipo\r\n" + //
            "HAVING ROUND(AVG(serviciosSpa.costo), 2) BETWEEN :precio1 AND :precio2)", nativeQuery = true)
    Collection<Servicio> darServiciosPromedioPorPrecioYTipo(@Param("precio1") Integer precio1, @Param("precio2") Integer precio2,@Param("tipo") String tipo);


//DE TRES
//Solo precio, fecha, empleado

    @Query(value = "SELECT servicios.* \r\n" + //
            "FROM servicios \r\n" + //
            "INNER JOIN consumos ON servicios.id = consumos.servicio_id\r\n" + //
            "WHERE consumos.fecha BETWEEN TO_DATE(:fecha1,'YYYY-MM-DD') AND TO_DATE(:fecha2,'YYYY-MM-DD') AND\r\n" + //
            "consumos.num_documento_empleado = :empleado\r\n" + //
            "INTERSECT\r\n" + //
            "(SELECT servicios.*\r\n" + //
            "FROM servicios\r\n" + //
            "INNER JOIN bares ON servicios.id = bares.id\r\n" + //
            "INNER JOIN menusBares ON bares.id = menusBares.bar_id\r\n" + //
            "INNER JOIN productos ON menusBares.producto_id = productos.id\r\n" + //
            "GROUP BY servicios.id, servicios.nombre, servicios.tipo\r\n" + //
            "HAVING ROUND(AVG(productos.costo), 2) BETWEEN :precio1 AND :precio2\r\n" + //
            "UNION\r\n" + //
            "SELECT servicios.*\r\n" + //
            "FROM servicios\r\n" + //
            "INNER JOIN establecimientosComercio ON servicios.id = establecimientosComercio.id\r\n" + //
            "INNER JOIN menusEstablecimientos ON establecimientosComercio.id = menusEstablecimientos.establecimientoComercio_id\r\n" + //
            "INNER JOIN productos ON menusEstablecimientos.producto_id = productos.id\r\n" + //
            "GROUP BY servicios.id, servicios.nombre, servicios.tipo\r\n" + //
            "HAVING ROUND(AVG(productos.costo), 2) BETWEEN :precio1 AND :precio2\r\n" + //
            "UNION\r\n" + //
            "SELECT servicios.*\r\n" + //
            "FROM servicios\r\n" + //
            "INNER JOIN restaurantes ON servicios.id = restaurantes.id\r\n" + //
            "INNER JOIN menusRestaurantes ON restaurantes.id = menusRestaurantes.restaurante_id\r\n" + //
            "INNER JOIN productos ON menusRestaurantes.producto_id = productos.id\r\n" + //
            "GROUP BY servicios.id, servicios.nombre, servicios.tipo\r\n" + //
            "HAVING ROUND(AVG(productos.costo), 2) BETWEEN :precio1 AND :precio2\r\n" + //
            "UNION\r\n" + //
            "SELECT servicios.*\r\n" + //
            "FROM servicios\r\n" + //
            "INNER JOIN spas ON servicios.id = spas.id\r\n" + //
            "INNER JOIN spasServiciosSpa ON spas.id = spasServiciosSpa.spa_id\r\n" + //
            "INNER JOIN serviciosSpa ON spasServiciosSpa.servicioSpa_id = serviciosSpa.id\r\n" + //
            "GROUP BY servicios.id, servicios.nombre, servicios.tipo\r\n" + //
            "HAVING ROUND(AVG(serviciosSpa.costo), 2) BETWEEN :precio1 AND :precio2)", nativeQuery = true)
    Collection<Servicio> darServiciosPromedioPorPrecioFechaYEmpleado(@Param("precio1") Integer precio1, @Param("precio2") Integer precio2,@Param("fecha1") String fecha1, @Param("fecha2") String fecha2,@Param("empleado") String empleado);


//Solo precio, fecha, tipo

    @Query(value = "SELECT servicios.* \r\n" + //
            "FROM servicios \r\n" + //
            "INNER JOIN consumos ON servicios.id = consumos.servicio_id\r\n" + //
            "WHERE servicios.tipo = :tipo AND\r\n" + //
            "consumos.fecha BETWEEN TO_DATE(:fecha1,'YYYY-MM-DD') AND TO_DATE(:fecha2,'YYYY-MM-DD')\r\n" + //
            "INTERSECT\r\n" + //
            "(SELECT servicios.*\r\n" + //
            "FROM servicios\r\n" + //
            "INNER JOIN bares ON servicios.id = bares.id\r\n" + //
            "INNER JOIN menusBares ON bares.id = menusBares.bar_id\r\n" + //
            "INNER JOIN productos ON menusBares.producto_id = productos.id\r\n" + //
            "GROUP BY servicios.id, servicios.nombre, servicios.tipo\r\n" + //
            "HAVING ROUND(AVG(productos.costo), 2) BETWEEN :precio1 AND :precio2\r\n" + //
            "UNION\r\n" + //
            "SELECT servicios.*\r\n" + //
            "FROM servicios\r\n" + //
            "INNER JOIN establecimientosComercio ON servicios.id = establecimientosComercio.id\r\n" + //
            "INNER JOIN menusEstablecimientos ON establecimientosComercio.id = menusEstablecimientos.establecimientoComercio_id\r\n" + //
            "INNER JOIN productos ON menusEstablecimientos.producto_id = productos.id\r\n" + //
            "GROUP BY servicios.id, servicios.nombre, servicios.tipo\r\n" + //
            "HAVING ROUND(AVG(productos.costo), 2) BETWEEN :precio1 AND :precio2\r\n" + //
            "UNION\r\n" + //
            "SELECT servicios.*\r\n" + //
            "FROM servicios\r\n" + //
            "INNER JOIN restaurantes ON servicios.id = restaurantes.id\r\n" + //
            "INNER JOIN menusRestaurantes ON restaurantes.id = menusRestaurantes.restaurante_id\r\n" + //
            "INNER JOIN productos ON menusRestaurantes.producto_id = productos.id\r\n" + //
            "GROUP BY servicios.id, servicios.nombre, servicios.tipo\r\n" + //
            "HAVING ROUND(AVG(productos.costo), 2) BETWEEN :precio1 AND :precio2\r\n" + //
            "UNION\r\n" + //
            "SELECT servicios.*\r\n" + //
            "FROM servicios\r\n" + //
            "INNER JOIN spas ON servicios.id = spas.id\r\n" + //
            "INNER JOIN spasServiciosSpa ON spas.id = spasServiciosSpa.spa_id\r\n" + //
            "INNER JOIN serviciosSpa ON spasServiciosSpa.servicioSpa_id = serviciosSpa.id\r\n" + //
            "GROUP BY servicios.id, servicios.nombre, servicios.tipo\r\n" + //
            "HAVING ROUND(AVG(serviciosSpa.costo), 2) BETWEEN :precio1 AND :precio2)\r\n" + //
            "", nativeQuery = true)
    Collection<Servicio> darServiciosPromedioPorPrecioFechaTipo(@Param("precio1") Integer precio1, @Param("precio2") Integer precio2,@Param("fecha1") String fecha1, @Param("fecha2") String fecha2,@Param("tipo") String tipo);

//Solo precio, empleado, tipo
    @Query(value = "SELECT servicios.* \r\n" + //
            "FROM servicios \r\n" + //
            "INNER JOIN consumos ON servicios.id = consumos.servicio_id\r\n" + //
            "WHERE servicios.tipo = :tipo AND\r\n" + //
            "consumos.num_documento_empleado = :empleado\r\n" + //
            "INTERSECT\r\n" + //
            "(SELECT servicios.*\r\n" + //
            "FROM servicios\r\n" + //
            "INNER JOIN bares ON servicios.id = bares.id\r\n" + //
            "INNER JOIN menusBares ON bares.id = menusBares.bar_id\r\n" + //
            "INNER JOIN productos ON menusBares.producto_id = productos.id\r\n" + //
            "GROUP BY servicios.id, servicios.nombre, servicios.tipo\r\n" + //
            "HAVING ROUND(AVG(productos.costo), 2) BETWEEN :precio1 AND :precio2\r\n" + //
            "UNION\r\n" + //
            "SELECT servicios.*\r\n" + //
            "FROM servicios\r\n" + //
            "INNER JOIN establecimientosComercio ON servicios.id = establecimientosComercio.id\r\n" + //
            "INNER JOIN menusEstablecimientos ON establecimientosComercio.id = menusEstablecimientos.establecimientoComercio_id\r\n" + //
            "INNER JOIN productos ON menusEstablecimientos.producto_id = productos.id\r\n" + //
            "GROUP BY servicios.id, servicios.nombre, servicios.tipo\r\n" + //
            "HAVING ROUND(AVG(productos.costo), 2) BETWEEN :precio1 AND :precio2\r\n" + //
            "UNION\r\n" + //
            "SELECT servicios.*\r\n" + //
            "FROM servicios\r\n" + //
            "INNER JOIN restaurantes ON servicios.id = restaurantes.id\r\n" + //
            "INNER JOIN menusRestaurantes ON restaurantes.id = menusRestaurantes.restaurante_id\r\n" + //
            "INNER JOIN productos ON menusRestaurantes.producto_id = productos.id\r\n" + //
            "GROUP BY servicios.id, servicios.nombre, servicios.tipo\r\n" + //
            "HAVING ROUND(AVG(productos.costo), 2) BETWEEN :precio1 AND :precio2\r\n" + //
            "UNION\r\n" + //
            "SELECT servicios.*\r\n" + //
            "FROM servicios\r\n" + //
            "INNER JOIN spas ON servicios.id = spas.id\r\n" + //
            "INNER JOIN spasServiciosSpa ON spas.id = spasServiciosSpa.spa_id\r\n" + //
            "INNER JOIN serviciosSpa ON spasServiciosSpa.servicioSpa_id = serviciosSpa.id\r\n" + //
            "GROUP BY servicios.id, servicios.nombre, servicios.tipo\r\n" + //
            "HAVING ROUND(AVG(serviciosSpa.costo), 2) BETWEEN :precio1 AND :precio2);", nativeQuery = true)
    Collection<Servicio> darServiciosPromedioPorPrecioEmpleadoTipo(@Param("precio1") Integer precio1, @Param("precio2") Integer precio2,@Param("empleado") String empleado,@Param("tipo") String tipo);


//COMPLETA


    @Query(value = "SELECT servicios.* \r\n" + //
            "FROM servicios \r\n" + //
            "INNER JOIN consumos ON servicios.id = consumos.servicio_id\r\n" + //
            "WHERE (servicios.tipo = :tipo AND\r\n" + //
            "consumos.fecha BETWEEN TO_DATE(:fecha1,'YYYY-MM-DD') AND TO_DATE(:fecha2,'YYYY-MM-DD') AND\r\n" + //
            "consumos.num_documento_empleado = :empleado)\r\n" + //
            "INTERSECT\r\n" + //
            "(SELECT servicios.*\r\n" + //
            "FROM servicios\r\n" + //
            "INNER JOIN bares ON servicios.id = bares.id\r\n" + //
            "INNER JOIN menusBares ON bares.id = menusBares.bar_id\r\n" + //
            "INNER JOIN productos ON menusBares.producto_id = productos.id\r\n" + //
            "GROUP BY servicios.id, servicios.nombre, servicios.tipo\r\n" + //
            "HAVING ROUND(AVG(productos.costo), 2) BETWEEN :precio1 AND :precio2\r\n" + //
            "UNION\r\n" + //
            "SELECT servicios.*\r\n" + //
            "FROM servicios\r\n" + //
            "INNER JOIN establecimientosComercio ON servicios.id = establecimientosComercio.id\r\n" + //
            "INNER JOIN menusEstablecimientos ON establecimientosComercio.id = menusEstablecimientos.establecimientoComercio_id\r\n" + //
            "INNER JOIN productos ON menusEstablecimientos.producto_id = productos.id\r\n" + //
            "GROUP BY servicios.id, servicios.nombre, servicios.tipo\r\n" + //
            "HAVING ROUND(AVG(productos.costo), 2) BETWEEN :precio1 AND :precio2\r\n" + //
            "UNION\r\n" + //
            "SELECT servicios.*\r\n" + //
            "FROM servicios\r\n" + //
            "INNER JOIN restaurantes ON servicios.id = restaurantes.id\r\n" + //
            "INNER JOIN menusRestaurantes ON restaurantes.id = menusRestaurantes.restaurante_id\r\n" + //
            "INNER JOIN productos ON menusRestaurantes.producto_id = productos.id\r\n" + //
            "GROUP BY servicios.id, servicios.nombre, servicios.tipo\r\n" + //
            "HAVING ROUND(AVG(productos.costo), 2) BETWEEN :precio1 AND :precio2\r\n" + //
            "UNION\r\n" + //
            "SELECT servicios.*\r\n" + //
            "FROM servicios\r\n" + //
            "INNER JOIN spas ON servicios.id = spas.id\r\n" + //
            "INNER JOIN spasServiciosSpa ON spas.id = spasServiciosSpa.spa_id\r\n" + //
            "INNER JOIN serviciosSpa ON spasServiciosSpa.servicioSpa_id = serviciosSpa.id\r\n" + //
            "GROUP BY servicios.id, servicios.nombre, servicios.tipo\r\n" + //
            "HAVING ROUND(AVG(serviciosSpa.costo), 2) BETWEEN :precio1 AND :precio2)", nativeQuery = true)
    Collection<Servicio> DarServiciosPromedioConTodo(@Param("fecha1") String fecha1, @Param("fecha2") String fecha2,@Param("precio1") Integer precio1, @Param("precio2") Integer precio2,@Param("empleado") String empleado,@Param("tipo") String tipo);


}
