package uniandes.edu.co.proyecto.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import uniandes.edu.co.proyecto.modelo.SalonReunion;
import uniandes.edu.co.proyecto.repositorios.SalonReunionRepository;
import uniandes.edu.co.proyecto.repositorios.ServicioRepository;

@Controller
public class SalonReunionController {
    private static final String tipo = "Salon de reunion";

    @Autowired
    private SalonReunionRepository salonReunionRepository;

    @Autowired
    private ServicioRepository servicioRepository;
    
    @GetMapping("/consultas/servicios/salonesReunion")
    public String SalonesReunion(Model model) {
        model.addAttribute("SalonesReunion", salonReunionRepository.darSalonesReunion());
        return "salonesReunion";
    }

    @GetMapping("/consultas/servicios/salonesReunion/new")
    public String SalonReunionForm(Model model) {
        model.addAttribute("salonReunion", new SalonReunion());
        return "salonReunionNuevo";
    }
    @PostMapping("/consultas/servicios/salonesReunion/new/save")
    public String BarGuardar(@ModelAttribute SalonReunion salonReunion) {
        int id = servicioRepository.findTop1ByOrderByIdDesc().iterator().next().getId() + 1;
        salonReunion.setId(id);
        salonReunion.setTipo(tipo);
        servicioRepository.save(salonReunion);
        return "redirect:/consultas/servicios/salonesReunion";
    }

    @GetMapping("/consultas/servicios/salonesReunion/{id}/edit")
    public String SalonReunionEditarForm(@PathVariable("id") Integer id, Model model) {
        SalonReunion salonReunion = salonReunionRepository.darSalonReunion(id);
        if (salonReunion != null) {
            model.addAttribute("salonReunion", salonReunion);
            return "salonReunionEditar";
        } else {
            return "redirect:/consultas/servicios/salonesReunion";
        }
    }

    @PostMapping("/consultas/servicios/salonesReunion/{id}/edit/save")
    public String SalonReunionEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute SalonReunion salonReunion) {
        salonReunionRepository.actualizarSalonReunion(id, salonReunion.getNombre(),salonReunion.getCapacidad(),salonReunion.getCostoHora(),salonReunion.getCostoEquipos());
        return "redirect:/consultas/servicios/salonesReunion";
    }
 
    @GetMapping("/consultas/servicios/salonesReunion/{id}/delete")
    public String SalonReunionBorrar(@PathVariable("id") Integer id) {
        salonReunionRepository.deleteById(id);
        return "redirect:/consultas/servicios/salonesReunion";
    }
}
