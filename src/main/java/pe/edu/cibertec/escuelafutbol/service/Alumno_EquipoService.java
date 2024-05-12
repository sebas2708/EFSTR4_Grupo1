package pe.edu.cibertec.escuelafutbol.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.escuelafutbol.model.bd.Alumno_equipo;
import pe.edu.cibertec.escuelafutbol.model.bd.Equipos;
import pe.edu.cibertec.escuelafutbol.repository.Alumno_equipoRepository;
import pe.edu.cibertec.escuelafutbol.repository.EquiposRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class Alumno_EquipoService implements IAlumno_EquipoService{
    private Alumno_equipoRepository alumno_equipoRepository;
    private EquiposRepository equiposRepository;

    @Override
    public List<Alumno_equipo> listarJugadores() {
        return alumno_equipoRepository.findAll();
    }

    @Transactional
    @Override
    public void registerJugadores(Alumno_equipo alumno_equipo) {

        //Verificar que equipo no este lleno
        Equipos equipo = equiposRepository.findById(alumno_equipo.getEquipo().getId()).get();
        int maximo = equipo.getNromaximo();
        List<Alumno_equipo> alumnosEquipo = alumno_equipoRepository.obtenerAlumnosEquipo(alumno_equipo.getEquipo().getId());
        if (alumnosEquipo.size() >= maximo){
            throw new RuntimeException("El equipo supera el máximo de alumnos");
        }
        //Desactivar inscripcion anterior
        alumno_equipoRepository.actualizarEquipoEstado(alumno_equipo.getAlumno().getId());
        //Grabar cambios
        alumno_equipoRepository.save(alumno_equipo);
    }
}
