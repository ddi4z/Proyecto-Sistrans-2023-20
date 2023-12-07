package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Usuario;
import uniandes.edu.co.proyecto.repositorios.UsuarioRepository;
import uniandes.edu.co.proyecto.repositorios.TipoUsuarioRepository;

@Controller
public class UsuariosController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;


    @GetMapping("/administrador/usuarios")
    public String usuarios(Model model){
        model.addAttribute("Usuarios", usuarioRepository.darUsuarios());
        return "usuarios";
    }

    @GetMapping("/administrador/usuarios/new")
    public String usuarioForm(Model model) {
        model.addAttribute("Usuario", new Usuario());
        model.addAttribute("Tipos",  tipoUsuarioRepository.darTiposUsuario());
        return "usuarioNuevo";
    }

    @PostMapping("/administrador/usuarios/new/save")
    public String usuarioGuardar(@ModelAttribute Usuario usuario) {
        usuarioRepository.insertarUsuario(usuario.getTipoDocumento(), usuario.getNumDocumento(), usuario.getNombre(), usuario.getCorreo(), usuario.getRol().getId());
        return "redirect:/administrador/usuarios";
    }

    @GetMapping("/administrador/usuarios/{id}/edit")
    public String usuarioEditarForm(@PathVariable("id") String id, Model model) {
        Usuario usuario = usuarioRepository.darUsuario((id));
        if (usuario != null) {
            model.addAttribute("Usuario", usuario);
            model.addAttribute("Tipos", tipoUsuarioRepository.darTiposUsuario());
            return "usuarioEditar";
        } else {
            return "redirect:/administrador/usuarios";
        }
    }

    @PostMapping("/administrador/usuarios/{id}/edit/save")
    public String usuarioEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Usuario usuario) {
        usuarioRepository.actualizarUsuario(usuario.getTipoDocumento(), usuario.getNumDocumento(), usuario.getNombre(), usuario.getCorreo(), usuario.getRol().getId());
        return "redirect:/administrador/usuarios";
    }

    @GetMapping("/administrador/usuarios/{id}/delete")
    public String usuarioBorrar(@PathVariable("id") String id) {
        usuarioRepository.eliminarUsuario((id));
        return "redirect:/administrador/usuarios";
    }
}