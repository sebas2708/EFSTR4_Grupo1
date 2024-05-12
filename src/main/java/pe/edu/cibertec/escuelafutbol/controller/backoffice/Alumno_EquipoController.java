package pe.edu.cibertec.escuelafutbol.controller.backoffice;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.escuelafutbol.model.bd.Alumno_equipo;
import pe.edu.cibertec.escuelafutbol.model.bd.Alumnos;
import pe.edu.cibertec.escuelafutbol.model.bd.Equipos;
import pe.edu.cibertec.escuelafutbol.model.bd.Profesores;
import pe.edu.cibertec.escuelafutbol.model.dto.request.Alumno_equipoRequest;
import pe.edu.cibertec.escuelafutbol.model.dto.request.EquiposRequest;
import pe.edu.cibertec.escuelafutbol.model.dto.response.Alumno_equipoResponse;
import pe.edu.cibertec.escuelafutbol.model.dto.response.EquiposResponse;
import pe.edu.cibertec.escuelafutbol.service.IAlumno_EquipoService;
import pe.edu.cibertec.escuelafutbol.service.IEquiposService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/alumno_equipo")
public class Alumno_EquipoController {
    private IAlumno_EquipoService iAlumno_equipoService;

    @GetMapping("")
    public String frmalumno_equipo(Model model){
        model.addAttribute("listaleq",
                iAlumno_equipoService.listarJugadores());
        return "backoffice/alumno_equipo/frmalumno_equipo";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Alumno_equipo> listarJugadores(){
        return iAlumno_equipoService.listarJugadores();
    }

    @PostMapping("/register")
    @ResponseBody
    public Alumno_equipoResponse registerJugadores(@RequestBody Alumno_equipoRequest alumno_equipoRequest){
        String mensaje = "Jugador registrado correctamente";
        boolean respuesta = true;
        try{
            Alumno_equipo aleq = new Alumno_equipo();
            if(alumno_equipoRequest.getId() > 0){
                aleq.setId_alumno_equipo(alumno_equipoRequest.getId());
            }
            Alumnos alumno = new Alumnos();
            alumno.setId(alumno_equipoRequest.getAlumno());
            aleq.setAlumno(alumno);
            Equipos equipo = new Equipos();
            equipo.setId(alumno_equipoRequest.getEquipo());
            aleq.setEquipo(equipo);
            aleq.setFecha_registro(alumno_equipoRequest.getFecha_registro());
            aleq.setActivo(alumno_equipoRequest.getActivo());
            iAlumno_equipoService.registerJugadores(aleq);
        }catch (Exception ex){
            mensaje = ex.getMessage();
            respuesta = false;
        }
        return Alumno_equipoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}
