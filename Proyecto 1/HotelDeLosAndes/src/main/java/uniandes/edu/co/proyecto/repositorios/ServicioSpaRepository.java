package uniandes.edu.co.proyecto.repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.ServicioSpa;

public interface ServicioSpaRepository extends JpaRepository<ServicioSpa, Integer>{
    @Query(value = "SELECT * FROM serviciosSpa", nativeQuery = true)
    Collection<ServicioSpa> darServiciosSpa();

    @Query(value = "SELECT * FROM serviciosSpa WHERE id = :id", nativeQuery = true)
    ServicioSpa darServicioSpa(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO serviciosSpa VALUES (idServiciosSpa.nextval, :nombre, :duracion, :costo)", nativeQuery = true)
    void insertarServicioSpa(@Param("nombre") String nombre, @Param("duracion") Integer duracion, @Param("costo") Double costo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE serviciosSpa SET nombre = :nombre, duracion = :duracion, costo = :costo WHERE id = :id", nativeQuery = true)
    void actualizarServicioSpa(@Param("id") Integer id, @Param("nombre") String nombre, @Param("duracion") Integer duracion, @Param("costo") Double costo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM serviciosSpa WHERE id = :id", nativeQuery = true)
    void eliminarServicioSpa(@Param("id") Integer id);
}

