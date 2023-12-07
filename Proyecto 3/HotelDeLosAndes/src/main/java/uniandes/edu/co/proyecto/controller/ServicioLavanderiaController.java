package uniandes.edu.co.proyecto.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.ServicioLavanderia;

import uniandes.edu.co.proyecto.repositorios.ServicioLavanderiaRepository;
import uniandes.edu.co.proyecto.repositorios.ServicioRepository;

@Controller
public class ServicioLavanderiaController {
    private static final String tipo = "Servicio lavanderia";

    @Autowired
    private ServicioLavanderiaRepository servicioLavanderiaRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/consultas/servicios/serviciosLavanderia")
    public String ServicioLavanderia(Model model) {
        model.addAttribute("ServiciosLavanderia", servicioLavanderiaRepository.darServiciosLavanderia());
        return "serviciosLavanderia";
    }

    @GetMapping("/consultas/servicios/serviciosLavanderia/new")
    public String ServicioLavanderiaForm(Model model) {
        model.addAttribute("servicioLavanderia", new ServicioLavanderia());
        return "servicioLavanderiaNuevo";
    }
    @PostMapping("/consultas/servicios/serviciosLavanderia/new/save")
    public String BarGuardar(@ModelAttribute ServicioLavanderia servicioLavanderia) {
        int id = servicioRepository.findTop1ByOrderByIdDesc().iterator().next().getId() + 1;
        servicioLavanderia.setId(id);
        servicioLavanderia.setTipo(tipo);
        servicioRepository.save(servicioLavanderia);
        return "redirect:/consultas/servicios/serviciosLavanderia";
    }
    @GetMapping("/consultas/servicios/serviciosLavanderia/{id}/edit")
    public String ServicioLavanderiaEditarForm(@PathVariable("id") Integer id, Model model) {
        ServicioLavanderia servicioLavanderia = servicioLavanderiaRepository.darServicioLavanderia(id);
        if (servicioLavanderia != null) {
            model.addAttribute("servicioLavanderia", servicioLavanderia);
            return "ServicioLavanderiaEditar";
        } else {
            return "redirect:/consultas/servicios/serviciosLavanderia";
        }
    }
    @PostMapping("/consultas/servicios/serviciosLavanderia/{id}/edit/save")
    public String ServicioLavanderiaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute ServicioLavanderia servicioLavanderia) {
        servicioLavanderiaRepository.actualizarServicioLavanderia(id,servicioLavanderia.getNombre(),servicioLavanderia.getCosto());
        return "redirect:/consultas/servicios/serviciosLavanderia";
    }

    @GetMapping("/consultas/servicios/serviciosLavanderia/{id}/delete")
    public String ServicioLavanderiaBorrar(@PathVariable("id") Integer id) {
        servicioLavanderiaRepository.deleteById(id);
        return "redirect:/consultas/servicios/serviciosLavanderia";
    }
}
