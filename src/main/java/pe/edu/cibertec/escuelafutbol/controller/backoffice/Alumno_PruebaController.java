package pe.edu.cibertec.escuelafutbol.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.escuelafutbol.model.bd.*;
import pe.edu.cibertec.escuelafutbol.model.dto.request.Alumno_PruebaRequest;
import pe.edu.cibertec.escuelafutbol.model.dto.request.Alumno_equipoRequest;
import pe.edu.cibertec.escuelafutbol.model.dto.response.Alumno_PruebaResponse;
import pe.edu.cibertec.escuelafutbol.model.dto.response.Alumno_equipoResponse;
import pe.edu.cibertec.escuelafutbol.service.IAlumno_PruebaService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/alumno_prueba")
public class Alumno_PruebaController {
    private IAlumno_PruebaService iAlumnoPruebaService;

    @GetMapping("")
    public String frmalumno_prueba(Model model) {
        model.addAttribute("listalpru",
                iAlumnoPruebaService.listarResultados());
        return "backoffice/alumno_prueba/frmalumno_prueba";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Alumno_Prueba> listarResultados() {
        return iAlumnoPruebaService.listarResultados();
    }

    @PostMapping("/register")
    @ResponseBody
    public Alumno_PruebaResponse registerResultados(@RequestBody Alumno_PruebaRequest alumno_pruebaRequest) {
        String mensaje = "Resultado registrado correctamente";
        boolean respuesta = true;
        try {
            Alumno_Prueba alpru = new Alumno_Prueba();
            if (alumno_pruebaRequest.getId() > 0) {
                alpru.setId_alumno_prueba(alumno_pruebaRequest.getId());
            }
            if (alumno_pruebaRequest.fecha_prueba == null){
                alumno_pruebaRequest.fecha_prueba = LocalDate.now();
            }
            Alumnos alumno = new Alumnos();
            alumno.setId(alumno_pruebaRequest.getAlumno());
            alpru.setAlumno(alumno);
            Pruebas_fisicas pruebas = new Pruebas_fisicas();
            pruebas.setId(alumno_pruebaRequest.getPrueba());
            alpru.setPrueba(pruebas);
            alpru.setResultados(alumno_pruebaRequest.getResultados());
            alpru.setFecha_prueba(alumno_pruebaRequest.getFecha_prueba());
            iAlumnoPruebaService.registerResultados(alpru);
        } catch (Exception ex) {
            mensaje = ex.getMessage();
            respuesta = false;
        }
        return Alumno_PruebaResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}