package uniandes.edu.co.proyecto.repositorios;


import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


import uniandes.edu.co.proyecto.modelo.Servicio;



import java.util.Collection;




public interface ServicioRepository extends MongoRepository<Servicio, Integer> {
    @Query("{}")
    Collection<Servicio> darServicios();


    @Query("{ 'id' : ?0 }")
    Servicio darServicio(Integer id);

    @Query("{}")
    Servicio insertarServicio(String nombre, Integer capacidad, Double costoNoche);

    @Query("{}")
    @Aggregation(pipeline = {
            "{$group: { _id: '$tipo', count: { $sum: 1 } }}",
            "{$project: { tipo: '$_id', count: 1, _id: 0 }}"
    })
    Collection<Servicio> obtenerTiposDeServicioDistintos();

    
    @Query(value = "{}", sort = "{_id : -1}", fields = "{_id : 1}")
    Collection<Servicio> findTop1ByOrderByIdDesc();

    @Query("{}")
    void actualizarServicio(Integer id, String nombre, Integer capacidad, Double costoNoche);


    void deleteById(Integer id);
} 