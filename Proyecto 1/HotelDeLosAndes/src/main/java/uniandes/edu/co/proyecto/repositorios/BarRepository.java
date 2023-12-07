package uniandes.edu.co.proyecto.repositorios;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Bar;

public interface BarRepository extends JpaRepository<Bar, Integer> {
    @Query(value = "SELECT bares.*, servicios.nombre FROM bares INNER JOIN servicios ON bares.id = servicios.id", nativeQuery = true)
    Collection<Bar> darBares();

    @Query(value = "SELECT bares.*, servicios.nombre FROM bares INNER JOIN servicios ON bares.id = servicios.id WHERE id = :id", nativeQuery = true)
    Bar darBar(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO bares VALUES (idServicios.nextval, :capacidad, :estilo);" +
                    "INSERT INTO servicios VALUES ((SELECT idServicios.CURRVAL FROM DUAL), :nombre)", nativeQuery = true)
    void insertarBar(@Param("nombre") String nombre, @Param("capacidad") Integer capacidad, @Param("estilo") String estilo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE bares SET capacidad = :capacidad, estilo = :estilo WHERE id = :id;" +
                    "UPDATE servicios SET nombre = :nombre WHERE id = :id", nativeQuery = true)
    void actualizarBar(@Param("id") Integer id, @Param("nombre") String nombre, @Param("capacidad") Integer capacidad, @Param("estilo") String estilo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM bares WHERE id = :id;" +
                    "DELETE FROM servicios WHERE id = :id", nativeQuery = true)
    void eliminarBar(@Param("id") Integer id);
}
