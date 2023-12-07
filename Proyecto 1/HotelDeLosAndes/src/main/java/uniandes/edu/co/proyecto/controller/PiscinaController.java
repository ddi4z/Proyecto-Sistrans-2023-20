package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.proyecto.modelo.Piscina;
import uniandes.edu.co.proyecto.repositorios.PiscinaRepository;

@Controller
public class PiscinaController {

    @Autowired
    private PiscinaRepository piscinaRepository;

    @GetMapping("/hotel/administrador/servicios/piscinas")
    public String Piscinas(Model model) {
        model.addAttribute("Piscinas", piscinaRepository.darPiscinas());
        return "piscinas";
    }

    @GetMapping("/hotel/administrador/servicios/piscinas/new")
    public String PiscinaForm(Model model) {
        model.addAttribute("Piscina", new Piscina());
        return "piscinaNueva";
    }

    @PostMapping("/hotel/administrador/servicios/piscinas/new/save")
    public String PiscinaGuardar(@ModelAttribute Piscina piscina) {
            piscinaRepository.insertarPiscina(piscina.getServicio().getNombre(), piscina.getCapacidad(), piscina.getProfundidad(), piscina.getHorainicio(), piscina.getHoraFin(), piscina.getCostoAdicional());
        return "redirect:/hotel/administrador/servicios/piscinas";
    }

    @GetMapping("/hotel/administrador/servicios/piscinas/{id}/edit")
    public String PiscinaEditarForm(@PathVariable("id") Integer id, Model model) {
        Piscina piscina = piscinaRepository.darPiscina(id);
        if (piscina != null) {
            model.addAttribute("piscina", piscina);
            return "piscinaEditar";
        } else {
            return "redirect:/hotel/administrador/servicios/piscinas";
        }
    }

    @PostMapping("/hotel/administrador/servicios/piscinas/{id}/edit/save")
    public String PiscinaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Piscina piscina) {
        piscinaRepository.actualizarPiscina(id, piscina.getServicio().getNombre(), piscina.getCapacidad(), piscina.getProfundidad(), piscina.getHorainicio(), piscina.getHoraFin(), piscina.getCostoAdicional());
        return "redirect:/hotel/administrador/servicios/piscinas";
    }

    @GetMapping("/hotel/administrador/piscinas/{id}/delete")
    public String PiscinaBorrar(@PathVariable("id") Integer id) {
        piscinaRepository.eliminarPiscina(id);
        return "redirect:/hotel/administrador/servicios/piscinas";
    }
}
