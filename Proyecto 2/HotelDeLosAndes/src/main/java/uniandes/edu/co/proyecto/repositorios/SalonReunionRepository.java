package uniandes.edu.co.proyecto.repositorios;

import java.math.BigInteger;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.SalonReunion;

public interface SalonReunionRepository extends JpaRepository<SalonReunion, Integer> {
    @Query(value = "SELECT salonesReunion.*, servicios.nombre FROM salonesReunion INNER JOIN servicios ON salonesReunion.id = servicios.id", nativeQuery = true)
    Collection<SalonReunion> darSalonesReunion();

    @Query(value = "SELECT salonesReunion.*, servicios.nombre FROM salonesReunion INNER JOIN servicios ON salonesReunion.id = servicios.id WHERE id = :id", nativeQuery = true)
    SalonReunion darSalonReunion(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO salonesReunion VALUES (:id, :capacidad, :costoHora, :costoEquipos)", nativeQuery = true)
    void insertarSalonReunion(@Param("id") BigInteger id, @Param("capacidad") Integer capacidad, @Param("costoHora") Double costoHora, @Param("costoEquipos") Double costoEquipos);

    @Modifying
    @Transactional
    @Query(value = "UPDATE salonesReunion SET capacidad = :capacidad, costo_hora = :costoHora, costo_equipos = :costoEquipos WHERE id = :id", nativeQuery = true)
    void actualizarSalonReunion(@Param("id") Integer id, @Param("capacidad") Integer capacidad, @Param("costoHora") Double costoHora, @Param("costoEquipos") Double costoEquipos);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM salonesReunion WHERE id = :id", nativeQuery = true)
    void eliminarSalonReunion(@Param("id") Integer id);
}
