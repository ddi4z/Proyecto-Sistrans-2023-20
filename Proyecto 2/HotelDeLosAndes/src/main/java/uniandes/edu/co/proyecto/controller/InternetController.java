package uniandes.edu.co.proyecto.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.proyecto.modelo.Internet;
import uniandes.edu.co.proyecto.modelo.Servicio;
import uniandes.edu.co.proyecto.repositorios.InternetRepository;
import uniandes.edu.co.proyecto.repositorios.ServicioRepository;

@Controller
public class InternetController {
    private static final String tipo = "Internet";

    @Autowired
    private InternetRepository internetRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/administrador/servicios/internets")
    public String Internets(Model model) {
        model.addAttribute("Internets", internetRepository.darInternets());
        return "internets";
    }

    @GetMapping("/administrador/servicios/internets/new")
    public String InternetForm(Model model) {
        model.addAttribute("Internet", new Internet());
        model.addAttribute("Servicio", new Servicio());
        return "internetNuevo";
    }

    @PostMapping("/administrador/servicios/internets/new/save")
    public String InternetGuardar(@ModelAttribute Internet internet, @ModelAttribute Servicio servicio) {
        servicioRepository.insertarServicio(servicio.getNombre(), tipo);
        BigInteger id = servicioRepository.darIdServicios();
        internetRepository.insertarInternet(id, internet.getCapacidad(), internet.getCostoDia());
        return "redirect:/administrador/servicios/internets";
    }

    @GetMapping("/administrador/servicios/internets/{id}/edit")
    public String InternetEditarForm(@PathVariable("id") Integer id, Model model) {
        Internet internet = internetRepository.darInternet(id);
        Servicio servicio = servicioRepository.darServicio(id);
        if (internet != null) {
            model.addAttribute("Internet", internet);
            model.addAttribute("Servicio", servicio);
            return "internetEditar";
        } else {
            return "redirect:/administrador/servicios/internets";
        }
    }

    @PostMapping("/administrador/servicios/internets/{id}/edit/save")
    public String InternetEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Internet internet, @ModelAttribute Servicio servicio) {
        servicioRepository.actualizarServicio(id, servicio.getNombre(), tipo);
        internetRepository.actualizarInternet(id, internet.getCapacidad(), internet.getCostoDia());
        return "redirect:/administrador/servicios/internets";
    }

    @GetMapping("/administrador/servicios/internets/{id}/delete")
    public String InternetBorrar(@PathVariable("id") Integer id) {
        internetRepository.eliminarInternet(id);
        servicioRepository.eliminarServicio(id);
        return "redirect:/administrador/servicios/internets";
    }
}
