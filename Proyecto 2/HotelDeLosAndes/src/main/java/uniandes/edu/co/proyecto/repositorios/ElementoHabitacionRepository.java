package uniandes.edu.co.proyecto.repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.ElementoDotacion;
import uniandes.edu.co.proyecto.modelo.ElementoHabitacion;

public interface ElementoHabitacionRepository extends JpaRepository<ElementoHabitacion, Integer>{
    @Query(value = "SELECT elementosDotacion.* FROM elementosDotacion " +
                    "INNER JOIN elementosHabitacion ON elementosDotacion.id = elementosHabitacion.elementodotacion_id", nativeQuery = true)
    Collection<ElementoDotacion> darElementosHabitaciones();

    @Query(value = "SELECT elementosDotacion.* FROM elementosDotacion " +
                    "INNER JOIN elementosHabitacion ON elementosDotacion.id = elementosHabitacion.elementodotacion_id" +
                    "WHERE elementosHabitacion.tipohabitacion_id = :tipoHabitacionId", nativeQuery = true)
    Collection<ElementoDotacion> darElementosHabitacion(@Param("tipoHabitacionId") Integer tipoHabitacionId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO elementosHabitacion VALUES (:tipoHabitacionId, :elementoDotacionId)", nativeQuery = true)
    void insertarElementoHabitacion(@Param("tipoHabitacionId") Integer tipoHabitacionId, @Param("elementoDotacionId") Integer elementoDotacionId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE elementosHabitacion SET tipohabitacion_id = :tipoHabitacionId WHERE elementodotacion_id = :elementoDotacionId", nativeQuery = true)
    void actualizarTipoHabitacionElementoHabitacion(@Param("tipoHabitacionId") Integer tipoHabitacionId, @Param("elementoDotacionId") Integer elementoDotacionId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE elementosHabitacion SET elementodotacion_id = :elementoDotacionId WHERE tipohabitacion_id = :tipoHabitacionId", nativeQuery = true)
    void actualizarElementoDotacionElementoElementoHabitacion(@Param("tipoHabitacionId") Integer tipoHabitacionId, @Param("elementoDotacionId") Integer elementoDotacionId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM elementosHabitacion WHERE tipohabitacion_id = :tipoHabitacionId", nativeQuery = true)
    void eliminarTipoHabitacionElementoHabitacion(@Param("tipoHabitacionId") Integer tipoHabitacionId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM elementosHabitacion WHERE elementodotacion_id = :elementoDotacionId", nativeQuery = true)
    void eliminarElementoDotacionElementoHabitacion(@Param("elementoDotacionId") Integer elementoDotacionId);
}
