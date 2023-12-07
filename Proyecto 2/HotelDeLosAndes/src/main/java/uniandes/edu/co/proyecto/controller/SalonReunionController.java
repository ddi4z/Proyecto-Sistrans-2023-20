package uniandes.edu.co.proyecto.controller;

import java.math.BigInteger;

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
    private static final String tipo = "SalonReunion";

    @Autowired
    private SalonReunionRepository salonReunionRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/administrador/servicios/salonesReunion")
    public String SalonesReunion(Model model) {
        model.addAttribute("SalonesReunion", salonReunionRepository.darSalonesReunion());
        return "salonesReunion";
    }

    @GetMapping("/administrador/servicios/salonesReunion/new")
    public String SalonReunionForm(Model model) {
        model.addAttribute("SalonReunion", new SalonReunion());
        return "salonReunionNuevo";
    }

    @PostMapping("/administrador/servicios/salonesReunion/new/save")
    public String SalonReunionGuardar(@ModelAttribute SalonReunion salonReunion) {
        servicioRepository.insertarServicio(salonReunion.getServicio().getNombre(), tipo);
        BigInteger id = servicioRepository.darIdServicios();
        salonReunionRepository.insertarSalonReunion(id,salonReunion.getCapacidad(),salonReunion.getCostoHora(),salonReunion.getCostoEquipos());
        return "redirect:/administrador/salonesReunion";
    }

    @GetMapping("/administrador/servicios/salonesReunion/{id}/edit")
    public String SalonReunionEditarForm(@PathVariable("id") Integer id, Model model) {
        SalonReunion salonReunion = salonReunionRepository.darSalonReunion(id);
        if (salonReunion != null) {
            model.addAttribute("salonReunion", salonReunion);
            return "salonReunionEditar";
        } else {
            return "redirect:/administrador/salonesReunion";
        }
    }

    @PostMapping("/administrador/servicios/salonesReunion/{id}/edit/save")
    public String SalonReunionEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute SalonReunion salonReunion) {
        servicioRepository.actualizarServicio(id, salonReunion.getServicio().getNombre(), tipo);
        salonReunionRepository.actualizarSalonReunion(id, salonReunion.getCapacidad(),salonReunion.getCostoHora(),salonReunion.getCostoEquipos());
        return "redirect:/administrador/salonesReunion";
    }

    @GetMapping("/administrador/servicios/salonesReunion/{id}/delete")
    public String SalonReunionBorrar(@PathVariable("id") Integer id) {
        salonReunionRepository.eliminarSalonReunion(id);
        servicioRepository.eliminarServicio(id);
        return "redirect:/administrador/servicios/salonesReunion";
    }
}
