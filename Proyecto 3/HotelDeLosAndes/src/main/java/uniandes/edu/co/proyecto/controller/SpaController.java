package uniandes.edu.co.proyecto.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import uniandes.edu.co.proyecto.modelo.Servicio;
import uniandes.edu.co.proyecto.modelo.ServicioSpa;
import uniandes.edu.co.proyecto.modelo.Spa;
import uniandes.edu.co.proyecto.repositorios.ServicioRepository;
import uniandes.edu.co.proyecto.repositorios.SpaRepository;

@Controller
public class SpaController {
    private static final String tipo = "Spa";

    @Autowired
    private SpaRepository spaRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    
    @GetMapping("/consultas/servicios/spas")
    public String Spa(Model model) {
        model.addAttribute("Spas", spaRepository.darSpas());
        return "spas";
    }

    @GetMapping("/consultas/servicios/spas/new")
    public String SpaForm(Model model) {
        model.addAttribute("Spa", new Spa());
        model.addAttribute("Servicio", new Servicio());
        return "spaNuevo";
    }

    @PostMapping("/consultas/servicios/spas/new/save")
    public String BarGuardar(@ModelAttribute Spa spa) {
        int id = servicioRepository.findTop1ByOrderByIdDesc().iterator().next().getId() + 1;
        spa.setId(id);
        spa.setTipo(tipo);
        spa.setServiciosSpa(new ArrayList<ServicioSpa>());
        servicioRepository.save(spa);
        return "redirect:/consultas/servicios/spas";
    }
    @GetMapping("/consultas/servicios/spas/{id}/edit")
    public String SpaEditarForm(@PathVariable("id") Integer id, Model model) {
        Spa spa = spaRepository.darSpa(id);
        if (spa != null) {
            model.addAttribute("Spa", spa);
            return "SpaEditar";
        } else {
            return "redirect:/consultas/servicios/spas";
        }
    }

    
    @PostMapping("/consultas/servicios/spas/{id}/edit/save")
    public String SpaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Spa spa, @ModelAttribute Servicio servicio) {
        spaRepository.actualizarSpa(id,spa.getNombre(), spa.getCapacidad());
        return "redirect:/consultas/servicios/spas";
    }
 
    @GetMapping("/consultas/servicios/spas/{id}/delete")
    public String SpaBorrar(@PathVariable("id") Integer id) {
        spaRepository.deleteById(id);
        return "redirect:/consultas/servicios/spas";
    }
}
