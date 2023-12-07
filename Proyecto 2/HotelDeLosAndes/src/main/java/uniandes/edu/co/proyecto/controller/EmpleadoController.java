package uniandes.edu.co.proyecto.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;


@Controller
public class EmpleadoController {
    @RequestMapping("/empleado")
    public String index() {
        return "empleado";
    }
}
