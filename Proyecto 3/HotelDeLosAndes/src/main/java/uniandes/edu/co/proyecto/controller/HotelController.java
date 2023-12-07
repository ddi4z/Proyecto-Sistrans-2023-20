package uniandes.edu.co.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HotelController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }
    @RequestMapping("/consultas")
    public String consultas() {
        return "consultas";
    }

    @RequestMapping("/requerimientos")
    public String requerimientos() {
        return "requerimientos";
    }
}


