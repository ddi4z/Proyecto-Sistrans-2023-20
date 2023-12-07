package uniandes.edu.co.proyecto.repositorios;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.ServicioLavanderia;

public interface ServicioLavanderiaRepository extends JpaRepository<ServicioLavanderia, Integer> {
    @Query(value = "SELECT serviciosLavanderia.*, servicios.nombre FROM serviciosLavanderia INNER JOIN servicios ON serviciosLavanderia.id = servicios.id", nativeQuery = true)
    Collection<ServicioLavanderia> darServiciosLavanderia();

    @Query(value = "SELECT serviciosLavanderia.*, servicios.nombre FROM serviciosLavanderia INNER JOIN servicios ON serviciosLavanderia.id = servicios.id WHERE id = :id", nativeQuery = true)
    ServicioLavanderia darServicioLavanderia(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO serviciosLavanderia VALUES (idServicios.nextval, :costo);" +
                    "INSERT INTO servicios VALUES ((SELECT idServicios.CURRVAL FROM DUAL), :nombre)", nativeQuery = true)
    void insertarServicioLavanderia(@Param("nombre") String nombre, @Param("costo") Double costo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE serviciosLavanderia SET costo = :costo WHERE id = :id;" +
                    "UPDATE servicios SET nombre = :nombre WHERE id = :id", nativeQuery = true)
    void actualizarServicioLavanderia(@Param("id") Integer id, @Param("nombre") String nombre, @Param("costo") Double costo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM serviciosLavanderia WHERE id = :id;" +
                    "DELETE FROM servicios WHERE id = :id", nativeQuery = true)
    void eliminarServicioLavanderia(@Param("id") Integer id);
}
