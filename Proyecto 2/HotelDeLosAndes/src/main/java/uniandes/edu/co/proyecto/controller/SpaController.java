package uniandes.edu.co.proyecto.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Servicio;
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


    
    @GetMapping("/administrador/servicios/spas")
    public String Spa(Model model) {
        model.addAttribute("Spas", spaRepository.darSpas());
        return "spas";
    }

    @GetMapping("/administrador/servicios/spas/new")
    public String SpaForm(Model model) {
        model.addAttribute("Spa", new Spa());
        model.addAttribute("Servicio", new Servicio());
        return "spaNuevo";
    }

    @PostMapping("/administrador/servicios/spas/new/save")
    public String SpaGuardar(@ModelAttribute Spa spa, @ModelAttribute Servicio servicio) {
        servicioRepository.insertarServicio(servicio.getNombre(), tipo);
        BigInteger id = servicioRepository.darIdServicios();
        spaRepository.insertarSpa(id,spa.getCapacidad());
        return "redirect:/administrador/servicios/spas";
    }

    @GetMapping("/administrador/servicios/spas/{id}/edit")
    public String SpaEditarForm(@PathVariable("id") Integer id, Model model) {
        Spa spa = spaRepository.darSpa(id);
        Servicio servicio = servicioRepository.darServicio(id);
        if (spa != null) {
            model.addAttribute("Spa", spa);
            model.addAttribute("Servicio", servicio);
            return "SpaEditar";
        } else {
            return "redirect:/administrador/servicios/spas";
        }
    }

    
    @PostMapping("/administrador/servicios/spas/{id}/edit/save")
    public String SpaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Spa spa, @ModelAttribute Servicio servicio) {
        servicioRepository.actualizarServicio(id, servicio.getNombre(), tipo);
        spaRepository.actualizarSpa(id, spa.getCapacidad());
        return "redirect:/administrador/servicios/spas";
    }

    @GetMapping("/administrador/servicios/spas/{id}/delete")
    public String SpaBorrar(@PathVariable("id") Integer id) {
        spaRepository.eliminarSpa(id);
        servicioRepository.eliminarServicio(id);
        return "redirect:/administrador/servicios/spas";
    }
}
