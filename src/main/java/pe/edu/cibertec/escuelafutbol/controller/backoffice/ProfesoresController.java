package pe.edu.cibertec.escuelafutbol.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.escuelafutbol.model.bd.Equipos;
import pe.edu.cibertec.escuelafutbol.model.bd.Profesores;
import pe.edu.cibertec.escuelafutbol.model.dto.request.ProfesoresRequest;
import pe.edu.cibertec.escuelafutbol.model.dto.response.ProfesoresResponse;
import pe.edu.cibertec.escuelafutbol.service.IProfesoresService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/profesores")
public class ProfesoresController {

    private IProfesoresService iProfesoresService;

    @GetMapping("")
    public String frmprofesores(Model model){
        model.addAttribute("listaprofesores",
                iProfesoresService.listarProfesores());
        return "backoffice/profesores/frmprofesores";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Profesores> listarProfesores(){
        return iProfesoresService.listarProfesores();
    }

    @PostMapping("/register")
    @ResponseBody
    public ProfesoresResponse registerProfesor(@RequestBody ProfesoresRequest profesoresRequest){
        String mensaje = "Profesor registrado correctamente";
        boolean respuesta = true;
        try{
            Profesores profesores = new Profesores();
            if (profesoresRequest.getId() > 0){
                profesores.setId(profesoresRequest.getId());
            }
            profesores.setDni(profesoresRequest.getDni());
            profesores.setNombre(profesoresRequest.getNombre());
            profesores.setApellido(profesoresRequest.getApellido());
            profesores.setTelefono(profesoresRequest.getTelefono());
            profesores.setCorreo_electronico(profesoresRequest.getCorreo_electronico());
            profesores.setEspecializacion(profesoresRequest.getEspecializacion());
            iProfesoresService.registerProfesores(profesores);
        }catch (Exception ex){
            mensaje = "Profesor no registrado, error en la BD. ";
            respuesta = false;
        }
        return  ProfesoresResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }

    @GetMapping("/get")
    @ResponseBody
    public List<Profesores> listprofesores(){
        return  iProfesoresService.listarProfesores();
    }
}
