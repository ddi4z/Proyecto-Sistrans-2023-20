package uniandes.edu.co.proyecto.repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.ServicioSpa;
import uniandes.edu.co.proyecto.modelo.ServicioSpaReservaSpa;

public interface ServicioSpaReservaSpaRepository extends JpaRepository<ServicioSpaReservaSpa, Integer>{
    @Query(value = "SELECT serviciosSpa.* FROM serviciosSpa " +
                    "INNER JOIN serviciosSpaReservasSpa ON serviciosSpa.id = serviciosSpaReservasSpa.serviciospa_id", nativeQuery = true)
    Collection<ServicioSpa> darServiciosSpaReservasSpa();

     @Query(value = "SELECT serviciosSpa.* FROM serviciosSpa " +
                    "INNER JOIN spasServiciosSpa ON serviciosSpa.id = spasServiciosSpa.serviciospa_id" +
                    "WHERE spasServiciosSpa.reservaspa_id = :reservaSpaId", nativeQuery = true)
    Collection<ServicioSpa> darServiciosSpaReservaSpa(@Param("reservaSpaId") Integer reservaSpaId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO serviciosSpaReservasSpa VALUES (:reservaSpaId, :servicioSpaId)", nativeQuery = true)
    void insertarServicioSpaReservaSpa(@Param("reservaSpaId") Integer reservaSpaId, @Param("servicioSpaId") Integer servicioSpaId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE serviciosSpaReservasSpa SET reservaspa_id = :reservaSpaId WHERE serviciospa_id = :servicioSpaId", nativeQuery = true)
    void actualizarReservaSpaServicioSpaReservaSpa(@Param("reservaSpaId") Integer reservaSpaId, @Param("servicioSpaId") Integer servicioSpaId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE serviciosSpaReservasSpa SET serviciospa_id = :servicioSpaId WHERE reservaspa_id = :reservaSpaId", nativeQuery = true)
    void actualizarServicioSpaServicioSpaReservaSpa(@Param("reservaSpaId") Integer reservaSpaId, @Param("servicioSpaId") Integer servicioSpaId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM serviciosSpaReservasSpa WHERE reservaspa_id = :reservaSpaId", nativeQuery = true)
    void eliminarReservaSpaServicioSpaReservaSpa(@Param("reservaSpaId") Integer reservaSpaId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM serviciosSpaReservasSpa WHERE serviciospa_id = :servicioSpaId", nativeQuery = true)
    void eliminarServicioSpaServicioSpaReservaSpa(@Param("servicioSpaId") Integer servicioSpaId);
}

