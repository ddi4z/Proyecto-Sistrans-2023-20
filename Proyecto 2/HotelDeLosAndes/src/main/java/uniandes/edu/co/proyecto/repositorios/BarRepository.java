package uniandes.edu.co.proyecto.repositorios;

import java.math.BigInteger;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Bar;

public interface BarRepository extends JpaRepository<Bar, Integer> {
    @Query(value = "SELECT bares.* FROM bares", nativeQuery = true)
    Collection<Bar> darBares();

    @Query(value = "SELECT bares.* FROM bares WHERE id = :id", nativeQuery = true)
    Bar darBar(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO bares VALUES (:id, :capacidad, :estilo)", nativeQuery = true)
    void insertarBar(@Param("id") BigInteger id, @Param("capacidad") Integer capacidad, @Param("estilo") String estilo);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE bares SET capacidad = :capacidad, estilo = :estilo WHERE id = :id", nativeQuery = true)
    void actualizarBar(@Param("id") Integer id, @Param("capacidad") Integer capacidad, @Param("estilo") String estilo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM bares WHERE id = :id", nativeQuery = true)
    void eliminarBar(@Param("id") Integer id);
}
