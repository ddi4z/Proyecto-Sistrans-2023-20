package uniandes.edu.co.proyecto.repositorios;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Integer> {
    @Query(value = "SELECT restaurantes.*, servicios.nombre FROM restaurantes INNER JOIN servicios ON restaurantes.id = servicios.id", nativeQuery = true)
    Collection<Restaurante> darRestaurantes();

    @Query(value = "SELECT restaurantes.*, servicios.nombre FROM restaurantes INNER JOIN servicios ON restaurantes.id = servicios.id WHERE id = :id", nativeQuery = true)
    Restaurante darRestaurante(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO restaurantes VALUES (idServicios.nextval, :capacidad, :estilo);" +
                    "INSERT INTO servicios VALUES ((SELECT idServicios.CURRVAL FROM DUAL), :nombre)", nativeQuery = true)
    void insertarRestaurante(@Param("nombre") String nombre, @Param("capacidad") Integer capacidad, @Param("estilo") String estilo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE restaurantes SET capacidad = :capacidad, estilo = :estilo WHERE id = :id;" +
                    "UPDATE servicios SET nombre = :nombre WHERE id = :id", nativeQuery = true)
    void actualizarRestaurante(@Param("id") Integer id, @Param("nombre") String nombre, @Param("capacidad") Integer capacidad, @Param("estilo") String estilo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM restaurantes WHERE id = :id;" +
                    "DELETE FROM servicios WHERE id = :id", nativeQuery = true)
    void eliminarRestaurante(@Param("id") Integer id);
}
