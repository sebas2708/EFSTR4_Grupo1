package pe.edu.cibertec.escuelafutbol.service;

import pe.edu.cibertec.escuelafutbol.model.bd.Alumno_Prueba;

import java.util.List;

public interface IAlumno_PruebaService {
    List<Alumno_Prueba> listarResultados();
    void registerResultados(Alumno_Prueba alumno_prueba);
}

