package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.proyecto.modelo.Prestamo;
import uniandes.edu.co.proyecto.repositorios.HabitacionRepository;
import uniandes.edu.co.proyecto.repositorios.PrestamoRepository;

@Controller
public class PrestamosController {
    @Autowired
    private PrestamoRepository prestamoRepository;


    @Autowired
    private HabitacionRepository habitacionRepository;


    @GetMapping("/consultas/prestamos")
    public String Prestamos(Model model) {
        model.addAttribute("Prestamos", prestamoRepository.darPrestamos());
        return "prestamos";
    }

    @GetMapping("/consultas/prestamos/{id}/delete")
    public String PrestamoBorrar(@PathVariable("id") Integer id) {
        prestamoRepository.deleteById(id);
        return "redirect:/consultas/prestamos";
    }

     @GetMapping("/consultas/prestamos/new")
    public String PrestamoForm(Model model) {
        model.addAttribute("prestamo", new Prestamo());
        model.addAttribute("habitaciones", habitacionRepository.darHabitaciones());
        model.addAttribute("utensilios", prestamoRepository.obtenerUtensiliosDistintos());
        return "prestamoNuevo";
    }

    @PostMapping("/consultas/prestamos/new/save")
    public String PrestamoGuardar(@ModelAttribute Prestamo prestamo) {
        int id = prestamoRepository.findTop1ByOrderByIdDesc().iterator().next().getId() + 1;
        prestamo.setId(id);
        if (prestamo.getDevuelto() == null){
            prestamo.setDevuelto(false);
        }
        else{
            prestamo.setDevuelto(true);
        }
        prestamoRepository.save(prestamo);
        return "redirect:/consultas/prestamos";
    }
    @GetMapping("/consultas/prestamos/{id}/edit")
    public String PrestamoEditarForm(@PathVariable("id") Integer id, Model model) {
        Prestamo prestamo = prestamoRepository.darPrestamo(id);
        if (prestamo != null) {
            model.addAttribute("prestamo", prestamo);
            model.addAttribute("habitaciones", habitacionRepository.darHabitaciones());
            model.addAttribute("utensilios", prestamoRepository.obtenerUtensiliosDistintos());
            return "prestamoEditar";
        } else {
            return "redirect:/consultas/prestamos";
        }
    }

    @PostMapping("/consultas/prestamos/{id}/edit/save")
    public String PrestamoEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Prestamo prestamo) {

        if (prestamo.getDevuelto() == null){
            prestamo.setDevuelto(false);
        }
        else{
            prestamo.setDevuelto(true);
        }
        prestamoRepository.actualizarPrestamo(id, prestamo.getUtensilio(), prestamo.getCostoPerdida(), prestamo.getDevuelto(), prestamo.getCliente(), prestamo.getHabitacion() );
        return "redirect:/consultas/prestamos";
    }
}
