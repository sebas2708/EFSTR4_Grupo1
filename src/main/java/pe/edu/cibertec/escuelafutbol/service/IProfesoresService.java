package pe.edu.cibertec.escuelafutbol.service;

import pe.edu.cibertec.escuelafutbol.model.bd.Profesores;

import java.util.List;

public interface IProfesoresService {
    List<Profesores> listarProfesores();
    void registerProfesores(Profesores profesores);
}
