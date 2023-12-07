package uniandes.edu.co.proyecto.repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.PlanConsumo;

public interface PlanConsumoRepository extends JpaRepository<PlanConsumo, Integer>{
    @Query(value = "SELECT * FROM planesConsumo", nativeQuery = true)
    Collection<PlanConsumo> darPlanesConsumo();

    @Query(value = "SELECT * FROM planesConsumo WHERE id = :id", nativeQuery = true)
    PlanConsumo darPlanConsumo(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO planesConsumo VALUES (idPlanesConsumo.nextval, TO_DATE(:fechaInicioVigencia,'YYYY-MM-DD'), TO_DATE(:fechaFinVigencia,'YYYY-MM-DD'), :nombre, :descuentoAlojamiento, :descuentoBar, :descuentoRestaurante, :descuentoSpa, :tipo)", nativeQuery = true)
    void insertarPlanConsumo(@Param("fechaInicioVigencia") String fechaInicioVigencia, @Param("fechaFinVigencia") String fechaFinVigencia, @Param("nombre") String nombre, @Param("descuentoAlojamiento") Double descuentoAlojamiento, @Param("descuentoBar") Double descuentoBar, @Param("descuentoRestaurante") Double descuentoRestaurante, @Param("descuentoSpa") Double descuentoSpa, @Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE planesConsumo SET fecha_inicio_vigencia = TO_DATE(:fechaInicioVigencia,'YYYY-MM-DD'), fecha_fin_vigencia = TO_DATE(:fechaFinVigencia,'YYYY-MM-DD'), nombre = :nombre, descuento_alojamiento = :descuentoAlojamiento, descuento_bar = :descuentoBar, descuento_restaurante = :descuentoRestaurante, descuento_spa = :descuentoSpa, tipo = :tipo WHERE id = :id", nativeQuery = true)
    void actualizarPlanConsumo(@Param("id") Integer id, @Param("fechaInicioVigencia") String fechaInicioVigencia, @Param("fechaFinVigencia") String fechaFinVigencia, @Param("nombre") String nombre, @Param("descuentoAlojamiento") Double descuentoAlojamiento, @Param("descuentoBar") Double descuentoBar, @Param("descuentoRestaurante") Double descuentoRestaurante, @Param("descuentoSpa") Double descuentoSpa, @Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM planesConsumo WHERE id = :id", nativeQuery = true)
    void eliminarPlanConsumo(@Param("id") Integer id);
}
