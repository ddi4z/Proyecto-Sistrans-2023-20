package uniandes.edu.co.proyecto.repositorios;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TipoHabitacion;


public interface TipoHabitacionRepository extends JpaRepository<TipoHabitacion, Integer>{
    @Query(value = "SELECT * FROM tiposHabitacion", nativeQuery = true)
    Collection<TipoHabitacion> darTiposHabitacion();

    @Query(value = "SELECT * FROM tiposHabitacion WHERE id = :id", nativeQuery = true)
    TipoHabitacion darTipoHabitacion(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tiposHabitacion VALUES (idTiposHabitacion.nextval, :nombre, :capacidad, :costoNoche)", nativeQuery = true)
    void insertarTipoHabitacion(@Param("nombre") String nombre, @Param("capacidad") Integer capacidad, @Param("costoNoche") Double costoNoche);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tiposHabitacion SET nombre = :nombre, capacidad = :capacidad, costo_noche = :costoNoche WHERE id = :id", nativeQuery = true)
    void actualizarTipoHabitacion(@Param("id") Integer id, @Param("nombre") String nombre, @Param("capacidad") Integer capacidad, @Param("costoNoche") Double costoNoche);
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tiposHabitacion WHERE id = :id", nativeQuery = true)
    void eliminarTipoHabitacion(@Param("id") Integer id);
}