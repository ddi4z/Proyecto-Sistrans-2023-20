package uniandes.edu.co.proyecto.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import uniandes.edu.co.proyecto.modelo.Gimnasio;
import uniandes.edu.co.proyecto.modelo.MaquinaGimnasio;
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


    @GetMapping("/consultas/servicios/gimnasios")
    public String Gimnasios(Model model) {
        model.addAttribute("Gimnasios", gimnasioRepository.darGimnasios());
        return "gimnasios";
    }

    @GetMapping("/consultas/servicios/gimnasios/new")
    public String GimnasioForm(Model model) {
        model.addAttribute("Gimnasio", new Gimnasio());
        model.addAttribute("Servicio", new Servicio());
        return "gimnasioNuevo";
    }

    @PostMapping("/consultas/servicios/gimnasios/new/save")
    public String BarGuardar(@ModelAttribute Gimnasio gimnasio) {
        int id = servicioRepository.findTop1ByOrderByIdDesc().iterator().next().getId() + 1;
        gimnasio.setId(id);
        gimnasio.setTipo(tipo);
        gimnasio.setMaquinas(new ArrayList<MaquinaGimnasio>());
        servicioRepository.save(gimnasio);
        return "redirect:/consultas/servicios/gimnasios";
    }


    @GetMapping("/consultas/servicios/gimnasios/{id}/edit")
    public String GimnasioEditarForm(@PathVariable("id") Integer id, Model model) {
        Gimnasio gimnasio = gimnasioRepository.darGimnasio(id);

        if (gimnasio != null) {
            model.addAttribute("Gimnasio", gimnasio);
            return "gimnasioEditar";
        } else {
            return "redirect:/consultas/servicios/gimnasios";
        }
    }

    @PostMapping("/consultas/servicios/gimnasios/{id}/edit/save")
    public String GimnasioEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Gimnasio gimnasio, @ModelAttribute Servicio servicio) {
        gimnasioRepository.actualizarGimnasio(id, gimnasio.getNombre(), gimnasio.getCapacidad(), gimnasio.getHoraInicio().toString(), gimnasio.getHoraFin().toString(), gimnasio.getCostoAdicional());
        return "redirect:/consultas/servicios/gimnasios";
    }
 
    @GetMapping("/consultas/servicios/gimnasios/{id}/delete")
    public String GimnasioBorrar(@PathVariable("id") Integer id) {
        gimnasioRepository.deleteById(id);
        return "redirect:/consultas/servicios/gimnasios";
    }
}
