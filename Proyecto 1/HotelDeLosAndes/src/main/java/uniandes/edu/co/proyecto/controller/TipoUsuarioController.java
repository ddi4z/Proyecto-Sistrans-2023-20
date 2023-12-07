package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.TipoUsuario;
import uniandes.edu.co.proyecto.repositorios.TipoUsuarioRepository;

@Controller
public class TipoUsuarioController {
    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @GetMapping("/hotel/administrador/tiposUsuario")
    public String TiposUsuario(Model model) {
        model.addAttribute("TiposUsuario", tipoUsuarioRepository.darTiposUsuario());
        return "tiposUsuario";
    }

    @GetMapping("/hotel/administrador/tiposUsuario/new")
    public String TipoUsuarioForm(Model model) {
        model.addAttribute("TipoUsuario", new TipoUsuario());
        return "tipoUsuarioNuevo";
    }

    @PostMapping("/hotel/administrador/tiposUsuario/new/save")
    public String TipoUsuarioGuardar(@ModelAttribute TipoUsuario tipoUsuario) {
        tipoUsuarioRepository.insertarTipoUsuario(tipoUsuario.getNombre());
        return "redirect:/hotel/administrador/servicios/tiposUsuario";
    }

    @GetMapping("/hotel/administrador/tiposUsuario/{id}/edit")
    public String TipoUsuarioEditarForm(@PathVariable("id") Integer id, Model model) {
        TipoUsuario tipoUsuario = tipoUsuarioRepository.darTipoUsuario(id);
        if (tipoUsuario != null) {
            model.addAttribute("tipoUsuario", tipoUsuario);
            return "tipoUsuarioEditar";
        } else {
            return "redirect:/hotel/administrador/tiposUsuario";
        }
    }

    @PostMapping("/hotel/administrador/tiposUsuario/{id}/edit/save")
    public String TipoUsuarioEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute TipoUsuario tipoUsuario) {
        tipoUsuarioRepository.actualizarTipoUsuario(id, tipoUsuario.getNombre());
        return "redirect:/hotel/administrador/tiposUsuario";
    }

    @GetMapping("/hotel/administrador/tiposUsuario/{id}/delete")
    public String TipoUsuarioBorrar(@PathVariable("id") Integer id) {
        tipoUsuarioRepository.eliminarTipoUsuario(id);
        return "redirect:/hotel/administrador/tiposUsuario";
    }
}
