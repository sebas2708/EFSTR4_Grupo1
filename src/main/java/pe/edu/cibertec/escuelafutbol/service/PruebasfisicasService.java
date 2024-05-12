package pe.edu.cibertec.escuelafutbol.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.escuelafutbol.model.bd.Pruebas_fisicas;
import pe.edu.cibertec.escuelafutbol.repository.PruebasRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class PruebasfisicasService implements  IPruebasfisicasService{

    private PruebasRepository pruebasRepository;

    @Override
    public List<Pruebas_fisicas> listarPruebas() {
        return pruebasRepository.findAll();
    }

    @Override
    public void registerPruebas(Pruebas_fisicas pruebasFisicas) {
        pruebasRepository.save(pruebasFisicas);
    }
}
