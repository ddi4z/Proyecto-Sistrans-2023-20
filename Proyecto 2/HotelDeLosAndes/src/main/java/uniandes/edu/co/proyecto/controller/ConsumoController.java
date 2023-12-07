package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Consumo;
import uniandes.edu.co.proyecto.repositorios.ConsumoRepository;
import uniandes.edu.co.proyecto.repositorios.HabitacionRepository;
import uniandes.edu.co.proyecto.repositorios.ServicioRepository;

@Controller
public class ConsumoController {

    @Autowired
    private ConsumoRepository consumoRepository;

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired
    private ServicioRepository servicioRepository;


    @GetMapping("/empleado/consumos")
    public String Consumos(Model model) {
        model.addAttribute("Consumos", consumoRepository.darConsumos());
        return "consumos";
    }

    @GetMapping("/empleado/consumos/new")
    public String ConsumoForm(Model model) {
        model.addAttribute("Consumo", new Consumo());
        model.addAttribute("habitaciones", habitacionRepository.darHabitaciones());
        model.addAttribute("servicios", servicioRepository.darServicios());
        return "consumoNuevo";
    }

    @PostMapping("/empleado/consumos/new/save")
    public String ConsumoGuardar(@ModelAttribute Consumo consumo) {
        consumoRepository.insertarConsumo(consumo.getFecha().toString().replace('T', ' '),consumo.getDescripcion(),consumo.getCosto(),consumo.getPagado()? 1 : 0,consumo.getHabitacion().getId(), consumo.getServicio().getId(), consumo.getCliente().getNumDocumento(), consumo.getEmpleado().getNumDocumento());
        return "redirect:/empleado/consumos";
    }

    @GetMapping("/empleado/consumos/{id}/edit")
    public String GimnasioEditarForm(@PathVariable("id") Integer id, Model model) {
        Consumo consumo = consumoRepository.darConsumo(id);
        if (consumo != null) {
            model.addAttribute("Consumo", consumo);
            model.addAttribute("habitaciones", habitacionRepository.darHabitaciones());
            model.addAttribute("servicios", servicioRepository.darServicios());
            return "consumoEditar";
        } else {
            return "redirect:/empleado/consumos";
        }
    }

    @PostMapping("/empleado/consumos/{id}/edit/save")
    public String ConsumoEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Consumo consumo) {
        consumoRepository.actualizarConsumo(id,consumo.getFecha().toString().replace('T', ' '),consumo.getDescripcion(),consumo.getCosto(),consumo.getPagado()? 1 : 0,consumo.getHabitacion().getId(), consumo.getServicio().getId(), consumo.getCliente().getNumDocumento(), consumo.getEmpleado().getNumDocumento());
        return "redirect:/empleado/consumos";
    }

    @GetMapping("/empleado/consumos/{id}/delete")
    public String ConsumoBorrar(@PathVariable("id") Integer id) {
        consumoRepository.eliminarConsumo(id);
        return "redirect:/empleado/consumos";
    }


}
