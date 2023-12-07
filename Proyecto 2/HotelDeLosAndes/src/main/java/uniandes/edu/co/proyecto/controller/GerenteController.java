package uniandes.edu.co.proyecto.controller;



import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import uniandes.edu.co.proyecto.repositorios.ConsumoRepository;
import uniandes.edu.co.proyecto.repositorios.HabitacionRepository;
import uniandes.edu.co.proyecto.repositorios.ServicioRepository;
import uniandes.edu.co.proyecto.repositorios.UsuarioRepository;


@Controller
public class GerenteController {

    @Autowired
    private ConsumoRepository consumoRepository;

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @RequestMapping("/gerente")
    public String index() {
        return "gerente";
    }

    @GetMapping("/gerente/recoleccion")
    public String Recoleccion(Model model) {
        model.addAttribute("Recoleccion", consumoRepository.gastoPorHabitacion());
        return "recoleccion";
    }


    @GetMapping("/gerente/populares")
    public String Populares(Model model) {
        return "popularesForm";
    }

    @PostMapping("/gerente/populares")
    public String PopularesResultados(@RequestParam("fechaInicio") String fechaInicio, @RequestParam("fechaFin") String fechaFin, Model model) {
        model.addAttribute("Populares", consumoRepository.serviciosMasConsumidos(fechaInicio, fechaFin));
        return "populares";
    }

    @GetMapping("/gerente/consumosUsuario")
    public String ConsumosUsuario(Model model) {
        return "consumosUsuarioForm";
    }

    @PostMapping("/gerente/consumosUsuario")
    public String ConsumosUsuarioResultados(@RequestParam("fechaInicio") String fechaInicio, @RequestParam("fechaFin") String fechaFin, @RequestParam("numDocumento") String numDocumento, Model model) {
        model.addAttribute("ConsumosUsuario", consumoRepository.consumosPorUsuario(fechaInicio, fechaFin, numDocumento));
        return "consumosUsuario";
    }



    @GetMapping("/gerente/ocupacion")
    public String Ocupacion(Model model) {
        model.addAttribute("Ocupacion", habitacionRepository.darPorcentajeOcupacion());
        return "ocupacion";
    }


    @GetMapping("/gerente/serviciosCaracteristicas")
    public String ServiciosCaracteristicas(Model model) {
        Collection<String> tipos = servicioRepository.darTiposServicio();
        tipos.clear();
        Collection<String> tiposForm = servicioRepository.darTiposServicio();
        tipos.add("Cualquiera");
        for (String tipo : tiposForm) {
            tipos.add(tipo);
        }
        model.addAttribute("Tipos", tipos);

        return "serviciosCaracteristicasForm";
    }


