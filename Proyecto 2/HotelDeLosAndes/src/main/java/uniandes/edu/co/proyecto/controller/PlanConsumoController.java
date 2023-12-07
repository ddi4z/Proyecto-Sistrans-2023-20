package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.PlanConsumo;
import uniandes.edu.co.proyecto.repositorios.PlanConsumoRepository;

@Controller
public class PlanConsumoController {

    @Autowired
    private PlanConsumoRepository planConsumoRepository;


    @GetMapping("/administrador/planesConsumo")
    public String PlanesConsumo(Model model){
        model.addAttribute("PlanesConsumo", planConsumoRepository.darPlanesConsumo());
        return "planesConsumo";
    }

    @GetMapping("/administrador/planesConsumo/new")
    public String PlanConsumoForm(Model model) {
        model.addAttribute("PlanConsumo", new PlanConsumo());
        return "planConsumoNuevo";
    }

    @PostMapping("/administrador/planesConsumo/new/save")
    public String PlanConsumoGuardar(@ModelAttribute PlanConsumo planConsumo) {
        planConsumoRepository.insertarPlanConsumo("2023-01-01", "2023-12-31", planConsumo.getNombre(), planConsumo.getDescuentoAlojamiento(), planConsumo.getDescuentoBar(), planConsumo.getDescuentoRestaurante(), planConsumo.getDescuentoSpa(), planConsumo.getTipo());
        return "redirect:/administrador/planesConsumo";
    }

    @GetMapping("/administrador/planesConsumo/{id}/edit")
    public String PlanConsumoEditarForm(@PathVariable("id") Integer id, Model model) {
        PlanConsumo planConsumo = planConsumoRepository.darPlanConsumo((id));
        if (planConsumo != null) {
            model.addAttribute("PlanConsumo", planConsumo);
            return "PlanConsumoEditar";
        } else {
            return "redirect:/administrador/planesConsumo";
        }
    }

    @PostMapping("/administrador/planesConsumo/{id}/edit/save")
    public String PlanConsumoEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute PlanConsumo PlanConsumo) {
        planConsumoRepository.actualizarPlanConsumo( (id), PlanConsumo.getFechaInicioVigencia().toString(), PlanConsumo.getFechaFinVigencia().toString(), PlanConsumo.getNombre(), PlanConsumo.getDescuentoAlojamiento(), PlanConsumo.getDescuentoBar(), PlanConsumo.getDescuentoRestaurante(), PlanConsumo.getDescuentoSpa(), PlanConsumo.getTipo());
        return "redirect:/planesConsumo";
    }

    @GetMapping("/administrador/planesConsumo/{id}/delete")
    public String PlanConsumoBorrar(@PathVariable("id") Integer id) {
        planConsumoRepository.eliminarPlanConsumo((id));
        return "redirect:/planesConsumo";
    }
}







