package uniandes.edu.co.proyecto.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import uniandes.edu.co.proyecto.modelo.Producto;
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


    @GetMapping("/consultas/servicios/restaurantes")
    public String Restaurantes(Model model) {
        model.addAttribute("Restaurantes", restauranteRepository.darRestaurantes());
        return "restaurantes";
    }

    @GetMapping("/consultas/servicios/restaurantes/new")
    public String RestauranteForm(Model model) {
        model.addAttribute("Restaurante", new Restaurante());
        model.addAttribute("Servicio", new Servicio());
        model.addAttribute("estilos", restauranteRepository.obtenerEstilosDistintos());
        return "restauranteNuevo";
    }

    @PostMapping("/consultas/servicios/restaurantes/new/save")
    public String BarGuardar(@ModelAttribute Restaurante restaurante) {
        int id = servicioRepository.findTop1ByOrderByIdDesc().iterator().next().getId() + 1;
        restaurante.setId(id);
        restaurante.setTipo(tipo);
        restaurante.setProductos(new ArrayList<Producto>());
        servicioRepository.save(restaurante);
        return "redirect:/consultas/servicios/restaurantes";
    }
    @GetMapping("/consultas/servicios/restaurantes/{id}/edit")
    public String RestauranteEditarForm(@PathVariable("id") Integer id, Model model) {
        Restaurante restaurante = restauranteRepository.darRestaurante(id);
        if (restaurante != null) {
            model.addAttribute("Restaurante", restaurante);
            model.addAttribute("estilos", restauranteRepository.obtenerEstilosDistintos());
            return "restauranteEditar";
        } else {
            return "redirect:/consultas/servicios/restaurantes";
        }
    }

    @PostMapping("/consultas/servicios/restaurantes/{id}/edit/save")
    public String RestauranteEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Restaurante restaurante, @ModelAttribute Servicio servicio) {
        restauranteRepository.actualizarRestaurante(id, restaurante.getNombre(),restaurante.getCapacidad(), restaurante.getEstilo());
        return "redirect:/consultas/servicios/restaurantes";
    }

    @GetMapping("/consultas/servicios/restaurantes/{id}/delete")
    public String RestauranteBorrar(@PathVariable("id") Integer id) {
        restauranteRepository.deleteById(id);
        return "redirect:/consultas/servicios/restaurantes";
    }
}
