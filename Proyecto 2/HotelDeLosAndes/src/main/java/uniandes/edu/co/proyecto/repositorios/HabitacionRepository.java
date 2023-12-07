package uniandes.edu.co.proyecto.repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Habitacion;

public interface HabitacionRepository extends JpaRepository<Habitacion, Integer>{
    @Query(value = "SELECT * FROM habitaciones", nativeQuery = true)
    Collection<Habitacion> darHabitaciones();

    @Query(value = "SELECT * FROM habitaciones WHERE id = :id", nativeQuery = true)
    Habitacion darHabitacion(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO habitaciones VALUES (idHabitaciones.nextval, 0, :tipo)", nativeQuery = true)
    void insertarHabitacion(@Param("tipo") Integer tipo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE habitaciones SET ocupada = :ocupada, tipo = :tipo WHERE id = :id", nativeQuery = true)
    void actualizarHabitacion(@Param("id") Integer id, @Param("ocupada") Integer ocupada, @Param("tipo") Integer tipo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM habitaciones WHERE id = :id", nativeQuery = true)
    void eliminarHabitacion(@Param("id") Integer id);

    @Query(value = "SELECT habitaciones.id, habitaciones.tipo, SUM(reservas.noches) AS dias_ocupacion, ROUND((SUM(reservas.noches)*100)/365, 2) AS porcentaje_ocupacion FROM habitaciones LEFT JOIN reservasHabitaciones ON habitaciones.id = reservashabitaciones.habitacion_id LEFT JOIN reservas ON reservashabitaciones.reserva_id = reservas.id WHERE reservashabitaciones.habitacion_id IS NULL OR reservas.fecha_salida < (SELECT TO_DATE(TO_CHAR(SYSDATE, 'YYYY') || '-01-01', 'YYYY-MM-DD') + INTERVAL '1' YEAR FROM DUAL) GROUP BY habitaciones.id, habitaciones.tipo ORDER BY habitaciones.id", nativeQuery = true)
    Collection<Object[]> darPorcentajeOcupacion();

    @Query(value = "SELECT fechas.fecha, COUNT(CASE WHEN reservasFechas.reserva_id IS NOT NULL THEN 1 ELSE NULL END) AS habitaciones_ocupadas FROM fechas LEFT JOIN reservasFechas ON fechas.fecha = reservasFechas.fecha LEFT JOIN reservas ON reservasFechas.reserva_id = reservas.id LEFT JOIN reservasHabitaciones ON reservas.id = reservasHabitaciones.reserva_id GROUP BY fechas.fecha ORDER BY habitaciones_ocupadas DESC, fechas.fecha FETCH FIRST 20 ROWS ONLY", nativeQuery = true)
    Collection<Object[]> darMayorOcupacion();

    @Query(value = "SELECT fechas.fecha, COUNT(CASE WHEN reservasFechas.reserva_id IS NOT NULL THEN 1 ELSE NULL END) AS habitaciones_ocupadas FROM fechas LEFT JOIN reservasFechas ON fechas.fecha = reservasFechas.fecha LEFT JOIN reservas ON reservasFechas.reserva_id = reservas.id  LEFT JOIN reservasHabitaciones ON reservas.id = reservasHabitaciones.reserva_id GROUP BY fechas.fecha ORDER BY habitaciones_ocupadas, fechas.fecha FETCH FIRST 20 ROWS ONLY", nativeQuery = true)
    Collection<Object[]> darMenorOcupacion();

    @Query(value = "SELECT TO_CHAR(reservas.fecha_entrada, 'WW') as semana, COUNT(reservasHabitaciones.habitacion_id) AS conteo, reservasHabitaciones.habitacion_id, habitaciones.tipo\n" + //
            "FROM reservas\n" + //
            "INNER JOIN reservasHabitaciones ON reservas.id = reservasHabitaciones.reserva_id\n" + //
            "INNER JOIN habitaciones ON reservasHabitaciones.habitacion_id = habitaciones.id\n" + //
            "WHERE EXTRACT(YEAR FROM reservas.fecha_entrada) = 2023\n" + //
            "GROUP BY TO_CHAR(reservas.fecha_entrada, 'WW'), reservasHabitaciones.habitacion_id, habitaciones.tipo\n" + //
            "ORDER BY TO_CHAR(reservas.fecha_entrada, 'WW'), COUNT(reservasHabitaciones.habitacion_id) DESC, reservasHabitaciones.habitacion_id", nativeQuery = true)
    Object[] darMasSolicitadas();

    @Query(value = "SELECT TO_CHAR(reservas.fecha_entrada, 'WW') as semana, COUNT(reservasHabitaciones.habitacion_id) AS conteo, reservasHabitaciones.habitacion_id, habitaciones.tipo\n" + //
            "FROM reservas\n" + //
            "INNER JOIN reservasHabitaciones ON reservas.id = reservasHabitaciones.reserva_id\n" + //
            "INNER JOIN habitaciones ON reservasHabitaciones.habitacion_id = habitaciones.id\n" + //
            "WHERE EXTRACT(YEAR FROM reservas.fecha_entrada) = 2023\n" + //
            "GROUP BY TO_CHAR(reservas.fecha_entrada, 'WW'), reservasHabitaciones.habitacion_id, habitaciones.tipo\n" + //
            "ORDER BY TO_CHAR(reservas.fecha_entrada, 'WW'), COUNT(reservasHabitaciones.habitacion_id), reservasHabitaciones.habitacion_id", nativeQuery = true)
    Object[] darMenosSolicitadas();
}

