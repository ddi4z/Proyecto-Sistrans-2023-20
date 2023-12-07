package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.repositorios.ReservaRepository;


public class ReservaController {
    @Autowired
    private ReservaRepository reservaRepository;



    @GetMapping("/hotel/administrador/reservas")
    public String usuarios(Model model){
        model.addAttribute("reservas", reservaRepository.darReservas());
        return "reservas";
    }

    @GetMapping("/hotel/administrador/reservas/new")
    public String usuarioForm(Model model) {
        model.addAttribute("usuario", new Reserva());
        return "reservaNueva";
    }

    @PostMapping("/hotel/administrador/reservas/new/save")
    public String usuarioGuardar(@ModelAttribute Reserva reserva) {
        reservaRepository.insertarReserva(reserva.getFechaEntrada(), reserva.getFechaSalida(), reserva.getNoches(), reserva.getNumeroPersonas(), reserva.getCheckIn() ? 1 : 0, reserva.getCheckOut() ? 1 : 0, reserva.getPlanConsumo().getId(), reserva.getUsuario().getNumDocumento());
        return "redirect:/reservas";
    }

    @GetMapping("/hotel/administrador/usuarios/{id}/edit")
    public String usuarioEditarForm(@PathVariable("id") int id, Model model) {
        Reserva reserva = reservaRepository.darReserva(((int) id));
        if (reserva != null) {
            model.addAttribute("reserva", reserva);
            return "reservaEditar";
        } else {
            return "redirect:/hotel/administrador/reservas";
        }
    }

    @PostMapping("/hotel/administrador/reservas/{id}/edit/save")
    public String reservaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Reserva reserva) {
        reservaRepository.actualizarReserva((id), reserva.getFechaEntrada(), reserva.getFechaSalida(), reserva.getNoches(), reserva.getNumeroPersonas(), reserva.getCheckIn() ? 1 : 0, reserva.getCheckOut() ? 1 : 0 , reserva.getPlanConsumo().getId(), reserva.getUsuario().getNumDocumento());
        return "redirect:/reservas";
    }

    @GetMapping("/hotel/administrador/reservas/{id}/delete")
    public String reservaBorrar(@PathVariable("id") Integer id) {
        reservaRepository.eliminarReserva((id));
        return "redirect:/hotel/administrador/reservas";
    }
}
