package uniandes.edu.co.proyecto.controller;

import java.util.Calendar;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.Consumo;
import uniandes.edu.co.proyecto.modelo.Usuario;
import uniandes.edu.co.proyecto.repositorios.ConsumoRepository;
import uniandes.edu.co.proyecto.repositorios.HabitacionRepository;
import uniandes.edu.co.proyecto.repositorios.ReservaRepository;
import uniandes.edu.co.proyecto.repositorios.ServicioRepository;
import uniandes.edu.co.proyecto.repositorios.UsuarioRepository;

@Controller
public class ConsumoController {

    @Autowired
    private ConsumoRepository consumoRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ReservaRepository reservaRepository;


    @GetMapping("/consultas/consumos")
    public String Consumos(Model model) {
        model.addAttribute("Consumos", consumoRepository.darConsumos());
        return "consumos";
    }

    @GetMapping("/consultas/consumos/new")
    public String ConsumoForm(Model model) {
        model.addAttribute("Consumo", new Consumo());
        model.addAttribute("servicios", servicioRepository.darServicios());
        model.addAttribute("habitaciones", habitacionRepository.darHabitaciones());
        for (Usuario usuario : usuarioRepository.darUsuarios()) {
            System.out.println(usuario.getNombre());
        }

        return "consumoNuevo";
    }

    @PostMapping("/consultas/consumos/new/save")
    public String ConsumoGuardar(@ModelAttribute Consumo consumo) {
        int id = consumoRepository.findTop1ByOrderByIdDesc().iterator().next().getId() + 1;
        consumo.setId(id);
        if (!consumo.getPagado()){
            consumo.setPagado(true);
        }
        else {
             consumo.setPagado(false);
        }
        consumoRepository.save(consumo);
        return "redirect:/consultas/consumos";
    }

    @GetMapping("/consultas/consumos/{id}/edit")
    public String GimnasioEditarForm(@PathVariable("id") Integer id, Model model) {
        Consumo consumo = consumoRepository.darConsumo(id);
        if (consumo != null) {
            model.addAttribute("Consumo", consumo);
            model.addAttribute("servicios", servicioRepository.darServicios());
            model.addAttribute("habitaciones", habitacionRepository.darHabitaciones());
            return "consumoEditar";
        } else {
            return "redirect:/consultas/consumos";
        }
    }

    @PostMapping("/consultas/consumos/{id}/edit/save")
    public String ConsumoEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Consumo consumo) {
        if (!consumo.getPagado()){
            consumo.setPagado(true);
        }
        else {
             consumo.setPagado(false);
        }
        consumoRepository.actualizarConsumo(id, consumo.getFecha(), consumo.getDescripcion(), consumo.getCosto(), consumo.getPagado(), consumo.getHabitacion(), consumo.getServicio(), consumo.getCliente());
        return "redirect:/consultas/consumos";
    }

    @GetMapping("/consultas/consumos/{id}/delete")
    public String ConsumoBorrar(@PathVariable("id") Integer id) {
        consumoRepository.deleteById(id);
        return "redirect:/consultas/consumos";
    }

    @GetMapping("/requerimientos/recoleccion")
    public String Recoleccion(Model model) {
        model.addAttribute("Recoleccion", consumoRepository.gastoPorHabitacion(new Date(Calendar.getInstance().get(Calendar.YEAR))));
        return "recoleccion";
    }

    @GetMapping("/requerimientos/ocupacion")
    public String Ocupacion(Model model) {
        model.addAttribute("Ocupacion", reservaRepository.darPorcentajeOcupacion(new Date(Calendar.getInstance().get(Calendar.YEAR))));
        return "ocupacion";
    }


    @GetMapping("/requerimientos/consumosCliente")
    public String ConsumosUsuario(Model model) {
        model.addAttribute("tipos", usuarioRepository.darUsuarios());
        return "consumosUsuarioForm";
    }

    @PostMapping("/requerimientos/consumosCliente")
    public String ConsumosUsuarioResultados(@RequestParam("fechaInicio") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio, @RequestParam("fechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin, @RequestParam("numDocumento") String numDocumento, Model model) {
        model.addAttribute("ConsumosUsuario", consumoRepository.consumosPorUsuario(numDocumento, fechaInicio, fechaFin));
        return "consumosUsuario";
    }

    @GetMapping("/requerimientos/consumosServicio")
    public String consumosServicio(Model model) {
        model.addAttribute("tipos", servicioRepository.obtenerTiposDeServicioDistintos());
        return "consumosServicioForm";
    }



    @PostMapping("/requerimientos/consumosServicio")
    public String ConsumosServicioResultados(@RequestParam("fechaInicio") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio, @RequestParam("fechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin, @RequestParam("tipoServicio") String tipoServicio, @RequestParam("ordenamiento") String ordenamiento, Model model) {
        if (tipoServicio.equals("Cualquiera")) {
            model.addAttribute("ConsumosServicio", consumoRepository.consumosServicios(fechaInicio, fechaFin, ordenamiento));
        }
        else{
            model.addAttribute("ConsumosServicio", consumoRepository.consumosServicio(tipoServicio, fechaInicio, fechaFin, ordenamiento));
        }
        return "consumosServicio";
    }

}
