package uniandes.edu.co.proyecto.repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.MaquinaGimnasio;
import uniandes.edu.co.proyecto.modelo.Tienen;

public interface TienenRepository extends JpaRepository<Tienen, Integer>{
    @Query(value = "SELECT maquinasGimnasio.* FROM maquinasGimnasio " +
                    "INNER JOIN tienen ON maquinasGimnasio.id = tienen.maquinagimnasio_id", nativeQuery = true)
    Collection<MaquinaGimnasio> darMaquinasGimnasio();

    @Query(value = "SELECT maquinasGimnasio.* FROM maquinasGimnasio " +
                    "INNER JOIN tienen ON maquinasGimnasio.id = tienen.maquinagimnasio_id" +
                    "WHERE tienen.gimnasio_id = :gimnasioId", nativeQuery = true)
    Collection<MaquinaGimnasio> darMaquinasGimnasioGimnasio(@Param("gimnasioId") Integer gimnasioId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tienen VALUES (:gimnasioId, :maquinaGimnasioId)", nativeQuery = true)
    void insertarTienen(@Param("gimnasioId") Integer gimnasioId, @Param("maquinaGimnasioId") Integer maquinaGimnasioId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tienen SET gimnasio_id = :gimnasioId WHERE maquina_gimnasio_id = :maquinaGimnasioId", nativeQuery = true)
    void actualizarGimnasioTienen(@Param("gimnasioId") Integer gimnasioId, @Param("maquinaGimnasioId") Integer maquinaGimnasioId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tienen SET maquina_gimnasio_id = :maquinaGimnasioId WHERE gimnasio_id = :gimnasioId", nativeQuery = true)
    void actualizarMaquinaGimnasioTienen(@Param("gimnasioId") Integer gimnasioId, @Param("maquinaGimnasioId") Integer maquinaGimnasioId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tienen WHERE gimnasio_id = :gimnasioId", nativeQuery = true)
    void eliminarGimnasioTienen(@Param("gimnasioId") Integer gimnasioId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tienen WHERE maquina_gimnasio_id = :maquinaGimnasioId", nativeQuery = true)
    void eliminarMaquinaGimnasioTienen(@Param("maquinaGimnasioId") Integer maquinaGimnasioId);
}
