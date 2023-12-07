package uniandes.edu.co.proyecto.repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.MenuRestaurante;
import uniandes.edu.co.proyecto.modelo.Producto;

public interface MenuRestauranteRepository extends JpaRepository<MenuRestaurante, Integer>{
    @Query(value = "SELECT productos.* FROM productos " +
                    "INNER JOIN menusRestaurantes ON productos.id = menusRestaurantes.producto_id", nativeQuery = true)
    Collection<Producto> darMenusRestaurantes();

    @Query(value = "SELECT productos.* FROM productos " +
                    "INNER JOIN menusRestaurantes ON productos.id = menusRestaurantes.producto_id" +
                    "WHERE menusRestaurantes.restaurante_id = :restauranteId", nativeQuery = true)
    Collection<Producto> darMenuRestaurante(@Param("restauranteId") Integer restauranteId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO menusRestaurantes VALUES (:restauranteId, :productoId)", nativeQuery = true)
    void insertarMenuRestaurante(@Param("restauranteId") Integer restauranteId, @Param("productoId") Integer productoId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE menusRestaurantes SET restaurante_id = :restauranteId WHERE producto_id = :productoId", nativeQuery = true)
    void actualizarRestauranteMenuRestaurante(@Param("restauranteId") Integer restauranteId, @Param("productoId") Integer productoId);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE menusRestaurantes SET producto_id = :productoId WHERE restaurante_id = :restauranteId", nativeQuery = true)
    void actualizarProductoMenuRestaurante(@Param("restauranteId") Integer restauranteId, @Param("productoId") Integer productoId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM menusRestaurantes WHERE restaurante_id = :restauranteId", nativeQuery = true)
    void eliminarRestauranteMenuRestaurante(@Param("restauranteId") Integer restauranteId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM menusRestaurantes WHERE producto_id = :productoId", nativeQuery = true)
    void eliminarProductoMenuRestaurante(@Param("productoId") Integer productoId);
}