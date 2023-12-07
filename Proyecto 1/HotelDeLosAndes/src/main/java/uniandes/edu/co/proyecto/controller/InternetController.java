package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.proyecto.modelo.Internet;
import uniandes.edu.co.proyecto.repositorios.InternetRepository;

@Controller
public class InternetController {

    @Autowired
    private InternetRepository internetRepository;

    @GetMapping("/hotel/administrador/servicios/internets")
    public String Internets(Model model) {
        model.addAttribute("Internets", internetRepository.darInternets());
        return "internets";
    }

    @GetMapping("/hotel/administrador/servicios/internets/new")
    public String InternetForm(Model model) {
        model.addAttribute("Internet", new Internet());
        return "internetNuevo";
    }

    @PostMapping("/hotel/administrador/servicios/internets/new/save")
    public String InternetGuardar(@ModelAttribute Internet internet) {
        internetRepository.insertarInternet(internet.getServicio().getNombre(), internet.getCapacidad(), internet.getCostoDia());
        return "redirect:/hotel/administrador/servicios/internets";
    }

    @GetMapping("/hotel/administrador/servicios/internets/{id}/edit")
    public String InternetEditarForm(@PathVariable("id") Integer id, Model model) {
        Internet internet = internetRepository.darInternet(id);
        if (internet != null) {
            model.addAttribute("internet", internet);
            return "internetEditar";
        } else {
            return "redirect:/hotel/administrador/servicios/internets";
        }
    }

    @PostMapping("/hotel/administrador/servicios/internets/{id}/edit/save")
    public String InternetEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Internet internet) {
        internetRepository.actualizarInternet(id, internet.getServicio().getNombre(), internet.getCapacidad(), internet.getCostoDia());
        return "redirect:/hotel/administrador/servicios/internets";
    }

    @GetMapping("/hotel/administrador/servicios/internets/{id}/delete")
    public String InternetBorrar(@PathVariable("id") Integer id) {
        internetRepository.eliminarInternet(id);
        return "redirect:/hotel/administrador/servicios/internets";
    }
}
