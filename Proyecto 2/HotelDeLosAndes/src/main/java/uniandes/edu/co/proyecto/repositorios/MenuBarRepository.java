package uniandes.edu.co.proyecto.repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.MenuBar;
import uniandes.edu.co.proyecto.modelo.Producto;

public interface MenuBarRepository extends JpaRepository<MenuBar, Integer>{
    @Query(value = "SELECT productos.* FROM productos " +
                    "INNER JOIN menusBares ON productos.id = menusBares.producto_id", nativeQuery = true)
    Collection<Producto> darMenusBares();

    @Query(value = "SELECT productos.* FROM productos " +
                    "INNER JOIN menusBares ON productos.id = menusBares.producto_id" +
                    "WHERE menusBares.bar_id = :barId", nativeQuery = true)
    Collection<Producto> darMenuBar(@Param("barId") Integer barId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO menusBares VALUES (:barId, :productoId)", nativeQuery = true)
    void insertarMenuBar(@Param("barId") Integer barId, @Param("productoId") Integer productoId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE menusBares SET bar_id = :barId WHERE producto_id = :productoId", nativeQuery = true)
    void actualizarBarMenuBar(@Param("barId") Integer barId, @Param("productoId") Integer productoId);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE menusBares SET producto_id = :productoId WHERE bar_id = :barId", nativeQuery = true)
    void actualizarProductoMenuBar(@Param("barId") Integer barId, @Param("productoId") Integer productoId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM menusBares WHERE bar_id = :barId", nativeQuery = true)
    void eliminarBarMenuBar(@Param("barId") Integer barId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM menusBares WHERE producto_id = :productoId", nativeQuery = true)
    void eliminarProductoMenuBar(@Param("productoId") Integer productoId);
}

