package uniandes.edu.co.proyecto.repositorios;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{
    @Query(value = "SELECT * FROM usuarios", nativeQuery = true)
    Collection<Usuario> darUsuarios();

    @Query(value = "SELECT * FROM usuarios WHERE num_documento = :numDocumento", nativeQuery = true)
    Usuario darUsuario(@Param("numDocumento") String numDocumento);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO usuarios VALUES (:tipoDocumento, :numDocumento, :nombre, :correo, :rol)", nativeQuery = true)
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

    //Rf 7 iteracion 2
    @Modifying
    @Transactional
    @Query(value = "SELECT usuarios.num_documento, SUM(consumos.costo) AS total_gastos, SUM(reservas.noches) AS total_noches FROM usuarios LEFT JOIN consumos ON usuarios.num_documento = consumos.num_documento_cliente LEFT JOIN reservas ON usuarios.num_documento = reservas.num_documento GROUP BY usuarios.num_documento HAVING SUM(consumos.costo) > 15000000 OR SUM(reservas.noches) >= 14 ORDER BY usuarios.num_documento", nativeQuery = true)
    Collection<Object[]> darBuenosClientes();

    //RFC 9 ITERACION 2
    @Query(value = "SELECT * FROM USUARIOS US INNER JOIN CONSUMOS C ON US.NUM_DOCUMENTO = C.NUM_DOCUMENTO_CLIENTE INNER JOIN SERVICIOS S ON S.ID = C.SERVICIO_ID WHERE S.TIPO = :servicio AND C.FECHA BETWEEN TO_DATE(:fechaInicial, 'YYYY-MM-DD') AND TO_DATE(:fechaFinal, 'YYYY-MM-DD') ORDER BY :ordenamiento", nativeQuery = true)
    Collection<Object[]> consultarConsumosServicio(@Param("servicio") String servicio, @Param("fechaInicial") String fechaInicial, @Param("fechaFinal") String fechaFinal, @Param("ordenamiento") String ordenamiento);

    //RFC 10 ITERACION 2
    @Query(value = "SELECT * FROM USUARIOS US LEFT JOIN CONSUMOS C ON US.NUM_DOCUMENTO = C.NUM_DOCUMENTO_CLIENTE LEFT JOIN SERVICIOS S ON S.ID = C.SERVICIO_ID AND S.TIPO = :servicio WHERE S.ID IS NULL AND (C.FECHA IS NULL OR C.FECHA BETWEEN TO_DATE(:fechaInicial, 'YYYY-MM-DD') AND TO_DATE(:fechaFinal, 'YYYY-MM-DD')) ORDER BY :ordenamiento", nativeQuery = true)
    Collection<Object[]> consultarConsumosNoServicio(@Param("servicio") String servicio, @Param("fechaInicial") String fechaInicial, @Param("fechaFinal") String fechaFinal, @Param("ordenamiento") String ordenamiento);

    //Rf 12 iteracion 2
    @Modifying
    @Transactional
    @Query(value = "SELECT tabla.tipo_documento, tabla.num_documento, tabla.nombre, tabla.correo, COUNT(tabla.num_documento) AS semestres_estadia\n" + //
            "FROM (SELECT usuarios.tipo_documento, usuarios.num_documento, usuarios.nombre, usuarios.correo, TO_CHAR(reservas.fecha_salida, 'Q') AS semestre, COUNT(reservas.id) AS conteo\n" + //
            "FROM usuarios\n" + //
            "INNER JOIN reservas ON usuarios.num_documento = reservas.num_documento\n" + //
            "WHERE EXTRACT(YEAR FROM reservas.fecha_salida) = 2023\n" + //
            "GROUP BY usuarios.tipo_documento, usuarios.num_documento, usuarios.nombre, usuarios.correo, TO_CHAR(reservas.fecha_salida, 'Q')) tabla\n" + //
            "GROUP BY tabla.tipo_documento, tabla.num_documento, tabla.nombre, tabla.correo\n" + //
            "HAVING COUNT(tabla.num_documento) = 4", nativeQuery = true)
    Collection<Object[]> darExcelentesClientesParte1();

    @Modifying
    @Transactional
    @Query(value = "SELECT usuarios.tipo_documento, usuarios.num_documento, usuarios.nombre, usuarios.correo, COUNT(UNIQUE reservas.id) conteo_reservas, COUNT(UNIQUE consumos.id) conteo_servicios_costosos\n" + //
            "FROM usuarios\n" + //
            "INNER JOIN reservas ON usuarios.num_documento = reservas.num_documento\n" + //
            "INNER JOIN reservasHabitaciones ON reservas.id = reservasHabitaciones.reserva_id\n" + //
            "INNER JOIN habitaciones ON reservasHabitaciones.habitacion_id = habitaciones.id\n" + //
            "INNER JOIN consumos ON habitaciones.id = consumos.habitacion_id\n" + //
            "WHERE consumos.costo > 300000\n" + //
            "GROUP BY usuarios.tipo_documento, usuarios.num_documento, usuarios.nombre, usuarios.correo\n" + //
            "HAVING COUNT(UNIQUE consumos.id) >= COUNT(UNIQUE reservas.id)", nativeQuery = true)
    Collection<Object[]> darExcelentesClientesParte2();

    @Modifying
    @Transactional
    @Query(value = "SELECT usuarios.tipo_documento, usuarios.num_documento, usuarios.nombre, usuarios.correo, COUNT(UNIQUE reservas.id) conteo_reservas, COUNT(UNIQUE reservasSpa.id) conteo_reservas_spa, COUNT(UNIQUE reservasSalonReunion.id) conteo_reservas_salon\n" + //
            "FROM usuarios\n" + //
            "INNER JOIN reservas ON usuarios.num_documento = reservas.num_documento\n" + //
            "LEFT JOIN reservasSpa ON usuarios.num_documento = reservasSpa.num_documento\n" + //
            "LEFT JOIN reservasSalonReunion ON usuarios.num_documento = reservasSalonReunion.num_documento\n" + //
            "WHERE reservasSpa.duracion > 240 OR reservasSalonReunion.duracion > 240\n" + //
            "GROUP BY usuarios.tipo_documento, usuarios.num_documento, usuarios.nombre, usuarios.correo\n" + //
            "HAVING COUNT(UNIQUE reservasSpa.id) >= COUNT(UNIQUE reservas.id) OR COUNT(UNIQUE reservasSalonReunion.id) >= COUNT(UNIQUE reservas.id)", nativeQuery = true)
    Collection<Object[]> darExcelentesClientesParte3();


}
