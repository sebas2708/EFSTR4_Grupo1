package pe.edu.cibertec.escuelafutbol.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.cibertec.escuelafutbol.service.IAlumnosService;

@AllArgsConstructor
@Controller
@RequestMapping("/alumnos")
public class AlumnosController {

    private IAlumnosService iAlumnosService;

    @GetMapping("/list")
    public String listarAlumnos(Model model){
        model.addAttribute("alumnos",
                iAlumnosService.listarAlumnos());
        return "backoffice/alumnos/frmalumnos";
    }
}
