package uniandes.edu.co.proyecto.repositorios;

import java.math.BigInteger;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Internet;

public interface InternetRepository extends JpaRepository<Internet, Integer> {
    @Query(value = "SELECT internets.* FROM internets", nativeQuery = true)
    Collection<Internet> darInternets();

    @Query(value = "SELECT internets.* FROM internets WHERE id = :id", nativeQuery = true)
    Internet darInternet(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO internets VALUES (:id, :capacidad, :costoDia)", nativeQuery = true)
    void insertarInternet(@Param("id") BigInteger id, @Param("capacidad") Integer capacidad, @Param("costoDia") Double costoDia);

    @Modifying
    @Transactional
    @Query(value = "UPDATE internets SET capacidad = :capacidad, costo_dia = :costoDia WHERE id = :id", nativeQuery = true)
    void actualizarInternet(@Param("id") Integer id, @Param("capacidad") Integer capacidad, @Param("costoDia") Double costoDia);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM internets WHERE id = :id", nativeQuery = true)
    void eliminarInternet(@Param("id") Integer id);
}
