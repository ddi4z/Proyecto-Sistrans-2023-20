package uniandes.edu.co.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ServicioController {
    @RequestMapping("/administrador/servicios")
    public String index() {
        return "servicio";
    }
}

