package uniandes.edu.co.proyecto.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.proyecto.modelo.Bar;
import uniandes.edu.co.proyecto.modelo.Servicio;
import uniandes.edu.co.proyecto.repositorios.BarRepository;
import uniandes.edu.co.proyecto.repositorios.ServicioRepository;

@Controller
public class BarController {
    private static final String tipo = "Bar";

    @Autowired
    private BarRepository barRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/administrador/servicios/bares")
    public String Bares(Model model) {
        model.addAttribute("Bares", barRepository.darBares());
        return "bares";
    }

    @GetMapping("/administrador/servicios/bares/new")
    public String BarForm(Model model) {
        model.addAttribute("Bar", new Bar());
        model.addAttribute("Servicio", new Servicio());
        return "barNuevo";
    }

    @PostMapping("/administrador/servicios/bares/new/save")
    public String BarGuardar(@ModelAttribute Bar bar, @ModelAttribute Servicio servicio) {
        servicioRepository.insertarServicio(servicio.getNombre(), tipo);
        BigInteger id = servicioRepository.darIdServicios();
        barRepository.insertarBar(id, bar.getCapacidad(), bar.getEstilo());
        return "redirect:/administrador/servicios/bares";
    }

    @GetMapping("/administrador/servicios/bares/{id}/edit")
    public String BarEditarForm(@PathVariable("id") Integer id, Model model) {
        Bar bar = barRepository.darBar(id);
        Servicio servicio = servicioRepository.darServicio(id);
        if (bar != null) {
            model.addAttribute("Bar", bar);
            model.addAttribute("Servicio", servicio);
            return "barEditar";
        } else {
            return "redirect:/administrador/servicios/bares";
        }
    }

    @PostMapping("/administrador/servicios/bares/{id}/edit/save")
    public String BarEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Bar bar, @ModelAttribute Servicio servicio) {
        servicioRepository.actualizarServicio(id, servicio.getNombre(), tipo);
        barRepository.actualizarBar(id, bar.getCapacidad(), bar.getEstilo());
        return "redirect:/administrador/servicios/bares";
    }

    @GetMapping("/administrador/servicios/bares/{id}/delete")
    public String BarBorrar(@PathVariable("id") Integer id) {
        barRepository.eliminarBar(id);
        servicioRepository.eliminarServicio(id);
        return "redirect:/administrador/servicios/bares";
    }
}
