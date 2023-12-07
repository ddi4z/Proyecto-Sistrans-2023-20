package uniandes.edu.co.proyecto.repositorios;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.proyecto.modelo.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {
    @Query(value = "SELECT * FROM prestamos", nativeQuery = true)
    Collection<Prestamo> darPrestamos();

    @Query(value = "SELECT * FROM prestamos WHERE id = :id", nativeQuery = true)
    Prestamo darPrestamo(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO prestamos VALUES (idPrestamos.nextval, :utensilio, :costoPerdida, :devuelto, :habitacionesId, :numDocumento)", nativeQuery = true)
    void insertarPrestamo(@Param("utensilio") String utensilio, @Param("costoPerdida") Double costoPerdida, @Param("devuelto") Integer devuelto, @Param("habitacionesId") Integer habitacionesId, @Param("numDocumento") String numDocumento);

    @Modifying
    @Transactional
    @Query(value = "UPDATE prestamos SET utensilio = :utensilio, costo_perdida = :costoPerdida, devuelto = :devuelto, habitaciones_id = :habitacionesId, num_documento = :numDocumento WHERE id = :id", nativeQuery = true)
    void actualizarPrestamo(@Param("id") Integer id, @Param("utensilio") String utensilio, @Param("costoPerdida") Double costoPerdida, @Param("devuelto") Integer devuelto, @Param("habitacionesId") Integer habitacionesId, @Param("numDocumento") String numDocumento);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM prestamos WHERE id = :id", nativeQuery = true)
    void eliminarPrestamo(@Param("id") Integer id);
}
