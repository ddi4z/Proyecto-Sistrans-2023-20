package uniandes.edu.co.proyecto.repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.ServicioSpa;
import uniandes.edu.co.proyecto.modelo.SpaServicioSpa;

public interface SpaServicioSpaRepository extends JpaRepository<SpaServicioSpa, Integer>{
    @Query(value = "SELECT serviciosSpa.* FROM serviciosSpa " +
                    "INNER JOIN spasServiciosSpa ON serviciosSpa.id = spasServiciosSpa.serviciospa_id", nativeQuery = true)
    Collection<ServicioSpa> darServiciosSpaSpas();

    @Query(value = "SELECT serviciosSpa.* FROM serviciosSpa " +
                    "INNER JOIN spasServiciosSpa ON serviciosSpa.id = spasServiciosSpa.serviciospa_id" +
                    "WHERE spasServiciosSpa.spa_id = :spaId", nativeQuery = true)
    Collection<ServicioSpa> darServiciosSpaSpa(@Param("spaId") Integer spaId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO spasServiciosSpa VALUES (:spaId, :servicioSpaId)", nativeQuery = true)
    void insertarSpaServicioSpa(@Param("spaId") Integer spaId, @Param("servicioSpaId") Integer servicioSpaId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE spasServiciosSpa SET spa_id = :spaId WHERE serviciospa_id = :servicioSpaId", nativeQuery = true)
    void actualizarSpaSpaServicioSpa(@Param("spaId") Integer spaId, @Param("servicioSpaId") Integer servicioSpaId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE spasServiciosSpa SET serviciospa_id = :servicioSpaId WHERE spa_id = :spaId", nativeQuery = true)
    void actualizarServicioSpaSpaServicioSpa(@Param("spaId") Integer spaId, @Param("servicioSpaId") Integer servicioSpaId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM spasServiciosSpa WHERE spa_id = :spaId", nativeQuery = true)
    void eliminarSpaSpaServicioSpa(@Param("spaId") Integer spaId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM spasServiciosSpa WHERE serviciospa_id = :servicioSpaId", nativeQuery = true)
    void eliminarServicioSpaSpaServicioSpa(@Param("servicioSpaId") Integer servicioSpaId);
}

