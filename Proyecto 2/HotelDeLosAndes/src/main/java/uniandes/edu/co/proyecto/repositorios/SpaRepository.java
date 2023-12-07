package uniandes.edu.co.proyecto.repositorios;

import java.math.BigInteger;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Spa;

public interface SpaRepository extends JpaRepository<Spa, Integer> {
    @Query(value = "SELECT * FROM spas", nativeQuery = true)
    Collection<Spa> darSpas();

    @Query(value = "SELECT * FROM spas WHERE id = :id", nativeQuery = true)
    Spa darSpa(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO spas VALUES (:id, :capacidad)", nativeQuery = true)
    void insertarSpa(@Param("id") BigInteger id, @Param("capacidad") Integer capacidad);

    @Modifying
    @Transactional
    @Query(value = "UPDATE spas SET capacidad = :capacidad WHERE id = :id", nativeQuery = true)
    void actualizarSpa(@Param("id") Integer id, @Param("capacidad") Integer capacidad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM spas WHERE id = :id", nativeQuery = true)
    void eliminarSpa(@Param("id") Integer id);
}
