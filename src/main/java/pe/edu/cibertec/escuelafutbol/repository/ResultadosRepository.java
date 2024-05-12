package pe.edu.cibertec.escuelafutbol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.escuelafutbol.model.bd.Resultados;

import java.util.Date;

@Repository
public interface ResultadosRepository extends JpaRepository<Resultados, Integer> {
}
