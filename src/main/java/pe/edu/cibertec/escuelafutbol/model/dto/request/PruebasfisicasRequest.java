package pe.edu.cibertec.escuelafutbol.model.dto.request;

import lombok.Data;

@Data
public class PruebasfisicasRequest {
    private int id;
    private String tipo_prueba;
    private String descripcion;
}
