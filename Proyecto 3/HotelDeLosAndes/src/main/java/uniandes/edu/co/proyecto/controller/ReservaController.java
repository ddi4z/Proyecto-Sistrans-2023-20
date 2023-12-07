package uniandes.edu.co.proyecto.controller;

import java.util.ArrayList;

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



@Controller
public class ReservaController {
    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;




    @GetMapping("/consultas/alojamientos")
    public String reservas(Model model){
        model.addAttribute("Reservas", reservaRepository.darReservas());
        return "reservas";
    }

    @GetMapping("/consultas/llegadas")
    public String reservasLlegada(Model model){
        model.addAttribute("Reservas", reservaRepository.darReservas());
        return "llegadas";
    }

    @GetMapping("/consultas/salidas")
    public String reservasSalida(Model model){
        model.addAttribute("Reservas", reservaRepository.darReservas());
        return "salidas";
    }
    
    @GetMapping("/consultas/alojamientos/new")
    public String reservaForm(Model model) {
        model.addAttribute("reserva", new Reserva());
        model.addAttribute("usuarios", usuarioRepository.darUsuarios());

        return "reservaNueva";
    }

    @PostMapping("/consultas/alojamientos/new/save")
    public String reservaGuardar(@ModelAttribute Reserva reserva) {
        int id = reservaRepository.findTop1ByOrderByIdDesc().iterator().next().getId() + 1;
        reserva.setId(id);
        reserva.setHabitaciones(new ArrayList<Integer>());

        reservaRepository.save(reserva);
        return "redirect:/consultas/alojamientos";
    }

    @GetMapping("/consultas/alojamientos/{id}/edit")
    public String reservaEditarForm(@PathVariable("id") int id, Model model) {
        Reserva reserva = reservaRepository.darReserva(((int) id));
        if (reserva != null) {
            model.addAttribute("reserva", reserva);
            model.addAttribute("usuarios", usuarioRepository.darUsuarios());
            return "reservaEditar";
        } else {
            return "redirect:/consultas/alojamientos";
        }
    }

    @GetMapping("/consultas/llegadas/{id}/editCheckIn")
    public String reservaEditarCheckInForm(@PathVariable("id") int id, Model model) {
        Reserva reserva = reservaRepository.darReserva(((int) id));
        if (reserva != null) {
            model.addAttribute("reserva", reserva);
            model.addAttribute("usuarios", usuarioRepository.darUsuarios());
            return "reservaEditarCheckIn";
        } else {
            return "redirect:/consultas/llegadas";
        }
    }
    @PostMapping("/consultas/llegadas/{id}/editCheckIn/save")
    public String reservaEditarCheckInGuardar(@PathVariable("id") Integer id, @ModelAttribute Reserva reserva) {
        reservaRepository.actualizarReservaCheckIn(id, reserva.getCheckIn());
        return "redirect:/consultas/llegadas";
    }


    @GetMapping("/consultas/llegadas/{id}/editCheckOut")
    public String reservaEditarCheckOutForm(@PathVariable("id") int id, Model model) {
        Reserva reserva = reservaRepository.darReserva(((int) id));
        if (reserva != null) {
            model.addAttribute("reserva", reserva);
            model.addAttribute("usuarios", usuarioRepository.darUsuarios());
            model.addAttribute("total", reservaRepository.darCostoConsumosNoPagados(id));
            return "reservaEditarCheckOut";
        } else {
            return "redirect:/consultas/llegadas";
        }
    }



    @PostMapping("/consultas/llegadas/{id}/editCheckOut/save")
    public String reservaEditarCheckOutGuardar(@PathVariable("id") Integer id, @ModelAttribute Reserva reserva) {
        reservaRepository.actualizarReservaCheckOut(id, reserva.getCheckOut());
        return "redirect:/consultas/llegadas";
    }



    @PostMapping("/consultas/alojamientos/{id}/edit/save")
    public String reservaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Reserva reserva) {
        reservaRepository.actualizarReserva(id, reserva.getFechaEntrada(), reserva.getFechaSalida(), reserva.getNoches(), reserva.getNumeroPersonas(), reserva.getCliente());
        return "redirect:/consultas/alojamientos";
    }

    @GetMapping("/consultas/alojamientos/{id}/delete")
    public String reservaBorrar(@PathVariable("id") Integer id) {
        reservaRepository.deleteById((id));
        return "redirect:/consultas/alojamientos";
    }

    @GetMapping("/requerimientos/excelentes")
    public String Excelentes(Model model) {
        model.addAttribute("Excelentes", reservaRepository.darExcelentesClientesParte3());
        return "excelentes";
    }
}
