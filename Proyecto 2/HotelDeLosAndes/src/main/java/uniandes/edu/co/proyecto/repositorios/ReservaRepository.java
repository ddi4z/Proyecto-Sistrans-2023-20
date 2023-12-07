package uniandes.edu.co.proyecto.repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Reserva;


public interface ReservaRepository extends JpaRepository<Reserva, Integer>{
    @Query(value = "SELECT * FROM reservas", nativeQuery = true)
    Collection<Reserva> darReservas();

    @Query(value = "SELECT * FROM reservas WHERE id = :id", nativeQuery = true)
    Reserva darReserva(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reservas VALUES (idReservas.nextval, TO_DATE(:fechaEntrada,'YYYY-MM-DD'), TO_DATE(:fechaSalida,'YYYY-MM-DD'), :noches, :numeroPersonas, 0, 0, :planConsumoId, :numDocumento)", nativeQuery = true)
    void insertarReserva(@Param("fechaEntrada") String fechaEntrada, @Param("fechaSalida") String fechaSalida, @Param("noches") Integer noches, @Param("numeroPersonas") Integer numeroPersonas, @Param("planConsumoId") Integer planConsumoId, @Param("numDocumento") String numDocumento);

    @Modifying
    @Transactional
    @Query(value = "UPDATE reservas SET fecha_entrada = TO_DATE(:fechaEntrada,'YYYY-MM-DD'), fecha_salida = TO_DATE(:fechaSalida,'YYYY-MM-DD'), noches = :noches, numero_personas = :numeroPersonas, check_in = :checkIn, check_out = :checkOut, plan_consumo_id = :planConsumoId, num_documento = :numDocumento WHERE id = :id", nativeQuery = true)
    void actualizarReserva(@Param("id") Integer id, @Param("fechaEntrada") String fechaEntrada, @Param("fechaSalida") String fechaSalida, @Param("noches") Integer noches, @Param("numeroPersonas") Integer numeroPersonas, @Param("checkIn") Integer checkIn, @Param("checkOut") Integer checkOut, @Param("planConsumoId") Integer planConsumoId, @Param("numDocumento") String numDocumento);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservas WHERE id = :id", nativeQuery = true)
    void eliminarReserva(@Param("id") Integer id);

}
