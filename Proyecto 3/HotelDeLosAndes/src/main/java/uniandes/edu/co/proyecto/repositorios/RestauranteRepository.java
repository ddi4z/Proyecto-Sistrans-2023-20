package uniandes.edu.co.proyecto.repositorios;


import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;


import uniandes.edu.co.proyecto.modelo.Restaurante;




import java.util.Collection;

public interface RestauranteRepository extends MongoRepository<Restaurante, Integer> {
    @Query("{'tipo' : 'Restaurante'}")
    Collection<Restaurante> darRestaurantes();


    @Query("{ 'id' : ?0 }")
    Restaurante darRestaurante(Integer id);

    @Query("{}")
    Restaurante insertarRestaurante(String nombre, Integer capacidad, Double costoNoche);



    @Query("{ 'id' : ?0 }")
    @Update("{$set: {'nombre': ?1, 'capacidad': ?2, 'estilo': ?3}}")
    void actualizarRestaurante(Integer id, String nombre, Integer capacidad, String estilo);

    @Query("{}")
    @Aggregation(pipeline = {
            "{$group: { _id: '$estilo', count: { $sum: 1 } }}",
            "{$project: { estilo: '$_id', count: 1, _id: 0 }}",
            "{$match: { estilo: { $ne: null } }}"
    })
    Collection<Restaurante> obtenerEstilosDistintos();

    void deleteById(Integer id);
} 