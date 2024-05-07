package pe.edu.cibertec.escuelafutbol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.escuelafutbol.model.bd.Profesores;

@Repository
public interface ProfesoresRepository extends JpaRepository<Profesores, Integer> {
}
