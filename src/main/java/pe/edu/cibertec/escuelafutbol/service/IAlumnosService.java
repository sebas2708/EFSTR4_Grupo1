package pe.edu.cibertec.escuelafutbol.service;

import pe.edu.cibertec.escuelafutbol.model.bd.Alumnos;
import pe.edu.cibertec.escuelafutbol.model.bd.Equipos;

import java.util.List;

public interface IAlumnosService {
    List<Alumnos> listarAlumnos();
    void registerAlumnos(Alumnos alumnos);

    void deleteAlumnos(Integer id);
}
