package pe.edu.cibertec.escuelafutbol.model.bd;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "alumno_equipo")
public class Alumno_equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_alumno_equipo;
    @ManyToOne
    @JoinColumn(name = "ID_Alumno")
    private Alumnos alumno;
    @ManyToOne
    @JoinColumn(name = "ID_Equipo")
    private Equipos equipo;
    private LocalDate fecha_registro;
    private Boolean activo;


}
