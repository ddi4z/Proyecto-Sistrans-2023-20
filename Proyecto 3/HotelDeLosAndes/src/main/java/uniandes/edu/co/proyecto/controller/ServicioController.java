package uniandes.edu.co.proyecto.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ServicioController {



    
    @GetMapping("/consultas/servicios")
    public String index() {
        return "servicio";
    }

}

