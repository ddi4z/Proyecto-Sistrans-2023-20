package uniandes.edu.co.proyecto.repositorios;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.proyecto.modelo.SalonConferencia;




import java.util.Collection;

public interface SalonConferenciaRepository extends MongoRepository<SalonConferencia, Integer> {
    @Query("{'tipo' : 'Salon de conferencia'}")
    Collection<SalonConferencia> darSalonesConferencia();


    @Query("{ 'id' : ?0 }")
    SalonConferencia darSalonConferencia(Integer id);


    @Query("{ 'id' : ?0 }")
    @Update("{$set: {'nombre': ?1, 'capacidad': ?2, 'costoHora': ?3}}")
    void actualizarSalonConferencia(Integer id, String nombre, Integer capacidad, Double CostoHora);


    void deleteById(Integer id);
} 