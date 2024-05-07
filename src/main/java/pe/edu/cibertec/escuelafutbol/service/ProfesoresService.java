package pe.edu.cibertec.escuelafutbol.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.escuelafutbol.model.bd.Profesores;
import pe.edu.cibertec.escuelafutbol.repository.ProfesoresRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class ProfesoresService implements IProfesoresService{

    private ProfesoresRepository profesoresRepository;
    @Override
    public List<Profesores> listarProfesores() {
        return profesoresRepository.findAll();
    }
}
