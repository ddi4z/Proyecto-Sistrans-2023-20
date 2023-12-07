package uniandes.edu.co.proyecto.repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.ElementoDotacion;

public interface ElementoDotacionRepository extends JpaRepository<ElementoDotacion, Integer>{
    @Query(value = "SELECT * FROM elementosDotacion", nativeQuery = true)
    Collection<ElementoDotacion> darElementosDotacion();

    @Query(value = "SELECT * FROM elementosDotacion WHERE id = :id", nativeQuery = true)
    ElementoDotacion darElementoDotacion(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO elementosDotacion VALUES (idElementosDotacion.nextval, :nombre)", nativeQuery = true)
    void insertarElementoDotacion(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE elementosDotacion SET nombre = :nombre WHERE id = :id", nativeQuery = true)
    void actualizarElementoDotacion(@Param("id") Integer id, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM elementosDotacion WHERE id = :id", nativeQuery = true)
    void eliminarElementoDotacion(@Param("id") Integer id);
}
