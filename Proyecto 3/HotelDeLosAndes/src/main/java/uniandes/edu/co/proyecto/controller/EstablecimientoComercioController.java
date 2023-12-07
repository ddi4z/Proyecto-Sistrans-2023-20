package uniandes.edu.co.proyecto.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import uniandes.edu.co.proyecto.modelo.EstablecimientoComercio;
import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.modelo.Servicio;
import uniandes.edu.co.proyecto.repositorios.EstablecimientoComercioRepository;
import uniandes.edu.co.proyecto.repositorios.ServicioRepository;

@Controller
public class EstablecimientoComercioController {
    private static final String tipo = "Establecimiento de comercio";

    @Autowired
    private EstablecimientoComercioRepository establecimientoComercioRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/consultas/servicios/establecimientosComercio")
    public String EstablecimientosComercio(Model model) {
        model.addAttribute("EstablecimientosComercio", establecimientoComercioRepository.darEstablecimientosComercio());
        return "establecimientosComercio";
    }
    

    @GetMapping("/consultas/servicios/establecimientosComercio/new")
    public String EstablecimientoComercio(Model model) {
        model.addAttribute("EstablecimientoComercio", new EstablecimientoComercio());
        model.addAttribute("Servicio", new Servicio());
        return "establecimientoComercioNuevo";
    }

    @PostMapping("/consultas/servicios/establecimientosComercio/new/save")
    public String BarGuardar(@ModelAttribute EstablecimientoComercio establecimientoComercio) {
        int id = servicioRepository.findTop1ByOrderByIdDesc().iterator().next().getId() + 1;
        establecimientoComercio.setId(id);
        establecimientoComercio.setTipo(tipo);
        establecimientoComercio.setProductos(new ArrayList<Producto>());
        servicioRepository.save(establecimientoComercio);
        return "redirect:/consultas/servicios/establecimientosComercio";
    }

    @GetMapping("/consultas/servicios/establecimientosComercio/{id}/edit")
    public String EstablecimientoComercioEditarForm(@PathVariable("id") Integer id, Model model) {
        EstablecimientoComercio establecimientoComercio = establecimientoComercioRepository.darEstablecimientoComercio(id);

        if (establecimientoComercio != null) {
            model.addAttribute("EstablecimientoComercio", establecimientoComercio);
            return "establecimientoComercioEditar";
        } else {
            return "redirect:/consultas/servicios/establecimientosComercio";
        }
    }

    @PostMapping("/consultas/servicios/establecimientosComercio/{id}/edit/save")
    public String EstablecimientoComercioEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute EstablecimientoComercio establecimientoComercio, @ModelAttribute Servicio servicio) {
        establecimientoComercioRepository.actualizarEstablecimientoComercio(id, establecimientoComercio.getNombre(),establecimientoComercio.getTipoEstablecimiento());
        return "redirect:/consultas/servicios/establecimientosComercio";
    }
 
    @GetMapping("/consultas/servicios/establecimientosComercio/{id}/delete")
    public String EstablecimientoComercioBorrar(@PathVariable("id") Integer id) {
        establecimientoComercioRepository.deleteById(id);
        return "redirect:/consultas/servicios/establecimientosComercio";
    }
}
