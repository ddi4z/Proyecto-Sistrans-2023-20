package uniandes.edu.co.proyecto.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import uniandes.edu.co.proyecto.modelo.SalonConferencia;
import uniandes.edu.co.proyecto.repositorios.SalonConferenciaRepository;
import uniandes.edu.co.proyecto.repositorios.ServicioRepository;

@Controller
public class SalonConferenciaController {
    private static final String tipo = "Salon de conferencia";

    @Autowired
    private SalonConferenciaRepository salonConferenciaRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/consultas/servicios/salonesConferencia")
    public String SalonesConferencia(Model model) {
        model.addAttribute("SalonesConferencia", salonConferenciaRepository.darSalonesConferencia());
        return "salonesConferencia";
    }

    @GetMapping("/consultas/servicios/salonesConferencia/new")
    public String SalonConferenciaForm(Model model) {
        model.addAttribute("salonConferencia", new SalonConferencia());
        return "salonConferenciaNuevo";
    }

    @PostMapping("/consultas/servicios/salonesConferencia/new/save")
    public String BarGuardar(@ModelAttribute SalonConferencia salonConferencia) {
        int id = servicioRepository.findTop1ByOrderByIdDesc().iterator().next().getId() + 1;
        salonConferencia.setId(id);
        salonConferencia.setTipo(tipo);
        servicioRepository.save(salonConferencia);
        return "redirect:/consultas/servicios/salonesConferencia";
    }

    @GetMapping("/consultas/servicios/salonesConferencia/{id}/edit")
    public String SalonConferenciaEditarForm(@PathVariable("id") Integer id, Model model) {
        SalonConferencia salonConferencia = salonConferenciaRepository.darSalonConferencia(id);
        if (salonConferencia != null) {
            model.addAttribute("salonConferencia", salonConferencia);
            return "salonConferenciaEditar";
        } else {
            return "redirect:/consultas/servicios/salonesConferencia";
        }
    }

    @PostMapping("/consultas/servicios/salonesConferencia/{id}/edit/save")
    public String SalonConferenciaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute SalonConferencia salonConferencia) {
        salonConferenciaRepository.actualizarSalonConferencia(id,salonConferencia.getNombre(),salonConferencia.getCapacidad(),salonConferencia.getCostoHora());
        return "redirect:/consultas/servicios/salonesConferencia";
    }

    @GetMapping("/consultas/servicios/salonesConferencia/{id}/delete")
    public String SalonConferenciaBorrar(@PathVariable("id") Integer id) {
        salonConferenciaRepository.deleteById(id);
        return "redirect:/consultas/servicios/salonesConferencia";
    }
}
