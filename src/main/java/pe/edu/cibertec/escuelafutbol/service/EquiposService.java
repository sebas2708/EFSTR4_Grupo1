package pe.edu.cibertec.escuelafutbol.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.escuelafutbol.model.bd.Equipos;
import pe.edu.cibertec.escuelafutbol.repository.EquiposRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class EquiposService implements IEquiposService{

    private EquiposRepository equiposRepository;
    @Override
    public List<Equipos> listarEquipos() {
        return equiposRepository.findAll();
    }

    @Override
    public void registerEquipos(Equipos equipos) {
        equiposRepository.save(equipos);
    }
}