    @PostMapping("/gerente/serviciosCaracteristicas")
    public String ServiciosCaracteristicasResultados(Model model,  
    @RequestParam(name = "precio1", required = false) Integer precio1,
    @RequestParam(name = "precio2", required = false) Integer precio2,
    @RequestParam(name = "fecha1", required = false) String fecha1,
    @RequestParam(name = "fecha2", required = false) String fecha2,
    @RequestParam(name = "empleado", required = false) String empleado,
    @RequestParam(name = "tipo", required = false) String tipo) {

        if (!fecha1.equals("") && !fecha2.equals("") && precio1 == null && precio2 == null && empleado.equals("") && tipo.equals("Cualquiera")) {
            model.addAttribute("General", servicioRepository.darServiciosEntreFechas(fecha1,fecha2));
            model.addAttribute("PrecioAsociado", null);
            model.addAttribute("Promedio", null);
        }
        else if (fecha1 == "" && fecha2 == "" && precio1 == null && precio2 == null && !empleado.equals("") && tipo.equals("Cualquiera") ) {
            model.addAttribute("General", servicioRepository.darServiciosPorEmpleadoId(empleado));
            model.addAttribute("PrecioAsociado", null);
            model.addAttribute("Promedio", null);
        }
        else if (fecha1 == "" && fecha2 == "" && precio1 == null && precio2 == null && empleado.equals("") && !tipo.equals("Cualquiera") ) {
            model.addAttribute("General", servicioRepository.darServiciosPorTipo(tipo));
            model.addAttribute("PrecioAsociado", null);
            model.addAttribute("Promedio", null);
        }
        else if (!fecha1.equals("") && !fecha2.equals("") && precio1 == null && precio2 == null && !empleado.equals("") && tipo.equals("Cualquiera") ) {
            model.addAttribute("General", servicioRepository.darServiciosPorFechaYEmpleado(fecha1,fecha2,empleado));
            model.addAttribute("PrecioAsociado", null);
            model.addAttribute("Promedio", null);
        }
        else if (!fecha1.equals("") && !fecha2.equals("") && precio1 == null && precio2 == null && empleado.equals("") && !tipo.equals("Cualquiera")) {
            System.out.println("aaaaaaaaaaaaaa");
            System.out.println(tipo);
            model.addAttribute("General", servicioRepository.darServiciosPorFechaYTipo(fecha1,fecha2,tipo));
            model.addAttribute("PrecioAsociado", null);
            model.addAttribute("Promedio", null);
        }
        else if (fecha1 == "" && fecha2 == "" && precio1 == null && precio2 == null && !empleado.equals("") && !tipo.equals("Cualquiera") ) {
            model.addAttribute("General", servicioRepository.darServiciosPorEmpleadoYTipo(empleado,tipo));
            model.addAttribute("PrecioAsociado", null);
            model.addAttribute("Promedio", null);
        }
        else if (!fecha1.equals("") && !fecha2.equals("") && precio1 == null && precio2 == null && !empleado.equals("") && !tipo.equals("Cualquiera") ) {
            model.addAttribute("General", servicioRepository.darServiciosPorFechaEmpleadoYTipo(fecha1,fecha2,empleado,tipo));
            model.addAttribute("PrecioAsociado", null);
            model.addAttribute("Promedio", null);
        }
        else if (fecha1 == "" && fecha2 == "" && precio1 != null && precio2 != null && empleado.equals("") && tipo.equals("Cualquiera") ) {
            model.addAttribute("General", null);
            model.addAttribute("PrecioAsociado", servicioRepository.darServiciosPorPrecio(precio1,precio2));
            model.addAttribute("Promedio", servicioRepository.darServiciosPromedioPorPrecio(precio1,precio2));
        }
        else if (!fecha1.equals("") && !fecha2.equals("") && precio1 != null && precio2 != null && empleado.equals("") && tipo.equals("Cualquiera") ) {
            model.addAttribute("General", null);
            model.addAttribute("PrecioAsociado", servicioRepository.darServiciosPorPrecioYFecha(precio1,precio2,fecha1,fecha2));
            model.addAttribute("Promedio", servicioRepository.darServiciosPromedioPorPrecioyFecha(precio1,precio2,fecha1,fecha2));
        }
        else if (fecha1 == "" && fecha2 == "" && precio1 != null && precio2 != null && !empleado.equals("") && tipo.equals("Cualquiera") ) {
            model.addAttribute("General", null);
            model.addAttribute("PrecioAsociado", servicioRepository.darServiciosPorPrecioYEmpleado(precio1,precio2,empleado));
            model.addAttribute("Promedio", servicioRepository.darServiciosPromedioPorPrecioYEmpleado(precio1,precio2,empleado));
        }
        else if (fecha1 == "" && fecha2 == "" && precio1 != null && precio2 != null && empleado.equals("") && !tipo.equals("Cualquiera") ) {
            model.addAttribute("General", null);
            model.addAttribute("PrecioAsociado", servicioRepository.darServiciosPorPrecioYTipo(precio1,precio2,tipo));
            model.addAttribute("Promedio", servicioRepository.darServiciosPromedioPorPrecioYTipo(precio1,precio2,tipo));
        }
        else if (!fecha1.equals("") && !fecha2.equals("") && precio1 != null && precio2 != null && !empleado.equals("") && !tipo.equals("Cualquiera") ) {
            model.addAttribute("General", null);
            model.addAttribute("PrecioAsociado", servicioRepository.darServiciosPorPrecioFechaYEmpleado(precio1,precio2,fecha1,fecha2,empleado));
            model.addAttribute("Promedio", servicioRepository.darServiciosPromedioPorPrecioFechaYEmpleado(precio1,precio2,fecha1,fecha2,empleado));
        }
        else if (!fecha1.equals("") && !fecha2.equals("") && precio1 != null && precio2 != null && empleado.equals("") && !tipo.equals("Cualquiera") ) {
            model.addAttribute("General", null);
            model.addAttribute("PrecioAsociado", servicioRepository.darServiciosPorPrecioFechaYTipo(precio1,precio2,fecha1,fecha2,tipo));
            model.addAttribute("Promedio", servicioRepository.darServiciosPromedioPorPrecioFechaTipo(precio1,precio2,fecha1,fecha2,tipo));
        }
        else if (fecha1 == "" && fecha2 == "" && precio1 != null && precio2 != null && !empleado.equals("") && !tipo.equals("Cualquiera") ) {
            model.addAttribute("General", null);
            model.addAttribute("PrecioAsociado", servicioRepository.darServiciosPorPrecioEmpleadoYTipo(precio1,precio2,empleado,tipo));
            model.addAttribute("Promedio", servicioRepository.darServiciosPromedioPorPrecioEmpleadoTipo(precio1,precio2,empleado,tipo));
        }
        else if (!fecha1.equals("") && !fecha2.equals("") && precio1 != null && precio2 != null && !empleado.equals("") && !tipo.equals("Cualquiera") ) {
            model.addAttribute("General", null);
            model.addAttribute("PrecioAsociado", servicioRepository.darServiciosConTodo(fecha1,fecha2,precio1,precio2,empleado,tipo));
            model.addAttribute("Promedio", servicioRepository.DarServiciosPromedioConTodo(fecha1,fecha2,precio1,precio2,empleado,tipo));
        }
        else{
            model.addAttribute("General", null);
            model.addAttribute("PrecioAsociado", null);
            model.addAttribute("Promedio", null);
        }
    return "serviciosCaracteristicas";
    }

    

