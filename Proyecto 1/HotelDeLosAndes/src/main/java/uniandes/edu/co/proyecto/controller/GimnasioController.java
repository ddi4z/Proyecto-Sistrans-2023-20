package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.proyecto.modelo.Gimnasio;
import uniandes.edu.co.proyecto.repositorios.GimnasioRepository;

@Controller
public class GimnasioController {

    @Autowired
    private GimnasioRepository gimnasioRepository;

    @GetMapping("/hotel/administrador/servicios/gimnasios")
    public String Gimnasios(Model model) {
        model.addAttribute("Gimnasios", gimnasioRepository.darGimnasios());
        return "gimnasios";
    }

    @GetMapping("/hotel/administrador/servicios/gimnasios/new")
    public String GimnasioForm(Model model) {
        model.addAttribute("Gimnasio", new Gimnasio());
        return "gimnasioNuevo";
    }

    @PostMapping("/hotel/administrador/servicios/gimnasios/new/save")
    public String GimnasioGuardar(@ModelAttribute Gimnasio gimnasio) {
        gimnasioRepository.insertarGimnasio(gimnasio.getServicio().getNombre(), gimnasio.getCapacidad(), gimnasio.getHoraInicio(), gimnasio.getHoraFin(), gimnasio.getcostoAdicional());
        return "redirect:/hotel/administrador/servicios/gimnasios";
    }

    @GetMapping("/hotel/administrador/gimnasios/{id}/edit")
    public String GimnasioEditarForm(@PathVariable("id") Integer id, Model model) {
        Gimnasio gimnasio = gimnasioRepository.darGimnasio(id);
        if (gimnasio != null) {
            model.addAttribute("gimnasio", gimnasio);
            return "gimnasioEditar";
        } else {
            return "redirect:/hotel/administrador/servicios/gimnasios";
        }
    }

    @PostMapping("/hotel/administrador/servicios/gimnasios/{id}/edit/save")
    public String GimnasioEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Gimnasio gimnasio) {
        gimnasioRepository.actualizarGimnasio(id, gimnasio.getServicio().getNombre(), gimnasio.getCapacidad(), gimnasio.getHoraInicio(), gimnasio.getHoraFin(), gimnasio.getcostoAdicional());
        return "redirect:/hotel/administrador/servicios/gimnasios";
    }

    @GetMapping("/hotel/administrador/servicios/gimnasios/{id}/delete")
    public String GimnasioBorrar(@PathVariable("id") Integer id) {
        gimnasioRepository.eliminarGimnasio(id);
        return "redirect:/hotel/administrador/servicios/gimnasios";
    }
}
