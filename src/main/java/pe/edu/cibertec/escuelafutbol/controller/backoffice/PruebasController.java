package pe.edu.cibertec.escuelafutbol.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.escuelafutbol.model.bd.Profesores;
import pe.edu.cibertec.escuelafutbol.model.bd.Pruebas_fisicas;
import pe.edu.cibertec.escuelafutbol.model.dto.request.ProfesoresRequest;
import pe.edu.cibertec.escuelafutbol.model.dto.request.PruebasfisicasRequest;
import pe.edu.cibertec.escuelafutbol.model.dto.response.ProfesoresResponse;
import pe.edu.cibertec.escuelafutbol.model.dto.response.PruebasfisicasResponse;
import pe.edu.cibertec.escuelafutbol.service.IPruebasfisicasService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/pruebas")
public class PruebasController {

    private IPruebasfisicasService iPruebasfisicasService;

    @GetMapping("")
    public String frmpruebas(Model model){
        model.addAttribute("listapruebas",
                iPruebasfisicasService.listarPruebas());
        return "backoffice/pruebas/frmprruebas";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Pruebas_fisicas> listarPruebas(){
        return iPruebasfisicasService.listarPruebas();
    }

    @PostMapping("/register")
    @ResponseBody
    public PruebasfisicasResponse registerPrueba(@RequestBody PruebasfisicasRequest pruebasfisicasRequest){
        String mensaje = "Prueba registrada correctamente";
        boolean respuesta = true;
        try{
            Pruebas_fisicas pruebasFisicas = new Pruebas_fisicas();
            if (pruebasfisicasRequest.getId()> 0){
                pruebasFisicas.setId(pruebasFisicas.getId());
            }
            pruebasFisicas.setTipo_prueba(pruebasfisicasRequest.getTipo_prueba());
            pruebasFisicas.setDescripcion(pruebasfisicasRequest.getDescripcion());
            iPruebasfisicasService.registerPruebas(pruebasFisicas);
        }catch (Exception ex){
            mensaje = "Prueba no registrada, error en la BD. ";
            respuesta = false;
        }
        return  PruebasfisicasResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }

    @GetMapping("/get")
    @ResponseBody
    public List<Pruebas_fisicas> listpruebas(){
        return  iPruebasfisicasService.listarPruebas();
    }
}
