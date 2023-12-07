package uniandes.edu.co.proyecto.controller;

import java.math.BigInteger;

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
    private static final String tipo = "ServicioLavanderia";

    @Autowired
    private ServicioLavanderiaRepository servicioLavanderiaRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/administrador/servicios/serviciosLavanderia")
    public String ServicioLavanderia(Model model) {
        model.addAttribute("ServiciosLavanderia", servicioLavanderiaRepository.darServiciosLavanderia());
        return "serviciosLavanderia";
    }

    @GetMapping("/administrador/servicios/serviciosLavanderia/new")
    public String ServicioLavanderiaForm(Model model) {
        model.addAttribute("ServicioLavanderia", new ServicioLavanderia());
        return "servicioLavanderiaNuevo";
    }

    @PostMapping("/administrador/servicios/serviciosLavanderia/new/save")
    public String ServicioLavanderiaGuardar(@ModelAttribute ServicioLavanderia servicioLavanderia) {
            servicioRepository.insertarServicio(servicioLavanderia.getServicio().getNombre(), tipo);
            BigInteger id = servicioRepository.darIdServicios();
            servicioLavanderiaRepository.insertarServicioLavanderia(id,servicioLavanderia.getCosto());
        return "redirect:/administrador/servicios/serviciosLavanderia";
    }

    @GetMapping("/administrador/servicios/serviciosLavanderia/{id}/edit")
    public String ServicioLavanderiaEditarForm(@PathVariable("id") Integer id, Model model) {
        ServicioLavanderia servicioLavanderia = servicioLavanderiaRepository.darServicioLavanderia(id);
        if (servicioLavanderia != null) {
            model.addAttribute("servicioLavanderia", servicioLavanderia);
            return "ServicioLavanderiaEditar";
        } else {
            return "redirect:/administrador/servicios/serviciosLavanderia";
        }
    }

    @PostMapping("/administrador/servicios/serviciosLavanderia/{id}/edit/save")
    public String ServicioLavanderiaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute ServicioLavanderia servicioLavanderia) {
        servicioRepository.actualizarServicio(id, servicioLavanderia.getServicio().getNombre(), tipo);
        servicioLavanderiaRepository.actualizarServicioLavanderia(id,servicioLavanderia.getCosto());
        return "redirect:/administrador/servicios/serviciosLavanderia";
    }

    @GetMapping("/administrador/serviciosLavanderia/{id}/delete")
    public String ServicioLavanderiaBorrar(@PathVariable("id") Integer id) {
        servicioLavanderiaRepository.eliminarServicioLavanderia(id);
        servicioRepository.eliminarServicio(id);
        return "redirect:/administrador/servicios/serviciosLavanderia";
    }
}
