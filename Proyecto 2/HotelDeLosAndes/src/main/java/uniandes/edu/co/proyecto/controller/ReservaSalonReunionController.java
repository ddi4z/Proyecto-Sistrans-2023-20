package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.ReservaSalonReunion;
import uniandes.edu.co.proyecto.repositorios.ReservaSalonReunionRepository;

@Controller
public class ReservaSalonReunionController {
    @Autowired
    private ReservaSalonReunionRepository reservaSalonReunionRepository;

    @GetMapping("/cliente/reservasSalonReunion")
    public String ReservaSalonReunion(Model model) {
        model.addAttribute("reservaSalonReunion", reservaSalonReunionRepository.darReservasSalonReunion());
        return "reservasSalonReunion";
    }

    @GetMapping("/cliente/reservasSalonReunion/new")
    public String ReservaSalonReunionForm(Model model) {
        model.addAttribute("ReservaSalonReunion", new ReservaSalonReunion());
        return "reservaSalonReunionNueva";
    }

    @PostMapping("/cliente/reservasSalonReunion/new/save")
    public String ReservaSalonReunionGuardar(@ModelAttribute ReservaSalonReunion reservaSalonReunion) {
            reservaSalonReunionRepository.insertarReservaSalonReunion(reservaSalonReunion.getHoraInicio().toString().replace('T', ' '), reservaSalonReunion.getDuracion(), reservaSalonReunion.getCosto(), reservaSalonReunion.getHoraFinLimpieza().toString().replace('T', ' '), reservaSalonReunion.getSalon().getId(), reservaSalonReunion.getUsuario().getNumDocumento());
        return "redirect:/cliente/reservasSalonReunion";
    }

    @GetMapping("/cliente/reservasSalonReunion/{id}/edit")
    public String ReservaSalonReunionEditarForm(@PathVariable("id") Integer id, Model model) {
        ReservaSalonReunion reservaSalonReunion = reservaSalonReunionRepository.darReservaSalonReunion(id);
        if (reservaSalonReunion != null) {
            model.addAttribute("reservaSalonReunion", reservaSalonReunion);
            return "ReservaSalonReunionEditar";
        } else {
            return "redirect:/cliente/reservasSalonReunion";
        }
    }

    @PostMapping("/cliente/reservasSalonReunion/{id}/edit/save")
    public String ReservaSalonReunionEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute ReservaSalonReunion reservaSalonReunion) {
        reservaSalonReunionRepository.actualizarReservaSalonReunion(id, reservaSalonReunion.getHoraInicio().toString().replace('T', ' '), reservaSalonReunion.getDuracion(), reservaSalonReunion.getCosto(), reservaSalonReunion.getHoraFinLimpieza().toString().replace('T', ' '), reservaSalonReunion.getSalon().getId(), reservaSalonReunion.getUsuario().getNumDocumento());
        return "redirect:/cliente/reservasSalonReunion";
    }

    @GetMapping("/cliente/reservasSalonReunion/{id}/delete")
    public String ReservaSalonReunionBorrar(@PathVariable("id") Integer id) {
        reservaSalonReunionRepository.eliminarReservaSalonReunion(id);
        return "redirect:/cliente/reservasSalonReunion";
    }
}
