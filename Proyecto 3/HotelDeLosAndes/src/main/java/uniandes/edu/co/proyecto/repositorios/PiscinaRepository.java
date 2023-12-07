package uniandes.edu.co.proyecto.repositorios;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.proyecto.modelo.Piscina;




import java.util.Collection;

public interface PiscinaRepository extends MongoRepository<Piscina, Integer> {
    @Query("{'tipo' : 'Piscina'}")
    Collection<Piscina> darPiscinas();


    @Query("{ 'id' : ?0 }")
    Piscina darPiscina(Integer id);

    @Query("{}")
    Piscina insertarPiscina(String nombre, Integer capacidad, Double costoNoche);

    @Query("{ 'id' : ?0 }")
    @Update("{$set: {'nombre': ?1,'capacidad': ?2, 'profundidad': ?3, 'horaInicio': ?4, 'horaFin': ?5, 'costoAdicional': ?6}}")
    void actualizarPiscina(Integer id, String nombre, Integer capacidad, Integer profundidad, String horaInicio, String horaFin, Double costoAdicional);


    void deleteById(Integer id);
} 