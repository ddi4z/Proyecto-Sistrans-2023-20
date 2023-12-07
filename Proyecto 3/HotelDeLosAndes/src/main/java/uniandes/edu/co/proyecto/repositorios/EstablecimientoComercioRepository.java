package uniandes.edu.co.proyecto.repositorios;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.proyecto.modelo.EstablecimientoComercio;




import java.util.Collection;

public interface EstablecimientoComercioRepository extends MongoRepository<EstablecimientoComercio, Integer> {
    @Query("{'tipo' : 'Establecimiento de comercio'}")
    Collection<EstablecimientoComercio> darEstablecimientosComercio();


    @Query("{ 'id' : ?0 }")
    EstablecimientoComercio darEstablecimientoComercio(Integer id);

    @Query("{}")
    EstablecimientoComercio insertarEstablecimientoComercio(String nombre, Integer capacidad, Double costoNoche);


    @Query("{ 'id' : ?0 }")
    @Update("{$set: {'nombre': ?1,'tipoEstablecimiento': ?2}}")
    void actualizarEstablecimientoComercio(Integer id, String nombre, String tipoEstablecimiento);


    void deleteById(Integer id);
} 