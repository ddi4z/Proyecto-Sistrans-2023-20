package uniandes.edu.co.proyecto.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TipoUsuario;

import java.util.Collection;


public interface TipoUsuarioRepository  extends JpaRepository<TipoUsuario, Integer>{

    @Query(value = "SELECT * FROM tiposUsuarios", nativeQuery = true)
    Collection<TipoUsuario> darTiposUsuario();

    @Query(value = "SELECT * FROM tiposUsuarios WHERE id = :id", nativeQuery = true)
    TipoUsuario darTipoUsuario(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tiposUsuarios VALUES (idTiposUsuarios.nextval, :nombre)", nativeQuery = true)
    void insertarTipoUsuario(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tiposUsuarios SET nombre = :nombre WHERE id = :id", nativeQuery = true)
    void actualizarTipoUsuario(@Param("id") Integer id, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tiposUsuarios WHERE id = :id", nativeQuery = true)
    void eliminarTipoUsuario(@Param("id") Integer id);

}
