package uniandes.edu.co.proyecto.repositorios;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.proyecto.modelo.ServicioLavanderia;




import java.util.Collection;

public interface ServicioLavanderiaRepository extends MongoRepository<ServicioLavanderia, Integer> {
    @Query("{'tipo' : 'Servicio lavanderia'}")
    Collection<ServicioLavanderia> darServiciosLavanderia();


    @Query("{ 'id' : ?0 }")
    ServicioLavanderia darServicioLavanderia(Integer id);



    @Query("{ 'id' : ?0 }")
    @Update("{$set: {'nombre': ?1, 'costo': ?2}}")
    void actualizarServicioLavanderia(Integer id, String nombre, Double costo);


    void deleteById(Integer id);
} 