package pe.edu.cibertec.escuelafutbol.model.dto.request;

import lombok.Data;

@Data
public class EquiposRequest {
    private Integer id;
    private String nombre_equipo;
    private Integer entrenador;
    private Integer nromaximo;
}
