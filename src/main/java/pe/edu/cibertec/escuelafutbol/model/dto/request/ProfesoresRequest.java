package pe.edu.cibertec.escuelafutbol.model.dto.request;

import lombok.Data;

@Data
public class ProfesoresRequest {
    private int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo_electronico;
    private String especializacion;
}
