package uniandes.edu.co.proyecto.repositorios;

import java.util.Date;
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
    @Query(value = "INSERT INTO reservasSpa VALUES (idReservasSpa.nextval, :horaInicio, :horaFin, :costo, :idSpa)", nativeQuery = true)
    void insertarReservaSpa(@Param("horaInicio") Date horaInicio, @Param("horaFin") Date horaFin, @Param("costo") Double costo, @Param("idSpa") Integer idSpa);

    @Modifying
    @Transactional
    @Query(value = "UPDATE reservasSpa SET hora_inicio = :horaInicio, hora_fin = :horaFin, costo = :costo, id_spa = :idSpa WHERE id = :id", nativeQuery = true)
    void actualizarReservaSpa(@Param("id") Integer id, @Param("horaInicio") Date horaInicio, @Param("horaFin") Date horaFin, @Param("costo") Double costo, @Param("idSpa") Integer idSpa);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservasSpa WHERE id = :id", nativeQuery = true)
    void eliminarReservaSpa(@Param("id") Integer num_documento);
}

