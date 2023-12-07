package uniandes.edu.co.proyecto.repositorios;
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
    @Query(value = "INSERT INTO reservasSalonReunion VALUES (idReservasSalonReunion.nextval, TO_DATE(:horaInicio,'YYYY-MM-DD HH24:MI'), :duracion, :costo, TO_DATE(:horaFinLimpieza,'YYYY-MM-DD HH24:MI'), :idSalon, :numeroDocumento)", nativeQuery = true)
    void insertarReservaSalonReunion(@Param("horaInicio") String horaInicio, @Param("duracion") Integer duracion, @Param("costo") Double costo, @Param("horaFinLimpieza") String horaFinLimpieza, @Param("idSalon") Integer idSalon,  @Param("numeroDocumento") String numeroDocumento);

    @Modifying
    @Transactional
    @Query(value = "UPDATE reservasSalonReunion SET hora_inicio = TO_DATE(:horaInicio,'YYYY-MM-DD HH24:MI'), duracion = :duracion, costo = :costo, hora_fin_limpieza = TO_DATE(:horaFinLimpieza,'YYYY-MM-DD HH24:MI'), id_salon = :idSalon, numero_documento = :numeroDocumento WHERE id = :id", nativeQuery = true)
    void actualizarReservaSalonReunion(@Param("id") Integer id, @Param("horaInicio") String horaInicio, @Param("duracion") Integer duracion, @Param("costo") Double costo, @Param("horaFinLimpieza") String horaFinLimpieza, @Param("idSalon") Integer idSalon,  @Param("numeroDocumento") String numeroDocumento);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservasSalonReunion WHERE id = :id", nativeQuery = true)
    void eliminarReservaSalonReunion(@Param("id") Integer id);
}

