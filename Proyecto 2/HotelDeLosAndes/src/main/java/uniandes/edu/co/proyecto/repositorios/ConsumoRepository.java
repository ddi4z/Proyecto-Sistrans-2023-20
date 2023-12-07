package uniandes.edu.co.proyecto.repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Consumo;

public interface ConsumoRepository extends JpaRepository<Consumo, Integer>{
    @Query(value = "SELECT * FROM consumos", nativeQuery = true)
    Collection<Consumo> darConsumos();

    @Query(value = "SELECT * FROM consumos WHERE habitacion_id = :habitacionId", nativeQuery = true)
    Collection<Consumo> darConsumosHabitacion(@Param("habitacionId") Integer habitacionId);

    @Query(value = "SELECT * FROM consumos WHERE id = :id", nativeQuery = true)
    Consumo darConsumo(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO consumos VALUES (idConsumos.nextval, TO_DATE(:fecha,'YYYY-MM-DD HH24:MI'), :descripcion, :costo, :pagado, :habitacionId, :servicioId, :numDocumentoCliente, :numDocumentoEmpleado)", nativeQuery = true)
    void insertarConsumo(@Param("fecha") String fecha, @Param("descripcion") String descripcion, @Param("costo") Double costo, @Param("pagado") Integer pagado, @Param("habitacionId") Integer habitacionId, @Param("servicioId") Integer servicioId, @Param("numDocumentoCliente") String numDocumentoCliente, @Param("numDocumentoEmpleado") String numDocumentoEmpleado);

    @Modifying
    @Transactional
    @Query(value = "UPDATE consumos SET fecha = TO_DATE(:fecha,'YYYY-MM-DD HH24:MI'), descripcion = :descripcion,  costo= :costo, pagado = :pagado, habitacion_id = :habitacionId, servicio_id = :servicioId, num_documento_cliente = :numDocumentoCliente, num_documento_empleado = :numDocumentoEmpleado WHERE id = :id", nativeQuery = true)
    void actualizarConsumo(@Param("id") Integer id, @Param("fecha") String fecha, @Param("descripcion") String descripcion, @Param("costo") Double costo, @Param("pagado") Integer pagado, @Param("habitacionId") Integer habitacionId, @Param("servicioId") Integer servicioId, @Param("numDocumentoCliente") String numDocumentoCliente, @Param("numDocumentoEmpleado") String numDocumentoEmpleado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM consumos WHERE id = :id", nativeQuery = true)
    void eliminarConsumo(@Param("id") Integer id);

    //Rf 1 iteracion 2
    @Modifying
    @Transactional
    @Query(value = "SELECT habitaciones.id, habitaciones.tipo, habitaciones.ocupada, sum(costo) FROM habitaciones LEFT JOIN consumos ON consumos.habitacion_id = habitaciones.id WHERE EXTRACT(YEAR FROM fecha) = 2023 OR fecha IS NULL GROUP BY habitaciones.id, habitaciones.tipo, habitaciones.ocupada ORDER BY habitaciones.id", nativeQuery = true)
    Collection<Object[]> gastoPorHabitacion();

    //Rf 2 iteracion 2
    @Modifying
    @Transactional
    @Query(value = "SELECT servicios.id, servicios.nombre, count(servicios.id) as cantidad FROM CONSUMOS RIGHT JOIN servicios ON consumos.SERVICIO_ID = servicios.ID WHERE consumos.fecha BETWEEN TO_DATE(:fechaInicio,'YYYY-MM-DD HH24:MI') AND TO_DATE(:fechaFin,'YYYY-MM-DD HH24:MI') GROUP BY servicios.id, servicios.nombre ORDER BY cantidad DESC FETCH FIRST 20 ROWS ONLY", nativeQuery = true)
    Collection<Object[]> serviciosMasConsumidos(@Param("fechaInicio") String fechaInicio,@Param("fechaFin") String fechaFin);

    //Rf 5 iteracion 2
    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM CONSUMOS WHERE num_documento_cliente = :numDocumento and fecha BETWEEN TO_DATE(:fechaInicio,'YYYY-MM-DD HH24:MI') AND TO_DATE(:fechaFin,'YYYY-MM-DD HH24:MI')", nativeQuery = true)
    Collection<Consumo> consumosPorUsuario(@Param("fechaInicio") String fechaInicio,@Param("fechaFin") String fechaFin, @Param("numDocumento") String numDocumento);

    //Rf 6 iteracion 2
    @Modifying
    @Transactional
    @Query(value = "SELECT TRUNC(fecha), count(*) FROM CONSUMOS group by TRUNC(fecha) order by count(*) DESC FETCH FIRST 20 ROWS ONLY", nativeQuery = true)
    Collection<Object[]> darMayorIngreso();

    //Rf 8 iteracion 2
    @Query(value = "SELECT servicios.id, servicios.nombre, servicios.tipo, ROUND(COUNT(consumos.servicio_id)/TO_CHAR(SYSDATE, 'WW'), 2) FROM consumos RIGHT JOIN servicios ON consumos.servicio_id = servicios.id  GROUP BY servicios.id, servicios.nombre, servicios.tipo  HAVING ROUND(COUNT(consumos.servicio_id)/TO_CHAR(SYSDATE, 'WW'), 2) < 3  ORDER BY ROUND(COUNT(consumos.servicio_id)/TO_CHAR(SYSDATE, 'WW'), 2), servicios.id", nativeQuery = true)
    Collection<Object[]> darBajaDemanda();
    
    //Rf 11 iteracion 2
    @Query(value = "SELECT TO_CHAR(consumos.fecha, 'WW') as semana, COUNT(consumos.servicio_id) AS conteo, consumos.servicio_id, servicios.nombre, servicios.tipo\n" + //
            "FROM consumos\n" + //
            "INNER JOIN servicios ON consumos.servicio_id = servicios.id\n" + //
            "WHERE EXTRACT(YEAR FROM consumos.fecha) = 2023\n" + //
            "GROUP BY TO_CHAR(consumos.fecha, 'WW'), consumos.servicio_id, servicios.nombre, servicios.tipo\n" + //
            "ORDER BY TO_CHAR(consumos.fecha, 'WW'), COUNT(consumos.servicio_id) DESC, consumos.servicio_id", nativeQuery = true)
    Collection<Object[]> darMasConsumidos();

    @Query(value = "SELECT TO_CHAR(consumos.fecha, 'WW') as semana, COUNT(consumos.servicio_id) AS conteo, consumos.servicio_id, servicios.nombre, servicios.tipo\n" + //
            "FROM consumos\n" + //
            "INNER JOIN servicios ON consumos.servicio_id = servicios.id\n" + //
            "WHERE EXTRACT(YEAR FROM consumos.fecha) = 2023\n" + //
            "GROUP BY TO_CHAR(consumos.fecha, 'WW'), consumos.servicio_id, servicios.nombre, servicios.tipo\n" + //
            "ORDER BY TO_CHAR(consumos.fecha, 'WW'), COUNT(consumos.servicio_id), consumos.servicio_id", nativeQuery = true)
    Collection<Object[]> darMenosConsumidos();



}

