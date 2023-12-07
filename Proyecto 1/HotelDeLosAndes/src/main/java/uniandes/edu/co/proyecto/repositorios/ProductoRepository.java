package uniandes.edu.co.proyecto.repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{
    @Query(value = "SELECT * FROM productos", nativeQuery = true)
    Collection<Producto> darProductos();

    @Query(value = "SELECT * FROM productos WHERE id = :id", nativeQuery = true)
    Producto darProducto(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO productos VALUES (idProductos.nextval, :nombre, :costo, :incluidoEnPlanes)", nativeQuery = true)
    void insertarProducto(@Param("nombre") String nombre, @Param("costo") Double costo, @Param("incluidoEnPlanes") Integer incluidoEnPlanes);

    @Modifying
    @Transactional
    @Query(value = "UPDATE productos SET nombre = :nombre, costo = :costo, incluido_en_planes = :incluidoEnPlanes WHERE id = :id", nativeQuery = true)
    void actualizarProducto(@Param("id") Integer id, @Param("nombre") String nombre, @Param("costo") Double costo, @Param("incluidoEnPlanes") Integer incluidoEnPlanes);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM productos WHERE id = :id", nativeQuery = true)
    void eliminarProducto(@Param("id") Integer id);
}

