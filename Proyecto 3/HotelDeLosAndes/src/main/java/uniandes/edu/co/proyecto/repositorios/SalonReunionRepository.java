package uniandes.edu.co.proyecto.repositorios;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.proyecto.modelo.SalonReunion;




import java.util.Collection;

public interface SalonReunionRepository extends MongoRepository<SalonReunion, Integer> {
    @Query("{'tipo': 'Salon de reunion'}")
    Collection<SalonReunion> darSalonesReunion();


    @Query("{ 'id' : ?0 }")
    SalonReunion darSalonReunion(Integer id);




    @Query("{ 'id' : ?0 }")
    @Update("{$set: {'nombre': ?1, 'capacidad': ?2, 'costoHora': ?3, 'costoEquipos': ?4}}")
    void actualizarSalonReunion(Integer id, String nombre, Integer capacidad, Double costoHora, Double costoEquipos);


    void deleteById(Integer id);
} 