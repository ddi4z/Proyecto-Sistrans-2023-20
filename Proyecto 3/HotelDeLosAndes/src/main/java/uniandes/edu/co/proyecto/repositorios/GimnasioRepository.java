package uniandes.edu.co.proyecto.repositorios;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.proyecto.modelo.Gimnasio;


import java.util.Collection;

public interface GimnasioRepository extends MongoRepository<Gimnasio, Integer> {
    @Query("{'tipo' : 'Gimnasio'}")
    Collection<Gimnasio> darGimnasios();


    @Query("{ 'id' : ?0 }")
    Gimnasio darGimnasio(Integer id);

    @Query("{}")
    Gimnasio insertarGimnasio(String nombre, Integer capacidad, Double costoNoche);



   
    @Query("{ 'id' : ?0 }")
    @Update("{$set: {'nombre': ?1,'capacidad': ?2, 'horaInicio': ?3, 'horaFin': ?4, 'costoAdicional': ?5}}")
    void actualizarGimnasio(Integer id, String nombre, int capacidad, String horaInicio, String horaFin, double costoAdicional);


    void deleteById(Integer id);
} 