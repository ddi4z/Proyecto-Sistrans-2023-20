package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.proyecto.modelo.Bar;
import uniandes.edu.co.proyecto.repositorios.BarRepository;

@Controller
public class BarController {

    @Autowired
    private BarRepository barRepository;

    @GetMapping("/hotel/administrador/servicios/bares")
    public String Bares(Model model) {
        model.addAttribute("Bares", barRepository.darBares());
        return "bares";
    }

    @GetMapping("/hotel/administrador/servicios/bares/new")
    public String BarForm(Model model) {
        model.addAttribute("Bar", new Bar());
        return "barNuevo";
    }

    @PostMapping("/hotel/administrador/servicios/bares/new/save")
    public String BarGuardar(@ModelAttribute Bar bar) {
        barRepository.insertarBar(bar.getServicio().getNombre(), bar.getCapacidad(), bar.getEstilo());
        return "redirect:/hotel/administrador/servicios/bares";
    }

    @GetMapping("/hotel/administrador/servicios/bares/{id}/edit")
    public String BarEditarForm(@PathVariable("id") Integer id, Model model) {
        Bar bar = barRepository.darBar(id);
        if (bar != null) {
            model.addAttribute("bar", bar);
            return "barEditar";
        } else {
            return "redirect:/hotel/administrador/servicios/bares";
        }
    }

    @PostMapping("/hotel/administrador/bares/{id}/edit/save")
    public String BarEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Bar bar) {
        barRepository.actualizarBar(id, bar.getServicio().getNombre(), bar.getCapacidad(), bar.getEstilo());
        return "redirect:/hotel/administrador/servicios/bares";
    }

    @GetMapping("/hotel/administrador/bares/{id}/delete")
    public String BarBorrar(@PathVariable("id") Integer id) {
        barRepository.eliminarBar(id);
        return "redirect:/hotel/administrador/servicios/bares";
    }
}
