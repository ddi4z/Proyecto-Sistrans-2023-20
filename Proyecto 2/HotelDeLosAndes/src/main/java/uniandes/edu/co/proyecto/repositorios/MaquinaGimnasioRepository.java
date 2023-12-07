package uniandes.edu.co.proyecto.repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.MaquinaGimnasio;

public interface MaquinaGimnasioRepository extends JpaRepository<MaquinaGimnasio, Integer>{
    @Query(value = "SELECT * FROM maquinasGimnasio", nativeQuery = true)
    Collection<MaquinaGimnasio> darMaquinasGimnasio();

    @Query(value = "SELECT * FROM maquinasGimnasio WHERE id = :id", nativeQuery = true)
    MaquinaGimnasio darMaquinaGimnasio(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO maquinasGimnasio VALUES (idMaquinasGimnasio.nextval, :nombre)", nativeQuery = true)
    void insertarMaquinaGimnasio(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE maquinasGimnasio SET nombre = :nombre WHERE id = :id", nativeQuery = true)
    void actualizarMaquinaGimnasio(@Param("id") Integer id, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM maquinasGimnasio WHERE id = :id", nativeQuery = true)
    void eliminarMaquinaGimnasio(@Param("id") Integer id);
}

