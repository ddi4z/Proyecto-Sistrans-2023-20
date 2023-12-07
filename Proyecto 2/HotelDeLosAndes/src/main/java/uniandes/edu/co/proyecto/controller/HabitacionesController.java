package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.repositorios.HabitacionRepository;
import uniandes.edu.co.proyecto.repositorios.TipoHabitacionRepository;

@Controller
public class HabitacionesController {
    @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;


    @GetMapping("/administrador/habitaciones")
    public String habitaciones(Model model){
        model.addAttribute("Habitaciones", habitacionRepository.darHabitaciones());
        return "habitaciones";
    }

    @GetMapping("/administrador/habitaciones/new")
    public String habitacionForm(Model model) {
        model.addAttribute("Habitacion", new Habitacion());
        model.addAttribute("Tipos",  tipoHabitacionRepository.darTiposHabitacion());
        return "habitacionNueva";
    }

    @PostMapping("/administrador/habitaciones/new/save")
    public String habitacionGuardar(@ModelAttribute Habitacion habitacion) {
        habitacionRepository.insertarHabitacion(habitacion.getTipo().getId());
        return "redirect:/habitaciones";
    }

    @GetMapping("/administrador/habitaciones/{id}/edit")
    public String habitacionEditarForm(@PathVariable("id") Integer id, Model model) {
        Habitacion habitacion = habitacionRepository.darHabitacion((id));
        if (habitacion != null) {
            model.addAttribute("Habitacion", habitacion);
            model.addAttribute("Tipos", tipoHabitacionRepository.darTiposHabitacion());
            return "habitacionEditar";
        } else {
            return "redirect:/administrador/habitaciones";
        }
    }

    @PostMapping("/administrador/habitaciones/{id}/edit/save")
    public String habitacionEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Habitacion habitacion) {
        habitacionRepository.actualizarHabitacion((id), habitacion.getOcupada() ? 1 : 0, habitacion.getTipo().getId());
        return "redirect:/habitaciones";
    }

    @GetMapping("/administrador/habitaciones/{id}/delete")
    public String habitacionBorrar(@PathVariable("id") Integer id) {
        habitacionRepository.eliminarHabitacion((id));
        return "redirect:/habitaciones";
    }
}
