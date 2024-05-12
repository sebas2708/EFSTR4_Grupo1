package pe.edu.cibertec.escuelafutbol.service;

import pe.edu.cibertec.escuelafutbol.model.bd.Alumno_equipo;

import java.util.List;

public interface IAlumno_EquipoService {
    List<Alumno_equipo> listarJugadores();
    void registerJugadores(Alumno_equipo alumno_equipo);
}
