package uniandes.edu.co.proyecto.controller;


import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.proyecto.modelo.Bar;

import uniandes.edu.co.proyecto.modelo.Producto;
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



    @GetMapping("/consultas/servicios/bares")
    public String Bares(Model model) {
        model.addAttribute("Bares", barRepository.darBares());
        return "bares";
    }

    @GetMapping("/consultas/servicios/bares/new")
    public String BarForm(Model model) {
        model.addAttribute("Bar", new Bar());
        model.addAttribute("estilos", barRepository.obtenerEstilosDistintos());
        return "barNuevo";
    }

    @PostMapping("/consultas/servicios/bares/new/save")
    public String BarGuardar(@ModelAttribute Bar bar) {
        int id = servicioRepository.findTop1ByOrderByIdDesc().iterator().next().getId() + 1;
        bar.setId(id);
        bar.setTipo(tipo);
        bar.setProductos(new ArrayList<Producto>());
        servicioRepository.save(bar);
        return "redirect:/consultas/servicios/bares";
    }


    @GetMapping("/consultas/servicios/bares/{id}/edit")
    public String BarEditarForm(@PathVariable("id") Integer id, Model model) {
        Bar bar = barRepository.darBar(id);
        if (bar != null) {
            model.addAttribute("Bar", bar);
            model.addAttribute("estilos", barRepository.obtenerEstilosDistintos());
            return "barEditar";
        } else {
            return "redirect:/consultas/servicios/bares";
        }
    }

    @PostMapping("/consultas/servicios/bares/{id}/edit/save")
    public String BarEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Bar bar, @ModelAttribute Servicio servicio) {
        barRepository.actualizarBar(id, bar.getNombre(),bar.getCapacidad(), bar.getEstilo());
        return "redirect:/consultas/servicios/bares";
    }

    @GetMapping("/consultas/servicios/bares/{id}/delete")
    public String BarBorrar(@PathVariable("id") Integer id) {
        barRepository.deleteById(id);
        return "redirect:/consultas/servicios/bares";
    }
}
