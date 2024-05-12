package pe.edu.cibertec.escuelafutbol.model.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Alumno_equipoRequest {
    private Integer id;
    private Integer alumno;
    private Integer equipo;
    private LocalDate fecha_registro;
    private Boolean activo;
}
