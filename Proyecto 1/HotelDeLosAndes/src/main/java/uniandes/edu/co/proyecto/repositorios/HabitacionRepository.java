package uniandes.edu.co.proyecto.repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Habitacion;

public interface HabitacionRepository extends JpaRepository<Habitacion, Integer>{
    @Query(value = "SELECT * FROM habitaciones", nativeQuery = true)
    Collection<Habitacion> darHabitaciones();

    @Query(value = "SELECT * FROM habitaciones WHERE id = :id", nativeQuery = true)
    Habitacion darHabitacion(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO habitaciones VALUES (idHabitaciones.nextval, :ocupada, :tipo)", nativeQuery = true)
    void insertarHabitacion(@Param("ocupada") Integer ocupada, @Param("tipo") Integer tipo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE habitaciones SET ocupada = :ocupada, tipo = :tipo WHERE id = :id", nativeQuery = true)
    void actualizarHabitacion(@Param("id") Integer id, @Param("ocupada") Integer ocupada, @Param("tipo") Integer tipo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM habitaciones WHERE id = :id", nativeQuery = true)
    void eliminarHabitacion(@Param("id") Integer id);
}

