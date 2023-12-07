package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.ReservaSpa;
import uniandes.edu.co.proyecto.repositorios.ReservaSpaRepository;

@Controller
public class ReservaSpaControlller {
    @Autowired
    private ReservaSpaRepository reservaSpaRepository;

    @GetMapping("/cliente/reservasSpa")
    public String ReservaSpa(Model model) {
        model.addAttribute("ReservasSpa", reservaSpaRepository.darReservasSpa());
        return "reservasSpa";
    }

    @GetMapping("/cliente/reservasSpa/new")
    public String ReservaSpaForm(Model model) {
        model.addAttribute("ReservaSpa", new ReservaSpa());
        return "reservaSpaNueva";
    }

    @PostMapping("/cliente/reservasSpa/new/save")
    public String ReservaSpaGuardar(@ModelAttribute ReservaSpa reservaSpa) {
        reservaSpaRepository.insertarReservaSpa(reservaSpa.getHoraInicio().toString().replace('T', ' '), reservaSpa.getHoraFin().toString().replace('T', ' '), reservaSpa.getCosto(), reservaSpa.getSpa().getId(),reservaSpa.getUsuario().getNumDocumento());
        return "redirect:/cliente/reservasSpa";
    }

    @GetMapping("/cliente/reservasSpa/{id}/edit")
    public String ReservaSpaEditarForm(@PathVariable("id") Integer id, Model model) {
        ReservaSpa reservaSpa = reservaSpaRepository.darReservaSpa(id);
        if (reservaSpa != null) {
            model.addAttribute("ReservaSpa", reservaSpa);
            return "ReservaSpaEditar";
        } else {
            return "redirect:/cliente/reservasSpa";
        }
    }

    @PostMapping("/cliente/reservasSpa/{id}/edit/save")
    public String ReservaSpaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute ReservaSpa reservaSpa) {
        reservaSpaRepository.actualizarReservaSpa(id, reservaSpa.getHoraInicio().toString().replace('T', ' '), reservaSpa.getHoraFin().toString().replace('T', ' '), reservaSpa.getCosto(), reservaSpa.getSpa().getId(),reservaSpa.getUsuario().getNumDocumento());
        return "redirect:/cliente/reservas/reservasSpa";
    }

    @GetMapping("/cliente/reservasSpa/{id}/delete")
    public String ReservaSpaBorrar(@PathVariable("id") Integer id) {
        reservaSpaRepository.eliminarReservaSpa(id);
        return "redirect:/cliente/reservasSpa";
    }
}
