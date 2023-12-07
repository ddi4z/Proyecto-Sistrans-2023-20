package uniandes.edu.co.proyecto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.proyecto.modelo.Internet;
import uniandes.edu.co.proyecto.modelo.Servicio;
import uniandes.edu.co.proyecto.repositorios.InternetRepository;
import uniandes.edu.co.proyecto.repositorios.ServicioRepository;

@Controller
public class InternetController {
    private static final String tipo = "Internet";

    @Autowired
    private InternetRepository internetRepository;
    @Autowired
    private ServicioRepository servicioRepository;


    @GetMapping("/consultas/servicios/internets")
    public String Internets(Model model) {
        model.addAttribute("Internets", internetRepository.darInternets());
        return "internets";
    }

    @GetMapping("/consultas/servicios/internets/new")
    public String InternetForm(Model model) {
        model.addAttribute("Internet", new Internet());
        model.addAttribute("Servicio", new Servicio());
        return "internetNuevo";
    }

    @PostMapping("/consultas/servicios/internets/new/save")
    public String BarGuardar(@ModelAttribute Internet internet) {
        int id = servicioRepository.findTop1ByOrderByIdDesc().iterator().next().getId() + 1;
        internet.setId(id);
        internet.setTipo(tipo);
        servicioRepository.save(internet);
        return "redirect:/consultas/servicios/internets";
    }
    @GetMapping("/consultas/servicios/internets/{id}/edit")
    public String InternetEditarForm(@PathVariable("id") Integer id, Model model) {
        Internet internet = internetRepository.darInternet(id);
        if (internet != null) {
            model.addAttribute("Internet", internet);

            return "internetEditar";
        } else {
            return "redirect:/consultas/servicios/internets";
        }
    }

    @PostMapping("/consultas/servicios/internets/{id}/edit/save")
    public String InternetEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Internet internet, @ModelAttribute Servicio servicio) {
        internetRepository.actualizarInternet(id , internet.getNombre(), internet.getCapacidad(), internet.getCostoDia());
        return "redirect:/consultas/servicios/internets";
    }

    @GetMapping("/consultas/servicios/internets/{id}/delete")
    public String InternetBorrar(@PathVariable("id") Integer id) {
        internetRepository.deleteById(id);
        return "redirect:/consultas/servicios/internets";
    }
}
