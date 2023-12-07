package uniandes.edu.co.proyecto.repositorios;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.ReservaFecha;

public interface ReservaFechaRepository extends JpaRepository<ReservaFecha, LocalDate> {
    @Query(value = "SELECT * FROM reservasFechas", nativeQuery = true)
    Collection<ReservaFecha> darReservasFechas();

    @Query(value = "SELECT * FROM reservasFechas WHERE fecha = TO_DATE(:fecha,'YYYY-MM-DD') AND reserva_id = :reservaId", nativeQuery = true)
    ReservaFecha darReservaFecha(@Param("fecha") String fecha, @Param("reservaId") Integer reservaId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reservasFechas VALUES (TO_DATE(:fecha,'YYYY-MM-DD'), :reservaId)", nativeQuery = true)
    void insertarReservaFecha(@Param("fecha") String fecha, @Param("reservaId") Integer reservaId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservasFechas WHERE fecha = TO_DATE(:fecha,'YYYY-MM-DD') AND reserva_id = :reservaId", nativeQuery = true)
    void eliminarReservaFecha(@Param("fecha") String fecha, @Param("reservaId") Integer reservaId);
}
