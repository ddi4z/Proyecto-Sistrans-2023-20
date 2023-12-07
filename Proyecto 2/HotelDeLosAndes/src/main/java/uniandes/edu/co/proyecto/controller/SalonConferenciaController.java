package uniandes.edu.co.proyecto.controller;

import java.math.BigInteger;

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
    private static final String tipo = "SalonConferencia";

    @Autowired
    private SalonConferenciaRepository salonConferenciaRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/administrador/servicios/salonesConferencia")
    public String SalonesConferencia(Model model) {
        model.addAttribute("SalonesConferencia", salonConferenciaRepository.darSalonesConferencia());
        return "salonesConferencia";
    }

    @GetMapping("/administrador/servicios/salonesConferencia/new")
    public String SalonConferenciaForm(Model model) {
        model.addAttribute("SalonConferencia", new SalonConferencia());
        return "salonConferenciaNuevo";
    }

    @PostMapping("/administrador/servicios/salonesConferencia/new/save")
    public String SalonConferenciaGuardar(@ModelAttribute SalonConferencia salonConferencia) {
        servicioRepository.insertarServicio(salonConferencia.getServicio().getNombre(), tipo);
        BigInteger id = servicioRepository.darIdServicios();
        salonConferenciaRepository.insertarSalonConferencia(id,salonConferencia.getCapacidad(),salonConferencia.getCostoHora());
        return "redirect:/administrador/salonesConferencia";
    }

    @GetMapping("/administrador/servicios/salonesConferencia/{id}/edit")
    public String SalonConferenciaEditarForm(@PathVariable("id") Integer id, Model model) {
        SalonConferencia salonConferencia = salonConferenciaRepository.darSalonConferencia(id);
        if (salonConferencia != null) {
            model.addAttribute("salonConferencia", salonConferencia);
            return "salonConferenciaEditar";
        } else {
            return "redirect:/administrador/salonesConferencia";
        }
    }

    @PostMapping("/administrador/servicios/salonesConferencia/{id}/edit/save")
    public String SalonConferenciaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute SalonConferencia salonConferencia) {
        servicioRepository.actualizarServicio(id, salonConferencia.getServicio().getNombre(), tipo);
        salonConferenciaRepository.actualizarSalonConferencia(id,salonConferencia.getCapacidad(),salonConferencia.getCostoHora());
        return "redirect:/administrador/salonesConferencia";
    }

    @GetMapping("/administrador/servicios/salonesConferencia/{id}/delete")
    public String SalonConferenciaBorrar(@PathVariable("id") Integer id) {
        salonConferenciaRepository.eliminarSalonConferencia(id);
        servicioRepository.eliminarServicio(id);
        return "redirect:/administrador/servicios/salonesConferencia";
    }
}
