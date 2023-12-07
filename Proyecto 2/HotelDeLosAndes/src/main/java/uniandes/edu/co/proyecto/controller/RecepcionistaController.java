package uniandes.edu.co.proyecto.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.repositorios.ServicioRepository;
import uniandes.edu.co.proyecto.repositorios.UsuarioRepository;

@Controller
public class RecepcionistaController {

    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping("/recepcionista")
    public String index() {
        return "recepcionista";
    }

    @GetMapping("/recepcionista/consumosV1")
    public String usuariosConConsumosServicio(Model model) {
        model.addAttribute("Tipos", servicioRepository.darTiposServicio());
        return "consumosV1RecepcionistaForm";
    }

    @PostMapping("/recepcionista/consumosV1")
    public String serviciosCaracteristicasResultados(Model model, @RequestParam(name = "servicio", required = true) String servicio, @RequestParam(name = "fechaInicial", required = true) String fechaIncial, @RequestParam(name = "fechaFinal", required = true) String fechaFinal, @RequestParam(name = "ordenamiento", required = true) String ordenamiento) {
        model.addAttribute("Usuarios", usuarioRepository.consultarConsumosServicio(servicio, fechaIncial, fechaFinal, ordenamiento));
        return "consumosV1Recepcionista";
    }

    @GetMapping("/recepcionista/consumosV2")
    public String usuariosSinConsumosServicio(Model model) {
        model.addAttribute("Tipos", servicioRepository.darTiposServicio());
        return "consumosV2RecepcionistaForm";
    }

    @PostMapping("/recepcionista/consumosV2")
    public String noServiciosCaracteristicasResultados(Model model, @RequestParam(name = "servicio", required = true) String servicio, @RequestParam(name = "fechaInicial", required = true) String fechaIncial, @RequestParam(name = "fechaFinal", required = true) String fechaFinal, @RequestParam(name = "ordenamiento", required = true) String ordenamiento) {
        model.addAttribute("Usuarios", usuarioRepository.consultarConsumosNoServicio(servicio, fechaIncial, fechaFinal, ordenamiento));
        model.addAttribute("servicio", servicio);
        return "consumosV2Recepcionista";
    }
}