    @GetMapping("/gerente/operacion")
    public String Operacion(Model model) {
        model.addAttribute("Mayor", habitacionRepository.darMayorOcupacion());
        model.addAttribute("Ingresos", consumoRepository.darMayorIngreso());
        model.addAttribute("Menor", habitacionRepository.darMenorOcupacion());
        return "operacion";
    }
    @GetMapping("/gerente/buenos")
    public String Buenos(Model model) {
        model.addAttribute("Buenos", usuarioRepository.darBuenosClientes());
        return "buenos";
    }

    

    @GetMapping("/gerente/bajaDemanda")
    public String bajaDemanda(Model model) {
        model.addAttribute("BajaDemanda", consumoRepository.darBajaDemanda());
        return "bajaDemanda";
    }

    @GetMapping("/gerente/consumosV1")
    public String usuariosConConsumosServicio(Model model) {
        model.addAttribute("Tipos", servicioRepository.darTiposServicio());
        return "consumosV1GerenteForm";
    }

    @PostMapping("/gerente/consumosV1")
    public String serviciosCaracteristicasResultados(Model model, @RequestParam(name = "servicio", required = true) String servicio, @RequestParam(name = "fechaInicial", required = true) String fechaIncial, @RequestParam(name = "fechaFinal", required = true) String fechaFinal, @RequestParam(name = "ordenamiento", required = true) String ordenamiento) {
        model.addAttribute("Usuarios", usuarioRepository.consultarConsumosServicio(servicio, fechaIncial, fechaFinal, ordenamiento));
        return "consumosV1Gerente";
    }

    @GetMapping("/gerente/consumosV2")
    public String usuariosSinConsumosServicio(Model model) {
        model.addAttribute("Tipos", servicioRepository.darTiposServicio());
        return "consumosV2GerenteForm";
    }

    @PostMapping("/gerente/consumosV2")
    public String noServiciosCaracteristicasResultados(Model model, @RequestParam(name = "servicio", required = true) String servicio, @RequestParam(name = "fechaInicial", required = true) String fechaIncial, @RequestParam(name = "fechaFinal", required = true) String fechaFinal, @RequestParam(name = "ordenamiento", required = true) String ordenamiento) {
        model.addAttribute("Usuarios", usuarioRepository.consultarConsumosNoServicio(servicio, fechaIncial, fechaFinal, ordenamiento));
        model.addAttribute("servicio", servicio);
        return "consumosV2Gerente";
    }

    @GetMapping("/gerente/funcionamiento")
    public String Funcionamiento(Model model) {
        model.addAttribute("MasConsumidos", consumoRepository.darMasConsumidos());
        model.addAttribute("MenosConsumidos", consumoRepository.darMenosConsumidos());
        model.addAttribute("MasSolicitadas", habitacionRepository.darMasSolicitadas());
        model.addAttribute("MenosSolicitadas", habitacionRepository.darMenosSolicitadas());
        return "funcionamiento";
    }

    @GetMapping("/gerente/excelentes")
    public String Excelentes(Model model) {
        model.addAttribute("Excelentes1", usuarioRepository.darExcelentesClientesParte1());
        model.addAttribute("Excelentes2", usuarioRepository.darExcelentesClientesParte2());
        model.addAttribute("Excelentes3", usuarioRepository.darExcelentesClientesParte3());



        return "excelentes";
    }
}





