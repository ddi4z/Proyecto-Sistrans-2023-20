package uniandes.edu.co.proyecto.repositorios;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;


import uniandes.edu.co.proyecto.modelo.TipoHabitacion;


import java.util.Collection;

public interface TipoHabitacionRepository extends MongoRepository<TipoHabitacion, Integer> {
    @Query("{}")
    Collection<TipoHabitacion> darTiposHabitacion();

    @Query("{ 'id' : ?0 }")
    TipoHabitacion darTipoHabitacion(int id);

    @Query(value = "{}", sort = "{_id : -1}", fields = "{_id : 1}")
    Collection<TipoHabitacion> findTop1ByOrderByIdDesc();

    @Query("{ 'id' : ?0 }")
    @Update("{$set: {'nombre': ?1, 'capacidad': ?2, 'costoNoche': ?3}}")
    void actualizarTipoHabitacion(int id, String nombre, int capacidad,  double costoNoche);


    void deleteById(int id);
}