package uniandes.edu.co.proyecto.repositorios;


import java.util.Collection;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;

import uniandes.edu.co.proyecto.modelo.Prestamo;


@Repository
public interface PrestamoRepository extends MongoRepository<Prestamo, Integer> {
    @Query("{}")
    Collection<Prestamo> darPrestamos();

    @Query(value = "{ 'id' : ?0 }", fields = "{_id : 0}")
    Prestamo darPrestamo(Integer id);

    @Query(value = "{}", sort = "{_id : -1}", fields = "{_id : 1}")
    Collection<Prestamo> findTop1ByOrderByIdDesc();

    @Query("{}")
    @Aggregation(pipeline = {
            "{$group: { _id: '$utensilio', count: { $sum: 1 } }}",
            "{$project: { utensilio: '$_id', count: 1, _id: 0 }}"
    })
    Collection<Prestamo> obtenerUtensiliosDistintos();

    @Query("{ 'id' : ?0 }")
    @Update("{$set: {'utensilio': ?1, 'costoPerdida': ?2, 'devuelto': ?3, 'cliente': ?4,'habitacion': ?5}}")
    void actualizarPrestamo(int id, String utensilio, Double costoPerdida, Boolean devuelto, String cliente, int habitacion);

    void deleteById(Integer id);

    
}   

