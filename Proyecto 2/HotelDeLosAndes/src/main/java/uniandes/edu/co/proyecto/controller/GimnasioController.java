package uniandes.edu.co.proyecto.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.proyecto.modelo.Gimnasio;
import uniandes.edu.co.proyecto.modelo.Servicio;
import uniandes.edu.co.proyecto.repositorios.GimnasioRepository;
import uniandes.edu.co.proyecto.repositorios.ServicioRepository;

@Controller
public class GimnasioController {
    private static final String tipo = "Gimnasio";

    @Autowired
    private GimnasioRepository gimnasioRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/administrador/servicios/gimnasios")
    public String Gimnasios(Model model) {
        model.addAttribute("Gimnasios", gimnasioRepository.darGimnasios());
        return "gimnasios";
    }

    @GetMapping("/administrador/servicios/gimnasios/new")
    public String GimnasioForm(Model model) {
        model.addAttribute("Gimnasio", new Gimnasio());
        model.addAttribute("Servicio", new Servicio());
        return "gimnasioNuevo";
    }

    @PostMapping("/administrador/servicios/gimnasios/new/save")
    public String GimnasioGuardar(@ModelAttribute Gimnasio gimnasio, @ModelAttribute Servicio servicio) {
        servicioRepository.insertarServicio(servicio.getNombre(), tipo);
        BigInteger id = servicioRepository.darIdServicios();
        gimnasioRepository.insertarGimnasio(id, gimnasio.getCapacidad(), gimnasio.getHoraInicio().toString(), gimnasio.getHoraFin().toString(), gimnasio.getCostoAdicional());
        return "redirect:/administrador/servicios/gimnasios";
    }

    @GetMapping("/administrador/servicios/gimnasios/{id}/edit")
    public String GimnasioEditarForm(@PathVariable("id") Integer id, Model model) {
        Gimnasio gimnasio = gimnasioRepository.darGimnasio(id);
        Servicio servicio = servicioRepository. darServicio(id);
        if (gimnasio != null) {
            model.addAttribute("Gimnasio", gimnasio);
            model.addAttribute("Servicio", servicio);
            return "gimnasioEditar";
        } else {
            return "redirect:/administrador/servicios/gimnasios";
        }
    }

    @PostMapping("/administrador/servicios/gimnasios/{id}/edit/save")
    public String GimnasioEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Gimnasio gimnasio, @ModelAttribute Servicio servicio) {
        servicioRepository.actualizarServicio(id, servicio.getNombre(), tipo);
        gimnasioRepository.actualizarGimnasio(id, gimnasio.getCapacidad(), gimnasio.getHoraInicio().toString(), gimnasio.getHoraFin().toString(), gimnasio.getCostoAdicional());
        return "redirect:/administrador/servicios/gimnasios";
    }

    @GetMapping("/administrador/servicios/gimnasios/{id}/delete")
    public String GimnasioBorrar(@PathVariable("id") Integer id) {
        gimnasioRepository.eliminarGimnasio(id);
        servicioRepository.eliminarServicio(id);
        return "redirect:/administrador/servicios/gimnasios";
    }
}
