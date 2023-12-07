package uniandes.edu.co.proyecto.repositorios;

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
    @Query(value = "INSERT INTO reservasSalonConferencia VALUES (idReservasSalonConferencia.nextval, TO_DATE(:horaInicio,'YYYY-MM-DD HH24:MI'), :duracion, :costo, TO_DATE(:horaFinLimpieza,'YYYY-MM-DD HH24:MI'), :idSalon, :numeroDocumento)", nativeQuery = true)
    void insertarReservaSalonConferencia(@Param("horaInicio") String horaInicio, @Param("duracion") Integer duracion, @Param("costo") Double costo, @Param("horaFinLimpieza") String horaFinLimpieza, @Param("idSalon") Integer idSalon,  @Param("numeroDocumento") String numeroDocumento);

    @Modifying
    @Transactional
    @Query(value = "UPDATE reservasSalonConferencia SET hora_inicio = TO_DATE(:horaInicio,'YYYY-MM-DD HH24:MI'), duracion = :duracion, costo = :costo, hora_fin_limpieza = TO_DATE(:horaFinLimpieza,'YYYY-MM-DD HH24:MI'), id_salon = :idSalon, numero_documento = :numeroDocumento WHERE id = :id", nativeQuery = true)
    void actualizarReservaSalonConferencia(@Param("id") Integer id, @Param("horaInicio") String horaInicio, @Param("duracion") Integer duracion, @Param("costo") Double costo, @Param("horaFinLimpieza") String horaFinLimpieza, @Param("idSalon") Integer idSalon,  @Param("numeroDocumento") String numeroDocumento);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservasSalonConferencia WHERE id = :id", nativeQuery = true)
    void eliminarReservaSalonConferencia(@Param("id") Integer id);
}


