package uniandes.edu.co.proyecto.repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.ReservaSpa;

public interface ReservaSpaRepository  extends JpaRepository<ReservaSpa, Integer>{
    @Query(value = "SELECT *  FROM reservasSpa", nativeQuery = true)
    Collection<ReservaSpa> darReservasSpa();

    @Query(value = "SELECT * FROM reservasSpa WHERE id = :id", nativeQuery = true)
    ReservaSpa darReservaSpa(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reservasSpa VALUES (idReservasSpa.nextval, TO_DATE(:horaInicio,'YYYY-MM-DD HH24:MI'), TO_DATE(:horaFin,'YYYY-MM-DD HH24:MI'), :costo, :idSpa, :numeroDocumento)", nativeQuery = true)
    void insertarReservaSpa(@Param("horaInicio") String horaInicio, @Param("horaFin") String horaFin, @Param("costo") Double costo, @Param("idSpa") Integer idSpa,  @Param("numeroDocumento") String numeroDocumento);

    @Modifying
    @Transactional
    @Query(value = "UPDATE reservasSpa SET hora_inicio = TO_DATE(:horaInicio,'YYYY-MM-DD HH24:MI'), hora_fin = TO_DATE(:horaFin,'YYYY-MM-DD HH24:MI'), costo = :costo, id_spa = :idSpa, num_documento = :numeroDocumento WHERE id = :id", nativeQuery = true)
    void actualizarReservaSpa(@Param("id") Integer id, @Param("horaInicio") String horaInicio, @Param("horaFin") String horaFin, @Param("costo") Double costo, @Param("idSpa") Integer idSpa,  @Param("numeroDocumento") String numeroDocumento);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservasSpa WHERE id = :id", nativeQuery = true)
    void eliminarReservaSpa(@Param("id") Integer num_documento);
}

