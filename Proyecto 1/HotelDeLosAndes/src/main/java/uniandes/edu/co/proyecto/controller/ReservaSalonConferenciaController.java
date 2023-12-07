package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.ReservaSalonConferencia;
import uniandes.edu.co.proyecto.repositorios.ReservaSalonConferenciaRepository;

@Controller
public class ReservaSalonConferenciaController {
    @Autowired
    private ReservaSalonConferenciaRepository reservaSalonConferenciaRepository;

    @GetMapping("/hotel/cliente/reservas/servicios/reservasSalonConferencia")
    public String ReservaSalonConferencia(Model model) {
        model.addAttribute("reservaSalonConferencia", reservaSalonConferenciaRepository.darReservasSalonConferencia());
        return "reservaSalonConferencia";
    }

    @GetMapping("/hotel/cliente/reservas/servicios/reservasSalonConferencia/new")
    public String ReservaSalonConferenciaForm(Model model) {
        model.addAttribute("reservasSalonConferencia", new ReservaSalonConferencia());
        return "reservaSalonConferenciaNueva";
    }

    @PostMapping("/hotel/cliente/reservas/servicios/reservasSalonConferencia/new/save")
    public String ReservaSalonConferenciaGuardar(@ModelAttribute ReservaSalonConferencia reservaSalonConferencia) {
            reservaSalonConferenciaRepository.insertarReservaSalonConferencia(reservaSalonConferencia.getHoraInicio(), reservaSalonConferencia.getDuracion(), reservaSalonConferencia.getCosto(), reservaSalonConferencia.getHorafinLimpieza(), reservaSalonConferencia.getSalon().getId());
        return "redirect:/hotel/cliente/reservas/servicios/reservasSalonConferencia";
    }

    @GetMapping("/hotel/cliente/reservas/servicios/reservasSalonConferencia/{id}/edit")
    public String ReservaSalonConferenciaEditarForm(@PathVariable("id") Integer id, Model model) {
        ReservaSalonConferencia reservaSalonConferencia = reservaSalonConferenciaRepository.darReservaSalonConferencia(id);
        if (reservaSalonConferencia != null) {
            model.addAttribute("reservaSalonConferencia", reservaSalonConferencia);
            return "ReservaSalonConferenciaEditar";
        } else {
            return "redirect:/hotel/cliente/reservas/servicios/reservasSalonConferencia";
        }
    }

    @PostMapping("/hotel/cliente/reservas/servicios/reservasSalonConferencia/{id}/edit/save")
    public String ReservaSalonConferenciaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute ReservaSalonConferencia reservaSalonConferencia) {
        reservaSalonConferenciaRepository.actualizarReservaSalonConferencia(id, reservaSalonConferencia.getHoraInicio(), reservaSalonConferencia.getDuracion(), reservaSalonConferencia.getCosto(), reservaSalonConferencia.getHorafinLimpieza(), reservaSalonConferencia.getSalon().getId());
        return "redirect:/hotel/cliente/reservas/servicios/reservasSalonConferencia";
    }

    @GetMapping("/hotel/cliente/reservas/reservasSalonConferencia/{id}/delete")
    public String ReservaSalonConferenciaBorrar(@PathVariable("id") Integer id) {
        reservaSalonConferenciaRepository.eliminarReservaSalonConferencia(id);
        return "redirect:/hotel/cliente/reservas/servicios/reservasSalonConferencia";
    }
}
