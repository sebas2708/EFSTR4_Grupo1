package pe.edu.cibertec.escuelafutbol.model.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class ResultadosRequest {
    private  Integer id_alumno;
    private  Integer id_equipo;
    private Date fecha_inicio;
}
