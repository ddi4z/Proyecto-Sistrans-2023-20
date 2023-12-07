package uniandes.edu.co.proyecto.repositorios;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Piscina;

public interface PiscinaRepository extends JpaRepository<Piscina, Integer> {
    @Query(value = "SELECT piscinas.*, servicios.nombre FROM piscinas INNER JOIN servicios ON piscinas.id = servicios.id", nativeQuery = true)
    Collection<Piscina> darPiscinas();

    @Query(value = "SELECT piscinas.*, servicios.nombre FROM piscinas INNER JOIN servicios ON piscinas.id = servicios.id WHERE id = :id", nativeQuery = true)
    Piscina darPiscina(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO piscinas VALUES (idServicios.nextval, :capacidad, :profundidad, :horaInicio, :horaFin, :costoAdicional);" +
                    "INSERT INTO servicios VALUES ((SELECT idServicios.CURRVAL FROM DUAL), :nombre)", nativeQuery = true)
    void insertarPiscina(@Param("nombre") String nombre, @Param("capacidad") Integer capacidad, @Param("profundidad") Integer profundidad, @Param("horaInicio") Date horaInicio, @Param("horaFin") Date horaFin, @Param("costoAdicional") Double costoAdicional);

    @Modifying
    @Transactional
    @Query(value = "UPDATE piscinas SET capacidad = :capacidad, profundidad = :profundidad, hora_inicio = :horaInicio, hora_fin = :horaFin, costo_adicional = :costoAdicional WHERE id = :id;" +
                    "UPDATE servicios SET nombre = :nombre WHERE id = :id", nativeQuery = true)
    void actualizarPiscina(@Param("id") Integer id, @Param("nombre") String nombre, @Param("capacidad") Integer capacidad, @Param("profundidad") Integer profundidad, @Param("horaInicio") Date horaInicio, @Param("horaFin") Date horaFin, @Param("costoAdicional") Double costoAdicional);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM piscinas WHERE id = :id;" +
                    "DELETE FROM servicios WHERE id = :id", nativeQuery = true)
    void eliminarPiscina(@Param("id") Integer id);
}
