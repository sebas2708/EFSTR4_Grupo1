package pe.edu.cibertec.escuelafutbol.model.bd;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "profesores")
public class Profesores {
    @Id
    private int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo_electronico;
    private String especializacion;
}
