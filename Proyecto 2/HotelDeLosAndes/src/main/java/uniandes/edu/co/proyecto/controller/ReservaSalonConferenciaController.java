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

    @GetMapping("/cliente/reservasSalonConferencia")
    public String ReservaSalonConferencia(Model model) {
        model.addAttribute("reservaSalonConferencia", reservaSalonConferenciaRepository.darReservasSalonConferencia());
        return "reservasSalonConferencia";
    }

    @GetMapping("/cliente/reservasSalonConferencia/new")
    public String ReservaSalonConferenciaForm(Model model) {
        model.addAttribute("ReservaSalonConferencia", new ReservaSalonConferencia());
        return "reservaSalonConferenciaNueva";
    }

    @PostMapping("/cliente/reservasSalonConferencia/new/save")
    public String ReservaSalonConferenciaGuardar(@ModelAttribute ReservaSalonConferencia reservaSalonConferencia) {
            reservaSalonConferenciaRepository.insertarReservaSalonConferencia(reservaSalonConferencia.getHoraInicio().toString().replace('T', ' '), reservaSalonConferencia.getDuracion(), reservaSalonConferencia.getCosto(), reservaSalonConferencia.getHoraFinLimpieza().toString().replace('T', ' '), reservaSalonConferencia.getSalon().getId(),reservaSalonConferencia.getUsuario().getNumDocumento());
        return "redirect:/cliente/reservasSalonConferencia";
    }

    @GetMapping("/cliente/reservasSalonConferencia/{id}/edit")
    public String ReservaSalonConferenciaEditarForm(@PathVariable("id") Integer id, Model model) {
        ReservaSalonConferencia reservaSalonConferencia = reservaSalonConferenciaRepository.darReservaSalonConferencia(id);
        if (reservaSalonConferencia != null) {
            model.addAttribute("reservaSalonConferencia", reservaSalonConferencia);
            return "ReservaSalonConferenciaEditar";
        } else {
            return "redirect:/cliente/reservasSalonConferencia";
        }
    }

    @PostMapping("/cliente/reservasSalonConferencia/{id}/edit/save")
    public String ReservaSalonConferenciaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute ReservaSalonConferencia reservaSalonConferencia) {
        reservaSalonConferenciaRepository.actualizarReservaSalonConferencia(id, reservaSalonConferencia.getHoraInicio().toString().replace('T', ' '), reservaSalonConferencia.getDuracion(), reservaSalonConferencia.getCosto(), reservaSalonConferencia.getHoraFinLimpieza().toString().replace('T', ' '), reservaSalonConferencia.getSalon().getId(),reservaSalonConferencia.getUsuario().getNumDocumento());
        return "redirect:/cliente/reservasSalonConferencia";
    }

    @GetMapping("/cliente/reservasSalonConferencia/{id}/delete")
    public String ReservaSalonConferenciaBorrar(@PathVariable("id") Integer id) {
        reservaSalonConferenciaRepository.eliminarReservaSalonConferencia(id);
        return "redirect:/cliente/reservasSalonConferencia";
    }
}
