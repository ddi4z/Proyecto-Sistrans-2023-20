package uniandes.edu.co.proyecto.repositorios;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Internet;

public interface InternetRepository extends JpaRepository<Internet, Integer> {
    @Query(value = "SELECT internets.*, servicios.nombre FROM internets INNER JOIN servicios ON internets.id = servicios.id", nativeQuery = true)
    Collection<Internet> darInternets();

    @Query(value = "SELECT internets.*, servicios.nombre FROM internets INNER JOIN servicios ON internets.id = servicios.id WHERE id = :id", nativeQuery = true)
    Internet darInternet(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO internets VALUES (idServicios.nextval, :capacidad, :costoDia);" +
                    "INSERT INTO servicios VALUES ((SELECT idServicios.CURRVAL FROM DUAL), :nombre)", nativeQuery = true)
    void insertarInternet(@Param("nombre") String nombre, @Param("capacidad") Integer capacidad, @Param("costoDia") Double costoDia);

    @Modifying
    @Transactional
    @Query(value = "UPDATE internets SET capacidad = :capacidad, costo_dia = :costoDia WHERE id = :id;" +
                    "UPDATE servicios SET nombre = :nombre WHERE id = :id", nativeQuery = true)
    void actualizarInternet(@Param("id") Integer id, @Param("nombre") String nombre, @Param("capacidad") Integer capacidad, @Param("costoDia") Double costoDia);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM internets WHERE id = :id;" +
                    "DELETE FROM servicios WHERE id = :id", nativeQuery = true)
    void eliminarInternet(@Param("id") Integer id);
}
