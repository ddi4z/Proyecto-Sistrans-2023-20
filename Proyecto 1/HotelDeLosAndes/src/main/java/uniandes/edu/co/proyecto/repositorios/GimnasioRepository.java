package uniandes.edu.co.proyecto.repositorios;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Gimnasio;

public interface GimnasioRepository extends JpaRepository<Gimnasio, Integer> {
    @Query(value = "SELECT gimnasios.*, servicios.nombre FROM gimnasios INNER JOIN servicios ON gimnasios.id = servicios.id", nativeQuery = true)
    Collection<Gimnasio> darGimnasios();

    @Query(value = "SELECT gimnasios.*, servicios.nombre FROM gimnasios INNER JOIN servicios ON gimnasios.id = servicios.id WHERE id = :id", nativeQuery = true)
    Gimnasio darGimnasio(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO gimnasios VALUES (idServicios.nextval, :capacidad, :horaInicio, :horaFin, :costoAdicional));" +
                    "INSERT INTO servicios VALUES ((SELECT idServicios.CURRVAL FROM DUAL), :nombre)", nativeQuery = true)
    void insertarGimnasio(@Param("nombre") String nombre, @Param("capacidad") Integer capacidad, @Param("horaInicio") Date horaInicio, @Param("horaFin") Date horaFin, @Param("costoAdicional") Double costoAdicional);

    @Modifying
    @Transactional
    @Query(value = "UPDATE gimnasios SET capacidad = :capacidad, hora_inicio = :horaInicio, hora_fin = :horaFin, costo_adicional = :costoAdicional WHERE id = :id;" +
                    "UPDATE servicios SET nombre = :nombre WHERE id = :id", nativeQuery = true)
    void actualizarGimnasio(@Param("id") Integer id, @Param("nombre") String nombre, @Param("capacidad") Integer capacidad, @Param("horaInicio") Date horaInicio, @Param("horaFin") Date horaFin, @Param("costoAdicional") Double costoAdicional);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM gimnasios WHERE id = :id;" +
                    "DELETE FROM servicios WHERE id = :id", nativeQuery = true)
    void eliminarGimnasio(@Param("id") Integer id);
}
