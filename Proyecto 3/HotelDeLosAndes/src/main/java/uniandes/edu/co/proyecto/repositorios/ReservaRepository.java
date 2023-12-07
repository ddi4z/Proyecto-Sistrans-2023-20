package uniandes.edu.co.proyecto.repositorios;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;

import lombok.Data;
import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.modelo.Usuario;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;


@Repository
public interface ReservaRepository extends MongoRepository<Reserva, Integer> {

    @Query("{}")
    Collection<Reserva> darReservas();

    @Query(value = "{ 'id' : ?0 }", fields = "{_id : 0}")
    Reserva darReserva(Integer id);


    @Query(value = "{}", sort = "{_id : -1}", fields = "{_id : 1}")
    Collection<Reserva> findTop1ByOrderByIdDesc();



    @Query("{ 'id' : ?0 }")
    @Update("{$set: {'fechaEntrada': ?1, 'fechaSalida': ?2, 'noches': ?3, 'numeroPersonas': ?4,'cliente': ?5}}")
    void actualizarReserva(int id, LocalDate fechaEntrada, LocalDate fechaSalida, int noches, int numeroPersonas, String cliente);



    @Query("{ 'id' : ?0 }")
    @Update("{$set: {'checkOut': ?1}}")
    void actualizarReservaCheckOut (int id, LocalDate checkOut);


    @Query("{ 'id' : ?0 }")
    @Update("{$set: {'checkIn': ?1}}")
    void actualizarReservaCheckIn (int id, LocalDate checkIn);
    
    void deleteById(Integer id);

    @Aggregation({

        "{$lookup: {from: 'clientes', localField: 'cliente', foreignField: '_id', as: 'clienteInfo'}}",
        "{$unwind: '$clienteInfo'}",
        "{$group: {_id: '$clienteInfo._id', numReservas: {$sum: 1}}}",
    })
    Collection<Usuario> darExcelentesClientesParte3();

    @Aggregation({
        "{$match: {fechaEntrada: {$gte: ?0}}}",
        "{$unwind: '$habitaciones'}",
        "{$group: {_id: {habitacion: '$habitaciones', fechaEntrada: '$fechaEntrada'}, totalNoches: {$sum: '$noches'}}}",
        "{$lookup: {from: 'habitaciones', localField: '_id.habitacion', foreignField: '_id', as: 'habitacion'}}",
        "{$unwind: '$habitacion'}",
        "{$group: {_id: '$_id.habitacion', habitacion: {$first: '$habitacion'}, indiceOcupacion: {$sum: 1}, diasOcupados: {$sum: 1}}}",
        "{$sort: {'_id': 1}}",
        "{$project: {_id: 0, habitacion: 1, indiceOcupacion: {$round: [{$divide: ['$diasOcupados', 365]}, 3]}, diasOcupados: 1}}",
    })
    Collection<InformeOcupacion> darPorcentajeOcupacion(Date date);

    @Aggregation({
        "{$match:{_id: ?0}}",
        "{$lookup:{from: 'consumos', localField: 'cliente', foreignField: 'cliente', as: 'consumos'}}",
        "{$unwind: '$consumos'}",
        "{$match:{ $expr: {$eq: ['$consumos.pagado', false] }}}",
        "{$group:{ _id: null, total: {$sum: '$consumos.costo'}}}",
        "{$project: {_id: 0, _id:'$total'}}",
    })
    Reserva darCostoConsumosNoPagados(int id);

    @Data
    public class InformeOcupacion {
        private Habitacion habitacion;
        private double indiceOcupacion;
        private int diasOcupados;
    }
}

