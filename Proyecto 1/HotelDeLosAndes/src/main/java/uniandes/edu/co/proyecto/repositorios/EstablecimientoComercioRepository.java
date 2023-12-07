package uniandes.edu.co.proyecto.repositorios;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.EstablecimientoComercio;

public interface EstablecimientoComercioRepository extends JpaRepository<EstablecimientoComercio, Integer> {
    @Query(value = "SELECT establecimientosComercio.*, servicios.nombre FROM establecimientosComercio INNER JOIN servicios ON establecimientosComercio.id = servicios.id", nativeQuery = true)
    Collection<EstablecimientoComercio> darEstablecimientosComercio();

    @Query(value = "SELECT establecimientosComercio.*, servicios.nombre FROM establecimientosComercio INNER JOIN servicios ON establecimientosComercio.id = servicios.id WHERE id = :id", nativeQuery = true)
    EstablecimientoComercio darEstablecimientoComercio(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO establecimientosComercio VALUES (idServicios.nextval, :tipo);" +
                    "INSERT INTO servicios VALUES ((SELECT idServicios.CURRVAL FROM DUAL), :nombre)", nativeQuery = true)
    void insertarEstablecimientoComercio(@Param("nombre") String nombre, @Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE establecimientosComercio SET tipo = :tipo WHERE id = :id;" +
                    "UPDATE servicios SET nombre = :nombre WHERE id = :id", nativeQuery = true)
    void actualizarEstablecimientoComercio(@Param("id") Integer id, @Param("nombre") String nombre, @Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM establecimientosComercio WHERE id = :id;" +
                    "DELETE FROM servicios WHERE id = :id", nativeQuery = true)
    void eliminarEstablecimientoComercio(@Param("id") Integer id);
}
