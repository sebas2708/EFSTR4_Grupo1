package pe.edu.cibertec.escuelafutbol.service;

import pe.edu.cibertec.escuelafutbol.model.bd.Pruebas_fisicas;

import java.util.List;

public interface IPruebasfisicasService {
    List<Pruebas_fisicas> listarPruebas();
    void registerPruebas(Pruebas_fisicas pruebasFisicas);
}
