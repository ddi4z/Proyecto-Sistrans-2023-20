package uniandes.edu.co.proyecto.repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.MenuEstablecimiento;
import uniandes.edu.co.proyecto.modelo.Producto;

public interface MenuEstablecimientoRepository extends JpaRepository<MenuEstablecimiento, Integer>{
    @Query(value = "SELECT productos.* FROM productos " +
                    "INNER JOIN menusEstablecimientos ON productos.id = menusEstablecimientos.producto_id", nativeQuery = true)
    Collection<Producto> darMenusEstablecimientos();

    @Query(value = "SELECT productos.* FROM productos " +
                    "INNER JOIN menusEstablecimientos ON productos.id = menusEstablecimientos.producto_id" +
                    "WHERE menusEstablecimientos.establecimientocomercio_id = :establecimientoComercioId", nativeQuery = true)
    Collection<Producto> darMenuEstablecimiento(@Param("establecimientoComercioId") Integer establecimientoComercioId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO menusEstablecimientos VALUES (:establecimientoComercioId, :productoId)", nativeQuery = true)
    void insertarMenuEstablecimiento(@Param("establecimientoComercioId") Integer establecimientoComercioId, @Param("productoId") Integer productoId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE menusEstablecimientos SET establecimientocomercio_id = :establecimientoComercioId WHERE producto_id = :productoId", nativeQuery = true)
    void actualizarEstablecimientoMenuEstablecimiento(@Param("establecimientoComercioId") Integer establecimientoComercioId, @Param("productoId") Integer productoId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE menusEstablecimientos SET producto_id = :productoId WHERE establecimientocomercio_id = :establecimientoComercioId", nativeQuery = true)
    void actualizarProductoMenuEstablecimiento(@Param("establecimientoComercioId") Integer establecimientoComercioId, @Param("productoId") Integer productoId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM menusEstablecimientos WHERE establecimientocomercio_id = :establecimientoComercioId", nativeQuery = true)
    void eliminarEstablecimientoMenuEstablecimiento(@Param("establecimientoComercioId") Integer establecimientoComercioId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM menusEstablecimientos WHERE producto_id = :productoId", nativeQuery = true)
    void eliminarProductoMenuEstablecimiento(@Param("productoId") Integer productoId);
}
