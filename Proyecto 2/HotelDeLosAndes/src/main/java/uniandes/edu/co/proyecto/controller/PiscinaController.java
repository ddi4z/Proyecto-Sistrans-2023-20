package uniandes.edu.co.proyecto.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.proyecto.modelo.Piscina;
import uniandes.edu.co.proyecto.modelo.Servicio;
import uniandes.edu.co.proyecto.repositorios.PiscinaRepository;
import uniandes.edu.co.proyecto.repositorios.ServicioRepository;

@Controller
public class PiscinaController {
    private static final String tipo = "Piscina";

    @Autowired
    private PiscinaRepository piscinaRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/administrador/servicios/piscinas")
    public String Piscinas(Model model) {
        model.addAttribute("Piscinas", piscinaRepository.darPiscinas());
        return "piscinas";
    }

    @GetMapping("/administrador/servicios/piscinas/new")
    public String PiscinaForm(Model model) {
        model.addAttribute("Piscina", new Piscina());
        model.addAttribute("Servicio", new Servicio());
        return "piscinaNueva";
    }

    @PostMapping("/administrador/servicios/piscinas/new/save")
    public String PiscinaGuardar(@ModelAttribute Piscina piscina, @ModelAttribute Servicio servicio) {
        servicioRepository.insertarServicio(servicio.getNombre(), tipo);
        BigInteger id = servicioRepository.darIdServicios();
        piscinaRepository.insertarPiscina(id, piscina.getCapacidad(), piscina.getProfundidad(), piscina.getHoraInicio().toString(), piscina.getHoraFin().toString(), piscina.getCostoAdicional());
        return "redirect:/administrador/servicios/piscinas";
    }

    @GetMapping("/administrador/servicios/piscinas/{id}/edit")
    public String PiscinaEditarForm(@PathVariable("id") Integer id, Model model) {
        Piscina piscina = piscinaRepository.darPiscina(id);
        Servicio servicio = servicioRepository.darServicio(id);
        if (piscina != null) {
            model.addAttribute("Piscina", piscina);
            model.addAttribute("Servicio", servicio);
            return "piscinaEditar";
        } else {
            return "redirect:/administrador/servicios/piscinas";
        }
    }

    @PostMapping("/administrador/servicios/piscinas/{id}/edit/save")
    public String PiscinaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Piscina piscina, @ModelAttribute Servicio servicio) {
        servicioRepository.actualizarServicio(id, servicio.getNombre(), tipo);
        piscinaRepository.actualizarPiscina(id, piscina.getCapacidad(), piscina.getProfundidad(), piscina.getHoraInicio().toString(), piscina.getHoraFin().toString(), piscina.getCostoAdicional());
        return "redirect:/administrador/servicios/piscinas";
    }

    @GetMapping("/administrador/servicios/piscinas/{id}/delete")
    public String PiscinaBorrar(@PathVariable("id") Integer id) {
        piscinaRepository.eliminarPiscina(id);
        servicioRepository.eliminarServicio(id);
        return "redirect:/administrador/servicios/piscinas";
    }
}
