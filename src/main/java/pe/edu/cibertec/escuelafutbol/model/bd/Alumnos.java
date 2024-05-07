package pe.edu.cibertec.escuelafutbol.model.bd;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "alumnos")
public class Alumnos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;
    private Date fecha_nacimiento;
    private String direccion;
    private String telefono;
}
