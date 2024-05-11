package pe.edu.cibertec.escuelafutbol.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.escuelafutbol.model.bd.Alumnos;
import pe.edu.cibertec.escuelafutbol.model.bd.Equipos;
import pe.edu.cibertec.escuelafutbol.model.bd.Profesores;
import pe.edu.cibertec.escuelafutbol.model.dto.request.AlumnosRequest;
import pe.edu.cibertec.escuelafutbol.model.dto.request.EquiposRequest;
import pe.edu.cibertec.escuelafutbol.model.dto.response.AlumnosResponse;
import pe.edu.cibertec.escuelafutbol.model.dto.response.EquiposResponse;
import pe.edu.cibertec.escuelafutbol.service.IEquiposService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/equipos")
public class EquiposController {

    private IEquiposService iEquiposService;

    @GetMapping("")
    public String frmequipos(Model model){
        model.addAttribute("listequipos",
                iEquiposService.listarEquipos());
        return "backoffice/equipos/frmequipos";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Equipos> listarEquipos(){
        return iEquiposService.listarEquipos();
    }

    @PostMapping("/register")
    @ResponseBody
    public EquiposResponse registerEquipo(@RequestBody EquiposRequest equiposRequest){
        String mensaje = "Equipo registrado correctamente";
        boolean respuesta = true;
        try{
            Equipos equipos = new Equipos();
            if(equiposRequest.getId() > 0){
                equipos.setId(equiposRequest.getId());
            }
            equipos.setNombre_equipo(equiposRequest.getNombre_equipo());
            Profesores profesores = new Profesores();
            profesores.setId(equiposRequest.getEntrenador());
            equipos.setEntrenador(profesores);
            equipos.setNromaximo(equiposRequest.getNromaximo());
            iEquiposService.registerEquipos(equipos);
        }catch (Exception ex){
            mensaje = "Equipo no registrado, error en la BD. ";
            respuesta = false;
        }
        return EquiposResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}
