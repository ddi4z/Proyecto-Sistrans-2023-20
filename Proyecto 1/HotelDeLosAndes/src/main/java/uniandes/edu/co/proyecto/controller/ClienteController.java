package uniandes.edu.co.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClienteController {
    @RequestMapping("/hotel/cliente")
    public String index() {
        return "cliente";
    }
}


