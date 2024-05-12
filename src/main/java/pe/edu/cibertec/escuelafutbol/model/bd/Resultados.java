package pe.edu.cibertec.escuelafutbol.model.bd;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "resultados_pruebas")
public class Resultados {
    @Id
    private  Integer id_alumno;
    private  Integer id_equipo;
    private Date fecha_inicio;
}
