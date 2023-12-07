package uniandes.edu.co.proyecto.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.proyecto.modelo.EstablecimientoComercio;
import uniandes.edu.co.proyecto.modelo.Servicio;
import uniandes.edu.co.proyecto.repositorios.EstablecimientoComercioRepository;
import uniandes.edu.co.proyecto.repositorios.ServicioRepository;

@Controller
public class EstablecimientoComercioController {
    private static final String tipo = "EstablecimientoComercio";

    @Autowired
    private EstablecimientoComercioRepository establecimientoComercioRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/administrador/servicios/establecimientosComercio")
    public String EstablecimientosComercio(Model model) {
        model.addAttribute("EstablecimientosComercio", establecimientoComercioRepository.darEstablecimientosComercio());
        return "establecimientosComercio";
    }
    

    @GetMapping("/administrador/servicios/establecimientosComercio/new")
    public String EstablecimientoComercio(Model model) {
        model.addAttribute("EstablecimientoComercio", new EstablecimientoComercio());
        model.addAttribute("Servicio", new Servicio());
        return "establecimientoComercioNuevo";
    }

    @PostMapping("/administrador/servicios/establecimientosComercio/new/save")
    public String EstablecimientoComercioGuardar(@ModelAttribute EstablecimientoComercio establecimientoComercio, @ModelAttribute Servicio servcio) {
        servicioRepository.insertarServicio(servcio.getNombre(), tipo);
        BigInteger id = servicioRepository.darIdServicios();
        establecimientoComercioRepository.insertarEstablecimientoComercio(id,establecimientoComercio.getTipo());
        return "redirect:/administrador/servicios/establecimientosComercio";
    }

    @GetMapping("/administrador/servicios/establecimientosComercio/{id}/edit")
    public String EstablecimientoComercioEditarForm(@PathVariable("id") Integer id, Model model) {
        EstablecimientoComercio establecimientoComercio = establecimientoComercioRepository.darEstablecimientoComercio(id);
        Servicio servicio = servicioRepository.darServicio(id);
        if (establecimientoComercio != null) {
            model.addAttribute("EstablecimientoComercio", establecimientoComercio);
            model.addAttribute("Servicio", servicio);
            return "establecimientoComercioEditar";
        } else {
            return "redirect:/administrador/servicios/establecimientosComercio";
        }
    }

    @PostMapping("/administrador/servicios/establecimientosComercio/{id}/edit/save")
    public String EstablecimientoComercioEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute EstablecimientoComercio establecimientoComercio, @ModelAttribute Servicio servicio) {
        servicioRepository.actualizarServicio(id, servicio.getNombre(), tipo);
        establecimientoComercioRepository.actualizarEstablecimientoComercio(id, establecimientoComercio.getTipo());
        return "redirect:/administrador/servicios/establecimientosComercio";
    }

    @GetMapping("/administrador/servicios/establecimientosComercio/{id}/delete")
    public String EstablecimientoComercioBorrar(@PathVariable("id") Integer id) {
        establecimientoComercioRepository.eliminarEstablecimientoComercio(id);
        servicioRepository.eliminarServicio(id);
        return "redirect:/administrador/servicios/establecimientosComercio";
    }
}
