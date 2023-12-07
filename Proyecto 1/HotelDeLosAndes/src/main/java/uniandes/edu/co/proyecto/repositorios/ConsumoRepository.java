package uniandes.edu.co.proyecto.repositorios;

import java.sql.Date;
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
    @Query(value = "INSERT INTO consumos VALUES (idConsumos.nextval, :fecha, :descripcion, :costo, :pagado, :habitacionId, :servicioId)", nativeQuery = true)
    void insertarConsumo(@Param("fecha") Date fecha, @Param("descripcion") String descripcion, @Param("costo") Double costo, @Param("pagado") Integer pagado, @Param("habitacionId") Integer habitacionId, @Param("servicioId") Integer servicioId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE consumos SET fecha = :fecha, descripcion = :descripcion,  costo= :costo, pagado = :pagado, habitacion_id = :habitacionId, servicio_id = :servicioId WHERE id = :id", nativeQuery = true)
    void actualizarConsumo(@Param("id") Integer id, @Param("fecha") Date fecha, @Param("descripcion") String descripcion, @Param("costo") Double costo, @Param("pagado") Integer pagado, @Param("habitacionId") Integer habitacionId, @Param("servicioId") Integer servicioId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM consumos WHERE id = :id", nativeQuery = true)
    void eliminarConsumo(@Param("id") Integer id);
}
