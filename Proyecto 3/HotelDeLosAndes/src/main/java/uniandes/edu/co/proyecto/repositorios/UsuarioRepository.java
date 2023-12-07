package uniandes.edu.co.proyecto.repositorios;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


import uniandes.edu.co.proyecto.modelo.Usuario;


import java.util.Collection;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    @Query("{}")
    Collection<Usuario> darUsuarios();
    

    @Query("{ 'id' : ?0 }")
    Usuario darUsuario(String id);

    @Query("{}")
    Usuario insertarUsuario();


    @Query("{}")
    void actualizarUsuario();



}