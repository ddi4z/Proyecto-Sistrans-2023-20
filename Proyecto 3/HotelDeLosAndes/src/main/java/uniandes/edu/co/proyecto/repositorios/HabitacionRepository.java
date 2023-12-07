package uniandes.edu.co.proyecto.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.proyecto.modelo.Habitacion;

import java.util.Collection;

public interface HabitacionRepository extends MongoRepository<Habitacion, Integer> {

    @Query("{}")
    Collection<Habitacion> darHabitaciones();

    @Query("{ 'id' : ?0 }")
    Habitacion darHabitacion(Integer id);

    @Query("{ 'ocupada' : 0, 'tipo' : ?0 }")
    Habitacion insertarHabitacion();

    @Query(value = "{}", sort = "{_id : -1}", fields = "{_id : 1}")
    Collection<Habitacion> findTop1ByOrderByIdDesc();



    void deleteById(Integer id);

    @Query("{ 'id' : ?0 }")
    @Update("{$set: {'ocupada': ?1, 'tipo': ?2}}")
    void actualizarHabitacion(int id, Boolean ocupada , int tipo);
}
