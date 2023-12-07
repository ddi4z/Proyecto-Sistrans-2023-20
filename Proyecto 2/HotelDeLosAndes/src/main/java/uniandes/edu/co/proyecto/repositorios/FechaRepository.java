package uniandes.edu.co.proyecto.repositorios;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Fecha;

public interface FechaRepository extends JpaRepository<Fecha, LocalDate> {
    @Query(value = "SELECT * FROM fechas", nativeQuery = true)
    Collection<Fecha> darFechas();

    @Query(value = "SELECT * FROM fechas WHERE fecha = TO_DATE(:fecha,'YYYY-MM-DD')", nativeQuery = true)
    Fecha darFecha(@Param("fecha") String fecha);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO fechas VALUES (TO_DATE(:fecha,'YYYY-MM-DD'))", nativeQuery = true)
    void insertarFecha(@Param("fecha") String fecha);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM fechas WHERE fecha = TO_DATE(:fecha,'YYYY-MM-DD')", nativeQuery = true)
    void eliminarFecha(@Param("fecha") String fecha);
}
