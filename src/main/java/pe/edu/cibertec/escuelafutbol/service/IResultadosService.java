package pe.edu.cibertec.escuelafutbol.service;

import pe.edu.cibertec.escuelafutbol.model.bd.Resultados;

import java.util.Date;
import java.util.List;

public interface IResultadosService {
    List<Resultados> listarResultados();
    void registerResultados(Resultados resultados);
}
