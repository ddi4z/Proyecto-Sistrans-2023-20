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

    @GetMapping("/hotel/cliente/reservas/servicios/reservasSpa")
    public String ReservaSpa(Model model) {
        model.addAttribute("reservasSpa", reservaSpaRepository.darReservasSpa());
        return "reservaSpa";
    }

    @GetMapping("/hotel/cliente/reservas/servicios/reservasSpa/new")
    public String ReservaSpaForm(Model model) {
        model.addAttribute("reservasSpa", new ReservaSpa());
        return "reservaSpaNueva";
    }

    @PostMapping("/hotel/cliente/reservas/servicios/reservasSpa/new/save")
    public String ReservaSpaGuardar(@ModelAttribute ReservaSpa reservaSpa) {
        reservaSpaRepository.insertarReservaSpa(reservaSpa.getHoraInicio(), reservaSpa.getHoraFin(), reservaSpa.getCosto(), reservaSpa.getSpa().getId());
        return "redirect:/hotel/cliente/reservas/servicios/reservasSpa";
    }

    @GetMapping("/hotel/cliente/reservas/servicios/reservasSpa/{id}/edit")
    public String ReservaSpaEditarForm(@PathVariable("id") Integer id, Model model) {
        ReservaSpa reservaSpa = reservaSpaRepository.darReservaSpa(id);
        if (reservaSpa != null) {
            model.addAttribute("reservaSpa", reservaSpa);
            return "ReservaSpaEditar";
        } else {
            return "redirect:/hotel/cliente/reservas/servicios/reservasSpa";
        }
    }

    @PostMapping("/hotel/cliente/reservas/servicios/reservasSpa/{id}/edit/save")
    public String ReservaSpaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute ReservaSpa reservaSpa) {
        reservaSpaRepository.actualizarReservaSpa(id, reservaSpa.getHoraInicio(), reservaSpa.getHoraFin(), reservaSpa.getCosto(), reservaSpa.getSpa().getId());
        return "redirect:/hotel/cliente/reservas/servicios/reservasSpa";
    }

    @GetMapping("/hotel/cliente/reservas/reservasSpa/{id}/delete")
    public String ReservaSpaBorrar(@PathVariable("id") Integer id) {
        reservaSpaRepository.eliminarReservaSpa(id);
        return "redirect:/hotel/cliente/reservas/servicios/reservasSpa";
    }
}
