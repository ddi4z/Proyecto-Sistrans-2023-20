package uniandes.edu.co.proyecto.repositorios;
import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.ReservaSalonReunion;
public interface ReservaSalonReunionRepository  extends JpaRepository<ReservaSalonReunion, Integer>{
    @Query(value = "SELECT *  FROM reservasSalonReunion", nativeQuery = true)
    Collection<ReservaSalonReunion> darReservasSalonReunion();

    @Query(value = "SELECT * FROM reservasSalonReunion WHERE id = :id", nativeQuery = true)
    ReservaSalonReunion darReservaSalonReunion(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reservasSalonReunion (idReservasSalonReunion.nextval, horaInicio, duracion, costo, horaFinLimpieza, idSalon) VALUES (:id, :horaInicio, :duracion, :costo, :horaFinLimpieza, :idSalon)", nativeQuery = true)
    void insertarReservaSalonReunion(@Param("horaInicio") LocalDateTime horaInicio, @Param("duracion") Integer duracion, @Param("costo") Double costo, @Param("horaFinLimpieza") LocalDateTime horaFinLimpieza, @Param("idSalon") Integer idSalon);

    @Modifying
    @Transactional
    @Query(value = "UPDATE reservasSalonReunion SET hora_inicio = :horaInicio, duracion = :duracion, costo = :costo, hora_fin_limpieza = :horaFinLimpieza, id_salon = :idSalon WHERE id = :id", nativeQuery = true)
    void actualizarReservaSalonReunion(@Param("id") Integer id, @Param("horaInicio") LocalDateTime horaInicio, @Param("duracion") Integer duracion, @Param("costo") Double costo, @Param("horaFinLimpieza") LocalDateTime horaFinLimpieza, @Param("idSalon") Integer idSalon);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservasSalonReunion WHERE id = :id", nativeQuery = true)
    void eliminarReservaSalonReunion(@Param("id") Integer id);
}

