package uniandes.edu.co.proyecto.repositorios;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    @Query(value = "SELECT * FROM usuarios", nativeQuery = true)
    Collection<Usuario> darUsuarios();

    @Query(value = "SELECT * FROM usuarios WHERE num_documento = :numDocumento", nativeQuery = true)
    Usuario darUsuario(@Param("numDocumento") String numDocumento);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO usuarios (:tipoDocumento, :numDocumento, :nombre, :correo, :rol)", nativeQuery = true)
    void insertarUsuario(@Param("tipoDocumento") String tipoDocumento, @Param("numDocumento") String numDocumento,
                    @Param("nombre") String nombre, @Param("correo") String correo, @Param("rol") Integer rol);

    @Modifying
    @Transactional
    @Query(value = "UPDATE usuarios SET tipo_documento = :tipoDocumento, nombre = :nombre, correo = :correo, rol = :rol WHERE num_documento = :numDocumento", nativeQuery = true)
    void actualizarUsuario(@Param("tipoDocumento") String tipoDocumento, @Param("numDocumento") String numDocumento,
                    @Param("nombre") String nombre, @Param("correo") String correo, @Param("rol") Integer rol);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM usuarios WHERE num_documento = :numDocumento", nativeQuery = true)
    void eliminarUsuario(@Param("numDocumento") String numDocumento);
}
