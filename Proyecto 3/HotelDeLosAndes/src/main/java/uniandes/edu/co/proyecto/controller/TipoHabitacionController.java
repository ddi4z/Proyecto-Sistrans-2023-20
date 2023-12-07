package uniandes.edu.co.proyecto.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.ElementoDotacion;
import uniandes.edu.co.proyecto.modelo.TipoHabitacion;
import uniandes.edu.co.proyecto.repositorios.TipoHabitacionRepository;

@Controller
public class TipoHabitacionController {
     @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

    @GetMapping("/consultas/tiposHabitacion")
    public String TiposHabitacion(Model model) {
        model.addAttribute("TiposHabitacion", tipoHabitacionRepository.darTiposHabitacion());
        return "tiposHabitacion";
    }

    @GetMapping("/consultas/tiposHabitacion/new")
    public String TipoHabitacionForm(Model model) {
        model.addAttribute("TipoHabitacion", new TipoHabitacion());
        return "tipoHabitacionNueva";
    }

    @PostMapping("/consultas/tiposHabitacion/new/save")
    public String TipoHabitacionGuardar(@ModelAttribute TipoHabitacion tipoHabitacion) {
        int id = tipoHabitacionRepository.findTop1ByOrderByIdDesc().iterator().next().getId() + 1;
        tipoHabitacion.setId(id);
        tipoHabitacion.setElementos(new ArrayList<ElementoDotacion>());
        tipoHabitacionRepository.save(tipoHabitacion);
        return "redirect:/consultas/tiposHabitacion";
    }

    @GetMapping("/consultas/tiposHabitacion/{id}/edit")
    public String TipoHabitacionEditarForm(@PathVariable("id") Integer id, Model model) {
        TipoHabitacion tipoHabitacion = tipoHabitacionRepository.darTipoHabitacion(id);
        if (tipoHabitacion != null) {
            model.addAttribute("TipoHabitacion", tipoHabitacion);
            return "tipoHabitacionEditar";
        } else {
            return "redirect:/consultas/tiposHabitacion";
        }
    }

    @PostMapping("/consultas/tiposHabitacion/{id}/edit/save")
    public String TipoHabitacionEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute TipoHabitacion tipoHabitacion) {
        tipoHabitacionRepository.actualizarTipoHabitacion(id, tipoHabitacion.getNombre(), tipoHabitacion.getCapacidad(), tipoHabitacion.getCostoNoche());
        return "redirect:/consultas/tiposHabitacion";
    }

    @GetMapping("/consultas/tiposHabitacion/{id}/delete")
    public String TipoHabitacionBorrar(@PathVariable("id") Integer id) {
        tipoHabitacionRepository.deleteById(id);
        return "redirect:/consultas/tiposHabitacion";
    }    
}

