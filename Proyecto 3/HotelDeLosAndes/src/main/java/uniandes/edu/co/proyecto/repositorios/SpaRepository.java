package uniandes.edu.co.proyecto.repositorios;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.proyecto.modelo.Spa;




import java.util.Collection;

public interface SpaRepository extends MongoRepository<Spa, Integer> {
    @Query("{'tipo' : 'Spa'}")
    Collection<Spa> darSpas();


    @Query("{ 'id' : ?0 }")
    Spa darSpa(Integer id);

    @Query("{}")
    Spa insertarSpa(String nombre, Integer capacidad, Double costoNoche);


    @Query("{ 'id' : ?0 }")
    @Update("{$set: {'nombre': ?1, 'capacidad': ?2}}")
    void actualizarSpa(int id, String nombre, int capacidad);

    void deleteById(Integer id);
} 