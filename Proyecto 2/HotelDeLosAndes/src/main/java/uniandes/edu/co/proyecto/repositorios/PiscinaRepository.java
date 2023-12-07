package uniandes.edu.co.proyecto.repositorios;

import java.math.BigInteger;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Piscina;

public interface PiscinaRepository extends JpaRepository<Piscina, Integer> {
    @Query(value = "SELECT piscinas.* FROM piscinas", nativeQuery = true)
    Collection<Piscina> darPiscinas();

    @Query(value = "SELECT piscinas.* FROM piscinas WHERE id = :id", nativeQuery = true)
    Piscina darPiscina(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO piscinas VALUES (:id, :capacidad, :profundidad, TO_DATE(:horaInicio,'HH24:MI'), TO_DATE(:horaFin,'HH24:MI'), :costoAdicional)", nativeQuery = true)
    void insertarPiscina(@Param("id") BigInteger id, @Param("capacidad") Integer capacidad, @Param("profundidad") Integer profundidad, @Param("horaInicio") String horaInicio, @Param("horaFin") String horaFin, @Param("costoAdicional") Double costoAdicional);

    @Modifying
    @Transactional
    @Query(value = "UPDATE piscinas SET capacidad = :capacidad, profundidad = :profundidad, hora_inicio = TO_DATE(:horaInicio,'HH24:MI'), hora_fin = TO_DATE(:horaFin,'HH24:MI'), costo_adicional = :costoAdicional WHERE id = :id", nativeQuery = true)
    void actualizarPiscina(@Param("id") Integer id, @Param("capacidad") Integer capacidad, @Param("profundidad") Integer profundidad, @Param("horaInicio") String horaInicio, @Param("horaFin") String horaFin, @Param("costoAdicional") Double costoAdicional);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM piscinas WHERE id = :id", nativeQuery = true)
    void eliminarPiscina(@Param("id") Integer id);
}
