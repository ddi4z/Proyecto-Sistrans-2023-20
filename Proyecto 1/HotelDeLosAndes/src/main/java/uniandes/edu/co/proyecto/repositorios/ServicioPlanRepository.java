package uniandes.edu.co.proyecto.repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.PlanConsumo;
import uniandes.edu.co.proyecto.modelo.ServicioPlan;

public interface ServicioPlanRepository extends JpaRepository<ServicioPlan, Integer>{
    @Query(value = "SELECT planesConsumo.* FROM planesConsumo " +
                    "INNER JOIN serviciosPlanes ON planesConsumo.id = serviciosPlanes.planconsumo_id", nativeQuery = true)
    Collection<PlanConsumo> darPlanesServicios();

    @Query(value = "SELECT planesConsumo.* FROM planesConsumo " +
                    "INNER JOIN serviciosPlanes ON planesConsumo.id = serviciosPlanes.planconsumo_id" +
                    "WHERE serviciosPlanes.servicio_id = :servicioId", nativeQuery = true)
    Collection<PlanConsumo> darPlanesServicio(@Param("servicioId") Integer servicioId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO serviciosPlanes VALUES (:servicioId, :planConsumoId)", nativeQuery = true)
    void insertarServicioPlan(@Param("servicioId") Integer servicioId, @Param("planConsumoId") Integer planConsumoId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE serviciosPlanes SET servicio_id = :servicioId WHERE planconsumo_id = :planConsumoId", nativeQuery = true)
    void actualizarServicioServicioPlan(@Param("servicioId") Integer servicioId, @Param("planConsumoId") Integer planConsumoId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE serviciosPlanes SET planconsumo_id = :planConsumoId WHERE servicio_id = :servicioId", nativeQuery = true)
    void actualizarPlanServicioPlan(@Param("servicioId") Integer servicioId, @Param("planConsumoId") Integer planConsumoId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM serviciosPlanes WHERE servicio_id = :servicioId", nativeQuery = true)
    void eliminarServicioServicioPlan(@Param("servicioId") Integer servicioId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM serviciosPlanes WHERE planconsumo_id = :planConsumoId", nativeQuery = true)
    void eliminarPlanServicioPlan(@Param("planConsumoId") Integer planConsumoId);
}

