package pe.edu.cibertec.escuelafutbol.model.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Alumno_PruebaResponse {
    private Boolean respuesta;
    private String mensaje;
}
