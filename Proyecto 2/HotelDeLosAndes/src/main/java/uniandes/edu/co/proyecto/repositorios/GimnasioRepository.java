package uniandes.edu.co.proyecto.repositorios;

import java.math.BigInteger;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Gimnasio;

public interface GimnasioRepository extends JpaRepository<Gimnasio, Integer> {
    @Query(value = "SELECT gimnasios.* FROM gimnasios", nativeQuery = true)
    Collection<Gimnasio> darGimnasios();

    @Query(value = "SELECT gimnasios.* FROM gimnasios WHERE id = :id", nativeQuery = true)
    Gimnasio darGimnasio(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO gimnasios VALUES (:id, :capacidad, TO_DATE(:horaInicio,'HH24:MI'), TO_DATE(:horaFin,'HH24:MI'), :costoAdicional)", nativeQuery = true)
    void insertarGimnasio(@Param("id") BigInteger id, @Param("capacidad") Integer capacidad, @Param("horaInicio") String horaInicio, @Param("horaFin") String horaFin, @Param("costoAdicional") Double costoAdicional);

    @Modifying
    @Transactional
    @Query(value = "UPDATE gimnasios SET capacidad = :capacidad, hora_inicio = TO_DATE(:horaInicio,'HH24:MI'), hora_fin = TO_DATE(:horaFin,'HH24:MI'), costo_adicional = :costoAdicional WHERE id = :id", nativeQuery = true)
    void actualizarGimnasio(@Param("id") Integer id, @Param("capacidad") Integer capacidad, @Param("horaInicio") String horaInicio, @Param("horaFin") String horaFin, @Param("costoAdicional") Double costoAdicional);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM gimnasios WHERE id = :id", nativeQuery = true)
    void eliminarGimnasio(@Param("id") Integer id);
}
