package uniandes.edu.co.proyecto.repositorios;

import java.math.BigInteger;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.SalonConferencia;

public interface SalonConferenciaRepository extends JpaRepository<SalonConferencia, Integer> {
    @Query(value = "SELECT salonesConferencia.*, servicios.nombre FROM salonesConferencia INNER JOIN servicios ON salonesConferencia.id = servicios.id", nativeQuery = true)
    Collection<SalonConferencia> darSalonesConferencia();

    @Query(value = "SELECT salonesConferencia.*, servicios.nombre FROM salonesConferencia INNER JOIN servicios ON salonesConferencia.id = servicios.id WHERE id = :id", nativeQuery = true)
    SalonConferencia darSalonConferencia(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO salonesConferencia VALUES (:id, :capacidad, :costoHora)", nativeQuery = true)
    void insertarSalonConferencia(@Param("id") BigInteger id, @Param("capacidad") Integer capacidad, @Param("costoHora") Double costoHora);

    @Modifying
    @Transactional
    @Query(value = "UPDATE salonesConferencia SET capacidad = :capacidad, costo_hora = :costoHora WHERE id = :id", nativeQuery = true)
    void actualizarSalonConferencia(@Param("id") Integer id, @Param("capacidad") Integer capacidad, @Param("costoHora") Double costoHora);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM salonesConferencia WHERE id = :id", nativeQuery = true)
    void eliminarSalonConferencia(@Param("id") Integer id);
}
