package uniandes.edu.co.proyecto.repositorios;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;


import uniandes.edu.co.proyecto.modelo.Internet;

import java.util.Collection;

public interface InternetRepository extends MongoRepository<Internet, Integer> {
    @Query("{'tipo' : 'Internet'}")
    Collection<Internet> darInternets();


    @Query("{ 'id' : ?0 }")
    Internet darInternet(Integer id);

   
    @Query("{ 'id' : ?0 }")
    @Update("{$set: {'nombre': ?1,'capacidad': ?2, 'costoDia': ?3}}")
    void actualizarInternet(Integer id, String nombre, int capacidad, double costoDia);


    void deleteById(Integer id);
} 