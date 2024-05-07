package pe.edu.cibertec.escuelafutbol.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.cibertec.escuelafutbol.service.IProfesoresService;

@AllArgsConstructor
@Controller
@RequestMapping("/profesores")
public class ProfesoresController {

    private IProfesoresService iProfesoresService;

    @GetMapping("list")
    public String listarProfesores(Model model){
        model.addAttribute("profesores",
                iProfesoresService.listarProfesores());
        return "backoffice/profesores/frmprofesores";
    }
}
