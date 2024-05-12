package pe.edu.cibertec.escuelafutbol.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.escuelafutbol.model.bd.Resultados;
import pe.edu.cibertec.escuelafutbol.repository.ResultadosRepository;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class ResultadosService implements  IResultadosService{

    private ResultadosRepository resultadosRepository;

    @Override
    public List<Resultados> listarResultados() {
        return resultadosRepository.findAll();
    }


    @Override
    @Transactional
    public void registerResultados(Resultados resultados) {
        resultadosRepository.save(resultados);
    }
}
