package uniandes.edu.co.proyecto.controller;



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


    @GetMapping("/consultas/servicios/piscinas")
    public String Piscinas(Model model) {
        model.addAttribute("Piscinas", piscinaRepository.darPiscinas());
        return "piscinas";
    }

    @GetMapping("/consultas/servicios/piscinas/new")
    public String PiscinaForm(Model model) {
        model.addAttribute("Piscina", new Piscina());
        model.addAttribute("Servicio", new Servicio());
        return "piscinaNueva";
    }
    @PostMapping("/consultas/servicios/piscinas/new/save")
    public String BarGuardar(@ModelAttribute Piscina piscina) {
        int id = servicioRepository.findTop1ByOrderByIdDesc().iterator().next().getId() + 1;
        piscina.setId(id);
        piscina.setTipo(tipo);
        servicioRepository.save(piscina);
        return "redirect:/consultas/servicios/piscinas";
    }
    @GetMapping("/consultas/servicios/piscinas/{id}/edit")
    public String PiscinaEditarForm(@PathVariable("id") Integer id, Model model) {
        Piscina piscina = piscinaRepository.darPiscina(id);
        if (piscina != null) {
            model.addAttribute("Piscina", piscina);
            return "piscinaEditar";
        } else {
            return "redirect:/consultas/servicios/piscinas";
        }
    }

    @PostMapping("/consultas/servicios/piscinas/{id}/edit/save")
    public String PiscinaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Piscina piscina, @ModelAttribute Servicio servicio) {

        piscinaRepository.actualizarPiscina(id, piscina.getNombre(),piscina.getCapacidad(), piscina.getProfundidad(), piscina.getHoraInicio().toString(), piscina.getHoraFin().toString(), piscina.getCostoAdicional());
        return "redirect:/consultas/servicios/piscinas";
    }

    @GetMapping("/consultas/servicios/piscinas/{id}/delete")
    public String PiscinaBorrar(@PathVariable("id") Integer id) {
        piscinaRepository.deleteById(id);
        return "redirect:/consultas/servicios/piscinas";
    }
}
