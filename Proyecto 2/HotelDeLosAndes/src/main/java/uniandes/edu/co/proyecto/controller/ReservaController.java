package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.repositorios.ReservaRepository;
import uniandes.edu.co.proyecto.repositorios.UsuarioRepository;
import uniandes.edu.co.proyecto.repositorios.PlanConsumoRepository;


@Controller
public class ReservaController {
    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PlanConsumoRepository planConsumoRepository;



    @GetMapping("/cliente/alojamientos")
    public String usuarios(Model model){
        model.addAttribute("Reservas", reservaRepository.darReservas());
        return "reservas";
    }

    @GetMapping("/recepcionista/llegadas")
    public String usuariosLlegada(Model model){
        model.addAttribute("Reservas", reservaRepository.darReservas());
        return "llegadas";
    }

    @GetMapping("/recepcionista/salidas")
    public String usuariosSalida(Model model){
        model.addAttribute("Reservas", reservaRepository.darReservas());
        return "salidas";
    }
    
    @GetMapping("/cliente/alojamientos/new")
    public String usuarioForm(Model model) {
        model.addAttribute("reserva", new Reserva());
        model.addAttribute("usuarios", usuarioRepository.darUsuarios());
        model.addAttribute("planesConsumo", planConsumoRepository.darPlanesConsumo());
        return "reservaNueva";
    }

    @PostMapping("/cliente/alojamientos/new/save")
    public String usuarioGuardar(@ModelAttribute Reserva reserva) {
        reservaRepository.insertarReserva(reserva.getFechaEntrada().toString(), reserva.getFechaSalida().toString(), reserva.getNoches(), reserva.getNumeroPersonas(), reserva.getPlanConsumo().getId(), reserva.getUsuario().getNumDocumento());
        return "redirect:/alojamientos";
    }

    @GetMapping("/cliente/alojamientos/{id}/edit")
    public String reservaEditarForm(@PathVariable("id") int id, Model model) {
        Reserva reserva = reservaRepository.darReserva(((int) id));
        if (reserva != null) {
            model.addAttribute("reserva", reserva);
            model.addAttribute("usuarios", usuarioRepository.darUsuarios());
            model.addAttribute("planesConsumo", planConsumoRepository.darPlanesConsumo());
            return "reservaEditar";
        } else {
            return "redirect:/cliente/alojamientos";
        }
    }

    @PostMapping("/cliente/alojamientos/{id}/edit/save")
    public String reservaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Reserva reserva) {
        reservaRepository.actualizarReserva((id), reserva.getFechaEntrada().toString(), reserva.getFechaSalida().toString(), reserva.getNoches(), reserva.getNumeroPersonas(), reserva.getCheckIn() ? 1 : 0, reserva.getCheckOut() ? 1 : 0 , reserva.getPlanConsumo().getId(), reserva.getUsuario().getNumDocumento());
        return "redirect:/reservas/alojamientos";
    }

    @GetMapping("/cliente/alojamientos/{id}/delete")
    public String reservaBorrar(@PathVariable("id") Integer id) {
        reservaRepository.eliminarReserva((id));
        return "redirect:/cliente/alojamientos";
    }
}
