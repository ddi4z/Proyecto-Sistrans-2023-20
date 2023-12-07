package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.proyecto.modelo.Restaurante;
import uniandes.edu.co.proyecto.repositorios.RestauranteRepository;

@Controller
public class RestauranteController {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @GetMapping("/hotel/administrador/servicios/restaurantes")
    public String Restaurantes(Model model) {
        model.addAttribute("Restaurantes", restauranteRepository.darRestaurantes());
        return "restaurantes";
    }

    @GetMapping("/hotel/administrador/servicios/restaurantes/new")
    public String RestauranteForm(Model model) {
        model.addAttribute("Restaurante", new Restaurante());
        return "restauranteNuevo";
    }

    @PostMapping("/hotel/administrador/servicios/restaurantes/new/save")
    public String RestauranteGuardar(@ModelAttribute Restaurante restaurante) {
        restauranteRepository.insertarRestaurante(restaurante.getServicio().getNombre(), restaurante.getCapacidad(), restaurante.getEstilo());
        return "redirect:/hotel/administrador/restaurantes";
    }

    @GetMapping("/hotel/administrador/servicios/restaurantes/{id}/edit")
    public String RestauranteEditarForm(@PathVariable("id") Integer id, Model model) {
        Restaurante restaurante = restauranteRepository.darRestaurante(id);
        if (restaurante != null) {
            model.addAttribute("restaurante", restaurante);
            return "restauranteEditar";
        } else {
            return "redirect:/hotel/administrador/restaurantes";
        }
    }

    @PostMapping("/hotel/administrador/servicios/restaurantes/{id}/edit/save")
    public String RestauranteEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Restaurante restaurante) {
        restauranteRepository.actualizarRestaurante(id, restaurante.getServicio().getNombre(), restaurante.getCapacidad(), restaurante.getEstilo());
        return "redirect:/hotel/administrador/restaurantes";
    }

    @GetMapping("/hotel/administrador/servicios/restaurantes/{id}/delete")
    public String RestauranteBorrar(@PathVariable("id") Integer id) {
        restauranteRepository.eliminarRestaurante(id);
        return "redirect:/hotel/administrador/servicios/restaurantes";
    }
}
