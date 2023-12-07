package uniandes.edu.co.proyecto.repositorios;

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
    @Query(value = "INSERT INTO salonesReunion VALUES (idServicios.nextval, :capacidad, :costoHora, :costoEquipos);" +
                    "INSERT INTO servicios VALUES ((SELECT idServicios.CURRVAL FROM DUAL), :nombre)", nativeQuery = true)
    void insertarSalonReunion(@Param("nombre") String nombre, @Param("capacidad") Integer capacidad, @Param("costoHora") Double costoHora, @Param("costoEquipos") Double costoEquipos);

    @Modifying
    @Transactional
    @Query(value = "UPDATE salonesReunion SET capacidad = :capacidad, costo_hora = :costoHora, costo_equipos = :costoEquipos WHERE id = :id;" +
                    "UPDATE servicios SET nombre = :nombre WHERE id = :id", nativeQuery = true)
    void actualizarSalonReunion(@Param("id") Integer id, @Param("nombre") String nombre, @Param("capacidad") Integer capacidad, @Param("costoHora") Double costoHora, @Param("costoEquipos") Double costoEquipos);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM salonesReunion WHERE id = :id;" +
                    "DELETE FROM servicios WHERE id = :id", nativeQuery = true)
    void eliminarSalonReunion(@Param("id") Integer id);
}
