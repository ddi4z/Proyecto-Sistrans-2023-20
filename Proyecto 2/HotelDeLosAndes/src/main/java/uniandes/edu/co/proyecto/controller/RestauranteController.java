package uniandes.edu.co.proyecto.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.proyecto.modelo.Restaurante;
import uniandes.edu.co.proyecto.modelo.Servicio;
import uniandes.edu.co.proyecto.repositorios.RestauranteRepository;
import uniandes.edu.co.proyecto.repositorios.ServicioRepository;

@Controller
public class RestauranteController {
    private static final String tipo = "Restaurante";

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/administrador/servicios/restaurantes")
    public String Restaurantes(Model model) {
        model.addAttribute("Restaurantes", restauranteRepository.darRestaurantes());
        return "restaurantes";
    }

    @GetMapping("/administrador/servicios/restaurantes/new")
    public String RestauranteForm(Model model) {
        model.addAttribute("Restaurante", new Restaurante());
        model.addAttribute("Servicio", new Servicio());
        return "restauranteNuevo";
    }

    @PostMapping("/administrador/servicios/restaurantes/new/save")
    public String RestauranteGuardar(@ModelAttribute Restaurante restaurante, @ModelAttribute Servicio servicio) {
        servicioRepository.insertarServicio(servicio.getNombre(), tipo);
        BigInteger id = servicioRepository.darIdServicios();
        restauranteRepository.insertarRestaurante(id, restaurante.getCapacidad(), restaurante.getEstilo());
        return "redirect:/administrador/servicios/restaurantes";
    }

    @GetMapping("/administrador/servicios/restaurantes/{id}/edit")
    public String RestauranteEditarForm(@PathVariable("id") Integer id, Model model) {
        Restaurante restaurante = restauranteRepository.darRestaurante(id);
        Servicio servicio = servicioRepository.darServicio(id);
        if (restaurante != null) {
            model.addAttribute("Restaurante", restaurante);
            model.addAttribute("Servicio", servicio);
            return "restauranteEditar";
        } else {
            return "redirect:/administrador/servicios/restaurantes";
        }
    }

    @PostMapping("/administrador/servicios/restaurantes/{id}/edit/save")
    public String RestauranteEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Restaurante restaurante, @ModelAttribute Servicio servicio) {
        servicioRepository.actualizarServicio(id, servicio.getNombre(), tipo);
        restauranteRepository.actualizarRestaurante(id, restaurante.getCapacidad(), restaurante.getEstilo());
        return "redirect:/administrador/servicios/restaurantes";
    }

    @GetMapping("/administrador/servicios/restaurantes/{id}/delete")
    public String RestauranteBorrar(@PathVariable("id") Integer id) {
        restauranteRepository.eliminarRestaurante(id);
        servicioRepository.eliminarServicio(id);
        return "redirect:/administrador/servicios/restaurantes";
    }
}
