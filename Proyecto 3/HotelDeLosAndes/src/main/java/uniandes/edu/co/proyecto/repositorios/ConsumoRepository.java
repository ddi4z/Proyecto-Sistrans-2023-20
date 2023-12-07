package uniandes.edu.co.proyecto.repositorios;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;

import lombok.Data;
import uniandes.edu.co.proyecto.modelo.Consumo;
import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.Servicio;
import uniandes.edu.co.proyecto.modelo.Usuario;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;


@Repository
public interface ConsumoRepository extends MongoRepository<Consumo, Integer> {

    @Query("{}")
    Collection<Consumo> darConsumos();

    @Query(value = "{ 'id' : ?0 }", fields = "{_id : 0}")
    Consumo darConsumo(Integer id);

    @Query(value = "{}", sort = "{_id : -1}", fields = "{_id : 1}")
    Collection<Consumo> findTop1ByOrderByIdDesc();


    @Query("{ 'id' : ?0 }")
    @Update("{$set: {'fecha': ?1, 'descripcion': ?2, 'costo': ?3, 'pagado': ?4,'habitacion': ?5,'servicio': ?6,'cliente': ?7}}")
    void actualizarConsumo(int id, LocalDateTime fecha, String descripcion, double costo, boolean pagado, int habitacion, int servicio, String cliente);

    void deleteById(Integer id);

    @Aggregation(pipeline = {
            "{$match: {fecha: {$gte: ?0}}}",
            "{$group: {_id: '$habitacion', totalHabitacion: {$sum: '$costo'}}}",
            "{$lookup: {from: 'habitaciones', localField: '_id', foreignField: '_id', as: 'habitacion'}}",
            "{$unwind: '$habitacion'}",
            "{$sort: {id: 1}}",
            "{$project: {_id: 0, habitacion: '$habitacion', recoleccion: {$round: ['$totalHabitacion', 2]}}}",
    })
    Collection<InformeHabitacion> gastoPorHabitacion(Date date);

    @Data
    public class InformeHabitacion {
        private Habitacion habitacion;
        private double recoleccion;
    }

    @Aggregation(pipeline = {
        "{$match: { 'cliente': ?0, 'fecha': { $gte: ?1, $lte: ?2 } }}",
        "{$group: { _id: '$cliente', totalConsumido: { $sum: '$costo' }, consumos: { $push: '$$ROOT' } }}",
        "{$project: {_id: 0, cliente: '$_id', totalConsumido: 1, consumos: 1}}"
    })
    InformeConsumos consumosPorUsuario(String numDocumento, Date fechaInicio, Date fechaFin);

    @Data
    public class InformeConsumos {
        private String cliente;
        private double totalConsumido;
        private Collection<Consumo> consumos;
    }

    @Aggregation(pipeline = {
        "{$match: {fecha: {$gte: ?1, $lte: ?2}}}",
        "{$lookup: {from: 'servicios', localField: 'servicio', foreignField: '_id', as: 'servicio'}}",
        "{$unwind: '$servicio'}",
        "{$match: {'servicio.tipo': ?0}}",
        "{$lookup: {from: 'clientes', localField: 'cliente', foreignField: '_id', as: 'cliente'}}",
        "{$unwind: '$cliente'}",
        "{$project: {'_id': 0, 'cliente': 1, 'fecha': 1, 'servicio': 1, 'pagado': 1}}",
        "{$sort: {?3: 1}}"
    })
    Collection<InformeConsumosServicio> consumosServicio(String tipoServicio, Date fechaInicio, Date fechaFin, String ordenamiento);    

    @Aggregation(pipeline = {
        "{$match: {fecha: {$gte: ?0, $lte: ?1}}}",
        "{$lookup: {from: 'servicios', localField: 'servicio', foreignField: '_id', as: 'servicio'}}",
        "{$unwind: '$servicio'}",
        "{$lookup: {from: 'clientes', localField: 'cliente', foreignField: '_id', as: 'cliente'}}",
        "{$unwind: '$cliente'}",
        "{$project: {'_id': 0, 'cliente': 1, 'fecha': 1, 'servicio': 1, 'pagado': 1}}",
        "{$sort: {?2: 1}}"
    })
    Collection<InformeConsumosServicio> consumosServicios(Date fechaInicio, Date fechaFin, String ordenamiento);    

    @Data
    public class InformeConsumosServicio {
        private Usuario cliente;
        private Date fecha;
        private Servicio servicio;
        private boolean pagado;
    }

}