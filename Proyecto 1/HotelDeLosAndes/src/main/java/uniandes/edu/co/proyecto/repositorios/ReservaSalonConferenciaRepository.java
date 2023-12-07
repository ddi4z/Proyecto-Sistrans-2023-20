package uniandes.edu.co.proyecto.repositorios;


import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.ReservaSalonConferencia;

public interface ReservaSalonConferenciaRepository extends JpaRepository<ReservaSalonConferencia, Integer>{
    @Query(value = "SELECT *  FROM reservasSalonConferencia", nativeQuery = true)
    Collection<ReservaSalonConferencia> darReservasSalonConferencia();

    @Query(value = "SELECT * FROM reservasSalonConferencia WHERE id = :id", nativeQuery = true)
    ReservaSalonConferencia darReservaSalonConferencia(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reservasSalonConferencia VALUES (idReservasSalonConferencia.nextval, :horaInicio, :duracion, :costo, :horaFinLimpieza, :idSalon)", nativeQuery = true)
    void insertarReservaSalonConferencia(@Param("horaInicio") LocalDateTime horaInicio, @Param("duracion") Integer duracion, @Param("costo") Double costo, @Param("horaFinLimpieza") LocalDateTime horaFinLimpieza, @Param("idSalon") Integer idSalon);

    @Modifying
    @Transactional
    @Query(value = "UPDATE reservasSalonConferencia SET hora_inicio = :horaInicio, duracion = :duracion, costo = :costo, hora_fin_limpieza = :horaFinLimpieza, id_salon = :idSalon WHERE id = :id", nativeQuery = true)
    void actualizarReservaSalonConferencia(@Param("id") Integer id, @Param("horaInicio") LocalDateTime horaInicio, @Param("duracion") Integer duracion, @Param("costo") Double costo, @Param("horaFinLimpieza") LocalDateTime horaFinLimpieza, @Param("idSalon") Integer idSalon);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservasSalonConferencia WHERE id = :id", nativeQuery = true)
    void eliminarReservaSalonConferencia(@Param("id") Integer id);
}


