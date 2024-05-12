package pe.edu.cibertec.escuelafutbol.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.escuelafutbol.model.bd.Alumnos;

import pe.edu.cibertec.escuelafutbol.repository.AlumnosRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class AlumnosService implements IAlumnosService{

    private AlumnosRepository alumnosRepository;
    @Override
    public List<Alumnos> listarAlumnos() {
        return alumnosRepository.findAll();
    }


    @Override
    public void registerAlumnos(Alumnos alumnos) {
        alumnosRepository.save(alumnos);
    }
}
