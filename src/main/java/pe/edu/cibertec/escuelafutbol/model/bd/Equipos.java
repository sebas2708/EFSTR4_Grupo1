package pe.edu.cibertec.escuelafutbol.model.bd;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "equipos")
public class Equipos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre_equipo;
    @ManyToOne
    @JoinColumn(name = "id_entrenador")
    private Profesores entrenador;
}
