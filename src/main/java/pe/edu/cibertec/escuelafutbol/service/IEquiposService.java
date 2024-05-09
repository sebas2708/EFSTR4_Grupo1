package pe.edu.cibertec.escuelafutbol.service;

import pe.edu.cibertec.escuelafutbol.model.bd.Equipos;

import java.util.List;

public interface IEquiposService {
    List<Equipos> listarEquipos();
    void registerEquipos(Equipos equipos);
}
