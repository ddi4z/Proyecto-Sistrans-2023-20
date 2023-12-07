package uniandes.edu.co.proyecto.repositorios;


import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.proyecto.modelo.Bar;

import java.util.Collection;

public interface BarRepository extends MongoRepository<Bar, Integer> {
    @Query("{ 'tipo' : 'Bar'}")
    Collection<Bar> darBares();


    @Query("{ 'id' : ?0 }")
    Bar darBar(Integer id);

    @Query("{}")
    Bar insertarBar(String nombre, Integer capacidad, Double costoNoche);

    @Query("{ 'id' : ?0 }")
    @Update("{$set: {'nombre': ?1, 'capacidad': ?2, 'estilo': ?3}}")
    void actualizarBar(Integer id, String nombre, Integer capacidad, String estilo);


    @Query("{}")
    @Aggregation(pipeline = {
            "{$group: { _id: '$estilo', count: { $sum: 1 } }}",
            "{$project: { estilo: '$_id', count: 1, _id: 0 }}",
            "{$match: { estilo: { $ne: null } }}"
    })
    Collection<Bar> obtenerEstilosDistintos();

    void deleteById(Integer id);
} 