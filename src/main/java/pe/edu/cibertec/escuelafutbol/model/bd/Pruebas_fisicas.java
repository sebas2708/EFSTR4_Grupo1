package pe.edu.cibertec.escuelafutbol.model.bd;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pruebas_fisicas")
public class Pruebas_fisicas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tipo_prueba;
    private String descripcion;
}
