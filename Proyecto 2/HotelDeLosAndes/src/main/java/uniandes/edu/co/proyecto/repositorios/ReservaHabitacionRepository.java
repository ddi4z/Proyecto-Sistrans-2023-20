package uniandes.edu.co.proyecto.repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.ReservaHabitacion;

public interface ReservaHabitacionRepository extends JpaRepository<ReservaHabitacion, Integer>{
    @Query(value = "SELECT habitaciones.* FROM habitaciones " +
            "INNER JOIN reservasHabitaciones ON habitaciones.id = reservasHabitaciones.habitacion_id", nativeQuery = true)
    Collection<Habitacion> darReservasHabitaciones();

    @Query(value = "SELECT habitaciones.* FROM habitaciones " +
            "INNER JOIN reservasHabitaciones ON habitaciones.id = reservasHabitaciones.habitacion_id" +
            "WHERE reservasHabitaciones.reserva_id = :reservaId", nativeQuery = true)
    Collection<Habitacion> darReservaHabitaciones(@Param("reservaId") Integer reservaId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reservasHabitaciones VALUES (:reservaId, :habitacionId)", nativeQuery = true)
    void insertarReservaHabitacion(@Param("reservaId") Integer reservaId, @Param("habitacionId") Integer habitacionId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE reservasHabitaciones SET reserva_id = :reservaId WHERE habitacion_id = :habitacionId", nativeQuery = true)
    void actualizarReservaReservaHabitacion(@Param("reservaId") Integer reservaId, @Param("habitacionId") Integer habitacionId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE reservasHabitaciones SET habitacion_id = :habitacionId WHERE reserva_id = :reservaId", nativeQuery = true)
    void actualizarHabitacionReservaHabitacion(@Param("reservaId") Integer reservaId, @Param("habitacionId") Integer habitacionId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservasHabitaciones WHERE reserva_id = :reservaId", nativeQuery = true)
    void eliminarReservaReservaHabitacion(@Param("reservaId") Integer reservaId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservasHabitaciones WHERE habitacion_id = :habitacionId", nativeQuery = true)
    void eliminarHabitacionReservaHabitacion(@Param("habitacionId") Integer habitacionId);
}
