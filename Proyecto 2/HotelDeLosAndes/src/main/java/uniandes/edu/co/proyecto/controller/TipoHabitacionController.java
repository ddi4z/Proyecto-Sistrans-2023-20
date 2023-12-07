package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.TipoHabitacion;
import uniandes.edu.co.proyecto.repositorios.TipoHabitacionRepository;

@Controller
public class TipoHabitacionController {
     @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

    @GetMapping("/administrador/tiposHabitacion")
    public String TiposHabitacion(Model model) {
        model.addAttribute("TiposHabitacion", tipoHabitacionRepository.darTiposHabitacion());
        return "tiposHabitacion";
    }

    @GetMapping("/administrador/tiposHabitacion/new")
    public String TipoHabitacionForm(Model model) {
        model.addAttribute("TipoHabitacion", new TipoHabitacion());
        return "tipoHabitacionNueva";
    }

    @PostMapping("/administrador/tiposHabitacion/new/save")
    public String TipoHabitacionGuardar(@ModelAttribute TipoHabitacion tipoHabitacion) {
        tipoHabitacionRepository.insertarTipoHabitacion(tipoHabitacion.getNombre(), tipoHabitacion.getCapacidad(), tipoHabitacion.getCostoNoche());
        return "redirect:/administrador/tiposHabitacion";
    }

    @GetMapping("/administrador/tiposHabitacion/{id}/edit")
    public String TipoHabitacionEditarForm(@PathVariable("id") Integer id, Model model) {
        TipoHabitacion tipoHabitacion = tipoHabitacionRepository.darTipoHabitacion(id);
        if (tipoHabitacion != null) {
            model.addAttribute("TipoHabitacion", tipoHabitacion);
            return "tipoHabitacionEditar";
        } else {
            return "redirect:/administrador/tiposHabitacion";
        }
    }

    @PostMapping("/administrador/tiposHabitacion/{id}/edit/save")
    public String TipoHabitacionEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute TipoHabitacion tipoHabitacion) {
        tipoHabitacionRepository.actualizarTipoHabitacion(id, tipoHabitacion.getNombre(), tipoHabitacion.getCapacidad(), tipoHabitacion.getCostoNoche());
        return "redirect:/administrador/tiposHabitacion";
    }

    @GetMapping("/administrador/tiposHabitacion/{id}/delete")
    public String TipoHabitacionBorrar(@PathVariable("id") Integer id) {
        tipoHabitacionRepository.eliminarTipoHabitacion(id);
        return "redirect:/administrador/tiposHabitacion";
    }    
}

